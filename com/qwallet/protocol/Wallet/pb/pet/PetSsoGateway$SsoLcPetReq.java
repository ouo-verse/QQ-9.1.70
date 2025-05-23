package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetSsoGateway$SsoLcPetReq extends MessageMicro<PetSsoGateway$SsoLcPetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"service", "method", "data"}, new Object[]{"", "", ByteStringMicro.EMPTY}, PetSsoGateway$SsoLcPetReq.class);
    public final PBStringField service = PBField.initString("");
    public final PBStringField method = PBField.initString("");
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
}
