package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProChannelMemberInfos implements Serializable {
    public int channelMemberCount;
    public int channelMemberMax;
    public int channelStatus;
    public boolean isActive;
    public int noMemberMaxLimit;
    long serialVersionUID = 1;
    public String guildId = "";
    public String channelId = "";
    public String channelName = "";
    public ArrayList<GProUser> memberList = new ArrayList<>();
    public ArrayList<GProChannelStateItemInfo> channelStateList = new ArrayList<>();
    public GProAVChannelConfig channelConfig = new GProAVChannelConfig();

    public GProAVChannelConfig getChannelConfig() {
        return this.channelConfig;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public int getChannelMemberCount() {
        return this.channelMemberCount;
    }

    public int getChannelMemberMax() {
        return this.channelMemberMax;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public ArrayList<GProChannelStateItemInfo> getChannelStateList() {
        return this.channelStateList;
    }

    public int getChannelStatus() {
        return this.channelStatus;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public ArrayList<GProUser> getMemberList() {
        return this.memberList;
    }

    public int getNoMemberMaxLimit() {
        return this.noMemberMaxLimit;
    }

    public String toString() {
        return "GProChannelMemberInfos{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelName=" + this.channelName + ",noMemberMaxLimit=" + this.noMemberMaxLimit + ",channelMemberMax=" + this.channelMemberMax + ",channelMemberCount=" + this.channelMemberCount + ",memberList=" + this.memberList + ",channelStatus=" + this.channelStatus + ",channelStateList=" + this.channelStateList + ",channelConfig=" + this.channelConfig + ",isActive=" + this.isActive + ",}";
    }
}
