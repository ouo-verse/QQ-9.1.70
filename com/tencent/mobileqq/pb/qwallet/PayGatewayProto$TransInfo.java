package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayGatewayProto$TransInfo extends MessageMicro<PayGatewayProto$TransInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ByteStringMicro.EMPTY}, PayGatewayProto$TransInfo.class);
    public final PBStringField key = PBField.initString("");
    public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
}
