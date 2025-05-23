package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class QQAppChannel$GetClientVersionResponse extends MessageMicro<QQAppChannel$GetClientVersionResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"version", "error"}, new Object[]{"", null}, QQAppChannel$GetClientVersionResponse.class);
    public final PBStringField version = PBField.initString("");
    public ZPlanError error = new ZPlanError();
}
