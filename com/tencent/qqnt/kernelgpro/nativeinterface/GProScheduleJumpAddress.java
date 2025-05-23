package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProScheduleJumpAddress {
    public int addressType;
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
        return "GProScheduleJumpAddress{addressType=" + this.addressType + ",address=" + this.address + ",feedAbstract=" + this.feedAbstract + ",}";
    }
}
