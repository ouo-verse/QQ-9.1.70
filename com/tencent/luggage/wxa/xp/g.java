package com.tencent.luggage.wxa.xp;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g {

    /* renamed from: d, reason: collision with root package name */
    public static volatile g f145276d;

    /* renamed from: a, reason: collision with root package name */
    public HandlerThread f145277a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f145278b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f145279c;

    public g() {
        this.f145278b = null;
        this.f145279c = null;
        if (this.f145277a == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("SoterGenKeyHandlerThreadName");
            this.f145277a = baseHandlerThread;
            baseHandlerThread.start();
            if (this.f145277a.getLooper() != null) {
                this.f145278b = new Handler(this.f145277a.getLooper());
            } else {
                com.tencent.luggage.wxa.np.e.b("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
                this.f145278b = new Handler(Looper.getMainLooper());
            }
        }
        this.f145279c = new Handler(Looper.getMainLooper());
    }

    public static g a() {
        g gVar;
        if (f145276d == null) {
            synchronized (g.class) {
                if (f145276d == null) {
                    f145276d = new g();
                }
                gVar = f145276d;
            }
            return gVar;
        }
        return f145276d;
    }

    public void b(Runnable runnable) {
        this.f145278b.post(runnable);
    }

    public void a(HandlerThread handlerThread) {
        HandlerThread handlerThread2 = this.f145277a;
        if (handlerThread2 != null && handlerThread2.isAlive()) {
            com.tencent.luggage.wxa.np.e.c("Soter.SoterTaskThread", "quit the previous thread", new Object[0]);
            this.f145277a.quit();
        }
        this.f145277a = handlerThread;
        handlerThread.setName("SoterGenKeyHandlerThreadName");
        if (!handlerThread.isAlive()) {
            handlerThread.start();
        }
        this.f145278b = new Handler(this.f145277a.getLooper());
    }

    public void a(Runnable runnable, long j3) {
        this.f145278b.postDelayed(runnable, j3);
    }

    public void a(Runnable runnable) {
        this.f145279c.post(runnable);
    }
}
