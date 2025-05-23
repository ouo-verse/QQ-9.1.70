package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.raft.codegenmeta.utils.Constants;

/* loaded from: classes3.dex */
public final class PetGlobalConfig$GetRsp extends MessageMicro<PetGlobalConfig$GetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"version", "pets", "clothing", "ornament", "scenes", Constants.Raft.TASKS, "defaults"}, new Object[]{"", null, null, null, null, null, null}, PetGlobalConfig$GetRsp.class);
    public final PBStringField version = PBField.initString("");
    public final PBRepeatMessageField<PetGlobalConfig$Pet> pets = PBField.initRepeatMessage(PetGlobalConfig$Pet.class);
    public final PBRepeatMessageField<PetGlobalConfig$Cloth> clothing = PBField.initRepeatMessage(PetGlobalConfig$Cloth.class);
    public final PBRepeatMessageField<PetGlobalConfig$Ornament> ornament = PBField.initRepeatMessage(PetGlobalConfig$Ornament.class);
    public final PBRepeatMessageField<PetGlobalConfig$Scene> scenes = PBField.initRepeatMessage(PetGlobalConfig$Scene.class);
    public final PBRepeatMessageField<PetGlobalConfig$Task> tasks = PBField.initRepeatMessage(PetGlobalConfig$Task.class);
    public PetGlobalConfig$Default defaults = new PetGlobalConfig$Default();
}
