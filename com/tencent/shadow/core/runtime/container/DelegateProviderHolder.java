package com.tencent.shadow.core.runtime.container;

import android.os.SystemClock;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes25.dex */
public class DelegateProviderHolder {
    public static final String DEFAULT_KEY = "DEFAULT_KEY";
    private static final String TAG = "DelegateProviderHolder";
    private static Map<String, DelegateProvider> delegateProviderMap = new HashMap();
    public static long sCustomPid = SystemClock.elapsedRealtime();

    static {
        Log.i(TAG, "plugin_tag static initializer sCustomPid: " + sCustomPid + ", classLoader: " + DelegateProviderHolder.class.getClassLoader());
    }

    public static DelegateProvider getDelegateProvider(String str) {
        return delegateProviderMap.get(str);
    }

    public static void setDelegateProvider(String str, DelegateProvider delegateProvider) {
        delegateProviderMap.put(str, delegateProvider);
    }
}
