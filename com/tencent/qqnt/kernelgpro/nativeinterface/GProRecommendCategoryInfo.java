package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendCategoryInfo {
    public long categoryId;
    public int categoryIndex;
    public ArrayList<GProChannel> channelInfoList = new ArrayList<>();
    public String categoryName = "";

    public long getCategoryId() {
        return this.categoryId;
    }

    public int getCategoryIndex() {
        return this.categoryIndex;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public ArrayList<GProChannel> getChannelInfoList() {
        return this.channelInfoList;
    }

    public String toString() {
        return "GProRecommendCategoryInfo{categoryIndex=" + this.categoryIndex + ",channelInfoList=" + this.channelInfoList + ",categoryName=" + this.categoryName + ",categoryId=" + this.categoryId + ",}";
    }
}
