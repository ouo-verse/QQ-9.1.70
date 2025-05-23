package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$GetMonitorPerformanceDetailReportResponse extends MessageMicro<ClientPerformance$GetMonitorPerformanceDetailReportResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"code", "msg", "branch_name", "data"}, new Object[]{0, "", "", null}, ClientPerformance$GetMonitorPerformanceDetailReportResponse.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342153msg = PBField.initString("");
    public final PBStringField branch_name = PBField.initString("");
    public ClientPerformance$MonitorPerformanceListReport data = new ClientPerformance$MonitorPerformanceListReport();
}
