package com.tencent.pb;

import com.tencent.bugly.common.trace.TraceSpan;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ReportTrace$SpanAnnoEntry extends MessageMicro<ReportTrace$SpanAnnoEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{TraceSpan.KEY_SPAN_ID, "time_stamp", "anno_msg", "errCode"}, new Object[]{0, 0L, "", 0}, ReportTrace$SpanAnnoEntry.class);
    public final PBUInt32Field span_id = PBField.initUInt32(0);
    public final PBUInt64Field time_stamp = PBField.initUInt64(0);
    public final PBStringField anno_msg = PBField.initString("");
    public final PBInt32Field errCode = PBField.initInt32(0);
}
