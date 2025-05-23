package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$AddRecentPlayReq;

/* loaded from: classes33.dex */
public class AddRecentPlayRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "miniapp.trpc.minigame.thirdparty_app_recent_play.ThirdpartyAppRecentPlay.AddRecentPlay";
    private INTERFACE$AddRecentPlayReq req;

    public AddRecentPlayRequest(String str, int i3) {
        INTERFACE$AddRecentPlayReq iNTERFACE$AddRecentPlayReq = new INTERFACE$AddRecentPlayReq();
        this.req = iNTERFACE$AddRecentPlayReq;
        iNTERFACE$AddRecentPlayReq.appid.set(str);
        this.req.versionType.set(3);
        this.req.timestamp.set(System.currentTimeMillis() / 1000);
        this.req.source.set(i3);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
