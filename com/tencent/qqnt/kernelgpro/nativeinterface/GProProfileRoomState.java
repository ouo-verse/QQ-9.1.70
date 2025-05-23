package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProProfileRoomState {
    public long channelId;
    public int channelType;
    public GProProfileChannelState feedChannelState;
    public long guildId;
    public GProLiveRoomInfo liveRoomState;
    public GProProfileChannelState textChannelState;
    public GProChannelMemberInfos voiceRoomState;

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public GProProfileChannelState getFeedChannelState() {
        return this.feedChannelState;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProLiveRoomInfo getLiveRoomState() {
        return this.liveRoomState;
    }

    public GProProfileChannelState getTextChannelState() {
        return this.textChannelState;
    }

    public GProChannelMemberInfos getVoiceRoomState() {
        return this.voiceRoomState;
    }

    public String toString() {
        return "GProProfileRoomState{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelType=" + this.channelType + ",voiceRoomState=" + this.voiceRoomState + ",liveRoomState=" + this.liveRoomState + ",textChannelState=" + this.textChannelState + ",feedChannelState=" + this.feedChannelState + ",}";
    }
}
