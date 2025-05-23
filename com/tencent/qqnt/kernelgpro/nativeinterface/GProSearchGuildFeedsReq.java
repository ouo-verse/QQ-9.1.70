package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSearchGuildFeedsReq {
    public int feedType;
    public long guildId;
    public long tinyId;
    public String query = "";
    public byte[] cookie = new byte[0];
    public ArrayList<Long> channelIds = new ArrayList<>();

    public ArrayList<Long> getChannelIds() {
        return this.channelIds;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public int getFeedType() {
        return this.feedType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getQuery() {
        return this.query;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProSearchGuildFeedsReq{tinyId=" + this.tinyId + ",guildId=" + this.guildId + ",query=" + this.query + ",cookie=" + this.cookie + ",feedType=" + this.feedType + ",channelIds=" + this.channelIds + ",}";
    }
}
