package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetHotLiveRsp {
    public ArrayList<GProRecommendItem> recommendList = new ArrayList<>();
    public GProRecommendExtInfo extInfo = new GProRecommendExtInfo();
    public byte[] cookie = new byte[0];
    public String sessionId = "";

    public byte[] getCookie() {
        return this.cookie;
    }

    public GProRecommendExtInfo getExtInfo() {
        return this.extInfo;
    }

    public ArrayList<GProRecommendItem> getRecommendList() {
        return this.recommendList;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String toString() {
        return "GProGetHotLiveRsp{recommendList=" + this.recommendList + ",extInfo=" + this.extInfo + ",cookie=" + this.cookie + ",sessionId=" + this.sessionId + ",}";
    }
}
