package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0xf5aGuildInfo;

/* loaded from: classes17.dex */
public class GGProCmd0xf5aGuildInfo implements IGProCmd0xf5aGuildInfo {
    public final GProCmd0xf5aGuildInfo mInfo;

    public GGProCmd0xf5aGuildInfo(GProCmd0xf5aGuildInfo gProCmd0xf5aGuildInfo) {
        this.mInfo = gProCmd0xf5aGuildInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public long getBannedTimeLimit() {
        return this.mInfo.getBannedTimeLimit();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public long getChannel() {
        return this.mInfo.getChannel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public int getChannelType() {
        return this.mInfo.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public int getGuildMemberNum() {
        return this.mInfo.getGuildMemberNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public String getGuildNumber() {
        return this.mInfo.getGuildNumber();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public String getInviteUrl() {
        return this.mInfo.getInviteUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public String getJoinGuildSig() {
        return this.mInfo.getJoinGuildSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public String getProfile() {
        return this.mInfo.getProfile();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
