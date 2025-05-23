package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProClientInfo {
    public int clientId;
    public String clientName;
    public GProIdentityInstruction identityInstruction;

    public GProClientInfo() {
        this.clientName = "";
        this.identityInstruction = new GProIdentityInstruction();
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public GProIdentityInstruction getIdentityInstruction() {
        return this.identityInstruction;
    }

    public String toString() {
        return "GProClientInfo{clientId=" + this.clientId + ",clientName=" + this.clientName + ",identityInstruction=" + this.identityInstruction + ",}";
    }

    public GProClientInfo(int i3, String str, GProIdentityInstruction gProIdentityInstruction) {
        this.clientName = "";
        new GProIdentityInstruction();
        this.clientId = i3;
        this.clientName = str;
        this.identityInstruction = gProIdentityInstruction;
    }
}
