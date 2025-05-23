package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ReportData$RspBody extends MessageMicro<ReportData$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", "msg", "reportArray"}, new Object[]{0L, ByteStringMicro.EMPTY, null}, ReportData$RspBody.class);
    public final PBInt64Field ret = PBField.initInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f291342msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<ReportData$ReportDataItem> reportArray = PBField.initRepeatMessage(ReportData$ReportDataItem.class);
}
