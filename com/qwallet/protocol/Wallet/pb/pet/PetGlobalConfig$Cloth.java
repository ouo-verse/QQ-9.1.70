package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetGlobalConfig$Cloth extends MessageMicro<PetGlobalConfig$Cloth> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"id", "name", "icon", "node_name", "position", "pets"}, new Object[]{"", "", "", "", "", ""}, PetGlobalConfig$Cloth.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f41706id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField node_name = PBField.initString("");
    public final PBStringField position = PBField.initString("");
    public final PBRepeatField<String> pets = PBField.initRepeat(PBStringField.__repeatHelper__);
}
