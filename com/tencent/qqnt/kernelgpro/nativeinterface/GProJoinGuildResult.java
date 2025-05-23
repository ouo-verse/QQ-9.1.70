package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProJoinGuildResult implements Serializable {
    public long guildId;
    public int openTab;
    public int qqMsgInList;
    public int retCode;
    long serialVersionUID = 1;
    public GProSecurityResult secRet = new GProSecurityResult();
    public GProCmd0xf5dGuildInfo guildChannels = new GProCmd0xf5dGuildInfo();
    public GProGuild guildInfo = new GProGuild();

    public GProCmd0xf5dGuildInfo getGuildChannels() {
        return this.guildChannels;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProGuild getGuildInfo() {
        return this.guildInfo;
    }

    public int getOpenTab() {
        return this.openTab;
    }

    public int getQqMsgInList() {
        return this.qqMsgInList;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public GProSecurityResult getSecRet() {
        return this.secRet;
    }

    public String toString() {
        return "GProJoinGuildResult{secRet=" + this.secRet + ",guildId=" + this.guildId + ",retCode=" + this.retCode + ",guildChannels=" + this.guildChannels + ",guildInfo=" + this.guildInfo + ",qqMsgInList=" + this.qqMsgInList + ",openTab=" + this.openTab + ",}";
    }
}
