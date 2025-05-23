package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ReportData$ReqBody extends MessageMicro<ReportData$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"reportId", "type", "params"}, new Object[]{"", 0, null}, ReportData$ReqBody.class);
    public final PBRepeatField<String> reportId = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatMessageField<ReportData$ReqMqqParam> params = PBField.initRepeatMessage(ReportData$ReqMqqParam.class);
}
