package com.tencent.luggage.wxa.lj;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.Layout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.MarginLayoutParamsCompat;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: e, reason: collision with root package name */
    public static final b f133513e = new b(null);

    /* renamed from: f, reason: collision with root package name */
    public static final String f133514f = "CapsuleTipsAnimator";

    /* renamed from: g, reason: collision with root package name */
    public static final Lazy f133515g;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f133516a;

    /* renamed from: b, reason: collision with root package name */
    public int f133517b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f133518c;

    /* renamed from: d, reason: collision with root package name */
    public m f133519d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f133520a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.pb.b invoke() {
            return new com.tencent.luggage.wxa.pb.b(com.tencent.luggage.wxa.lo.o.a(z.c(), 2), com.tencent.luggage.wxa.lo.o.a(z.c(), 20));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return l.f133514f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f133521a;

        public c(m mVar) {
            this.f133521a = mVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 d16 = this.f133521a.d();
            if (d16 != null) {
                d16.invoke();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f133523b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinearLayout f133524c;

        public d(m mVar, LinearLayout linearLayout) {
            this.f133523b = mVar;
            this.f133524c = linearLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            l lVar = l.this;
            TextView c16 = lVar.c(lVar.f133516a);
            if (c16 != null) {
                c16.setText(this.f133523b.g());
            }
            l.this.f();
            if (this.f133523b.a()) {
                this.f133524c.setBackgroundResource(R.drawable.j_a);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationStart(animation);
            l lVar = l.this;
            LinearLayout a16 = lVar.a(lVar.f133516a);
            if (a16 != null) {
                a16.setVisibility(0);
            }
            l.this.f133516a.I().o();
            w.d(l.f133513e.a(), "animateShow-> onAnimationStart ->reportCapsuleTipsMutation");
            l.this.f133516a.a(true, this.f133523b.f());
            com.tencent.luggage.wxa.kj.v J = l.this.f133516a.h0().J();
            Intrinsics.checkNotNullExpressionValue(J, "runtime.service.currentPageView");
            k.a(J);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f133526b;

        public e(m mVar) {
            this.f133526b = mVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            l.this.f133516a.I().n();
            l lVar = l.this;
            LinearLayout a16 = lVar.a(lVar.f133516a);
            if (a16 != null) {
                a16.setVisibility(8);
            }
            l.this.f133516a.I().g().f152355e = false;
            l.this.f();
            w.d(l.f133513e.a(), "animateShow-> onAnimationEnd ->reportCapsuleTipsMutation");
            l.this.f133516a.a(false, this.f133526b.f());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationStart(animation);
            l.this.b(false);
            l.this.b((m) null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f133527a;

        public f(m mVar) {
            this.f133527a = mVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Function0 b16 = this.f133527a.b();
            if (b16 != null) {
                b16.invoke();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Function0 c16 = this.f133527a.c();
            if (c16 != null) {
                c16.invoke();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator f133528a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Animator f133529a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Animator animator) {
                super(0);
                this.f133529a = animator;
            }

            public final void a() {
                this.f133529a.cancel();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Animator animator) {
            super(1);
            this.f133528a = animator;
        }

        public final void a(com.tencent.luggage.wxa.e5.h lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "$this$lifecycle");
            lifecycle.b(new a(this.f133528a));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.e5.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f133530a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Boolean f133531b;

        public h(View view, Boolean bool) {
            this.f133530a = view;
            this.f133531b = bool;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) animatedValue).intValue();
            ViewGroup.LayoutParams layoutParams = this.f133530a.getLayoutParams();
            if (Intrinsics.areEqual(this.f133531b, Boolean.TRUE)) {
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(intValue);
            } else {
                layoutParams.width = intValue;
            }
            this.f133530a.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            l.this.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationStart(animation);
            com.tencent.luggage.wxa.kj.v J = l.this.f133516a.h0().J();
            Intrinsics.checkNotNullExpressionValue(J, "runtime.service.currentPageView");
            k.a(J);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends AnimatorListenerAdapter {
        public j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            l.this.f();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f133520a);
        f133515g = lazy;
    }

    public l(com.tencent.luggage.wxa.ic.g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.f133516a = runtime;
    }

    public final m c() {
        return this.f133519d;
    }

    public final int d() {
        return this.f133516a.I().g().getWidth() - z.j().getDimensionPixelSize(R.dimen.bj8);
    }

    public final boolean e() {
        return this.f133518c;
    }

    public final void f() {
        new q().a(this.f133516a.h0());
    }

    public final void g() {
        LinearLayout a16;
        if (!this.f133516a.I().k() && (a16 = a(this.f133516a)) != null) {
            this.f133516a.I().g().getButtonImage().setAlpha(0.0f);
            ViewGroup.LayoutParams layoutParams = a16.getLayoutParams();
            if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd() == 0) {
                return;
            }
            ValueAnimator a17 = a(a16, d(), 0, Boolean.TRUE);
            if (a17 != null) {
                a17.setDuration(300L);
            } else {
                a17 = null;
            }
            Intrinsics.checkNotNull(a17);
            a17.addListener(new j());
            a(a17).start();
        }
    }

    public final TextView c(com.tencent.luggage.wxa.ic.g gVar) {
        View a16 = gVar.I().a(R.id.s_c);
        if (a16 instanceof TextView) {
            return (TextView) a16;
        }
        return null;
    }

    public final void a(m config) {
        long j3;
        Intrinsics.checkNotNullParameter(config, "config");
        this.f133518c = true;
        this.f133519d = config;
        this.f133516a.I().g().f152355e = true;
        this.f133517b = a(this.f133516a, config.g(), config.h());
        LinearLayout a16 = a(this.f133516a);
        if (a16 == null) {
            return;
        }
        if (config.a()) {
            a16.setOnClickListener(new c(config));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f133516a.I().g().getButtonImage(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(150L);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 0.0f);
        ofFloat2.setDuration(0L);
        if (this.f133516a.I().k() || this.f133516a.I().g().a()) {
            ViewGroup.LayoutParams layoutParams = a16.getLayoutParams();
            if ((layoutParams instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams) : 0) < 1) {
                ofFloat2 = a(a16);
            }
        }
        Animator animator = ofFloat2;
        Animator a17 = a(this, a16, 0, this.f133517b, null, 8, null);
        Intrinsics.checkNotNull(a17);
        a17.addListener(new d(config, a16));
        AnimatorSet animatorSet2 = new AnimatorSet();
        if (config.h()) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(c(this.f133516a), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            j3 = 150;
            ofFloat3.setDuration(150L);
            Unit unit = Unit.INSTANCE;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(b(this.f133516a), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat4.setDuration(150L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
        } else {
            j3 = 150;
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(c(this.f133516a), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat5.setDuration(150L);
            Unit unit2 = Unit.INSTANCE;
            animatorSet2.playTogether(ofFloat5);
        }
        Animator duration = ValueAnimator.ofInt(1).setDuration(config.e());
        AnimatorSet animatorSet3 = new AnimatorSet();
        if (config.h()) {
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(c(this.f133516a), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ofFloat6.setDuration(j3);
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(b(this.f133516a), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ofFloat7.setDuration(j3);
            animatorSet3.playTogether(ofFloat6, ofFloat7);
        } else {
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(c(this.f133516a), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ofFloat8.setDuration(j3);
            animatorSet3.playTogether(ofFloat8);
        }
        Animator a18 = a(this, a16, this.f133517b, 0, null, 8, null);
        Intrinsics.checkNotNull(a18);
        a18.addListener(new e(config));
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.f133516a.I().g().getButtonImage(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat9.setDuration(150L);
        animatorSet.playSequentially(ofFloat, animator, a17, animatorSet2, duration, animatorSet3, a18, ofFloat9);
        Animator a19 = a(animatorSet);
        a19.addListener(new f(config));
        a19.start();
    }

    public final void b(boolean z16) {
        this.f133518c = z16;
    }

    public final void b(m mVar) {
        this.f133519d = mVar;
    }

    public final ImageView b(com.tencent.luggage.wxa.ic.g gVar) {
        View a16 = gVar.I().a(R.id.s_b);
        if (a16 instanceof ImageView) {
            return (ImageView) a16;
        }
        return null;
    }

    public static /* synthetic */ void a(l lVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        lVar.a(z16, z17);
    }

    public final void a(boolean z16, boolean z17) {
        if (this.f133518c) {
            if (z17) {
                a(z16);
            } else {
                g();
            }
        }
    }

    public final void a(boolean z16) {
        List<Animator> list;
        LinearLayout a16 = a(this.f133516a);
        if (a16 != null) {
            ArrayList arrayList = new ArrayList();
            ViewGroup.LayoutParams layoutParams = a16.getLayoutParams();
            if ((layoutParams instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams) : 0) < 1) {
                arrayList.add(a(a16));
            }
            if (!z16) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f133516a.I().g().getButtonImage(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
                ofFloat.setDuration(300L);
                Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(runtime.capsuleB\u2026.apply { duration = 300 }");
                arrayList.add(ofFloat);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            list = CollectionsKt___CollectionsKt.toList(arrayList);
            animatorSet.playSequentially(list);
            a(animatorSet).start();
        }
    }

    public final ValueAnimator a(View view) {
        ValueAnimator a16 = a(view, 0, d(), Boolean.TRUE);
        if (a16 != null) {
            a16.setDuration(300L);
        } else {
            a16 = null;
        }
        Intrinsics.checkNotNull(a16);
        a16.addListener(new i());
        return a16;
    }

    public static /* synthetic */ ValueAnimator a(l lVar, View view, int i3, int i16, Boolean bool, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            bool = Boolean.FALSE;
        }
        return lVar.a(view, i3, i16, bool);
    }

    public final ValueAnimator a(View view, int i3, int i16, Boolean bool) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, i16);
        ofInt.addUpdateListener(new h(view, bool));
        return ofInt;
    }

    public final int a(com.tencent.luggage.wxa.ic.g gVar, CharSequence charSequence, boolean z16) {
        float desiredWidth;
        LinearLayout a16 = a(gVar);
        int i3 = 0;
        int paddingLeft = a16 != null ? a16.getPaddingLeft() + a16.getPaddingRight() : 0;
        ImageView b16 = b(gVar);
        if (b16 != null) {
            if (!z16) {
                b16 = null;
            }
            if (b16 != null) {
                i3 = MathKt__MathJVMKt.roundToInt(z.j().getDisplayMetrics().density * 30);
            }
        }
        TextView c16 = c(gVar);
        TextPaint paint = c16 != null ? c16.getPaint() : null;
        if (charSequence instanceof String) {
            if (paint != null) {
                desiredWidth = paint.measureText((String) charSequence);
            }
            desiredWidth = 0.0f;
        } else {
            if (paint != null) {
                desiredWidth = Layout.getDesiredWidth(charSequence, paint);
            }
            desiredWidth = 0.0f;
        }
        return (int) (paddingLeft + i3 + desiredWidth);
    }

    public final LinearLayout a(com.tencent.luggage.wxa.ic.g gVar) {
        View a16 = gVar.I().a(R.id.s_a);
        if (a16 instanceof LinearLayout) {
            return (LinearLayout) a16;
        }
        return null;
    }

    public final Animator a(Animator animator) {
        com.tencent.luggage.wxa.e5.l.f124555a.a(this.f133516a, new g(animator));
        return animator;
    }
}
