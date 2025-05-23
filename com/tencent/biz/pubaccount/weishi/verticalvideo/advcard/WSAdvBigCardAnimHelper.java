package com.tencent.biz.pubaccount.weishi.verticalvideo.advcard;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\bR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u0017\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSAdvBigCardAnimHelper;", "", "Landroid/view/View;", "targetView", "", "delayTime", "Landroid/animation/Animator$AnimatorListener;", "animatorListener", "", "f", "g", "d", "a", "I", "getBottomBarHeight", "()I", "e", "(I)V", "bottomBarHeight", "Landroid/animation/ValueAnimator;", "b", "Landroid/animation/ValueAnimator;", "easeInAnimator", "c", "easeOutAnimator", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/utils/a;", "Lkotlin/Lazy;", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/utils/a;", "easeInInterpolator", "easeOutInterpolator", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSAdvBigCardAnimHelper {

    /* renamed from: g, reason: collision with root package name */
    private static final int f81844g = ViewUtils.dip2px(92.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int bottomBarHeight;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator easeInAnimator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator easeOutAnimator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy easeInInterpolator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy easeOutInterpolator;

    public WSAdvBigCardAnimHelper() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.biz.pubaccount.weishi.verticalvideo.utils.a>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSAdvBigCardAnimHelper$easeInInterpolator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.biz.pubaccount.weishi.verticalvideo.utils.a invoke() {
                return new com.tencent.biz.pubaccount.weishi.verticalvideo.utils.a(0.42f, 0.0f, 1.0f, 1.0f);
            }
        });
        this.easeInInterpolator = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.biz.pubaccount.weishi.verticalvideo.utils.a>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSAdvBigCardAnimHelper$easeOutInterpolator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.biz.pubaccount.weishi.verticalvideo.utils.a invoke() {
                return new com.tencent.biz.pubaccount.weishi.verticalvideo.utils.a(0.0f, 0.0f, 0.58f, 1.0f);
            }
        });
        this.easeOutInterpolator = lazy2;
    }

    private final com.tencent.biz.pubaccount.weishi.verticalvideo.utils.a b() {
        return (com.tencent.biz.pubaccount.weishi.verticalvideo.utils.a) this.easeInInterpolator.getValue();
    }

    private final com.tencent.biz.pubaccount.weishi.verticalvideo.utils.a c() {
        return (com.tencent.biz.pubaccount.weishi.verticalvideo.utils.a) this.easeOutInterpolator.getValue();
    }

    public final void a() {
        ValueAnimator valueAnimator = this.easeInAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.easeOutAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    public final int d() {
        return f81844g + this.bottomBarHeight;
    }

    public final void e(int i3) {
        this.bottomBarHeight = i3;
    }

    public final void f(View targetView, int delayTime, Animator.AnimatorListener animatorListener) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(animatorListener, "animatorListener");
        x.i("WSAdvBigCardAnimHelper", "startEaseInAnim delayTime = " + delayTime);
        a();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(targetView, View.TRANSLATION_Y.getName(), (float) d(), (float) 0);
        ofFloat.setInterpolator(b());
        ofFloat.setDuration(300L);
        ofFloat.addListener(animatorListener);
        ofFloat.setStartDelay(delayTime);
        ofFloat.start();
        this.easeInAnimator = ofFloat;
    }

    public final void g(View targetView, int delayTime, Animator.AnimatorListener animatorListener) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(animatorListener, "animatorListener");
        a();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(targetView, View.TRANSLATION_Y.getName(), 0, d());
        ofFloat.setInterpolator(c());
        ofFloat.setDuration(300L);
        ofFloat.addListener(animatorListener);
        ofFloat.setStartDelay(delayTime);
        ofFloat.start();
        this.easeOutAnimator = ofFloat;
    }
}
