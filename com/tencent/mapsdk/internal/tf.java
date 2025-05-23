package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tf {

    /* renamed from: a, reason: collision with root package name */
    public static final String f150434a = "txmapengine";

    /* renamed from: b, reason: collision with root package name */
    public static String f150435b = "release";

    /* renamed from: c, reason: collision with root package name */
    public static String f150436c = "undefined";

    /* renamed from: d, reason: collision with root package name */
    public static boolean f150437d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f150438e = false;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f150439f = false;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f150440g = false;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f150441h = false;

    /* renamed from: i, reason: collision with root package name */
    public static int f150442i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static String f150443j = "";

    /* renamed from: k, reason: collision with root package name */
    public static String f150444k = "";

    /* renamed from: l, reason: collision with root package name */
    public static String f150445l = "";

    /* renamed from: m, reason: collision with root package name */
    public static String f150446m = "";

    /* renamed from: n, reason: collision with root package name */
    public static String f150447n = "tms";

    /* renamed from: o, reason: collision with root package name */
    public static String f150448o = "undefined";

    /* renamed from: p, reason: collision with root package name */
    public static List<b> f150449p = new ArrayList(10);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(Context context, String str);

        void i();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum b {
        PLUGIN("shell.adapter.LocPluginModular"),
        BUGLY("bugly.TMSBugly"),
        BEACON("beacon.TMSBeaconReport");


        /* renamed from: d, reason: collision with root package name */
        public String f150454d;

        b(String str) {
            this.f150454d = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        byte[] a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0113. Please report as an issue. */
    public static void a(Context context) {
        try {
            String a16 = ht.a(context, context.getPackageName() + "_ShellConfig");
            if (TextUtils.isEmpty(a16)) {
                a16 = ht.a(context, "TMS_ShellConfig");
                if (TextUtils.isEmpty(a16)) {
                    try {
                        Properties properties = new Properties();
                        properties.load(context.getAssets().open("tencentmap/mapsdk_vector/sdkconfig.dat"));
                        a16 = properties.getProperty("classname");
                    } catch (IOException unused) {
                        a16 = "com.tencent.mapsdk.BuildConfig";
                    }
                }
            }
            Class<?> cls = Class.forName(a16);
            for (Field field : cls.getDeclaredFields()) {
                char c16 = 1;
                field.setAccessible(true);
                String name = field.getName();
                switch (name.hashCode()) {
                    case -2051118828:
                        if (name.equals("VERSION_CODE")) {
                            c16 = '\f';
                            break;
                        }
                        break;
                    case -2050804302:
                        if (name.equals("VERSION_NAME")) {
                            c16 = 7;
                            break;
                        }
                        break;
                    case -1781919750:
                        if (name.equals("SEARCH_ENABLE")) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case -1256894524:
                        if (name.equals("BEACON_KEY")) {
                            c16 = '\t';
                            break;
                        }
                        break;
                    case -783990306:
                        if (name.equals("BEACON_ENABLE")) {
                            c16 = '\b';
                            break;
                        }
                        break;
                    case -758346991:
                        if (name.equals("SHEET_PROJECT_NAME")) {
                            c16 = 5;
                            break;
                        }
                        break;
                    case -368721951:
                        if (name.equals("BUGLY_KEY")) {
                            c16 = '\n';
                            break;
                        }
                        break;
                    case 44249739:
                        if (name.equals("BUILD_TYPE")) {
                            c16 = '\r';
                            break;
                        }
                        break;
                    case 64921139:
                        if (name.equals("DEBUG")) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case 196363279:
                        if (name.equals("PLUGIN_ENABLE")) {
                            c16 = 4;
                            break;
                        }
                        break;
                    case 1766588577:
                        if (name.equals("BUGLY_ENABLE")) {
                            break;
                        }
                        break;
                    case 2076249758:
                        if (name.equals("FLAVOR")) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case 2095911147:
                        if (name.equals("REPO_VERSION")) {
                            c16 = 6;
                            break;
                        }
                        break;
                    case 2107919841:
                        if (name.equals("BUGLY_KEY_SHARE")) {
                            c16 = 11;
                            break;
                        }
                        break;
                }
                c16 = '\uffff';
                switch (c16) {
                    case 0:
                        f150437d = ((Boolean) field.get(cls)).booleanValue();
                        LogUtil.b(ky.f149118x, "[DEBUG]:" + f150437d);
                    case 1:
                        boolean booleanValue = ((Boolean) field.get(cls)).booleanValue();
                        f150438e = booleanValue;
                        if (booleanValue) {
                            f150449p.add(b.BUGLY);
                        }
                        LogUtil.b(ky.f149118x, "[BUGLY]:" + f150438e);
                    case 2:
                        f150436c = (String) field.get(cls);
                        LogUtil.b(ky.f149118x, "[FLAVOR]:" + f150436c);
                    case 3:
                        f150439f = ((Boolean) field.get(cls)).booleanValue();
                        LogUtil.b(ky.f149118x, "[SEARCH]:" + f150439f);
                    case 4:
                        boolean booleanValue2 = ((Boolean) field.get(cls)).booleanValue();
                        f150440g = booleanValue2;
                        if (booleanValue2) {
                            f150449p.add(b.PLUGIN);
                        }
                        LogUtil.b(ky.f149118x, "[PLUGIN]:" + f150440g);
                    case 5:
                        f150447n = (String) field.get(cls);
                    case 6:
                        f150448o = (String) field.get(cls);
                        LogUtil.b(ky.f149118x, "[REPO]:" + f150448o);
                    case 7:
                        f150443j = (String) field.get(cls);
                        LogUtil.b(ky.f149118x, "[VER]:" + f150443j);
                    case '\b':
                        boolean booleanValue3 = ((Boolean) field.get(cls)).booleanValue();
                        f150441h = booleanValue3;
                        if (booleanValue3) {
                            f150449p.add(b.BEACON);
                        }
                        LogUtil.b(ky.f149118x, "[BEACON]:" + f150441h);
                    case '\t':
                        f150444k = (String) field.get(cls);
                    case '\n':
                        f150445l = (String) field.get(cls);
                    case 11:
                        f150446m = (String) field.get(cls);
                    case '\f':
                        f150442i = ((Integer) field.get(cls)).intValue();
                        LogUtil.b(ky.f149118x, "[VER_CODE]:" + f150442i);
                    case '\r':
                        f150435b = (String) field.get(cls);
                        LogUtil.b(ky.f149118x, "[BUILD_TYPE]:" + f150435b);
                    default:
                }
            }
        } catch (ClassNotFoundException e16) {
            LogUtil.b(e16.getMessage(), e16);
        } catch (IllegalAccessException e17) {
            LogUtil.b(e17.getMessage(), e17);
        }
    }

    private static String b() {
        return f150436c + "-" + f150435b;
    }

    private static String a() {
        return f150443j + "-" + f150448o;
    }

    private static String a(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f150436c + "-" + f150435b);
        sb5.append("!");
        sb5.append(str);
        return sb5.toString();
    }
}
