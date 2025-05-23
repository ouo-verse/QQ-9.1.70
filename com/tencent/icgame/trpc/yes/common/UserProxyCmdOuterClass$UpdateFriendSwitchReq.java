package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$UpdateFriendSwitchReq extends MessageMicro<UserProxyCmdOuterClass$UpdateFriendSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"friend_switch"}, new Object[]{0}, UserProxyCmdOuterClass$UpdateFriendSwitchReq.class);
    public final PBInt32Field friend_switch = PBField.initInt32(0);
}
