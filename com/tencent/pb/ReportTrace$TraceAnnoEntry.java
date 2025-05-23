package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ReportTrace$TraceAnnoEntry extends MessageMicro<ReportTrace$TraceAnnoEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48}, new String[]{"uid", "trace_id", "span_anno_list", "ret", "server_timestamp", "feature_id"}, new Object[]{"", 0L, null, 0, 0L, 0}, ReportTrace$TraceAnnoEntry.class);
    public final PBStringField uid = PBField.initString("");
    public final PBUInt64Field trace_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<ReportTrace$SpanAnnoEntry> span_anno_list = PBField.initRepeatMessage(ReportTrace$SpanAnnoEntry.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBUInt64Field server_timestamp = PBField.initUInt64(0);
    public final PBUInt32Field feature_id = PBField.initUInt32(0);
}
