package com.tencent.luggage.wxa.lj;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.luggage.wxa.lj.a;
import com.tencent.luggage.wxa.lj.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mobileqq.R;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends f implements j.b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f133483e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final String f133484f = "CapsuleBarBlinkWrapper";

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f133485a;

    /* renamed from: b, reason: collision with root package name */
    public int f133486b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f133487c;

    /* renamed from: d, reason: collision with root package name */
    public Animator f133488d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f133490b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z16) {
            super(1);
            this.f133490b = z16;
        }

        public final void a(com.tencent.luggage.wxa.kl.e eVar) {
            i.this.a(eVar, this.f133490b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.kl.e) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f133492b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z16) {
            super(1);
            this.f133492b = z16;
        }

        public final void a(com.tencent.luggage.wxa.kl.e eVar) {
            i.this.a(eVar, this.f133492b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.kl.e) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBrandOptionButton f133493a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Drawable f133494b;

        public d(AppBrandOptionButton appBrandOptionButton, Drawable drawable) {
            this.f133493a = appBrandOptionButton;
            this.f133494b = drawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.f133493a.getButtonImage().setImageDrawable(this.f133494b);
        }
    }

    public i(com.tencent.luggage.wxa.ic.g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.f133485a = runtime;
        this.f133486b = Integer.MIN_VALUE;
    }

    @Override // com.tencent.luggage.wxa.lj.j.b
    public void a(int i3) {
    }

    @Override // com.tencent.luggage.wxa.lj.f
    public void b(Map params) {
        Boolean bool;
        boolean z16;
        Intrinsics.checkNotNullParameter(params, "params");
        Object obj = params.get("key_type");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarBlinkHelper.CustomStatus");
        a.EnumC6443a enumC6443a = (a.EnumC6443a) obj;
        Object obj2 = params.get("key_allow_animation");
        if (obj2 instanceof Boolean) {
            bool = (Boolean) obj2;
        } else {
            bool = null;
        }
        if (bool != null) {
            z16 = bool.booleanValue();
        } else {
            z16 = false;
        }
        if (enumC6443a == a.EnumC6443a.TRADE) {
            new com.tencent.luggage.wxa.kl.h(this.f133485a.I().g().getContext(), params, new b(z16));
        } else if (enumC6443a == a.EnumC6443a.KOUBEI) {
            new com.tencent.luggage.wxa.kl.g(this.f133485a.I().g().getContext(), params, new c(z16));
        }
        c(enumC6443a.ordinal(), true);
    }

    public final void c(int i3, boolean z16) {
        w.d(f133484f, "reportCapsuleBlinkMutationStart isCustomStatus:%b", Boolean.valueOf(z16));
        this.f133485a.a(true, i3, z16);
    }

    public final boolean d() {
        Animator animator = this.f133488d;
        if (animator != null && animator.isRunning()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.lj.j.b
    /* renamed from: dismiss */
    public void c() {
        setLogo((Drawable) null);
    }

    public final void e() {
        Animator animator = this.f133488d;
        if (animator != null) {
            animator.cancel();
        }
        ImageView buttonImage = this.f133485a.I().g().getButtonImage();
        if (buttonImage != null) {
            buttonImage.clearAnimation();
        }
    }

    public void f() {
        e();
    }

    public final void g() {
        Animator animator = this.f133488d;
        if (animator != null) {
            animator.pause();
        }
    }

    public final void h() {
        Animator animator = this.f133488d;
        if (animator != null) {
            animator.resume();
        }
    }

    @Override // com.tencent.luggage.wxa.lj.j.b
    public void setLogo(int i3) {
    }

    @Override // com.tencent.luggage.wxa.lj.j.b
    public void a(CharSequence charSequence) {
    }

    @Override // com.tencent.luggage.wxa.lj.j.b
    public void setLogo(Drawable drawable) {
        a(drawable);
    }

    @Override // com.tencent.luggage.wxa.lj.j.b
    public void a(String str) {
    }

    @Override // com.tencent.luggage.wxa.lj.j.b
    public void a(int i3, boolean z16) {
        this.f133486b = i3;
        this.f133487c = z16;
    }

    @Override // com.tencent.luggage.wxa.lj.j.b
    public void a(Map params) {
        Intrinsics.checkNotNullParameter(params, "params");
        b(params);
    }

    @Override // com.tencent.luggage.wxa.lj.f
    public void a(Drawable drawable) {
        AppBrandOptionButton g16 = this.f133485a.I().g();
        e();
        boolean z16 = drawable != null;
        boolean a16 = z16 ? false : g16.a();
        this.f133485a.I().f().a(false, drawable != null);
        g16.b();
        w.d(f133484f, "applyLogo");
        if (z16) {
            c(this.f133486b, a16);
        } else {
            a(a16);
        }
        if (drawable != null) {
            g16.getButtonImage().setImageDrawable(drawable);
            Animator a17 = a(g16.getButtonImage());
            ValueAnimator valueAnimator = a17 instanceof ValueAnimator ? (ValueAnimator) a17 : null;
            if (valueAnimator != null) {
                valueAnimator.addUpdateListener(new d(g16, drawable));
            }
            a17.start();
            this.f133488d = a17;
        }
    }

    public final void a(com.tencent.luggage.wxa.kl.e eVar, boolean z16) {
        if (eVar == null) {
            return;
        }
        e();
        l.a(this.f133485a.I().f(), true, false, 2, null);
        AppBrandOptionButton g16 = this.f133485a.I().g();
        View a16 = this.f133485a.I().a(R.id.sqn);
        if (a16 != null) {
            g16.removeView(a16);
        }
        eVar.setId(R.id.sqn);
        eVar.setColor(g16.getStyleColor());
        g16.a(eVar);
        if (z16) {
            Animator a17 = a(g16.getCustomOptionView());
            a17.start();
            this.f133488d = a17;
        }
    }

    @Override // com.tencent.luggage.wxa.lj.f
    public void a(boolean z16) {
        w.d(f133484f, "reportCapsuleBlinkMutationFinish isCustomStatus:%b", Boolean.valueOf(z16));
        this.f133485a.a(false, this.f133486b, z16);
    }
}
