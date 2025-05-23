package fj4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0002B#\b\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0002\u001a\u00020\u0000R\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lfj4/a;", "", "a", "", "Ljava/lang/String;", "TAG", "Landroid/animation/AnimatorSet;", "b", "Landroid/animation/AnimatorSet;", "animatorSet", "", "Landroid/animation/Animator;", "animatorList", "Landroid/animation/Animator$AnimatorListener;", "listener", "<init>", "(Ljava/util/List;Landroid/animation/Animator$AnimatorListener;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnimatorSet animatorSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b&\u0010'J^\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJx\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\t\u001a\u00020\u0007J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u001b\u001a\u00020\u001aR\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010%\u00a8\u0006("}, d2 = {"Lfj4/a$a;", "", "Landroid/view/View;", "targetView", "", "startAlpha", "endAlpha", "", "duration", "delay", "", "isInitStartAlpha", "isHardwareAccelerate", "Landroid/animation/TimeInterpolator;", "interpolator", "Landroid/animation/Animator$AnimatorListener;", "listener", "a", "startScaleX", "endScaleX", "startScaleY", "endScaleY", "pivotX", "pivotY", "e", "d", "Lfj4/a;", "c", "J", "getDuration", "()J", "Ljava/util/ArrayList;", "Landroid/animation/Animator;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "animatorList", "Landroid/animation/Animator$AnimatorListener;", "<init>", "(J)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fj4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10319a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long duration;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<Animator> animatorList = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Animator.AnimatorListener listener;

        public C10319a(long j3) {
            this.duration = j3;
        }

        public static /* synthetic */ C10319a b(C10319a c10319a, View view, float f16, float f17, long j3, long j16, boolean z16, boolean z17, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, int i3, Object obj) {
            long j17;
            long j18;
            boolean z18;
            boolean z19;
            TimeInterpolator timeInterpolator2;
            Animator.AnimatorListener animatorListener2;
            if ((i3 & 8) != 0) {
                j17 = c10319a.duration;
            } else {
                j17 = j3;
            }
            if ((i3 & 16) != 0) {
                j18 = 0;
            } else {
                j18 = j16;
            }
            if ((i3 & 32) != 0) {
                z18 = true;
            } else {
                z18 = z16;
            }
            if ((i3 & 64) != 0) {
                z19 = true;
            } else {
                z19 = z17;
            }
            if ((i3 & 128) != 0) {
                timeInterpolator2 = null;
            } else {
                timeInterpolator2 = timeInterpolator;
            }
            if ((i3 & 256) != 0) {
                animatorListener2 = null;
            } else {
                animatorListener2 = animatorListener;
            }
            return c10319a.a(view, f16, f17, j17, j18, z18, z19, timeInterpolator2, animatorListener2);
        }

        public static /* synthetic */ C10319a f(C10319a c10319a, View view, float f16, float f17, float f18, float f19, float f26, float f27, long j3, boolean z16, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, long j16, int i3, Object obj) {
            float f28;
            float f29;
            long j17;
            boolean z17;
            TimeInterpolator timeInterpolator2;
            Animator.AnimatorListener animatorListener2;
            long j18;
            if ((i3 & 32) != 0) {
                f28 = 0.0f;
            } else {
                f28 = f26;
            }
            if ((i3 & 64) != 0) {
                f29 = 0.0f;
            } else {
                f29 = f27;
            }
            if ((i3 & 128) != 0) {
                j17 = c10319a.duration;
            } else {
                j17 = j3;
            }
            if ((i3 & 256) != 0) {
                z17 = true;
            } else {
                z17 = z16;
            }
            if ((i3 & 512) != 0) {
                timeInterpolator2 = null;
            } else {
                timeInterpolator2 = timeInterpolator;
            }
            if ((i3 & 1024) != 0) {
                animatorListener2 = null;
            } else {
                animatorListener2 = animatorListener;
            }
            if ((i3 & 2048) != 0) {
                j18 = 0;
            } else {
                j18 = j16;
            }
            return c10319a.e(view, f16, f17, f18, f19, f28, f29, j17, z17, timeInterpolator2, animatorListener2, j18);
        }

        @NotNull
        public final C10319a a(@NotNull View targetView, float startAlpha, float endAlpha, long duration, long delay, boolean isInitStartAlpha, boolean isHardwareAccelerate, @Nullable TimeInterpolator interpolator, @Nullable Animator.AnimatorListener listener) {
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            if (isInitStartAlpha) {
                targetView.setAlpha(startAlpha);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(targetView, c.f123400v, startAlpha, endAlpha);
            ofFloat.setStartDelay(delay);
            ofFloat.setInterpolator(interpolator);
            ofFloat.setDuration(duration);
            this.animatorList.add(ofFloat);
            if (listener != null) {
                ofFloat.addListener(listener);
            }
            if (isHardwareAccelerate) {
                ofFloat.addListener(new b(targetView));
            }
            return this;
        }

        @NotNull
        public final a c() {
            return new a(this.animatorList, this.listener, null);
        }

        @NotNull
        public final C10319a d(@Nullable Animator.AnimatorListener listener) {
            this.listener = listener;
            return this;
        }

        @NotNull
        public final C10319a e(@NotNull View targetView, float startScaleX, float endScaleX, float startScaleY, float endScaleY, float pivotX, float pivotY, long duration, boolean isHardwareAccelerate, @Nullable TimeInterpolator interpolator, @Nullable Animator.AnimatorListener listener, long delay) {
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            targetView.setPivotX(pivotX);
            targetView.setPivotY(pivotY);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(targetView, BasicAnimation.KeyPath.SCALE_X, startScaleX, endScaleX);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(targetView, BasicAnimation.KeyPath.SCALE_Y, startScaleY, endScaleY);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(interpolator);
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.setDuration(duration);
            animatorSet.setStartDelay(delay);
            this.animatorList.add(animatorSet);
            if (listener != null) {
                animatorSet.addListener(listener);
            }
            if (isHardwareAccelerate) {
                animatorSet.addListener(new b(targetView));
            }
            return this;
        }
    }

    public /* synthetic */ a(List list, Animator.AnimatorListener animatorListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, animatorListener);
    }

    @NotNull
    public final a a() {
        try {
            this.animatorSet.start();
        } catch (IllegalArgumentException e16) {
            QLog.e(this.TAG, 1, "start anim error:" + e16);
        }
        return this;
    }

    a(List<? extends Animator> list, Animator.AnimatorListener animatorListener) {
        this.TAG = "ECAnimationSet[" + hashCode() + "]";
        AnimatorSet animatorSet = new AnimatorSet();
        this.animatorSet = animatorSet;
        animatorSet.playTogether(list);
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
    }
}
