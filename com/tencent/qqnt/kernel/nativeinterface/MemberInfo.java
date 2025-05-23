package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MemberInfo implements IKernelModel, Serializable {
    public int bigClubFlag;
    public int bigClubLevel;
    public int cardNameId;
    public int cardType;
    public int creditLevel;
    public int globalGroupLevel;
    public int globalGroupPoint;
    public boolean isDelete;
    public boolean isRobot;
    public boolean isSpecialConcerned;
    public boolean isSpecialShielded;
    public int joinTime;
    public int lastSpeakTime;
    public int memberFlag;
    public int memberFlagExt;
    public int memberFlagExt2;
    public int memberLevel;
    public int memberMobileFlag;
    public int memberRealLevel;
    public int memberTitleId;
    public int mssVipType;
    public int richFlag;
    public int shutUpTime;
    public long specialTitleExpireTime;
    public long uin;
    public int userShowFlag;
    public int userShowFlagNew;
    long serialVersionUID = 1;
    public String uid = "";
    public String qid = "";
    public String nick = "";
    public String remark = "";
    public String cardName = "";
    public MemberRole role = MemberRole.values()[0];
    public String avatarPath = "";
    public byte[] groupHonor = new byte[0];
    public String memberSpecialTitle = "";
    public String autoRemark = "";

    public String getAutoRemark() {
        return this.autoRemark;
    }

    public String getAvatarPath() {
        return this.avatarPath;
    }

    public int getBigClubFlag() {
        return this.bigClubFlag;
    }

    public int getBigClubLevel() {
        return this.bigClubLevel;
    }

    public String getCardName() {
        return this.cardName;
    }

    public int getCardNameId() {
        return this.cardNameId;
    }

    public int getCardType() {
        return this.cardType;
    }

    public int getCreditLevel() {
        return this.creditLevel;
    }

    public int getGlobalGroupLevel() {
        return this.globalGroupLevel;
    }

    public int getGlobalGroupPoint() {
        return this.globalGroupPoint;
    }

    public byte[] getGroupHonor() {
        return this.groupHonor;
    }

    public boolean getIsDelete() {
        return this.isDelete;
    }

    public boolean getIsRobot() {
        return this.isRobot;
    }

    public boolean getIsSpecialConcerned() {
        return this.isSpecialConcerned;
    }

    public boolean getIsSpecialShielded() {
        return this.isSpecialShielded;
    }

    public int getJoinTime() {
        return this.joinTime;
    }

    public int getLastSpeakTime() {
        return this.lastSpeakTime;
    }

    public int getMemberFlag() {
        return this.memberFlag;
    }

    public int getMemberFlagExt() {
        return this.memberFlagExt;
    }

    public int getMemberFlagExt2() {
        return this.memberFlagExt2;
    }

    public int getMemberLevel() {
        return this.memberLevel;
    }

    public int getMemberMobileFlag() {
        return this.memberMobileFlag;
    }

    public int getMemberRealLevel() {
        return this.memberRealLevel;
    }

    public String getMemberSpecialTitle() {
        return this.memberSpecialTitle;
    }

    public int getMemberTitleId() {
        return this.memberTitleId;
    }

    public int getMssVipType() {
        return this.mssVipType;
    }

    public String getNick() {
        return this.nick;
    }

    public String getQid() {
        return this.qid;
    }

    public String getRemark() {
        return this.remark;
    }

    public int getRichFlag() {
        return this.richFlag;
    }

    public MemberRole getRole() {
        return this.role;
    }

    public int getShutUpTime() {
        return this.shutUpTime;
    }

    public long getSpecialTitleExpireTime() {
        return this.specialTitleExpireTime;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public int getUserShowFlag() {
        return this.userShowFlag;
    }

    public int getUserShowFlagNew() {
        return this.userShowFlagNew;
    }

    public void setAutoRemark(String str) {
        this.autoRemark = str;
    }

    public void setAvatarPath(String str) {
        this.avatarPath = str;
    }

    public void setBigClubFlag(int i3) {
        this.bigClubFlag = i3;
    }

    public void setBigClubLevel(int i3) {
        this.bigClubLevel = i3;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public void setCardNameId(int i3) {
        this.cardNameId = i3;
    }

    public void setCardType(int i3) {
        this.cardType = i3;
    }

    public void setCreditLevel(int i3) {
        this.creditLevel = i3;
    }

    public void setGlobalGroupLevel(int i3) {
        this.globalGroupLevel = i3;
    }

    public void setGlobalGroupPoint(int i3) {
        this.globalGroupPoint = i3;
    }

    public void setGroupHonor(byte[] bArr) {
        this.groupHonor = bArr;
    }

    public void setIsDelete(boolean z16) {
        this.isDelete = z16;
    }

    public void setIsRobot(boolean z16) {
        this.isRobot = z16;
    }

    public void setIsSpecialConcerned(boolean z16) {
        this.isSpecialConcerned = z16;
    }

    public void setIsSpecialShielded(boolean z16) {
        this.isSpecialShielded = z16;
    }

    public void setJoinTime(int i3) {
        this.joinTime = i3;
    }

    public void setLastSpeakTime(int i3) {
        this.lastSpeakTime = i3;
    }

    public void setMemberFlag(int i3) {
        this.memberFlag = i3;
    }

    public void setMemberFlagExt(int i3) {
        this.memberFlagExt = i3;
    }

    public void setMemberFlagExt2(int i3) {
        this.memberFlagExt2 = i3;
    }

    public void setMemberLevel(int i3) {
        this.memberLevel = i3;
    }

    public void setMemberMobileFlag(int i3) {
        this.memberMobileFlag = i3;
    }

    public void setMemberRealLevel(int i3) {
        this.memberRealLevel = i3;
    }

    public void setMemberSpecialTitle(String str) {
        this.memberSpecialTitle = str;
    }

    public void setMemberTitleId(int i3) {
        this.memberTitleId = i3;
    }

    public void setMssVipType(int i3) {
        this.mssVipType = i3;
    }

    public void setNick(String str) {
        this.nick = str;
    }

    public void setQid(String str) {
        this.qid = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setRichFlag(int i3) {
        this.richFlag = i3;
    }

    public void setRole(MemberRole memberRole) {
        this.role = memberRole;
    }

    public void setShutUpTime(int i3) {
        this.shutUpTime = i3;
    }

    public void setSpecialTitleExpireTime(long j3) {
        this.specialTitleExpireTime = j3;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUin(long j3) {
        this.uin = j3;
    }

    public void setUserShowFlag(int i3) {
        this.userShowFlag = i3;
    }

    public void setUserShowFlagNew(int i3) {
        this.userShowFlagNew = i3;
    }

    public String toString() {
        return "MemberInfo{uid=" + this.uid + ",qid=" + this.qid + ",uin=" + this.uin + ",nick=" + this.nick + ",remark=" + this.remark + ",cardType=" + this.cardType + ",cardName=" + this.cardName + ",role=" + this.role + ",avatarPath=" + this.avatarPath + ",shutUpTime=" + this.shutUpTime + ",isDelete=" + this.isDelete + ",isSpecialConcerned=" + this.isSpecialConcerned + ",isRobot=" + this.isRobot + ",groupHonor=" + this.groupHonor + ",memberRealLevel=" + this.memberRealLevel + ",memberLevel=" + this.memberLevel + ",globalGroupLevel=" + this.globalGroupLevel + ",globalGroupPoint=" + this.globalGroupPoint + ",memberTitleId=" + this.memberTitleId + ",memberSpecialTitle=" + this.memberSpecialTitle + ",specialTitleExpireTime=" + this.specialTitleExpireTime + ",userShowFlag=" + this.userShowFlag + ",userShowFlagNew=" + this.userShowFlagNew + ",richFlag=" + this.richFlag + ",mssVipType=" + this.mssVipType + ",bigClubLevel=" + this.bigClubLevel + ",bigClubFlag=" + this.bigClubFlag + ",autoRemark=" + this.autoRemark + ",creditLevel=" + this.creditLevel + ",joinTime=" + this.joinTime + ",lastSpeakTime=" + this.lastSpeakTime + ",memberFlag=" + this.memberFlag + ",memberFlagExt=" + this.memberFlagExt + ",memberMobileFlag=" + this.memberMobileFlag + ",memberFlagExt2=" + this.memberFlagExt2 + ",isSpecialShielded=" + this.isSpecialShielded + ",cardNameId=" + this.cardNameId + ",}";
    }
}
