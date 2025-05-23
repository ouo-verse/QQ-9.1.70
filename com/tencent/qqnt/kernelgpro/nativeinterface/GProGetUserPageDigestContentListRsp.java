package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetUserPageDigestContentListRsp {
    public boolean isFinish;
    public String cookie = "";
    public String traceId = "";
    public ArrayList<GProStFeed> vecFeedList = new ArrayList<>();

    public String getCookie() {
        return this.cookie;
    }

    public boolean getIsFinish() {
        return this.isFinish;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public ArrayList<GProStFeed> getVecFeedList() {
        return this.vecFeedList;
    }

    public String toString() {
        return "GProGetUserPageDigestContentListRsp{isFinish=" + this.isFinish + ",cookie=" + this.cookie + ",traceId=" + this.traceId + ",vecFeedList=" + this.vecFeedList + ",}";
    }
}
