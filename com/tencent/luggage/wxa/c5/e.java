package com.tencent.luggage.wxa.c5;

import android.graphics.Bitmap;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.bf.s0;
import com.tencent.luggage.wxa.fd.h;
import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.fd.n;
import com.tencent.luggage.wxa.h6.o;
import com.tencent.luggage.wxa.ic.c0;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.ic.v;
import com.tencent.luggage.wxa.kj.q1;
import com.tencent.luggage.wxa.kj.t;
import com.tencent.luggage.wxa.lj.k;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xi.g;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.ic.g implements c.InterfaceC6640c, com.tencent.luggage.wxa.ae.c {
    public com.tencent.luggage.wxa.ok.e I0;
    public Boolean J0;
    public volatile com.tencent.luggage.wxa.rj.c K0;
    public volatile com.tencent.luggage.wxa.cj.b L0;
    public final com.tencent.luggage.wxa.cj.a[] M0;
    public final com.tencent.luggage.wxa.ae.d[] N0;
    public final com.tencent.luggage.wxa.ae.d[] O0;
    public boolean P0;
    public boolean Q0;
    public volatile PowerManager.WakeLock R0;

    static {
        com.tencent.mm.plugin.appbrand.appcache.a.a(g.a.f145051a);
    }

    public e(@NonNull v vVar) {
        super(vVar);
        this.J0 = null;
        this.L0 = com.tencent.luggage.wxa.cj.b.f123564d;
        this.M0 = new com.tencent.luggage.wxa.cj.a[]{null};
        this.N0 = new com.tencent.luggage.wxa.ae.d[]{null};
        this.O0 = new com.tencent.luggage.wxa.ae.d[]{null};
        this.R0 = null;
    }

    public com.tencent.luggage.wxa.ok.e A1() {
        return new com.tencent.luggage.wxa.ok.e(L(), this);
    }

    public final com.tencent.luggage.wxa.rj.c B1() {
        return this.K0;
    }

    public final int C1() {
        if (e.a.a(l0())) {
            return 0;
        }
        return S().V;
    }

    @Override // com.tencent.luggage.wxa.ae.c
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public final com.tencent.luggage.wxa.ae.b c() {
        h b16;
        com.tencent.luggage.wxa.ae.d dVar = this.N0[0];
        if (dVar != null) {
            return (com.tencent.luggage.wxa.ae.b) dVar;
        }
        if (t0()) {
            return null;
        }
        synchronized (this.N0) {
            com.tencent.luggage.wxa.ae.d dVar2 = this.N0[0];
            if (dVar2 != null) {
                return (com.tencent.luggage.wxa.ae.b) dVar2;
            }
            com.tencent.luggage.wxa.j4.g j06 = j0();
            if (j06 != null) {
                b16 = j06.f130831g0;
            } else {
                b16 = h.b();
            }
            int i3 = b16.Z;
            com.tencent.luggage.wxa.ae.d[] dVarArr = this.N0;
            com.tencent.luggage.wxa.ae.b bVar = new com.tencent.luggage.wxa.ae.b(i3);
            dVarArr[0] = bVar;
            return bVar;
        }
    }

    @Override // com.tencent.luggage.wxa.ae.c
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public final com.tencent.luggage.wxa.ae.e g() {
        com.tencent.luggage.wxa.ae.d dVar = this.O0[0];
        if (dVar != null) {
            return (com.tencent.luggage.wxa.ae.e) dVar;
        }
        if (t0()) {
            return null;
        }
        synchronized (this.O0) {
            com.tencent.luggage.wxa.ae.d[] dVarArr = this.O0;
            com.tencent.luggage.wxa.ae.d dVar2 = dVarArr[0];
            if (dVar2 != null) {
                return (com.tencent.luggage.wxa.ae.e) dVar2;
            }
            com.tencent.luggage.wxa.ae.e eVar = new com.tencent.luggage.wxa.ae.e(this);
            dVarArr[0] = eVar;
            return eVar;
        }
    }

    public com.tencent.luggage.wxa.cj.a F1() {
        if (this.M0[0] == null) {
            if (!t0() && !w0()) {
                synchronized (this.M0) {
                    com.tencent.luggage.wxa.cj.a[] aVarArr = this.M0;
                    if (aVarArr[0] == null) {
                        com.tencent.luggage.wxa.bj.c cVar = (com.tencent.luggage.wxa.bj.c) f(com.tencent.luggage.wxa.bj.c.class);
                        Objects.requireNonNull(cVar);
                        aVarArr[0] = new com.tencent.luggage.wxa.cj.a(this, cVar);
                    }
                }
            } else {
                return null;
            }
        }
        return this.M0[0];
    }

    public int G1() {
        return L1().f122984c;
    }

    @Override // com.tencent.luggage.wxa.ic.g
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public s0 P() {
        return (s0) super.P();
    }

    @Override // com.tencent.luggage.wxa.ic.g
    /* renamed from: I1, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.j4.d S() {
        return (com.tencent.luggage.wxa.j4.d) super.S();
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void J0() {
        super.J0();
        com.tencent.luggage.wxa.wd.a.a();
        com.tencent.luggage.wxa.bj.h.a(S().B0);
        v1();
        P1();
    }

    @Override // com.tencent.luggage.wxa.ic.g
    /* renamed from: J1, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.y4.b Y() {
        return (com.tencent.luggage.wxa.y4.b) super.Y();
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void K0() {
        com.tencent.luggage.wxa.ae.d dVar;
        super.K0();
        U1();
        Y1();
        com.tencent.luggage.wxa.a5.c.f120844a.b(this);
        O1();
        if (B1() != null) {
            B1().a();
        }
        com.tencent.luggage.wxa.tj.b.a(getAppId());
        this.K0 = null;
        com.tencent.luggage.wxa.ae.d[][] dVarArr = {this.N0, this.O0};
        for (int i3 = 0; i3 < 2; i3++) {
            com.tencent.luggage.wxa.ae.d[] dVarArr2 = dVarArr[i3];
            synchronized (dVarArr2) {
                dVar = dVarArr2[0];
                dVarArr2[0] = null;
            }
            if (dVar != null) {
                dVar.a();
            }
        }
        com.tencent.luggage.wxa.cj.a[] aVarArr = this.M0;
        if (aVarArr != null) {
            synchronized (aVarArr) {
                com.tencent.luggage.wxa.cj.a aVar = this.M0[0];
                if (aVar != null) {
                    try {
                        aVar.c();
                        this.M0[0] = null;
                    } catch (Throwable th5) {
                        this.M0[0] = null;
                        throw th5;
                    }
                }
            }
        }
    }

    public com.tencent.luggage.wxa.ok.e K1() {
        return this.I0;
    }

    public com.tencent.luggage.wxa.bk.e L1() {
        return S().i();
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void M0() {
        super.M0();
        this.L0 = S().H0;
    }

    @Override // com.tencent.luggage.wxa.ic.g
    /* renamed from: M1, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.j4.g j0() {
        return (com.tencent.luggage.wxa.j4.g) a(com.tencent.luggage.wxa.j4.g.class, false);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void N0() {
        super.N0();
        if (this.K0 != null) {
            if ((x1() || 4 == S().I) && TextUtils.isEmpty(S().f125813f) && !TextUtils.isEmpty(S().H)) {
                S().f125813f = S().H;
                return;
            }
            return;
        }
        throw new IllegalStateException("Should ensure ApiPermissionController installed before init. Use #setApiPermissionController().");
    }

    public com.tencent.luggage.wxa.cj.b N1() {
        return this.L0;
    }

    public final boolean O1() {
        com.tencent.luggage.wxa.ok.e eVar = this.I0;
        if (eVar != null) {
            if (eVar.getParent() instanceof ViewGroup) {
                this.I0.e();
                ((ViewGroup) this.I0.getParent()).removeView(this.I0);
            }
            this.I0 = null;
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void P0() {
        super.P0();
        com.tencent.luggage.wxa.a5.c.f120844a.a(this);
    }

    public final void P1() {
        com.tencent.luggage.wxa.qc.c c06 = c0();
        if (c06 == null) {
            w.b("Luggage.WXA.AppBrandRuntimeLU", "installOnRunningStateChangedListener, runningStateController is null");
        } else {
            c06.a(this);
        }
    }

    public final boolean Q1() {
        return S().l();
    }

    public boolean R1() {
        Boolean bool = this.J0;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(b(S()));
        this.J0 = valueOf;
        return valueOf.booleanValue();
    }

    public boolean S1() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void T0() {
        super.T0();
        X1();
    }

    public final void U1() {
        PowerManager.WakeLock wakeLock = this.R0;
        this.R0 = null;
        a(wakeLock);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void V0() {
        super.V0();
        B1().c();
    }

    public boolean W1() {
        return false;
    }

    public final boolean X1() {
        if (!com.tencent.luggage.wxa.qj.b.d(this) || this.I0 != null) {
            return false;
        }
        com.tencent.luggage.wxa.qj.b.e(this);
        com.tencent.luggage.wxa.ok.e A1 = A1();
        this.I0 = A1;
        if (A1 != null) {
            K().addView(this.I0);
            this.I0.i();
            return true;
        }
        return true;
    }

    public final void Y1() {
        com.tencent.luggage.wxa.qc.c c06 = c0();
        if (c06 == null) {
            w.b("Luggage.WXA.AppBrandRuntimeLU", "uninstallOnRunningStateChangedListener, runningStateController is null");
        } else {
            c06.b(this);
        }
    }

    public final void a(com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.bk.e eVar) {
        if (dVar == null || eVar == null) {
            return;
        }
        v e06 = e0();
        if (e06 == null) {
            w.b("Luggage.WXA.AppBrandRuntimeLU", "load with self.appId[%s] config[%s] stat[%d], skip by NULL container", getAppId(), dVar.f125808a, Integer.valueOf(eVar.f122984c));
        } else if (e06 instanceof d) {
            ((d) e06).a(this, dVar, eVar);
        } else {
            e06.a(this, dVar);
        }
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void b(Object obj) {
        if (S().f130801m0 != null) {
            try {
                c0.class.cast(obj);
                c0 c0Var = (c0) obj;
                if (c0Var == null) {
                    c0Var = c0.f129713d;
                }
                a("doNotifyReturnData call onNavigateBackToWxAppResultListener", new Object[0]);
                S().f130801m0.a(c0Var);
            } catch (ClassCastException e16) {
                throw new IllegalStateException("Only data as MiniProgramNavigationBackResult acceptable here.", e16);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void d(i iVar) {
        boolean z16;
        if (!s0()) {
            return;
        }
        boolean R1 = R1();
        com.tencent.luggage.wxa.j4.d dVar = (com.tencent.luggage.wxa.j4.d) iVar;
        boolean b16 = b(dVar);
        if ((!R1 && b16) || (R1 && !b16 && c(dVar))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.J0 = null;
            k1();
        }
        if (!t1() && !t0()) {
            if (e.a.b(l0()) && dVar.V != j0().b()) {
                w.f("Luggage.WXA.AppBrandRuntimeLU", String.format(Locale.ENGLISH, "Updated InitConfig.appVersion(%d) != getSysConfig().appVersion(%d), appId:%s", Integer.valueOf(dVar.V), Integer.valueOf(j0().b()), getAppId()));
                k1();
            }
            if (!t1() && e(iVar)) {
                j1();
            }
        }
        super.d(iVar);
        v1();
    }

    public boolean e(i iVar) {
        return !TextUtils.isEmpty(iVar.f125813f);
    }

    public com.tencent.luggage.wxa.fd.b h(boolean z16) {
        String c16 = k0.c(this, "/app-config.json");
        if (w0.c(c16)) {
            Iterator it = j0().f125966l.f151864d.iterator();
            while (it.hasNext()) {
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                if (modulePkgInfo.independent) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(modulePkgInfo.name);
                    String str = "/";
                    if (modulePkgInfo.name.endsWith("/")) {
                        str = "";
                    }
                    sb5.append(str);
                    sb5.append("app-config.json");
                    c16 = k0.c(this, sb5.toString());
                    if (!w0.c(c16)) {
                        break;
                    }
                }
            }
        }
        String c17 = k0.c(this, "/app-config-darkmode.json");
        if (TextUtils.isEmpty(c17)) {
            c17 = "{}";
        }
        com.tencent.luggage.wxa.fd.b a16 = com.tencent.luggage.wxa.fd.b.a(getAppId(), c16, c17, Q1(), z16);
        if (!Q1()) {
            a16.a().f125641a = S().f125812e;
            a16.a().f125642b = true;
        } else if (!a16.m().booleanValue()) {
            a16.a().f125641a = S().X.f125924e;
        }
        return a16;
    }

    public q i() {
        return g(false);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void o() {
        new com.tencent.luggage.wxa.b5.e(this).b();
        super.o();
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public r q() {
        com.tencent.luggage.wxa.bf.a a16;
        if (j0() == null) {
            w.b("Luggage.WXA.AppBrandRuntimeLU", "createFileSystem but get NUL sysConfig, appId:%s", getAppId());
            a16 = new com.tencent.luggage.wxa.bf.a();
        } else {
            a16 = com.tencent.luggage.wxa.fd.f.a(S());
        }
        return new s0(this, a16);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public com.tencent.luggage.wxa.xi.a s() {
        return com.tencent.luggage.wxa.x4.a.a(this);
    }

    public final PowerManager.WakeLock u1() {
        PowerManager.WakeLock newWakeLock = ((PowerManager) F().getSystemService("power")).newWakeLock(1, "wx:appbrand_headless");
        newWakeLock.setReferenceCounted(false);
        if (!newWakeLock.isHeld()) {
            a("acquireWakeLock", new Object[0]);
            newWakeLock.acquire(60000L);
        }
        return newWakeLock;
    }

    public final void v1() {
        PowerManager.WakeLock wakeLock = this.R0;
        if (!x1()) {
            a(wakeLock);
        } else {
            if (wakeLock != null && wakeLock.isHeld()) {
                return;
            }
            this.R0 = u1();
        }
    }

    public Bitmap w1() {
        if (I() != null) {
            I().a();
        }
        if (i0() != null) {
            i0().cancelPendingInputEvents();
        }
        try {
            if (Y() != null) {
                Y().getCurrentPage().getCurrentPageView().W().cancelPendingInputEvents();
            }
        } catch (NullPointerException unused) {
        }
        return q1.a(K());
    }

    public final boolean x1() {
        if (t0() || com.tencent.luggage.wxa.v4.i.HEADLESS != S().G0) {
            return false;
        }
        return true;
    }

    public final boolean y1() {
        if (t0()) {
            return false;
        }
        return S().G0.b();
    }

    public boolean z1() {
        if (1030 == L1().f122984c) {
            return true;
        }
        return false;
    }

    public static boolean c(com.tencent.luggage.wxa.j4.d dVar) {
        int i3 = dVar.i().f122984c;
        return i3 == 1011 || i3 == 1012 || i3 == 1013;
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public com.tencent.luggage.wxa.ya.a e(Class cls) {
        if (com.tencent.luggage.wxa.t4.b.class == cls) {
            return new com.tencent.luggage.wxa.t4.a(com.tencent.luggage.wxa.y8.h.a(S().f130798j0), getAppId());
        }
        return super.e(cls);
    }

    public final q g(boolean z16) {
        q qVar = (q) super.f(q.class);
        if (qVar == null && z16) {
            throw new q.a();
        }
        return qVar;
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void g(int i3) {
        w.d("Luggage.WXA.AppBrandRuntimeLU", "reportCapsuleMutationClick type:%d", Integer.valueOf(i3));
        a(k.a.CLICK.b(), i3, k.b.NONE.b());
    }

    public final void a(com.tencent.luggage.wxa.rj.c cVar) {
        cVar.getClass();
        this.K0 = cVar;
    }

    public e(@NonNull com.tencent.luggage.wxa.wj.c cVar) {
        super(cVar);
        this.J0 = null;
        this.L0 = com.tencent.luggage.wxa.cj.b.f123564d;
        this.M0 = new com.tencent.luggage.wxa.cj.a[]{null};
        this.N0 = new com.tencent.luggage.wxa.ae.d[]{null};
        this.O0 = new com.tencent.luggage.wxa.ae.d[]{null};
        this.R0 = null;
    }

    public void a(q qVar) {
        if (i() == null) {
            qVar.getClass();
            super.a(q.class, qVar);
            return;
        }
        throw new IllegalStateException("Duplicated call!!");
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void b(l lVar) {
        super.b(lVar);
        if (f(q.class) == null) {
            a(q.class, com.tencent.luggage.wxa.mc.c.f134270g);
        }
        a((com.tencent.luggage.wxa.xd.l) new t((q) f(q.class), k0.b(this)));
        a((com.tencent.luggage.wxa.xd.l) new com.tencent.luggage.wxa.j4.f(this));
    }

    public final n a(i iVar, c0 c0Var) {
        n nVar = new n();
        nVar.f125848b = iVar.f125808a;
        nVar.f125847a = 3;
        nVar.f125849c = c0Var == null ? null : c0Var.f129715b.toString();
        nVar.f125850d = c0Var != null ? c0Var.f129716c.toString() : null;
        return nVar;
    }

    public static boolean b(com.tencent.luggage.wxa.j4.d dVar) {
        return dVar.Q && (c(dVar) || a(dVar));
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void a(i iVar, Object obj) {
        try {
            c0.class.cast(obj);
            com.tencent.luggage.wxa.j4.d clone = S().clone();
            clone.N.a(a(iVar, (c0) obj));
            com.tencent.luggage.wxa.bk.e eVar = new com.tencent.luggage.wxa.bk.e();
            eVar.f122984c = 1038;
            if (iVar instanceof com.tencent.luggage.wxa.j4.d) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(iVar.f125808a);
                sb5.append(':');
                com.tencent.luggage.wxa.j4.d dVar = (com.tencent.luggage.wxa.j4.d) iVar;
                sb5.append(dVar.j());
                sb5.append(':');
                sb5.append(dVar.I + 1000);
                eVar.f122985d = sb5.toString();
            }
            clone.S = w0.c();
            clone.f125813f = null;
            clone.p();
            clone.a(eVar);
            a((i) clone);
        } catch (ClassCastException e16) {
            throw new IllegalStateException("Only data as MiniProgramNavigationBackResult acceptable here.", e16);
        }
    }

    public void T1() {
    }

    public void V1() {
    }

    public static boolean a(com.tencent.luggage.wxa.j4.d dVar) {
        return dVar.i().f122984c == 1101;
    }

    @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
    public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
        if (com.tencent.luggage.wxa.qc.b.SUSPEND == bVar) {
            U1();
        }
    }

    public final void a(PowerManager.WakeLock wakeLock) {
        if (wakeLock != null && wakeLock.isHeld()) {
            a("releaseWakeLock", new Object[0]);
            wakeLock.release();
        }
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void a(boolean z16, int i3, boolean z17) {
        w.d("Luggage.WXA.AppBrandRuntimeLU", "reportCapsuleBlinkMutation isStart:%b, status:%d, isCustomStatus:%b", Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
        a((z16 ? k.a.START : k.a.STOP).b(), (z17 ? k.a(i3) : k.b(i3)).b(), (I().f().e() ? k.b.TIPS : k.b.NONE).b());
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void a(boolean z16, int i3) {
        w.d("Luggage.WXA.AppBrandRuntimeLU", "reportCapsuleBlinkMutation isStart:%b type:%d", Boolean.valueOf(z16), Integer.valueOf(i3));
        a((z16 ? k.a.START : k.a.STOP).b(), i3, k.b(I().c().b()).b());
    }

    public final void a(int i3, int i16, int i17) {
        if (i3 > 0 && i16 > 0) {
            ((com.tencent.luggage.wxa.bk.h) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.bk.h.class)).a(i3, i16, i17, getAppId(), Y() != null ? StringUtils.substring(o.b(Y().getCurrentUrl()), 0, 1024) : "", Y() != null ? StringUtils.substring(o.c(Y().getCurrentUrl()), 0, 1024) : "", S() != null ? S().j() : "", G1());
        } else {
            w.d("Luggage.WXA.AppBrandRuntimeLU", "action <= 0 || type <= 0");
        }
    }
}
