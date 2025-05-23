package com.tencent.component.utils.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.component.network.module.cache.common.LruCache;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes5.dex */
public class PreferenceManager {
    private static final String CACHE_NAME = "cache_pref";
    private static final String DEFAULT_NAME = "default_pref";
    private static final float DEFAULT_VERSION = 0.0f;
    private static final long GLOBAL_UID = 0;
    private static final boolean OPTIMIZE = true;
    private static final int OPTIMIZE_BOUNDS = 1;
    private static final String OPTIMIZE_PREFIX = "preferences";
    private static final LruCache<String, SharedPreferences> sSharedPrefs = new LruCache<>(12);
    private static final ReentrantReadWriteLock sUniqueReadWriteLock = new ReentrantReadWriteLock();

    private static String convertToString(float f16) {
        int i3 = (int) f16;
        if (f16 == i3) {
            return String.valueOf(i3);
        }
        return String.valueOf(f16);
    }

    public static SharedPreferences getCacheGlobalPreference(Context context) {
        return obtainPreference(context, 0L, CACHE_NAME, 0.0f);
    }

    public static SharedPreferences getCachePreference(Context context, long j3) {
        return obtainPreference(context, j3, CACHE_NAME, 0.0f);
    }

    public static SharedPreferences getDefaultGlobalPreference(Context context) {
        return obtainPreference(context, 0L, DEFAULT_NAME, 0.0f);
    }

    public static SharedPreferences getDefaultPreference(Context context, long j3) {
        return obtainPreference(context, j3, DEFAULT_NAME, 0.0f);
    }

    public static SharedPreferences getGlobalPreference(Context context, String str) {
        return obtainPreference(context, 0L, str, 0.0f);
    }

    public static SharedPreferences getPreference(Context context, long j3, String str) {
        return obtainPreference(context, j3, str, 0.0f);
    }

    private static String obtainLegalName(String str) {
        if (str == null) {
            return str;
        }
        if (str.indexOf(File.separatorChar) >= 0) {
            return str.replaceAll(File.separator, "_");
        }
        return str;
    }

    private static String obtainOptimizeName(String str) {
        if (str == null) {
            return null;
        }
        int hashCode = str.hashCode() % 1;
        if (hashCode < 0) {
            hashCode++;
        }
        return OPTIMIZE_PREFIX + hashCode;
    }

    private static SharedPreferences obtainPreference(Context context, long j3, String str, float f16) {
        return obtainPreference(context, j3, str, f16, false);
    }

    public static SharedPreferences getCacheGlobalPreference(Context context, float f16) {
        return obtainPreference(context, 0L, CACHE_NAME, f16);
    }

    public static SharedPreferences getCachePreference(Context context, long j3, float f16) {
        return obtainPreference(context, j3, CACHE_NAME, f16);
    }

    public static SharedPreferences getDefaultGlobalPreference(Context context, boolean z16) {
        return obtainPreference(context, 0L, DEFAULT_NAME, 0.0f, z16);
    }

    public static SharedPreferences getDefaultPreference(Context context, long j3, float f16) {
        return obtainPreference(context, j3, DEFAULT_NAME, f16);
    }

    public static SharedPreferences getGlobalPreference(Context context, String str, float f16) {
        return obtainPreference(context, 0L, str, f16);
    }

    public static SharedPreferences getPreference(Context context, long j3, String str, float f16) {
        return obtainPreference(context, j3, str, f16);
    }

    private static SharedPreferences obtainPreference(Context context, long j3, String str, float f16, boolean z16) {
        String obtainLegalName = TextUtils.isEmpty(str) ? DEFAULT_NAME : obtainLegalName(str);
        if (z16) {
            return context.getSharedPreferences(context.getPackageName() + "_" + ((j3 != 0 ? String.valueOf(j3) : "") + "_" + obtainLegalName + "_" + convertToString(f16)), 0);
        }
        String str2 = (j3 != 0 ? String.valueOf(j3) : "") + "_" + obtainLegalName + "_" + convertToString(f16);
        ReentrantReadWriteLock reentrantReadWriteLock = sUniqueReadWriteLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        if (readLock != null) {
            readLock.lock();
        }
        try {
            LruCache<String, SharedPreferences> lruCache = sSharedPrefs;
            SharedPreferences sharedPreferences = lruCache.get(str2);
            if (sharedPreferences != null) {
                return sharedPreferences;
            }
            if (readLock != null) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            if (writeLock != null) {
                writeLock.lock();
            }
            try {
                try {
                    SharedPreferences sharedPreferences2 = lruCache.get(str2);
                    if (sharedPreferences2 == null) {
                        try {
                            sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_" + obtainOptimizeName(str2), 0);
                            if (sharedPreferences != null) {
                                sharedPreferences = new OptimizedSharedPreferencesWrapper(sharedPreferences, str2 + ":", true);
                            }
                            lruCache.put(str2, sharedPreferences);
                            sharedPreferences2 = sharedPreferences;
                        } catch (Exception e16) {
                            e = e16;
                            sharedPreferences = sharedPreferences2;
                            e.printStackTrace();
                            LogUtils.i("PreferenceManager", "obtainPreference exception: " + e.getMessage());
                            return sharedPreferences;
                        }
                    }
                    if (writeLock == null) {
                        return sharedPreferences2;
                    }
                    writeLock.unlock();
                    return sharedPreferences2;
                } catch (Exception e17) {
                    e = e17;
                }
            } finally {
                if (writeLock != null) {
                    writeLock.unlock();
                }
            }
        } finally {
            if (readLock != null) {
                readLock.unlock();
            }
        }
    }

    public static SharedPreferences getDefaultGlobalPreference(Context context, float f16) {
        return obtainPreference(context, 0L, DEFAULT_NAME, f16);
    }
}
