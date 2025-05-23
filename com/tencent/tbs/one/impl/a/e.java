package com.tencent.tbs.one.impl.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.tbs.one.TBSOnePrivacy;
import com.tencent.tbs.one.impl.a.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static String f374565a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f374566b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f374567c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f374568d = "";

    /* renamed from: e, reason: collision with root package name */
    private static String f374569e = "";

    /* renamed from: f, reason: collision with root package name */
    private static String f374570f = null;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f374571g = false;

    public static void a(String str) {
        f374565a = str;
    }

    public static void b(String str) {
        f374566b = str;
    }

    public static String c() {
        return "";
    }

    public static String d() {
        return Build.CPU_ABI;
    }

    public static String e(Context context) {
        if (!TextUtils.isEmpty(f374570f)) {
            return f374570f;
        }
        StringBuilder sb5 = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        try {
            str = new String(str.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(str)) {
            str = "1.0";
        }
        sb5.append(str);
        sb5.append("; ");
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        if (language != null) {
            sb5.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                sb5.append("-");
                sb5.append(country.toLowerCase());
            }
        } else {
            sb5.append("en");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String b16 = b(context);
            try {
                b16 = new String(b16.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception unused2) {
            }
            sb5.append("; ");
            if (TextUtils.isEmpty(b16)) {
                b16 = "";
            }
            sb5.append(b16);
        }
        String str2 = Build.ID;
        String replaceAll = str2 == null ? null : str2.replaceAll("[\u4e00-\u9fa5]", "");
        sb5.append(" Build/");
        if (TextUtils.isEmpty(replaceAll)) {
            replaceAll = "00";
        }
        sb5.append(replaceAll);
        String format = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", sb5);
        f374570f = format;
        return format;
    }

    public static List<ActivityManager.RunningAppProcessInfo> f(Context context) {
        ActivityManager activityManager;
        if (f374571g || (activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) == null) {
            return null;
        }
        return SystemMethodProxy.getRunningAppProcesses(activityManager);
    }

    public static boolean g(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected() || NetworkMonitor.getType(activeNetworkInfo) != 1) {
            return false;
        }
        return true;
    }

    public static String a() {
        return f374565a;
    }

    public static String b() {
        return f374566b;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f374566b)) {
            try {
                return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
            } catch (Throwable unused) {
                return "";
            }
        }
        return f374566b;
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(f374569e)) {
            try {
                f374569e = context.getPackageName();
            } catch (Throwable unused) {
            }
        }
        return f374569e;
    }

    public static String a(Context context) {
        return TBSOnePrivacy.AndroidId.get(context);
    }

    public static String b(Context context) {
        TBSOnePrivacy tBSOnePrivacy = TBSOnePrivacy.DeviceModel;
        if (tBSOnePrivacy.isDisabled()) {
            return "";
        }
        try {
            if (a.a(context, a.EnumC9884a.Mqq)) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("uifa", 0);
                String string = sharedPreferences.getString("model", "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                String model = DeviceInfoMonitor.getModel();
                sharedPreferences.edit().putString("model", model).commit();
                return model;
            }
            if (a.a(context, a.EnumC9884a.Mtt, a.EnumC9884a.SogouExplorer, a.EnumC9884a.SogouReader)) {
                return tBSOnePrivacy.get(context);
            }
            String str = tBSOnePrivacy.get(context);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String model2 = DeviceInfoMonitor.getModel();
            tBSOnePrivacy.set(context, model2);
            return model2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(boolean z16) {
        f374571g = z16;
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            int i3 = b16 & 255;
            if (i3 < 16) {
                sb5.append("0");
            }
            sb5.append(Long.toString(i3, 16));
        }
        return sb5.toString();
    }

    public static String a(long j3) {
        return String.format(Locale.getDefault(), "%d(%s)", Long.valueOf(j3), new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j3)));
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue() != 0;
        }
        if (obj instanceof String) {
            return Boolean.parseBoolean((String) obj);
        }
        return true;
    }

    public static String a(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        if (iterable == null) {
            return "";
        }
        StringBuilder sb5 = null;
        for (CharSequence charSequence2 : iterable) {
            if (sb5 == null) {
                sb5 = new StringBuilder();
            } else {
                sb5.append(charSequence);
            }
            sb5.append(charSequence2);
        }
        return sb5 == null ? "" : sb5.toString();
    }

    public static boolean e() {
        return f374571g;
    }
}
