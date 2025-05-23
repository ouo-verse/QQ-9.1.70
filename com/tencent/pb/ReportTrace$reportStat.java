package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleWeakNetReporter;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ReportTrace$reportStat extends MessageMicro<ReportTrace$reportStat> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"ret", QCircleWeakNetReporter.KEY_COST, "memory", "cpu", "net_type", "display", "java_heap", "native_heap"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0}, ReportTrace$reportStat.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBInt32Field cost = PBField.initInt32(0);
    public final PBInt32Field memory = PBField.initInt32(0);
    public final PBInt32Field cpu = PBField.initInt32(0);
    public final PBUInt32Field net_type = PBField.initUInt32(0);
    public final PBUInt32Field display = PBField.initUInt32(0);
    public final PBInt32Field java_heap = PBField.initInt32(0);
    public final PBInt32Field native_heap = PBField.initInt32(0);
}
