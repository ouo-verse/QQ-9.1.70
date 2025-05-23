package com.tencent.ecommerce.repo.proto.ecom.api_gateway;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECApiGateway$KeyValue extends MessageMicro<ECApiGateway$KeyValue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, ECApiGateway$KeyValue.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
