package com.tencent.pb.performance;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ClientPerformance$HighPowerConsumption extends MessageMicro<ClientPerformance$HighPowerConsumption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"netWorkPower"}, new Object[]{null}, ClientPerformance$HighPowerConsumption.class);
    public ClientPerformance$NetworkHighPowerConsumption netWorkPower = new MessageMicro<ClientPerformance$NetworkHighPowerConsumption>() { // from class: com.tencent.pb.performance.ClientPerformance$NetworkHighPowerConsumption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 64, 72, 80, 90, 98, 106, 114}, new String[]{"process_name", CrashHianalyticsData.THREAD_NAME, CrashHianalyticsData.STACK_TRACE, "main_stack_trace", "rx_usage", "rx_times", "tx_usage", "tx_times", "bg_duration", "monitor_time", "type", "url", "path", "info"}, new Object[]{"", "", "", "", 0L, 0, 0L, 0, 0L, 0L, "", "", "", null}, ClientPerformance$NetworkHighPowerConsumption.class);
        public final PBStringField process_name = PBField.initString("");
        public final PBStringField thread_name = PBField.initString("");
        public final PBStringField stack_trace = PBField.initString("");
        public final PBStringField main_stack_trace = PBField.initString("");
        public final PBInt64Field rx_usage = PBField.initInt64(0);
        public final PBUInt32Field rx_times = PBField.initUInt32(0);
        public final PBInt64Field tx_usage = PBField.initInt64(0);
        public final PBUInt32Field tx_times = PBField.initUInt32(0);
        public final PBInt64Field bg_duration = PBField.initInt64(0);
        public final PBInt64Field monitor_time = PBField.initInt64(0);
        public final PBStringField type = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBStringField path = PBField.initString("");
        public ClientPerformance$MonitorInfo info = new ClientPerformance$MonitorInfo();
    };
}
