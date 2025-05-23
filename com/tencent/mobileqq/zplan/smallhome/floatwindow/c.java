package com.tencent.mobileqq.zplan.smallhome.floatwindow;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b!\u0010\"J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/c;", "", "", "screenWidth", "newTop", "newLeft", "", "f", "", "isFromClick", "d", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/e;", "a", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/e;", "proxyWrapper", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/ZPlanSmallHomeFloatView;", "b", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/ZPlanSmallHomeFloatView;", "floatView", "c", "I", "normalWidth", "normalHeight", "e", "edgeWidth", "edgeHeight", "Landroid/animation/ValueAnimator;", "g", "Landroid/animation/ValueAnimator;", "mDragAnimator", tl.h.F, "Ljava/lang/Integer;", "cacheNewLeft", "<init>", "(Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/e;Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/ZPlanSmallHomeFloatView;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final e proxyWrapper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZPlanSmallHomeFloatView floatView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int normalWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int normalHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int edgeWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int edgeHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator mDragAnimator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Integer cacheNewLeft;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/floatwindow/c$a", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends com.tencent.mobileqq.widget.f {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            animator.removeAllListeners();
            ZPlanSmallHomeFloatView zPlanSmallHomeFloatView = c.this.floatView;
            if (zPlanSmallHomeFloatView != null) {
                zPlanSmallHomeFloatView.e();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/floatwindow/c$b", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.widget.f {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f335680e;

        b(int i3) {
            this.f335680e = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            animator.removeAllListeners();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            ZPlanSmallHomeFloatView zPlanSmallHomeFloatView = c.this.floatView;
            if (zPlanSmallHomeFloatView != null) {
                zPlanSmallHomeFloatView.f(this.f335680e < 0);
            }
        }
    }

    public c(e proxyWrapper, ZPlanSmallHomeFloatView zPlanSmallHomeFloatView) {
        Intrinsics.checkNotNullParameter(proxyWrapper, "proxyWrapper");
        this.proxyWrapper = proxyWrapper;
        this.floatView = zPlanSmallHomeFloatView;
        this.normalWidth = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f12417e);
        this.normalHeight = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f12407d);
        this.edgeWidth = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f12397c);
        this.edgeHeight = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f12387b);
        this.cacheNewLeft = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i3, int i16, int i17, int i18, c this$0, boolean z16, int i19, int i26, int i27, int i28, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.proxyWrapper.n0((int) (i3 + ((i16 - i3) * floatValue)), (int) (i17 + ((i18 - i17) * floatValue)));
        if (z16) {
            this$0.proxyWrapper.k0((int) (i19 + ((i26 - i19) * floatValue)), (int) (i27 + ((i28 - i27) * floatValue)));
        }
        ZPlanSmallHomeFloatView zPlanSmallHomeFloatView = this$0.floatView;
        if (zPlanSmallHomeFloatView != null) {
            zPlanSmallHomeFloatView.n(floatValue, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, c this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.proxyWrapper.n0((int) (i19 + ((i26 - i19) * floatValue)), (int) (i27 + ((i28 - i27) * floatValue)));
        this$0.proxyWrapper.k0((int) (i3 + ((i16 - i3) * floatValue)), (int) (i17 + ((i18 - i17) * floatValue)));
        ZPlanSmallHomeFloatView zPlanSmallHomeFloatView = this$0.floatView;
        if (zPlanSmallHomeFloatView != null) {
            zPlanSmallHomeFloatView.n(floatValue, false);
        }
    }

    public final void d(final boolean isFromClick) {
        ValueAnimator valueAnimator = this.mDragAnimator;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            this.mDragAnimator = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mDragAnimator = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(isFromClick ? 160L : 1L);
        }
        final int r16 = this.proxyWrapper.r();
        final int s16 = this.proxyWrapper.s();
        Integer num = this.cacheNewLeft;
        final int intValue = num != null ? num.intValue() : r16;
        final int i3 = this.edgeWidth;
        final int i16 = this.edgeHeight;
        final int i17 = this.normalWidth;
        final int i18 = this.normalHeight;
        ValueAnimator valueAnimator2 = this.mDragAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.zplan.smallhome.floatwindow.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    c.e(i3, i17, i16, i18, this, isFromClick, r16, intValue, s16, s16, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this.mDragAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new a());
        }
        ValueAnimator valueAnimator4 = this.mDragAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
    }

    public final void f(int screenWidth, final int newTop, int newLeft) {
        ValueAnimator valueAnimator = this.mDragAnimator;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            this.mDragAnimator = null;
        }
        this.cacheNewLeft = Integer.valueOf(newLeft);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mDragAnimator = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(260L);
        }
        final int r16 = this.proxyWrapper.r();
        final int s16 = this.proxyWrapper.s();
        final int i3 = this.edgeWidth;
        int i16 = (screenWidth / 2) - (i3 / 2);
        if (r16 < 0) {
            i16 = -i16;
        }
        final int i17 = i16;
        final int i18 = this.normalWidth;
        final int i19 = this.normalHeight;
        final int i26 = this.edgeHeight;
        ValueAnimator valueAnimator2 = this.mDragAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.zplan.smallhome.floatwindow.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    c.g(r16, i17, s16, newTop, i18, i3, i19, i26, this, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this.mDragAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new b(r16));
        }
        ValueAnimator valueAnimator4 = this.mDragAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
    }
}
