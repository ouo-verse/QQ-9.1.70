package com.tencent.mobileqq.perf.replay.report;

import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class ClientPerformanceMetricV2$SsoPerformanceTestReportRequest extends MessageMicro<ClientPerformanceMetricV2$SsoPerformanceTestReportRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{j.T0, "perf_data_list"}, new Object[]{null, null}, ClientPerformanceMetricV2$SsoPerformanceTestReportRequest.class);
    public ClientPerformanceMetricV2$AppInfo app_info = new MessageMicro<ClientPerformanceMetricV2$AppInfo>() { // from class: com.tencent.mobileqq.perf.replay.report.ClientPerformanceMetricV2$AppInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"parent_commit_id", "commit_id", "branch_name", "app_version_num", "build_num", "test_type"}, new Object[]{"", "", "", "", 0L, 1}, ClientPerformanceMetricV2$AppInfo.class);
        public final PBStringField parent_commit_id = PBField.initString("");
        public final PBStringField commit_id = PBField.initString("");
        public final PBStringField branch_name = PBField.initString("");
        public final PBStringField app_version_num = PBField.initString("");
        public final PBInt64Field build_num = PBField.initInt64(0);
        public final PBEnumField test_type = PBField.initEnum(1);
    };
    public final PBRepeatMessageField<ClientPerformanceMetricV2$PerfDataV2> perf_data_list = PBField.initRepeatMessage(ClientPerformanceMetricV2$PerfDataV2.class);
}
