package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayGatewayProto$ProxyReq extends MessageMicro<PayGatewayProto$ProxyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"service", "method", "payload", "trans"}, new Object[]{"", "", ByteStringMicro.EMPTY, null}, PayGatewayProto$ProxyReq.class);
    public final PBStringField service = PBField.initString("");
    public final PBStringField method = PBField.initString("");
    public final PBBytesField payload = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<PayGatewayProto$TransInfo> trans = PBField.initRepeatMessage(PayGatewayProto$TransInfo.class);
}
