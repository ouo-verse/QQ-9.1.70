package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes3.dex */
public final class PetSsoGateway$SsoLcPetRsp extends MessageMicro<PetSsoGateway$SsoLcPetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"retcode", "retmsg", "data"}, new Object[]{0L, "", ByteStringMicro.EMPTY}, PetSsoGateway$SsoLcPetRsp.class);
    public final PBUInt64Field retcode = PBField.initUInt64(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
}
