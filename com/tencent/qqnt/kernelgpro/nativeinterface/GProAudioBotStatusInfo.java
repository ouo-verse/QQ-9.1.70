package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAudioBotStatusInfo {
    public long botId;
    public long botTrtcId;
    public long botUin;
    public long channelId;
    public int detailType;
    public String detailUrl;
    public String statusText;
    public int statusType;

    public GProAudioBotStatusInfo() {
        this.statusText = "";
        this.detailUrl = "";
    }

    public long getBotId() {
        return this.botId;
    }

    public long getBotTrtcId() {
        return this.botTrtcId;
    }

    public long getBotUin() {
        return this.botUin;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getDetailType() {
        return this.detailType;
    }

    public String getDetailUrl() {
        return this.detailUrl;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public int getStatusType() {
        return this.statusType;
    }

    public String toString() {
        return "GProAudioBotStatusInfo{channelId=" + this.channelId + ",botId=" + this.botId + ",botUin=" + this.botUin + ",statusType=" + this.statusType + ",statusText=" + this.statusText + ",detailUrl=" + this.detailUrl + ",detailType=" + this.detailType + ",botTrtcId=" + this.botTrtcId + ",}";
    }

    public GProAudioBotStatusInfo(long j3, long j16, long j17, int i3, String str, String str2, int i16, long j18) {
        this.channelId = j3;
        this.botId = j16;
        this.botUin = j17;
        this.statusType = i3;
        this.statusText = str;
        this.detailUrl = str2;
        this.detailType = i16;
        this.botTrtcId = j18;
    }
}
