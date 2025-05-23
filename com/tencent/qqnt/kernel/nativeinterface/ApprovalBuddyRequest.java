package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ApprovalBuddyRequest {
    public boolean accept;
    public String friendUid;
    public String refuseMsg;
    public long reqTime;

    public ApprovalBuddyRequest() {
        this.friendUid = "";
    }

    public boolean getAccept() {
        return this.accept;
    }

    public String getFriendUid() {
        return this.friendUid;
    }

    public String getRefuseMsg() {
        return this.refuseMsg;
    }

    public long getReqTime() {
        return this.reqTime;
    }

    public ApprovalBuddyRequest(String str, boolean z16, String str2, long j3) {
        this.friendUid = str;
        this.accept = z16;
        this.refuseMsg = str2;
        this.reqTime = j3;
    }
}
