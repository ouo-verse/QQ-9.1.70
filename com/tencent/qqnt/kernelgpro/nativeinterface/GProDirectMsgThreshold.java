package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProDirectMsgThreshold implements Serializable {
    public int needHasJoinRole;
    public long needJoinTime;
    public int needRealName;
    long serialVersionUID = 1;

    public int getNeedHasJoinRole() {
        return this.needHasJoinRole;
    }

    public long getNeedJoinTime() {
        return this.needJoinTime;
    }

    public int getNeedRealName() {
        return this.needRealName;
    }

    public void setNeedHasJoinRole(int i3) {
        this.needHasJoinRole = i3;
    }

    public void setNeedJoinTime(long j3) {
        this.needJoinTime = j3;
    }

    public void setNeedRealName(int i3) {
        this.needRealName = i3;
    }

    public String toString() {
        return "GProDirectMsgThreshold{needRealName=" + this.needRealName + ",needHasJoinRole=" + this.needHasJoinRole + ",needJoinTime=" + this.needJoinTime + ",}";
    }
}
