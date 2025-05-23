package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OpenIDResult {
    public OpenIDInfo openidInfo = new OpenIDInfo();
    public ThirdPartySigSvrErrorInfo errorInfo = new ThirdPartySigSvrErrorInfo();

    public ThirdPartySigSvrErrorInfo getErrorInfo() {
        return this.errorInfo;
    }

    public OpenIDInfo getOpenidInfo() {
        return this.openidInfo;
    }

    public String toString() {
        return "OpenIDResult{openidInfo=" + this.openidInfo + ",errorInfo=" + this.errorInfo + ",}";
    }
}
