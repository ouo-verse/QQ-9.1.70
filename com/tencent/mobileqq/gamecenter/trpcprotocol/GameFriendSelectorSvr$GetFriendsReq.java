package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameFriendSelectorSvr$GetFriendsReq extends MessageMicro<GameFriendSelectorSvr$GetFriendsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"appid"}, new Object[]{""}, GameFriendSelectorSvr$GetFriendsReq.class);
    public final PBStringField appid = PBField.initString("");
}
