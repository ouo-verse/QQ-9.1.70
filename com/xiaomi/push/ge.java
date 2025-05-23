package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ge {

    /* renamed from: a, reason: collision with root package name */
    private static String f388951a;

    /* renamed from: b, reason: collision with root package name */
    private static String f388952b;

    /* renamed from: c, reason: collision with root package name */
    private static String f388953c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f388954d = String.valueOf((char) 2);

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f388955e = {"--", "a-", "u-", "v-", "o-", "g-", "d-"};

    /* renamed from: f, reason: collision with root package name */
    private static final Set<String> f388956f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f388957g;

    static {
        HashSet hashSet = new HashSet();
        f388956f = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        hashSet.add("com.xiaomi.finddevice");
        hashSet.add("com.miui.securitycenter");
        f388957g = true;
    }

    public static synchronized String A(Context context) {
        String k3;
        synchronized (ge.class) {
            k3 = ag.k(p(context) + ((String) null));
        }
        return k3;
    }

    public static String B(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    @Deprecated
    private static String C(Context context) {
        return "";
    }

    private static String D(Context context) {
        String string = context.getSharedPreferences("device_info", 0).getString("default_id", null);
        if (TextUtils.isEmpty(string)) {
            String E = E(context);
            i(context, E);
            return E;
        }
        return string;
    }

    private static String E(Context context) {
        return aa.a(Build.BRAND + "_" + ia.a() + "_" + Build.VERSION.SDK_INT + "_" + Build.VERSION.RELEASE + "_" + Build.VERSION.INCREMENTAL + "_" + c() + "_" + context.getPackageName() + "_" + System.currentTimeMillis() + "_" + ag.a(16));
    }

    private static double a(double d16) {
        int i3 = 1;
        while (true) {
            double d17 = i3;
            if (d17 < d16) {
                i3 <<= 1;
            } else {
                return d17;
            }
        }
    }

    private static float b(int i3) {
        float f16 = ((((((i3 + RFixConstants.MD5_FILE_BUF_LENGTH) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d16 = f16;
        if (d16 > 0.5d) {
            return (float) Math.ceil(d16);
        }
        return f16;
    }

    @TargetApi(17)
    public static int c() {
        Object g16 = y.g("android.os.UserHandle", "myUserId", new Object[0]);
        if (g16 == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(g16)).intValue();
    }

    private static long d(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static String e() {
        return b(n()) + "GB";
    }

    private static String f(int i3) {
        if (i3 > 0) {
            String[] strArr = f388955e;
            if (i3 < strArr.length) {
                return strArr[i3];
            }
        }
        return f388955e[0];
    }

    @Deprecated
    public static String g(Context context) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[Catch: all -> 0x00ce, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x0016, B:11:0x001b, B:12:0x0020, B:16:0x0030, B:18:0x0036, B:21:0x003d, B:23:0x004b, B:24:0x0096, B:26:0x00ae, B:27:0x00b1, B:28:0x005c, B:30:0x006a, B:33:0x0076, B:36:0x007e, B:37:0x0084, B:39:0x00ca), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1 A[Catch: all -> 0x00ce, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x0016, B:11:0x001b, B:12:0x0020, B:16:0x0030, B:18:0x0036, B:21:0x003d, B:23:0x004b, B:24:0x0096, B:26:0x00ae, B:27:0x00b1, B:28:0x005c, B:30:0x006a, B:33:0x0076, B:36:0x007e, B:37:0x0084, B:39:0x00ca), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String h(Context context, boolean z16) {
        String str;
        boolean z17;
        String C;
        synchronized (ge.class) {
            if (f388952b == null) {
                String p16 = p(context);
                String str2 = "";
                if (!hz.t()) {
                    if (z16) {
                        C = t(context);
                    } else {
                        C = C(context);
                    }
                    str2 = C;
                }
                String g16 = g(context);
                int i3 = 1;
                if (Build.VERSION.SDK_INT < 26) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 && r(str2) && r(g16)) {
                    String e16 = q.a(context).e();
                    if (!TextUtils.isEmpty(e16)) {
                        p16 = e16 + p16;
                        i3 = 2;
                    } else {
                        String a16 = q.a(context).a();
                        if (!TextUtils.isEmpty(a16) && !a16.startsWith("00000000-0000-0000-0000-000000000000")) {
                            i3 = 4;
                            p16 = a16;
                        } else if (!TextUtils.isEmpty(p16)) {
                            i3 = 5;
                        } else {
                            p16 = D(context);
                            i3 = 6;
                        }
                    }
                    jz4.c.w("devid rule select:" + i3);
                    if (i3 != 3) {
                        f388952b = p16;
                    } else {
                        f388952b = f(i3) + ag.k(p16);
                    }
                }
                p16 = str2 + p16 + g16;
                jz4.c.w("devid rule select:" + i3);
                if (i3 != 3) {
                }
            }
            str = f388952b;
        }
        return str;
    }

    private static void i(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info", 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("default_id", null))) {
            sharedPreferences.edit().putString("default_id", str).apply();
        } else {
            jz4.c.m("default_id exist,do not change it.");
        }
    }

    public static boolean j() {
        if (c() <= 0) {
            return true;
        }
        return false;
    }

    public static boolean k(Context context) {
        Intent c16 = ie.c(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), null, null);
        if (c16 == null) {
            return false;
        }
        int intExtra = c16.getIntExtra("status", -1);
        if (intExtra != 2 && intExtra != 5) {
            return false;
        }
        return true;
    }

    public static boolean l(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) y.e(context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && (applicationInfo.flags & 8388608) == 8388608) {
            return false;
        }
        return true;
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i3 = 0;
        while (true) {
            String[] strArr = f388955e;
            if (i3 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i3])) {
                return true;
            }
            i3++;
        }
    }

    public static int n() {
        BufferedReader bufferedReader;
        Throwable th5;
        String[] split;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                } catch (Exception unused) {
                } catch (Throwable th6) {
                    bufferedReader = null;
                    th5 = th6;
                }
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                        Integer.parseInt(split[1]);
                    }
                    bufferedReader.close();
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return 0;
                } catch (Throwable th7) {
                    th5 = th7;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th5;
                }
            } catch (IOException unused4) {
            }
        }
        return 0;
    }

    public static String o() {
        return a(((d(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    public static String p(Context context) {
        String str = f388951a;
        if (str == null && f388957g) {
            boolean u16 = u(context);
            f388957g = u16;
            if (!u16) {
                return null;
            }
            try {
                f388951a = DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
            } catch (Throwable th5) {
                jz4.c.m("failure to get androidId: " + th5);
            }
            return f388951a;
        }
        return str;
    }

    public static boolean q(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null && !powerManager.isScreenOn()) {
            return false;
        }
        return true;
    }

    private static boolean r(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        if (trim.length() == 0 || trim.equalsIgnoreCase("null") || trim.equalsIgnoreCase("unknown")) {
            return true;
        }
        return false;
    }

    public static String s() {
        return n() + "KB";
    }

    @Deprecated
    public static String t(Context context) {
        return null;
    }

    private static boolean u(Context context) {
        Bundle bundle;
        ApplicationInfo applicationInfo;
        Bundle bundle2;
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 128);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && (bundle2 = applicationInfo.metaData) != null && bundle2.containsKey("supportGetAndroidID")) {
                boolean z16 = packageInfo.applicationInfo.metaData.getBoolean("supportGetAndroidID", true);
                jz4.c.x("DeviceInfo", "Get supportGetAndroidID from app metaData: " + z16);
                return z16;
            }
        } catch (Exception e16) {
            jz4.c.A("DeviceInfo", "Check supportGetAndroidID from app metaData error: " + e16.getMessage());
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
            intent.setComponent(componentName);
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(componentName, 128);
            if (serviceInfo != null && (bundle = serviceInfo.metaData) != null && bundle.containsKey("supportGetAndroidID")) {
                jz4.c.x("DeviceInfo", "The metaData of XMPushService contains key supportGetAndroidID,so return false.");
                return false;
            }
        } catch (Exception e17) {
            jz4.c.A("DeviceInfo", "Check supportGetAndroidID from XMPushService metaData error: " + e17.getMessage());
        }
        jz4.c.x("DeviceInfo", "Not configure the metaData key of supportGetAndroidID\uff0creturn true by default.");
        return true;
    }

    public static String v() {
        return (d(Environment.getDataDirectory()) / 1024) + "KB";
    }

    @Deprecated
    public static String w(Context context) {
        return null;
    }

    @Deprecated
    public static String x(Context context) {
        return null;
    }

    @Deprecated
    public static String y(Context context) {
        return "";
    }

    public static synchronized String z(Context context) {
        synchronized (ge.class) {
            String str = f388953c;
            if (str != null) {
                return str;
            }
            String k3 = ag.k(p(context) + g(context));
            f388953c = k3;
            return k3;
        }
    }
}
