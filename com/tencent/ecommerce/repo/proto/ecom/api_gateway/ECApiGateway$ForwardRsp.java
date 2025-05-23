package com.tencent.ecommerce.repo.proto.ecom.api_gateway;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECApiGateway$ForwardRsp extends MessageMicro<ECApiGateway$ForwardRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"retcode", "retmsg", "body", "compress_type"}, new Object[]{0, "", ByteStringMicro.EMPTY, 0}, ECApiGateway$ForwardRsp.class);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field compress_type = PBField.initUInt32(0);
}
