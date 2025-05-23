package ah0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.rf.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0002\u0004\u0002B#\b\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0002\u001a\u00020\u0000J\u0006\u0010\u0004\u001a\u00020\u0003R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lah0/a;", "", "b", "", "a", "", "Ljava/lang/String;", "TAG", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "animatorSet", "", "Landroid/animation/Animator;", "animatorList", "Landroid/animation/Animator$AnimatorListener;", "listener", "<init>", "(Ljava/util/List;Landroid/animation/Animator$AnimatorListener;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AnimatorSet animatorSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b.\u0010/J^\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJx\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\t\u001a\u00020\u0007JZ\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ>\u0010!\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ*\u0010\"\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010#\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010%\u001a\u00020$R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010)R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010-\u00a8\u00060"}, d2 = {"Lah0/a$a;", "", "Landroid/view/View;", "targetView", "", "startAlpha", "endAlpha", "", "duration", "delay", "", "isInitStartAlpha", "isHardwareAccelerate", "Landroid/animation/TimeInterpolator;", "interpolator", "Landroid/animation/Animator$AnimatorListener;", "listener", "a", "startScaleX", "endScaleX", "startScaleY", "endScaleY", "pivotX", "pivotY", "e", "startX", "startY", "endX", "endY", "i", "target", "from", "to", "g", "k", "d", "Lah0/a;", "c", "Ljava/util/ArrayList;", "Landroid/animation/Animator;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "animatorList", "b", "Landroid/animation/Animator$AnimatorListener;", "J", "<init>", "(J)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: ah0.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0035a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final ArrayList<Animator> animatorList = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private Animator.AnimatorListener listener;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final long duration;

        public C0035a(long j3) {
            this.duration = j3;
        }

        public final a c() {
            return new a(this.animatorList, this.listener, null);
        }

        public final C0035a d(Animator.AnimatorListener listener) {
            this.listener = listener;
            return this;
        }

        public final C0035a e(View targetView, float startScaleX, float endScaleX, float startScaleY, float endScaleY, float pivotX, float pivotY, long duration, boolean isHardwareAccelerate, TimeInterpolator interpolator, Animator.AnimatorListener listener, long delay) {
            if (!Float.isNaN(startScaleX) && !Float.isNaN(endScaleX) && !Float.isNaN(startScaleY) && !Float.isNaN(endScaleY)) {
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
                    animatorSet.addListener(new c(targetView));
                }
                return this;
            }
            cg0.a.a("ECAnimationSet", "ECAnimationSet scaleAnimation", "IllegalArgument startScaleX=" + startScaleX + ", endScaleX=" + endScaleX + ", startScaleY=" + startScaleY + ", endScaleY=" + endScaleY);
            return this;
        }

        public final C0035a i(View targetView, float startX, float startY, float endX, float endY, long duration, boolean isHardwareAccelerate, TimeInterpolator interpolator, Animator.AnimatorListener listener) {
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
                animatorSet.addListener(new c(targetView));
            }
            return this;
        }

        public final C0035a a(View targetView, float startAlpha, float endAlpha, long duration, long delay, boolean isInitStartAlpha, boolean isHardwareAccelerate, TimeInterpolator interpolator, Animator.AnimatorListener listener) {
            if (isInitStartAlpha) {
                targetView.setAlpha(startAlpha);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(targetView, com.tencent.luggage.wxa.c8.c.f123400v, startAlpha, endAlpha);
            ofFloat.setStartDelay(delay);
            ofFloat.setInterpolator(interpolator);
            ofFloat.setDuration(duration);
            this.animatorList.add(ofFloat);
            if (listener != null) {
                ofFloat.addListener(listener);
            }
            if (isHardwareAccelerate) {
                ofFloat.addListener(new c(targetView));
            }
            return this;
        }

        public final C0035a k(View target, View from, View to5, TimeInterpolator interpolator) {
            from.getLocationInWindow(new int[2]);
            to5.getLocationInWindow(new int[2]);
            if (target == from) {
                return j(this, target, 0.0f, 0.0f, r1[0] - r2[0], r1[1] - r2[1], 0L, false, interpolator, null, g.CTRL_INDEX, null);
            }
            return j(this, target, r2[0] - r1[0], r2[1] - r1[1], 0.0f, 0.0f, 0L, false, interpolator, null, g.CTRL_INDEX, null);
        }

        public static /* synthetic */ C0035a j(C0035a c0035a, View view, float f16, float f17, float f18, float f19, long j3, boolean z16, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, int i3, Object obj) {
            return c0035a.i(view, f16, f17, f18, f19, (i3 & 32) != 0 ? c0035a.duration : j3, (i3 & 64) != 0 ? true : z16, (i3 & 128) != 0 ? null : timeInterpolator, (i3 & 256) != 0 ? null : animatorListener);
        }

        public final C0035a g(View target, View from, View to5, float pivotX, float pivotY, TimeInterpolator interpolator) {
            if (target == from) {
                return f(this, target, 1.0f, to5.getWidth() / from.getWidth(), 1.0f, to5.getHeight() / from.getHeight(), pivotX, pivotY, 0L, false, interpolator, null, 0L, 3456, null);
            }
            return f(this, target, from.getWidth() / to5.getWidth(), 1.0f, from.getHeight() / to5.getHeight(), 1.0f, pivotX, pivotY, 0L, false, interpolator, null, 0L, 3456, null);
        }

        public static /* synthetic */ C0035a f(C0035a c0035a, View view, float f16, float f17, float f18, float f19, float f26, float f27, long j3, boolean z16, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, long j16, int i3, Object obj) {
            return c0035a.e(view, f16, f17, f18, f19, (i3 & 32) != 0 ? 0.0f : f26, (i3 & 64) != 0 ? 0.0f : f27, (i3 & 128) != 0 ? c0035a.duration : j3, (i3 & 256) != 0 ? true : z16, (i3 & 512) != 0 ? null : timeInterpolator, (i3 & 1024) != 0 ? null : animatorListener, (i3 & 2048) != 0 ? 0L : j16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lah0/a$b;", "", "Landroid/view/View;", "view", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: ah0.a$b, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(View view) {
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleY(1.0f);
            view.setScaleX(1.0f);
        }
    }

    a(List<? extends Animator> list, Animator.AnimatorListener animatorListener) {
        this.TAG = "ECAnimationSet[" + hashCode() + ']';
        AnimatorSet animatorSet = new AnimatorSet();
        this.animatorSet = animatorSet;
        animatorSet.playTogether(list);
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
    }

    public final void a() {
        cg0.a.b(this.TAG, "ECAnimationSet cancel");
        this.animatorSet.cancel();
    }

    public final a b() {
        cg0.a.b(this.TAG, "ECAnimationSet start");
        try {
            this.animatorSet.start();
        } catch (Exception e16) {
            cg0.a.a(this.TAG, "ECAnimationSet start", e16.toString());
        }
        return this;
    }

    public /* synthetic */ a(List list, Animator.AnimatorListener animatorListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, animatorListener);
    }
}
