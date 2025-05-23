package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ReportTrace$ReportTraceReq extends MessageMicro<ReportTrace$ReportTraceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"head", "trace_list"}, new Object[]{null, null}, ReportTrace$ReportTraceReq.class);
    public ReportTrace$ReportHead head = new ReportTrace$ReportHead();
    public final PBRepeatMessageField<ReportTrace$TraceEntry> trace_list = PBField.initRepeatMessage(ReportTrace$TraceEntry.class);
}
