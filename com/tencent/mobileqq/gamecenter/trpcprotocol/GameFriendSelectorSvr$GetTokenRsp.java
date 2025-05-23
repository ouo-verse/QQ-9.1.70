package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameFriendSelectorSvr$GetTokenRsp extends MessageMicro<GameFriendSelectorSvr$GetTokenRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"token"}, new Object[]{""}, GameFriendSelectorSvr$GetTokenRsp.class);
    public final PBStringField token = PBField.initString("");
}
