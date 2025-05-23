package mk1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a@\u0010\t\u001a\u00020\u0007*\u0004\u0018\u00010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u001a \u0010\u000b\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\n\u001a\u00020\u0002H\u0002\u00a8\u0006\f"}, d2 = {"Landroid/view/View;", "Lkotlin/Pair;", "", com.tencent.luggage.wxa.c8.c.f123400v, "", "durationMs", "Lkotlin/Function1;", "", "endCallback", "c", "v", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i {
    private static final float b(Pair<Float, Float> pair, float f16) {
        return pair.getFirst().floatValue() + ((pair.getSecond().floatValue() - pair.getFirst().floatValue()) * f16);
    }

    public static final void c(@Nullable final View view, @NotNull final Pair<Float, Float> alpha, long j3, @Nullable Function1<? super Unit, Unit> function1) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        if (view != null) {
            view.setAlpha(alpha.getFirst().floatValue());
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mk1.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i.e(view, alpha, valueAnimator);
            }
        });
        ofFloat.setDuration(j3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat);
        animatorSet.addListener(new a(function1));
        animatorSet.start();
    }

    public static /* synthetic */ void d(View view, Pair pair, long j3, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        c(view, pair, j3, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View view, Pair alpha, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(alpha, "$alpha");
        if (view != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            view.setAlpha(b(alpha, ((Float) animatedValue).floatValue()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"mk1/i$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationStart", "onAnimationEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Unit, Unit> f416902d;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Unit, Unit> function1) {
            this.f416902d = function1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            Function1<Unit, Unit> function1 = this.f416902d;
            if (function1 != null) {
                function1.invoke(Unit.INSTANCE);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation, boolean isReverse) {
        }
    }
}
