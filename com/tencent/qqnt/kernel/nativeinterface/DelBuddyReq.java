package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DelBuddyReq implements IKernelModel {
    public String friendUid;
    public boolean isDecide;
    public boolean isInitiator;
    public long reqTime;
    public int reqType;

    public DelBuddyReq() {
        this.friendUid = "";
    }

    public String getFriendUid() {
        return this.friendUid;
    }

    public boolean getIsDecide() {
        return this.isDecide;
    }

    public boolean getIsInitiator() {
        return this.isInitiator;
    }

    public long getReqTime() {
        return this.reqTime;
    }

    public int getReqType() {
        return this.reqType;
    }

    public void setFriendUid(String str) {
        this.friendUid = str;
    }

    public void setIsDecide(boolean z16) {
        this.isDecide = z16;
    }

    public void setIsInitiator(boolean z16) {
        this.isInitiator = z16;
    }

    public void setReqTime(long j3) {
        this.reqTime = j3;
    }

    public void setReqType(int i3) {
        this.reqType = i3;
    }

    public DelBuddyReq(boolean z16, boolean z17, String str, int i3, long j3) {
        this.isDecide = z16;
        this.isInitiator = z17;
        this.friendUid = str;
        this.reqType = i3;
        this.reqTime = j3;
    }
}
