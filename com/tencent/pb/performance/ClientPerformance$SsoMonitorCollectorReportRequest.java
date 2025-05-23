package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$SsoMonitorCollectorReportRequest extends MessageMicro<ClientPerformance$SsoMonitorCollectorReportRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"app", "branch_name", "data"}, new Object[]{0, "", null}, ClientPerformance$SsoMonitorCollectorReportRequest.class);
    public final PBEnumField app = PBField.initEnum(0);
    public final PBStringField branch_name = PBField.initString("");
    public ClientPerformance$MonitorPerformanceReport data = new ClientPerformance$MonitorPerformanceReport();
}
