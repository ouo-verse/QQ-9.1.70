package com.tencent.rtmp.video.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final ThreadPoolExecutor f368818a;

    /* renamed from: b, reason: collision with root package name */
    final Handler f368819b;

    /* renamed from: c, reason: collision with root package name */
    final List<C9791a> f368820c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.rtmp.video.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C9791a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final Runnable f368821a;

        /* renamed from: b, reason: collision with root package name */
        final Runnable f368822b;

        /* renamed from: c, reason: collision with root package name */
        final Runnable f368823c;

        /* renamed from: d, reason: collision with root package name */
        final long f368824d;

        public C9791a(Runnable runnable, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, runnable, Long.valueOf(j3));
                return;
            }
            this.f368821a = runnable;
            this.f368822b = d.a(this, runnable);
            this.f368823c = e.a(this);
            this.f368824d = j3;
        }
    }

    public a() {
        this((byte) 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public final void a(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f368818a.execute(runnable);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
        }
    }

    public final void b(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f368818a.execute(c.a(runnable, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void c(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
            return;
        }
        if (runnable == null) {
            return;
        }
        this.f368818a.remove(runnable);
        synchronized (this) {
            Iterator<C9791a> it = this.f368820c.iterator();
            while (it.hasNext()) {
                C9791a next = it.next();
                if (next != null && runnable == next.f368821a) {
                    a.this.f368819b.removeCallbacks(next.f368823c);
                    a.this.f368818a.remove(next.f368822b);
                    it.remove();
                }
            }
        }
    }

    a(byte b16) {
        this("SequenceTaskRunner_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
    }

    public final void a(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, runnable, Long.valueOf(j3));
            return;
        }
        C9791a c9791a = new C9791a(runnable, j3);
        synchronized (this) {
            this.f368820c.add(c9791a);
        }
        a.this.f368819b.postDelayed(c9791a.f368823c, c9791a.f368824d);
    }

    a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        this.f368818a = new BaseThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), b.a(str));
        this.f368819b = new Handler(Looper.getMainLooper());
        this.f368820c = new ArrayList();
    }
}
