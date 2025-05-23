package com.tencent.luggage.wxa.t6;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.MessageQueue;
import android.os.Process;
import com.tencent.luggage.wxa.p6.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f140879a = new h();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends com.tencent.luggage.wxa.tk.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f140880a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.t6.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6741a implements MessageQueue.IdleHandler {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f140881a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Activity f140882b;

            public C6741a(AtomicInteger atomicInteger, Activity activity) {
                this.f140881a = atomicInteger;
                this.f140882b = activity;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                if (this.f140881a.get() <= 0) {
                    boolean z16 = !com.tencent.luggage.wxa.c5.g.f123332a.c();
                    boolean a16 = com.tencent.luggage.wxa.lc.a.a();
                    w.d("Luggage.WxaProcessSuicideLogic", "before suicide maybe (onActivityDestroyed), last activity " + this.f140882b.getComponentName());
                    w.d("Luggage.WxaProcessSuicideLogic", "before suicide maybe (onActivityDestroyed), hasPendingLaunchActivity " + a16 + " hasRuntimeStashed " + z16);
                    if (!a16 && !z16) {
                        h.f140879a.a();
                    }
                    if (z16) {
                        return false;
                    }
                }
                return true;
            }
        }

        public a(AtomicInteger atomicInteger) {
            this.f140880a = atomicInteger;
        }

        @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f140880a.incrementAndGet();
        }

        @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f140880a.decrementAndGet();
            if (this.f140880a.get() <= 0) {
                com.tencent.luggage.wxa.bo.d.a(new C6741a(this.f140880a, activity));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements h.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f140883a;

        public b(AtomicInteger atomicInteger) {
            this.f140883a = atomicInteger;
        }

        @Override // com.tencent.luggage.wxa.p6.h.a
        public void a(com.tencent.luggage.wxa.p5.f rt5) {
            Intrinsics.checkNotNullParameter(rt5, "rt");
            com.tencent.luggage.wxa.c5.g gVar = com.tencent.luggage.wxa.c5.g.f123332a;
            gVar.b(rt5);
            boolean z16 = true;
            boolean z17 = !com.tencent.luggage.wxa.p6.h.f137365a.b();
            boolean z18 = !gVar.c();
            boolean a16 = com.tencent.luggage.wxa.lc.a.a();
            if (this.f140883a.get() <= 0) {
                z16 = false;
            }
            w.d("Luggage.WxaProcessSuicideLogic", "before suicide maybe (onRuntimeRemoved), hasPendingLaunchActivity:" + a16 + ", hasActiveActivity:" + z16 + ", hasRuntimeStashed:" + z18 + ", hasActiveRuntime:" + z17);
            if (!a16 && !z16 && !z18 && !z17) {
                h.f140879a.a();
            }
        }
    }

    public final void a(Application application) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(application, "application");
        String i3 = z.i();
        Intrinsics.checkNotNullExpressionValue(i3, "getProcessName()");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) i3, (CharSequence) ":wxa_container", false, 2, (Object) null);
        if (contains$default) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            application.registerActivityLifecycleCallbacks(new a(atomicInteger));
            com.tencent.luggage.wxa.p6.h.f137365a.a(new b(atomicInteger));
        }
    }

    public final void a() {
        w.c();
        SystemMethodProxy.killProcess(Process.myPid());
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
