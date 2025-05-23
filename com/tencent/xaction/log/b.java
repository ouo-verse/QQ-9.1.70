package com.tencent.xaction.log;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f384886a;

    /* renamed from: b, reason: collision with root package name */
    private static a f384887b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15833);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f384886a = false;
        }
    }

    public static void a(String str, int i3, String str2) {
        b(str, i3, str2, null);
    }

    public static void b(String str, int i3, String str2, Throwable th5) {
        a aVar = f384887b;
        if (aVar != null) {
            aVar.trace(3, str, i3, str2, th5);
        } else if (f384886a) {
            Log.d(str, str2, th5);
        }
    }

    public static void c(String str, int i3, String str2, Throwable th5) {
        a aVar = f384887b;
        if (aVar != null) {
            aVar.trace(6, str, i3, str2, th5);
        } else if (f384886a) {
            Log.e(str, str2, th5);
        }
    }

    public static void d(String str, int i3, String str2, Throwable th5) {
        a aVar = f384887b;
        if (aVar != null) {
            aVar.trace(4, str, i3, str2, th5);
        } else if (f384886a) {
            Log.i(str, str2, th5);
        }
    }

    public static void e(a aVar) {
        f384887b = aVar;
    }

    public static void f(String str, int i3, String str2, Throwable th5) {
        a aVar = f384887b;
        if (aVar != null) {
            aVar.trace(5, str, i3, str2, th5);
        } else if (f384886a) {
            Log.w(str, str2, th5);
        }
    }
}
