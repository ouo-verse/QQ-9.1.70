package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hz {

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f389399a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static int f389400b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, n> f389401c;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a() {
        int i3;
        boolean z16;
        if (f389399a == 0) {
            try {
                i3 = 1;
            } catch (Throwable th5) {
                jz4.c.o("get isMIUI failed", th5);
                f389399a = 0;
            }
            if (TextUtils.isEmpty(g("ro.miui.ui.version.code")) && TextUtils.isEmpty(g("ro.miui.ui.version.name"))) {
                z16 = false;
                if (z16) {
                    i3 = 2;
                }
                f389399a = i3;
                jz4.c.w("isMIUI's value is: " + f389399a);
            }
            z16 = true;
            if (z16) {
            }
            f389399a = i3;
            jz4.c.w("isMIUI's value is: " + f389399a);
        }
        return f389399a;
    }

    public static int b(Context context) {
        String g16 = g("ro.miui.ui.version.code");
        if (!TextUtils.isEmpty(g16) && TextUtils.isDigitsOnly(g16)) {
            return Integer.parseInt(g16);
        }
        return 0;
    }

    public static n c(String str) {
        n m3 = m(str);
        if (m3 == null) {
            return n.Global;
        }
        return m3;
    }

    public static String d() {
        int a16 = ii.a();
        if (i() && a16 > 0) {
            if (a16 < 2) {
                return com.tencent.luggage.wxa.c8.c.f123400v;
            }
            if (a16 < 3) {
                return "development";
            }
            return "stable";
        }
        return "";
    }

    public static String e(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + f(intent.getExtras());
    }

    public static String f(Bundle bundle) {
        StringBuilder sb5 = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb5.append("null");
        } else {
            boolean z16 = true;
            for (String str : bundle.keySet()) {
                if (!z16) {
                    sb5.append(", ");
                }
                sb5.append(str);
                sb5.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    sb5.append(Arrays.toString((int[]) obj));
                } else if (obj instanceof byte[]) {
                    sb5.append(Arrays.toString((byte[]) obj));
                } else if (obj instanceof boolean[]) {
                    sb5.append(Arrays.toString((boolean[]) obj));
                } else if (obj instanceof short[]) {
                    sb5.append(Arrays.toString((short[]) obj));
                } else if (obj instanceof long[]) {
                    sb5.append(Arrays.toString((long[]) obj));
                } else if (obj instanceof float[]) {
                    sb5.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof double[]) {
                    sb5.append(Arrays.toString((double[]) obj));
                } else if (obj instanceof String[]) {
                    sb5.append(Arrays.toString((String[]) obj));
                } else if (obj instanceof CharSequence[]) {
                    sb5.append(Arrays.toString((CharSequence[]) obj));
                } else if (obj instanceof Parcelable[]) {
                    sb5.append(Arrays.toString((Parcelable[]) obj));
                } else if (obj instanceof Bundle) {
                    sb5.append(f((Bundle) obj));
                } else {
                    sb5.append(obj);
                }
                z16 = false;
            }
        }
        sb5.append("]");
        return sb5.toString();
    }

    public static String g(String str) {
        try {
            try {
                return (String) y.g(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME, "get", str, "");
            } catch (Exception e16) {
                jz4.c.B("fail to get property. " + e16);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void h() {
        if (f389401c != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        f389401c = hashMap;
        hashMap.put(LocaleManager.MOBILE_COUNTRY_CODE_CN_STR, n.China);
        Map<String, n> map = f389401c;
        n nVar = n.Europe;
        map.put("FI", nVar);
        f389401c.put("SE", nVar);
        f389401c.put("NO", nVar);
        f389401c.put("FO", nVar);
        f389401c.put("EE", nVar);
        f389401c.put("LV", nVar);
        f389401c.put("LT", nVar);
        f389401c.put("BY", nVar);
        f389401c.put("MD", nVar);
        f389401c.put("UA", nVar);
        f389401c.put("PL", nVar);
        f389401c.put("CZ", nVar);
        f389401c.put("SK", nVar);
        f389401c.put("HU", nVar);
        f389401c.put("DE", nVar);
        f389401c.put("AT", nVar);
        f389401c.put("CH", nVar);
        f389401c.put("LI", nVar);
        f389401c.put("GB", nVar);
        f389401c.put("IE", nVar);
        f389401c.put("NL", nVar);
        f389401c.put("BE", nVar);
        f389401c.put("LU", nVar);
        f389401c.put("FR", nVar);
        f389401c.put("RO", nVar);
        f389401c.put("BG", nVar);
        f389401c.put("RS", nVar);
        f389401c.put("MK", nVar);
        f389401c.put("AL", nVar);
        f389401c.put("GR", nVar);
        f389401c.put("SI", nVar);
        f389401c.put("HR", nVar);
        f389401c.put("IT", nVar);
        f389401c.put("SM", nVar);
        f389401c.put("MT", nVar);
        f389401c.put("ES", nVar);
        f389401c.put("PT", nVar);
        f389401c.put("AD", nVar);
        f389401c.put("CY", nVar);
        f389401c.put("DK", nVar);
        f389401c.put("IS", nVar);
        f389401c.put("UK", nVar);
        f389401c.put("EL", nVar);
        f389401c.put("RU", n.Russia);
        f389401c.put("IN", n.India);
    }

    public static boolean i() {
        if (a() == 1) {
            return true;
        }
        return false;
    }

    public static boolean j(Context context) {
        if (context != null && k(context.getPackageName())) {
            return true;
        }
        return false;
    }

    public static boolean k(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static int l(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static n m(String str) {
        h();
        return f389401c.get(str.toUpperCase());
    }

    public static String n() {
        String a16 = ih.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a16)) {
            a16 = ih.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a16)) {
            a16 = ih.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a16)) {
            a16 = ih.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(a16)) {
            a16 = ih.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a16)) {
            a16 = ih.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a16)) {
            a16 = o(ih.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(a16)) {
            a16 = ih.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a16)) {
            a16 = ih.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a16)) {
            a16 = ih.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a16)) {
            a16 = ih.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a16)) {
            jz4.c.m("get region from system, region = " + a16);
        }
        if (TextUtils.isEmpty(a16)) {
            String country = Locale.getDefault().getCountry();
            jz4.c.m("locale.default.country = " + country);
            return country;
        }
        return a16;
    }

    private static String o(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("-");
            if (split.length > 0) {
                return split[0];
            }
            return str;
        }
        return str;
    }

    public static boolean p() {
        if (a() == 2) {
            return true;
        }
        return false;
    }

    public static String q() {
        return g("ro.miui.ui.version.name");
    }

    public static boolean r() {
        if (f389400b < 0) {
            f389400b = !v() ? 1 : 0;
        }
        if (f389400b > 0) {
            return true;
        }
        return false;
    }

    public static String s() {
        return g("ro.build.characteristics");
    }

    public static boolean t() {
        return !n.China.name().equalsIgnoreCase(c(n()).name());
    }

    public static String u() {
        return g("ro.product.manufacturer");
    }

    public static boolean v() {
        String str = "";
        try {
            str = ih.a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }
}
