package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCmd0xf5aGuildInfo {
    public long bannedTimeLimit;
    public long channel;
    public int channelType;
    public long guildId;
    public int guildMemberNum;
    public String guildName = "";
    public String avatar = "";
    public String joinGuildSig = "";
    public String inviteUrl = "";
    public String profile = "";
    public String guildNumber = "";

    public String getAvatar() {
        return this.avatar;
    }

    public long getBannedTimeLimit() {
        return this.bannedTimeLimit;
    }

    public long getChannel() {
        return this.channel;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getGuildMemberNum() {
        return this.guildMemberNum;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getGuildNumber() {
        return this.guildNumber;
    }

    public String getInviteUrl() {
        return this.inviteUrl;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public String getProfile() {
        return this.profile;
    }

    public String toString() {
        return "GProCmd0xf5aGuildInfo{guildId=" + this.guildId + ",guildName=" + this.guildName + ",avatar=" + this.avatar + ",channel=" + this.channel + ",joinGuildSig=" + this.joinGuildSig + ",inviteUrl=" + this.inviteUrl + ",profile=" + this.profile + ",channelType=" + this.channelType + ",guildNumber=" + this.guildNumber + ",bannedTimeLimit=" + this.bannedTimeLimit + ",guildMemberNum=" + this.guildMemberNum + ",}";
    }
}
