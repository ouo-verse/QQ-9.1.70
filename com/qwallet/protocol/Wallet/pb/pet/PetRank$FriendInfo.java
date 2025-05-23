package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetRank$FriendInfo extends MessageMicro<PetRank$FriendInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"icon", "nick", "is_opened", "pet_icon", "pet_level"}, new Object[]{"", "", Boolean.FALSE, "", ""}, PetRank$FriendInfo.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBBoolField is_opened = PBField.initBool(false);
    public final PBStringField pet_icon = PBField.initString("");
    public final PBStringField pet_level = PBField.initString("");
}
