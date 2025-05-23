package com.tencent.upgrade.thread;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static ExecutorService f383895b;

    /* renamed from: c, reason: collision with root package name */
    private static ExecutorService f383896c;

    /* renamed from: d, reason: collision with root package name */
    private static Handler f383897d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile a f383898e;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f383899a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.upgrade.thread.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public class ThreadFactoryC10038a implements ThreadFactory {
        static IPatchRedirector $redirector_;

        ThreadFactoryC10038a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            }
            return new BaseThread(runnable, a.this.e());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10640);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f383897d = new Handler(Looper.getMainLooper());
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383899a = new AtomicInteger(0);
        f383895b = c();
        f383896c = c();
    }

    private ThreadPoolExecutor c() {
        return new BaseThreadPoolExecutor(0, 5, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC10038a());
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f383898e == null) {
                synchronized (a.class) {
                    if (f383898e == null) {
                        f383898e = new a();
                    }
                }
            }
            aVar = f383898e;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return "Shiply_Upgrade_" + this.f383899a.getAndIncrement();
    }

    public void b(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        } else {
            f383895b.execute(runnable);
        }
    }
}
