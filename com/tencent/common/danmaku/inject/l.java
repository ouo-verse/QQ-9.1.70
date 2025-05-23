package com.tencent.common.danmaku.inject;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f99732a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);
    }

    private static boolean a() {
        return true;
    }

    public static boolean b() {
        if (f99732a && a()) {
            return true;
        }
        return false;
    }

    public static void c(boolean z16) {
        f99732a = z16;
    }

    public static void d(a aVar) {
        if (aVar != null) {
            com.tencent.common.danmaku.util.e.f(aVar);
        }
    }
}
