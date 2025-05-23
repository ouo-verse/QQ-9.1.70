package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetAppCenterRsp {
    public int appLimit;
    public ArrayList<AppDetail> getApps = new ArrayList<>();
    public ArrayList<AppDetail> recommendApps = new ArrayList<>();
    public ArrayList<RankList> rankList = new ArrayList<>();

    public int getAppLimit() {
        return this.appLimit;
    }

    public ArrayList<AppDetail> getGetApps() {
        return this.getApps;
    }

    public ArrayList<RankList> getRankList() {
        return this.rankList;
    }

    public ArrayList<AppDetail> getRecommendApps() {
        return this.recommendApps;
    }

    public String toString() {
        return "GetAppCenterRsp{getApps=" + this.getApps + ",recommendApps=" + this.recommendApps + ",rankList=" + this.rankList + ",appLimit=" + this.appLimit + ",}";
    }
}
