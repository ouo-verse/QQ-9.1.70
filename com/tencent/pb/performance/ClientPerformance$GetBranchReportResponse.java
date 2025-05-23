package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$GetBranchReportResponse extends MessageMicro<ClientPerformance$GetBranchReportResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 56}, new String[]{"code", "msg", "reports", "result", "branch_url", "name", "branch_id"}, new Object[]{0, "", null, 0, "", "", 0}, ClientPerformance$GetBranchReportResponse.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342151msg = PBField.initString("");
    public final PBRepeatMessageField<ClientPerformance$PerformanceReport> reports = PBField.initRepeatMessage(ClientPerformance$PerformanceReport.class);
    public final PBEnumField result = PBField.initEnum(0);
    public final PBStringField branch_url = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field branch_id = PBField.initInt32(0);
}
