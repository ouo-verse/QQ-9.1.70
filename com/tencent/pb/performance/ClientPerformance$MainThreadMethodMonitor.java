package com.tencent.pb.performance;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$MainThreadMethodMonitor extends MessageMicro<ClientPerformance$MainThreadMethodMonitor> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"type", "cost_time", CrashHianalyticsData.STACK_TRACE, "info"}, new Object[]{"", 0, "", null}, ClientPerformance$MainThreadMethodMonitor.class);
    public final PBStringField type = PBField.initString("");
    public final PBInt32Field cost_time = PBField.initInt32(0);
    public final PBStringField stack_trace = PBField.initString("");
    public ClientPerformance$MonitorInfo info = new ClientPerformance$MonitorInfo();
}
