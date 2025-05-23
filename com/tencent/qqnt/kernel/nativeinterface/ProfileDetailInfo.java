package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class ProfileDetailInfo {
    public String address;
    public String avatarUrl;
    public int birthdayDay;
    public int birthdayMonth;
    public int birthdayYear;
    public String city;
    public String college;
    public int constellation;
    public String country;
    public int disableEmojiShortCuts;
    public String eMail;
    public int extStatus;
    public String homeTown;
    public String interest;
    public boolean isBlock;
    public int isHidePrivilegeIcon;
    public int isHideQQLevel;
    public boolean isSpecialCareOpen;
    public boolean isSpecialCareZone;
    public int kBloodType;
    public ArrayList<String> labels;
    public String longNick;
    public int makeFriendCareer;
    public String nick;
    public String phoneNum;
    public ProfilePicInfo photoWall;
    public String pos;
    public String postCode;
    public PrivilegeIcon privilegeIcon;
    public String province;
    public String qid;
    public int qidianCrewFlag;
    public int qidianCrewFlag2;
    public int qidianMasterFlag;
    public QQLevel qqLevel;
    public int recommendImgFlag;
    public int regTime;
    public String remark;
    public String ringId;
    public int sex;
    public int shengXiao;
    public int status;
    public boolean svipFlag;
    public int termType;
    public long topTime;
    public String uid;
    public long uin;
    public boolean vipFlag;
    public int vipLevel;
    public boolean yearVipFlag;

    public ProfileDetailInfo() {
        this.uid = "";
        this.qid = "";
        this.nick = "";
        this.remark = "";
        this.longNick = "";
        this.avatarUrl = "";
        this.homeTown = "";
        this.pos = "";
        this.eMail = "";
        this.phoneNum = "";
        this.college = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.postCode = "";
        this.address = "";
        this.ringId = "";
        this.interest = "";
        this.labels = new ArrayList<>();
        this.qqLevel = new QQLevel();
        this.privilegeIcon = new PrivilegeIcon();
        this.photoWall = new ProfilePicInfo();
    }

    public String getAddress() {
        return this.address;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getBirthdayDay() {
        return this.birthdayDay;
    }

    public int getBirthdayMonth() {
        return this.birthdayMonth;
    }

    public int getBirthdayYear() {
        return this.birthdayYear;
    }

    public String getCity() {
        return this.city;
    }

    public String getCollege() {
        return this.college;
    }

    public int getConstellation() {
        return this.constellation;
    }

    public String getCountry() {
        return this.country;
    }

    public int getDisableEmojiShortCuts() {
        return this.disableEmojiShortCuts;
    }

    public String getEMail() {
        return this.eMail;
    }

    public int getExtStatus() {
        return this.extStatus;
    }

    public String getHomeTown() {
        return this.homeTown;
    }

    public String getInterest() {
        return this.interest;
    }

    public boolean getIsBlock() {
        return this.isBlock;
    }

    public int getIsHidePrivilegeIcon() {
        return this.isHidePrivilegeIcon;
    }

    public int getIsHideQQLevel() {
        return this.isHideQQLevel;
    }

    public boolean getIsSpecialCareOpen() {
        return this.isSpecialCareOpen;
    }

    public boolean getIsSpecialCareZone() {
        return this.isSpecialCareZone;
    }

    public int getKBloodType() {
        return this.kBloodType;
    }

    public ArrayList<String> getLabels() {
        return this.labels;
    }

    public String getLongNick() {
        return this.longNick;
    }

    public int getMakeFriendCareer() {
        return this.makeFriendCareer;
    }

    public String getNick() {
        return this.nick;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public ProfilePicInfo getPhotoWall() {
        return this.photoWall;
    }

    public String getPos() {
        return this.pos;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public PrivilegeIcon getPrivilegeIcon() {
        return this.privilegeIcon;
    }

    public String getProvince() {
        return this.province;
    }

    public String getQid() {
        return this.qid;
    }

    public int getQidianCrewFlag() {
        return this.qidianCrewFlag;
    }

    public int getQidianCrewFlag2() {
        return this.qidianCrewFlag2;
    }

    public int getQidianMasterFlag() {
        return this.qidianMasterFlag;
    }

    public QQLevel getQqLevel() {
        return this.qqLevel;
    }

    public int getRecommendImgFlag() {
        return this.recommendImgFlag;
    }

    public int getRegTime() {
        return this.regTime;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getRingId() {
        return this.ringId;
    }

    public int getSex() {
        return this.sex;
    }

    public int getShengXiao() {
        return this.shengXiao;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean getSvipFlag() {
        return this.svipFlag;
    }

    public int getTermType() {
        return this.termType;
    }

    public long getTopTime() {
        return this.topTime;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public boolean getVipFlag() {
        return this.vipFlag;
    }

    public int getVipLevel() {
        return this.vipLevel;
    }

    public boolean getYearVipFlag() {
        return this.yearVipFlag;
    }

    public ProfileDetailInfo(String str, String str2, long j3, String str3, String str4, String str5, String str6, int i3, int i16, int i17, int i18, long j16, int i19, int i26, int i27, String str7, int i28, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, boolean z16, boolean z17, boolean z18, String str17, int i29, String str18, int i36, ArrayList<String> arrayList, QQLevel qQLevel, int i37, PrivilegeIcon privilegeIcon, int i38, ProfilePicInfo profilePicInfo, boolean z19, boolean z26, boolean z27, int i39, int i46, int i47, int i48, int i49, int i56, int i57, int i58) {
        this.uid = "";
        this.qid = "";
        this.nick = "";
        this.remark = "";
        this.longNick = "";
        this.avatarUrl = "";
        this.homeTown = "";
        this.pos = "";
        this.eMail = "";
        this.phoneNum = "";
        this.college = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.postCode = "";
        this.address = "";
        this.ringId = "";
        this.interest = "";
        this.labels = new ArrayList<>();
        this.qqLevel = new QQLevel();
        this.privilegeIcon = new PrivilegeIcon();
        new ProfilePicInfo();
        this.uid = str;
        this.qid = str2;
        this.uin = j3;
        this.nick = str3;
        this.remark = str4;
        this.longNick = str5;
        this.avatarUrl = str6;
        this.birthdayYear = i3;
        this.birthdayMonth = i16;
        this.birthdayDay = i17;
        this.sex = i18;
        this.topTime = j16;
        this.constellation = i19;
        this.shengXiao = i26;
        this.kBloodType = i27;
        this.homeTown = str7;
        this.makeFriendCareer = i28;
        this.pos = str8;
        this.eMail = str9;
        this.phoneNum = str10;
        this.college = str11;
        this.country = str12;
        this.province = str13;
        this.city = str14;
        this.postCode = str15;
        this.address = str16;
        this.isBlock = z16;
        this.isSpecialCareOpen = z17;
        this.isSpecialCareZone = z18;
        this.ringId = str17;
        this.regTime = i29;
        this.interest = str18;
        this.termType = i36;
        this.labels = arrayList;
        this.qqLevel = qQLevel;
        this.isHideQQLevel = i37;
        this.privilegeIcon = privilegeIcon;
        this.isHidePrivilegeIcon = i38;
        this.photoWall = profilePicInfo;
        this.vipFlag = z19;
        this.yearVipFlag = z26;
        this.svipFlag = z27;
        this.vipLevel = i39;
        this.status = i46;
        this.qidianMasterFlag = i47;
        this.qidianCrewFlag = i48;
        this.qidianCrewFlag2 = i49;
        this.extStatus = i56;
        this.recommendImgFlag = i57;
        this.disableEmojiShortCuts = i58;
    }
}
