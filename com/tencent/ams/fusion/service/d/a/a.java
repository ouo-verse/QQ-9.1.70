package com.tencent.ams.fusion.service.d.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements lt.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f70257a;

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f70258b;

    /* renamed from: c, reason: collision with root package name */
    private ExecutorService f70259c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f70260d;

    /* renamed from: e, reason: collision with root package name */
    private ExecutorService f70261e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.ams.fusion.service.d.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0674a implements Comparator<Runnable> {
        static IPatchRedirector $redirector_;

        C0674a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Runnable runnable, Runnable runnable2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, (Object) runnable2)).intValue();
            }
            if (runnable instanceof c) {
                if (runnable2 instanceof c) {
                    return ((c) runnable2).e() - ((c) runnable).e();
                }
                return -((c) runnable).e();
            }
            if (runnable2 instanceof c) {
                return ((c) runnable2).e();
            }
            return 0;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        d();
        e();
        f();
        g();
        h();
    }

    private void d() {
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(2, 4, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b("FusionAdCachedThreadPool"), new ThreadPoolExecutor.DiscardOldestPolicy());
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f70257a = baseThreadPoolExecutor;
    }

    private void e() {
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(2, 2, 30L, TimeUnit.SECONDS, new PriorityBlockingQueue(100, new C0674a()), new b("FusionAdBackgroundCachedThreadPool"), new ThreadPoolExecutor.DiscardOldestPolicy());
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f70258b = baseThreadPoolExecutor;
    }

    private void f() {
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(1, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b("FusionAdImmediateThreadPool"), new ThreadPoolExecutor.DiscardOldestPolicy());
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f70259c = baseThreadPoolExecutor;
    }

    private void g() {
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(com.tencent.ams.fusion.service.splash.a.a.d().n(), Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b("FusionAdResourceDownloadThreadPool"), new ThreadPoolExecutor.DiscardOldestPolicy());
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f70260d = baseThreadPoolExecutor;
    }

    private void h() {
        this.f70261e = new BaseScheduledThreadPoolExecutor(2, new b("FusionAdScheduledThreadPoolExecutor"), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    @Override // lt.a
    public void a(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f70258b.execute(runnable);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        }
    }

    @Override // lt.a
    public void b(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
        } else {
            this.f70259c.execute(runnable);
        }
    }

    @Override // lt.a
    public void c(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    @Override // lt.a
    public void a(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, runnable, Long.valueOf(j3));
            return;
        }
        ExecutorService executorService = this.f70261e;
        if (executorService instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executorService).schedule(runnable, j3, TimeUnit.MILLISECONDS);
        }
    }

    @Override // lt.a
    public void d(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f70260d.execute(runnable);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
        }
    }
}
