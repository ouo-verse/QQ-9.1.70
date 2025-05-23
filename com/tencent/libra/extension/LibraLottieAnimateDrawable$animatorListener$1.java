package com.tencent.libra.extension;

import android.animation.Animator;
import android.os.Handler;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import r01.d;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/libra/extension/LibraLottieAnimateDrawable$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libra-extension-lottie_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LibraLottieAnimateDrawable$animatorListener$1 implements Animator.AnimatorListener {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ LibraLottieAnimateDrawable f118701d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LibraLottieAnimateDrawable$animatorListener$1(LibraLottieAnimateDrawable libraLottieAnimateDrawable) {
        this.f118701d = libraLottieAnimateDrawable;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animation) {
        Handler handler;
        Intrinsics.checkNotNullParameter(animation, "animation");
        handler = this.f118701d.mUIHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.libra.extension.LibraLottieAnimateDrawable$animatorListener$1$onAnimationEnd$1
                @Override // java.lang.Runnable
                public final void run() {
                    Animatable2Compat.AnimationCallback animationCallback;
                    animationCallback = LibraLottieAnimateDrawable$animatorListener$1.this.f118701d.animatableCallback;
                    if (animationCallback != null) {
                        animationCallback.onAnimationEnd(LibraLottieAnimateDrawable$animatorListener$1.this.f118701d.getDrawable());
                    }
                }
            });
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@NotNull Animator animation) {
        Handler handler;
        Intrinsics.checkNotNullParameter(animation, "animation");
        handler = this.f118701d.mUIHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.libra.extension.LibraLottieAnimateDrawable$animatorListener$1$onAnimationRepeat$1
                @Override // java.lang.Runnable
                public final void run() {
                    d dVar;
                    dVar = LibraLottieAnimateDrawable$animatorListener$1.this.f118701d.libraAnimationListener;
                    if (dVar != null) {
                        dVar.a(0);
                    }
                }
            });
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NotNull Animator animation) {
        Handler handler;
        Intrinsics.checkNotNullParameter(animation, "animation");
        handler = this.f118701d.mUIHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.libra.extension.LibraLottieAnimateDrawable$animatorListener$1$onAnimationStart$1
                @Override // java.lang.Runnable
                public final void run() {
                    Animatable2Compat.AnimationCallback animationCallback;
                    animationCallback = LibraLottieAnimateDrawable$animatorListener$1.this.f118701d.animatableCallback;
                    if (animationCallback != null) {
                        animationCallback.onAnimationStart(LibraLottieAnimateDrawable$animatorListener$1.this.f118701d.getDrawable());
                    }
                }
            });
        }
    }
}
