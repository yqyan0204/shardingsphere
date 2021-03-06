/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.proxy.backend.communication.jdbc.execute.generator;

import org.apache.shardingsphere.proxy.config.yaml.YamlDataSourceParameter;
import org.apache.shardingsphere.sql.parser.binder.statement.ddl.CreateDataSourcesStatementContext;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Yaml dataSource configuration generator.
 */
public class YamlDataSourceConfigurationGenerator implements YamlConfigurationGenerator<CreateDataSourcesStatementContext, Collection<YamlDataSourceParameter>> {
    
    @Override
    public Collection<YamlDataSourceParameter> generate(final CreateDataSourcesStatementContext sqlStatement) {
        Collection<YamlDataSourceParameter> result = new LinkedList<>();
        for (CreateDataSourcesStatementContext.DataSourceContext each : sqlStatement.getDataSourceContexts()) {
            YamlDataSourceParameter dataSource = new YamlDataSourceParameter();
            dataSource.setUrl(each.getUrl());
            dataSource.setUsername(each.getUserName());
            dataSource.setPassword(each.getPassword());
            result.add(dataSource);
        }
        return result;
    }
}
