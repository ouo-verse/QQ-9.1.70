package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetAppListRsp {
    public int cacheInterval;
    public ArrayList<AppListAppInfo> appList = new ArrayList<>();
    public ArrayList<AppListAppInfo> moreList = new ArrayList<>();

    public ArrayList<AppListAppInfo> getAppList() {
        return this.appList;
    }

    public int getCacheInterval() {
        return this.cacheInterval;
    }

    public ArrayList<AppListAppInfo> getMoreList() {
        return this.moreList;
    }

    public String toString() {
        return "GetAppListRsp{appList=" + this.appList + ",moreList=" + this.moreList + ",cacheInterval=" + this.cacheInterval + ",}";
    }
}
