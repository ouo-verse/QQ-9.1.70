package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetGlobalConfig$Scene extends MessageMicro<PetGlobalConfig$Scene> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"id", "name", "icon", "resource"}, new Object[]{"", "", "", ""}, PetGlobalConfig$Scene.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f41708id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField resource = PBField.initString("");
}
