package com.tencent.gamecenter.wadl.sdk.downloader.task.h;

import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private c f107551a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f107552b = false;

    /* renamed from: c, reason: collision with root package name */
    private final Object f107553c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final Object f107554d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f107555e = false;

    public b(c cVar) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-SaveService", "new BDSaveService...");
        this.f107551a = cVar;
        new BaseThread(this, "GameDownload-SaveThread").start();
    }

    public void a() {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-SaveService", "start SaveService...");
        synchronized (this.f107553c) {
            if (!this.f107552b) {
                this.f107552b = true;
                this.f107553c.notify();
            }
        }
    }

    public void b() {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-SaveService", "stop SaveService...");
        synchronized (this.f107553c) {
            if (this.f107552b) {
                this.f107552b = false;
            }
        }
    }

    public void c() {
        try {
            if (this.f107555e) {
                synchronized (this.f107554d) {
                    this.f107554d.notify();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                z16 = this.f107551a.onSave();
            } catch (Throwable th5) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-SaveService", th5);
                z16 = false;
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (!z16) {
                int i3 = com.tencent.gamecenter.wadl.sdk.downloader.a.a.f107278c;
                if (elapsedRealtime2 > 0) {
                    long j3 = i3;
                    if (elapsedRealtime2 < j3) {
                        int i16 = (int) (j3 - elapsedRealtime2);
                        try {
                            this.f107555e = true;
                            synchronized (this.f107554d) {
                                this.f107554d.wait(i16);
                            }
                        } catch (Exception unused) {
                        } catch (Throwable th6) {
                            this.f107555e = false;
                            throw th6;
                        }
                        this.f107555e = false;
                    }
                }
            }
            synchronized (this.f107553c) {
                if (!this.f107552b) {
                    try {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-SaveService", "BDSaveService try wait...");
                        LockMethodProxy.wait(this.f107553c);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
    }
}
