package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class ClientPerformance$MonitorPerformanceListReport extends MessageMicro<ClientPerformance$MonitorPerformanceListReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"core_indicator", "memory_leak", "block_monitor", "large_image_monitor", "strict_mode_monitor"}, new Object[]{null, null, null, null, null}, ClientPerformance$MonitorPerformanceListReport.class);
    public final PBRepeatMessageField<ClientPerformance$CoreIndicatorMonitor> core_indicator = PBField.initRepeatMessage(ClientPerformance$CoreIndicatorMonitor.class);
    public final PBRepeatMessageField<ClientPerformance$MemoryLeakMonitor> memory_leak = PBField.initRepeatMessage(ClientPerformance$MemoryLeakMonitor.class);
    public final PBRepeatMessageField<ClientPerformance$BlockMonitor> block_monitor = PBField.initRepeatMessage(ClientPerformance$BlockMonitor.class);
    public final PBRepeatMessageField<ClientPerformance$LargeImageMonitor> large_image_monitor = PBField.initRepeatMessage(ClientPerformance$LargeImageMonitor.class);
    public final PBRepeatMessageField<ClientPerformance$StrictModeMonitor> strict_mode_monitor = PBField.initRepeatMessage(ClientPerformance$StrictModeMonitor.class);
}
