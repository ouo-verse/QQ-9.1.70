package com.tencent.qui.quiblurview;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes25.dex */
class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f363651a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8198);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f363651a = new Handler(Looper.getMainLooper());
        }
    }

    public static void a(Runnable runnable) {
        f363651a.removeCallbacks(runnable);
    }

    public static void b(Runnable runnable, long j3) {
        f363651a.postDelayed(runnable, j3);
    }
}
