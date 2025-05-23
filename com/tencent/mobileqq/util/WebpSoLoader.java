package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebpSoLoader {

    /* renamed from: a, reason: collision with root package name */
    public static int[] f306528a;

    public static void a(String str) {
        if (f306528a != null && str != null) {
            if (str.contains("libwebp-") || str.contains("libskia")) {
                BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit().putBoolean("WebpHookSupported", false).commit();
                f306528a = null;
                if (QLog.isColorLevel()) {
                    QLog.d("WebpSoLoader", 2, String.format("Crash in libwebp support library at %s process!", MsfSdkUtils.getProcessName(BaseApplication.getContext())));
                }
            }
        }
    }

    public static int[] b() {
        int[] iArr = f306528a;
        if (iArr != null) {
            return iArr;
        }
        return new int[]{0, 4, 1, 0};
    }

    public static String c(Context context) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return null;
        }
        return filesDir.getParent() + SoLoadCore.PATH_TX_LIB;
    }

    public static boolean d() {
        return false;
    }

    private static native int nativeGetDecoderVersion();

    private static native int nativeSetup();

    public static void e(boolean z16) {
    }
}
