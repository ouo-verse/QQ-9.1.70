package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProPreloadGuildFeedsRsp {
    public long cdDuration;
    public int msgSumType;
    public ArrayList<GProPreloadFeed> feeds = new ArrayList<>();
    public byte[] token = new byte[0];
    public byte[] msgSum = new byte[0];
    public ArrayList<GProStFeed> stfeedList = new ArrayList<>();

    public long getCdDuration() {
        return this.cdDuration;
    }

    public ArrayList<GProPreloadFeed> getFeeds() {
        return this.feeds;
    }

    public byte[] getMsgSum() {
        return this.msgSum;
    }

    public int getMsgSumType() {
        return this.msgSumType;
    }

    public ArrayList<GProStFeed> getStfeedList() {
        return this.stfeedList;
    }

    public byte[] getToken() {
        return this.token;
    }

    public String toString() {
        return "GProPreloadGuildFeedsRsp{feeds=" + this.feeds + ",cdDuration=" + this.cdDuration + ",token=" + this.token + ",msgSum=" + this.msgSum + ",msgSumType=" + this.msgSumType + ",stfeedList=" + this.stfeedList + ",}";
    }
}
