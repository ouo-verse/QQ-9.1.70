package com.tencent.smtt.sdk;

/* loaded from: classes23.dex */
public abstract class SystemCoreProtector {
    public void onCookieManagerException(Exception exc) {
        throw new IllegalStateException(exc);
    }
}
