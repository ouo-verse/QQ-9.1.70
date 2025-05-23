package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProIdentity implements Serializable {
    public int identityType;
    long serialVersionUID;
    public byte[] thirdPartyData;
    public int type;
    public String value;

    public GProIdentity() {
        this.serialVersionUID = 1L;
        this.value = "";
        this.thirdPartyData = new byte[0];
    }

    public int getIdentityType() {
        return this.identityType;
    }

    public byte[] getThirdPartyData() {
        return this.thirdPartyData;
    }

    public int getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "GProIdentity{type=" + this.type + ",value=" + this.value + ",identityType=" + this.identityType + ",thirdPartyData=" + this.thirdPartyData + ",}";
    }

    public GProIdentity(int i3, String str, int i16, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.type = i3;
        this.value = str;
        this.identityType = i16;
        this.thirdPartyData = bArr;
    }
}
