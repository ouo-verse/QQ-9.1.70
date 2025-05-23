package com.tencent.luggage.wxa.ok;

import android.content.Context;
import com.tencent.luggage.wxa.kj.h1;
import com.tencent.luggage.wxa.kj.i1;
import com.tencent.luggage.wxa.ok.n;
import com.tencent.luggage.wxa.wj.c;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.mobileqq.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r implements n {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f136636a;

    /* renamed from: b, reason: collision with root package name */
    public final Lazy f136637b;

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f136638c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Context invoke() {
            i1 a16 = r.this.f136636a.a(h1.ACTION_BAR);
            if (a16 != null) {
                return a16.a(r.this.f136636a.F(), com.tencent.luggage.wxa.kl.b.class);
            }
            return null;
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
        public final Context invoke() {
            i1 a16 = r.this.f136636a.a(h1.CAPSULE_BAR);
            if (a16 != null) {
                return a16.a(r.this.f136636a.F(), com.tencent.luggage.wxa.lj.d.class);
            }
            return null;
        }
    }

    public r(com.tencent.luggage.wxa.ic.g rt5) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(rt5, "rt");
        this.f136636a = rt5;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new a());
        this.f136637b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new b());
        this.f136638c = lazy2;
    }

    @Override // com.tencent.luggage.wxa.ok.n
    public n.b N() {
        int roundToInt;
        Context c16 = c();
        if (c16 == null) {
            c16 = this.f136636a.F();
        }
        roundToInt = MathKt__MathJVMKt.roundToInt(c16.getResources().getDisplayMetrics().density * 96);
        Context c17 = c();
        if (c17 == null) {
            c17 = this.f136636a.F();
        }
        return new n.b(roundToInt, c17.getResources().getDimensionPixelSize(R.dimen.c1t));
    }

    @Override // com.tencent.luggage.wxa.ok.n
    public n.a W() {
        if (this.f136636a.n0().getOrientationHandler().a() == e.b.PORTRAIT) {
            return new n.a(0, (a(b(), R.dimen.bfj) - a(c(), R.dimen.c1t)) / 2, a(b(), R.dimen.c1f), 0);
        }
        return new n.a(0, (a(b(), R.dimen.bfj) - a(c(), R.dimen.c1t)) / 2, a(b(), R.dimen.c1g), 0);
    }

    public final Context b() {
        return (Context) this.f136637b.getValue();
    }

    public final Context c() {
        return (Context) this.f136638c.getValue();
    }

    @Override // com.tencent.luggage.wxa.ok.n
    public int a(com.tencent.luggage.wxa.ic.l service) {
        c.C6887c statusBar;
        Intrinsics.checkNotNullParameter(service, "service");
        com.tencent.luggage.wxa.wj.c D = service.D();
        if (D == null || (statusBar = D.getStatusBar()) == null || 8 == statusBar.f144268b) {
            return 0;
        }
        return statusBar.f144267a;
    }

    public final int a(Context context, int i3) {
        if (context == null) {
            context = this.f136636a.F();
        }
        return context.getResources().getDimensionPixelSize(i3);
    }
}
