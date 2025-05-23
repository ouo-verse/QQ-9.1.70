package com.tencent.luggage.wxa.uk;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f142696a;

    /* renamed from: b, reason: collision with root package name */
    public final int f142697b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f142698c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f142699d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f142700e;

    /* renamed from: f, reason: collision with root package name */
    public AtomicInteger f142701f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f0(Runnable runnable) {
        this(runnable, 0, null, 6, null);
        Intrinsics.checkNotNullParameter(runnable, "runnable");
    }

    public void a() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "countdown, curCount: " + this.f142701f.decrementAndGet());
        if (d()) {
            run();
        }
    }

    public void b() {
        this.f142701f.set(0);
        run();
    }

    public final Runnable c() {
        return this.f142698c;
    }

    public boolean d() {
        if (this.f142701f.get() <= 0) {
            return true;
        }
        return false;
    }

    public int e() {
        return this.f142697b;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f142700e) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, isCanceled");
            return;
        }
        if (!d()) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, reach0 is false, just return");
        } else if (this.f142699d) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, hasRun");
        } else {
            this.f142696a.run();
            this.f142699d = true;
        }
    }

    public f0(Runnable runnable, int i3, Runnable runnable2) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f142696a = runnable;
        this.f142697b = i3;
        this.f142698c = runnable2;
        this.f142701f = new AtomicInteger(e());
    }

    public /* synthetic */ f0(Runnable runnable, int i3, Runnable runnable2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(runnable, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? null : runnable2);
    }
}
