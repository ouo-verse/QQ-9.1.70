package com.tencent.luggage.wxa.q7;

import android.app.Activity;
import android.app.Application;
import com.tencent.luggage.wxa.tn.w0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f137869a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final long f137870b = TimeUnit.DAYS.toMillis(1);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f137871c = true;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f137872d = true;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {
        public a() {
            super(0);
        }

        public final void a() {
            boolean z16;
            long j3 = a0.this.g().getLong(a0.this.f(), 0L);
            long c16 = w0.c();
            if (j3 > c16 || w0.c(j3) >= a0.this.c()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                try {
                    a0.this.b();
                } finally {
                    a0.this.g().putLong(a0.this.f(), c16);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends com.tencent.luggage.wxa.tk.a {

        /* renamed from: a, reason: collision with root package name */
        public int f137874a;

        public b() {
        }

        @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f137874a++;
        }

        @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            int i3 = this.f137874a - 1;
            this.f137874a = i3;
            if (i3 > 0) {
                return;
            }
            this.f137874a = 0;
            a0.this.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f137876a;

        public c(Function0 function0) {
            this.f137876a = function0;
        }

        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.f137876a.invoke();
        }
    }

    public abstract void b();

    public void b(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public long c() {
        return this.f137870b;
    }

    public boolean d() {
        return this.f137872d;
    }

    public boolean e() {
        return this.f137871c;
    }

    public final String f() {
        return h() + "__KEY_LAST_CHECKED_TIMESTAMP";
    }

    public final com.tencent.luggage.wxa.tn.f0 g() {
        return com.tencent.luggage.wxa.tn.f0.c("WxaPeriodTaskChecker.cfg", 2);
    }

    public abstract String h();

    public final void a(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if ((!d() || com.tencent.luggage.wxa.tn.z.m()) && !this.f137869a.getAndSet(true)) {
            application.registerActivityLifecycleCallbacks(new b());
            b(application);
        }
    }

    public final void a() {
        a aVar = new a();
        if (e()) {
            com.tencent.luggage.wxa.zp.h.f146825d.d(new c(aVar));
        } else {
            aVar.invoke();
        }
    }
}
