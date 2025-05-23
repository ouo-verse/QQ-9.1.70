package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetTopFeedsRsp {
    public ArrayList<GProTopFeed> topFeeds = new ArrayList<>();

    public ArrayList<GProTopFeed> getTopFeeds() {
        return this.topFeeds;
    }

    public String toString() {
        return "GProGetTopFeedsRsp{topFeeds=" + this.topFeeds + ",}";
    }
}
