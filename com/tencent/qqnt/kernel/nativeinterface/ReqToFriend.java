package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ReqToFriend {
    public int addFriendSetting;
    public String answer;
    public String buddyUid;
    public long buddyUin;
    public Integer defaultCatgory;
    public String phoneNumber;
    public String remark;
    public Verify securityVerify;
    public int sourceID;
    public int sourceSubID;
    public String verifyInfo;

    public ReqToFriend() {
        this.buddyUid = "";
        this.phoneNumber = "";
    }

    public int getAddFriendSetting() {
        return this.addFriendSetting;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String getBuddyUid() {
        return this.buddyUid;
    }

    public long getBuddyUin() {
        return this.buddyUin;
    }

    public Integer getDefaultCatgory() {
        return this.defaultCatgory;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getRemark() {
        return this.remark;
    }

    public Verify getSecurityVerify() {
        return this.securityVerify;
    }

    public int getSourceID() {
        return this.sourceID;
    }

    public int getSourceSubID() {
        return this.sourceSubID;
    }

    public String getVerifyInfo() {
        return this.verifyInfo;
    }

    public void setAddFriendSetting(int i3) {
        this.addFriendSetting = i3;
    }

    public void setAnswer(String str) {
        this.answer = str;
    }

    public void setBuddyUid(String str) {
        this.buddyUid = str;
    }

    public void setBuddyUin(long j3) {
        this.buddyUin = j3;
    }

    public void setDefaultCatgory(Integer num) {
        this.defaultCatgory = num;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSecurityVerify(Verify verify) {
        this.securityVerify = verify;
    }

    public void setSourceID(int i3) {
        this.sourceID = i3;
    }

    public void setSourceSubID(int i3) {
        this.sourceSubID = i3;
    }

    public void setVerifyInfo(String str) {
        this.verifyInfo = str;
    }

    public ReqToFriend(long j3, String str, String str2, int i3, String str3, String str4, Integer num, String str5, Verify verify, int i16, int i17) {
        this.buddyUin = j3;
        this.buddyUid = str;
        this.phoneNumber = str2;
        this.addFriendSetting = i3;
        this.answer = str3;
        this.remark = str4;
        this.defaultCatgory = num;
        this.verifyInfo = str5;
        this.securityVerify = verify;
        this.sourceID = i16;
        this.sourceSubID = i17;
    }
}
