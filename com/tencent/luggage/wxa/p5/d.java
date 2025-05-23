package com.tencent.luggage.wxa.p5;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.xi.a;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.y4.b implements p.e0 {
    public final com.tencent.luggage.wxa.p4.c U;
    public com.tencent.luggage.wxa.y4.a V;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p.h0 f137272a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p5.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6577a implements Runnable {
            public RunnableC6577a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f137272a.proceed();
            }
        }

        public a(p.h0 h0Var) {
            this.f137272a = h0Var;
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public /* synthetic */ void a(List list) {
            s41.a.a(this, list);
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public void a(a.e eVar) {
            d.this.a(new RunnableC6577a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p.h0 f137275a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f137276b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f137277c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ k1 f137278d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                if (bVar.f137276b) {
                    bVar.f137275a.a(false);
                }
                b.this.f137275a.proceed();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p5.d$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6578b implements Runnable {
            public RunnableC6578b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                if (bVar.f137276b && d.this.V != null) {
                    d.this.V.cancel();
                    d.this.V = null;
                }
                b.this.f137275a.cancel();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements Runnable {

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public class a implements DialogInterface.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.y4.a f137283a;

                public a(com.tencent.luggage.wxa.y4.a aVar) {
                    this.f137283a = aVar;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    if (i3 == -1) {
                        com.tencent.luggage.wxa.y4.a aVar = this.f137283a;
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        b bVar = b.this;
                        d.this.a(bVar.f137277c, bVar.f137278d, bVar.f137275a, true);
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.p5.d$b$c$b, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC6579b implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.y4.a f137285a;

                public RunnableC6579b(com.tencent.luggage.wxa.y4.a aVar) {
                    this.f137285a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.luggage.wxa.y4.a aVar = this.f137285a;
                    if (aVar != null) {
                        aVar.h();
                    }
                }
            }

            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.y4.a aVar = d.this.V;
                d.this.V = new com.tencent.luggage.wxa.y4.a(d.this.getContext());
                a aVar2 = new a(aVar);
                d.this.V.setPositiveButton(aVar2);
                d.this.V.setNegativeButton(aVar2);
                d.this.V.a(d.this, new RunnableC6579b(aVar));
            }
        }

        public b(p.h0 h0Var, boolean z16, String str, k1 k1Var) {
            this.f137275a = h0Var;
            this.f137276b = z16;
            this.f137277c = str;
            this.f137278d = k1Var;
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public void a(List list) {
            this.f137275a.a("downloadPackageList", list);
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public void a(a.e eVar) {
            int i3 = c.f137287a[eVar.ordinal()];
            if (i3 == 1) {
                com.tencent.luggage.wxa.xm.b.INSTANCE.a(937, this.f137276b ? 6 : 2);
                d.this.a(new a());
            } else if (i3 == 2) {
                com.tencent.luggage.wxa.xm.b.INSTANCE.a(937, this.f137276b ? 8 : 4);
                d.this.a(new RunnableC6578b());
            } else {
                if (i3 != 3) {
                    return;
                }
                com.tencent.luggage.wxa.xm.b.INSTANCE.a(937, this.f137276b ? 7 : 3);
                d.this.a(new c());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f137287a;

        static {
            int[] iArr = new int[a.e.values().length];
            f137287a = iArr;
            try {
                iArr[a.e.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f137287a[a.e.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f137287a[a.e.FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d(Context context, com.tencent.luggage.wxa.c5.e eVar) {
        super(context, eVar);
        super.setDelegate(this);
        this.U = new com.tencent.luggage.wxa.p4.c(this);
        s();
    }

    @Override // com.tencent.luggage.wxa.kj.p.e0
    public n a(String str, k1 k1Var, p pVar, Callable callable) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.kj.p
    public void h(String str) {
        com.tencent.luggage.wxa.gi.b.c(getAppId(), com.tencent.luggage.wxa.ik.a.E);
        com.tencent.luggage.wxa.gi.b.c(getAppId(), com.tencent.luggage.wxa.ik.a.F);
        com.tencent.luggage.wxa.gi.b.c(getAppId(), com.tencent.luggage.wxa.ik.a.G);
        super.h(str);
        com.tencent.luggage.wxa.gi.b.b(getAppId(), com.tencent.luggage.wxa.ik.a.G);
        com.tencent.luggage.wxa.gi.b.b(getAppId(), com.tencent.luggage.wxa.ik.a.F);
    }

    public final void s() {
        this.U.a(1);
        this.U.a(true);
    }

    @Override // com.tencent.luggage.wxa.kj.p.e0
    public boolean a(String str) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.y4.b, com.tencent.luggage.wxa.kj.p
    public p.m0 b(n nVar, n nVar2) {
        p.m0 b16 = super.b(nVar, nVar2);
        this.U.a(nVar, nVar2);
        return b16;
    }

    public d(Context context, com.tencent.luggage.wxa.c5.e eVar, p.e0 e0Var) {
        super(context, eVar);
        super.setDelegate(e0Var);
        this.U = new com.tencent.luggage.wxa.p4.c(this);
        s();
    }

    @Override // com.tencent.luggage.wxa.y4.b, com.tencent.luggage.wxa.kj.p
    public p.m0 a(n nVar, n nVar2, k1 k1Var, String str, boolean z16) {
        p.m0 a16 = super.a(nVar, nVar2, k1Var, str, z16);
        this.U.b(nVar, nVar2, k1Var);
        return a16;
    }

    @Override // com.tencent.luggage.wxa.y4.b, com.tencent.luggage.wxa.kj.p
    public void a(n nVar, n nVar2, k1 k1Var) {
        super.a(nVar, nVar2, k1Var);
        this.U.a(nVar, nVar2, k1Var);
    }

    @Override // com.tencent.luggage.wxa.kj.p.e0
    public boolean a(v vVar, String str) {
        return vVar instanceof e;
    }

    @Override // com.tencent.luggage.wxa.kj.p.e0
    public v a(p pVar, String str) {
        return new e(com.tencent.luggage.wxa.z5.c.class);
    }

    @Override // com.tencent.luggage.wxa.kj.p.e0
    public boolean a(String str, k1 k1Var, p pVar, p.h0 h0Var) {
        com.tencent.luggage.wxa.xi.a W = getRuntime().W();
        if (!W.b()) {
            W.a(str, new a(h0Var));
            return true;
        }
        a(str, k1Var, h0Var, false);
        return true;
    }

    public final void a(String str, k1 k1Var, p.h0 h0Var, boolean z16) {
        com.tencent.luggage.wxa.xm.b.INSTANCE.a(937, z16 ? 5 : 1);
        getRuntime().W().a(str, new b(h0Var, z16, str, k1Var));
    }
}
