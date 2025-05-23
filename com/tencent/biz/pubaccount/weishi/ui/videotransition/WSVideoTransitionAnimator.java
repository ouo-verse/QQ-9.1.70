package com.tencent.biz.pubaccount.weishi.ui.videotransition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J \u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0006J\u001e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004J(\u0010\u001d\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0004J4\u0010!\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001e2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0002J \u0010(\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\u001c\u0010)\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001eR\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSVideoTransitionAnimator;", "", "Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSAnimConfig;", "animConfig", "", "valueType", "", "animatedValue", "f", "Landroid/animation/ValueAnimator;", "", "isReverse", "", "l", "Landroid/view/View;", "view", "translationX", "translationY", "k", "scale", "j", "clipTop", "clipHeight", h.F, "Landroid/widget/ImageView;", "coverView", "width", "curRatio", "curTopMargin", "i", "Lkotlin/Function0;", "onAnimStartCallback", "onAnimEndCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "d", "Landroid/content/Context;", "context", "startAlpha", "endAlpha", "o", "c", "Landroid/graphics/drawable/ColorDrawable;", "b", "Lkotlin/Lazy;", "g", "()Landroid/graphics/drawable/ColorDrawable;", "windowBgDrawable", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSVideoTransitionAnimator {

    /* renamed from: a, reason: collision with root package name */
    public static final WSVideoTransitionAnimator f81645a = new WSVideoTransitionAnimator();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy windowBgDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/pubaccount/weishi/ui/videotransition/WSVideoTransitionAnimator$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f81647d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f81648e;

        a(View view, Function0<Unit> function0) {
            this.f81647d = view;
            this.f81648e = function0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.f81647d.setAlpha(1.0f);
            this.f81647d.setVisibility(8);
            this.f81648e.invoke();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/pubaccount/weishi/ui/videotransition/WSVideoTransitionAnimator$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f81649d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f81650e;

        b(Function0<Unit> function0, Function0<Unit> function02) {
            this.f81649d = function0;
            this.f81650e = function02;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f81650e.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f81649d.invoke();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/pubaccount/weishi/ui/videotransition/WSVideoTransitionAnimator$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f81651d;

        c(Context context) {
            this.f81651d = context;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Context context = this.f81651d;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).getWindow().setBackgroundDrawable(WSVideoTransitionAnimator.f81645a.g());
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ColorDrawable>() { // from class: com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionAnimator$windowBgDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ColorDrawable invoke() {
                return new ColorDrawable(-33554432);
            }
        });
        windowBgDrawable = lazy;
    }

    WSVideoTransitionAnimator() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(WSAnimConfig animConfig, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(animConfig, "$animConfig");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        WSVideoTransitionAnimator wSVideoTransitionAnimator = f81645a;
        float f16 = wSVideoTransitionAnimator.f(animConfig, 1, floatValue);
        float f17 = wSVideoTransitionAnimator.f(animConfig, 2, floatValue);
        float f18 = wSVideoTransitionAnimator.f(animConfig, 3, floatValue);
        float f19 = wSVideoTransitionAnimator.f(animConfig, 4, floatValue);
        int f26 = (int) wSVideoTransitionAnimator.f(animConfig, 6, floatValue);
        float f27 = wSVideoTransitionAnimator.f(animConfig, 7, floatValue);
        float f28 = wSVideoTransitionAnimator.f(animConfig, 5, floatValue);
        wSVideoTransitionAnimator.j(animConfig.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), f16);
        wSVideoTransitionAnimator.k(animConfig.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), f17, f18);
        wSVideoTransitionAnimator.i(animConfig.getIvCoverForAnim(), animConfig.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String().getWidth(), f19, f26);
        wSVideoTransitionAnimator.h(animConfig.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), (int) f27, (int) f28);
    }

    private final float f(WSAnimConfig animConfig, int valueType, float animatedValue) {
        float d16 = animConfig.d(valueType);
        return d16 + ((animConfig.a(valueType) - d16) * animatedValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ColorDrawable g() {
        return (ColorDrawable) windowBgDrawable.getValue();
    }

    public final void c(View coverView, Function0<Unit> onAnimEndCallback) {
        Intrinsics.checkNotNullParameter(coverView, "coverView");
        Intrinsics.checkNotNullParameter(onAnimEndCallback, "onAnimEndCallback");
        coverView.animate().alpha(0.0f).setDuration(200L).setListener(new a(coverView, onAnimEndCallback)).start();
    }

    public final ValueAnimator.AnimatorUpdateListener d(final WSAnimConfig animConfig) {
        Intrinsics.checkNotNullParameter(animConfig, "animConfig");
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.pubaccount.weishi.ui.videotransition.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WSVideoTransitionAnimator.e(WSAnimConfig.this, valueAnimator);
            }
        };
    }

    public final void h(View view, int clipTop, int clipHeight) {
        Intrinsics.checkNotNullParameter(view, "view");
        ((WSDragFrameLayout) view).setClipVertical(clipTop, clipHeight);
        view.invalidate();
    }

    public final void j(View view, float scale) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        view.setScaleX(scale);
        view.setScaleY(scale);
    }

    public final void k(View view, float translationX, float translationY) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
    }

    public final void m(WSAnimConfig animConfig, Function0<Unit> onAnimStartCallback, Function0<Unit> onAnimEndCallback, boolean isReverse) {
        Intrinsics.checkNotNullParameter(animConfig, "animConfig");
        Intrinsics.checkNotNullParameter(onAnimStartCallback, "onAnimStartCallback");
        Intrinsics.checkNotNullParameter(onAnimEndCallback, "onAnimEndCallback");
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        duration.addListener(new b(onAnimStartCallback, onAnimEndCallback));
        duration.addUpdateListener(f81645a.d(animConfig));
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(0F, 1F).setDurat\u2026er(animConfig))\n        }");
        l(duration, isReverse);
    }

    public final void o(Context context, int startAlpha, int endAlpha) {
        ObjectAnimator duration = ObjectAnimator.ofInt(g(), com.tencent.luggage.wxa.c8.c.f123400v, startAlpha, endAlpha).setDuration(300L);
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        duration.addListener(new c(context));
        duration.start();
    }

    private final void l(ValueAnimator valueAnimator, boolean z16) {
        if (z16) {
            valueAnimator.reverse();
        } else {
            valueAnimator.start();
        }
    }

    public final void i(ImageView coverView, int width, float curRatio, int curTopMargin) {
        if (coverView != null) {
            com.tencent.biz.pubaccount.weishi.ui.videotransition.a.f81662a.a(coverView, width, curRatio, curTopMargin);
        }
    }

    public static /* synthetic */ void n(WSVideoTransitionAnimator wSVideoTransitionAnimator, WSAnimConfig wSAnimConfig, Function0 function0, Function0 function02, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        wSVideoTransitionAnimator.m(wSAnimConfig, function0, function02, z16);
    }
}
