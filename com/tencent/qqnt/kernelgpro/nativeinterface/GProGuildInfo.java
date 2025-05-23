package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildInfo implements Serializable {
    public int allowSearch;
    public GProMsgSeq authChannelChangeSeq;
    public long bannedTimeLimit;
    public long changeNameInterval;
    public long changeRuleInterval;
    public GProMsgSeq channelChangeSeq;
    public int clientId;
    public int coverFontColorId;
    public long coverSeq;
    public long createTime;
    public GProDirectMsgThreshold directMsgThreshold;
    public GProExtendInfo extendInfo;
    public long faceSeq;
    public long groupId;
    public GProGuildAuditInfo guildAuditInfo;
    public int guildCanShare;
    public long guildCode;
    public GProGuildGlobalAuthInfo guildGlobalAuthInfo;
    public GProMsgSeq guildInfoChangeSeq;
    public String guildName;
    public long guildNameChangeTime;
    public int guildNumSearch;
    public String guildNumber;
    public GProMsgSeq guildPermissionChanngeSeq;
    public ArrayList<GProGuildAuditBaseItem> guildRules;
    public GProGuildSafetyRisk guildSafetyRisk;
    public int guildSignInNotify;
    public GProGroupProStatus guildStatus;
    public int guildType;
    public boolean isGroupGuild;
    public int isVisibleForVisitor;
    public int joinGuildOption;
    public GProJumpInfo jumpInfo;
    public int keywordSearchSwitch;
    public int medalLevel;
    public ArrayList<GProMedalInfo> medals;
    public int memberNum;
    public ArrayList<GProNavigationInfo> navigations;
    public long ownerTinyid;
    public String profile;
    public int qrCodePeriod;
    public int qrCodeSwitch;
    public GProMsgSeq roleChangeSeq;
    long serialVersionUID;
    public long shutupExpireTime;
    public GProSpeakThreshold speakThreshold;
    public int supportRecommendSwitch;
    public GProTagInfo tagInfo;
    public int topicSquareSwitch;
    public long uint32GuildRuleChangeTime;
    public int visitorInteractionAllSwitch;
    public int vistorFaceDistinguish;
    public int vistorInteraction;

    public GProGuildInfo() {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.profile = "";
        this.guildStatus = new GProGroupProStatus();
        this.guildNumber = "";
        this.speakThreshold = new GProSpeakThreshold();
        this.directMsgThreshold = new GProDirectMsgThreshold();
        this.extendInfo = new GProExtendInfo();
        this.navigations = new ArrayList<>();
        this.jumpInfo = new GProJumpInfo();
        this.medals = new ArrayList<>();
        this.tagInfo = new GProTagInfo();
        this.guildAuditInfo = new GProGuildAuditInfo();
        this.guildRules = new ArrayList<>();
        this.guildGlobalAuthInfo = new GProGuildGlobalAuthInfo();
        this.guildSafetyRisk = new GProGuildSafetyRisk();
        this.guildInfoChangeSeq = new GProMsgSeq();
        this.channelChangeSeq = new GProMsgSeq();
        this.roleChangeSeq = new GProMsgSeq();
        this.authChannelChangeSeq = new GProMsgSeq();
        this.guildPermissionChanngeSeq = new GProMsgSeq();
    }

    public int getAllowSearch() {
        return this.allowSearch;
    }

    public GProMsgSeq getAuthChannelChangeSeq() {
        return this.authChannelChangeSeq;
    }

    public long getBannedTimeLimit() {
        return this.bannedTimeLimit;
    }

    public long getChangeNameInterval() {
        return this.changeNameInterval;
    }

    public long getChangeRuleInterval() {
        return this.changeRuleInterval;
    }

    public GProMsgSeq getChannelChangeSeq() {
        return this.channelChangeSeq;
    }

    public int getClientId() {
        return this.clientId;
    }

    public int getCoverFontColorId() {
        return this.coverFontColorId;
    }

    public long getCoverSeq() {
        return this.coverSeq;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public GProDirectMsgThreshold getDirectMsgThreshold() {
        return this.directMsgThreshold;
    }

    public GProExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public long getFaceSeq() {
        return this.faceSeq;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public GProGuildAuditInfo getGuildAuditInfo() {
        return this.guildAuditInfo;
    }

    public int getGuildCanShare() {
        return this.guildCanShare;
    }

    public long getGuildCode() {
        return this.guildCode;
    }

    public GProGuildGlobalAuthInfo getGuildGlobalAuthInfo() {
        return this.guildGlobalAuthInfo;
    }

    public GProMsgSeq getGuildInfoChangeSeq() {
        return this.guildInfoChangeSeq;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public long getGuildNameChangeTime() {
        return this.guildNameChangeTime;
    }

    public int getGuildNumSearch() {
        return this.guildNumSearch;
    }

    public String getGuildNumber() {
        return this.guildNumber;
    }

    public GProMsgSeq getGuildPermissionChanngeSeq() {
        return this.guildPermissionChanngeSeq;
    }

    public ArrayList<GProGuildAuditBaseItem> getGuildRules() {
        return this.guildRules;
    }

    public GProGuildSafetyRisk getGuildSafetyRisk() {
        return this.guildSafetyRisk;
    }

    public int getGuildSignInNotify() {
        return this.guildSignInNotify;
    }

    public GProGroupProStatus getGuildStatus() {
        return this.guildStatus;
    }

    public int getGuildType() {
        return this.guildType;
    }

    public boolean getIsGroupGuild() {
        return this.isGroupGuild;
    }

    public int getIsVisibleForVisitor() {
        return this.isVisibleForVisitor;
    }

    public int getJoinGuildOption() {
        return this.joinGuildOption;
    }

    public GProJumpInfo getJumpInfo() {
        return this.jumpInfo;
    }

    public int getKeywordSearchSwitch() {
        return this.keywordSearchSwitch;
    }

    public int getMedalLevel() {
        return this.medalLevel;
    }

    public ArrayList<GProMedalInfo> getMedals() {
        return this.medals;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public ArrayList<GProNavigationInfo> getNavigations() {
        return this.navigations;
    }

    public long getOwnerTinyid() {
        return this.ownerTinyid;
    }

    public String getProfile() {
        return this.profile;
    }

    public int getQrCodePeriod() {
        return this.qrCodePeriod;
    }

    public int getQrCodeSwitch() {
        return this.qrCodeSwitch;
    }

    public GProMsgSeq getRoleChangeSeq() {
        return this.roleChangeSeq;
    }

    public long getShutupExpireTime() {
        return this.shutupExpireTime;
    }

    public GProSpeakThreshold getSpeakThreshold() {
        return this.speakThreshold;
    }

    public int getSupportRecommendSwitch() {
        return this.supportRecommendSwitch;
    }

    public GProTagInfo getTagInfo() {
        return this.tagInfo;
    }

    public int getTopicSquareSwitch() {
        return this.topicSquareSwitch;
    }

    public long getUint32GuildRuleChangeTime() {
        return this.uint32GuildRuleChangeTime;
    }

    public int getVisitorInteractionAllSwitch() {
        return this.visitorInteractionAllSwitch;
    }

    public int getVistorFaceDistinguish() {
        return this.vistorFaceDistinguish;
    }

    public int getVistorInteraction() {
        return this.vistorInteraction;
    }

    public String toString() {
        return "GProGuildInfo{guildCode=" + this.guildCode + ",createTime=" + this.createTime + ",memberNum=" + this.memberNum + ",guildType=" + this.guildType + ",guildName=" + this.guildName + ",profile=" + this.profile + ",faceSeq=" + this.faceSeq + ",guildStatus=" + this.guildStatus + ",ownerTinyid=" + this.ownerTinyid + ",coverSeq=" + this.coverSeq + ",clientId=" + this.clientId + ",shutupExpireTime=" + this.shutupExpireTime + ",bannedTimeLimit=" + this.bannedTimeLimit + ",coverFontColorId=" + this.coverFontColorId + ",guildCanShare=" + this.guildCanShare + ",qrCodePeriod=" + this.qrCodePeriod + ",guildNumber=" + this.guildNumber + ",guildNameChangeTime=" + this.guildNameChangeTime + ",allowSearch=" + this.allowSearch + ",keywordSearchSwitch=" + this.keywordSearchSwitch + ",isVisibleForVisitor=" + this.isVisibleForVisitor + ",speakThreshold=" + this.speakThreshold + ",directMsgThreshold=" + this.directMsgThreshold + ",extendInfo=" + this.extendInfo + ",navigations=" + this.navigations + ",jumpInfo=" + this.jumpInfo + ",vistorFaceDistinguish=" + this.vistorFaceDistinguish + ",vistorInteraction=" + this.vistorInteraction + ",medals=" + this.medals + ",topicSquareSwitch=" + this.topicSquareSwitch + ",groupId=" + this.groupId + ",isGroupGuild=" + this.isGroupGuild + ",tagInfo=" + this.tagInfo + ",qrCodeSwitch=" + this.qrCodeSwitch + ",visitorInteractionAllSwitch=" + this.visitorInteractionAllSwitch + ",guildSignInNotify=" + this.guildSignInNotify + ",guildAuditInfo=" + this.guildAuditInfo + ",supportRecommendSwitch=" + this.supportRecommendSwitch + ",guildRules=" + this.guildRules + ",uint32GuildRuleChangeTime=" + this.uint32GuildRuleChangeTime + ",guildNumSearch=" + this.guildNumSearch + ",guildGlobalAuthInfo=" + this.guildGlobalAuthInfo + ",guildSafetyRisk=" + this.guildSafetyRisk + ",guildInfoChangeSeq=" + this.guildInfoChangeSeq + ",channelChangeSeq=" + this.channelChangeSeq + ",roleChangeSeq=" + this.roleChangeSeq + ",authChannelChangeSeq=" + this.authChannelChangeSeq + ",guildPermissionChanngeSeq=" + this.guildPermissionChanngeSeq + ",medalLevel=" + this.medalLevel + ",joinGuildOption=" + this.joinGuildOption + ",changeNameInterval=" + this.changeNameInterval + ",changeRuleInterval=" + this.changeRuleInterval + ",}";
    }

    public GProGuildInfo(long j3, int i3, String str, String str2, long j16, GProGroupProStatus gProGroupProStatus, long j17, long j18, int i16, long j19, long j26, int i17, int i18, int i19, String str3, long j27, int i26, int i27, int i28, GProSpeakThreshold gProSpeakThreshold, GProDirectMsgThreshold gProDirectMsgThreshold, GProExtendInfo gProExtendInfo, ArrayList<GProNavigationInfo> arrayList, GProJumpInfo gProJumpInfo, int i29, int i36, ArrayList<GProMedalInfo> arrayList2, int i37, long j28, boolean z16, GProTagInfo gProTagInfo, int i38, int i39, GProMsgSeq gProMsgSeq, GProMsgSeq gProMsgSeq2, GProMsgSeq gProMsgSeq3, GProMsgSeq gProMsgSeq4, GProMsgSeq gProMsgSeq5, int i46, long j29) {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.profile = "";
        this.guildStatus = new GProGroupProStatus();
        this.guildNumber = "";
        this.speakThreshold = new GProSpeakThreshold();
        this.directMsgThreshold = new GProDirectMsgThreshold();
        this.extendInfo = new GProExtendInfo();
        this.navigations = new ArrayList<>();
        this.jumpInfo = new GProJumpInfo();
        this.medals = new ArrayList<>();
        this.tagInfo = new GProTagInfo();
        this.guildAuditInfo = new GProGuildAuditInfo();
        this.guildRules = new ArrayList<>();
        this.guildGlobalAuthInfo = new GProGuildGlobalAuthInfo();
        this.guildSafetyRisk = new GProGuildSafetyRisk();
        this.guildInfoChangeSeq = new GProMsgSeq();
        this.channelChangeSeq = new GProMsgSeq();
        this.roleChangeSeq = new GProMsgSeq();
        this.authChannelChangeSeq = new GProMsgSeq();
        new GProMsgSeq();
        this.guildCode = j3;
        this.memberNum = i3;
        this.guildName = str;
        this.profile = str2;
        this.faceSeq = j16;
        this.guildStatus = gProGroupProStatus;
        this.ownerTinyid = j17;
        this.coverSeq = j18;
        this.clientId = i16;
        this.shutupExpireTime = j19;
        this.bannedTimeLimit = j26;
        this.coverFontColorId = i17;
        this.guildCanShare = i18;
        this.qrCodePeriod = i19;
        this.guildNumber = str3;
        this.guildNameChangeTime = j27;
        this.allowSearch = i26;
        this.keywordSearchSwitch = i27;
        this.isVisibleForVisitor = i28;
        this.speakThreshold = gProSpeakThreshold;
        this.directMsgThreshold = gProDirectMsgThreshold;
        this.extendInfo = gProExtendInfo;
        this.navigations = arrayList;
        this.jumpInfo = gProJumpInfo;
        this.vistorFaceDistinguish = i29;
        this.vistorInteraction = i36;
        this.medals = arrayList2;
        this.topicSquareSwitch = i37;
        this.groupId = j28;
        this.isGroupGuild = z16;
        this.tagInfo = gProTagInfo;
        this.qrCodeSwitch = i38;
        this.visitorInteractionAllSwitch = i39;
        this.guildInfoChangeSeq = gProMsgSeq;
        this.channelChangeSeq = gProMsgSeq2;
        this.roleChangeSeq = gProMsgSeq3;
        this.authChannelChangeSeq = gProMsgSeq4;
        this.guildPermissionChanngeSeq = gProMsgSeq5;
        this.medalLevel = i46;
        this.changeNameInterval = j29;
    }
}
