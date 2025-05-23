package com.tencent.ecommerce.repo.proto.ecom.cir.api_gateway;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class COMM$BytesEntry extends MessageMicro<COMM$BytesEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ByteStringMicro.EMPTY}, COMM$BytesEntry.class);
    public final PBStringField key = PBField.initString("");
    public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
}
