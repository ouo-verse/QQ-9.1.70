package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProOtherJumpAddress implements Serializable {
    public int addressType;
    long serialVersionUID = 1;
    public String address = "";
    public String feedAbstract = "";

    public String getAddress() {
        return this.address;
    }

    public int getAddressType() {
        return this.addressType;
    }

    public String getFeedAbstract() {
        return this.feedAbstract;
    }

    public String toString() {
        return "GProOtherJumpAddress{addressType=" + this.addressType + ",address=" + this.address + ",feedAbstract=" + this.feedAbstract + ",}";
    }
}
