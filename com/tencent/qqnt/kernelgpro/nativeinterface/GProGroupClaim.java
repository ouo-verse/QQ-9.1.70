package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGroupClaim implements Serializable {
    public int groupType;
    public int number;
    long serialVersionUID = 1;

    public GProGroupClaim() {
    }

    public int getGroupType() {
        return this.groupType;
    }

    public int getNumber() {
        return this.number;
    }

    public void setGroupType(int i3) {
        this.groupType = i3;
    }

    public void setNumber(int i3) {
        this.number = i3;
    }

    public String toString() {
        return "GProGroupClaim{groupType=" + this.groupType + ",number=" + this.number + ",}";
    }

    public GProGroupClaim(int i3, int i16) {
        this.groupType = i3;
        this.number = i16;
    }
}
