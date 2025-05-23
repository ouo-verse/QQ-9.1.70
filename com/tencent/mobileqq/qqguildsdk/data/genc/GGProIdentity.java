package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentity;

/* loaded from: classes17.dex */
public class GGProIdentity implements IGProIdentity {
    public final GProIdentity mInfo;

    public GGProIdentity(GProIdentity gProIdentity) {
        this.mInfo = gProIdentity;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProIdentity
    public int getIdentityType() {
        return this.mInfo.getIdentityType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProIdentity
    public byte[] getThirdPartyData() {
        return this.mInfo.getThirdPartyData();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProIdentity
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProIdentity
    public String getValue() {
        return this.mInfo.getValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProIdentity
    public String toString() {
        return this.mInfo.toString();
    }
}
