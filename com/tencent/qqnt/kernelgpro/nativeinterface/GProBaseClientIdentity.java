package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProBaseClientIdentity implements Serializable {
    public int clientId;
    long serialVersionUID = 1;
    public String desc = "";

    public int getClientId() {
        return this.clientId;
    }

    public String getDesc() {
        return this.desc;
    }

    public String toString() {
        return "GProBaseClientIdentity{clientId=" + this.clientId + ",desc=" + this.desc + ",}";
    }
}
