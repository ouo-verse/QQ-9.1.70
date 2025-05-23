package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStickyChannel implements Serializable {
    public int channelType;
    public long createTime;
    public long updateTime;
    long serialVersionUID = 1;
    public String guildId = "";
    public String channelId = "";
    public GProStickyTextChannel textChannel = new GProStickyTextChannel();
    public GProLiveRoomInfo liveChannel = new GProLiveRoomInfo();
    public GProChannelMemberInfos voiceChannel = new GProChannelMemberInfos();
    public GProStickyFeedChannel feedChannel = new GProStickyFeedChannel();

    public String getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public GProStickyFeedChannel getFeedChannel() {
        return this.feedChannel;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public GProLiveRoomInfo getLiveChannel() {
        return this.liveChannel;
    }

    public GProStickyTextChannel getTextChannel() {
        return this.textChannel;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public GProChannelMemberInfos getVoiceChannel() {
        return this.voiceChannel;
    }

    public String toString() {
        return "GProStickyChannel{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelType=" + this.channelType + ",createTime=" + this.createTime + ",updateTime=" + this.updateTime + ",textChannel=" + this.textChannel + ",liveChannel=" + this.liveChannel + ",voiceChannel=" + this.voiceChannel + ",feedChannel=" + this.feedChannel + ",}";
    }
}
