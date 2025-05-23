package com.tencent.shadow.core.runtime.qcircle.container;

import android.os.SystemClock;

/* loaded from: classes25.dex */
public class DelegateProviderHolder {
    private static DelegateProvider delegateProvider;
    public static long sCustomPid = SystemClock.elapsedRealtime();

    public static DelegateProvider getDelegateProvider() {
        return delegateProvider;
    }

    public static void setDelegateProvider(DelegateProvider delegateProvider2) {
        delegateProvider = delegateProvider2;
    }
}
