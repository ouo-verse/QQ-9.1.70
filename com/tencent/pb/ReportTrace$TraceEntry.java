package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ReportTrace$TraceEntry extends MessageMicro<ReportTrace$TraceEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58, 64, 72, 80, 88}, new String[]{"feature_id", "trace_id", "from_uid", "to_uid", "time_stamp", "span_list", "result", "extra1", "extra2", "extra3", "server_timestamp"}, new Object[]{0, 0L, "", "", 0L, null, null, 0, 0, 0, 0L}, ReportTrace$TraceEntry.class);
    public final PBUInt32Field feature_id = PBField.initUInt32(0);
    public final PBUInt64Field trace_id = PBField.initUInt64(0);
    public final PBStringField from_uid = PBField.initString("");
    public final PBStringField to_uid = PBField.initString("");
    public final PBUInt64Field time_stamp = PBField.initUInt64(0);
    public final PBRepeatMessageField<ReportTrace$SpanEntry> span_list = PBField.initRepeatMessage(ReportTrace$SpanEntry.class);
    public ReportTrace$reportStat result = new ReportTrace$reportStat();
    public final PBUInt32Field extra1 = PBField.initUInt32(0);
    public final PBUInt32Field extra2 = PBField.initUInt32(0);
    public final PBUInt32Field extra3 = PBField.initUInt32(0);
    public final PBUInt64Field server_timestamp = PBField.initUInt64(0);
}
