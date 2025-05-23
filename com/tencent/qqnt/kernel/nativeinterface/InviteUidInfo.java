package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InviteUidInfo {
    public String inviteUid = "";
    public long judgeConfCode;
    public long judgeGroupCode;

    public String getInviteUid() {
        return this.inviteUid;
    }

    public long getJudgeConfCode() {
        return this.judgeConfCode;
    }

    public long getJudgeGroupCode() {
        return this.judgeGroupCode;
    }

    public String toString() {
        return "InviteUidInfo{inviteUid=" + this.inviteUid + ",judgeGroupCode=" + this.judgeGroupCode + ",judgeConfCode=" + this.judgeConfCode + ",}";
    }
}
