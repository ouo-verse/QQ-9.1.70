package com.tencent.luggage.wxa.ar;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.xweb.CommandCfgPlugin;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class z0 {

    /* renamed from: a, reason: collision with root package name */
    public static long f121796a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static int f121797b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static String f121798c;

    /* renamed from: d, reason: collision with root package name */
    public static String f121799d;

    public static void a(long j3) {
        f121796a = j3;
    }

    public static String b() {
        String h16 = h();
        if (a(h16)) {
            x0.a("XWebUpdateConfigUtil", "use test config url : " + h16);
            return h16;
        }
        String f16 = f();
        if (a(f16)) {
            x0.a("XWebUpdateConfigUtil", "use temp config url : " + f16);
            return f16;
        }
        String str = XWalkEnvironment.getBuildConfigThirdPartyRelease() ? "https://dldir1v6.qq.com/weixin/android/wxweb/updateConfig_public.xml" : "https://dldir1v6.qq.com/weixin/android/wxweb/updateConfig.xml";
        x0.a("XWebUpdateConfigUtil", "use release config url = " + str);
        return str;
    }

    public static void c(String str) {
        f121799d = str;
    }

    public static String d() {
        String i3 = i();
        if (a(i3)) {
            x0.a("XWebUpdateConfigUtil", "plugin use test config url: " + i3);
            return i3;
        }
        String g16 = g();
        if (a(g16)) {
            x0.a("XWebUpdateConfigUtil", "plugin use temp config url: " + g16);
            return g16;
        }
        String str = XWalkEnvironment.getBuildConfigThirdPartyRelease() ? "https://dldir1v6.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_public.xml" : "https://dldir1v6.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
        x0.a("XWebUpdateConfigUtil", "plugin use release config url: " + str);
        return str;
    }

    public static int e() {
        int c16 = c();
        if (c16 > 0) {
            x0.a("XWebUpdateConfigUtil", "getPluginUpdatePeriod, use temp period:" + c16);
            return c16;
        }
        int cmdPluginUpdatePeriod = CommandCfgPlugin.getInstance().getCmdPluginUpdatePeriod();
        if (cmdPluginUpdatePeriod > 0) {
            x0.a("XWebUpdateConfigUtil", "getPluginUpdatePeriod, use cmd period:" + cmdPluginUpdatePeriod);
            return cmdPluginUpdatePeriod;
        }
        x0.a("XWebUpdateConfigUtil", "getPluginUpdatePeriod, use default period:90000000");
        return 90000000;
    }

    public static String f() {
        return f121798c;
    }

    public static String g() {
        return f121799d;
    }

    public static String h() {
        SharedPreferences r16 = y0.r();
        if (r16 == null) {
            x0.c("XWebUpdateConfigUtil", "getTestBaseConfigUrl, sp is null");
            return "";
        }
        String string = r16.getString("XWEB_TEST_CONFIG_URL", "");
        if (string == null || string.trim().isEmpty()) {
            return "";
        }
        return string;
    }

    public static String i() {
        SharedPreferences r16 = y0.r();
        if (r16 == null) {
            x0.c("XWebUpdateConfigUtil", "getTestPluginConfigUrl, sp is null");
            return "";
        }
        String string = r16.getString("XWEB_PLUGIN_TEST_CONFIG_URL", "");
        if (string == null || string.trim().isEmpty()) {
            return "";
        }
        return string;
    }

    public static long a() {
        return f121796a;
    }

    public static int c() {
        return f121797b;
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                if (new Date().after(new SimpleDateFormat(DateUtil.DATE_FORMAT_8).parse(str2))) {
                    x0.f("XWebUpdateConfigUtil", "today is after end date, set temp update config failed");
                    return false;
                }
            } catch (Throwable th5) {
                x0.a("XWebUpdateConfigUtil", "setTempUpdateConfigUrl, error", th5);
                return false;
            }
        }
        f121798c = str;
        return true;
    }

    public static boolean e(String str) {
        SharedPreferences r16 = y0.r();
        if (r16 == null) {
            x0.c("XWebUpdateConfigUtil", "setTestPluginConfigUrl, sp is null");
            return false;
        }
        SharedPreferences.Editor edit = r16.edit();
        if (str != null && !str.trim().isEmpty()) {
            if (!a(str)) {
                x0.c("XWebUpdateConfigUtil", "setTestPluginConfigUrl, url is invalid");
                return false;
            }
            edit.putString("XWEB_PLUGIN_TEST_CONFIG_URL", str.trim());
        } else {
            edit.remove("XWEB_PLUGIN_TEST_CONFIG_URL");
        }
        return edit.commit();
    }

    public static void b(String str) {
        f121798c = str;
    }

    public static boolean d(String str) {
        SharedPreferences r16 = y0.r();
        if (r16 == null) {
            x0.c("XWebUpdateConfigUtil", "setTestBaseConfigUrl, sp is null");
            return false;
        }
        SharedPreferences.Editor edit = r16.edit();
        if (str != null && !str.trim().isEmpty()) {
            if (!a(str)) {
                x0.c("XWebUpdateConfigUtil", "setTestBaseConfigUrl, url is invalid");
                return false;
            }
            edit.putString("XWEB_TEST_CONFIG_URL", str.trim());
        } else {
            edit.remove("XWEB_TEST_CONFIG_URL");
        }
        return edit.commit();
    }

    public static void a(int i3) {
        f121797b = i3;
    }

    public static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                if (new Date().after(new SimpleDateFormat(DateUtil.DATE_FORMAT_8).parse(str2))) {
                    x0.f("XWebUpdateConfigUtil", "today is after end date, set temp plugin update config failed");
                    return;
                }
            } catch (Throwable th5) {
                x0.a("XWebUpdateConfigUtil", "setTempPluginConfigUrl, error", th5);
                return;
            }
        }
        f121799d = str;
    }

    public static boolean a(String str) {
        if (str != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            try {
                URI uri = new URI(str.trim());
                if (!uri.getScheme().equals("https")) {
                    return false;
                }
                if (!uri.getHost().equals("dldir1.qq.com") && !uri.getHost().equals("dldir1v6.qq.com")) {
                    return false;
                }
                x0.d("XWebUpdateConfigUtil", "isValidConfigHost true, url:" + str);
                return true;
            } catch (Throwable th5) {
                x0.a("XWebUpdateConfigUtil", "isValidConfigHost error", th5);
            }
        }
        return false;
    }
}
