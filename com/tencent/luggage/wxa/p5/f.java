package com.tencent.luggage.wxa.p5;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.b5.k;
import com.tencent.luggage.wxa.fd.b;
import com.tencent.luggage.wxa.h2.a;
import com.tencent.luggage.wxa.h6.l;
import com.tencent.luggage.wxa.h6.q;
import com.tencent.luggage.wxa.i3.o;
import com.tencent.luggage.wxa.i3.w;
import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.v;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.lj.a;
import com.tencent.luggage.wxa.lj.j;
import com.tencent.luggage.wxa.n3.l0;
import com.tencent.luggage.wxa.n5.b;
import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.p5.f;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.rc.s;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandOnBackgroundFetchDataEvent;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mobileqq.mini.api.LaunchScene;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.joor.ReflectException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.c5.e {
    public EnumC6584f S0;
    public boolean T0;
    public final e.a U0;
    public h V0;
    public final LongSparseArray W0;
    public boolean X0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements e.a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p5.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6580a implements ValueCallback {
            public C6580a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                w.d("Luggage.STANDALONE.Runtime", "onAccountLogout() logout js evaluated");
            }
        }

        public a() {
        }

        @Override // com.tencent.luggage.wxa.o3.e.a
        public void a(com.tencent.luggage.wxa.o3.j jVar) {
        }

        @Override // com.tencent.luggage.wxa.o3.e.a
        public void a() {
            if (f.this.t0()) {
                return;
            }
            if (f.this.c2() == EnumC6584f.KillRuntime) {
                f.this.D();
            } else {
                if (f.this.h0() == null) {
                    return;
                }
                f.this.h0().getJsRuntime().evaluateJavascript("if (wx && wx.logout) { wx.logout(function(res){}); }", new C6580a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Function1 {
        public b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(f fVar) {
            boolean z16;
            if (fVar.getAppId().equals(f.this.getAppId()) && fVar != f.this) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends g.x {

        /* renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f137294b = new AtomicBoolean(false);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements w.a {

            /* renamed from: a, reason: collision with root package name */
            public final AtomicBoolean f137296a = new AtomicBoolean(false);

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g.x f137297b;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.p5.f$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC6581a implements Runnable {
                public RunnableC6581a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    f fVar = f.this;
                    if (q.a() && l.f126905a.a(f.this.getAppId())) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    fVar.a(fVar.h(z16));
                }
            }

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    f.this.j2();
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.p5.f$c$a$c, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC6582c implements Runnable {

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.p5.f$c$a$c$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public class RunnableC6583a implements Runnable {
                    public RunnableC6583a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a("onOrientationChanged: fail, go ready simply");
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.p5.f$c$a$c$b */
                /* loaded from: classes8.dex */
                public class b implements e.a {
                    public b() {
                    }

                    @Override // com.tencent.luggage.wxa.wj.e.a
                    public void a(e.b bVar, boolean z16) {
                        a.this.a(String.format(Locale.ENGLISH, "onOrientationChanged: res = [%b]", Boolean.valueOf(z16)));
                    }
                }

                public RunnableC6582c() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    f.this.b(new RunnableC6583a(), 500L);
                    f.this.a(new b(), f.this.Z1());
                }
            }

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public class d implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Throwable f137304a;

                public d(Throwable th5) {
                    this.f137304a = th5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(z.c(), this.f137304a.getMessage(), 0).show();
                }
            }

            public a(g.x xVar) {
                this.f137297b = xVar;
            }

            @Override // com.tencent.luggage.wxa.i3.w.a
            public void onError(final Throwable th5) {
                if (!c.this.f137294b.get()) {
                    x.f129431a.a(f.this.S().k(), x.d.FAIL, th5);
                    if (th5 instanceof o) {
                        ((o) th5).a(f.this);
                        return;
                    }
                    f.this.D();
                    if (th5 instanceof CancellationException) {
                        return;
                    }
                    if (th5 instanceof com.tencent.luggage.wxa.bj.a) {
                        com.tencent.luggage.wxa.zp.h.f146825d.a(new Runnable() { // from class: s31.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                f.c.a.this.a(th5);
                            }
                        });
                    } else if (!TextUtils.isEmpty(th5.getMessage())) {
                        com.tencent.luggage.wxa.zp.h.f146825d.a(new d(th5));
                    }
                }
            }

            public final void a(String str) {
                if (this.f137296a.getAndSet(true) || c.this.f137294b.get()) {
                    return;
                }
                com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "|runProfiled| WxaLaunchPrepareProcess.invokeProcessReady(%s), appId:%s, ts:%d, hash:%d", str, f.this.getAppId(), Long.valueOf(w0.c()), Integer.valueOf(this.f137297b.hashCode()));
                this.f137297b.d();
            }

            @Override // com.tencent.luggage.wxa.i3.w.a
            public void a(com.tencent.luggage.wxa.j4.g gVar) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "|runProfiled| WxaLaunchPrepareProcess end, appId:%s, ts:%d", f.this.getAppId(), Long.valueOf(w0.c()));
                if (gVar == null || c.this.f137294b.get()) {
                    if (c.this.f137294b.get()) {
                        return;
                    }
                    com.tencent.luggage.wxa.tn.w.b("Luggage.STANDALONE.Runtime", "|runProfiled| WxaLaunchPrepareProcess,SysConfig is null, finish, appId:%s, ts:%d, hash:%d", f.this.getAppId(), Long.valueOf(w0.c()), Integer.valueOf(this.f137297b.hashCode()));
                    f.this.D();
                    return;
                }
                com.tencent.luggage.wxa.gi.b.b(f.this.getAppId(), com.tencent.luggage.wxa.ik.a.f130632m);
                com.tencent.luggage.wxa.gi.b.b(f.this.getAppId(), com.tencent.luggage.wxa.ik.a.f130630k);
                com.tencent.luggage.wxa.gi.b.c(f.this.getAppId(), com.tencent.luggage.wxa.ik.a.f130638s);
                try {
                    try {
                        f.this.J().add(gVar);
                        f.this.J().add(gVar.d());
                        f.this.J().add(new com.tencent.luggage.wxa.rj.d(gVar.K));
                        Locale locale = Locale.ENGLISH;
                        com.tencent.luggage.wxa.e5.g.a(String.format(locale, "Runtime(%s).setAppConfig", f.this.getAppId()), new RunnableC6581a());
                        f.this.a(new com.tencent.luggage.wxa.rj.c((com.tencent.luggage.wxa.ic.g) f.this, 0, false));
                        f.this.b(true);
                        com.tencent.luggage.wxa.e5.g.a(String.format(locale, "Runtime(%s).setupConfigs", f.this.getAppId()), new b());
                        com.tencent.luggage.wxa.gi.b.b(f.this.getAppId(), com.tencent.luggage.wxa.ik.a.f130638s);
                        f.this.i2();
                        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "|runProfiled| WxaLaunchPrepareProcess setup configs end, appId:%s, ts:%d", f.this.getAppId(), Long.valueOf(w0.c()));
                        f.this.e(new RunnableC6582c());
                        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "|runProfiled| WxaLaunchPrepareProcess finally terminate, appId:%s, ts:%d", f.this.getAppId(), Long.valueOf(w0.c()));
                        x.f129431a.a(f.this.S().k(), x.d.OK);
                    } catch (NullPointerException e16) {
                        if (!f.this.t0() && !f.this.w0() && !c.this.f137294b.get()) {
                            throw e16;
                        }
                        com.tencent.luggage.wxa.tn.w.a("Luggage.STANDALONE.Runtime", e16, "runtime destroyed", new Object[0]);
                        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "|runProfiled| WxaLaunchPrepareProcess finally terminate, appId:%s, ts:%d", f.this.getAppId(), Long.valueOf(w0.c()));
                        x.f129431a.a(f.this.S().k(), x.d.OK);
                    }
                } catch (Throwable th5) {
                    com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "|runProfiled| WxaLaunchPrepareProcess finally terminate, appId:%s, ts:%d", f.this.getAppId(), Long.valueOf(w0.c()));
                    x.f129431a.a(f.this.S().k(), x.d.OK);
                    throw th5;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(Throwable th5) {
                com.tencent.luggage.wxa.j3.c.f130777a.a(f.this.L(), (com.tencent.luggage.wxa.bj.a) th5);
            }
        }

        public c() {
        }

        @Override // com.tencent.luggage.wxa.ic.g.x
        public String b() {
            return "WxaLaunchPrepareProcess";
        }

        @Override // com.tencent.luggage.wxa.ic.g.x
        public void c() {
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "ResourcePrepareProcess.prepare() appId:%s, hash:%d", f.this.getAppId(), Integer.valueOf(hashCode()));
            com.tencent.luggage.wxa.gi.b.c(f.this.getAppId(), com.tencent.luggage.wxa.ik.a.f130630k);
            com.tencent.luggage.wxa.gi.b.c(f.this.getAppId(), com.tencent.luggage.wxa.ik.a.f130632m);
            AppBrandBackgroundRunningMonitor.a(f.this);
            com.tencent.luggage.wxa.i3.w.a(f.this, new a(this));
        }

        @Override // com.tencent.luggage.wxa.ic.g.x
        public void a() {
            com.tencent.luggage.wxa.tn.w.b("Luggage.STANDALONE.Runtime", "ResourcePrepareProcess.interrupt() appId:%s, hash:%d", f.this.getAppId(), Integer.valueOf(hashCode()));
            super.a();
            this.f137294b.set(true);
            f.this.b0().a("FATAL");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.p5.f$f, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC6584f {
        KillRuntime,
        KeepRuntimeAlive
    }

    static {
        com.tencent.luggage.wxa.y7.a.a();
        com.tencent.luggage.wxa.tn.j.f141599a.i();
    }

    public f(@NonNull v vVar) {
        super(vVar);
        this.S0 = EnumC6584f.KillRuntime;
        this.T0 = false;
        this.U0 = new a();
        this.W0 = new LongSparseArray();
        f(true);
        a(vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2() {
        AppBrandOnBackgroundFetchDataEvent.a(this);
        com.tencent.luggage.wxa.tc.b.a(S().f125808a, S().G, l0(), O(), G1(), new com.tencent.luggage.wxa.tc.g(S().k()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2() {
        if (Q1() && !TextUtils.isEmpty(S().f125812e)) {
            e.b a16 = e.b.a(S().f125812e);
            com.tencent.luggage.wxa.wj.e orientationHandler = n0().getOrientationHandler();
            if (a16 == null) {
                a16 = e.b.PORTRAIT;
            }
            orientationHandler.a(a16, null);
        }
    }

    @Override // com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void J0() {
        if (Q1()) {
            try {
                this.V0 = new com.tencent.luggage.wxa.u5.b();
            } catch (ReflectException unused) {
                throw new RuntimeException("Check your proguard config pls, you should keep 'com.tencent.luggage.standalone_ext.game.impl.StandaloneGameGlobalSetupDelegateIMPL' for mini-game support.");
            }
        }
        com.tencent.luggage.wxa.gi.b.c(getAppId(), com.tencent.luggage.wxa.ik.a.f130626g);
        com.tencent.luggage.wxa.p6.h hVar = com.tencent.luggage.wxa.p6.h.f137365a;
        hVar.a(2, new b());
        hVar.a(this);
        com.tencent.luggage.wxa.r6.b.c(this);
        boolean z16 = false;
        com.tencent.luggage.wxa.r6.e.a((com.tencent.luggage.wxa.c5.e) this, false);
        super.J0();
        a(com.tencent.luggage.wxa.bj.c.class, l0.f135214b);
        if (Q1()) {
            h hVar2 = this.V0;
            Objects.requireNonNull(hVar2);
            hVar2.a(this);
        }
        new com.tencent.luggage.wxa.b5.h(this).c();
        new com.tencent.luggage.wxa.b5.a(this).b();
        l2();
        k2();
        if (L1().f122984c == 1099) {
            z16 = true;
        }
        this.X0 = z16;
    }

    @Override // com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void K0() {
        com.tencent.luggage.wxa.p6.h.f137365a.b(this);
        super.K0();
        com.tencent.luggage.wxa.h2.a.b(h0());
        com.tencent.luggage.wxa.c2.a.b(getAppId());
        new com.tencent.luggage.wxa.b5.i((com.tencent.luggage.wxa.c5.e) this, true).b();
        com.tencent.luggage.wxa.o3.l.f136139a.a(this.U0);
        com.tencent.luggage.wxa.ih.d dVar = (com.tencent.luggage.wxa.ih.d) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.ih.d.class);
        if (dVar != null) {
            dVar.i(getAppId());
        }
    }

    @Override // com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void N0() {
        super.N0();
        com.tencent.luggage.wxa.o3.l.f136139a.b(this.U0);
        com.tencent.luggage.wxa.uc.a.a(this);
        com.tencent.luggage.wxa.gi.b.b(getAppId(), com.tencent.luggage.wxa.ik.a.f130626g);
        com.tencent.luggage.wxa.gi.b.c(getAppId(), com.tencent.luggage.wxa.ik.a.f130644y);
        if (y1() && (n0() instanceof com.tencent.luggage.wxa.f6.g)) {
            DisplayMetrics vDisplayMetrics = n0().getVDisplayMetrics();
            K().measure(View.MeasureSpec.makeMeasureSpec(vDisplayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(vDisplayMetrics.heightPixels, Integer.MIN_VALUE));
        }
    }

    @Override // com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void P0() {
        super.P0();
        if (S().f130795g0) {
            Context F = F();
            if (F instanceof com.tencent.luggage.wxa.f6.j) {
                com.tencent.luggage.wxa.ic.i.a(this, com.tencent.luggage.wxa.f6.j.a(((com.tencent.luggage.wxa.f6.j) F).getBaseContext()));
            }
        }
        d(new Runnable() { // from class: s31.a
            @Override // java.lang.Runnable
            public final void run() {
                f.this.e2();
            }
        });
        c0.a(new Runnable() { // from class: s31.b
            @Override // java.lang.Runnable
            public final void run() {
                f.this.f2();
            }
        });
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void Q0() {
        super.Q0();
        com.tencent.luggage.wxa.r6.b.a(this);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void S0() {
        super.S0();
        com.tencent.luggage.wxa.h2.a.a(h0());
        if (y1() && (n0() instanceof com.tencent.luggage.wxa.f6.g)) {
            DisplayMetrics vDisplayMetrics = n0().getVDisplayMetrics();
            K().measure(View.MeasureSpec.makeMeasureSpec(vDisplayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(vDisplayMetrics.heightPixels, Integer.MIN_VALUE));
        }
    }

    @Override // com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void T0() {
        super.T0();
        com.tencent.luggage.wxa.gi.b.b(getAppId(), com.tencent.luggage.wxa.ik.a.f130644y);
        com.tencent.luggage.wxa.gi.b.a(com.tencent.luggage.wxa.ik.a.class, getAppId());
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void U0() {
        b("Luggage.STANDALONE.Runtime:" + getAppId());
    }

    @Override // com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void V0() {
        com.tencent.luggage.wxa.p6.h.f137365a.a(this);
        super.V0();
        try {
            new k(this).b();
        } catch (Throwable unused) {
        }
        com.tencent.luggage.wxa.r6.b.b(this);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void X0() {
        com.tencent.luggage.wxa.h2.a.a(h0());
        new com.tencent.luggage.wxa.b5.h(this).b();
    }

    public EnumC6584f c2() {
        return this.S0;
    }

    @Override // com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void d(com.tencent.luggage.wxa.fd.i iVar) {
        super.d(iVar);
        if (!t1()) {
            com.tencent.luggage.wxa.r6.e.a((com.tencent.luggage.wxa.c5.e) this, true);
            com.tencent.luggage.wxa.i3.e.f129218h.b(this);
        }
    }

    public boolean d2() {
        return this.T0;
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void e(int i3) {
        super.e(i3);
        if (i3 != 2) {
            this.T0 = false;
        }
    }

    public void h(int i3) {
        boolean t06 = t0();
        a("onDownloadProgress(%d), hasDownload[%b]", Integer.valueOf(i3), Boolean.valueOf(this.T0));
        if (t06) {
            return;
        }
        f(i3);
    }

    public void h2() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "onLaunchStartDownloadPkg appId:%s", getAppId());
        this.T0 = true;
    }

    public void i2() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "onPrepareDone appId:%s", getAppId());
        b0().b();
    }

    public void j2() {
        com.tencent.luggage.wxa.j4.g j06 = j0();
        com.tencent.luggage.wxa.r5.a S = S();
        com.tencent.luggage.wxa.fd.b E = E();
        if (j06 != null && S != null && E != null) {
            J().add(com.tencent.luggage.wxa.fd.f.a(this, j06, E));
            J().add(com.tencent.luggage.wxa.fd.f.a(S));
            J().add(com.tencent.luggage.wxa.fd.f.b());
            J().add(com.tencent.luggage.wxa.fd.f.a((com.tencent.luggage.wxa.c5.e) this));
            com.tencent.luggage.wxa.qj.a a16 = com.tencent.luggage.wxa.fd.f.a(j06);
            a16.f138884b |= false;
            J().add(a16);
            com.tencent.luggage.wxa.h2.a.a(getAppId(), new e());
            return;
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.STANDALONE.Runtime", "setupConfigs get NULL Config, appId[%s]", getAppId());
    }

    public final void k2() {
        com.tencent.luggage.wxa.ih.d dVar = (com.tencent.luggage.wxa.ih.d) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.ih.d.class);
        if (dVar != null) {
            dVar.a(getAppId(), new d());
        }
    }

    public void l2() {
        b((g.x) new c());
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public final boolean m1() {
        return !Q1();
    }

    @Override // com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public final void o() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "close appId[%s] type[%d] hash[%d] stacktrace=%s", getAppId(), Integer.valueOf(l0()), Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()));
        super.o();
    }

    @Override // com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public r q() {
        com.tencent.luggage.wxa.h1.e.a(s.class, new com.tencent.luggage.wxa.rc.i());
        return super.q();
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public com.tencent.luggage.wxa.ok.j r() {
        return new com.tencent.luggage.wxa.f6.f(n0(), this);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public p t() {
        Context F;
        if (Q1()) {
            h hVar = this.V0;
            Objects.requireNonNull(hVar);
            return hVar.b(this);
        }
        if (L() == null) {
            F = L();
        } else {
            F = F();
        }
        return new com.tencent.luggage.wxa.p5.d(F, this);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public com.tencent.luggage.wxa.ic.l u() {
        if (R1()) {
            return new com.tencent.luggage.wxa.a6.a((Function<com.tencent.luggage.wxa.r4.d, ? extends com.tencent.luggage.wxa.r4.f>) new Function() { // from class: s31.d
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return new com.tencent.luggage.wxa.r4.q((com.tencent.luggage.wxa.r4.d) obj);
                }
            });
        }
        if (Q1()) {
            h hVar = this.V0;
            Objects.requireNonNull(hVar);
            return hVar.c(this);
        }
        return new com.tencent.luggage.wxa.a6.a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends d.b {

        /* renamed from: a, reason: collision with root package name */
        public j.b f137306a;

        public d() {
        }

        public final void a() {
            j.b bVar = this.f137306a;
            if (bVar != null) {
                bVar.c();
            }
        }

        public final void b() {
            j.b bVar = this.f137306a;
            if (bVar != null) {
                bVar.c();
            }
            this.f137306a = a.b.a(f.this).a(a.c.VOICE);
        }

        @Override // com.tencent.luggage.wxa.ih.d.b, com.tencent.luggage.wxa.ih.d.c
        public void onStart() {
            super.onStart();
            b();
        }

        @Override // com.tencent.luggage.wxa.ih.d.b, com.tencent.luggage.wxa.ih.d.c
        public void a(String str, int i3, int i16) {
            super.a(str, i3, i16);
            a();
        }
    }

    public final b.e Z1() {
        n currentPage;
        if (!s0()) {
            com.tencent.luggage.wxa.fd.b E = E();
            if (E == null) {
                return null;
            }
            return E.a(com.tencent.luggage.wxa.h6.o.b(O()));
        }
        com.tencent.luggage.wxa.y4.b Y = Y();
        if (Y == null || (currentPage = Y.getCurrentPage()) == null) {
            return null;
        }
        return currentPage.getPageConfig();
    }

    @Override // com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    /* renamed from: a2, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.r5.a S() {
        return (com.tencent.luggage.wxa.r5.a) super.S();
    }

    public com.tencent.luggage.wxa.rc.q b2() {
        return (com.tencent.luggage.wxa.rc.q) super.f(com.tencent.luggage.wxa.rc.q.class);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public final void b(int i3) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "finish appId[%s] type[%d] hash[%d] isFinishing[%b] reason[%d] stacktrace=%s", getAppId(), Integer.valueOf(l0()), Integer.valueOf(hashCode()), Boolean.valueOf(w0()), Integer.valueOf(i3), Log.getStackTraceString(new Throwable()));
        if (w0()) {
            return;
        }
        super.b(i3);
    }

    @Override // com.tencent.luggage.wxa.c5.e
    public boolean e(com.tencent.luggage.wxa.fd.i iVar) {
        int i3;
        com.tencent.luggage.wxa.j4.d dVar = (com.tencent.luggage.wxa.j4.d) iVar;
        com.tencent.luggage.wxa.r5.a S = S();
        com.tencent.luggage.wxa.bk.e i16 = dVar.i();
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "shouldRelaunchOnConfigChanged, appId[%s] newPath[%s] oldPath[%s] currentPath[%s]", getAppId(), dVar.f125813f, S.f125813f, Y().getCurrentUrl());
        if (!this.X0 && (i3 = i16.f122984c) != 1099) {
            if (ArrayUtils.contains(new int[]{LaunchScene.LAUNCH_SCENE_VM_NOTIFICATION, 1168}, i3) && dVar.i().f122984c == S.i().f122984c) {
                String c16 = TextUtils.isEmpty(dVar.f125813f) ? E().c() : dVar.f125813f;
                if (StringUtils.equals(TextUtils.isEmpty(S.f125813f) ? E().c() : S.f125813f, c16) && (dVar.f130797i0 || StringUtils.equals(c16, Y().getCurrentUrl()))) {
                    com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "shouldRelaunchOnConfigChanged, both scene & path the same, return false, scene[%d], path[%s], forceIndexNoReLaunch[%b]", Integer.valueOf(dVar.i().f122984c), dVar.f125813f, Boolean.valueOf(dVar.f130797i0));
                    return false;
                }
            }
            if (ArrayUtils.contains(new int[]{1001, 1003, 1023, 1038, 1056, 1080, 1083, 1089, 1090, 1103, 1104, 1113, 1114, 1117, 1131}, i16.f122984c)) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "shouldRelaunch return false. keepNoRelaunch appId[%s] newScene[%d]", getAppId(), Integer.valueOf(i16.f122984c));
                return false;
            }
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "shouldRelaunchOnConfigChanged, fallback return true");
            return true;
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "shouldRelaunch return true. appId[%s] mShouldRelaunchCausedByFunctionalPageOpen[%b] newScene[%d]", getAppId(), Boolean.valueOf(this.X0), Integer.valueOf(i16.f122984c));
        this.X0 = i16.f122984c == 1099;
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.h2.a.e
        public void a(Object obj) {
            if (obj instanceof b.a) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "onCustomDataNotify, appId[%s], AuthStateChangedByUserEvent", f.this.getAppId());
                com.tencent.luggage.wxa.tj.b.a(f.this.getAppId());
                f fVar = f.this;
                b.a aVar = (b.a) obj;
                fVar.a(fVar, aVar);
                com.tencent.luggage.wxa.ge.d.f126692a.a(f.this.getAppId(), a(aVar));
            }
        }

        public final com.tencent.luggage.wxa.ge.c a(b.a aVar) {
            boolean z16 = aVar.f135334c;
            if (!z16 && !aVar.f135335d) {
                return com.tencent.luggage.wxa.ge.c.REJECTED;
            }
            if (z16 && !aVar.f135335d) {
                return com.tencent.luggage.wxa.ge.c.ACCEPTED_IN_FOREGROUND;
            }
            if (z16 && aVar.f135335d) {
                return com.tencent.luggage.wxa.ge.c.ALWAYS_ACCEPTED;
            }
            return null;
        }
    }

    public void b(final long j3, final AppBrandOnBackgroundFetchDataEvent appBrandOnBackgroundFetchDataEvent) {
        c(new Runnable() { // from class: s31.c
            @Override // java.lang.Runnable
            public final void run() {
                f.this.a(j3, appBrandOnBackgroundFetchDataEvent);
            }
        });
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void a(v vVar) {
        super.a(vVar);
        com.tencent.luggage.wxa.kj.v vVar2 = null;
        if (vVar != null) {
            Activity context = vVar.getContext();
            if (vVar instanceof com.tencent.luggage.wxa.ic.j) {
                Activity j3 = ((com.tencent.luggage.wxa.ic.j) vVar).j();
                Objects.requireNonNull(j3);
                context = j3;
            }
            if (F() instanceof com.tencent.luggage.wxa.f6.j) {
                ((com.tencent.luggage.wxa.f6.j) F()).setBaseContext(context);
            }
            if (I() != null) {
                I().a(context);
            }
            if (h0() != null) {
                h0().a(n0());
            }
            if (Y() != null && Y().getCurrentPage() != null) {
                vVar2 = Y().getCurrentPage().getCurrentPageView();
            }
            if (vVar2 != null) {
                vVar2.a(n0());
                Y().b(vVar2);
                return;
            }
            return;
        }
        if (S() != null) {
            com.tencent.luggage.wxa.f6.g gVar = new com.tencent.luggage.wxa.f6.g(null, S().T0, z.c());
            Context context2 = gVar.getContext();
            if (context2 instanceof com.tencent.luggage.wxa.f6.j) {
                context2 = ((com.tencent.luggage.wxa.f6.j) context2).getBaseContext();
            }
            if (F() instanceof com.tencent.luggage.wxa.f6.j) {
                com.tencent.luggage.wxa.ic.i.a(this, com.tencent.luggage.wxa.f6.j.a(context2));
            }
            if (I() != null) {
                I().a(context2);
            }
            if (h0() != null) {
                h0().a((com.tencent.luggage.wxa.wj.c) gVar);
            }
            if (Y() != null) {
                com.tencent.luggage.wxa.kj.q.a(Y(), gVar);
            }
        }
    }

    public f(@NonNull com.tencent.luggage.wxa.wj.c cVar) {
        super(cVar);
        this.S0 = EnumC6584f.KillRuntime;
        this.T0 = false;
        this.U0 = new a();
        this.W0 = new LongSparseArray();
        f(true);
        if (cVar instanceof v) {
            a((v) cVar);
        } else {
            a((v) null);
        }
    }

    public void g2() {
    }

    public final void a(e.a aVar, b.e eVar) {
        e.b bVar = null;
        if (t0()) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "mayRequestOrientation mFinished is true return,mAppId:%s", getAppId());
            aVar.a(null, false);
            return;
        }
        if (Q1()) {
            bVar = e.b.a(E().a().f125641a);
        } else if (eVar == null) {
            if (k()) {
                throw new IllegalArgumentException("page config should not be NULL!!");
            }
        } else {
            e.b a16 = e.b.a(eVar.f125694n);
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "currentOrientation = [%s] orientation = [%s] allowUnLock = [%b] resizable = [%b]", n0().getOrientationHandler().a(), a16, Boolean.valueOf(((com.tencent.luggage.wxa.j4.a) a(com.tencent.luggage.wxa.j4.a.class)).f130780a), Boolean.valueOf(E().H));
            if (e.b.b(n0().getOrientationHandler().a()) && ((com.tencent.luggage.wxa.j4.a) a(com.tencent.luggage.wxa.j4.a.class)).f130780a && a16 != e.b.UNSPECIFIED) {
                aVar.a(null, false);
                return;
            }
            bVar = a16;
        }
        if (E().H && !Q1()) {
            n0().getOrientationHandler().a(e.b.UNSPECIFIED, aVar);
            return;
        }
        com.tencent.luggage.wxa.wj.e orientationHandler = n0().getOrientationHandler();
        if (bVar == null) {
            bVar = e.b.PORTRAIT;
        }
        orientationHandler.a(bVar, aVar);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void a(com.tencent.luggage.wxa.fd.i iVar, String str) {
        if (iVar == null) {
            S().p();
            S().S = w0.c();
            com.tencent.luggage.wxa.r5.a S = S();
            com.tencent.luggage.wxa.dk.b a16 = com.tencent.luggage.wxa.r6.b.a(getAppId());
            Objects.requireNonNull(a16);
            S.J0 = new com.tencent.luggage.wxa.li.b(a16.f124303a, str);
            S().a(com.tencent.luggage.wxa.i3.s.a(S()));
        }
        super.a(iVar, str);
    }

    public final void a(com.tencent.luggage.wxa.ic.g gVar, b.a aVar) {
        if (gVar != null) {
            com.tencent.luggage.wxa.ef.o oVar = (com.tencent.luggage.wxa.ef.o) gVar.c(com.tencent.luggage.wxa.ef.o.class);
            if (!(oVar instanceof com.tencent.luggage.wxa.ef.p)) {
                com.tencent.luggage.wxa.tn.w.f("Luggage.STANDALONE.Runtime", "handleUserAuthChanged, invalid location state manager");
                return;
            }
            com.tencent.luggage.wxa.ef.p pVar = (com.tencent.luggage.wxa.ef.p) oVar;
            boolean z16 = aVar.f135332a;
            boolean z17 = aVar.f135333b;
            boolean z18 = (pVar.p() || z16) ? false : true;
            boolean z19 = pVar.p() && !(z17 && z16);
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "handleUserAuthChanged, should stop location foreground:%s, should stop location background:%s", Boolean.valueOf(z18), Boolean.valueOf(z19));
            if (z18 || z19) {
                pVar.n();
                pVar.a(gVar);
            }
            if (z19) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "locationBackgroundStateChanged, not listening, appId[%s]", getAppId());
                c0().o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j3, AppBrandOnBackgroundFetchDataEvent appBrandOnBackgroundFetchDataEvent) {
        if (this.W0.indexOfKey(j3) >= 0) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.Runtime", "notifyBackgroundFetchDataThrottling timestamp:%d dispatched, skip", Long.valueOf(j3));
        } else {
            appBrandOnBackgroundFetchDataEvent.setContext(h0()).dispatch();
            this.W0.put(j3, this);
        }
    }
}
