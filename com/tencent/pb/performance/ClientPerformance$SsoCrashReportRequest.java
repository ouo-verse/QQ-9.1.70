package com.tencent.pb.performance;

import com.tencent.mobileqq.minigame.report.MiniGameCrashReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ClientPerformance$SsoCrashReportRequest extends MessageMicro<ClientPerformance$SsoCrashReportRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField branch_name = PBField.initString("");
    public final PBStringField crash_type = PBField.initString("");
    public final PBBoolField is_native_crashed = PBField.initBool(false);
    public final PBStringField crash_address = PBField.initString("");
    public final PBStringField crash_stack = PBField.initString("");
    public final PBUInt32Field native_si_code = PBField.initUInt32(0);
    public final PBInt64Field crash_time = PBField.initInt64(0);
    public final PBStringField process_name = PBField.initString("");
    public final PBBoolField is_release = PBField.initBool(false);
    public ClientPerformance$MonitorInfo info = new ClientPerformance$MonitorInfo();

    static {
        String[] strArr = {"branch_name", "crash_type", "is_native_crashed", MiniGameCrashReporter.BeaconKey.CRASH_ADDRESS, "crash_stack", "native_si_code", "crash_time", "process_name", "is_release", "info"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 56, 66, 72, 82}, strArr, new Object[]{"", "", bool, "", "", 0, 0L, "", bool, null}, ClientPerformance$SsoCrashReportRequest.class);
    }
}
