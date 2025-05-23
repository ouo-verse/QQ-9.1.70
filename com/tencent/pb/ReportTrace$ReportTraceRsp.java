package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ReportTrace$ReportTraceRsp extends MessageMicro<ReportTrace$ReportTraceRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"report_interval", "report_num", "report_fail"}, new Object[]{0, 0, 0}, ReportTrace$ReportTraceRsp.class);
    public final PBUInt32Field report_interval = PBField.initUInt32(0);
    public final PBUInt32Field report_num = PBField.initUInt32(0);
    public final PBUInt32Field report_fail = PBField.initUInt32(0);
}
