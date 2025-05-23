package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProUserListGroupInfo implements Serializable {
    public int groupType;
    long serialVersionUID = 1;

    public int getGroupType() {
        return this.groupType;
    }

    public String toString() {
        return "GProUserListGroupInfo{groupType=" + this.groupType + ",}";
    }
}
