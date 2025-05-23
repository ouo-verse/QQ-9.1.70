package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameFriendSelectorSvr$GetTokenReq extends MessageMicro<GameFriendSelectorSvr$GetTokenReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"sender_id", "receiver_id"}, new Object[]{"", ""}, GameFriendSelectorSvr$GetTokenReq.class);
    public final PBStringField sender_id = PBField.initString("");
    public final PBStringField receiver_id = PBField.initString("");
}
