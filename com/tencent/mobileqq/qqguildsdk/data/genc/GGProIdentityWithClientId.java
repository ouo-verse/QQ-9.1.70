package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentityWithClientId;

/* loaded from: classes17.dex */
public class GGProIdentityWithClientId implements IGProIdentityWithClientId {
    public final GProIdentityWithClientId mInfo;

    public GGProIdentityWithClientId(GProIdentityWithClientId gProIdentityWithClientId) {
        this.mInfo = gProIdentityWithClientId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProIdentityWithClientId
    public int getClientId() {
        return this.mInfo.getClientId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProIdentityWithClientId
    public IGProIdentity getIdentitys() {
        return new GGProIdentity(this.mInfo.getIdentitys());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProIdentityWithClientId
    public String toString() {
        return this.mInfo.toString();
    }
}
