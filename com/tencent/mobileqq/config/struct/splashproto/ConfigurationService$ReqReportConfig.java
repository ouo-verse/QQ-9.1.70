package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$ReqReportConfig extends MessageMicro<ConfigurationService$ReqReportConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"config_list"}, new Object[]{null}, ConfigurationService$ReqReportConfig.class);
    public final PBRepeatMessageField<ConfigurationService$ReportConfig> config_list = PBField.initRepeatMessage(ConfigurationService$ReportConfig.class);
}
