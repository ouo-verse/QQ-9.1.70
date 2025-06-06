package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildData {
    public ArrayList<GProRecommendCategoryInfo> categoryList;
    public ArrayList<GProRecommendChannelExtendInfo> channelExtendInfo;
    public ArrayList<GProPollingData> dataList;
    public GProRecommendGuildInfo guildInfo;

    public GProGuildData() {
        this.guildInfo = new GProRecommendGuildInfo();
        this.categoryList = new ArrayList<>();
        this.channelExtendInfo = new ArrayList<>();
        this.dataList = new ArrayList<>();
    }

    public ArrayList<GProRecommendCategoryInfo> getCategoryList() {
        return this.categoryList;
    }

    public ArrayList<GProRecommendChannelExtendInfo> getChannelExtendInfo() {
        return this.channelExtendInfo;
    }

    public ArrayList<GProPollingData> getDataList() {
        return this.dataList;
    }

    public GProRecommendGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public String toString() {
        return "GProGuildData{guildInfo=" + this.guildInfo + ",categoryList=" + this.categoryList + ",channelExtendInfo=" + this.channelExtendInfo + ",dataList=" + this.dataList + ",}";
    }

    public GProGuildData(GProRecommendGuildInfo gProRecommendGuildInfo, ArrayList<GProRecommendCategoryInfo> arrayList, ArrayList<GProRecommendChannelExtendInfo> arrayList2, ArrayList<GProPollingData> arrayList3) {
        this.guildInfo = new GProRecommendGuildInfo();
        this.categoryList = new ArrayList<>();
        this.channelExtendInfo = new ArrayList<>();
        new ArrayList();
        this.guildInfo = gProRecommendGuildInfo;
        this.categoryList = arrayList;
        this.channelExtendInfo = arrayList2;
        this.dataList = arrayList3;
    }
}
