package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildAdvFeedPos {
    public int index;
    public boolean isUpdated;
    public boolean supportInteraction;
    public byte[] feedModel = new byte[0];
    public GProGuildAdvFeedInfo feedInfo = new GProGuildAdvFeedInfo();
    public GProGuildAdvFeedReddotInfo reddotInfo = new GProGuildAdvFeedReddotInfo();
    public GProGuildAdvFeedAdvInfo advInfo = new GProGuildAdvFeedAdvInfo();

    public GProGuildAdvFeedAdvInfo getAdvInfo() {
        return this.advInfo;
    }

    public GProGuildAdvFeedInfo getFeedInfo() {
        return this.feedInfo;
    }

    public byte[] getFeedModel() {
        return this.feedModel;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean getIsUpdated() {
        return this.isUpdated;
    }

    public GProGuildAdvFeedReddotInfo getReddotInfo() {
        return this.reddotInfo;
    }

    public boolean getSupportInteraction() {
        return this.supportInteraction;
    }

    public String toString() {
        return "GProGuildAdvFeedPos{index=" + this.index + ",feedModel=" + this.feedModel + ",supportInteraction=" + this.supportInteraction + ",feedInfo=" + this.feedInfo + ",reddotInfo=" + this.reddotInfo + ",advInfo=" + this.advInfo + ",isUpdated=" + this.isUpdated + ",}";
    }
}
