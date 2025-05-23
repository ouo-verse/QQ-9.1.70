package com.huawei.hms.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SystemUtils {
    public static final String UNKNOWN = "unknown";

    private static String a() {
        return getSystemProperties("ro.product.locale", "");
    }

    private static String b() {
        return getSystemProperties("ro.product.locale.region", "");
    }

    public static String getAndoridVersion() {
        return getSystemProperties("ro.build.version.release", "unknown");
    }

    public static String getLocalCountry() {
        Locale locale = Locale.getDefault();
        if (locale != null) {
            return locale.getCountry();
        }
        return "";
    }

    public static String getManufacturer() {
        return getSystemProperties("ro.product.manufacturer", "unknown");
    }

    public static long getMegabyte(double d16) {
        double d17;
        if (Build.VERSION.SDK_INT > 25) {
            d17 = 1000.0d;
        } else {
            d17 = 1024.0d;
        }
        return (long) (d16 * d17 * d17);
    }

    public static String getNetType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            return NetworkMonitor.getTypeName(activeNetworkInfo);
        }
        return "";
    }

    public static String getPhoneModel() {
        return getSystemProperties("ro.product.model", "unknown");
    }

    public static String getSystemProperties(String str, String str2) {
        try {
            return (String) SystemProperties.class.getDeclaredMethod("get", String.class, String.class).invoke(SystemProperties.class, str, str2);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + str);
            return str2;
        }
    }

    public static boolean isChinaROM() {
        String b16 = b();
        if (!TextUtils.isEmpty(b16)) {
            return "cn".equalsIgnoreCase(b16);
        }
        String a16 = a();
        if (!TextUtils.isEmpty(a16)) {
            return a16.toLowerCase(Locale.US).contains("cn");
        }
        String localCountry = getLocalCountry();
        if (!TextUtils.isEmpty(localCountry)) {
            return "cn".equalsIgnoreCase(localCountry);
        }
        return false;
    }

    public static boolean isEMUI() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("is Emui :");
        int i3 = HwBuildEx.VERSION.EMUI_SDK_INT;
        sb5.append(i3);
        HMSLog.i("SystemUtils", sb5.toString());
        if (i3 > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isSystemApp(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 16384);
        } catch (AndroidException e16) {
            HMSLog.e("SystemUtils", "isSystemApp Exception: " + e16);
            packageInfo = null;
            if (packageInfo == null) {
            }
            return false;
        } catch (RuntimeException e17) {
            HMSLog.e("SystemUtils", "isSystemApp RuntimeException:" + e17);
            packageInfo = null;
            if (packageInfo == null) {
            }
            return false;
        }
        if (packageInfo == null && (packageInfo.applicationInfo.flags & 1) > 0) {
            return true;
        }
        return false;
    }

    public static boolean isTVDevice() {
        return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
    }
}
