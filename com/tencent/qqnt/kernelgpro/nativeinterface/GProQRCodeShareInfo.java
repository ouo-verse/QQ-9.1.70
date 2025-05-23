package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProQRCodeShareInfo implements Serializable {
    public String OnlineMembersCount;
    public long avTime;
    public String channelCopyWriter;
    public String feedLabel;
    public long feedNum;
    public long gameNum;
    public String guildLabel;
    public long liveNum;
    public String membersCount;
    long serialVersionUID;
    public String streamLabel;
    public String teamLabel;
    public String voiceLabel;

    public GProQRCodeShareInfo() {
        this.serialVersionUID = 1L;
        this.OnlineMembersCount = "";
        this.membersCount = "";
        this.guildLabel = "";
        this.channelCopyWriter = "";
        this.feedLabel = "";
        this.streamLabel = "";
        this.voiceLabel = "";
        this.teamLabel = "";
    }

    public long getAvTime() {
        return this.avTime;
    }

    public String getChannelCopyWriter() {
        return this.channelCopyWriter;
    }

    public String getFeedLabel() {
        return this.feedLabel;
    }

    public long getFeedNum() {
        return this.feedNum;
    }

    public long getGameNum() {
        return this.gameNum;
    }

    public String getGuildLabel() {
        return this.guildLabel;
    }

    public long getLiveNum() {
        return this.liveNum;
    }

    public String getMembersCount() {
        return this.membersCount;
    }

    public String getOnlineMembersCount() {
        return this.OnlineMembersCount;
    }

    public String getStreamLabel() {
        return this.streamLabel;
    }

    public String getTeamLabel() {
        return this.teamLabel;
    }

    public String getVoiceLabel() {
        return this.voiceLabel;
    }

    public String toString() {
        return "GProQRCodeShareInfo{OnlineMembersCount=" + this.OnlineMembersCount + ",membersCount=" + this.membersCount + ",feedNum=" + this.feedNum + ",gameNum=" + this.gameNum + ",liveNum=" + this.liveNum + ",avTime=" + this.avTime + ",guildLabel=" + this.guildLabel + ",channelCopyWriter=" + this.channelCopyWriter + ",feedLabel=" + this.feedLabel + ",streamLabel=" + this.streamLabel + ",voiceLabel=" + this.voiceLabel + ",teamLabel=" + this.teamLabel + ",}";
    }

    public GProQRCodeShareInfo(String str, String str2, long j3, long j16, long j17, long j18, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.serialVersionUID = 1L;
        this.OnlineMembersCount = str;
        this.membersCount = str2;
        this.feedNum = j3;
        this.gameNum = j16;
        this.liveNum = j17;
        this.avTime = j18;
        this.guildLabel = str3;
        this.channelCopyWriter = str4;
        this.feedLabel = str5;
        this.streamLabel = str6;
        this.voiceLabel = str7;
        this.teamLabel = str8;
    }
}
