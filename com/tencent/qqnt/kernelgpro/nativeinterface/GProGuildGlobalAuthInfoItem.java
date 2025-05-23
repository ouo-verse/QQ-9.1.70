package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuildGlobalAuthInfoItem implements Serializable {
    public int globalAuthScopeType;
    long serialVersionUID = 1;

    public int getGlobalAuthScopeType() {
        return this.globalAuthScopeType;
    }

    public String toString() {
        return "GProGuildGlobalAuthInfoItem{globalAuthScopeType=" + this.globalAuthScopeType + ",}";
    }
}
