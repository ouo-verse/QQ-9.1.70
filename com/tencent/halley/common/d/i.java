package com.tencent.halley.common.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f113530a;

    /* renamed from: b, reason: collision with root package name */
    private static String f113531b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12138);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f113530a = "";
            f113531b = "";
        }
    }

    private static SharedPreferences a(boolean z16) {
        try {
            Context a16 = com.tencent.halley.common.a.a();
            StringBuilder sb5 = new StringBuilder("HalleyServicePreferences_");
            sb5.append(com.tencent.halley.common.a.c());
            sb5.append(com.tencent.halley.common.a.b() ? "_test" : "");
            String sb6 = sb5.toString();
            if (z16) {
                sb6 = sb6 + "_" + com.tencent.halley.common.a.g();
            }
            return a16.getSharedPreferences(sb6, 0);
        } catch (Exception e16) {
            com.tencent.halley.common.utils.d.e("PlatformUtil", e16.getMessage());
            return null;
        }
    }

    public static long b(String str) {
        SharedPreferences a16 = a(false);
        if (a16 != null) {
            return a16.getLong(str, 0L);
        }
        return -1L;
    }

    public static int c(String str) {
        SharedPreferences a16 = a(false);
        if (a16 != null) {
            return a16.getInt(str, 0);
        }
        return -1;
    }

    public static String a() {
        if (!TextUtils.isEmpty(f113531b)) {
            return f113531b;
        }
        String b16 = b("deviceid", "", false);
        f113531b = b16;
        return b16;
    }

    public static String b(String str, String str2, boolean z16) {
        SharedPreferences a16 = a(z16);
        return a16 != null ? a16.getString(str, str2) : "";
    }

    public static String a(int i3) {
        return i3 == 2 ? QADNetStatus.G_2 : i3 == 3 ? QADNetStatus.G_3 : i3 == 4 ? QADNetStatus.G_4 : i3 == 1 ? "wifi" : "";
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f113530a)) {
            return f113530a;
        }
        String packageName = context.getPackageName();
        String a16 = j.a(Process.myPid());
        if (TextUtils.isEmpty(a16) || !a16.startsWith(packageName)) {
            a16 = j.a(context, Process.myPid());
        }
        f113530a = a16;
        return a16;
    }

    public static void a(String str) {
        a("deviceid", str, false);
        f113531b = str;
    }

    public static void a(String str, int i3) {
        SharedPreferences a16 = a(false);
        if (a16 != null) {
            a16.edit().putInt(str, i3).commit();
        }
    }

    public static void a(String str, long j3) {
        SharedPreferences a16 = a(false);
        if (a16 != null) {
            a16.edit().putLong(str, j3).commit();
        }
    }

    public static void a(String str, String str2, boolean z16) {
        SharedPreferences a16 = a(z16);
        if (a16 != null) {
            a16.edit().putString(str, str2).commit();
        }
    }
}
