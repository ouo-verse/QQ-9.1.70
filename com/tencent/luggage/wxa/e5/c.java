package com.tencent.luggage.wxa.e5;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f124539a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f124540b;

    public c(Runnable runnable, int i3) {
        boolean z16;
        this.f124539a = runnable;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.f124540b = new AtomicInteger(i3);
            return;
        }
        throw new IllegalArgumentException("count <= 0".toString());
    }

    public final void a() {
        Runnable runnable;
        if (this.f124540b.decrementAndGet() == 0 && (runnable = this.f124539a) != null) {
            runnable.run();
        }
    }
}
