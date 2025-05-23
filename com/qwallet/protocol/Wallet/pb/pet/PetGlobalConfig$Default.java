package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetGlobalConfig$Default extends MessageMicro<PetGlobalConfig$Default> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"pet_type", "scene_id"}, new Object[]{"", ""}, PetGlobalConfig$Default.class);
    public final PBStringField pet_type = PBField.initString("");
    public final PBStringField scene_id = PBField.initString("");
}
