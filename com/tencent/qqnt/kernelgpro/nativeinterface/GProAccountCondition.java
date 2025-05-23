package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAccountCondition {
    public long clientId;
    public boolean isNeedAuth;

    public long getClientId() {
        return this.clientId;
    }

    public boolean getIsNeedAuth() {
        return this.isNeedAuth;
    }

    public String toString() {
        return "GProAccountCondition{clientId=" + this.clientId + ",isNeedAuth=" + this.isNeedAuth + ",}";
    }
}
