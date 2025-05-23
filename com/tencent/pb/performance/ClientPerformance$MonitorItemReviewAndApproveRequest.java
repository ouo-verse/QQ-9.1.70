package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ClientPerformance$MonitorItemReviewAndApproveRequest extends MessageMicro<ClientPerformance$MonitorItemReviewAndApproveRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"id", "result", "monitor_type", "branch"}, new Object[]{0, 0, 0, ""}, ClientPerformance$MonitorItemReviewAndApproveRequest.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f342157id = PBField.initUInt32(0);
    public final PBEnumField result = PBField.initEnum(0);
    public final PBUInt32Field monitor_type = PBField.initUInt32(0);
    public final PBStringField branch = PBField.initString("");
}
