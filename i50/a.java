package i50;

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
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0002\u0004\u0002B#\b\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0002\u001a\u00020\u0000J\u0006\u0010\u0004\u001a\u00020\u0003R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\t\u00a8\u0006\u0013"}, d2 = {"Li50/a;", "", "b", "", "a", "", "Ljava/lang/String;", "TAG", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "animatorSet", "", "Landroid/animation/Animator;", "animatorList", "Landroid/animation/Animator$AnimatorListener;", "listener", "<init>", "(Ljava/util/List;Landroid/animation/Animator$AnimatorListener;)V", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnimatorSet animatorSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J^\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011Jx\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u000b\u001a\u00020\tJZ\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010 \u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\"\u001a\u00020!R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010%R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010,\u00a8\u0006/"}, d2 = {"Li50/a$a;", "", "", "scaleValue", "d", "Landroid/view/View;", "targetView", "startAlpha", "endAlpha", "", "duration", "delay", "", "isInitStartAlpha", "isHardwareAccelerate", "Landroid/animation/TimeInterpolator;", "interpolator", "Landroid/animation/Animator$AnimatorListener;", "listener", "a", "startScaleX", "endScaleX", "startScaleY", "endScaleY", "pivotX", "pivotY", "f", "startX", "startY", "endX", "endY", h.F, "e", "Li50/a;", "c", "J", "getDuration", "()J", "Ljava/util/ArrayList;", "Landroid/animation/Animator;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "animatorList", "Landroid/animation/Animator$AnimatorListener;", "<init>", "(J)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: i50.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C10505a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long duration;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<Animator> animatorList = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Animator.AnimatorListener listener;

        public C10505a(long j3) {
            this.duration = j3;
        }

        public static /* synthetic */ C10505a b(C10505a c10505a, View view, float f16, float f17, long j3, long j16, boolean z16, boolean z17, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, int i3, Object obj) {
            long j17;
            long j18;
            boolean z18;
            boolean z19;
            TimeInterpolator timeInterpolator2;
            Animator.AnimatorListener animatorListener2;
            if ((i3 & 8) != 0) {
                j17 = c10505a.duration;
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
            return c10505a.a(view, f16, f17, j17, j18, z18, z19, timeInterpolator2, animatorListener2);
        }

        private final float d(float scaleValue) {
            if (!Float.isNaN(scaleValue) && !Float.isInfinite(scaleValue)) {
                return scaleValue;
            }
            return 0.0f;
        }

        public static /* synthetic */ C10505a i(C10505a c10505a, View view, float f16, float f17, float f18, float f19, long j3, boolean z16, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, int i3, Object obj) {
            long j16;
            boolean z17;
            TimeInterpolator timeInterpolator2;
            Animator.AnimatorListener animatorListener2;
            if ((i3 & 32) != 0) {
                j16 = c10505a.duration;
            } else {
                j16 = j3;
            }
            if ((i3 & 64) != 0) {
                z17 = true;
            } else {
                z17 = z16;
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
            return c10505a.h(view, f16, f17, f18, f19, j16, z17, timeInterpolator2, animatorListener2);
        }

        @NotNull
        public final C10505a a(@NotNull View targetView, float startAlpha, float endAlpha, long duration, long delay, boolean isInitStartAlpha, boolean isHardwareAccelerate, @Nullable TimeInterpolator interpolator, @Nullable Animator.AnimatorListener listener) {
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
        public final C10505a e(@Nullable Animator.AnimatorListener listener) {
            this.listener = listener;
            return this;
        }

        @NotNull
        public final C10505a f(@NotNull View targetView, float startScaleX, float endScaleX, float startScaleY, float endScaleY, float pivotX, float pivotY, long duration, boolean isHardwareAccelerate, @Nullable TimeInterpolator interpolator, @Nullable Animator.AnimatorListener listener, long delay) {
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            targetView.setPivotX(pivotX);
            targetView.setPivotY(pivotY);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(targetView, BasicAnimation.KeyPath.SCALE_X, d(startScaleX), d(endScaleX));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(targetView, BasicAnimation.KeyPath.SCALE_Y, d(startScaleY), d(endScaleY));
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

        @NotNull
        public final C10505a h(@NotNull View targetView, float startX, float startY, float endX, float endY, long duration, boolean isHardwareAccelerate, @Nullable TimeInterpolator interpolator, @Nullable Animator.AnimatorListener listener) {
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(targetView, "translationX", startX, endX);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(targetView, "translationY", startY, endY);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.setInterpolator(interpolator);
            animatorSet.setDuration(duration);
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

    public final void a() {
        QLog.d(this.TAG, 1, "QFSPublicAccountAnimationSet cancel");
        this.animatorSet.cancel();
    }

    @NotNull
    public final a b() {
        QLog.d(this.TAG, 1, "QFSPublicAccountAnimationSet start");
        try {
            this.animatorSet.start();
        } catch (IllegalArgumentException e16) {
            QLog.e(this.TAG, 1, "start anim error:" + e16);
        }
        return this;
    }

    a(List<? extends Animator> list, Animator.AnimatorListener animatorListener) {
        this.TAG = "QFSPublicAccountAnimationSet[" + hashCode() + "]";
        AnimatorSet animatorSet = new AnimatorSet();
        this.animatorSet = animatorSet;
        animatorSet.playTogether(list);
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
    }
}
