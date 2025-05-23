package com.tencent.biz.pubaccount.weishi.verticalvideo.advcard;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0004R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/h;", "", "Landroid/view/View;", "targetView", "", "delayTime", "Landroid/animation/Animator$AnimatorListener;", "animatorListener", "", "d", "e", "a", "b", "I", "getCardWidth", "()I", "c", "(I)V", "cardWidth", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "easeInAnimator", "easeOutAnimator", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class h {

    /* renamed from: e, reason: collision with root package name */
    private static final int f81880e = ViewUtils.dip2px(92.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int cardWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator easeInAnimator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator easeOutAnimator;

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

    public final int b() {
        return (-f81880e) - this.cardWidth;
    }

    public final void c(int i3) {
        this.cardWidth = i3;
    }

    public final void d(View targetView, int delayTime, Animator.AnimatorListener animatorListener) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(animatorListener, "animatorListener");
        x.i("WSThreeSegmentCardAnimHelper", "startEaseInAnim delayTime = " + delayTime);
        a();
        int b16 = b();
        targetView.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(targetView, View.TRANSLATION_X.getName(), b16, 0);
        ofFloat.setDuration(400L);
        ofFloat.addListener(animatorListener);
        ofFloat.setStartDelay(delayTime);
        ofFloat.start();
        this.easeInAnimator = ofFloat;
    }

    public final void e(View targetView, int delayTime, Animator.AnimatorListener animatorListener) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(animatorListener, "animatorListener");
        a();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(targetView, View.TRANSLATION_X.getName(), 0, b());
        ofFloat.setDuration(400L);
        ofFloat.addListener(animatorListener);
        ofFloat.setStartDelay(delayTime);
        ofFloat.start();
        this.easeOutAnimator = ofFloat;
    }
}
