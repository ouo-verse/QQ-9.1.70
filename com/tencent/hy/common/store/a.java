package com.tencent.hy.common.store;

import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static MMKV f114709a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20056);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f114709a = MMKV.a0("csc_pref", 2);
        }
    }

    public static boolean a(String str, boolean z16) {
        return f114709a.getBoolean(str, z16);
    }

    public static float b(String str, float f16) {
        return f114709a.getFloat(str, f16);
    }

    public static int c(String str, int i3) {
        return f114709a.getInt(str, i3);
    }

    public static void d(String str, boolean z16) {
        f114709a.N(str, z16);
    }

    public static void e(String str, float f16) {
        f114709a.B(str, f16);
    }

    public static void f(String str, int i3) {
        f114709a.D(str, i3);
    }

    public static void g(String str, long j3) {
        f114709a.F(str, j3);
    }

    public static void h(String str, int i3) {
        f114709a.putInt(str, i3);
    }
}
