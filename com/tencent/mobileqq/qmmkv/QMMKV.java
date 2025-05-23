package com.tencent.mobileqq.qmmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QMMKV {
    public static final int MODE_ACROSS = 2;
    public static final int MODE_SINGLE = 1;
    private static volatile MMKVHandlerBase mmkvFileHandler;
    private static final ConcurrentHashMap<String, MMKVOptionEntity> mmapName2Entity = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, MMKVOptionEntityV2> mmapName2EntityV2 = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, MMKVAdapter> spName2Adapter = new ConcurrentHashMap<>();
    private static volatile boolean mmkvInited = false;
    public static volatile boolean encodeMonitorOn = false;
    public static volatile boolean decodeMonitorOn = false;
    public static volatile boolean syncMonitorOn = false;

    QMMKV() {
    }

    @NonNull
    @Deprecated
    public static MMKVOptionEntity from(Context context, String str, int i3) {
        String str2 = str + i3;
        ConcurrentHashMap<String, MMKVOptionEntity> concurrentHashMap = mmapName2Entity;
        MMKVOptionEntity mMKVOptionEntity = concurrentHashMap.get(str2);
        if (mMKVOptionEntity != null && mMKVOptionEntity.isAccessible()) {
            return mMKVOptionEntity;
        }
        MMKVOptionEntity mmkvCreateInstance = mmkvCreateInstance(context, str, i3);
        if (mmkvCreateInstance != null) {
            concurrentHashMap.put(str2, mmkvCreateInstance);
            return mmkvCreateInstance;
        }
        return new MMKVOptionEntity(null, i3, mmkvFileHandler, null);
    }

    @Deprecated
    public static SharedPreferences fromSpAdapter(Context context, String str, String str2) {
        return fromSpAdapterV2(context, str, str2, false);
    }

    public static SharedPreferences fromSpAdapterV2(Context context, String str, String str2, boolean z16) {
        int i3;
        String str3 = str + "_" + str2 + "_" + (z16 ? 1 : 0);
        ConcurrentHashMap<String, MMKVAdapter> concurrentHashMap = spName2Adapter;
        MMKVAdapter mMKVAdapter = concurrentHashMap.get(str3);
        if (mMKVAdapter != null && mMKVAdapter.isEntityAccessible()) {
            return mMKVAdapter;
        }
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        MMKVAdapter mMKVAdapter2 = new MMKVAdapter(fromV2(context, str2, 2, i3), str);
        concurrentHashMap.put(str3, mMKVAdapter2);
        return mMKVAdapter2;
    }

    @NonNull
    public static MMKVOptionEntityV2 fromV2(Context context, String str, int i3, int i16) {
        String str2 = str + "_" + i3 + "_" + i16;
        ConcurrentHashMap<String, MMKVOptionEntityV2> concurrentHashMap = mmapName2EntityV2;
        MMKVOptionEntityV2 mMKVOptionEntityV2 = concurrentHashMap.get(str2);
        if (mMKVOptionEntityV2 != null && mMKVOptionEntityV2.isAccessible()) {
            return mMKVOptionEntityV2;
        }
        MMKVOptionEntityV2 mmkvCreateInstanceV2 = mmkvCreateInstanceV2(context, str, i3, i16);
        if (mmkvCreateInstanceV2 != null) {
            concurrentHashMap.put(str2, mmkvCreateInstanceV2);
            return mmkvCreateInstanceV2;
        }
        return new MMKVOptionEntityV2(null, 0, mmkvFileHandler, null);
    }

    public static synchronized void initializeInternal(Context context, MMKVHandlerBase mMKVHandlerBase) {
        synchronized (QMMKV.class) {
            if (mMKVHandlerBase == null) {
                mMKVHandlerBase = new MMKVHandlerImpl();
            }
            mmkvFileHandler = mMKVHandlerBase;
            if (mmkvInited) {
                return;
            }
            if (context != null) {
                try {
                    logDebug("initMMKV at:" + MMKV.T(context));
                    MMKV.e0(mmkvFileHandler);
                    MMKV.d0(mmkvFileHandler);
                    mmkvInited = true;
                } catch (UnsatisfiedLinkError e16) {
                    logError(Arrays.toString(e16.getStackTrace()));
                }
            } else {
                logError(Arrays.toString(new IllegalStateException("initMMKV when context null").getStackTrace()));
            }
        }
    }

    private static boolean isTypeStrSet(Object obj) {
        if (obj instanceof Set) {
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                if (it.next() instanceof String) {
                    return true;
                }
            }
        }
        if (obj instanceof HashSet) {
            Iterator it5 = ((HashSet) obj).iterator();
            while (it5.hasNext()) {
                if (it5.next() instanceof String) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void logDebug(String str) {
        if (mmkvFileHandler != null) {
            mmkvFileHandler.logDebug("QMMKV", str);
        }
    }

    public static void logError(String str) {
        if (mmkvFileHandler != null) {
            mmkvFileHandler.logError("QMMKV", str);
        }
    }

    public static void logInfo(String str) {
        if (mmkvFileHandler != null) {
            mmkvFileHandler.logInfo("QMMKV", str);
        }
    }

    public static void logWarn(String str) {
        if (mmkvFileHandler != null) {
            mmkvFileHandler.logWarn("QMMKV", str);
        }
    }

    @Deprecated
    public static boolean migrate(Context context, String str, SharedPreferences sharedPreferences) {
        return migrateV2(context, str, sharedPreferences, false);
    }

    @Deprecated
    public static boolean migrateToSpAdapter(Context context, String str, String str2) {
        return migrateToSpAdapterV2(context, str, 4, str2, false);
    }

    public static boolean migrateToSpAdapterV2(Context context, String str, String str2, boolean z16) {
        return migrateToSpAdapterV2(context, str, 4, str2, z16);
    }

    public static boolean migrateV2(Context context, String str, SharedPreferences sharedPreferences, boolean z16) {
        Map<String, ?> all;
        int i3;
        if (sharedPreferences != null && (all = sharedPreferences.getAll()) != null && all.size() > 0) {
            if (z16) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            MMKVOptionEntityV2 fromV2 = fromV2(context, str, 2, i3);
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    if (value instanceof Boolean) {
                        fromV2.encodeBool(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        fromV2.encodeInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        fromV2.encodeLong(key, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        fromV2.encodeFloat(key, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        fromV2.encodeDouble(key, ((Double) value).doubleValue());
                    } else if (value instanceof String) {
                        fromV2.encodeString(key, (String) value);
                    } else if (isTypeStrSet(value)) {
                        fromV2.encodeStringSet(key, (Set) value);
                    } else {
                        logError("migrate unknown type: " + value.getClass());
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Deprecated
    private static MMKVOptionEntity mmkvCreateInstance(Context context, String str, int i3) {
        try {
            if (mmkvInited) {
                if (mmkvFileHandler.isFileAvailable(str)) {
                    logDebug("mmkvCreateInstance id:" + str + ", mode:" + i3);
                    return new MMKVOptionEntity(str, i3, mmkvFileHandler, mmkvFileHandler.provideMemoryCache());
                }
                throw new IllegalStateException("mmkvCreateInstance file not registered.");
            }
            throw new IllegalStateException("mmkvCreateInstance without init!!!");
        } catch (RuntimeException | UnsatisfiedLinkError e16) {
            if (mmkvFileHandler != null) {
                logError(e16.getMessage() + MsgSummary.STR_COLON + Arrays.toString(e16.getStackTrace()));
                return null;
            }
            Log.e("QMMKV", e16.getMessage(), e16);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.mobileqq.qmmkv.v2.a] */
    private static MMKVOptionEntityV2 mmkvCreateInstanceV2(Context context, String str, int i3, int i16) {
        boolean z16;
        boolean z17;
        try {
            if (mmkvInited) {
                if (mmkvFileHandler.isFileAvailable(str)) {
                    logDebug("mmkvCreateInstanceV2 id:" + str + ", mode:" + i3 + ", rule:" + i16);
                    com.tencent.mobileqq.qmmkv.v2.k provideMemoryCache = mmkvFileHandler.provideMemoryCache();
                    boolean z18 = false;
                    if (i16 == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (i16 == 2) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z16 | z17) {
                        if (i16 == 1) {
                            z18 = true;
                        }
                        provideMemoryCache = new com.tencent.mobileqq.qmmkv.v2.a(z18, provideMemoryCache);
                    }
                    return new MMKVOptionEntityV2(str, i3, mmkvFileHandler, provideMemoryCache);
                }
                throw new IllegalStateException("mmkvCreateInstanceV2 file not registered.");
            }
            throw new IllegalStateException("mmkvCreateInstanceV2 without init!!!");
        } catch (RuntimeException | UnsatisfiedLinkError e16) {
            if (mmkvFileHandler != null) {
                logError(e16.getMessage() + MsgSummary.STR_COLON + Arrays.toString(e16.getStackTrace()));
                return null;
            }
            Log.e("QMMKV", e16.getMessage(), e16);
            return null;
        }
    }

    @NonNull
    public static MMKVOptionEntityV2 withAccount(Context context, String str) {
        return fromV2(context, str, 2, 2);
    }

    @NonNull
    public static MMKVOptionEntityV2 withoutAccount(Context context, String str) {
        return fromV2(context, str, 2, 1);
    }

    @Deprecated
    public static boolean migrateToSpAdapter(Context context, String str, int i3, String str2) {
        return migrateToSpAdapterV2(context, str, i3, str2, false);
    }

    public static boolean migrateToSpAdapterV2(Context context, String str, int i3, String str2, boolean z16) {
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, i3);
        return migrateToSpAdapterV2(context, str, str2, sharedPreferences != null ? sharedPreferences.getAll() : null, z16);
    }

    public static boolean migrateToSpAdapter(Context context, String str, String str2, Map<String, ?> map) {
        return migrateToSpAdapterV2(context, str, str2, map, false);
    }

    public static boolean migrateToSpAdapterV2(Context context, String str, String str2, Map<String, ?> map, boolean z16) {
        if (context == null || map == null || map.size() <= 0) {
            return false;
        }
        MMKVAdapter mMKVAdapter = (MMKVAdapter) fromSpAdapterV2(context, str, str2, z16);
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null) {
                if (value instanceof Boolean) {
                    mMKVAdapter.putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    mMKVAdapter.putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    mMKVAdapter.putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    mMKVAdapter.putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof String) {
                    mMKVAdapter.putString(key, (String) value);
                } else if (isTypeStrSet(value)) {
                    mMKVAdapter.putStringSet(key, (Set) value);
                } else {
                    logError("migrateToSpAdapter error: " + value.getClass());
                }
            }
        }
        return true;
    }

    @NonNull
    @Deprecated
    public static MMKVOptionEntity from(Context context, String str) {
        return from(context, str, 2);
    }

    @NonNull
    public static MMKVOptionEntityV2 fromV2(Context context, String str) {
        return fromV2(context, str, 2, 0);
    }
}
