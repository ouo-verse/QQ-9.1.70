package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProTopChannelFeedReq {
    public long cancelTime;
    public long channelId;
    public long guildId;
    public int sceneType;
    public String feedId = "";
    public String pginSourceName = "";
    public String visitFrom = "";

    public long getCancelTime() {
        return this.cancelTime;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getPginSourceName() {
        return this.pginSourceName;
    }

    public int getSceneType() {
        return this.sceneType;
    }

    public String getVisitFrom() {
        return this.visitFrom;
    }

    public String toString() {
        return "GProTopChannelFeedReq{sceneType=" + this.sceneType + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",feedId=" + this.feedId + ",cancelTime=" + this.cancelTime + ",pginSourceName=" + this.pginSourceName + ",visitFrom=" + this.visitFrom + ",}";
    }
}
