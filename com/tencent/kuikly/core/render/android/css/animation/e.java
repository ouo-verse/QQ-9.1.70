package com.tencent.kuikly.core.render.android.css.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b&\u0018\u0000 &2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002JH\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000426\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006H\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H&R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/e;", "Lcom/tencent/kuikly/core/render/android/css/animation/c;", "Landroid/animation/TimeInterpolator;", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "target", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", IXWebBroadcastListener.STAGE_FINISHED, "", "propKey", "", "onAnimationEndBlock", "o", "a", "Landroid/animation/ValueAnimator;", "t", "", "g", "I", "getTimingFuncType", "()I", "u", "(I)V", "timingFuncType", tl.h.F, "Landroid/animation/ValueAnimator;", "objectAnimator", "i", "Z", "isCancel", "f", "()Z", QzoneWebMusicJsPlugin.EVENT_PLAYING, "<init>", "()V", "k", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public abstract class e extends c {

    /* renamed from: j, reason: collision with root package name */
    private static Interpolator f117619j;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int timingFuncType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator objectAnimator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isCancel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/e$a;", "", "Landroid/view/animation/Interpolator;", "interpolator", "", "a", "b", "", "TIMING_FUNC_TYPE_ACCELERATE", "I", "TIMING_FUNC_TYPE_ACCELERATE_DECELERATE", "TIMING_FUNC_TYPE_DECELERATE", "TIMING_FUNC_TYPE_KEYBOARD", "TIMING_FUNC_TYPE_LINEAR", "UNIT_S_TO_MS", "keyboardInterpolator", "Landroid/view/animation/Interpolator;", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.css.animation.e$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(@Nullable Interpolator interpolator) {
            e.f117619j = interpolator;
        }

        public final void b() {
            e.f117619j = null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/kuikly/core/render/android/css/animation/e$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2 f117625e;

        b(Function2 function2) {
            this.f117625e = function2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            e.this.isCancel = true;
            this.f117625e.invoke(Boolean.valueOf(e.this.e(true)), e.this.getPropKey());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            if (!e.this.isCancel) {
                this.f117625e.invoke(Boolean.valueOf(e.this.e(false)), e.this.getPropKey());
            }
        }
    }

    private final TimeInterpolator s() {
        int i3 = this.timingFuncType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 7) {
                        return new LinearInterpolator();
                    }
                    Interpolator interpolator = f117619j;
                    if (interpolator == null) {
                        return new LinearInterpolator();
                    }
                    return interpolator;
                }
                return new AccelerateDecelerateInterpolator();
            }
            return new DecelerateInterpolator();
        }
        return new AccelerateInterpolator();
    }

    @Override // com.tencent.kuikly.core.render.android.css.animation.c
    public void a() {
        ValueAnimator valueAnimator = this.objectAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.css.animation.c
    public boolean f() {
        ValueAnimator valueAnimator = this.objectAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.css.animation.c
    public void o(@NotNull View target, @NotNull Function2<? super Boolean, ? super String, Unit> onAnimationEndBlock) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onAnimationEndBlock, "onAnimationEndBlock");
        ValueAnimator t16 = t(target);
        t16.setInterpolator(s());
        float f16 = 1000;
        t16.setDuration(getDurationS() * f16);
        t16.setStartDelay(getDelay() * f16);
        if (getRepeatForever()) {
            t16.setRepeatCount(-1);
            t16.setRepeatMode(1);
        }
        Unit unit = Unit.INSTANCE;
        this.objectAnimator = t16;
        t16.addListener(new b(onAnimationEndBlock));
        this.isCancel = false;
        ValueAnimator valueAnimator = this.objectAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @NotNull
    public abstract ValueAnimator t(@NotNull View target);

    public final void u(int i3) {
        this.timingFuncType = i3;
    }
}
