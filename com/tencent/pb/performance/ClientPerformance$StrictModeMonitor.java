package com.tencent.pb.performance;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$StrictModeMonitor extends MessageMicro<ClientPerformance$StrictModeMonitor> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"type", "msg", CrashHianalyticsData.STACK_TRACE, "cause_stack_trace", "info"}, new Object[]{"", "", "", "", null}, ClientPerformance$StrictModeMonitor.class);
    public final PBStringField type = PBField.initString("");

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342166msg = PBField.initString("");
    public final PBStringField stack_trace = PBField.initString("");
    public final PBStringField cause_stack_trace = PBField.initString("");
    public ClientPerformance$MonitorInfo info = new ClientPerformance$MonitorInfo();
}
