package com.tencent.qav.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static HandlerThread f342413a;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f342414b;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f342415c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40015);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("qav_sdk_thread_sub");
        f342413a = baseHandlerThread;
        baseHandlerThread.start();
        f342414b = new Handler(Looper.getMainLooper());
        f342415c = new Handler(f342413a.getLooper());
    }

    public static void a(Runnable runnable, long j3) {
        f342415c.postDelayed(runnable, j3);
    }

    public static void b(Runnable runnable) {
        f342414b.post(runnable);
    }

    public static Handler c() {
        return f342415c;
    }

    public static Handler d() {
        return f342414b;
    }

    public static void e(Runnable runnable) {
        f342415c.removeCallbacks(runnable);
    }
}
