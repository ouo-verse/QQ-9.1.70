package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildFeedDraft {
    public long draftUpdateTimeSec;
    public GProStFeed draftFeed = new GProStFeed();
    public String expandJsonStr = "";

    public GProStFeed getDraftFeed() {
        return this.draftFeed;
    }

    public long getDraftUpdateTimeSec() {
        return this.draftUpdateTimeSec;
    }

    public String getExpandJsonStr() {
        return this.expandJsonStr;
    }

    public String toString() {
        return "GProGuildFeedDraft{draftUpdateTimeSec=" + this.draftUpdateTimeSec + ",draftFeed=" + this.draftFeed + ",expandJsonStr=" + this.expandJsonStr + ",}";
    }
}
