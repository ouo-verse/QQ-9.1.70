package com.qzone.common.event;

import cooperation.qzone.util.QZLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes39.dex */
public final class BackgroundPoster implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final d f45848d = new d();

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f45849e;

    /* renamed from: f, reason: collision with root package name */
    private final EventCenter f45850f;

    /* renamed from: h, reason: collision with root package name */
    private IThreadPool f45851h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackgroundPoster(EventCenter eventCenter, IThreadPool iThreadPool) {
        this.f45850f = eventCenter;
        this.f45851h = iThreadPool;
    }

    public void a(b bVar, Object obj) {
        c a16 = c.a(bVar, obj);
        synchronized (this) {
            this.f45848d.a(a16);
            if (!this.f45849e) {
                this.f45849e = true;
                this.f45851h.submit(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                c c16 = this.f45848d.c(1000);
                if (c16 == null) {
                    synchronized (this) {
                        c16 = this.f45848d.b();
                        if (c16 == null) {
                            return;
                        }
                    }
                }
                this.f45850f.invokeObserver(c16);
            } catch (InterruptedException e16) {
                QZLog.w("Event", Thread.currentThread().getName() + " was interruppted", e16);
                return;
            } finally {
                this.f45849e = false;
            }
        }
    }
}
