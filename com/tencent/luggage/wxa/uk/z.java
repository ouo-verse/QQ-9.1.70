package com.tencent.luggage.wxa.uk;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class z implements Runnable, com.tencent.luggage.wxa.vo.a {

    /* renamed from: e, reason: collision with root package name */
    public static final a f142812e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final s f142813a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f142814b;

    /* renamed from: c, reason: collision with root package name */
    public final String f142815c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f142816d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final z a(s registry, Runnable runnable) {
            Intrinsics.checkNotNullParameter(registry, "registry");
            if (runnable instanceof z) {
                runnable = ((z) runnable).f142814b;
            }
            String stackTraceString = Log.getStackTraceString(new Throwable());
            Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(Throwable())");
            z zVar = new z(registry, runnable, stackTraceString);
            registry.b(zVar);
            return zVar;
        }
    }

    public z(s mRegistry, Runnable runnable, String str) {
        Intrinsics.checkNotNullParameter(mRegistry, "mRegistry");
        this.f142813a = mRegistry;
        this.f142814b = runnable;
        this.f142815c = str;
        this.f142816d = new AtomicBoolean(false);
    }

    public static final z a(s sVar, Runnable runnable) {
        return f142812e.a(sVar, runnable);
    }

    @Override // com.tencent.luggage.wxa.vo.a
    public void g() {
        this.f142816d.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f142816d.get()) {
            try {
                Runnable runnable = this.f142814b;
                if (runnable != null) {
                    runnable.run();
                }
                return;
            } finally {
                this.f142813a.a(this);
            }
        }
        com.tencent.luggage.wxa.tn.w.f("Luggage.WXA.LifeCycleWrappedRunnable", "run() but dead, <init> stackTrace = " + this.f142815c);
    }

    public String toString() {
        return "[LifeCycleWrappedRunnable]" + this.f142814b;
    }
}
