package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProOtherJumpAddress;

/* loaded from: classes17.dex */
public class GGProOtherJumpAddress implements IGProOtherJumpAddress {
    public final GProOtherJumpAddress mInfo;

    public GGProOtherJumpAddress(GProOtherJumpAddress gProOtherJumpAddress) {
        this.mInfo = gProOtherJumpAddress;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProOtherJumpAddress
    public String getAddress() {
        return this.mInfo.getAddress();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProOtherJumpAddress
    public int getAddressType() {
        return this.mInfo.getAddressType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProOtherJumpAddress
    public String getFeedAbstract() {
        return this.mInfo.getFeedAbstract();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProOtherJumpAddress
    public String toString() {
        return this.mInfo.toString();
    }
}
