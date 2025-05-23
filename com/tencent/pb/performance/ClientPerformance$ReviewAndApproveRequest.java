package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$ReviewAndApproveRequest extends MessageMicro<ClientPerformance$ReviewAndApproveRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"app", "audit_user", "result", "branch"}, new Object[]{0, "", 0, ""}, ClientPerformance$ReviewAndApproveRequest.class);
    public final PBEnumField app = PBField.initEnum(0);
    public final PBStringField audit_user = PBField.initString("");
    public final PBEnumField result = PBField.initEnum(0);
    public final PBStringField branch = PBField.initString("");
}
