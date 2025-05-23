package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MemberCommonInfoFilter {
    public int memberUin;
    public int privilege;
    public int shutUpTime;
    public int uinFlag;
    public int uinFlagExt;
    public int uinMobileFlag;

    public int getMemberUin() {
        return this.memberUin;
    }

    public int getPrivilege() {
        return this.privilege;
    }

    public int getShutUpTime() {
        return this.shutUpTime;
    }

    public int getUinFlag() {
        return this.uinFlag;
    }

    public int getUinFlagExt() {
        return this.uinFlagExt;
    }

    public int getUinMobileFlag() {
        return this.uinMobileFlag;
    }

    public void setMemberUin(int i3) {
        this.memberUin = i3;
    }

    public void setPrivilege(int i3) {
        this.privilege = i3;
    }

    public void setShutUpTime(int i3) {
        this.shutUpTime = i3;
    }

    public void setUinFlag(int i3) {
        this.uinFlag = i3;
    }

    public void setUinFlagExt(int i3) {
        this.uinFlagExt = i3;
    }

    public void setUinMobileFlag(int i3) {
        this.uinMobileFlag = i3;
    }

    public String toString() {
        return "MemberCommonInfoFilter{memberUin=" + this.memberUin + ",uinFlag=" + this.uinFlag + ",uinFlagExt=" + this.uinFlagExt + ",uinMobileFlag=" + this.uinMobileFlag + ",shutUpTime=" + this.shutUpTime + ",privilege=" + this.privilege + ",}";
    }
}
