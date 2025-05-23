package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$SsoHighPowerConsumptionReportRequest extends MessageMicro<ClientPerformance$SsoHighPowerConsumptionReportRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"branch_name", "data"}, new Object[]{"", null}, ClientPerformance$SsoHighPowerConsumptionReportRequest.class);
    public final PBStringField branch_name = PBField.initString("");
    public final PBRepeatMessageField<ClientPerformance$HighPowerConsumption> data = PBField.initRepeatMessage(ClientPerformance$HighPowerConsumption.class);
}
