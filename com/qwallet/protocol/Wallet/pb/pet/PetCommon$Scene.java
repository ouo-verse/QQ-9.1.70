package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetCommon$Scene extends MessageMicro<PetCommon$Scene> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"id", "equipped"}, new Object[]{"", Boolean.FALSE}, PetCommon$Scene.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f41705id = PBField.initString("");
    public final PBBoolField equipped = PBField.initBool(false);
}
