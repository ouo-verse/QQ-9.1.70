package com.tenpay.ndk;

import android.content.Context;
import android.text.TextUtils;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncApi;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CftSoLoader {
    private static final String BUILDIN_CFTSO_NAME = "cftutils_v1.3.1";
    private static final String BUILDIN_VERSION = "1.3.1";
    public static final String VERSION_1_2_6 = "1.2.6";
    public static final String VERSION_1_3_1 = "1.3.1";
    public static String currentVersionName = null;
    private static boolean loaded = false;
    public static final Object lock = new Object();

    private static int[] getIntArray(String str) {
        try {
            String[] split = str.split("\\.");
            int[] iArr = new int[split.length];
            for (int i3 = 0; i3 < split.length; i3++) {
                iArr[i3] = Integer.parseInt(split[i3]);
            }
            return iArr;
        } catch (NumberFormatException e16) {
            QwLog.e(e16.toString());
            return null;
        }
    }

    public static boolean isNewVersion(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int[] intArray = getIntArray(str);
            int[] intArray2 = getIntArray(str2);
            if (intArray != null && intArray.length >= 3 && intArray2 != null && intArray2.length >= 3) {
                int i3 = intArray[0];
                int i16 = intArray2[0];
                if (i3 > i16) {
                    return true;
                }
                if (i3 == i16 && intArray[1] > intArray2[1]) {
                    return true;
                }
                if (i3 == i16 && intArray[1] == intArray2[1] && intArray[2] >= intArray2[2]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void loadLibrary(Context context, String str) {
        try {
            System.loadLibrary(str);
        } finally {
            try {
            } catch (Throwable th5) {
            }
        }
    }

    public static void loadSo(Context context) {
        if (!loaded) {
            synchronized (lock) {
                if (!loaded) {
                    try {
                        QwLog.i("load so lib...");
                        String loadDynamicSo = QFuncApi.loadDynamicSo();
                        currentVersionName = loadDynamicSo;
                        if (TextUtils.isEmpty(loadDynamicSo)) {
                            loadLibrary(context, BUILDIN_CFTSO_NAME);
                            currentVersionName = "1.3.1";
                        }
                        loaded = true;
                    } catch (Throwable th5) {
                        QwLog.i("loadSo: " + th5);
                    }
                }
            }
        }
    }
}
