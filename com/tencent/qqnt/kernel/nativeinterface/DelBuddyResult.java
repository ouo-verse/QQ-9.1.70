package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DelBuddyResult {
    public String friendUid;
    public long resultCode;
    public String resultMsg;

    public DelBuddyResult() {
        this.friendUid = "";
        this.resultMsg = "";
    }

    public String getFriendUid() {
        return this.friendUid;
    }

    public long getResultCode() {
        return this.resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public DelBuddyResult(String str, long j3, String str2) {
        this.friendUid = str;
        this.resultCode = j3;
        this.resultMsg = str2;
    }
}
