package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PublicAccountProfile {
    public Integer accountPos;
    public Long accountPosUpdateTime;
    public Boolean isMsgDisturb;
    public String nick;
    public String uid = "";
    public long uin;

    public Integer getAccountPos() {
        return this.accountPos;
    }

    public Long getAccountPosUpdateTime() {
        return this.accountPosUpdateTime;
    }

    public Boolean getIsMsgDisturb() {
        return this.isMsgDisturb;
    }

    public String getNick() {
        return this.nick;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "PublicAccountProfile{uid=" + this.uid + ",uin=" + this.uin + ",nick=" + this.nick + ",accountPos=" + this.accountPos + ",accountPosUpdateTime=" + this.accountPosUpdateTime + ",isMsgDisturb=" + this.isMsgDisturb + ",}";
    }
}
