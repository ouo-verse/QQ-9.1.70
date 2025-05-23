package com.tencent.richframework.gallery.anim;

import android.os.Handler;
import com.tencent.richframework.gallery.anim.TransitionAnimator;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/richframework/gallery/anim/TransitionManager$startEnterAnim$1", "Lcom/tencent/richframework/gallery/anim/TransitionAnimator$OnAnimCallback;", "onAnimaUpdate", "", "value", "", "onAnimationCancel", "onAnimationEnd", "onAnimationStart", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class TransitionManager$startEnterAnim$1 implements TransitionAnimator.OnAnimCallback {
    final /* synthetic */ TransitionAnimator.OnAnimCallback $callback;
    final /* synthetic */ TransitionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransitionManager$startEnterAnim$1(TransitionManager transitionManager, TransitionAnimator.OnAnimCallback onAnimCallback) {
        this.this$0 = transitionManager;
        this.$callback = onAnimCallback;
    }

    @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
    public void onAnimaUpdate(float value) {
        TransitionAnimator.OnAnimCallback onAnimCallback = this.$callback;
        if (onAnimCallback != null) {
            onAnimCallback.onAnimaUpdate(value);
        }
    }

    @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
    public void onAnimationCancel() {
        TransitionAnimator.OnAnimCallback onAnimCallback = this.$callback;
        if (onAnimCallback != null) {
            onAnimCallback.onAnimationCancel();
        }
    }

    @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
    public void onAnimationEnd() {
        TransitionAnimator.OnAnimCallback onAnimCallback = this.$callback;
        if (onAnimCallback != null) {
            onAnimCallback.onAnimationEnd();
        }
        Handler uIHandler = RFWThreadManager.getUIHandler();
        Runnable runnable = new Runnable() { // from class: com.tencent.richframework.gallery.anim.TransitionManager$startEnterAnim$1$onAnimationEnd$1
            @Override // java.lang.Runnable
            public final void run() {
                TransitionManager transitionManager = TransitionManager$startEnterAnim$1.this.this$0;
                TransitionInitData transitionInitData = transitionManager.getTransitionInitData();
                Intrinsics.checkNotNull(transitionInitData);
                transitionManager.doFadeCoverDismissAni(transitionInitData.getFadeCoverTimeMs());
            }
        };
        Intrinsics.checkNotNull(this.this$0.getTransitionInitData());
        uIHandler.postDelayed(runnable, r2.getTransitionDelayTimeMs());
    }

    @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
    public void onAnimationStart() {
        TransitionAnimator.OnAnimCallback onAnimCallback = this.$callback;
        if (onAnimCallback != null) {
            onAnimCallback.onAnimationStart();
        }
    }
}
