package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupExt {
    public int appIdentifierSwitch;
    public int appIdentifierType;
    public long bindGuildId;
    public int blacklistExpireTime;
    public int companyId;
    public int essentialMsgPrivilege;
    public int essentialMsgSwitch;
    public long fullGroupExpansionSeq;
    public int fullGroupExpansionSwitch;
    public long gangUpId;
    public long groupAioBindGuildId;
    public int groupBindGuildSwitch;
    public long groupFlagPro1;
    public int groupInfoExtSeq;
    public int groupSecurityBannedFlag;
    public int groupSquareSwitch;
    public int hasGroupCustomPortrait;
    public int inviteRobotMemberExamine;
    public int inviteRobotMemberSwitch;
    public int inviteRobotSwitch;
    public int isLimitGroupRtc;
    public int lightCharNum;
    public long luckyWordId;
    public int memberChangeGroupNameSwitch;
    public long msgEventSeq;
    public int qqMusicMedalSwitch;
    public int reserve;
    public int showPlayTogetherSwitch;
    public int starId;
    public int todoSeq;
    public long topBannerSeq;
    public long viewedMsgDisappearTime;
    public String luckyWord = "";
    public MemberID groupOwnerId = new MemberID();
    public GuildIdList groupBindGuildIds = new GuildIdList();
    public GroupExtFlameData groupExtFlameData = new GroupExtFlameData();
    public GuildIdList groupExcludeGuildIds = new GuildIdList();
    public GroupExtMedalData groupExtMedalData = new GroupExtMedalData();

    public int getAppIdentifierSwitch() {
        return this.appIdentifierSwitch;
    }

    public int getAppIdentifierType() {
        return this.appIdentifierType;
    }

    public long getBindGuildId() {
        return this.bindGuildId;
    }

    public int getBlacklistExpireTime() {
        return this.blacklistExpireTime;
    }

    public int getCompanyId() {
        return this.companyId;
    }

    public int getEssentialMsgPrivilege() {
        return this.essentialMsgPrivilege;
    }

    public int getEssentialMsgSwitch() {
        return this.essentialMsgSwitch;
    }

    public long getFullGroupExpansionSeq() {
        return this.fullGroupExpansionSeq;
    }

    public int getFullGroupExpansionSwitch() {
        return this.fullGroupExpansionSwitch;
    }

    public long getGangUpId() {
        return this.gangUpId;
    }

    public long getGroupAioBindGuildId() {
        return this.groupAioBindGuildId;
    }

    public GuildIdList getGroupBindGuildIds() {
        return this.groupBindGuildIds;
    }

    public int getGroupBindGuildSwitch() {
        return this.groupBindGuildSwitch;
    }

    public GuildIdList getGroupExcludeGuildIds() {
        return this.groupExcludeGuildIds;
    }

    public GroupExtFlameData getGroupExtFlameData() {
        return this.groupExtFlameData;
    }

    public GroupExtMedalData getGroupExtMedalData() {
        return this.groupExtMedalData;
    }

    public long getGroupFlagPro1() {
        return this.groupFlagPro1;
    }

    public int getGroupInfoExtSeq() {
        return this.groupInfoExtSeq;
    }

    public MemberID getGroupOwnerId() {
        return this.groupOwnerId;
    }

    public int getGroupSecurityBannedFlag() {
        return this.groupSecurityBannedFlag;
    }

    public int getGroupSquareSwitch() {
        return this.groupSquareSwitch;
    }

    public int getHasGroupCustomPortrait() {
        return this.hasGroupCustomPortrait;
    }

    public int getInviteRobotMemberExamine() {
        return this.inviteRobotMemberExamine;
    }

    public int getInviteRobotMemberSwitch() {
        return this.inviteRobotMemberSwitch;
    }

    public int getInviteRobotSwitch() {
        return this.inviteRobotSwitch;
    }

    public int getIsLimitGroupRtc() {
        return this.isLimitGroupRtc;
    }

    public int getLightCharNum() {
        return this.lightCharNum;
    }

    public String getLuckyWord() {
        return this.luckyWord;
    }

    public long getLuckyWordId() {
        return this.luckyWordId;
    }

    public int getMemberChangeGroupNameSwitch() {
        return this.memberChangeGroupNameSwitch;
    }

    public long getMsgEventSeq() {
        return this.msgEventSeq;
    }

    public int getQqMusicMedalSwitch() {
        return this.qqMusicMedalSwitch;
    }

    public int getReserve() {
        return this.reserve;
    }

    public int getShowPlayTogetherSwitch() {
        return this.showPlayTogetherSwitch;
    }

    public int getStarId() {
        return this.starId;
    }

    public int getTodoSeq() {
        return this.todoSeq;
    }

    public long getTopBannerSeq() {
        return this.topBannerSeq;
    }

    public long getViewedMsgDisappearTime() {
        return this.viewedMsgDisappearTime;
    }

    public String toString() {
        return "GroupExt{groupInfoExtSeq=" + this.groupInfoExtSeq + ",reserve=" + this.reserve + ",luckyWordId=" + this.luckyWordId + ",lightCharNum=" + this.lightCharNum + ",luckyWord=" + this.luckyWord + ",starId=" + this.starId + ",essentialMsgSwitch=" + this.essentialMsgSwitch + ",todoSeq=" + this.todoSeq + ",blacklistExpireTime=" + this.blacklistExpireTime + ",isLimitGroupRtc=" + this.isLimitGroupRtc + ",companyId=" + this.companyId + ",hasGroupCustomPortrait=" + this.hasGroupCustomPortrait + ",bindGuildId=" + this.bindGuildId + ",groupOwnerId=" + this.groupOwnerId + ",essentialMsgPrivilege=" + this.essentialMsgPrivilege + ",msgEventSeq=" + this.msgEventSeq + ",inviteRobotSwitch=" + this.inviteRobotSwitch + ",gangUpId=" + this.gangUpId + ",qqMusicMedalSwitch=" + this.qqMusicMedalSwitch + ",showPlayTogetherSwitch=" + this.showPlayTogetherSwitch + ",groupFlagPro1=" + this.groupFlagPro1 + ",groupBindGuildIds=" + this.groupBindGuildIds + ",viewedMsgDisappearTime=" + this.viewedMsgDisappearTime + ",groupExtFlameData=" + this.groupExtFlameData + ",groupBindGuildSwitch=" + this.groupBindGuildSwitch + ",groupAioBindGuildId=" + this.groupAioBindGuildId + ",groupExcludeGuildIds=" + this.groupExcludeGuildIds + ",fullGroupExpansionSwitch=" + this.fullGroupExpansionSwitch + ",fullGroupExpansionSeq=" + this.fullGroupExpansionSeq + ",inviteRobotMemberSwitch=" + this.inviteRobotMemberSwitch + ",inviteRobotMemberExamine=" + this.inviteRobotMemberExamine + ",groupSquareSwitch=" + this.groupSquareSwitch + ",groupSecurityBannedFlag=" + this.groupSecurityBannedFlag + ",groupExtMedalData=" + this.groupExtMedalData + ",memberChangeGroupNameSwitch=" + this.memberChangeGroupNameSwitch + ",appIdentifierSwitch=" + this.appIdentifierSwitch + ",appIdentifierType=" + this.appIdentifierType + ",topBannerSeq=" + this.topBannerSeq + ",}";
    }
}
