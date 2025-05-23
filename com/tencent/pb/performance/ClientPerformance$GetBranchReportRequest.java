package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$GetBranchReportRequest extends MessageMicro<ClientPerformance$GetBranchReportRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"app", "branch"}, new Object[]{0, ""}, ClientPerformance$GetBranchReportRequest.class);
    public final PBEnumField app = PBField.initEnum(0);
    public final PBStringField branch = PBField.initString("");
}
