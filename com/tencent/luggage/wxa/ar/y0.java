package com.tencent.luggage.wxa.ar;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.xweb.ISharedPreferenceProvider;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class y0 {

    /* renamed from: a, reason: collision with root package name */
    public static ISharedPreferenceProvider f121794a;

    /* renamed from: b, reason: collision with root package name */
    public static Context f121795b;

    public static void a(Context context) {
        if (context != null) {
            f121795b = XWalkEnvironment.convertContextToApplication(context);
            x0.d("XWebSharedPreferenceUtil", "setApplicationContext:" + f121795b);
        }
    }

    public static SharedPreferences b() {
        return d("XWEB.CMDCFG");
    }

    public static SharedPreferences c() {
        return d("XWEB.CMDCFG.LATEST");
    }

    public static SharedPreferences d(String str) {
        return a(str, true);
    }

    public static SharedPreferences e(String str) {
        return f("xwalk_plugin_version_info_" + str);
    }

    public static SharedPreferences f(String str) {
        Context context = f121795b;
        if (context == null) {
            x0.f("XWebSharedPreferenceUtil", "safeGetProcessSharedPreferences, application context is null");
            return null;
        }
        return context.getSharedPreferences(str, 4);
    }

    public static SharedPreferences g() {
        return d("UPDATELOG");
    }

    public static SharedPreferences h() {
        return d("REPORT_DAILY");
    }

    public static SharedPreferences i() {
        return a("XWEB_UPDATING_TAG");
    }

    public static SharedPreferences j() {
        return a("XWEB_USER_INFO");
    }

    public static SharedPreferences k() {
        return a("xweb_value_changed");
    }

    public static SharedPreferences l() {
        return f("xwalk_reader_record");
    }

    public static SharedPreferences m() {
        return f("xweb_multi_process");
    }

    public static SharedPreferences n() {
        return f("xwalk_plugin_update_info");
    }

    public static SharedPreferences o() {
        return f("UPDATEINFOTAG");
    }

    public static SharedPreferences p() {
        return f("xweb_using_core_version");
    }

    public static SharedPreferences q() {
        return f("XWALKINFOS");
    }

    public static SharedPreferences r() {
        return f("xweb_debug");
    }

    public static SharedPreferences s() {
        return f("libxwalkcore");
    }

    public static SharedPreferences b(String str) {
        return a("XWEB_EMBED_INSTALL_" + str);
    }

    public static SharedPreferences c(String str) {
        return a("xweb_scheduler_" + str);
    }

    public static SharedPreferences d() {
        return a("XWEB.CMDCFG.PLUGIN");
    }

    public static SharedPreferences e() {
        return a("XWEB.CMDCFG.PLUGIN.LATEST");
    }

    public static Context a() {
        return f121795b;
    }

    public static synchronized void a(ISharedPreferenceProvider iSharedPreferenceProvider) {
        synchronized (y0.class) {
            if (iSharedPreferenceProvider != null) {
                f121794a = iSharedPreferenceProvider;
            }
        }
    }

    public static SharedPreferences f() {
        return a("FREQUENT_LIMITER");
    }

    public static SharedPreferences a(String str, boolean z16) {
        SharedPreferences sharedPreferences;
        ISharedPreferenceProvider iSharedPreferenceProvider = f121794a;
        if (iSharedPreferenceProvider != null) {
            try {
                sharedPreferences = iSharedPreferenceProvider.getSharedPreference(a(), str, 4, z16);
            } catch (Throwable th5) {
                x0.a("XWebSharedPreferenceUtil", "getMMKVSharedPreferences, SPProvider get sp error", th5);
                sharedPreferences = null;
            }
            if (sharedPreferences != null) {
                return sharedPreferences;
            }
            x0.f("XWebSharedPreferenceUtil", "getMMKVSharedPreferences, get null from SPProvider");
            n0.a(176L, 1);
        } else {
            n0.a(177L, 1);
        }
        return f(str);
    }

    public static SharedPreferences a(String str) {
        return a(str, false);
    }
}
