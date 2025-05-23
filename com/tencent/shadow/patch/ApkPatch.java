package com.tencent.shadow.patch;

import com.tencent.qphone.base.util.QLog;

/* loaded from: classes25.dex */
public class ApkPatch {
    private static final String TAG = "ApkPatch";
    private static boolean isLoadPatchApkSoSuccess = false;

    public static boolean loadSo(String str) {
        try {
            System.load(str);
            isLoadPatchApkSoSuccess = true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "load patch apk so fail, ex:" + th5);
        }
        return isLoadPatchApkSoSuccess;
    }

    private static native int normalize(String str, String str2);

    public static boolean normalizeZip(String str, String str2) {
        if (normalize(str, str2) == 1) {
            return true;
        }
        return false;
    }

    public static int patch(String str, String str2, String str3) {
        if (!isLoadPatchApkSoSuccess) {
            return -1;
        }
        int patch = patch(str, str2, str3, 0L, null, 2);
        QLog.e(TAG, 1, "patch code:" + patch);
        return patch;
    }

    private static native int patch(String str, String str2, String str3, long j3, String str4, int i3);
}
