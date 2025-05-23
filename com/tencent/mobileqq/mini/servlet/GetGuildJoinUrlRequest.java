package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$GetGuildInviteCodeReq;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetGuildJoinUrlRequest extends ProtoBufRequest {
    private INTERFACE$GetGuildInviteCodeReq mReq;

    public GetGuildJoinUrlRequest(String str) {
        INTERFACE$GetGuildInviteCodeReq iNTERFACE$GetGuildInviteCodeReq = new INTERFACE$GetGuildInviteCodeReq();
        this.mReq = iNTERFACE$GetGuildInviteCodeReq;
        iNTERFACE$GetGuildInviteCodeReq.guild_id.set(str);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.mReq.toByteArray();
    }
}
