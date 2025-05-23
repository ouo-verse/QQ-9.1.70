package com.tencent.luggage.wxa.lo;

import android.animation.Animator;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public View f133707a;

    /* renamed from: b, reason: collision with root package name */
    public Function0 f133708b;

    public final void a(View view, Function0 function0) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f133707a = view;
        this.f133708b = function0;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator p06) {
        Unit unit;
        Intrinsics.checkNotNullParameter(p06, "p0");
        View view = this.f133707a;
        if (view != null) {
            view.setTranslationX(0.0f);
        }
        Function0 function0 = this.f133708b;
        if (function0 != null) {
            function0.invoke();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            n.c("WeUISlideAnimHelper", "HorizontalAnimationListener onAnimationEnd onAnimationEnd\uff1a" + this.f133708b, new Object[0]);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
    }
}
