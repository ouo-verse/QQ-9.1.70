package com.tencent.gamecenter.wadl.sdk.checker;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlCheckResult {
    public String errMsg;
    public long fileSize;
    public boolean isIPv6;
    public boolean isSucc;

    public String toString() {
        return "[isSucc=" + this.isSucc + ",isIPv6=" + this.isIPv6 + ",fileSize=" + this.fileSize + ",errMsg=" + this.errMsg + "]";
    }
}
