package com.tencent.trackrecordlib.d.a;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(Object obj, String str) {
        c.a(a(obj, true), str);
    }

    public static Map<String, ?> b(Object obj) {
        return c.b(a(obj, false));
    }

    public static void c(Object obj, String str) {
        c.c(a(obj, true), str);
    }

    public static Map<String, ?> d(Object obj) {
        return c.e(a(obj, false));
    }

    public static void e(Object obj, String str) {
        c.e(a(obj, true), str);
    }

    public static String a(Object obj) {
        return c.a(a(obj, false));
    }

    public static void b(Object obj, String str) {
        c.b(a(obj, false), str);
    }

    public static String c(Object obj) {
        return c.d(a(obj, false));
    }

    @Nullable
    public static Object d(Object obj, String str) {
        return c.d(a(obj, true), str);
    }

    public static void a(Object obj, Map<String, ?> map) {
        c.a(a(obj, true), map);
    }

    public static void b(Object obj, Map<String, ?> map) {
        c.b(a(obj, true), map);
    }

    public static void a(Object obj, String str, Object obj2) {
        c.a(a(obj, true), str, obj2);
    }

    public static void b(Object obj, String str, Object obj2) {
        c.b(a(obj, true), str, obj2);
    }

    private static b a(Object obj, boolean z16) {
        b a16 = a.a(obj);
        if (a16 != null || !z16) {
            return a16;
        }
        b bVar = new b();
        a.a(obj, bVar);
        return bVar;
    }
}
