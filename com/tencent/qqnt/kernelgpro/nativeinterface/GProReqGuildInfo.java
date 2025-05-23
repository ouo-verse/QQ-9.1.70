package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProReqGuildInfo {
    public long guildCode;
    public long guildId;
    public long invitorUin;
    public ArrayList<Long> channelIds = new ArrayList<>();
    public String guildNum = "";

    public ArrayList<Long> getChannelIds() {
        return this.channelIds;
    }

    public long getGuildCode() {
        return this.guildCode;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildNum() {
        return this.guildNum;
    }

    public long getInvitorUin() {
        return this.invitorUin;
    }

    public String toString() {
        return "GProReqGuildInfo{guildId=" + this.guildId + ",guildCode=" + this.guildCode + ",invitorUin=" + this.invitorUin + ",channelIds=" + this.channelIds + ",guildNum=" + this.guildNum + ",}";
    }
}
