package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProLobbyAppAuthStatusRsp {
    public String authCode;
    public int authStatus;
    public String openId;

    public GProLobbyAppAuthStatusRsp() {
        this.openId = "";
        this.authCode = "";
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public int getAuthStatus() {
        return this.authStatus;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String toString() {
        return "GProLobbyAppAuthStatusRsp{authStatus=" + this.authStatus + ",openId=" + this.openId + ",authCode=" + this.authCode + ",}";
    }

    public GProLobbyAppAuthStatusRsp(int i3, String str, String str2) {
        this.authStatus = i3;
        this.openId = str;
        this.authCode = str2;
    }
}
