package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes3.dex */
public final class PetRank$MyFriendsRsp extends MessageMicro<PetRank$MyFriendsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"friend_info"}, new Object[]{null}, PetRank$MyFriendsRsp.class);
    public final PBRepeatMessageField<PetRank$FriendInfo> friend_info = PBField.initRepeatMessage(PetRank$FriendInfo.class);
}
