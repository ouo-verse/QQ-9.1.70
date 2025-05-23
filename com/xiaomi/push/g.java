package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import com.vivo.push.PushClientConstants;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum b {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);


        /* renamed from: a, reason: collision with other field name */
        private final int f24725a;

        b(int i3) {
            this.f24725a = i3;
        }

        public int a() {
            return this.f24725a;
        }
    }

    public static int a(Context context) {
        Bundle bundle;
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(PushClientConstants.COM_ANDROID_SYSTEMUI, 128);
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getInt("SupportForPushVersionCode");
                }
                return 0;
            } catch (PackageManager.NameNotFoundException unused) {
                return 0;
            }
        }
        return 0;
    }

    public static int b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    private static ApplicationInfo c(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            jz4.c.m("not found app info " + str);
            return null;
        }
    }

    public static Drawable d(Context context, String str) {
        ApplicationInfo c16 = c(context, str);
        Drawable drawable = null;
        if (c16 != null) {
            try {
                drawable = c16.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = c16.loadLogo(context.getPackageManager());
                }
            } catch (Exception e16) {
                jz4.c.m("get app icon drawable failed, " + e16);
            }
        }
        if (drawable == null) {
            return new ColorDrawable(0);
        }
        return drawable;
    }

    private static b e(Context context, ApplicationInfo applicationInfo) {
        Object systemService;
        Boolean bool;
        boolean areNotificationsEnabled;
        int i3 = Build.VERSION.SDK_INT;
        if (applicationInfo != null && i3 >= 24) {
            try {
                if (applicationInfo.packageName.equals(context.getPackageName())) {
                    areNotificationsEnabled = ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
                    bool = Boolean.valueOf(areNotificationsEnabled);
                } else {
                    if (i3 >= 29) {
                        systemService = y.e(context.getSystemService("notification"), "getService", new Object[0]);
                    } else {
                        systemService = context.getSystemService("security");
                    }
                    if (systemService != null) {
                        bool = (Boolean) y.n(systemService, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                    } else {
                        bool = null;
                    }
                }
                if (bool != null) {
                    if (bool.booleanValue()) {
                        return b.ALLOWED;
                    }
                    return b.NOT_ALLOWED;
                }
            } catch (Exception e16) {
                jz4.c.m("are notifications enabled error " + e16);
            }
            return b.UNKNOWN;
        }
        return b.UNKNOWN;
    }

    @TargetApi(19)
    public static b f(Context context, String str, boolean z16) {
        ApplicationInfo applicationInfo;
        b e16;
        b bVar;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (str.equals(context.getPackageName())) {
                    applicationInfo = context.getApplicationInfo();
                } else {
                    applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
                }
                e16 = e(context, applicationInfo);
                bVar = b.UNKNOWN;
            } catch (Throwable th5) {
                jz4.c.m("get app op error " + th5);
            }
            if (e16 != bVar) {
                return e16;
            }
            Integer num = (Integer) y.b(AppOpsManager.class, "OP_POST_NOTIFICATION");
            if (num == null) {
                return bVar;
            }
            Integer num2 = (Integer) y.e((AppOpsManager) context.getSystemService("appops"), AudioRecorderJsPlugin.AudioManager.FUNCTION_NAME_CHECK_OP_NOT_THROW, num, Integer.valueOf(applicationInfo.uid), str);
            int i3 = (Integer) y.b(AppOpsManager.class, "MODE_ALLOWED");
            int i16 = (Integer) y.b(AppOpsManager.class, "MODE_IGNORED");
            jz4.c.w(String.format("get app mode %s|%s|%s", num2, i3, i16));
            if (i3 == null) {
                i3 = 0;
            }
            if (i16 == null) {
                i16 = 1;
            }
            if (num2 != null) {
                if (z16) {
                    if (!num2.equals(i16)) {
                        return b.ALLOWED;
                    }
                    return b.NOT_ALLOWED;
                }
                if (num2.equals(i3)) {
                    return b.ALLOWED;
                }
                return b.NOT_ALLOWED;
            }
            return b.UNKNOWN;
        }
        return b.UNKNOWN;
    }

    public static String g() {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            str = Application.getProcessName();
        } else {
            str = (String) y.g("android.app.ActivityThread", "currentProcessName", new Object[0]);
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "";
    }

    public static String h(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return "1.0";
    }

    public static Map<String, String> i(Context context, String str) {
        return null;
    }

    public static void j(Context context, ApplicationInfo applicationInfo, boolean z16) {
        Object systemService;
        int i3 = Build.VERSION.SDK_INT;
        if (b.ALLOWED != e(context, applicationInfo)) {
            try {
                if (i3 >= 29) {
                    systemService = y.e(context.getSystemService("notification"), "getService", new Object[0]);
                } else {
                    systemService = context.getSystemService("security");
                }
                if (systemService != null) {
                    y.n(systemService, "setNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid), Boolean.valueOf(z16));
                }
            } catch (Exception e16) {
                jz4.c.m("set notifications enabled error " + e16);
            }
        }
    }

    public static boolean k(Context context) {
        String g16 = g();
        if (!TextUtils.isEmpty(g16) && context != null) {
            return g16.equals(context.getPackageName());
        }
        return false;
    }

    public static boolean l(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || hz.i()) {
            return false;
        }
        return context.getPackageName().equals(str);
    }

    public static int m(Context context, String str) {
        ApplicationInfo c16 = c(context, str);
        if (c16 != null) {
            int i3 = c16.icon;
            if (i3 == 0) {
                return c16.logo;
            }
            return i3;
        }
        return 0;
    }

    public static String n(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 0);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                return packageManager.getApplicationLabel(applicationInfo).toString();
            }
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return str;
        }
    }

    public static boolean o(Context context, String str) {
        return false;
    }

    public static boolean p(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        return true;
    }

    public static boolean q(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                    return str.equals(DeviceInfoMonitor.getString(context.getContentResolver(), "freeform_package_name"));
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }
}
