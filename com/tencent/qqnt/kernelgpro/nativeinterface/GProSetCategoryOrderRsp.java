package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes24.dex */
public final class GProSetCategoryOrderRsp {
    public ArrayList<GProCategoryChannelIdList> categoryList;
    public HashMap<Long, GProChannel> channelMap;
    public GProCategoryChannelIdList uncategorizedChannels;

    public GProSetCategoryOrderRsp() {
        this.channelMap = new HashMap<>();
        this.uncategorizedChannels = new GProCategoryChannelIdList();
        this.categoryList = new ArrayList<>();
    }

    public ArrayList<GProCategoryChannelIdList> getCategoryList() {
        return this.categoryList;
    }

    public HashMap<Long, GProChannel> getChannelMap() {
        return this.channelMap;
    }

    public GProCategoryChannelIdList getUncategorizedChannels() {
        return this.uncategorizedChannels;
    }

    public String toString() {
        return "GProSetCategoryOrderRsp{channelMap=" + this.channelMap + ",uncategorizedChannels=" + this.uncategorizedChannels + ",categoryList=" + this.categoryList + ",}";
    }

    public GProSetCategoryOrderRsp(HashMap<Long, GProChannel> hashMap, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList) {
        this.channelMap = new HashMap<>();
        this.uncategorizedChannels = new GProCategoryChannelIdList();
        new ArrayList();
        this.channelMap = hashMap;
        this.uncategorizedChannels = gProCategoryChannelIdList;
        this.categoryList = arrayList;
    }
}
