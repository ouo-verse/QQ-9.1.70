package com.tencent.robot.aio.story;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqnt.aio.lazy.FrameLayoutLazyVB;
import com.tencent.robot.aio.story.RobotStoryAnimatorMviUIState;
import com.tencent.robot.aio.story.a;
import hn2.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u001a\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u001c\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0016\u0010\u001f\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/robot/aio/story/RobotStoryAnimatorVB;", "Lcom/tencent/qqnt/aio/lazy/FrameLayoutLazyVB;", "Lcom/tencent/robot/aio/story/a;", "Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState;", "Landroid/view/View$OnTouchListener;", "Lhn2/q;", "w1", "binding", "", "z1", "A1", "o1", "u1", "", "v1", "Landroid/view/ViewGroup$LayoutParams;", "e1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "x1", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", tl.h.F, "Z", "hadEndWaitAnimator", "i", "J", "startWaitAnimatorTimeMillis", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lhn2/q;", "Landroid/animation/AnimatorSet;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/animation/AnimatorSet;", "mAnimatorSet", "Landroid/os/Handler;", "D", "Landroid/os/Handler;", "handler", "<init>", "()V", "E", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotStoryAnimatorVB extends FrameLayoutLazyVB<a, RobotStoryAnimatorMviUIState> implements View.OnTouchListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet mAnimatorSet;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.robot.aio.story.b
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean y16;
            y16 = RobotStoryAnimatorVB.y1(RobotStoryAnimatorVB.this, message);
            return y16;
        }
    });

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hadEndWaitAnimator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long startWaitAnimatorTimeMillis;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private q binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnEnd$$inlined$addListener$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f367377d;

        public b(q qVar) {
            this.f367377d = qVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f367377d.f405409d.setVisibility(8);
            this.f367377d.f405410e.setVisibility(8);
            this.f367377d.f405408c.setVisibility(8);
            this.f367377d.f405411f.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnStart$$inlined$addListener$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f367378d;

        public c(q qVar) {
            this.f367378d = qVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f367378d.f405409d.cancelAnimation();
            this.f367378d.f405410e.cancelAnimation();
        }
    }

    private final void A1(q binding) {
        this.startWaitAnimatorTimeMillis = SystemClock.elapsedRealtime();
        binding.f405409d.playAnimation();
        binding.f405410e.playAnimation();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestHeight = binding.getRoot().getMeasuredHeight();
        obtain.mRequestWidth = binding.getRoot().getMeasuredWidth();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable("https://static-res.qq.com/static-res/adelie/story/robot_enter_story_background.png", obtain);
        drawable.startDownload();
        binding.f405408c.setImageDrawable(drawable);
    }

    private final void o1() {
        List<Animator> mutableListOf;
        if (this.hadEndWaitAnimator) {
            return;
        }
        this.hadEndWaitAnimator = true;
        final q qVar = this.binding;
        if (qVar != null) {
            ValueAnimator endWaitAnimator$lambda$17$lambda$9 = ValueAnimator.ofFloat(1.0f, 0.0f);
            endWaitAnimator$lambda$17$lambda$9.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.aio.story.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RobotStoryAnimatorVB.s1(q.this, valueAnimator);
                }
            });
            Intrinsics.checkNotNullExpressionValue(endWaitAnimator$lambda$17$lambda$9, "endWaitAnimator$lambda$17$lambda$9");
            endWaitAnimator$lambda$17$lambda$9.addListener(new c(qVar));
            endWaitAnimator$lambda$17$lambda$9.addListener(new b(qVar));
            ValueAnimator fadeOutAnim = endWaitAnimator$lambda$17$lambda$9.setDuration(200L);
            final ValueAnimator transitionAnim = ValueAnimator.ofFloat(0.0f, 1.0f);
            transitionAnim.setDuration(1000L);
            transitionAnim.setInterpolator(PathInterpolatorCompat.create(0.52f, 0.0f, 0.74f, 0.0f));
            transitionAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.aio.story.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RobotStoryAnimatorVB.p1(q.this, transitionAnim, valueAnimator);
                }
            });
            Intrinsics.checkNotNullExpressionValue(fadeOutAnim, "fadeOutAnim");
            Intrinsics.checkNotNullExpressionValue(transitionAnim, "transitionAnim");
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(fadeOutAnim, transitionAnim);
            if (qVar.f405407b.getDrawable() != null) {
                qVar.f405407b.setScaleX(1.5f);
                qVar.f405407b.setScaleY(1.5f);
                final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.5f, 1.0f);
                ofFloat.setDuration(1000L);
                ofFloat.setInterpolator(PathInterpolatorCompat.create(0.26f, 0.0f, 0.6f, 0.2f));
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.aio.story.e
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        RobotStoryAnimatorVB.q1(q.this, ofFloat, valueAnimator);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(1.5f, 1f).apply \u2026      }\n                }");
                mutableListOf.add(ofFloat);
                final ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
                ofFloat2.setDuration(500L);
                ofFloat2.setInterpolator(PathInterpolatorCompat.create(0.26f, 0.0f, 0.6f, 0.2f));
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.aio.story.f
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        RobotStoryAnimatorVB.r1(q.this, ofFloat2, valueAnimator);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(1f, 0f).apply {\n\u2026      }\n                }");
                mutableListOf.add(ofFloat2);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            AIONotificationUIUtils.f192828a.l(animatorSet, new Function0<Unit>() { // from class: com.tencent.robot.aio.story.RobotStoryAnimatorVB$endWaitAnimator$1$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    q.this.getRoot().setVisibility(8);
                    ViewParent parent = q.this.getRoot().getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(q.this.getRoot());
                    }
                    this.sendIntent(a.c.f367387d);
                }
            });
            animatorSet.playSequentially(mutableListOf);
            animatorSet.start();
            this.mAnimatorSet = animatorSet;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(q this_run, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        StoryTransitionView storyTransitionView = this_run.f405412g;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        storyTransitionView.setProgress(((Float) animatedValue).floatValue());
        this_run.f405407b.setBlurRadius((int) ((1 - valueAnimator.getAnimatedFraction()) * 40.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(q this_run, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        StoryBlurBgView storyBlurBgView = this_run.f405407b;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        storyBlurBgView.setScaleX(((Float) animatedValue).floatValue());
        StoryBlurBgView storyBlurBgView2 = this_run.f405407b;
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        storyBlurBgView2.setScaleY(((Float) animatedValue2).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(q this_run, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        StoryBlurBgView storyBlurBgView = this_run.f405407b;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        storyBlurBgView.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(q this_run, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this_run.f405409d.setAlpha(floatValue);
        this_run.f405409d.setScaleX(floatValue);
        this_run.f405409d.setScaleY(floatValue);
        this_run.f405410e.setAlpha(floatValue);
        this_run.f405408c.setAlpha(floatValue);
        this_run.f405411f.setAlpha(floatValue);
    }

    private final void u1() {
        long coerceAtLeast;
        q qVar = this.binding;
        if (qVar != null && this.startWaitAnimatorTimeMillis > 0) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(v1(), 0L);
            if (!this.handler.hasMessages(4097)) {
                Handler handler = this.handler;
                handler.sendMessageDelayed(Message.obtain(handler, 4097), coerceAtLeast);
            }
            a.b bVar = new a.b(null, 1, null);
            sendIntent(bVar);
            Drawable drawable = bVar.getDrawable();
            if (drawable != null) {
                qVar.f405407b.setImageDrawable(drawable);
                qVar.f405407b.setBlurRadius(40);
            }
        }
    }

    private final long v1() {
        return 2000 - (SystemClock.elapsedRealtime() - this.startWaitAnimatorTimeMillis);
    }

    private final q w1() {
        q g16 = q.g(LayoutInflater.from(getMContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(mContext))");
        this.binding = g16;
        z1(g16);
        g16.getRoot().setOnTouchListener(this);
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y1(RobotStoryAnimatorVB this$0, Message it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.what == 4097) {
            this$0.o1();
            return true;
        }
        return false;
    }

    private final void z1(q binding) {
        binding.f405409d.setAnimationFromUrl("https://static-res.qq.com/static-res/adelie/story/robot_enter_story_book.json");
        binding.f405409d.setRepeatCount(-1);
        binding.f405410e.setAnimationFromUrl("https://static-res.qq.com/static-res/adelie/story/robot_enter_story_particle.json");
        binding.f405410e.setRepeatCount(-1);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<a, RobotStoryAnimatorMviUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.aio.lazy.FrameLayoutLazyVB
    @NotNull
    public ViewGroup.LayoutParams e1() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        this.hadEndWaitAnimator = false;
        this.startWaitAnimatorTimeMillis = 0L;
        this.handler.removeCallbacksAndMessages(null);
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.mAnimatorSet = null;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        return true;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull RobotStoryAnimatorMviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotStoryAnimatorMviUIState.CreateStoryAnimatorView) {
            sendIntent(new a.C9770a(w1()));
        } else if (state instanceof RobotStoryAnimatorMviUIState.StartStoryViewAnimator) {
            A1(((RobotStoryAnimatorMviUIState.StartStoryViewAnimator) state).getBinding());
        } else if (state instanceof RobotStoryAnimatorMviUIState.StopStoryViewAnimator) {
            u1();
        }
    }
}
