package com.tencent.luggage.wxa.c5;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.fd.i0;
import com.tencent.luggage.wxa.fd.j0;
import com.tencent.luggage.wxa.ic.j;
import com.tencent.luggage.wxa.ic.w;
import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.ok.o;
import com.tencent.luggage.wxa.ol.q;
import com.tencent.luggage.wxa.wj.e;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends j implements w {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.c5.e f123310a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.j4.d f123311b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.bk.e f123312c;

        public a(com.tencent.luggage.wxa.c5.e eVar, com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.bk.e eVar2) {
            this.f123310a = eVar;
            this.f123311b = dVar;
            this.f123312c = eVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.a(d.this.j());
            if (this.f123310a == null) {
                d.this.m(this.f123311b.f125808a);
            }
            com.tencent.luggage.wxa.c5.e eVar = (com.tencent.luggage.wxa.c5.e) d.this.n(this.f123311b.f125808a);
            this.f123311b.a(this.f123312c);
            if (eVar == null) {
                com.tencent.luggage.wxa.j4.d dVar = this.f123311b;
                dVar.f125820m = com.tencent.luggage.wxa.lk.j.b(dVar.f125808a, "public:prepare", "\u5c0f\u7a0b\u5e8f\u73af\u5883\u521d\u59cb\u5316");
                com.tencent.luggage.wxa.lk.j.a(this.f123311b.f125808a, "internal:prepare", "createRuntime");
                eVar = d.this.a((i) this.f123311b);
                com.tencent.luggage.wxa.lk.j.c(this.f123311b.f125808a);
                d.this.c(eVar);
                com.tencent.luggage.wxa.lk.j.a(this.f123311b.f125808a, "internal:prepare", "loadNew");
                d.this.b(this.f123310a, eVar, (i) this.f123311b);
                com.tencent.luggage.wxa.lk.j.c(this.f123311b.f125808a);
            } else {
                com.tencent.luggage.wxa.c5.e eVar2 = this.f123310a;
                if (eVar2 == eVar) {
                    d.this.a((com.tencent.luggage.wxa.c5.e) null, eVar, (i) this.f123311b);
                    d.this.onResume();
                } else {
                    d.this.a(eVar2, eVar, (i) this.f123311b);
                }
            }
            if (!eVar.r1() && d.this.b((com.tencent.luggage.wxa.ic.g) eVar)) {
                if (eVar.d0() != null) {
                    eVar.d(true);
                } else {
                    eVar.d(false);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f123314a;

        public b(String str) {
            this.f123314a = str;
        }

        @Override // com.tencent.luggage.wxa.wj.e.a
        public void a(e.b bVar, boolean z16) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithSplashAd, onOrientationChanged, appId[%s] orientation[%s] success[%b]", this.f123314a, bVar, Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f123316a;

        public c(String str) {
            this.f123316a = str;
        }

        @Override // com.tencent.luggage.wxa.wj.e.a
        public void a(e.b bVar, boolean z16) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithoutAd, onOrientationChanged, appId[%s] orientation[%s] success[%b]", this.f123316a, bVar, Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.c5.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6096d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f123318a = new AtomicBoolean(false);

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f123319b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f123320c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Runnable f123321d;

        public RunnableC6096d(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.ic.g gVar2, Runnable runnable) {
            this.f123319b = gVar;
            this.f123320c = gVar2;
            this.f123321d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f123318a.getAndSet(true)) {
                d.super.a(this.f123319b, this.f123320c, this.f123321d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f123323a = new AtomicBoolean(false);

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.c5.e f123324b;

        public e(com.tencent.luggage.wxa.c5.e eVar) {
            this.f123324b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f123323a.getAndSet(true)) {
                return;
            }
            this.f123324b.T1();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f123326a = new AtomicBoolean(false);

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.c5.e f123327b;

        public f(com.tencent.luggage.wxa.c5.e eVar) {
            this.f123327b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f123326a.getAndSet(true)) {
                return;
            }
            this.f123327b.T1();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum g {
        Finish,
        OnDestroy
    }

    public d(com.tencent.luggage.wxa.kk.a aVar, Class<? extends com.tencent.luggage.wxa.c5.e> cls) {
        super(aVar, cls);
    }

    @Override // com.tencent.luggage.wxa.ic.j
    public void C() {
        if (d()) {
            return;
        }
        super.C();
    }

    public void H() {
        Iterator G = G();
        while (G.hasNext()) {
            new com.tencent.luggage.wxa.b5.e((com.tencent.luggage.wxa.c5.e) G.next()).b();
        }
    }

    /* renamed from: I */
    public boolean getEnableStashPersistentRuntime() {
        return true;
    }

    public int J() {
        return a();
    }

    public void K() {
        if (a() == 1) {
            ((com.tencent.luggage.wxa.c5.e) f()).T1();
        }
    }

    public boolean b(com.tencent.luggage.wxa.c5.e eVar) {
        return false;
    }

    public final void c(com.tencent.luggage.wxa.c5.e eVar) {
        if (eVar == null || eVar.S() == null || b(eVar)) {
            return;
        }
        if (eVar.V()) {
            a(eVar.S());
        } else {
            b(eVar.S());
        }
    }

    @Override // com.tencent.luggage.wxa.ic.w
    public boolean d() {
        if (J() > 0) {
            return false;
        }
        a(false);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ic.j
    public void t() {
        super.t();
        if (getEnableStashPersistentRuntime()) {
            com.tencent.luggage.wxa.c5.g.f123332a.a();
        }
    }

    public final void b(com.tencent.luggage.wxa.j4.d dVar) {
        if (TextUtils.isEmpty(dVar.f125812e) || !dVar.l()) {
            return;
        }
        com.tencent.luggage.wxa.xj.d orientationHandler = h().getOrientationHandler();
        if (orientationHandler == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithoutAd appId[%s] orientation[%s], NULL orientationHandler", dVar.f125808a, dVar.f125812e);
            return;
        }
        String str = dVar.f125808a;
        com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithoutAd, appId:%s, config.Orientation:%s", str, dVar.f125812e);
        orientationHandler.a(e.b.a(dVar), new c(str));
    }

    public void a(com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.bk.e eVar) {
        a((com.tencent.luggage.wxa.c5.e) null, dVar, eVar);
    }

    public void a(com.tencent.luggage.wxa.c5.e eVar, com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.bk.e eVar2) {
        if (dVar == null || eVar2 == null) {
            return;
        }
        j().runOnUiThread(new a(eVar, dVar, eVar2));
    }

    public final void a(com.tencent.luggage.wxa.j4.d dVar) {
        Activity a16 = x().a();
        if (a16 == null || a16.isFinishing()) {
            return;
        }
        com.tencent.luggage.wxa.xj.d orientationHandler = h().getOrientationHandler();
        if (orientationHandler == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithSplashAd, appId:%s, orientation:%s, NULL orientationHandler", dVar.f125808a, dVar.f125812e);
            return;
        }
        String str = dVar.f125808a;
        com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithSplashAd, appId:%s, config.Orientation:%s", str, dVar.f125812e);
        orientationHandler.a(e.b.PORTRAIT, new b(str));
    }

    @Override // com.tencent.luggage.wxa.ic.j
    public void b(com.tencent.luggage.wxa.c5.e eVar, com.tencent.luggage.wxa.c5.e eVar2, i iVar) {
        super.b((com.tencent.luggage.wxa.ic.g) eVar, (com.tencent.luggage.wxa.ic.g) eVar2, iVar);
        if (eVar != null) {
            ((o) com.tencent.luggage.wxa.h1.e.a(o.class)).a(eVar2, new f(eVar2), eVar, null);
        }
    }

    @Override // com.tencent.luggage.wxa.ic.j
    /* renamed from: b */
    public com.tencent.luggage.wxa.c5.e a(i iVar) {
        com.tencent.luggage.wxa.c5.e a16;
        return (!getEnableStashPersistentRuntime() || (a16 = com.tencent.luggage.wxa.c5.g.f123332a.a((com.tencent.luggage.wxa.j4.d) iVar, this)) == null) ? (com.tencent.luggage.wxa.c5.e) super.a(iVar) : a16;
    }

    public void a(boolean z16) {
        a(z16, (com.tencent.luggage.wxa.ic.g) null);
    }

    public void a(boolean z16, com.tencent.luggage.wxa.ic.g gVar) {
        a(z16, gVar, (Runnable) null);
    }

    public void a(boolean z16, com.tencent.luggage.wxa.ic.g gVar, Runnable runnable) {
        Activity j3 = j();
        if (j3 == null || j3.isFinishing()) {
            return;
        }
        boolean runInStandaloneTask = x().runInStandaloneTask();
        int a16 = a();
        com.tencent.luggage.wxa.j4.d S = a16 > 0 ? ((com.tencent.luggage.wxa.c5.e) f()).S() : null;
        if (runInStandaloneTask && z16) {
            j3.moveTaskToBack(true);
        } else {
            j3.finish();
        }
        if (a16 <= 0) {
            j3.overridePendingTransition(0, 0);
        } else {
            ((o) com.tencent.luggage.wxa.h1.e.a(o.class)).b(j3, S);
        }
    }

    @Override // com.tencent.luggage.wxa.ic.j
    public void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.ic.g gVar2, Runnable runnable) {
        Object[] objArr = new Object[6];
        objArr[0] = gVar == null ? "null" : gVar.getAppId();
        objArr[1] = gVar2.getAppId();
        objArr[2] = Boolean.valueOf(gVar2.w0());
        objArr[3] = Boolean.valueOf(gVar2.m());
        objArr[4] = Boolean.valueOf(q());
        objArr[5] = Integer.valueOf(J());
        com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "onRuntimeClose entered, in.appId[%s], out.appId[%s], out.isFinishing[%b], out.canDoCloseAnimation[%b], mIsActivityPaused[%b], stackSize[%d]", objArr);
        RunnableC6096d runnableC6096d = new RunnableC6096d(gVar, gVar2, runnable);
        if (q()) {
            gVar2.e(false);
        }
        if (!gVar2.w0()) {
            if (J() > 1) {
                if (gVar2.m()) {
                    ((o) com.tencent.luggage.wxa.h1.e.a(o.class)).b(gVar, null, gVar2, runnableC6096d);
                    return;
                } else {
                    runnableC6096d.run();
                    return;
                }
            }
            a(true);
            return;
        }
        if (!b(gVar2)) {
            runnableC6096d.run();
            return;
        }
        if (J() > 1) {
            if (gVar2.m()) {
                ((o) com.tencent.luggage.wxa.h1.e.a(o.class)).b(gVar, null, gVar2, runnableC6096d);
                return;
            } else {
                runnableC6096d.run();
                return;
            }
        }
        a(false);
    }

    @Override // com.tencent.luggage.wxa.ic.j
    public void a(com.tencent.luggage.wxa.c5.e eVar, com.tencent.luggage.wxa.c5.e eVar2, i iVar) {
        super.a((com.tencent.luggage.wxa.ic.g) eVar, (com.tencent.luggage.wxa.ic.g) eVar2, iVar);
        if (eVar != null) {
            ((o) com.tencent.luggage.wxa.h1.e.a(o.class)).a(eVar2, new e(eVar2), eVar, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008c A[Catch: OutOfMemoryError -> 0x00d2, NullPointerException | OutOfMemoryError -> 0x00d4, TryCatch #2 {NullPointerException | OutOfMemoryError -> 0x00d4, blocks: (B:25:0x0042, B:27:0x004e, B:29:0x005a, B:35:0x0073, B:37:0x0079, B:39:0x008c, B:40:0x009b), top: B:24:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(g gVar) {
        boolean z16;
        Bitmap w16;
        if (getEnableStashPersistentRuntime()) {
            com.tencent.luggage.wxa.c5.e eVar = (com.tencent.luggage.wxa.c5.e) f();
            boolean r16 = r();
            Iterator F = F();
            while (F.hasNext()) {
                com.tencent.luggage.wxa.c5.e eVar2 = (com.tencent.luggage.wxa.c5.e) F.next();
                if (a(eVar2) && eVar2.s0() && !eVar2.w0() && !eVar2.t0()) {
                    if (gVar == g.Finish && eVar2 == eVar) {
                        try {
                            if (i0.DISABLED != eVar2.S().s() && j0.TRANSPARENT != eVar2.S().t()) {
                                n currentPage = eVar2.Y().getCurrentPage();
                                Objects.requireNonNull(currentPage);
                                if (!currentPage.q() && !r16) {
                                    z16 = false;
                                    if (!z16 && (w16 = eVar2.w1()) != null) {
                                        FrameLayout frameLayout = new FrameLayout(getContext());
                                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(eVar2.K().getWidth(), eVar2.K().getHeight(), eVar2.K().getLayoutParams() == null ? ((FrameLayout.LayoutParams) eVar2.K().getLayoutParams()).gravity : 81);
                                        frameLayout.setBackground(new BitmapDrawable(getContext().getResources(), w16));
                                        frameLayout.setWillNotDraw(false);
                                        v().addView(frameLayout, layoutParams);
                                        v().bringChildToFront(frameLayout);
                                    }
                                }
                            }
                            z16 = true;
                            if (!z16) {
                                FrameLayout frameLayout2 = new FrameLayout(getContext());
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(eVar2.K().getWidth(), eVar2.K().getHeight(), eVar2.K().getLayoutParams() == null ? ((FrameLayout.LayoutParams) eVar2.K().getLayoutParams()).gravity : 81);
                                frameLayout2.setBackground(new BitmapDrawable(getContext().getResources(), w16));
                                frameLayout2.setWillNotDraw(false);
                                v().addView(frameLayout2, layoutParams2);
                                v().bringChildToFront(frameLayout2);
                            }
                        } catch (NullPointerException | OutOfMemoryError e16) {
                            com.tencent.luggage.wxa.tn.w.a("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", e16, "stashPersistentRuntimesWhenActivityMayDestroy", new Object[0]);
                        }
                    }
                    if (eVar2.B0()) {
                        f(eVar2);
                    }
                    com.tencent.luggage.wxa.il.g K = eVar2.K();
                    if (K.getParent() instanceof ViewGroup) {
                        ((ViewGroup) K.getParent()).removeView(K);
                    }
                    k(eVar2);
                    com.tencent.luggage.wxa.c5.g.f123332a.c(eVar2);
                }
            }
        }
    }

    public boolean a(com.tencent.luggage.wxa.c5.e eVar) {
        return getEnableStashPersistentRuntime() && com.tencent.luggage.wxa.c5.g.f123332a.a(eVar);
    }
}
