package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProEnterAudioLiveChannelReq {
    public long channelId;
    public int channelType;
    public boolean forceTRTCSign;
    public long guildId;
    public String joinSourceType;
    public int sourceType;

    public GProEnterAudioLiveChannelReq() {
        this.joinSourceType = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public boolean getForceTRTCSign() {
        return this.forceTRTCSign;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getJoinSourceType() {
        return this.joinSourceType;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setChannelType(int i3) {
        this.channelType = i3;
    }

    public void setForceTRTCSign(boolean z16) {
        this.forceTRTCSign = z16;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setJoinSourceType(String str) {
        this.joinSourceType = str;
    }

    public void setSourceType(int i3) {
        this.sourceType = i3;
    }

    public String toString() {
        return "GProEnterAudioLiveChannelReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",sourceType=" + this.sourceType + ",forceTRTCSign=" + this.forceTRTCSign + ",joinSourceType=" + this.joinSourceType + ",channelType=" + this.channelType + ",}";
    }

    public GProEnterAudioLiveChannelReq(long j3, long j16, int i3, boolean z16, String str, int i16) {
        this.guildId = j3;
        this.channelId = j16;
        this.sourceType = i3;
        this.forceTRTCSign = z16;
        this.joinSourceType = str;
        this.channelType = i16;
    }
}
