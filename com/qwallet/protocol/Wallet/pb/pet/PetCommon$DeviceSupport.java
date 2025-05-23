package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetCommon$DeviceSupport extends MessageMicro<PetCommon$DeviceSupport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_support", "fail_url"}, new Object[]{Boolean.FALSE, ""}, PetCommon$DeviceSupport.class);
    public final PBBoolField is_support = PBField.initBool(false);
    public final PBStringField fail_url = PBField.initString("");
}
