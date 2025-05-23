package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$ListBranchReportsResponse extends MessageMicro<ClientPerformance$ListBranchReportsResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48}, new String[]{"code", "msg", "data", "total", "page", "size"}, new Object[]{0, "", null, 0, 0, 0}, ClientPerformance$ListBranchReportsResponse.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342154msg = PBField.initString("");
    public final PBRepeatMessageField<ClientPerformance$ReportListData> data = PBField.initRepeatMessage(ClientPerformance$ReportListData.class);
    public final PBInt32Field total = PBField.initInt32(0);
    public final PBInt32Field page = PBField.initInt32(0);
    public final PBInt32Field size = PBField.initInt32(0);
}
