package com.tencent.luggage.wxa.w8;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.wxa.w8.g;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f144126a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f144127b = new Handler(Looper.getMainLooper());

    public static final Handler a() {
        return f144127b;
    }

    public static final boolean b() {
        return Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread());
    }

    public static final Object d(Function0 cb5) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        return cb5.invoke();
    }

    public final Object c(final Function0 cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        f fVar = new f(new Callable() { // from class: l41.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return g.d(Function0.this);
            }
        });
        a(fVar);
        return fVar.a();
    }

    public static final void a(Runnable run) {
        Intrinsics.checkNotNullParameter(run, "run");
        if (b()) {
            run.run();
        } else {
            f144127b.post(run);
        }
    }

    public static final void b(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final void a(final Function0 run) {
        Intrinsics.checkNotNullParameter(run, "run");
        a(new Runnable() { // from class: l41.a
            @Override // java.lang.Runnable
            public final void run() {
                g.b(Function0.this);
            }
        });
    }
}
