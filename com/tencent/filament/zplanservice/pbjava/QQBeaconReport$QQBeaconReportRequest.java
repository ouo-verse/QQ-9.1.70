package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class QQBeaconReport$QQBeaconReportRequest extends MessageMicro<QQBeaconReport$QQBeaconReportRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"event", "params"}, new Object[]{"", ""}, QQBeaconReport$QQBeaconReportRequest.class);
    public final PBStringField event = PBField.initString("");
    public final PBStringField params = PBField.initString("");
}
