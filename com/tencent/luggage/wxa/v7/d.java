package com.tencent.luggage.wxa.v7;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.luggage.storage.StandaloneCriticalDataProvider;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity;
import com.tencent.luggage.wxa.i1.a;
import com.tencent.luggage.wxa.n3.q0;
import com.tencent.luggage.wxa.q7.e0;
import com.tencent.luggage.wxa.q7.g0;
import com.tencent.luggage.wxa.q7.r;
import com.tencent.luggage.wxa.q7.y;
import com.tencent.luggage.wxa.q7.z;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.l0;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.luggage.wxa.zp.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibVersionChecker;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.smtt.sdk.TbsConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.v7.a {

    /* renamed from: b, reason: collision with root package name */
    public static final d f143293b = new d();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f143294c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f143295d = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends com.tencent.luggage.wxa.tk.a {

        /* renamed from: a, reason: collision with root package name */
        public int f143296a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Application f143297b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public static final b f143299a = new b();

            @Override // java.lang.Runnable
            public final void run() {
                w.c();
            }
        }

        public a(Application application) {
            this.f143297b = application;
        }

        @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f143296a++;
            w.d("Luggage.WXA.MainProcessStartup", "onActivityCreated: wxa lazy load start...");
            if (d.f143294c.get()) {
                this.f143297b.unregisterActivityLifecycleCallbacks(this);
                return;
            }
            i iVar = com.tencent.luggage.wxa.zp.h.f146825d;
            final d dVar = d.f143293b;
            iVar.d(new Runnable() { // from class: com.tencent.luggage.wxa.v7.d.a.a
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.b();
                }
            }, "MainProcessStartup-LoadLazyModules");
        }

        @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onActivityDestroyed(activity);
            int i3 = this.f143296a - 1;
            this.f143296a = i3;
            if (i3 <= 0) {
                com.tencent.luggage.wxa.zp.h.f146825d.c(b.f143299a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends com.tencent.luggage.wxa.w5.b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements d0 {

            /* renamed from: a, reason: collision with root package name */
            public static final a f143301a = new a();

            @Override // com.tencent.luggage.wxa.xd.d0
            public final void a(Context context, String str, String str2, d0.a aVar) {
                WxaSimpleWebViewActivity.INSTANCE.a(context, str);
            }
        }

        public c(Context context) {
            super(context);
        }

        @Override // com.tencent.luggage.wxa.w5.b, com.tencent.luggage.wxa.h4.b, com.tencent.luggage.wxa.h4.c, com.tencent.luggage.wxa.j1.a, com.tencent.luggage.wxa.i1.a.c
        public void a(a.d initializer) {
            Intrinsics.checkNotNullParameter(initializer, "initializer");
            super.a(initializer);
            com.tencent.luggage.wxa.h1.e.a(d0.class, a.f143301a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.v7.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6837d extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f143302a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6837d(Application application) {
            super(0);
            this.f143302a = application;
        }

        public final void a() {
            String str;
            String str2;
            C6837d c6837d;
            com.tencent.luggage.wxa.e5.g gVar = com.tencent.luggage.wxa.e5.g.f124544a;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            q0.a(q0.f135244a, false, 1, null);
            Unit unit = Unit.INSTANCE;
            String obj = unit.toString();
            String str3 = "";
            if (obj == null) {
                obj = "";
            }
            boolean a16 = l0.a();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 <= 32 || !a16) {
                str = "block main thread and skip ";
                StringBuilder sb5 = new StringBuilder();
                str2 = "runProfiled:log:";
                sb5.append(str2);
                sb5.append("WxaTdiLoginBoot.boot");
                sb5.append(" cost ");
                sb5.append(elapsedRealtime2);
                sb5.append(" ms result:");
                sb5.append(obj);
                sb5.append(" isMainThread: ");
                sb5.append(a16);
                sb5.append(TokenParser.SP);
                w.d("Luggage.Utils.Profile", sb5.toString());
                c6837d = this;
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("block main thread and skip ");
                str = "block main thread and skip ";
                sb6.append((int) (elapsedRealtime2 / 16));
                sb6.append(" frames! runProfiled:log:");
                sb6.append("WxaTdiLoginBoot.boot");
                sb6.append(" cost ");
                sb6.append(elapsedRealtime2);
                sb6.append(" ms result:");
                sb6.append(obj);
                sb6.append(" isMainThread: ");
                sb6.append(a16);
                sb6.append(TokenParser.SP);
                w.f("Luggage.Utils.Profile", sb6.toString());
                c6837d = this;
                str2 = "runProfiled:log:";
            }
            Application application = c6837d.f143302a;
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            g0.f137975e.a(application);
            WxaCommLibVersionChecker.f151845e.a(application);
            z.f138235e.a(application);
            String obj2 = unit.toString();
            if (obj2 != null) {
                str3 = obj2;
            }
            boolean a17 = l0.a();
            long elapsedRealtime4 = SystemClock.elapsedRealtime() - elapsedRealtime3;
            if (elapsedRealtime4 > 32 && a17) {
                w.f("Luggage.Utils.Profile", str + ((int) (elapsedRealtime4 / 16)) + " frames! runProfiled:log:installPeriodChecker cost " + elapsedRealtime4 + " ms result:" + str3 + " isMainThread: " + a17 + TokenParser.SP);
                return;
            }
            w.d("Luggage.Utils.Profile", str2 + "installPeriodChecker cost " + elapsedRealtime4 + " ms result:" + str3 + " isMainThread: " + a17 + TokenParser.SP);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f143303a;

        public e(Function0 function0) {
            this.f143303a = function0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.f143294c.get()) {
                this.f143303a.invoke();
            } else {
                com.tencent.luggage.wxa.zp.h.f146825d.b(this, 100L, "MainProcessStartup-LoadLazyModules");
            }
        }
    }

    public final void b() {
        if (!f143295d.getAndSet(true)) {
            AtomicBoolean atomicBoolean = f143294c;
            if (!atomicBoolean.get()) {
                Context c16 = com.tencent.luggage.wxa.tn.z.c();
                Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
                d(c16);
            }
            atomicBoolean.set(true);
            w.d("Luggage.WXA.MainProcessStartup", "safeLoadLazyModules end");
        }
    }

    public final boolean c(Context context) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isActivityAlive, ActivityGuard.hasRegistered:");
        com.tencent.luggage.wxa.q7.a aVar = com.tencent.luggage.wxa.q7.a.f137866a;
        sb5.append(aVar.b());
        w.d("Luggage.WXA.MainProcessStartup", sb5.toString());
        if (aVar.b()) {
            return aVar.a();
        }
        w.b("Luggage.WXA.MainProcessStartup", "isActivityAlive using ActivityManager, should be banned for gov requested");
        try {
            String i3 = com.tencent.luggage.wxa.tn.z.i();
            if (!Intrinsics.areEqual(i3, TbsConfig.APP_QB) && !Intrinsics.areEqual(i3, "com.tencent.news")) {
                Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                if (((ActivityManager) systemService).getRunningTasks(100).size() <= 0) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (Exception e16) {
            w.b("Luggage.WXA.MainProcessStartup", "isActivityAlive fail: " + e16);
            return false;
        }
    }

    public final void d(Context context) {
        Application application;
        Unit unit;
        Application application2;
        String str;
        String str2;
        String str3;
        if (context instanceof Application) {
            application = (Application) context;
        } else {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            application = (Application) applicationContext;
        }
        com.tencent.luggage.wxa.i1.a.a(new c(context));
        if (r.f138048a.e()) {
            com.tencent.luggage.wxa.j7.a.f130880a.a(new com.tencent.luggage.wxa.j7.c());
        }
        com.tencent.luggage.wxa.e5.g gVar = com.tencent.luggage.wxa.e5.g.f124544a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.luggage.wxa.t6.e.f140872a.a(application);
        Unit unit2 = Unit.INSTANCE;
        String obj = unit2.toString();
        if (obj == null) {
            obj = "";
        }
        boolean a16 = l0.a();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 > 32 && a16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("block main thread and skip ");
            unit = unit2;
            application2 = application;
            str = "";
            sb5.append((int) (elapsedRealtime2 / 16));
            sb5.append(" frames! runProfiled:log:");
            sb5.append("initWxaTask");
            sb5.append(" cost ");
            sb5.append(elapsedRealtime2);
            sb5.append(" ms result:");
            sb5.append(obj);
            sb5.append(" isMainThread: ");
            sb5.append(a16);
            sb5.append(TokenParser.SP);
            w.f("Luggage.Utils.Profile", sb5.toString());
        } else {
            unit = unit2;
            application2 = application;
            str = "";
            w.d("Luggage.Utils.Profile", "runProfiled:log:initWxaTask cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + a16 + TokenParser.SP);
        }
        long elapsedRealtime3 = SystemClock.elapsedRealtime();
        com.tencent.luggage.wxa.x7.i.f144642a.a();
        String obj2 = unit.toString();
        if (obj2 == null) {
            obj2 = str;
        }
        boolean a17 = l0.a();
        long elapsedRealtime4 = SystemClock.elapsedRealtime() - elapsedRealtime3;
        if (elapsedRealtime4 <= 32 || !a17) {
            str2 = "block main thread and skip ";
            w.d("Luggage.Utils.Profile", "runProfiled:log:installTdiCgi cost " + elapsedRealtime4 + " ms result:" + obj2 + " isMainThread: " + a17 + TokenParser.SP);
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("block main thread and skip ");
            str2 = "block main thread and skip ";
            sb6.append((int) (elapsedRealtime4 / 16));
            sb6.append(" frames! runProfiled:log:");
            sb6.append("installTdiCgi");
            sb6.append(" cost ");
            sb6.append(elapsedRealtime4);
            sb6.append(" ms result:");
            sb6.append(obj2);
            sb6.append(" isMainThread: ");
            sb6.append(a17);
            sb6.append(TokenParser.SP);
            w.f("Luggage.Utils.Profile", sb6.toString());
        }
        long elapsedRealtime5 = SystemClock.elapsedRealtime();
        y.f138216a.a(new C6837d(application2));
        String obj3 = unit.toString();
        if (obj3 == null) {
            obj3 = str;
        }
        boolean a18 = l0.a();
        long elapsedRealtime6 = SystemClock.elapsedRealtime() - elapsedRealtime5;
        if (elapsedRealtime6 > 32 && a18) {
            w.f("Luggage.Utils.Profile", str2 + ((int) (elapsedRealtime6 / 16)) + " frames! runProfiled:log:WxaDynamicPkgMgr.waitForLoaded cost " + elapsedRealtime6 + " ms result:" + obj3 + " isMainThread: " + a18 + TokenParser.SP);
        } else {
            w.d("Luggage.Utils.Profile", "runProfiled:log:WxaDynamicPkgMgr.waitForLoaded cost " + elapsedRealtime6 + " ms result:" + obj3 + " isMainThread: " + a18 + TokenParser.SP);
        }
        long elapsedRealtime7 = SystemClock.elapsedRealtime();
        com.tencent.luggage.wxa.b6.c.a();
        String obj4 = unit.toString();
        if (obj4 == null) {
            str3 = str;
        } else {
            str3 = obj4;
        }
        boolean a19 = l0.a();
        long elapsedRealtime8 = SystemClock.elapsedRealtime() - elapsedRealtime7;
        if (elapsedRealtime8 > 32 && a19) {
            w.f("Luggage.Utils.Profile", str2 + ((int) (elapsedRealtime8 / 16)) + " frames! runProfiled:log:initXWebEnvironment cost " + elapsedRealtime8 + " ms result:" + str3 + " isMainThread: " + a19 + TokenParser.SP);
        } else {
            w.d("Luggage.Utils.Profile", "runProfiled:log:initXWebEnvironment cost " + elapsedRealtime8 + " ms result:" + str3 + " isMainThread: " + a19 + TokenParser.SP);
        }
        com.tencent.luggage.wxa.f7.g.f125459c.c();
        e0.f137956a.a();
    }

    @Override // com.tencent.luggage.wxa.v7.a, com.tencent.luggage.wxa.v7.e
    public void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
    
        if (r5 == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Context context, boolean z16) {
        Application application;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        super.a(context);
        w.d("Luggage.WXA.MainProcessStartup", "initialize: main process start up, skipActivityInstanceCheck:" + z16);
        if (context instanceof Application) {
            application = (Application) context;
        } else {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            application = (Application) applicationContext;
        }
        com.tencent.luggage.wxa.u6.a.f142122a.b();
        if (!z16) {
            z17 = true;
            if (StandaloneCriticalDataProvider.INSTANCE.a() == null) {
                w.d("Luggage.WXA.MainProcessStartup", "initialize StandaloneCriticalDataProvider not created, should be called during Application.attachBaseContext()");
            } else {
                boolean c16 = c(context);
                w.d("Luggage.WXA.MainProcessStartup", "initialize isActivityAlive:" + c16);
            }
            if (!z17) {
                w.d("Luggage.WXA.MainProcessStartup", "initialize hold and wait for activity created");
                application.registerActivityLifecycleCallbacks(new a(application));
                return;
            } else {
                com.tencent.luggage.wxa.zp.h.f146825d.d(new Runnable() { // from class: com.tencent.luggage.wxa.v7.d.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.b();
                    }
                }, "MainProcessStartup-LoadLazyModules");
                return;
            }
        }
        z17 = false;
        if (!z17) {
        }
    }

    public final void a(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (f143294c.get()) {
            block.invoke();
        } else {
            com.tencent.luggage.wxa.zp.h.f146825d.d(new e(block), "MainProcessStartup-LoadLazyModules");
        }
    }
}
