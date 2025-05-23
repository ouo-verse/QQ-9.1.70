package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProPageHeadInfo implements Serializable {
    public ArrayList<GProBannerInfo> bannerInfos;
    public String dayBannerUrl;
    public boolean hasSearch;
    public String headText;
    public String nightBannerUrl;
    public long pollingDuration;
    long serialVersionUID;
    public String valueAddedBannerUrl;

    public GProPageHeadInfo() {
        this.serialVersionUID = 1L;
        this.headText = "";
        this.dayBannerUrl = "";
        this.bannerInfos = new ArrayList<>();
        this.nightBannerUrl = "";
        this.valueAddedBannerUrl = "";
    }

    public ArrayList<GProBannerInfo> getBannerInfos() {
        return this.bannerInfos;
    }

    public String getDayBannerUrl() {
        return this.dayBannerUrl;
    }

    public boolean getHasSearch() {
        return this.hasSearch;
    }

    public String getHeadText() {
        return this.headText;
    }

    public String getNightBannerUrl() {
        return this.nightBannerUrl;
    }

    public long getPollingDuration() {
        return this.pollingDuration;
    }

    public String getValueAddedBannerUrl() {
        return this.valueAddedBannerUrl;
    }

    public String toString() {
        return "GProPageHeadInfo{headText=" + this.headText + ",hasSearch=" + this.hasSearch + ",dayBannerUrl=" + this.dayBannerUrl + ",bannerInfos=" + this.bannerInfos + ",pollingDuration=" + this.pollingDuration + ",nightBannerUrl=" + this.nightBannerUrl + ",valueAddedBannerUrl=" + this.valueAddedBannerUrl + ",}";
    }

    public GProPageHeadInfo(String str, boolean z16, String str2, ArrayList<GProBannerInfo> arrayList, long j3, String str3, String str4) {
        this.serialVersionUID = 1L;
        this.headText = "";
        this.dayBannerUrl = "";
        new ArrayList();
        this.headText = str;
        this.hasSearch = z16;
        this.dayBannerUrl = str2;
        this.bannerInfos = arrayList;
        this.pollingDuration = j3;
        this.nightBannerUrl = str3;
        this.valueAddedBannerUrl = str4;
    }
}
