package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGroupProStatus implements Serializable {
    public int isBanned;
    public int isEnable;
    public int isFrozen;
    long serialVersionUID = 1;

    public int getIsBanned() {
        return this.isBanned;
    }

    public int getIsEnable() {
        return this.isEnable;
    }

    public int getIsFrozen() {
        return this.isFrozen;
    }

    public void setIsBanned(int i3) {
        this.isBanned = i3;
    }

    public void setIsEnable(int i3) {
        this.isEnable = i3;
    }

    public void setIsFrozen(int i3) {
        this.isFrozen = i3;
    }

    public String toString() {
        return "GProGroupProStatus{isEnable=" + this.isEnable + ",isBanned=" + this.isBanned + ",isFrozen=" + this.isFrozen + ",}";
    }
}
