package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes22.dex */
public final class ClientPerformance$ModifyAdminReportRequest extends MessageMicro<ClientPerformance$ModifyAdminReportRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"app", "report_id", QCircleAlphaUserReporter.KEY_USER, "data", "branch_url", "report_name"}, new Object[]{0, "", "", null, "", ""}, ClientPerformance$ModifyAdminReportRequest.class);
    public final PBEnumField app = PBField.initEnum(0);
    public final PBStringField report_id = PBField.initString("");
    public final PBStringField user = PBField.initString("");
    public final PBRepeatMessageField<ClientPerformance$PerformanceReport> data = PBField.initRepeatMessage(ClientPerformance$PerformanceReport.class);
    public final PBStringField branch_url = PBField.initString("");
    public final PBStringField report_name = PBField.initString("");
}
