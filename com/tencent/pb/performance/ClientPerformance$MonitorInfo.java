package com.tencent.pb.performance;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ClientPerformance$MonitorInfo extends MessageMicro<ClientPerformance$MonitorInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56, 66}, new String[]{"status", ReportDataBuilder.KEY_BUILD_NUMBER, "event_time", "uin", "app_version", "id", "monitor_type", "log_url"}, new Object[]{0, 0L, 0L, "", "", 0, 0, ""}, ClientPerformance$MonitorInfo.class);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBInt64Field build_number = PBField.initInt64(0);
    public final PBInt64Field event_time = PBField.initInt64(0);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField app_version = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f342156id = PBField.initUInt32(0);
    public final PBUInt32Field monitor_type = PBField.initUInt32(0);
    public final PBStringField log_url = PBField.initString("");
}
