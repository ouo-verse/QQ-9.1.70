package com.tencent.ark.open;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.ark.Logger;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkUtil {
    private static final String TAG = "ArkApp.ArkUtil";
    public static volatile boolean sARMv7Compatible = false;

    static {
        String str = Build.CPU_ABI;
        String str2 = Build.CPU_ABI2;
        if (checkCPUABIStringV7(str).booleanValue() || checkCPUABIStringV7(str2).booleanValue()) {
            sARMv7Compatible = true;
        }
        if (sARMv7Compatible && DeviceInfoMonitor.getModel().contains("Android SDK built for x86")) {
            sARMv7Compatible = false;
            Logger.logI(TAG, "sARMv7Compatible set false for MODEL: ", DeviceInfoMonitor.getModel());
        }
    }

    public static void assertTrue(boolean z16) {
        if (z16) {
        } else {
            throw new AssertionError();
        }
    }

    private static Boolean checkCPUABIStringV7(String str) {
        boolean z16;
        if (!str.equalsIgnoreCase("armeabi-v7a") && !str.equalsIgnoreCase("arm64-v8a")) {
            z16 = false;
        } else {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }

    public static void checkVersion(boolean z16) {
        if (sARMv7Compatible && DeviceInfoMonitor.getModel().contains("Android SDK built for x86") && !z16) {
            sARMv7Compatible = false;
            Logger.logI(TAG, "checkVersion sARMv7Compatible set false for MODEL: ", DeviceInfoMonitor.getModel(), ",isdebug=", Boolean.valueOf(z16));
        }
    }

    public static void createDir(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.logE(TAG, "create dir path is empty");
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            Logger.logE(TAG, "create dir find dir path is file need to delte, path = ", str);
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void delete(String str, boolean z16) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            delete(file2.getAbsolutePath(), z16);
        }
        if (!z16) {
            file.delete();
        }
    }

    public static boolean fileExists(String str) {
        if (str == null || !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static String filterKeyForLog(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replaceAll("((?i)sid|uin|sec_sig|MOBINFO|address)=[^&#]+", "$1=****");
    }

    public static boolean isDeviceSupportArkMsg() {
        return sARMv7Compatible;
    }

    public static boolean rename(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        return file.renameTo(new File(str2));
    }
}
