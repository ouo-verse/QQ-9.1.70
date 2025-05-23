package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.BaseMidCountView;
import java.lang.ref.WeakReference;
import pw2.i;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected volatile Context f303636a;

    /* renamed from: c, reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f303638c;

    /* renamed from: d, reason: collision with root package name */
    private volatile kt3.d f303639d;

    /* renamed from: e, reason: collision with root package name */
    private volatile com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.a f303640e;

    /* renamed from: f, reason: collision with root package name */
    protected BaseMidCountView f303641f;

    /* renamed from: h, reason: collision with root package name */
    private int f303643h;

    /* renamed from: i, reason: collision with root package name */
    private final WeakReference<Activity> f303644i;

    /* renamed from: j, reason: collision with root package name */
    private long f303645j;

    /* renamed from: k, reason: collision with root package name */
    private ViewGroup f303646k;

    /* renamed from: l, reason: collision with root package name */
    private volatile long f303647l;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f303637b = false;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f303642g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends pw2.d {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            e.this.h(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            e.this.g(activity);
        }
    }

    public e(Context context, int i3, ViewGroup viewGroup, long j3, long j16) {
        this.f303636a = context;
        this.f303643h = i3;
        this.f303646k = viewGroup;
        this.f303645j = j3;
        this.f303647l = j16;
        this.f303644i = new WeakReference<>(i.k(context));
    }

    private synchronized void d() {
        if (this.f303641f != null) {
            n.e("QAdCountDownHandler", "closeCountDownView");
            this.f303641f.c();
            this.f303641f = null;
        }
    }

    private Activity f() {
        if (this.f303636a instanceof Activity) {
            return (Activity) this.f303636a;
        }
        WeakReference<Activity> weakReference = this.f303644i;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Activity activity) {
        if (activity == f()) {
            n.e("QAdCountDownHandler", "handleActivityBackground, ad activity background, call pauseCountDown");
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity) {
        if (activity == f() && this.f303642g) {
            n.e("QAdCountDownHandler", "handleActivityForeground, ad activity foreground, call startCountDown");
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        if (!this.f303642g && this.f303636a != null) {
            this.f303645j -= 200;
            n.e("QAdCountDownHandler", "daytonlin mMidPlayCountdownTimes " + this.f303645j);
            long j3 = this.f303645j;
            if (j3 > 0) {
                long j16 = 1000;
                if (j3 >= 1000) {
                    j16 = (int) j3;
                }
                long j17 = j16;
                if (!this.f303637b) {
                    q(j17);
                }
                BaseMidCountView baseMidCountView = this.f303641f;
                if (baseMidCountView != null) {
                    baseMidCountView.setCountDown((int) j17);
                }
                if (this.f303639d != null) {
                    this.f303639d.onAdCountDown(this.f303643h, j17, this.f303647l);
                }
                r();
            } else {
                n.e("QAdCountDownHandler", "handleCountDown, mid ad count down complete");
                d();
                s();
                if (this.f303639d != null) {
                    this.f303639d.f(this.f303643h);
                }
                if (this.f303640e != null) {
                    this.f303640e.j();
                }
            }
            return;
        }
        n.e("QAdCountDownHandler", "handleCountDown, pause count down");
    }

    private synchronized void l() {
        if (this.f303646k != null && this.f303638c == null) {
            n.e("QAdCountDownHandler", "registerActivityLifecycleCallback");
            this.f303638c = new a();
            qv2.b.a().registerActivityLifecycleCallbacks(this.f303638c);
        }
    }

    private synchronized void q(long j3) {
        n.e("QAdCountDownHandler", "startCountDownFirstTime");
        this.f303637b = true;
        if (this.f303639d != null) {
            this.f303639d.onAdCountDownStart(this.f303643h, j3, this.f303647l);
        }
        e();
    }

    private synchronized void s() {
        if (this.f303638c != null) {
            n.e("QAdCountDownHandler", "unregisterActivityLifecycleCallback");
            qv2.b.a().unregisterActivityLifecycleCallbacks(this.f303638c);
            this.f303638c = null;
        }
    }

    protected synchronized void e() {
        if (this.f303640e == null) {
            return;
        }
        BaseMidCountView e16 = this.f303640e.e();
        if (e16 != null && this.f303646k != null) {
            n.e("QAdCountDownHandler", "createAndAddCountDownView");
            this.f303641f = e16;
            e16.b(this.f303646k);
        }
    }

    public synchronized boolean j() {
        boolean z16;
        if (this.f303645j <= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public synchronized void k() {
        n.e("QAdCountDownHandler", "pauseCountDown");
        this.f303642g = true;
    }

    public synchronized void m() {
        k();
        d();
        s();
        this.f303639d = null;
        this.f303640e = null;
    }

    public void n(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.a aVar) {
        this.f303640e = aVar;
    }

    public void o(kt3.d dVar) {
        this.f303639d = dVar;
    }

    public synchronized void p() {
        r();
        l();
    }

    public synchronized void r() {
        n.e("QAdCountDownHandler", "startCountDown");
        if (j()) {
            return;
        }
        this.f303642g = false;
        yu2.f.f().d(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.i();
            }
        }, 200L);
    }
}
