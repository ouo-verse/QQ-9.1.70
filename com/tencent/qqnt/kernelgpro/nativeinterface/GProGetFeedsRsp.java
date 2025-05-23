package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetFeedsRsp {
    public ArrayList<GProMVPFeed> feeds = new ArrayList<>();

    public ArrayList<GProMVPFeed> getFeeds() {
        return this.feeds;
    }

    public String toString() {
        return "GProGetFeedsRsp{feeds=" + this.feeds + ",}";
    }
}
