package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes3.dex */
public final class PetCommon$Dress extends MessageMicro<PetCommon$Dress> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"clothing", "ornament", "scene"}, new Object[]{null, null, null}, PetCommon$Dress.class);
    public final PBRepeatMessageField<PetCommon$Clothing> clothing = PBField.initRepeatMessage(PetCommon$Clothing.class);
    public final PBRepeatMessageField<PetCommon$Ornament> ornament = PBField.initRepeatMessage(PetCommon$Ornament.class);
    public final PBRepeatMessageField<PetCommon$Scene> scene = PBField.initRepeatMessage(PetCommon$Scene.class);
}
