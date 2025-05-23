package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BuddyReq implements IKernelModel, Serializable {
    public int commFriendNum;
    public Integer curFriendMax;
    public String extWords;
    public int flag;
    public String friendAvatarUrl;
    public String friendNick;
    public String friendUid;
    public Long groupCode;
    public boolean isAgreed;
    public Boolean isBuddy;
    public boolean isDecide;
    public boolean isDoubt;
    public boolean isInitiator;
    public boolean isShowCard;
    public boolean isUnread;
    public String nameMore;
    public int preGroupingId;
    public int relation;
    public Integer reqSubType;
    public long reqTime;
    public int reqType;
    long serialVersionUID;
    public int sourceId;

    public BuddyReq() {
        this.serialVersionUID = 1L;
        this.friendUid = "";
        this.friendNick = "";
        this.friendAvatarUrl = "";
    }

    public int getCommFriendNum() {
        return this.commFriendNum;
    }

    public Integer getCurFriendMax() {
        return this.curFriendMax;
    }

    public String getExtWords() {
        return this.extWords;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getFriendAvatarUrl() {
        return this.friendAvatarUrl;
    }

    public String getFriendNick() {
        return this.friendNick;
    }

    public String getFriendUid() {
        return this.friendUid;
    }

    public Long getGroupCode() {
        return this.groupCode;
    }

    public boolean getIsAgreed() {
        return this.isAgreed;
    }

    public Boolean getIsBuddy() {
        return this.isBuddy;
    }

    public boolean getIsDecide() {
        return this.isDecide;
    }

    public boolean getIsDoubt() {
        return this.isDoubt;
    }

    public boolean getIsInitiator() {
        return this.isInitiator;
    }

    public boolean getIsShowCard() {
        return this.isShowCard;
    }

    public boolean getIsUnread() {
        return this.isUnread;
    }

    public String getNameMore() {
        return this.nameMore;
    }

    public int getPreGroupingId() {
        return this.preGroupingId;
    }

    public int getRelation() {
        return this.relation;
    }

    public Integer getReqSubType() {
        return this.reqSubType;
    }

    public long getReqTime() {
        return this.reqTime;
    }

    public int getReqType() {
        return this.reqType;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public void setCommFriendNum(int i3) {
        this.commFriendNum = i3;
    }

    public void setCurFriendMax(Integer num) {
        this.curFriendMax = num;
    }

    public void setExtWords(String str) {
        this.extWords = str;
    }

    public void setFlag(int i3) {
        this.flag = i3;
    }

    public void setFriendAvatarUrl(String str) {
        this.friendAvatarUrl = str;
    }

    public void setFriendNick(String str) {
        this.friendNick = str;
    }

    public void setFriendUid(String str) {
        this.friendUid = str;
    }

    public void setGroupCode(Long l3) {
        this.groupCode = l3;
    }

    public void setIsAgreed(boolean z16) {
        this.isAgreed = z16;
    }

    public void setIsBuddy(Boolean bool) {
        this.isBuddy = bool;
    }

    public void setIsDecide(boolean z16) {
        this.isDecide = z16;
    }

    public void setIsDoubt(boolean z16) {
        this.isDoubt = z16;
    }

    public void setIsInitiator(boolean z16) {
        this.isInitiator = z16;
    }

    public void setIsShowCard(boolean z16) {
        this.isShowCard = z16;
    }

    public void setIsUnread(boolean z16) {
        this.isUnread = z16;
    }

    public void setNameMore(String str) {
        this.nameMore = str;
    }

    public void setPreGroupingId(int i3) {
        this.preGroupingId = i3;
    }

    public void setRelation(int i3) {
        this.relation = i3;
    }

    public void setReqSubType(Integer num) {
        this.reqSubType = num;
    }

    public void setReqTime(long j3) {
        this.reqTime = j3;
    }

    public void setReqType(int i3) {
        this.reqType = i3;
    }

    public void setSourceId(int i3) {
        this.sourceId = i3;
    }

    public String toString() {
        return "BuddyReq{isDecide=" + this.isDecide + ",isInitiator=" + this.isInitiator + ",friendUid=" + this.friendUid + ",reqType=" + this.reqType + ",reqSubType=" + this.reqSubType + ",reqTime=" + this.reqTime + ",extWords=" + this.extWords + ",flag=" + this.flag + ",preGroupingId=" + this.preGroupingId + ",commFriendNum=" + this.commFriendNum + ",curFriendMax=" + this.curFriendMax + ",isShowCard=" + this.isShowCard + ",isUnread=" + this.isUnread + ",isDoubt=" + this.isDoubt + ",nameMore=" + this.nameMore + ",friendNick=" + this.friendNick + ",friendAvatarUrl=" + this.friendAvatarUrl + ",sourceId=" + this.sourceId + ",groupCode=" + this.groupCode + ",isBuddy=" + this.isBuddy + ",isAgreed=" + this.isAgreed + ",relation=" + this.relation + ",}";
    }

    public BuddyReq(boolean z16, boolean z17, String str, int i3, Integer num, long j3, String str2, int i16, int i17, int i18, Integer num2, boolean z18, boolean z19, boolean z26, String str3, String str4, String str5, int i19, Long l3, Boolean bool, boolean z27, int i26) {
        this.serialVersionUID = 1L;
        this.isDecide = z16;
        this.isInitiator = z17;
        this.friendUid = str;
        this.reqType = i3;
        this.reqSubType = num;
        this.reqTime = j3;
        this.extWords = str2;
        this.flag = i16;
        this.preGroupingId = i17;
        this.commFriendNum = i18;
        this.curFriendMax = num2;
        this.isShowCard = z18;
        this.isUnread = z19;
        this.isDoubt = z26;
        this.nameMore = str3;
        this.friendNick = str4;
        this.friendAvatarUrl = str5;
        this.sourceId = i19;
        this.groupCode = l3;
        this.isBuddy = bool;
        this.isAgreed = z27;
        this.relation = i26;
    }
}
