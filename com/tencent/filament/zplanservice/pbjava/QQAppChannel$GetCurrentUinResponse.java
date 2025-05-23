package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class QQAppChannel$GetCurrentUinResponse extends MessageMicro<QQAppChannel$GetCurrentUinResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "error"}, new Object[]{0L, null}, QQAppChannel$GetCurrentUinResponse.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public ZPlanError error = new ZPlanError();
}
