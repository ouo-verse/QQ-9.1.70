package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetContentRecommendRsp implements Serializable {
    public byte[] cookies;
    public GProMVPExtInfo extInfo;
    public GProNavigationList navigation;
    public ArrayList<GProRecommendContentItem> recommendList;
    long serialVersionUID;
    public String sessionId;

    public GProGetContentRecommendRsp() {
        this.serialVersionUID = 1L;
        this.recommendList = new ArrayList<>();
        this.extInfo = new GProMVPExtInfo();
        this.cookies = new byte[0];
        this.sessionId = "";
        this.navigation = new GProNavigationList();
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public GProMVPExtInfo getExtInfo() {
        return this.extInfo;
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

    public String toString() {
        return "GProGetContentRecommendRsp{recommendList=" + this.recommendList + ",extInfo=" + this.extInfo + ",cookies=" + this.cookies + ",sessionId=" + this.sessionId + ",navigation=" + this.navigation + ",}";
    }

    public GProGetContentRecommendRsp(ArrayList<GProRecommendContentItem> arrayList, GProMVPExtInfo gProMVPExtInfo, byte[] bArr, String str) {
        this.serialVersionUID = 1L;
        this.recommendList = new ArrayList<>();
        this.extInfo = new GProMVPExtInfo();
        this.cookies = new byte[0];
        this.sessionId = "";
        this.navigation = new GProNavigationList();
        this.recommendList = arrayList;
        this.extInfo = gProMVPExtInfo;
        this.cookies = bArr;
        this.sessionId = str;
    }
}
