package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCmd0xf67RspBody {
    public int qqMsgInList;
    public long tinyid;
    public GProSecurityResult secRet = new GProSecurityResult();
    public ArrayList<GProJoinGuildResult> joinedGuildsResultList = new ArrayList<>();
    public GProCmd0xf5dGuildInfo guildChannels = new GProCmd0xf5dGuildInfo();
    public GProGuild guildInfo = new GProGuild();

    public GProCmd0xf5dGuildInfo getGuildChannels() {
        return this.guildChannels;
    }

    public GProGuild getGuildInfo() {
        return this.guildInfo;
    }

    public ArrayList<GProJoinGuildResult> getJoinedGuildsResultList() {
        return this.joinedGuildsResultList;
    }

    public int getQqMsgInList() {
        return this.qqMsgInList;
    }

    public GProSecurityResult getSecRet() {
        return this.secRet;
    }

    public long getTinyid() {
        return this.tinyid;
    }

    public String toString() {
        return "GProCmd0xf67RspBody{secRet=" + this.secRet + ",tinyid=" + this.tinyid + ",joinedGuildsResultList=" + this.joinedGuildsResultList + ",guildChannels=" + this.guildChannels + ",guildInfo=" + this.guildInfo + ",qqMsgInList=" + this.qqMsgInList + ",}";
    }
}
