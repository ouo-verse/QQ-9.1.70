package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProEnterAVChannelPermissionInfo implements Serializable {
    public int roleType;
    long serialVersionUID = 1;

    public GProEnterAVChannelPermissionInfo() {
    }

    public int getRoleType() {
        return this.roleType;
    }

    public String toString() {
        return "GProEnterAVChannelPermissionInfo{roleType=" + this.roleType + ",}";
    }

    public GProEnterAVChannelPermissionInfo(int i3) {
        this.roleType = i3;
    }
}
