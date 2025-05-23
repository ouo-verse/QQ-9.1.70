package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetDynamicPageRecommendRsp {
    public boolean isEnd;
    public ArrayList<GProRecommendContentItem> recommendList = new ArrayList<>();
    public GProMVPExtInfo extInfo = new GProMVPExtInfo();
    public byte[] cookies = new byte[0];
    public String sessionId = "";
    public GProNavigationList navigation = new GProNavigationList();
    public ArrayList<GProStFeed> stfeeds = new ArrayList<>();

    public byte[] getCookies() {
        return this.cookies;
    }

    public GProMVPExtInfo getExtInfo() {
        return this.extInfo;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public GProNavigationList getNavigation() {
        return this.navigation;
    }

    public ArrayList<GProRecommendContentItem> getRecommendList() {
        return this.recommendList;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public ArrayList<GProStFeed> getStfeeds() {
        return this.stfeeds;
    }

    public String toString() {
        return "GProGetDynamicPageRecommendRsp{recommendList=" + this.recommendList + ",extInfo=" + this.extInfo + ",cookies=" + this.cookies + ",sessionId=" + this.sessionId + ",navigation=" + this.navigation + ",isEnd=" + this.isEnd + ",stfeeds=" + this.stfeeds + ",}";
    }
}
