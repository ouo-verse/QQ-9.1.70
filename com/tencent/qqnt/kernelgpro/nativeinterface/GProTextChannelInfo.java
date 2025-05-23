package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTextChannelInfo implements Serializable {
    long serialVersionUID = 1;
    public int subTypeId;

    public int getSubTypeId() {
        return this.subTypeId;
    }

    public String toString() {
        return "GProTextChannelInfo{subTypeId=" + this.subTypeId + ",}";
    }
}
