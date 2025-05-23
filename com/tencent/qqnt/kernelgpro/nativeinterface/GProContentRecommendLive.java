package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProContentRecommendLive implements Serializable {
    public long channelId;
    public int channelType;
    public long guildId;
    public long roomId;
    long serialVersionUID = 1;
    public String cover = "";
    public String liveTitle = "";
    public byte[] joinSig = new byte[0];
    public GProFeedGuildInfo guildInfo = new GProFeedGuildInfo();
    public GProContentRecommendStreamInfo streamInfo = new GProContentRecommendStreamInfo();

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getCover() {
        return this.cover;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProFeedGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public byte[] getJoinSig() {
        return this.joinSig;
    }

    public String getLiveTitle() {
        return this.liveTitle;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public GProContentRecommendStreamInfo getStreamInfo() {
        return this.streamInfo;
    }

    public String toString() {
        return "GProContentRecommendLive{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelType=" + this.channelType + ",cover=" + this.cover + ",liveTitle=" + this.liveTitle + ",joinSig=" + this.joinSig + ",roomId=" + this.roomId + ",guildInfo=" + this.guildInfo + ",streamInfo=" + this.streamInfo + ",}";
    }
}
