package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetContentRecommendReq {
    public byte[] adCookies;
    public String busiInfo;
    public byte[] cookies;
    public int direction;
    public String navigationVersion;
    public int refreshNum;
    public String sessionId;
    public GProMVPSourceInfo source;

    public GProGetContentRecommendReq() {
        this.source = new GProMVPSourceInfo();
        this.cookies = new byte[0];
        this.sessionId = "";
        this.busiInfo = "";
        this.navigationVersion = "";
        this.adCookies = new byte[0];
    }

    public byte[] getAdCookies() {
        return this.adCookies;
    }

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

    public void setAdCookies(byte[] bArr) {
        this.adCookies = bArr;
    }

    public void setBusiInfo(String str) {
        this.busiInfo = str;
    }

    public void setCookies(byte[] bArr) {
        this.cookies = bArr;
    }

    public void setDirection(int i3) {
        this.direction = i3;
    }

    public void setNavigationVersion(String str) {
        this.navigationVersion = str;
    }

    public void setRefreshNum(int i3) {
        this.refreshNum = i3;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSource(GProMVPSourceInfo gProMVPSourceInfo) {
        this.source = gProMVPSourceInfo;
    }

    public String toString() {
        return "GProGetContentRecommendReq{source=" + this.source + ",cookies=" + this.cookies + ",direction=" + this.direction + ",refreshNum=" + this.refreshNum + ",sessionId=" + this.sessionId + ",busiInfo=" + this.busiInfo + ",navigationVersion=" + this.navigationVersion + ",adCookies=" + this.adCookies + ",}";
    }

    public GProGetContentRecommendReq(GProMVPSourceInfo gProMVPSourceInfo, byte[] bArr, int i3, int i16, String str, String str2) {
        new GProMVPSourceInfo();
        this.navigationVersion = "";
        this.adCookies = new byte[0];
        this.source = gProMVPSourceInfo;
        this.cookies = bArr;
        this.direction = i3;
        this.refreshNum = i16;
        this.sessionId = str;
        this.busiInfo = str2;
    }
}
