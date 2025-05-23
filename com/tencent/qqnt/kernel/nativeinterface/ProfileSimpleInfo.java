package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class ProfileSimpleInfo {
    public String avatarUrl;
    public int birthdayDay;
    public int birthdayMonth;
    public int birthdayYear;
    public int categoryId;
    public int extStatus;
    public boolean isBlock;
    public boolean isMsgDisturb;
    public boolean isSpecialCareOpen;
    public boolean isSpecialCareZone;
    public boolean isZPlanCoupleOpen;
    public String longNick;
    public String nick;
    public boolean onlyChat;
    public String qid;
    public int qidianCrewFlag;
    public int qidianCrewFlag2;
    public int qidianMasterFlag;
    public boolean qzoneNotWatch;
    public boolean qzoneNotWatched;
    public String remark;
    public String ringId;
    public int sex;
    public int status;
    public int studyFlag;
    public boolean svipFlag;
    public int teenagerFlag;
    public long topTime;
    public String uid;
    public long uin;
    public boolean vipFlag;
    public int vipLevel;
    public boolean yearVipFlag;
    public int zplanCoupleSceneId;

    public ProfileSimpleInfo() {
        this.uid = "";
        this.qid = "";
        this.nick = "";
        this.remark = "";
        this.longNick = "";
        this.avatarUrl = "";
        this.ringId = "";
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

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getExtStatus() {
        return this.extStatus;
    }

    public boolean getIsBlock() {
        return this.isBlock;
    }

    public boolean getIsMsgDisturb() {
        return this.isMsgDisturb;
    }

    public boolean getIsSpecialCareOpen() {
        return this.isSpecialCareOpen;
    }

    public boolean getIsSpecialCareZone() {
        return this.isSpecialCareZone;
    }

    public boolean getIsZPlanCoupleOpen() {
        return this.isZPlanCoupleOpen;
    }

    public String getLongNick() {
        return this.longNick;
    }

    public String getNick() {
        return this.nick;
    }

    public boolean getOnlyChat() {
        return this.onlyChat;
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

    public boolean getQzoneNotWatch() {
        return this.qzoneNotWatch;
    }

    public boolean getQzoneNotWatched() {
        return this.qzoneNotWatched;
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

    public int getStatus() {
        return this.status;
    }

    public int getStudyFlag() {
        return this.studyFlag;
    }

    public boolean getSvipFlag() {
        return this.svipFlag;
    }

    public int getTeenagerFlag() {
        return this.teenagerFlag;
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

    public int getZplanCoupleSceneId() {
        return this.zplanCoupleSceneId;
    }

    public ProfileSimpleInfo(String str, String str2, long j3, String str3, String str4, String str5, String str6, int i3, int i16, int i17, int i18, long j16, boolean z16, boolean z17, boolean z18, boolean z19, String str7, int i19, int i26, int i27, int i28, int i29, int i36, boolean z26, boolean z27, boolean z28, boolean z29, boolean z36, boolean z37, int i37, boolean z38, int i38, int i39, int i46) {
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
        this.isBlock = z16;
        this.isMsgDisturb = z17;
        this.isSpecialCareOpen = z18;
        this.isSpecialCareZone = z19;
        this.ringId = str7;
        this.status = i19;
        this.qidianMasterFlag = i26;
        this.qidianCrewFlag = i27;
        this.qidianCrewFlag2 = i28;
        this.extStatus = i29;
        this.categoryId = i36;
        this.onlyChat = z26;
        this.qzoneNotWatch = z27;
        this.qzoneNotWatched = z28;
        this.vipFlag = z29;
        this.yearVipFlag = z36;
        this.svipFlag = z37;
        this.vipLevel = i37;
        this.isZPlanCoupleOpen = z38;
        this.zplanCoupleSceneId = i38;
        this.teenagerFlag = i39;
        this.studyFlag = i46;
    }
}
