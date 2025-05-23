package com.tencent.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class oidb_0xfe1$ReqDataExtFieldIdItem extends MessageMicro<oidb_0xfe1$ReqDataExtFieldIdItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_key", "bytes_value"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0xfe1$ReqDataExtFieldIdItem.class);
    public final PBUInt32Field uint32_key = PBField.initUInt32(0);
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
}
