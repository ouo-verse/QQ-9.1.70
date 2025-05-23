package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RelationFlag {
    public String c2cRingId;
    public boolean isBlock;
    public boolean isBlocked;
    public boolean isHideSession;
    public boolean isMsgDisturb;
    public boolean isSpecialCareOpen;
    public boolean isSpecialCareZone;
    public byte[] notifyFlag;
    public int qidianCrewFlag;
    public int qidianCrewFlag2;
    public int qidianMasterFlag;
    public int recommendImgFlag;
    public String ringId;
    public long topTime;
    public boolean wxMsgNotifyClosed;

    public RelationFlag() {
        this.ringId = "";
        this.c2cRingId = "";
        this.notifyFlag = new byte[0];
    }

    public String getC2cRingId() {
        return this.c2cRingId;
    }

    public boolean getIsBlock() {
        return this.isBlock;
    }

    public boolean getIsBlocked() {
        return this.isBlocked;
    }

    public boolean getIsHideSession() {
        return this.isHideSession;
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

    public byte[] getNotifyFlag() {
        return this.notifyFlag;
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

    public int getRecommendImgFlag() {
        return this.recommendImgFlag;
    }

    public String getRingId() {
        return this.ringId;
    }

    public long getTopTime() {
        return this.topTime;
    }

    public boolean getWxMsgNotifyClosed() {
        return this.wxMsgNotifyClosed;
    }

    public RelationFlag(long j3, boolean z16, boolean z17, boolean z18, boolean z19, String str, boolean z26, int i3, int i16, int i17, int i18) {
        this.c2cRingId = "";
        this.notifyFlag = new byte[0];
        this.topTime = j3;
        this.isBlock = z16;
        this.isMsgDisturb = z17;
        this.isSpecialCareOpen = z18;
        this.isSpecialCareZone = z19;
        this.ringId = str;
        this.isBlocked = z26;
        this.recommendImgFlag = i3;
        this.qidianMasterFlag = i16;
        this.qidianCrewFlag = i17;
        this.qidianCrewFlag2 = i18;
    }
}
