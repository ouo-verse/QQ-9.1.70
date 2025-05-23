package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildHomeSections {
    public ArrayList<GProCategoryChannelInfoList> commonCategories = new ArrayList<>();
    public ArrayList<GProChannel> feedChannels = new ArrayList<>();

    public ArrayList<GProCategoryChannelInfoList> getCommonCategories() {
        return this.commonCategories;
    }

    public ArrayList<GProChannel> getFeedChannels() {
        return this.feedChannels;
    }

    public String toString() {
        return "GProGuildHomeSections{commonCategories=" + this.commonCategories + ",feedChannels=" + this.feedChannels + ",}";
    }
}
