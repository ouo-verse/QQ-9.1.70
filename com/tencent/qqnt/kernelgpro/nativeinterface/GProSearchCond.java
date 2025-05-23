package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSearchCond {
    public ArrayList<Long> channelIds;
    public ArrayList<Long> fromTinyIds;
    public ArrayList<GProMsgTimeRange> timeRanges;

    public GProSearchCond() {
        this.channelIds = new ArrayList<>();
        this.fromTinyIds = new ArrayList<>();
        this.timeRanges = new ArrayList<>();
    }

    public ArrayList<Long> getChannelIds() {
        return this.channelIds;
    }

    public ArrayList<Long> getFromTinyIds() {
        return this.fromTinyIds;
    }

    public ArrayList<GProMsgTimeRange> getTimeRanges() {
        return this.timeRanges;
    }

    public void setChannelIds(ArrayList<Long> arrayList) {
        this.channelIds = arrayList;
    }

    public void setFromTinyIds(ArrayList<Long> arrayList) {
        this.fromTinyIds = arrayList;
    }

    public void setTimeRanges(ArrayList<GProMsgTimeRange> arrayList) {
        this.timeRanges = arrayList;
    }

    public String toString() {
        return "GProSearchCond{channelIds=" + this.channelIds + ",fromTinyIds=" + this.fromTinyIds + ",timeRanges=" + this.timeRanges + ",}";
    }

    public GProSearchCond(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<GProMsgTimeRange> arrayList3) {
        this.channelIds = new ArrayList<>();
        this.fromTinyIds = new ArrayList<>();
        new ArrayList();
        this.channelIds = arrayList;
        this.fromTinyIds = arrayList2;
        this.timeRanges = arrayList3;
    }
}
