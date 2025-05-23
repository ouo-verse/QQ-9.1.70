package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAISearchGetSessionListRsp {
    public long cookie;
    public boolean isFinished;
    public long totalCount;
    public ArrayList<GProAISearchUserSessionCategory> userSessionList = new ArrayList<>();

    public long getCookie() {
        return this.cookie;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public ArrayList<GProAISearchUserSessionCategory> getUserSessionList() {
        return this.userSessionList;
    }

    public String toString() {
        return "GProAISearchGetSessionListRsp{userSessionList=" + this.userSessionList + ",cookie=" + this.cookie + ",isFinished=" + this.isFinished + ",totalCount=" + this.totalCount + ",}";
    }
}
