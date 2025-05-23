package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$BranchReportData extends MessageMicro<ClientPerformance$BranchReportData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"report_id", "report_name", "branch_name"}, new Object[]{0, "", ""}, ClientPerformance$BranchReportData.class);
    public final PBInt32Field report_id = PBField.initInt32(0);
    public final PBStringField report_name = PBField.initString("");
    public final PBStringField branch_name = PBField.initString("");
}
