package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStUser implements Serializable {
    public long birthday;
    public int blackState;
    public int constellation;
    public int descType;
    public int followState;
    public int frdState;
    public int nickFlag;
    public int relationState;
    public int sex;
    public int type;
    public long uin;
    long serialVersionUID = 1;
    public String idd = "";
    public String nick = "";
    public GProStIconInfo icon = new GProStIconInfo();
    public String desc = "";
    public String school = "";
    public String location = "";
    public byte[] busiData = new byte[0];
    public GProStTagMedalInfo medal = new GProStTagMedalInfo();
    public String jumpUrl = "";
    public String locationCode = "";
    public String thirdId = "";
    public String company = "";
    public String certificationDesc = "";
    public GProChannelUserInfo channelUserInfo = new GProChannelUserInfo();
    public String loginId = "";
    public GProCustomManageTag manageTag = new GProCustomManageTag();
    public GProPersonalMedal personalMedal = new GProPersonalMedal();
    public ArrayList<GProCustomManageTag> userTagList = new ArrayList<>();
    public String avatarPendant = "";

    public String getAvatarPendant() {
        return this.avatarPendant;
    }

    public long getBirthday() {
        return this.birthday;
    }

    public int getBlackState() {
        return this.blackState;
    }

    public byte[] getBusiData() {
        return this.busiData;
    }

    public String getCertificationDesc() {
        return this.certificationDesc;
    }

    public GProChannelUserInfo getChannelUserInfo() {
        return this.channelUserInfo;
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

    public int getFollowState() {
        return this.followState;
    }

    public int getFrdState() {
        return this.frdState;
    }

    public GProStIconInfo getIcon() {
        return this.icon;
    }

    public String getIdd() {
        return this.idd;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getLocation() {
        return this.location;
    }

    public String getLocationCode() {
        return this.locationCode;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public GProCustomManageTag getManageTag() {
        return this.manageTag;
    }

    public GProStTagMedalInfo getMedal() {
        return this.medal;
    }

    public String getNick() {
        return this.nick;
    }

    public int getNickFlag() {
        return this.nickFlag;
    }

    public GProPersonalMedal getPersonalMedal() {
        return this.personalMedal;
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

    public long getUin() {
        return this.uin;
    }

    public ArrayList<GProCustomManageTag> getUserTagList() {
        return this.userTagList;
    }

    public String toString() {
        return "GProStUser{idd=" + this.idd + ",nick=" + this.nick + ",icon=" + this.icon + ",desc=" + this.desc + ",followState=" + this.followState + ",type=" + this.type + ",sex=" + this.sex + ",birthday=" + this.birthday + ",school=" + this.school + ",location=" + this.location + ",busiData=" + this.busiData + ",frdState=" + this.frdState + ",relationState=" + this.relationState + ",blackState=" + this.blackState + ",medal=" + this.medal + ",constellation=" + this.constellation + ",jumpUrl=" + this.jumpUrl + ",locationCode=" + this.locationCode + ",thirdId=" + this.thirdId + ",company=" + this.company + ",certificationDesc=" + this.certificationDesc + ",descType=" + this.descType + ",channelUserInfo=" + this.channelUserInfo + ",loginId=" + this.loginId + ",uin=" + this.uin + ",nickFlag=" + this.nickFlag + ",manageTag=" + this.manageTag + ",personalMedal=" + this.personalMedal + ",userTagList=" + this.userTagList + ",avatarPendant=" + this.avatarPendant + ",}";
    }
}
