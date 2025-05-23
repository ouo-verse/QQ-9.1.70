package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$MonitorReviewAndApproveRequest extends MessageMicro<ClientPerformance$MonitorReviewAndApproveRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"app", "result", "branch", "review_type"}, new Object[]{0, 0, "", 0}, ClientPerformance$MonitorReviewAndApproveRequest.class);
    public final PBEnumField app = PBField.initEnum(0);
    public final PBEnumField result = PBField.initEnum(0);
    public final PBStringField branch = PBField.initString("");
    public final PBEnumField review_type = PBField.initEnum(0);
}
