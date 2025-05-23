package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRealTimeChannel {
    public String channelId;
    public int channelType;
    public String guildId;
    public GProRealTimeLiveChannel liveChannel;
    public GProRealTimeVoiceChannel voiceChannel;

    public GProRealTimeChannel() {
        this.guildId = "";
        this.channelId = "";
        this.liveChannel = new GProRealTimeLiveChannel();
        this.voiceChannel = new GProRealTimeVoiceChannel();
    }

    public String getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public GProRealTimeLiveChannel getLiveChannel() {
        return this.liveChannel;
    }

    public GProRealTimeVoiceChannel getVoiceChannel() {
        return this.voiceChannel;
    }

    public String toString() {
        return "GProRealTimeChannel{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelType=" + this.channelType + ",liveChannel=" + this.liveChannel + ",voiceChannel=" + this.voiceChannel + ",}";
    }

    public GProRealTimeChannel(String str, String str2, int i3, GProRealTimeLiveChannel gProRealTimeLiveChannel, GProRealTimeVoiceChannel gProRealTimeVoiceChannel) {
        this.guildId = "";
        this.channelId = "";
        this.liveChannel = new GProRealTimeLiveChannel();
        new GProRealTimeVoiceChannel();
        this.guildId = str;
        this.channelId = str2;
        this.channelType = i3;
        this.liveChannel = gProRealTimeLiveChannel;
        this.voiceChannel = gProRealTimeVoiceChannel;
    }
}
