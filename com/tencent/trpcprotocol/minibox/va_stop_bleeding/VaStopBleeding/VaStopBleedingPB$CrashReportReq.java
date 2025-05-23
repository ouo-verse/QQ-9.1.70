package com.tencent.trpcprotocol.minibox.va_stop_bleeding.VaStopBleeding;

import com.tencent.mobileqq.minigame.report.MiniGameCrashReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class VaStopBleedingPB$CrashReportReq extends MessageMicro<VaStopBleedingPB$CrashReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66, 74, 80}, new String[]{"crash_time", "process_name", "is_native_crashed", "crash_type", MiniGameCrashReporter.BeaconKey.CRASH_ADDRESS, "crash_stack", "minibox_version", "appid", "game_version", "start_time"}, new Object[]{0L, "", Boolean.FALSE, "", "", "", "", "", "", 0L}, VaStopBleedingPB$CrashReportReq.class);
    public final PBInt64Field crash_time = PBField.initInt64(0);
    public final PBStringField process_name = PBField.initString("");
    public final PBBoolField is_native_crashed = PBField.initBool(false);
    public final PBStringField crash_type = PBField.initString("");
    public final PBStringField crash_address = PBField.initString("");
    public final PBStringField crash_stack = PBField.initString("");
    public final PBStringField minibox_version = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField game_version = PBField.initString("");
    public final PBInt64Field start_time = PBField.initInt64(0);
}
