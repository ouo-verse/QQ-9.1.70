package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$CreateMonitorBranchPerformanceRequest extends MessageMicro<ClientPerformance$CreateMonitorBranchPerformanceRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"app", "branch_name", "start_time", "end_time"}, new Object[]{0, "", 0L, 0L}, ClientPerformance$CreateMonitorBranchPerformanceRequest.class);
    public final PBEnumField app = PBField.initEnum(0);
    public final PBStringField branch_name = PBField.initString("");
    public final PBInt64Field start_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
}
