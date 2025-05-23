package com.tencent.pb.performance;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ClientPerformance$MonitorPerformanceReport extends MessageMicro<ClientPerformance$MonitorPerformanceReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56}, new String[]{"core_indicator", "memory_leak", "block_monitor", "large_image_monitor", "strict_mode_monitor", "main_thread_monitor", "count"}, new Object[]{null, null, null, null, null, null, 0}, ClientPerformance$MonitorPerformanceReport.class);
    public ClientPerformance$CoreIndicatorMonitor core_indicator = new MessageMicro<ClientPerformance$CoreIndicatorMonitor>() { // from class: com.tencent.pb.performance.ClientPerformance$CoreIndicatorMonitor
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42}, new String[]{"type", "threshold", "stage", "trouble_value", "info"}, new Object[]{"", 0, "", 0, null}, ClientPerformance$CoreIndicatorMonitor.class);
        public final PBStringField type = PBField.initString("");
        public final PBInt32Field threshold = PBField.initInt32(0);
        public final PBStringField stage = PBField.initString("");
        public final PBInt32Field trouble_value = PBField.initInt32(0);
        public ClientPerformance$MonitorInfo info = new ClientPerformance$MonitorInfo();
    };
    public ClientPerformance$MemoryLeakMonitor memory_leak = new ClientPerformance$MemoryLeakMonitor();
    public ClientPerformance$BlockMonitor block_monitor = new MessageMicro<ClientPerformance$BlockMonitor>() { // from class: com.tencent.pb.performance.ClientPerformance$BlockMonitor
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"type", CrashHianalyticsData.STACK_TRACE, "cost_time", "info"}, new Object[]{"", "", 0, null}, ClientPerformance$BlockMonitor.class);
        public final PBStringField type = PBField.initString("");
        public final PBStringField stack_trace = PBField.initString("");
        public final PBInt32Field cost_time = PBField.initInt32(0);
        public ClientPerformance$MonitorInfo info = new ClientPerformance$MonitorInfo();
    };
    public ClientPerformance$LargeImageMonitor large_image_monitor = new ClientPerformance$LargeImageMonitor();
    public ClientPerformance$StrictModeMonitor strict_mode_monitor = new ClientPerformance$StrictModeMonitor();
    public ClientPerformance$MainThreadMethodMonitor main_thread_monitor = new ClientPerformance$MainThreadMethodMonitor();
    public final PBUInt32Field count = PBField.initUInt32(0);
}
