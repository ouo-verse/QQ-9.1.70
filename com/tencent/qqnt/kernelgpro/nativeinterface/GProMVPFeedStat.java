package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMVPFeedStat {
    public long pageView;
    public long shareCount;
    public long totalCommentCount;
    public GProMVPPrefer prefer = new GProMVPPrefer();
    public ArrayList<GProMVPEmoji> emojis = new ArrayList<>();

    public ArrayList<GProMVPEmoji> getEmojis() {
        return this.emojis;
    }

    public long getPageView() {
        return this.pageView;
    }

    public GProMVPPrefer getPrefer() {
        return this.prefer;
    }

    public long getShareCount() {
        return this.shareCount;
    }

    public long getTotalCommentCount() {
        return this.totalCommentCount;
    }

    public String toString() {
        return "GProMVPFeedStat{pageView=" + this.pageView + ",shareCount=" + this.shareCount + ",totalCommentCount=" + this.totalCommentCount + ",prefer=" + this.prefer + ",emojis=" + this.emojis + ",}";
    }
}
