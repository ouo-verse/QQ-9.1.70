package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes6.dex */
public final class QQAppChannel$GetClientPlatformResponse extends MessageMicro<QQAppChannel$GetClientPlatformResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"platform", "error"}, new Object[]{"", null}, QQAppChannel$GetClientPlatformResponse.class);
    public final PBStringField platform = PBField.initString("");
    public ZPlanError error = new ZPlanError();
}
