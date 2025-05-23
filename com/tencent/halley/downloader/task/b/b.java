package com.tencent.halley.downloader.task.b;

import android.os.SystemClock;
import com.tencent.halley.common.utils.d;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Object f113796a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f113797b;

    /* renamed from: c, reason: collision with root package name */
    private c f113798c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f113799d;

    /* renamed from: e, reason: collision with root package name */
    private Object f113800e;

    public b(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.f113799d = false;
        this.f113800e = new Object();
        this.f113796a = new Object();
        this.f113797b = false;
        d.c("halley-downloader-SaveService", "new BDSaveService...");
        this.f113798c = cVar;
        new BaseThread(this, "HalleyDownload-SaveThread").start();
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        d.c("halley-downloader-SaveService", "start SaveService...");
        synchronized (this.f113800e) {
            if (!this.f113799d) {
                this.f113799d = true;
                this.f113800e.notify();
            }
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        d.c("halley-downloader-SaveService", "stop SaveService...");
        synchronized (this.f113800e) {
            if (this.f113799d) {
                this.f113799d = false;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                z16 = this.f113798c.e();
            } catch (Throwable th5) {
                d.a("halley-downloader-SaveService", th5);
                z16 = false;
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (!z16) {
                int i3 = com.tencent.halley.downloader.a.a.f113581d;
                if (elapsedRealtime2 > 0) {
                    long j3 = i3;
                    if (elapsedRealtime2 < j3) {
                        int i16 = (int) (j3 - elapsedRealtime2);
                        try {
                            try {
                                this.f113797b = true;
                                synchronized (this.f113796a) {
                                    this.f113796a.wait(i16);
                                }
                            } finally {
                                this.f113797b = false;
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
            synchronized (this.f113800e) {
                if (!this.f113799d) {
                    try {
                        d.b("halley-downloader-SaveService", "BDSaveService try wait...");
                        LockMethodProxy.wait(this.f113800e);
                    } catch (InterruptedException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }
}
