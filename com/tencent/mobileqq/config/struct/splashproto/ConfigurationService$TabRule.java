package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$TabRule extends MessageMicro<ConfigurationService$TabRule> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{QAdVrReportParams.ParamKey.EXPERIMENT_ID, "group_id"}, new Object[]{"", ""}, ConfigurationService$TabRule.class);
    public final PBStringField experiment_id = PBField.initString("");
    public final PBStringField group_id = PBField.initString("");
}
