package com.tencent.qmethod.pandoraex.monitor;

import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DexMonitor {
    private static final String TAG = "DexMonitor";
    private static final String TYPE_DEX = "DEX";
    private static final String TYPE_SO = "SO";
    public static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(64);

    public static void dexClassLoader(DexClassLoader dexClassLoader, String str, String str2, String str3, ClassLoader classLoader) {
        if (str != null) {
            map.put(str, TYPE_DEX);
        }
    }

    public static void load(String str) {
        if (str != null) {
            map.put(str, TYPE_SO);
        }
        System.load(str);
    }

    public static void loadLibrary(String str) {
        String findLibrary;
        try {
            ClassLoader classLoader = DexMonitor.class.getClassLoader();
            if ((classLoader instanceof BaseDexClassLoader) && (findLibrary = ((BaseDexClassLoader) classLoader).findLibrary(str)) != null) {
                map.put(findLibrary, TYPE_SO);
            }
        } catch (Throwable th5) {
            Log.d(TAG, "loadLibrary monitor error=" + th5.getMessage(), th5);
        }
        System.loadLibrary(str);
    }
}
