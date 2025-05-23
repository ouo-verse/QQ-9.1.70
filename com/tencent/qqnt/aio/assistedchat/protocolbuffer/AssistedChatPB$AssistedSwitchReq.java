package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes23.dex */
public final class AssistedChatPB$AssistedSwitchReq extends MessageMicro<AssistedChatPB$AssistedSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"peer_user"}, new Object[]{null}, AssistedChatPB$AssistedSwitchReq.class);
    public AssistedChatPB$PeerUser peer_user = new AssistedChatPB$PeerUser();
}
