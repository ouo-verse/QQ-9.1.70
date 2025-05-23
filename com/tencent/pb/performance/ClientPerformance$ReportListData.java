package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$ReportListData extends MessageMicro<ClientPerformance$ReportListData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64}, new String[]{"branch_url", "report_name", "iteration", "creator", "editor", "result", "create_timestamp", "branch_id"}, new Object[]{"", "", "", "", "", 0, 0, 0}, ClientPerformance$ReportListData.class);
    public final PBStringField branch_url = PBField.initString("");
    public final PBStringField report_name = PBField.initString("");
    public final PBStringField iteration = PBField.initString("");
    public final PBStringField creator = PBField.initString("");
    public final PBStringField editor = PBField.initString("");
    public final PBEnumField result = PBField.initEnum(0);
    public final PBInt32Field create_timestamp = PBField.initInt32(0);
    public final PBInt32Field branch_id = PBField.initInt32(0);
}
