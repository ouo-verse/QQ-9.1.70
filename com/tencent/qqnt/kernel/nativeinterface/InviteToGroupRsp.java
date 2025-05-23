package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InviteToGroupRsp {
    public long currentMaxMsgSeq;
    public long joinGroupCode;
    public int verifyType;
    public String verifyUrl = "";

    public long getCurrentMaxMsgSeq() {
        return this.currentMaxMsgSeq;
    }

    public long getJoinGroupCode() {
        return this.joinGroupCode;
    }

    public int getVerifyType() {
        return this.verifyType;
    }

    public String getVerifyUrl() {
        return this.verifyUrl;
    }

    public String toString() {
        return "InviteToGroupRsp{joinGroupCode=" + this.joinGroupCode + ",currentMaxMsgSeq=" + this.currentMaxMsgSeq + ",verifyUrl=" + this.verifyUrl + ",verifyType=" + this.verifyType + ",}";
    }
}
