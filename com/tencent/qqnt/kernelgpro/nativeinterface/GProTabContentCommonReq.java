package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProTabContentCommonReq {
    public int direction;
    public int refreshNum;
    public int tabId;
    public GProMVPSourceInfo source = new GProMVPSourceInfo();
    public byte[] cookies = new byte[0];
    public byte[] backendCookies = new byte[0];
    public String sessionId = "";
    public byte[] adCookies = new byte[0];

    public byte[] getAdCookies() {
        return this.adCookies;
    }

    public byte[] getBackendCookies() {
        return this.backendCookies;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public int getDirection() {
        return this.direction;
    }

    public int getRefreshNum() {
        return this.refreshNum;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public GProMVPSourceInfo getSource() {
        return this.source;
    }

    public int getTabId() {
        return this.tabId;
    }

    public String toString() {
        return "GProTabContentCommonReq{source=" + this.source + ",direction=" + this.direction + ",refreshNum=" + this.refreshNum + ",tabId=" + this.tabId + ",cookies=" + this.cookies + ",backendCookies=" + this.backendCookies + ",sessionId=" + this.sessionId + ",adCookies=" + this.adCookies + ",}";
    }
}
