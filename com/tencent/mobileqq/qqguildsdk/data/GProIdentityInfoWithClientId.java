package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentityWithClientId;

/* loaded from: classes17.dex */
public class GProIdentityInfoWithClientId implements IGProIdentityInfoWithClientId {
    private final GProIdentityWithClientId mGProIdentityWithClientId;

    public GProIdentityInfoWithClientId(GProIdentityWithClientId gProIdentityWithClientId) {
        this.mGProIdentityWithClientId = gProIdentityWithClientId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfoWithClientId
    public String getClientId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.W0(this.mGProIdentityWithClientId.clientId);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfoWithClientId
    public IGProIdentityInfo getIdentity() {
        return new GProIdentityInfo(this.mGProIdentityWithClientId.identitys);
    }
}
