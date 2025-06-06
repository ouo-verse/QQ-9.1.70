package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMsgSearchCond {
    public ArrayList<Long> channelIds;
    public ArrayList<Integer> channelTypes;
    public ArrayList<Long> fromTinyids;
    public GProSeqCond seqCond;
    public ArrayList<GProMsgTimeRange> timeRanges;

    public GProMsgSearchCond() {
    }

    public ArrayList<Long> getChannelIds() {
        return this.channelIds;
    }

    public ArrayList<Integer> getChannelTypes() {
        return this.channelTypes;
    }

    public ArrayList<Long> getFromTinyids() {
        return this.fromTinyids;
    }

    public GProSeqCond getSeqCond() {
        return this.seqCond;
    }

    public ArrayList<GProMsgTimeRange> getTimeRanges() {
        return this.timeRanges;
    }

    public String toString() {
        return "GProMsgSearchCond{channelIds=" + this.channelIds + ",fromTinyids=" + this.fromTinyids + ",timeRanges=" + this.timeRanges + ",channelTypes=" + this.channelTypes + ",seqCond=" + this.seqCond + ",}";
    }

    public GProMsgSearchCond(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<GProMsgTimeRange> arrayList3, ArrayList<Integer> arrayList4, GProSeqCond gProSeqCond) {
        this.channelIds = arrayList;
        this.fromTinyids = arrayList2;
        this.timeRanges = arrayList3;
        this.channelTypes = arrayList4;
        this.seqCond = gProSeqCond;
    }
}
