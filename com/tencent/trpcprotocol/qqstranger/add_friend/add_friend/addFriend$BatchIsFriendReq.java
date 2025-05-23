package com.tencent.trpcprotocol.qqstranger.add_friend.add_friend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class addFriend$BatchIsFriendReq extends MessageMicro<addFriend$BatchIsFriendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"to_openids"}, new Object[]{""}, addFriend$BatchIsFriendReq.class);
    public final PBRepeatField<String> to_openids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
