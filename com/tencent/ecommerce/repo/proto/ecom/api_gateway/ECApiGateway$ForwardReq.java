package com.tencent.ecommerce.repo.proto.ecom.api_gateway;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECApiGateway$ForwardReq extends MessageMicro<ECApiGateway$ForwardReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 802}, new String[]{"service", "method", "body", "serialization_type", "refer", "exts"}, new Object[]{"", "", ByteStringMicro.EMPTY, 0, "", null}, ECApiGateway$ForwardReq.class);
    public final PBStringField service = PBField.initString("");
    public final PBStringField method = PBField.initString("");
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field serialization_type = PBField.initUInt32(0);
    public final PBStringField refer = PBField.initString("");
    public final PBRepeatMessageField<ECApiGateway$KeyValue> exts = PBField.initRepeatMessage(ECApiGateway$KeyValue.class);
}
