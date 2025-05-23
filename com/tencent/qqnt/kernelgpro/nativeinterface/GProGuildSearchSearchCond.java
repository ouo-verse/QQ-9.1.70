package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildSearchSearchCond {
    public int rankType;
    public ArrayList<Long> channelIds = new ArrayList<>();
    public ArrayList<Long> fromTinyids = new ArrayList<>();
    public ArrayList<GProGuildSearchMsgTimeRange> timeRanges = new ArrayList<>();

    public ArrayList<Long> getChannelIds() {
        return this.channelIds;
    }

    public ArrayList<Long> getFromTinyids() {
        return this.fromTinyids;
    }

    public int getRankType() {
        return this.rankType;
    }

    public ArrayList<GProGuildSearchMsgTimeRange> getTimeRanges() {
        return this.timeRanges;
    }

    public String toString() {
        return "GProGuildSearchSearchCond{channelIds=" + this.channelIds + ",fromTinyids=" + this.fromTinyids + ",timeRanges=" + this.timeRanges + ",rankType=" + this.rankType + ",}";
    }
}
