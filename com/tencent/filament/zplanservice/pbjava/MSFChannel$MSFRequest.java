package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class MSFChannel$MSFRequest extends MessageMicro<MSFChannel$MSFRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"command", "data"}, new Object[]{"", ByteStringMicro.EMPTY}, MSFChannel$MSFRequest.class);
    public final PBStringField command = PBField.initString("");
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
}
