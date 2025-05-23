package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameFriendSelectorSvr$SendMsgRsp extends MessageMicro<GameFriendSelectorSvr$SendMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg"}, new Object[]{""}, GameFriendSelectorSvr$SendMsgRsp.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f213223msg = PBField.initString("");
}
