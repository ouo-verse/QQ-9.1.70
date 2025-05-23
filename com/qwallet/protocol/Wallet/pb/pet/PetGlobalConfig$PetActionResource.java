package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetGlobalConfig$PetActionResource extends MessageMicro<PetGlobalConfig$PetActionResource> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"action_type", "pet_resource", "decoration_resource", "sub_action_resources"}, new Object[]{"", "", "", null}, PetGlobalConfig$PetActionResource.class);
    public final PBStringField action_type = PBField.initString("");
    public final PBStringField pet_resource = PBField.initString("");
    public final PBStringField decoration_resource = PBField.initString("");
    public final PBRepeatMessageField<PetGlobalConfig$SubActionResources> sub_action_resources = PBField.initRepeatMessage(PetGlobalConfig$SubActionResources.class);
}
