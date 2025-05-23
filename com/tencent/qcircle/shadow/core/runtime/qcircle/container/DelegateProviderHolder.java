package com.tencent.qcircle.shadow.core.runtime.qcircle.container;

import android.os.SystemClock;
import java.util.HashMap;

/* loaded from: classes22.dex */
public class DelegateProviderHolder {
    private static HashMap<String, DelegateProvider> sDelegateMap = new HashMap<>();
    public static long sCustomPid = SystemClock.elapsedRealtime();

    public static DelegateProvider getDelegateProviderFromUUid(String str) {
        return sDelegateMap.get(str);
    }

    public static void setDelegateProvider(String str, DelegateProvider delegateProvider) {
        sDelegateMap.put(str, delegateProvider);
    }
}
