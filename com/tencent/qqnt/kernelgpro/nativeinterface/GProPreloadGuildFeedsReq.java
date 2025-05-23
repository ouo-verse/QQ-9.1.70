package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProPreloadGuildFeedsReq {
    public int getType;
    public long guildId;
    public long latestContentTime;
    public int sortOption;
    public String latestFeedId = "";
    public GProPreloadGuildFeedsFilter filter = new GProPreloadGuildFeedsFilter();
    public byte[] token = new byte[0];

    public GProPreloadGuildFeedsFilter getFilter() {
        return this.filter;
    }

    public int getGetType() {
        return this.getType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getLatestContentTime() {
        return this.latestContentTime;
    }

    public String getLatestFeedId() {
        return this.latestFeedId;
    }

    public int getSortOption() {
        return this.sortOption;
    }

    public byte[] getToken() {
        return this.token;
    }

    public String toString() {
        return "GProPreloadGuildFeedsReq{guildId=" + this.guildId + ",latestFeedId=" + this.latestFeedId + ",latestContentTime=" + this.latestContentTime + ",filter=" + this.filter + ",token=" + this.token + ",getType=" + this.getType + ",sortOption=" + this.sortOption + ",}";
    }
}
