package com.tencent.luggage.wxa.p4;

import android.os.Looper;
import com.tencent.luggage.wxa.e5.h;
import com.tencent.luggage.wxa.e5.l;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final p f137231a;

    /* renamed from: b, reason: collision with root package name */
    public final String f137232b;

    /* renamed from: c, reason: collision with root package name */
    public int f137233c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f137234d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f137235e;

    /* renamed from: f, reason: collision with root package name */
    public int f137236f;

    /* renamed from: g, reason: collision with root package name */
    public final Lazy f137237g;

    /* renamed from: h, reason: collision with root package name */
    public final Lazy f137238h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function1 {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p4.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6573a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f137240a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6573a(c cVar) {
                super(0);
                this.f137240a = cVar;
            }

            public final void a() {
                this.f137240a.b().a(this.f137240a.a(), this.f137240a.a());
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f137241a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(c cVar) {
                super(0);
                this.f137241a = cVar;
            }

            public final void a() {
                this.f137241a.b().f();
                try {
                    w.d("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", "[wxa_reload]onSuspend appId[" + this.f137241a.f137232b + "] try pause all pages's rendering");
                    Iterator q16 = this.f137241a.f137231a.q();
                    Intrinsics.checkNotNullExpressionValue(q16, "pageContainer.stackIterator()");
                    c cVar = this.f137241a;
                    while (q16.hasNext()) {
                        n page = (n) q16.next();
                        Intrinsics.checkNotNullExpressionValue(page, "page");
                        cVar.a(page);
                    }
                } catch (Throwable th5) {
                    w.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th5, "[wxa_reload]onSuspend appId[" + this.f137241a.f137232b + ']', new Object[0]);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p4.c$a$c, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6574c extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f137242a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6574c(c cVar) {
                super(0);
                this.f137242a = cVar;
            }

            public final void a() {
                this.f137242a.b().f();
                try {
                    w.d("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", "[wxa_reload]onForeground appId[" + this.f137242a.f137232b + "] try restore top[" + this.f137242a.c() + "] pages's rendering");
                    Iterator q16 = this.f137242a.f137231a.q();
                    Intrinsics.checkNotNullExpressionValue(q16, "pageContainer.stackIterator()");
                    c cVar = this.f137242a;
                    int i3 = 0;
                    while (q16.hasNext()) {
                        n page = (n) q16.next();
                        i3++;
                        if (i3 <= cVar.c()) {
                            Intrinsics.checkNotNullExpressionValue(page, "page");
                            cVar.b(page);
                        }
                    }
                } catch (Throwable th5) {
                    w.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th5, "[wxa_reload]onForeground appId[" + this.f137242a.f137232b + ']', new Object[0]);
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
        public static final class d extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f137243a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(c cVar) {
                super(0);
                this.f137243a = cVar;
            }

            public final void a() {
                this.f137243a.b().f();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public a() {
            super(1);
        }

        public final void a(h lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "$this$lifecycle");
            lifecycle.a(new C6573a(c.this));
            lifecycle.d(new b(c.this));
            lifecycle.c(new C6574c(c.this));
            lifecycle.b(new d(c.this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf((c.this.f137231a.getRuntime().j0().f125964j * 1000) + 100);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.p4.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6575c extends Lambda implements Function0 {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p4.c$c$a */
        /* loaded from: classes8.dex */
        public static final class a implements e0.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f137246a;

            public a(c cVar) {
                this.f137246a = cVar;
            }

            @Override // com.tencent.luggage.wxa.tn.e0.a
            public final boolean a() {
                try {
                    w.d("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", "[wxa_reload]onBackground appId[" + this.f137246a.f137232b + "] try pause all pages's rendering, delay[" + this.f137246a.a() + "] switch[" + this.f137246a.e() + ']');
                    if (this.f137246a.e()) {
                        Iterator q16 = this.f137246a.f137231a.q();
                        Intrinsics.checkNotNullExpressionValue(q16, "pageContainer.stackIterator()");
                        c cVar = this.f137246a;
                        int i3 = 0;
                        while (q16.hasNext()) {
                            n page = (n) q16.next();
                            i3++;
                            if (i3 > cVar.d()) {
                                Intrinsics.checkNotNullExpressionValue(page, "page");
                                cVar.a(page);
                            }
                        }
                    }
                } catch (Throwable th5) {
                    w.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th5, "[wxa_reload]onBackground appId[" + this.f137246a.f137232b + ']', new Object[0]);
                }
                return false;
            }
        }

        public C6575c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e0 invoke() {
            return new e0(Looper.getMainLooper(), (e0.a) new a(c.this), false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = c.this;
            k1 k1Var = k1.NAVIGATE_BACK;
            cVar.b(k1Var);
            c.this.a(k1Var);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1 f137249b;

        public e(k1 k1Var) {
            this.f137249b = k1Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.a(this.f137249b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function0 {
        public f() {
            super(0);
        }

        public final void a() {
            Iterator q16 = c.this.f137231a.q();
            Intrinsics.checkNotNullExpressionValue(q16, "pageContainer.stackIterator()");
            c cVar = c.this;
            int i3 = 0;
            while (q16.hasNext()) {
                n page = (n) q16.next();
                int i16 = i3 + 1;
                if (i3 >= cVar.c()) {
                    Intrinsics.checkNotNullExpressionValue(page, "page");
                    cVar.a(page);
                }
                i3 = i16;
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public c(p pageContainer) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(pageContainer, "pageContainer");
        this.f137231a = pageContainer;
        l lVar = l.f124555a;
        g runtime = pageContainer.getRuntime();
        Intrinsics.checkNotNullExpressionValue(runtime, "pageContainer.runtime");
        lVar.a(runtime, new a());
        this.f137232b = pageContainer.getAppId();
        this.f137233c = 2;
        this.f137234d = true;
        this.f137235e = true;
        this.f137236f = 1;
        lazy = LazyKt__LazyJVMKt.lazy(new b());
        this.f137237g = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new C6575c());
        this.f137238h = lazy2;
    }

    public final boolean e() {
        return this.f137235e;
    }

    public final void f() {
        v currentPageView;
        try {
            if (this.f137234d) {
                return;
            }
            n currentPage = this.f137231a.getCurrentPage();
            if (!(currentPage instanceof com.tencent.luggage.wxa.kj.g) || (currentPageView = ((com.tencent.luggage.wxa.kj.g) currentPage).getCurrentPageView()) == null) {
                return;
            }
            Iterator I = ((com.tencent.luggage.wxa.kj.g) currentPage).I();
            Intrinsics.checkNotNullExpressionValue(I, "page.pagesIterator()");
            while (I.hasNext()) {
                v pv5 = (v) I.next();
                if (Intrinsics.areEqual(currentPageView, pv5)) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(pv5, "pv");
                a(pv5);
            }
        } catch (Throwable th5) {
            w.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th5, "[wxa_reload]tryPauseRenderingOfInvisibleTabbarPages appId[" + this.f137232b + "], switch[" + this.f137234d + ']', new Object[0]);
        }
    }

    public final int c() {
        return this.f137233c;
    }

    public final int d() {
        return this.f137236f;
    }

    public final void a(n nVar) {
        com.tencent.luggage.wxa.mj.f fVar;
        com.tencent.luggage.wxa.mj.f fVar2;
        if (nVar instanceof com.tencent.luggage.wxa.kj.g) {
            Iterator I = ((com.tencent.luggage.wxa.kj.g) nVar).I();
            Intrinsics.checkNotNullExpressionValue(I, "this.pagesIterator()");
            while (I.hasNext()) {
                v vVar = (v) I.next();
                if (vVar != null && (fVar2 = (com.tencent.luggage.wxa.mj.f) vVar.f(com.tencent.luggage.wxa.mj.f.class)) != null) {
                    fVar2.v();
                }
            }
            return;
        }
        v currentPageView = nVar.getCurrentPageView();
        if (currentPageView == null || (fVar = (com.tencent.luggage.wxa.mj.f) currentPageView.f(com.tencent.luggage.wxa.mj.f.class)) == null) {
            return;
        }
        fVar.v();
    }

    public final void b(n nVar) {
        com.tencent.luggage.wxa.mj.f fVar;
        com.tencent.luggage.wxa.mj.f fVar2;
        if (nVar instanceof com.tencent.luggage.wxa.kj.g) {
            Iterator I = ((com.tencent.luggage.wxa.kj.g) nVar).I();
            Intrinsics.checkNotNullExpressionValue(I, "this.pagesIterator()");
            while (I.hasNext()) {
                v vVar = (v) I.next();
                if (vVar != null && (fVar2 = (com.tencent.luggage.wxa.mj.f) vVar.f(com.tencent.luggage.wxa.mj.f.class)) != null) {
                    fVar2.t();
                }
            }
            return;
        }
        v currentPageView = nVar.getCurrentPageView();
        if (currentPageView == null || (fVar = (com.tencent.luggage.wxa.mj.f) currentPageView.f(com.tencent.luggage.wxa.mj.f.class)) == null) {
            return;
        }
        fVar.t();
    }

    public final void a(v vVar) {
        com.tencent.luggage.wxa.mj.f fVar = (com.tencent.luggage.wxa.mj.f) vVar.f(com.tencent.luggage.wxa.mj.f.class);
        if (fVar != null) {
            fVar.v();
        }
    }

    public final e0 b() {
        return (e0) this.f137238h.getValue();
    }

    public final void a(int i3) {
        this.f137233c = i3;
    }

    public final void b(n nVar, n in5, k1 type) {
        Intrinsics.checkNotNullParameter(in5, "in");
        Intrinsics.checkNotNullParameter(type, "type");
        b(in5);
    }

    public final void a(boolean z16) {
        this.f137235e = z16;
    }

    public final void b(k1 k1Var) {
        try {
            p pVar = this.f137231a;
            n d16 = pVar.d(pVar.getCurrentPage());
            if (d16 != null) {
                b(d16);
            }
        } catch (Throwable th5) {
            w.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th5, "[wxa_reload]tryRestoreRenderingOfNearestInvisiblePage appId[" + this.f137232b + "] type[" + k1Var + ']', new Object[0]);
        }
    }

    public final long a() {
        return ((Number) this.f137237g.getValue()).longValue();
    }

    public final void a(n nVar, n in5, k1 type) {
        com.tencent.luggage.wxa.mj.f fVar;
        Intrinsics.checkNotNullParameter(in5, "in");
        Intrinsics.checkNotNullParameter(type, "type");
        k1 k1Var = k1.NAVIGATE_TO;
        if (k1Var == type) {
            b(type);
            a(in5, type);
        } else if (k1.SWITCH_TAB == type) {
            f();
        }
        v currentPageView = in5.getCurrentPageView();
        if (currentPageView != null && (fVar = (com.tencent.luggage.wxa.mj.f) currentPageView.f(com.tencent.luggage.wxa.mj.f.class)) != null) {
            fVar.t();
        }
        if (k1.SWITCH_TAB == type || k1Var == type) {
            return;
        }
        this.f137231a.post(new e(type));
    }

    public final void a(n out, n in5) {
        com.tencent.luggage.wxa.mj.f fVar;
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(in5, "in");
        this.f137231a.post(new d());
        v currentPageView = in5.getCurrentPageView();
        if (currentPageView == null || (fVar = (com.tencent.luggage.wxa.mj.f) currentPageView.f(com.tencent.luggage.wxa.mj.f.class)) == null) {
            return;
        }
        fVar.t();
    }

    public final void a(n nVar, k1 k1Var) {
        try {
            if (this.f137231a.getPageCount() <= this.f137233c) {
                return;
            }
            final f fVar = new f();
            nVar.a(new Runnable() { // from class: com.tencent.luggage.wxa.p4.d
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Function0.this.invoke();
                }
            });
        } catch (Throwable th5) {
            w.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th5, "[wxa_reload]tryPauseRenderingOfInvisiblePages appId[" + this.f137232b + "] type[" + k1Var + "] maxKeepPageCount[" + this.f137233c + "] keepInvisbileTabbarPagesActive[" + this.f137234d + ']', new Object[0]);
        }
    }

    public final void a(k1 k1Var) {
        com.tencent.luggage.wxa.q4.a aVar;
        try {
            p pVar = this.f137231a;
            n d16 = pVar.d(pVar.getCurrentPage());
            if (d16 == null || (aVar = (com.tencent.luggage.wxa.q4.a) d16.getCurrentPageView().f(com.tencent.luggage.wxa.q4.a.class)) == null) {
                return;
            }
            w.d("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", "[wxa_reload]tryReloadNearestInvisiblePage appId[" + this.f137232b + "] reload[" + aVar.u() + "] type[" + k1Var + ']');
        } catch (Throwable th5) {
            w.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th5, "[wxa_reload]tryReloadNearestInvisiblePage appId[" + this.f137232b + "] type[" + k1Var + ']', new Object[0]);
        }
    }
}
