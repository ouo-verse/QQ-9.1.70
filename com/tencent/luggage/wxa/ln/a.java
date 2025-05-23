package com.tencent.luggage.wxa.ln;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f133698a;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f133699b;

    public a(int i3) {
        if (i3 > 0) {
            this.f133698a = new AtomicInteger(i3);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.f133699b = runnable;
    }

    public final boolean b() {
        if (this.f133698a.decrementAndGet() == 0 && this.f133699b != null) {
            c().run();
            return true;
        }
        return false;
    }

    public final Runnable c() {
        Runnable runnable = this.f133699b;
        if (runnable != null) {
            return runnable;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callback");
        return null;
    }

    public final boolean d() {
        if (this.f133698a.get() == 0) {
            return true;
        }
        return false;
    }

    public final boolean a() {
        return this.f133698a.getAndSet(-1) > 0;
    }

    public final void a(int i3) {
        this.f133698a.set(i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i3, Runnable callback) {
        this(i3);
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(callback);
    }
}
