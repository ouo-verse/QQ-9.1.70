package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFeedGuildInfo implements Serializable {
    public long channelId;
    public String guildIcon;
    public long guildId;
    public String guildName;
    public String joinGuildSig;
    public ArrayList<GProMedalInfo> medals;
    long serialVersionUID;

    public GProFeedGuildInfo() {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        this.joinGuildSig = "";
        this.medals = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getGuildIcon() {
        return this.guildIcon;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public ArrayList<GProMedalInfo> getMedals() {
        return this.medals;
    }

    public String toString() {
        return "GProFeedGuildInfo{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildIcon=" + this.guildIcon + ",joinGuildSig=" + this.joinGuildSig + ",channelId=" + this.channelId + ",medals=" + this.medals + ",}";
    }

    public GProFeedGuildInfo(long j3, String str, String str2, String str3, long j16, ArrayList<GProMedalInfo> arrayList) {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        this.joinGuildSig = "";
        new ArrayList();
        this.guildId = j3;
        this.guildName = str;
        this.guildIcon = str2;
        this.joinGuildSig = str3;
        this.channelId = j16;
        this.medals = arrayList;
    }
}
