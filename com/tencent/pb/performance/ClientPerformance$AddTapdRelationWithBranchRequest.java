package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$AddTapdRelationWithBranchRequest extends MessageMicro<ClientPerformance$AddTapdRelationWithBranchRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"app", "branch", "feature_id"}, new Object[]{0, "", ""}, ClientPerformance$AddTapdRelationWithBranchRequest.class);
    public final PBEnumField app = PBField.initEnum(0);
    public final PBStringField branch = PBField.initString("");
    public final PBRepeatField<String> feature_id = PBField.initRepeat(PBStringField.__repeatHelper__);
}
