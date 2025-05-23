package com.tencent.mobileqq.microapp.appbrand.b;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Handler f245945a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f245945a = new Handler(Looper.getMainLooper());
        }
    }

    public static void a(Runnable runnable) {
        f245945a.post(runnable);
    }

    public static void a(Runnable runnable, long j3) {
        f245945a.postDelayed(runnable, j3);
    }
}
