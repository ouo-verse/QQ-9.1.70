package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsStUser {
    public long birthday;
    public int blackState;
    public int constellation;
    public int descType;
    public long fansCount;
    public long followCount;
    public int followState;
    public int frdState;
    public long fuelCount;
    public boolean isUserInLivingStatus;
    public int label;
    public long levelBenefit;
    public int newAddedFansCount;
    public int relationState;
    public int sex;
    public int type;
    public long visitorCount;
    public String userId = "";
    public String nick = "";
    public UfsStIconInfo icon = new UfsStIconInfo();
    public String desc = "";
    public String school = "";
    public String location = "";
    public byte[] busiData = new byte[0];
    public UfsStTagMedalInfo medal = new UfsStTagMedalInfo();
    public String jumpUrl = "";
    public String locationCode = "";
    public String thirdId = "";
    public String company = "";
    public String certificationDesc = "";
    public String rawNick = "";
    public UfsStIconDecorate iconDecorate = new UfsStIconDecorate();
    public byte[] busiReport = new byte[0];
    public String euid = "";
    public UfsStGuildStateInfo guildState = new UfsStGuildStateInfo();
    public String loginIpLocation = "";
    public byte[] qqVip = new byte[0];
    public String mcnName = "";
    public String levelBenefitIcon = "";

    public long getBirthday() {
        return this.birthday;
    }

    public int getBlackState() {
        return this.blackState;
    }

    public byte[] getBusiData() {
        return this.busiData;
    }

    public byte[] getBusiReport() {
        return this.busiReport;
    }

    public String getCertificationDesc() {
        return this.certificationDesc;
    }

    public String getCompany() {
        return this.company;
    }

    public int getConstellation() {
        return this.constellation;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getDescType() {
        return this.descType;
    }

    public String getEuid() {
        return this.euid;
    }

    public long getFansCount() {
        return this.fansCount;
    }

    public long getFollowCount() {
        return this.followCount;
    }

    public int getFollowState() {
        return this.followState;
    }

    public int getFrdState() {
        return this.frdState;
    }

    public long getFuelCount() {
        return this.fuelCount;
    }

    public UfsStGuildStateInfo getGuildState() {
        return this.guildState;
    }

    public UfsStIconInfo getIcon() {
        return this.icon;
    }

    public UfsStIconDecorate getIconDecorate() {
        return this.iconDecorate;
    }

    public boolean getIsUserInLivingStatus() {
        return this.isUserInLivingStatus;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getLabel() {
        return this.label;
    }

    public long getLevelBenefit() {
        return this.levelBenefit;
    }

    public String getLevelBenefitIcon() {
        return this.levelBenefitIcon;
    }

    public String getLocation() {
        return this.location;
    }

    public String getLocationCode() {
        return this.locationCode;
    }

    public String getLoginIpLocation() {
        return this.loginIpLocation;
    }

    public String getMcnName() {
        return this.mcnName;
    }

    public UfsStTagMedalInfo getMedal() {
        return this.medal;
    }

    public int getNewAddedFansCount() {
        return this.newAddedFansCount;
    }

    public String getNick() {
        return this.nick;
    }

    public byte[] getQqVip() {
        return this.qqVip;
    }

    public String getRawNick() {
        return this.rawNick;
    }

    public int getRelationState() {
        return this.relationState;
    }

    public String getSchool() {
        return this.school;
    }

    public int getSex() {
        return this.sex;
    }

    public String getThirdId() {
        return this.thirdId;
    }

    public int getType() {
        return this.type;
    }

    public String getUserId() {
        return this.userId;
    }

    public long getVisitorCount() {
        return this.visitorCount;
    }

    public String toString() {
        return "UfsStUser{userId=" + this.userId + ",nick=" + this.nick + ",icon=" + this.icon + ",desc=" + this.desc + ",followState=" + this.followState + ",type=" + this.type + ",sex=" + this.sex + ",birthday=" + this.birthday + ",school=" + this.school + ",location=" + this.location + ",busiData=" + this.busiData + ",frdState=" + this.frdState + ",relationState=" + this.relationState + ",blackState=" + this.blackState + ",medal=" + this.medal + ",constellation=" + this.constellation + ",jumpUrl=" + this.jumpUrl + ",locationCode=" + this.locationCode + ",thirdId=" + this.thirdId + ",company=" + this.company + ",certificationDesc=" + this.certificationDesc + ",descType=" + this.descType + ",isUserInLivingStatus=" + this.isUserInLivingStatus + ",rawNick=" + this.rawNick + ",iconDecorate=" + this.iconDecorate + ",busiReport=" + this.busiReport + ",label=" + this.label + ",followCount=" + this.followCount + ",fansCount=" + this.fansCount + ",fuelCount=" + this.fuelCount + ",visitorCount=" + this.visitorCount + ",newAddedFansCount=" + this.newAddedFansCount + ",euid=" + this.euid + ",guildState=" + this.guildState + ",loginIpLocation=" + this.loginIpLocation + ",qqVip=" + this.qqVip + ",mcnName=" + this.mcnName + ",levelBenefit=" + this.levelBenefit + ",levelBenefitIcon=" + this.levelBenefitIcon + ",}";
    }
}
