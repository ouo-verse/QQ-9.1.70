package com.tencent.mobileqq.matchfriend.aio.background.state;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy;
import com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate;
import com.tencent.mobileqq.matchfriend.aio.background.state.a;
import com.tencent.mobileqq.matchfriend.aio.background.state.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/state/h;", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/BaseStateAnimator;", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/a$a;", "viewParams", "", "immediate", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate;", "pv", "Landroid/view/View;", "pagView", "", "d", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class h extends BaseStateAnimator {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/matchfriend/aio/background/state/h$a", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$b;", "Landroid/view/View;", "view", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "a", "onAnimationUpdate", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements PAGViewDelegate.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.AnimatorParams f243839a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f243840b;

        a(a.AnimatorParams animatorParams, boolean z16) {
            this.f243839a = animatorParams;
            this.f243840b = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a.AnimatorParams viewParams) {
            Intrinsics.checkNotNullParameter(viewParams, "$viewParams");
            viewParams.getTextView().setVisibility(8);
        }

        @Override // com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate.b
        public void a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate.b
        public void onAnimationCancel(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate.b
        public void onAnimationEnd(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (this.f243839a.getTextView().getVisibility() == 0) {
                if (!this.f243840b) {
                    ViewPropertyAnimator alpha = this.f243839a.getTextView().animate().alpha(0.0f);
                    final a.AnimatorParams animatorParams = this.f243839a;
                    alpha.setDuration(150L);
                    alpha.withEndAction(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.background.state.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.a.c(a.AnimatorParams.this);
                        }
                    });
                    alpha.start();
                    return;
                }
                this.f243839a.getTextView().setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate.b
        public void onAnimationStart(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate.b
        public void onAnimationUpdate(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.state.BaseStateAnimator
    public void d(BaseMutualMarkAIOBackgroundProxy.f state, a.AnimatorParams viewParams, boolean immediate, PAGViewDelegate pv5, View pagView) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        Intrinsics.checkNotNullParameter(pv5, "pv");
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        pv5.c(pagView, new a(viewParams, immediate));
    }
}
