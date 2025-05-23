package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProUserGiftRankInfo implements Serializable {
    public long channelId;
    public long guildId;
    public String jumpUrl;
    public String rankInfo;
    long serialVersionUID;
    public int topNum;
    public GProUser userInfo;

    public GProUserGiftRankInfo() {
        this.serialVersionUID = 1L;
        this.userInfo = new GProUser();
        this.rankInfo = "";
        this.jumpUrl = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getRankInfo() {
        return this.rankInfo;
    }

    public int getTopNum() {
        return this.topNum;
    }

    public GProUser getUserInfo() {
        return this.userInfo;
    }

    public String toString() {
        return "GProUserGiftRankInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",userInfo=" + this.userInfo + ",rankInfo=" + this.rankInfo + ",topNum=" + this.topNum + ",jumpUrl=" + this.jumpUrl + ",}";
    }

    public GProUserGiftRankInfo(long j3, long j16, GProUser gProUser, String str, int i3, String str2) {
        this.serialVersionUID = 1L;
        new GProUser();
        this.guildId = j3;
        this.channelId = j16;
        this.userInfo = gProUser;
        this.rankInfo = str;
        this.topNum = i3;
        this.jumpUrl = str2;
    }
}
