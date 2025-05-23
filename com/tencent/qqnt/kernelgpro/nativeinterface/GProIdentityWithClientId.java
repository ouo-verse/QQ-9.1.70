package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProIdentityWithClientId implements Serializable {
    public int clientId;
    long serialVersionUID = 1;
    public GProIdentity identitys = new GProIdentity();

    public int getClientId() {
        return this.clientId;
    }

    public GProIdentity getIdentitys() {
        return this.identitys;
    }

    public String toString() {
        return "GProIdentityWithClientId{clientId=" + this.clientId + ",identitys=" + this.identitys + ",}";
    }
}
