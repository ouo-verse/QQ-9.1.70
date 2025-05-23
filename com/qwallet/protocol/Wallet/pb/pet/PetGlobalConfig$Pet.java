package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetGlobalConfig$Pet extends MessageMicro<PetGlobalConfig$Pet> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"pet_type", "base_action_type", "icon", ThreadPoolParams.DEFAULT_THREAD_NAME, "icon_active", "pet_action_resources", "random_names", "entrance_pic_small", "entrance_pic_big"}, new Object[]{"", "", "", "", "", null, "", "", ""}, PetGlobalConfig$Pet.class);
    public final PBStringField pet_type = PBField.initString("");
    public final PBStringField base_action_type = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField default_name = PBField.initString("");
    public final PBStringField icon_active = PBField.initString("");
    public final PBRepeatMessageField<PetGlobalConfig$PetActionResource> pet_action_resources = PBField.initRepeatMessage(PetGlobalConfig$PetActionResource.class);
    public final PBRepeatField<String> random_names = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField entrance_pic_small = PBField.initString("");
    public final PBStringField entrance_pic_big = PBField.initString("");
}
