package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameFriendSelectorSvr$GetFriendsRsp extends MessageMicro<GameFriendSelectorSvr$GetFriendsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"partition_name", "role_name", "friends", "id"}, new Object[]{"", "", null, ""}, GameFriendSelectorSvr$GetFriendsRsp.class);
    public final PBStringField partition_name = PBField.initString("");
    public final PBStringField role_name = PBField.initString("");
    public final PBRepeatMessageField<GameFriendSelectorSvr$Friend> friends = PBField.initRepeatMessage(GameFriendSelectorSvr$Friend.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f213220id = PBField.initString("");
}
