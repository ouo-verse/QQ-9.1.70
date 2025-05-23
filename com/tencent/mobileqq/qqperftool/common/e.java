package com.tencent.mobileqq.qqperftool.common;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f274253a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f274253a = null;
        }
    }

    public static void a(String str, String str2) {
        if (f274253a != null) {
            f274253a.d(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (f274253a != null) {
            f274253a.e(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th5) {
        if (f274253a != null) {
            f274253a.e(str, str2, th5);
        } else {
            Log.e(str, str2, th5);
        }
    }

    public static void d(String str, String str2) {
        if (f274253a != null) {
            f274253a.i(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static void e(d dVar) {
        f274253a = dVar;
    }

    public static void f(String str, String str2) {
        if (f274253a != null) {
            f274253a.w(str, str2);
        } else {
            Log.w(str, str2);
        }
    }
}
