package com.tencent.pb;

import com.tencent.bugly.common.trace.TraceSpan;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ReportTrace$SpanEntry extends MessageMicro<ReportTrace$SpanEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{TraceSpan.KEY_SPAN_ID, "time_stamp", "result", "param_list"}, new Object[]{0, 0L, null, null}, ReportTrace$SpanEntry.class);
    public final PBUInt32Field span_id = PBField.initUInt32(0);
    public final PBUInt64Field time_stamp = PBField.initUInt64(0);
    public ReportTrace$reportStat result = new ReportTrace$reportStat();
    public final PBRepeatMessageField<ReportTrace$ExtParam> param_list = PBField.initRepeatMessage(ReportTrace$ExtParam.class);
}
