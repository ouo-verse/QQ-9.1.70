package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes16.dex */
public final class PayGatewayProto$OriginCgiRsp extends MessageMicro<PayGatewayProto$OriginCgiRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{ByteStringMicro.EMPTY}, PayGatewayProto$OriginCgiRsp.class);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
}
