package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class MSFChannel$MSFResponse extends MessageMicro<MSFChannel$MSFResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"data", "error"}, new Object[]{ByteStringMicro.EMPTY, null}, MSFChannel$MSFResponse.class);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    public ZPlanError error = new ZPlanError();
}
