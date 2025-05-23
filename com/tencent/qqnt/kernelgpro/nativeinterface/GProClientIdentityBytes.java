package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProClientIdentityBytes implements Serializable {
    public int clientId;
    public ArrayList<GProIdentityWithClientId> defaultIdentitys;
    public ArrayList<GProIdentity> identitys;
    long serialVersionUID;

    public GProClientIdentityBytes() {
        this.serialVersionUID = 1L;
        this.identitys = new ArrayList<>();
        this.defaultIdentitys = new ArrayList<>();
    }

    public int getClientId() {
        return this.clientId;
    }

    public ArrayList<GProIdentityWithClientId> getDefaultIdentitys() {
        return this.defaultIdentitys;
    }

    public ArrayList<GProIdentity> getIdentitys() {
        return this.identitys;
    }

    public String toString() {
        return "GProClientIdentityBytes{clientId=" + this.clientId + ",identitys=" + this.identitys + ",defaultIdentitys=" + this.defaultIdentitys + ",}";
    }

    public GProClientIdentityBytes(int i3, ArrayList<GProIdentity> arrayList) {
        this.serialVersionUID = 1L;
        this.identitys = new ArrayList<>();
        this.defaultIdentitys = new ArrayList<>();
        this.clientId = i3;
        this.identitys = arrayList;
    }
}
