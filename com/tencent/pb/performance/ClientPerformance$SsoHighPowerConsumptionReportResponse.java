package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$SsoHighPowerConsumptionReportResponse extends MessageMicro<ClientPerformance$SsoHighPowerConsumptionReportResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "msg"}, new Object[]{0, ""}, ClientPerformance$SsoHighPowerConsumptionReportResponse.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342163msg = PBField.initString("");
}
