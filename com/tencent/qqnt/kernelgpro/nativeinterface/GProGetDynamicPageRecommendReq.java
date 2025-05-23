package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetDynamicPageRecommendReq {
    public int direction;
    public int refreshNum;
    public int tabType;
    public int userRecommendType;
    public GProMVPSourceInfo source = new GProMVPSourceInfo();
    public byte[] cookies = new byte[0];
    public String sessionId = "";
    public String busiInfo = "";
    public byte[] visitorMsg = new byte[0];
    public String navigationVersion = "";

    public String getBusiInfo() {
        return this.busiInfo;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public int getDirection() {
        return this.direction;
    }

    public String getNavigationVersion() {
        return this.navigationVersion;
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

    public int getTabType() {
        return this.tabType;
    }

    public int getUserRecommendType() {
        return this.userRecommendType;
    }

    public byte[] getVisitorMsg() {
        return this.visitorMsg;
    }

    public String toString() {
        return "GProGetDynamicPageRecommendReq{source=" + this.source + ",cookies=" + this.cookies + ",direction=" + this.direction + ",refreshNum=" + this.refreshNum + ",sessionId=" + this.sessionId + ",busiInfo=" + this.busiInfo + ",visitorMsg=" + this.visitorMsg + ",userRecommendType=" + this.userRecommendType + ",navigationVersion=" + this.navigationVersion + ",tabType=" + this.tabType + ",}";
    }
}
