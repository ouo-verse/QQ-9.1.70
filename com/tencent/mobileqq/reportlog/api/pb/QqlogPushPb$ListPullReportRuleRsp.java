package com.tencent.mobileqq.reportlog.api.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes18.dex */
public final class QqlogPushPb$ListPullReportRuleRsp extends MessageMicro<QqlogPushPb$ListPullReportRuleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"total", "rules"}, new Object[]{0, null}, QqlogPushPb$ListPullReportRuleRsp.class);
    public final PBInt32Field total = PBField.initInt32(0);
    public final PBRepeatMessageField<QqlogPushPb$PullReportRule> rules = PBField.initRepeatMessage(QqlogPushPb$PullReportRule.class);
}
