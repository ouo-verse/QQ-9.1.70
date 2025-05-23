package com.qwallet.protocol.Wallet.hb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class ElementPB$TransInfo extends MessageMicro<ElementPB$TransInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ByteStringMicro.EMPTY}, ElementPB$TransInfo.class);
    public final PBStringField key = PBField.initString("");
    public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
}
