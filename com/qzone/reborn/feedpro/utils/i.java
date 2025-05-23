package com.qzone.reborn.feedpro.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a\u00b2\u0001\u0010\u0010\u001a\u00020\r*\u0004\u0018\u00010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u001a \u0010\u0012\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0002H\u0002\u001a \u0010\u0013\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00012\u0006\u0010\u0011\u001a\u00020\u0002H\u0002\u00a8\u0006\u0014"}, d2 = {"Landroid/view/View;", "Lkotlin/Pair;", "", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "translationX", "translationY", "Landroid/graphics/Rect;", "clipBounds", com.tencent.luggage.wxa.c8.c.f123400v, "Lcom/qzone/reborn/feedpro/utils/f;", "animTimeParams", "Lkotlin/Function0;", "", "onAnimationStart", "onAnimationEnd", "e", "v", "c", "d", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedpro/utils/i$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationStart", "onAnimationEnd", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f54333d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f54334e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f54335f;

        a(Function0<Unit> function0, Function0<Unit> function02, View view) {
            this.f54333d = function0;
            this.f54334e = function02;
            this.f54335f = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Function0<Unit> function0 = this.f54334e;
            if (function0 != null) {
                function0.invoke();
            }
            View view = this.f54335f;
            if (view == null) {
                return;
            }
            view.setClipBounds(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation, boolean isReverse) {
            Function0<Unit> function0 = this.f54333d;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private static final float c(Pair<Float, Float> pair, float f16) {
        return pair.getFirst().floatValue() + ((pair.getSecond().floatValue() - pair.getFirst().floatValue()) * f16);
    }

    private static final Rect d(Pair<Rect, Rect> pair, float f16) {
        return new Rect((int) (pair.getFirst().left + ((pair.getSecond().left - pair.getFirst().left) * f16)), (int) (pair.getFirst().top + ((pair.getSecond().top - pair.getFirst().top) * f16)), (int) (pair.getFirst().right + ((pair.getSecond().right - pair.getFirst().right) * f16)), (int) (pair.getFirst().bottom + ((pair.getSecond().bottom - pair.getFirst().bottom) * f16)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View view, Pair clipBounds, Pair scaleX, Pair scaleY, Pair translationX, Pair translationY, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(clipBounds, "$clipBounds");
        Intrinsics.checkNotNullParameter(scaleX, "$scaleX");
        Intrinsics.checkNotNullParameter(scaleY, "$scaleY");
        Intrinsics.checkNotNullParameter(translationX, "$translationX");
        Intrinsics.checkNotNullParameter(translationY, "$translationY");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        if (view != null) {
            view.setClipBounds(d(clipBounds, floatValue));
        }
        if (view != null) {
            view.setScaleX(c(scaleX, floatValue));
        }
        if (view != null) {
            view.setScaleY(c(scaleY, floatValue));
        }
        if (view != null) {
            view.setTranslationX(c(translationX, floatValue));
        }
        if (view == null) {
            return;
        }
        view.setTranslationY(c(translationY, floatValue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(View view, Pair alpha, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(alpha, "$alpha");
        if (view == null) {
            return;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(c(alpha, ((Float) animatedValue).floatValue()));
    }

    public static final void e(final View view, final Pair<Float, Float> scaleX, final Pair<Float, Float> scaleY, final Pair<Float, Float> translationX, final Pair<Float, Float> translationY, final Pair<Rect, Rect> clipBounds, final Pair<Float, Float> alpha, QzoneFeedProAnimTimeParams animTimeParams, Function0<Unit> function0, Function0<Unit> function02) {
        List listOf;
        boolean z16;
        Intrinsics.checkNotNullParameter(scaleX, "scaleX");
        Intrinsics.checkNotNullParameter(scaleY, "scaleY");
        Intrinsics.checkNotNullParameter(translationX, "translationX");
        Intrinsics.checkNotNullParameter(translationY, "translationY");
        Intrinsics.checkNotNullParameter(clipBounds, "clipBounds");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(animTimeParams, "animTimeParams");
        RFWLog.i("QZoneFeedxAnimUtils", RFWLog.USR, "performAnimation: target\n scaleX = " + scaleX + " scaleY = " + scaleY + "\ntranslationX = " + translationX + " translationY = " + translationY + "\nclipBounds = " + clipBounds + "\nalpha = " + alpha + "\n");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{scaleX.getFirst(), scaleX.getSecond(), scaleY.getFirst(), scaleY.getSecond()});
        List list = listOf;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                float floatValue = ((Number) it.next()).floatValue();
                if (!((Float.isInfinite(floatValue) || Float.isNaN(floatValue)) ? false : true)) {
                    z16 = false;
                    break;
                }
            }
        }
        z16 = true;
        if (z16) {
            if (view != null) {
                view.setScaleX(scaleX.getFirst().floatValue());
            }
            if (view != null) {
                view.setScaleY(scaleY.getFirst().floatValue());
            }
            if (view != null) {
                view.setTranslationX(translationX.getFirst().floatValue());
            }
            if (view != null) {
                view.setTranslationY(translationY.getFirst().floatValue());
            }
            if (view != null) {
                view.setClipBounds(clipBounds.getFirst());
            }
            if (view != null) {
                view.setAlpha(alpha.getFirst().floatValue());
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.reborn.feedpro.utils.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    i.g(view, clipBounds, scaleX, scaleY, translationX, translationY, valueAnimator);
                }
            });
            ofFloat.setDuration(animTimeParams.getTotalDuration());
            ofFloat.setStartDelay(animTimeParams.getTotalStartDelay());
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.reborn.feedpro.utils.h
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    i.h(view, alpha, valueAnimator);
                }
            });
            ofFloat2.setDuration(animTimeParams.getAlphaDuration());
            ofFloat2.setStartDelay(animTimeParams.getAlphaStartDelay());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.addListener(new a(function0, function02, view));
            animatorSet.start();
        }
    }
}
