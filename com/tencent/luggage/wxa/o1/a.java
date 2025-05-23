package com.tencent.luggage.wxa.o1;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Point;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.fd.n;
import com.tencent.luggage.wxa.i3.s;
import com.tencent.luggage.wxa.i3.u;
import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.i3.y;
import com.tencent.luggage.wxa.ic.u0;
import com.tencent.luggage.wxa.ic.v;
import com.tencent.luggage.wxa.lk.j;
import com.tencent.luggage.wxa.n3.j0;
import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.tn.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.luggage.wxa.xo.h;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.c5.d implements LifecycleOwner {
    public final long J;
    public volatile boolean K;
    public volatile boolean L;
    public volatile boolean M;
    public boolean N;
    public View O;
    public com.tencent.luggage.wxa.c5.b P;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.o1.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6524a implements com.tencent.luggage.wxa.c5.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.d6.b f136047a;

        public C6524a(com.tencent.luggage.wxa.d6.b bVar) {
            this.f136047a = bVar;
        }

        @Override // com.tencent.luggage.wxa.c5.b
        public void a(int i3) {
            close();
        }

        @Override // com.tencent.luggage.wxa.c5.b
        public void close() {
            a.this.a(false, (com.tencent.luggage.wxa.ic.g) null);
            a.this.a(this.f136047a);
        }

        @Override // com.tencent.luggage.wxa.c5.b
        public String getAppId() {
            return this.f136047a.f124086d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.r5.a f136049a;

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.luggage.wxa.bk.e f136050b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.d6.b f136051c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.j4.d f136052d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ g f136053e;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.o1.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6525a implements Runnable {
            public RunnableC6525a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.o1.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6526b implements Runnable {
            public RunnableC6526b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.ic.g f16;
                if (a.this.O != null) {
                    com.tencent.luggage.wxa.ok.a.a(a.this.O);
                    a.this.O = null;
                }
                b bVar = b.this;
                a.super.a(bVar.f136049a, bVar.f136050b);
                if (a.this.M) {
                    a.super.onResume();
                    a.this.M = false;
                } else if (a.this.N && (f16 = a.this.f()) != null && !f16.B0()) {
                    a.super.onResume();
                }
                b bVar2 = b.this;
                a.this.a(bVar2.f136049a, bVar2.f136051c, bVar2.f136050b);
                g gVar = b.this.f136053e;
                if (gVar != null) {
                    gVar.a(true);
                }
            }
        }

        public b(com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.bk.e eVar, g gVar, com.tencent.luggage.wxa.d6.b bVar, com.tencent.luggage.wxa.j4.d dVar2, g gVar2) {
            this.f136051c = bVar;
            this.f136052d = dVar2;
            this.f136053e = gVar2;
            this.f136049a = ((com.tencent.luggage.wxa.p6.d) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.p6.d.class)).a(dVar.b(), bVar, eVar);
            j0.a(dVar2.f125808a, dVar2.f125809b, dVar2.f125810c);
            HashMap hashMap = new HashMap(bVar.f124091i.size());
            Iterator it = bVar.f124091i.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.d6.a aVar = (com.tencent.luggage.wxa.d6.a) it.next();
                hashMap.put(aVar.f124084d, aVar.f124085e);
            }
            this.f136049a.M0 = (String) hashMap.get("clientApplicationId");
            this.f136049a.a(this.f136051c.f124092j);
            com.tencent.luggage.wxa.r5.a aVar2 = this.f136049a;
            com.tencent.luggage.wxa.d6.b bVar2 = this.f136051c;
            aVar2.S0 = bVar2.f124093k;
            aVar2.f130795g0 = bVar2.f124098p;
            aVar2.f130794f0 = bVar2.f124099q;
            aVar2.b(bVar2.f124094l);
            com.tencent.luggage.wxa.r5.a aVar3 = this.f136049a;
            aVar3.T0 = this.f136051c.f124096n;
            com.tencent.luggage.wxa.d6.b bVar3 = this.f136051c;
            aVar3.U0 = new Point(bVar3.f124102t, bVar3.f124103u);
            this.f136049a.W0 = y.f129448a.b();
            com.tencent.luggage.wxa.r5.a aVar4 = this.f136049a;
            com.tencent.luggage.wxa.d6.b bVar4 = this.f136051c;
            aVar4.f130806r0 = bVar4.f124097o;
            aVar4.f130793e0 = bVar4.f124100r;
            aVar4.P0 = bVar4.f124105w;
            aVar4.Q0 = bVar4.f124106x;
            String str = (String) hashMap.get("zoom");
            if (str != null) {
                try {
                    this.f136049a.N0 = Float.parseFloat(str);
                } catch (NumberFormatException unused) {
                    w.f("Luggage.AppBrandRuntimeContainerStandaloneImpl", "zoom cannot be parsed " + str);
                }
            }
            String str2 = (String) hashMap.get("ratio");
            if (str2 != null) {
                try {
                    this.f136049a.O0 = Float.parseFloat(str2);
                } catch (NumberFormatException unused2) {
                    w.f("Luggage.AppBrandRuntimeContainerStandaloneImpl", "ratio cannot be parsed " + str2);
                }
            }
            ((com.tencent.luggage.wxa.p6.d) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.p6.d.class)).a(this.f136049a, this.f136051c, eVar);
            y yVar = y.f129448a;
            y.a(this.f136049a.f125808a, com.tencent.luggage.wxa.s3.f.c(), com.tencent.luggage.wxa.s3.f.b());
            this.f136050b = eVar == null ? a.this.M() : eVar;
        }

        public void a() {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                a.this.runOnUiThread(new RunnableC6525a());
                return;
            }
            if (a.this.K) {
                com.tencent.luggage.wxa.r5.a aVar = this.f136049a;
                w.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "Loader.load() appId:%s, type:%d, container is destroyed, return", aVar.f125808a, Integer.valueOf(aVar.f125811d));
                g gVar = this.f136053e;
                if (gVar != null) {
                    gVar.a(false);
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.e5.g.a("AppBrandRuntimeContainerStandaloneImpl.loadStandaloneImpl", new RunnableC6526b());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f136057a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f136058b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.o1.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6527a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f136060a;

            public RunnableC6527a(Object obj) {
                this.f136060a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object obj = this.f136060a;
                String str = "";
                if (obj instanceof com.tencent.luggage.wxa.j3.b) {
                    int a16 = ((com.tencent.luggage.wxa.j3.b) obj).a();
                    if (a16 != 1) {
                        if (a16 != 2) {
                            if (a16 != 3) {
                                if (a16 == 4) {
                                    str = a.this.O().getResources().getString(R.string.yxs);
                                }
                            } else {
                                str = a.this.O().getResources().getString(R.string.yxt);
                            }
                        } else {
                            str = a.this.O().getResources().getString(R.string.yzu);
                        }
                    } else {
                        str = a.this.O().getResources().getString(R.string.yxq);
                    }
                    if (!w0.c(str)) {
                        com.tencent.luggage.wxa.y9.a.makeText(a.this.O(), str, 0).show();
                        w.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "DemoInfoError: errMsg:%s hasLogin:%b hasActivateDevice:%b", str, Boolean.valueOf(l.f136139a.c()), Boolean.valueOf(com.tencent.luggage.wxa.s3.f.f140021a.g()));
                    }
                } else if (obj instanceof com.tencent.luggage.wxa.j3.a) {
                    switch (((com.tencent.luggage.wxa.j3.a) obj).a()) {
                        case 1:
                            str = a.this.O().getResources().getString(R.string.yzp);
                            break;
                        case 2:
                            str = a.this.O().getResources().getString(R.string.yzr);
                            break;
                        case 3:
                            str = a.this.O().getResources().getString(R.string.yzo);
                            break;
                        case 4:
                            str = a.this.O().getResources().getString(R.string.yzs);
                            break;
                        case 5:
                            str = a.this.O().getResources().getString(R.string.yzq);
                            break;
                        case 6:
                        case 7:
                            str = a.this.O().getResources().getString(R.string.yzt);
                            break;
                    }
                    if (!w0.c(str)) {
                        com.tencent.luggage.wxa.y9.a.makeText(a.this.O(), str, 0).show();
                        w.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "DebugPkgInfoError: errMsg:%s hasLogin:%b hasActivateDevice:%b", str, Boolean.valueOf(l.f136139a.c()), Boolean.valueOf(com.tencent.luggage.wxa.s3.f.f140021a.g()));
                    }
                } else if (obj instanceof String) {
                    String str2 = (String) obj;
                    w.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "Error Loading WxaAttrs, errMsg:%s hasLogin:%b hasActivateDevice:%b", str2, Boolean.valueOf(l.f136139a.c()), Boolean.valueOf(com.tencent.luggage.wxa.s3.f.f140021a.i()));
                    com.tencent.luggage.wxa.y9.a.makeText(a.this.O(), "Error Loading WxaAttrs:" + str2, 0).show();
                } else if (obj instanceof com.tencent.luggage.wxa.bj.a) {
                    w.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "CGI Error Loading WxaAttrs, hasLogin:%b hasActivateDevice:%b, cgi %s", Boolean.valueOf(l.f136139a.c()), Boolean.valueOf(com.tencent.luggage.wxa.s3.f.f140021a.g()), this.f136060a.toString());
                    com.tencent.luggage.wxa.j3.c.f130777a.a(a.this.O(), (com.tencent.luggage.wxa.bj.a) this.f136060a);
                } else {
                    w.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "Error Loading WxaAttrs, hasLogin:%b hasActivateDevice:%b", Boolean.valueOf(l.f136139a.c()), Boolean.valueOf(com.tencent.luggage.wxa.s3.f.f140021a.i()));
                    com.tencent.luggage.wxa.y9.a.makeText(a.this.O(), "Error Loading WxaAttrs", 0).show();
                }
                if (!a.this.d()) {
                    a.this.a(true, (com.tencent.luggage.wxa.ic.g) null);
                }
            }
        }

        public c(String str, u uVar) {
            this.f136057a = str;
            this.f136058b = uVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public void a(Object obj) {
            a.this.o(this.f136057a);
            a.this.L = false;
            x.f129431a.a(this.f136058b.f129361c, x.d.FAIL, obj);
            a.this.runOnUiThread(new RunnableC6527a(obj));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f136062a;

        public d(String str) {
            this.f136062a = str;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public void a(Void r26) {
            a.this.o(this.f136062a);
            a.this.L = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ki.a f136064b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f136065c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.d6.b f136066d;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.o1.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6528a implements g {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f136068a;

            public C6528a(com.tencent.luggage.wxa.xo.b bVar) {
                this.f136068a = bVar;
            }

            @Override // com.tencent.luggage.wxa.o1.a.g
            public void a(boolean z16) {
                if (z16) {
                    this.f136068a.a(new Object[0]);
                } else {
                    this.f136068a.a("loadStandaloneImpl fail");
                }
            }
        }

        public e(com.tencent.luggage.wxa.ki.a aVar, String str, com.tencent.luggage.wxa.d6.b bVar) {
            this.f136064b = aVar;
            this.f136065c = str;
            this.f136066d = bVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(com.tencent.luggage.wxa.j4.d dVar) {
            if (dVar == null) {
                h.a().a((Object) null);
                com.tencent.luggage.wxa.ki.a aVar = this.f136064b;
                w.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "WxaLaunchPreconditionProcess get NULL InitConfig, with params(appId:%s versionType:%d)", aVar.f132018b, Integer.valueOf(aVar.f132022d));
                return null;
            }
            a.this.o(this.f136065c);
            this.f136064b.a(dVar);
            dVar.f125813f = com.tencent.luggage.wxa.ki.a.a(this.f136064b.f132026f);
            if (StringUtils.isEmpty(dVar.j())) {
                dVar.p();
            }
            com.tencent.luggage.wxa.xo.b b16 = h.b();
            j.c(this.f136066d.f124086d, "public:prepare", "loadStandaloneImpl");
            a.this.a(dVar, this.f136066d, this.f136064b.f132032i, new C6528a(b16));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.d6.b f136070a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.o1.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6529a implements Function0 {
            public C6529a() {
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke() {
                com.tencent.luggage.wxa.ok.a.a(a.this.O);
                if (a.this.f() == null) {
                    a.this.a(false, (com.tencent.luggage.wxa.ic.g) null);
                }
                f fVar = f.this;
                a.this.a(fVar.f136070a);
                return null;
            }
        }

        public f(com.tencent.luggage.wxa.d6.b bVar) {
            this.f136070a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.O != null) {
                com.tencent.luggage.wxa.ok.a.a(a.this.O);
            }
            a aVar = a.this;
            aVar.O = aVar.N();
            if (a.this.O == null) {
                return;
            }
            if (a.this.O instanceof com.tencent.luggage.wxa.ok.l) {
                ((com.tencent.luggage.wxa.ok.l) a.this.O).a(new C6529a());
            }
            if (a.this.O.getParent() != a.this.v()) {
                if (a.this.O.getParent() != null) {
                    ((ViewGroup) a.this.O.getParent()).removeView(a.this.O);
                }
                a.this.v().addView(a.this.O, new ViewGroup.LayoutParams(-1, -1));
            }
            a.this.v().bringChildToFront(a.this.O);
            a.this.O.setVisibility(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface g {
        void a(boolean z16);
    }

    public a(com.tencent.luggage.wxa.kk.a aVar, Class<? extends com.tencent.luggage.wxa.c5.e> cls) {
        super(aVar, cls);
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        if (!(aVar.getContext() instanceof com.tencent.luggage.wxa.f6.j)) {
            a(com.tencent.luggage.wxa.f6.j.a(aVar.a()));
        }
        this.J = w0.c();
    }

    @Override // com.tencent.luggage.wxa.c5.d
    public int J() {
        int i3;
        int a16 = a();
        if (this.P != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return a16 + i3;
    }

    public void L() {
        Iterator it = w().iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.c5.e eVar = (com.tencent.luggage.wxa.c5.e) it.next();
            if (eVar instanceof com.tencent.luggage.wxa.p5.f) {
                ((com.tencent.luggage.wxa.p5.f) eVar).g2();
            }
        }
    }

    public com.tencent.luggage.wxa.bk.e M() {
        com.tencent.luggage.wxa.bk.e eVar = new com.tencent.luggage.wxa.bk.e();
        eVar.f122984c = 1168;
        return eVar;
    }

    public View N() {
        return new com.tencent.luggage.wxa.f6.f(this);
    }

    public final Context O() {
        com.tencent.luggage.wxa.kk.a x16 = x();
        if (x16 != null) {
            return x16.getContext().getApplicationContext();
        }
        return z.c();
    }

    public void a(com.tencent.luggage.wxa.d6.b bVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl, com.tencent.luggage.wxa.wj.c
    public Context cloneContext() {
        return com.tencent.luggage.wxa.f6.j.a(j());
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return ((AppCompatActivity) x().a()).getLifecycle();
    }

    public void o(String str) {
        if (this.P != null) {
            w.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "end fakeLoading " + this.P.getAppId() + " context " + getContext().hashCode() + " reason " + str);
            com.tencent.luggage.wxa.c5.c.f123305a.b(this.P);
            this.P = null;
        }
    }

    @Override // com.tencent.luggage.wxa.ic.j
    public void onPause() {
        this.N = false;
        this.M = false;
        super.onPause();
    }

    @Override // com.tencent.luggage.wxa.ic.j
    public void onResume() {
        this.N = true;
        if (this.L) {
            w.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "onResume, skip by mPerformingLoadNew");
            this.M = true;
        } else {
            super.onResume();
        }
    }

    @Override // com.tencent.luggage.wxa.c5.d, com.tencent.luggage.wxa.ic.j
    public void t() {
        this.K = true;
        super.t();
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(z.c());
        }
    }

    public void a(com.tencent.luggage.wxa.d6.b bVar, String str) {
    }

    @Override // com.tencent.luggage.wxa.c5.d, com.tencent.luggage.wxa.ic.w
    public boolean d() {
        if (this.L) {
            w.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "closeIfNoActiveRuntimes, skip by mPerformingLoadNew");
            return false;
        }
        return super.d();
    }

    public void a(com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.d6.b bVar, com.tencent.luggage.wxa.bk.e eVar) {
    }

    public boolean a(com.tencent.luggage.wxa.p5.f fVar) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.c5.d, com.tencent.luggage.wxa.ic.j
    /* renamed from: b */
    public com.tencent.luggage.wxa.c5.e a(i iVar) {
        Point t16;
        if (iVar instanceof com.tencent.luggage.wxa.x2.d) {
            return new com.tencent.luggage.wxa.x2.f(this);
        }
        com.tencent.luggage.wxa.p5.f a16 = u0.a.a(iVar);
        if (a16 != null && !a16.t0() && !a16.w0()) {
            if ((a16.n0() instanceof com.tencent.luggage.wxa.f6.g) && (t16 = ((com.tencent.luggage.wxa.f6.g) a16.n0()).t()) != null && t16.x > 0 && t16.y > 0) {
                return super.a(iVar);
            }
            a16.a((v) this);
            w.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "createRuntime: preRenderRt=" + a16);
            return a16;
        }
        return super.a(iVar);
    }

    public final void a(com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.d6.b bVar, com.tencent.luggage.wxa.bk.e eVar, g gVar) {
        j.c(dVar.f125808a, "public:prepare", "Loader#load");
        new b(dVar, eVar, gVar, bVar, dVar, gVar).a();
    }

    public boolean a(Intent intent, String str) {
        com.tencent.luggage.wxa.bk.e eVar;
        com.tencent.luggage.wxa.j4.d dVar;
        com.tencent.luggage.wxa.p5.f b16;
        if ("onCreate".equals(str)) {
            w.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "|runProfiled| constructed -> performLaunch %dms", Long.valueOf(w0.c() - this.J));
        }
        com.tencent.luggage.wxa.d6.b bVar = new com.tencent.luggage.wxa.d6.b();
        if (com.tencent.luggage.wxa.l3.i.b(bVar, intent, "action") && !TextUtils.isEmpty(bVar.f124086d)) {
            com.tencent.luggage.wxa.ki.a a16 = com.tencent.luggage.wxa.m3.a.a(bVar);
            a16.c(intent.getStringExtra("visitingSessionId"));
            a16.f132034j = (n) intent.getParcelableExtra(com.tencent.luggage.wxa.c8.c.f123370d0);
            try {
                eVar = (com.tencent.luggage.wxa.bk.e) intent.getParcelableExtra("statObject");
            } catch (Exception e16) {
                w.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "performLaunch, reason:%s, get statObject from intent, get exception:%s", str, e16);
                eVar = null;
            }
            com.tencent.luggage.wxa.c5.e eVar2 = (com.tencent.luggage.wxa.c5.e) n(bVar.f124086d);
            if (eVar2 == null) {
                eVar2 = com.tencent.luggage.wxa.c5.g.f123332a.a(bVar.f124086d, bVar.f124090h);
            }
            if (eVar2 == null) {
                eVar2 = u0.a.b(bVar.f124086d, bVar.f124090h);
            }
            if (eVar2 == null && (b16 = com.tencent.luggage.wxa.p6.h.b(bVar.f124086d)) != null && b16.e0() != this && !a(b16)) {
                b16.b(2);
                intent.removeExtra("wxaLaunchInstanceId");
            }
            boolean a17 = r.a(intent, "reloadIfExist", false);
            if (eVar2 != null && eVar2.l0() == bVar.f124090h && !a17) {
                com.tencent.luggage.wxa.j4.d clone = eVar2.S().clone();
                a16.a(clone);
                clone.f125813f = com.tencent.luggage.wxa.ki.a.a(bVar.f124089g);
                if (StringUtils.isEmpty(clone.j())) {
                    clone.p();
                }
                a(clone, bVar, eVar, (g) null);
                eVar2.c(true);
                return true;
            }
            if (intent.hasExtra("fullyPreparedInitConfig") && (dVar = (com.tencent.luggage.wxa.j4.d) intent.getParcelableExtra("fullyPreparedInitConfig")) != null) {
                a(dVar, bVar, eVar, (g) null);
                return true;
            }
            this.L = true;
            if (eVar2 != null) {
                eVar2.c(2);
            }
            String stringExtra = intent.getStringExtra("wxaLaunchInstanceId");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = s.a(a16);
            }
            w.a("Luggage.AppBrandRuntimeContainerStandaloneImpl", "runtimeContainer cost %d", Long.valueOf(w0.c() - this.J));
            com.tencent.luggage.wxa.gi.b.a(bVar.f124086d, com.tencent.luggage.wxa.ik.a.f130625f, "", TimeUnit.NANOSECONDS.toMillis(bVar.f124095m), w0.c());
            if (eVar == null) {
                eVar = M();
            }
            a16.f132032i = eVar;
            C6524a c6524a = new C6524a(bVar);
            this.P = c6524a;
            com.tencent.luggage.wxa.c5.c.f123305a.a(c6524a);
            w.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "begin fakeLoading " + bVar.f124086d + " context " + getContext().hashCode() + " reason " + str);
            a(bVar, stringExtra);
            j.c(bVar.f124086d, "public:prepare", "WxaLaunchPreconditionProcess");
            u uVar = new u(a16, stringExtra);
            com.tencent.luggage.wxa.xo.d c16 = uVar.a().c(new e(a16, str, bVar));
            com.tencent.luggage.wxa.yo.g gVar = com.tencent.luggage.wxa.yo.d.f146045b;
            c16.a(gVar, new d(str)).a(gVar, new c(str, uVar));
            com.tencent.luggage.wxa.e5.g.a("RuntimeContainerProfile| create loading placeholder", new f(bVar));
            return true;
        }
        d();
        com.tencent.luggage.wxa.y9.a.makeText(O(), "Error Action", 0).show();
        return false;
    }

    @Override // com.tencent.luggage.wxa.c5.d, com.tencent.luggage.wxa.ic.j
    public void b(com.tencent.luggage.wxa.c5.e eVar, com.tencent.luggage.wxa.c5.e eVar2, i iVar) {
        if (eVar2.s0()) {
            w.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "loadNew(), runtime(%s) initialized, should be preRendered, use loadExisted() instead", eVar2.getAppId());
            super.a(eVar, eVar2, iVar);
            return;
        }
        if (eVar2.A0()) {
            w.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "loadNew(), runtime(%s) isLaunched, should be preRendered, use loadExisted() instead", eVar2.getAppId());
            super.a(eVar, eVar2, iVar);
            return;
        }
        if (!d41.a.a()) {
            if (eVar != null && com.tencent.luggage.wxa.o1.c.a(eVar, iVar)) {
                w.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "loadNew(), loadNewRuntimeUglyMaybe return true for %s -> %s", eVar.getAppId(), iVar.f125808a);
                return;
            } else if (((com.tencent.luggage.wxa.j4.d) iVar).l()) {
                com.tencent.luggage.wxa.p6.h.a(eVar2);
            }
        }
        super.b(eVar, eVar2, iVar);
    }
}
