package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes3.dex */
public final class PetSsoGateway$WebLcPetRsp extends MessageMicro<PetSsoGateway$WebLcPetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"retcode", "retmsg", "data"}, new Object[]{0L, "", ""}, PetSsoGateway$WebLcPetRsp.class);
    public final PBUInt64Field retcode = PBField.initUInt64(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBStringField data = PBField.initString("");
}
