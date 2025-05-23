package com.tencent.liteav.base.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SoLoader {
    private static final String TAG = "SoLoader";
    private static ExternalSoLoader mExternalSoLoader = null;
    private static boolean mHasLoaded = false;
    private static String mLibraryPath = "";
    private static final Object mLoadLock = new Object();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface ExternalSoLoader {
        boolean loadLibrary(String[] strArr);
    }

    public static String getLibraryPath() {
        return mLibraryPath;
    }

    public static boolean loadAllLibraries() {
        boolean z16;
        synchronized (mLoadLock) {
            if (!mHasLoaded) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("txsoundtouch");
                arrayList.add("txffmpeg");
                arrayList.add("liteavsdk");
                if (mExternalSoLoader != null) {
                    mHasLoaded = loadLibraryByExternal((String[]) arrayList.toArray(new String[arrayList.size()]));
                } else if (!TextUtils.isEmpty(mLibraryPath)) {
                    mHasLoaded = loadLibraryInCustomerPath((String[]) arrayList.toArray(new String[arrayList.size()]));
                } else {
                    mHasLoaded = loadLibraryDefault((String[]) arrayList.toArray(new String[arrayList.size()]));
                }
            }
            z16 = mHasLoaded;
        }
        return z16;
    }

    public static boolean loadLibrary(String str) {
        try {
            synchronized (mLoadLock) {
                ExternalSoLoader externalSoLoader = mExternalSoLoader;
                if (externalSoLoader != null) {
                    return externalSoLoader.loadLibrary(new String[]{str});
                }
                if (!TextUtils.isEmpty(mLibraryPath)) {
                    boolean loadLibrary = loadLibrary(mLibraryPath, str);
                    Log.w(TAG, "load library " + str + " in customer path:" + loadLibrary);
                    return loadLibrary;
                }
                Log.w(TAG, "load library " + str + " from system path ");
                System.loadLibrary(str);
                return true;
            }
        } catch (Throwable th5) {
            Log.w(TAG, "load library " + str + " failed: " + th5);
            return false;
        }
    }

    private static boolean loadLibraryByExternal(String[] strArr) {
        ExternalSoLoader externalSoLoader = mExternalSoLoader;
        if (externalSoLoader != null && strArr != null && strArr.length != 0) {
            try {
                boolean loadLibrary = externalSoLoader.loadLibrary(strArr);
                Log.i(TAG, "load libraries " + Arrays.toString(strArr) + " by external: " + loadLibrary);
                return loadLibrary;
            } catch (Throwable th5) {
                Log.w(TAG, "load libraries " + Arrays.toString(strArr) + " by external: " + th5);
            }
        }
        return false;
    }

    private static boolean loadLibraryDefault(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            try {
                for (String str : strArr) {
                    System.loadLibrary(str);
                    Log.i(TAG, "load library " + str + " in default path success.");
                }
                return true;
            } catch (Throwable th5) {
                Log.w(TAG, "load libraries " + Arrays.toString(strArr) + " in default path error: " + th5);
            }
        }
        return false;
    }

    private static boolean loadLibraryInCustomerPath(String[] strArr) {
        int i3 = 0;
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(mLibraryPath)) {
            return false;
        }
        int length = strArr.length;
        boolean z16 = false;
        while (i3 < length) {
            String str = strArr[i3];
            boolean loadLibrary = loadLibrary(mLibraryPath, str);
            Log.i(TAG, "load library " + str + " in customer path:" + loadLibrary);
            if (loadLibrary) {
                i3++;
                z16 = loadLibrary;
            } else {
                return loadLibrary;
            }
        }
        return z16;
    }

    public static void setExternalSoLoader(ExternalSoLoader externalSoLoader) {
        synchronized (mLoadLock) {
            mExternalSoLoader = externalSoLoader;
        }
    }

    public static void setLibraryPath(String str) {
        Log.w(TAG, "setLibraryPath ".concat(String.valueOf(str)));
        mLibraryPath = str;
    }

    private static boolean loadLibrary(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Log.w(TAG, "load library " + str2 + " from path " + str);
            System.load(str + "/lib" + str2 + ".so");
            return true;
        } catch (Throwable th5) {
            Log.w(TAG, "load library " + str2 + "in path" + str + " failed: " + th5);
            return false;
        }
    }
}
