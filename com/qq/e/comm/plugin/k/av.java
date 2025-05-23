package com.qq.e.comm.plugin.k;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.qq.e.comm.managers.GDTADManager;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class av {

    /* renamed from: a, reason: collision with root package name */
    private final long f39628a;

    /* renamed from: b, reason: collision with root package name */
    private final long f39629b;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f39630c;

    /* renamed from: d, reason: collision with root package name */
    private long f39631d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f39632e = false;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f39633f = false;

    /* renamed from: g, reason: collision with root package name */
    private HandlerThread f39634g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f39635h;

    public av(long j3, long j16, boolean z16) {
        Looper mainLooper;
        this.f39628a = j3;
        this.f39629b = j16;
        if (!z16) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AMS-TikTokTimerThread");
            this.f39634g = baseHandlerThread;
            baseHandlerThread.start();
            mainLooper = this.f39634g.getLooper();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        this.f39635h = new Handler(mainLooper) { // from class: com.qq.e.comm.plugin.k.av.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (!av.this.f39632e && !av.this.f39633f) {
                    long elapsedRealtime = av.this.f39630c - SystemClock.elapsedRealtime();
                    if (elapsedRealtime <= 0) {
                        av.this.a();
                        return;
                    }
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    av.this.a(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + av.this.f39629b) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += av.this.f39629b;
                    }
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                }
            }
        };
    }

    public abstract void a();

    public abstract void a(long j3);

    public final synchronized long e() {
        long elapsedRealtime;
        if (this.f39633f) {
            elapsedRealtime = this.f39631d;
        } else {
            elapsedRealtime = this.f39630c - SystemClock.elapsedRealtime();
        }
        if (elapsedRealtime <= 0) {
            return this.f39628a;
        }
        return this.f39628a - elapsedRealtime;
    }

    public synchronized void f() {
        HandlerThread handlerThread = this.f39634g;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    public synchronized av b(long j3) {
        this.f39632e = false;
        if (j3 <= 0) {
            a();
            return this;
        }
        this.f39630c = SystemClock.elapsedRealtime() + j3;
        Handler handler = this.f39635h;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public final synchronized void c() {
        this.f39632e = true;
        this.f39635h.removeMessages(1);
    }

    public final synchronized void d() {
        boolean z16 = GDTADManager.getInstance().getSM() != null && GDTADManager.getInstance().getSM().getInteger("tikTokTimerPauseFix", 1) == 1;
        if (!this.f39632e && (!this.f39633f || !z16)) {
            this.f39633f = true;
            this.f39631d = this.f39630c - SystemClock.elapsedRealtime();
            this.f39635h.removeMessages(1);
        }
    }

    public final synchronized void b() {
        b(this.f39628a);
    }
}
