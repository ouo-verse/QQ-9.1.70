package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_report$ReportReq extends MessageMicro<ilive_report$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"report_msg"}, new Object[]{null}, ilive_report$ReportReq.class);
    public final PBRepeatMessageField<ilive_report$ReportMsg> report_msg = PBField.initRepeatMessage(ilive_report$ReportMsg.class);
}
