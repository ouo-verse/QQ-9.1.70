package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    private static Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        String str2;
        if (cls == null) {
            throw new a("class is null in invokeStaticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new a("paramsType is null, but params is not null");
            }
        } else {
            if (objArr == null) {
                throw new a("paramsType or params should be same");
            }
            if (clsArr.length != objArr.length) {
                throw new a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
            }
        }
        try {
            try {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException unused) {
                str2 = "invokeStaticFun(): method invoke Exception!";
                v.f("hmsSdk", str2);
                return null;
            } catch (IllegalArgumentException unused2) {
                str2 = "invokeStaticFun(): Illegal Argument!";
                v.f("hmsSdk", str2);
                return null;
            } catch (InvocationTargetException unused3) {
                str2 = "invokeStaticFun(): Invocation Target Exception!";
                v.f("hmsSdk", str2);
                return null;
            }
        } catch (NoSuchMethodException unused4) {
            v.f("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
        }
    }

    public static String b() {
        String a16 = a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        v.c("hmsSdk", "SystemPropertiesEx: get rom_ver: " + a16);
        if (!TextUtils.isEmpty(a16)) {
            return a16;
        }
        String str = Build.DISPLAY;
        v.c("hmsSdk", "SystemProperties: get rom_ver: " + str);
        return str;
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        return context.getPackageName();
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), c(context), 16384).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            v.f("hmsSdk", "getVersion(): The package name is not correct!");
            return "";
        }
    }

    private static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return a(Class.forName(str), str2, clsArr, objArr);
        } catch (a unused) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            v.f("hmsSdk", str3);
            return null;
        } catch (ClassNotFoundException unused2) {
            str3 = "invokeStaticFun() Not found class!";
            v.f("hmsSdk", str3);
            return null;
        }
    }

    public static String b(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("CHANNEL")) == null) {
                return "Unknown";
            }
            String obj2 = obj.toString();
            return obj2.length() > 256 ? "Unknown" : obj2;
        } catch (PackageManager.NameNotFoundException unused) {
            v.f("hmsSdk", "getChannel(): The packageName is not correct!");
            return "Unknown";
        }
    }

    public static String a() {
        return a("ro.build.version.emui", "");
    }

    @SuppressLint({"HardwareIds"})
    public static String a(Context context) {
        return context == null ? "" : DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String a16 = a(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME, str, str2);
        return TextUtils.isEmpty(a16) ? a("com.huawei.android.os.SystemPropertiesEx", str, str2) : a16;
    }

    private static String a(String str, String str2, String str3) {
        Object a16 = a(str, "get", new Class[]{String.class, String.class}, new Object[]{str2, str3});
        return a16 != null ? (String) a16 : str3;
    }
}
