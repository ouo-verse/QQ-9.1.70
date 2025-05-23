package com.tencent.gdtad.views.videoimax;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment;
import java.lang.ref.WeakReference;

/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
final class TransitionContext {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private ValueAnimator f109738a;

    /* renamed from: b, reason: collision with root package name */
    private GdtVideoImaxEnterImageView f109739b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f109740c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f109741d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private ResultReceiver f109742e;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static final class MyResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<TransitionContext> f109743d;

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, @NonNull Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            GdtLog.d("TransitionContext", "onReceiveResult() called with: resultCode = [" + i3 + "], resultData = [" + bundle + "]");
            TransitionContext transitionContext = this.f109743d.get();
            if (transitionContext != null) {
                if (i3 == 2) {
                    transitionContext.g(transitionContext.f109739b);
                    return;
                }
                if (i3 == 0) {
                    transitionContext.f109740c = true;
                    bundle.setClassLoader(GdtVideoImaxFragment.MyResultReceiver.class.getClassLoader());
                    transitionContext.f109742e = (ResultReceiver) bundle.getParcelable("callback");
                    if (transitionContext.f109741d) {
                        transitionContext.h();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(@NonNull ImageView imageView) {
        GdtLog.d("TransitionContext", "finishEnterAnimator() called with: maskView = [" + imageView + "]");
        ViewGroup viewGroup = (ViewGroup) imageView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(imageView);
        }
        ValueAnimator valueAnimator = this.f109738a;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.f109738a.cancel();
                this.f109738a = null;
                throw null;
            }
            throw null;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        GdtLog.d("TransitionContext", "sendAnimationEnd() called");
        ResultReceiver resultReceiver = this.f109742e;
        if (resultReceiver != null) {
            resultReceiver.send(1, new Bundle());
        }
    }
}
