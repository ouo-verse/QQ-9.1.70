package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetGlobalConfig$Ornament extends MessageMicro<PetGlobalConfig$Ornament> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"id", "resource", "name", "icon"}, new Object[]{"", "", "", ""}, PetGlobalConfig$Ornament.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f41707id = PBField.initString("");
    public final PBStringField resource = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
}
