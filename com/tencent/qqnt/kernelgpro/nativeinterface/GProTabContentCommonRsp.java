package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProTabContentCommonRsp {
    public ArrayList<GProRecommendContentItem> recommendList = new ArrayList<>();
    public ArrayList<GProNavigationTab> tabList = new ArrayList<>();
    public GProMVPExtInfo extInfo = new GProMVPExtInfo();
    public byte[] cookies = new byte[0];
    public byte[] backendCookies = new byte[0];
    public String sessionId = "";

    public byte[] getBackendCookies() {
        return this.backendCookies;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public GProMVPExtInfo getExtInfo() {
        return this.extInfo;
    }

    public ArrayList<GProRecommendContentItem> getRecommendList() {
        return this.recommendList;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public ArrayList<GProNavigationTab> getTabList() {
        return this.tabList;
    }

    public String toString() {
        return "GProTabContentCommonRsp{recommendList=" + this.recommendList + ",tabList=" + this.tabList + ",extInfo=" + this.extInfo + ",cookies=" + this.cookies + ",backendCookies=" + this.backendCookies + ",sessionId=" + this.sessionId + ",}";
    }
}
