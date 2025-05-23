package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes24.dex */
public final class GProGuildInit implements Serializable {
    public long guildId;
    long serialVersionUID = 1;
    public HashMap<Long, GProChannel> channelMap = new HashMap<>();
    public GProCategoryChannelIdList uncategorizedChannels = new GProCategoryChannelIdList();
    public ArrayList<GProCategoryChannelIdList> categoryList = new ArrayList<>();

    public ArrayList<GProCategoryChannelIdList> getCategoryList() {
        return this.categoryList;
    }

    public HashMap<Long, GProChannel> getChannelMap() {
        return this.channelMap;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProCategoryChannelIdList getUncategorizedChannels() {
        return this.uncategorizedChannels;
    }

    public String toString() {
        return "GProGuildInit{guildId=" + this.guildId + ",channelMap=" + this.channelMap + ",uncategorizedChannels=" + this.uncategorizedChannels + ",categoryList=" + this.categoryList + ",}";
    }
}
