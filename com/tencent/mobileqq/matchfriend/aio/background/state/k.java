package com.tencent.mobileqq.matchfriend.aio.background.state;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy;
import com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate;
import com.tencent.mobileqq.matchfriend.aio.background.state.a;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerForegroundApi;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J0\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/state/k;", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/BaseStateAnimator;", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/a$a;", "viewParams", "", "immediate", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "view", "k", "f", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate;", "pv", "pagView", "d", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k extends BaseStateAnimator {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/matchfriend/aio/background/state/k$a", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$b;", "Landroid/view/View;", "view", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "a", "onAnimationUpdate", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements PAGViewDelegate.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a.AnimatorParams f243844b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f243845c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PAGViewDelegate f243846d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BaseMutualMarkAIOBackgroundProxy.f f243847e;

        a(a.AnimatorParams animatorParams, boolean z16, PAGViewDelegate pAGViewDelegate, BaseMutualMarkAIOBackgroundProxy.f fVar) {
            this.f243844b = animatorParams;
            this.f243845c = z16;
            this.f243846d = pAGViewDelegate;
            this.f243847e = fVar;
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
            k.this.m(this.f243844b, this.f243845c);
            k.this.k(this.f243846d);
            k.this.k(this.f243844b.getPolarLightView());
            this.f243844b.getPolarLightView().stopAnimation();
            Object c16 = this.f243847e.c();
            QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel = c16 instanceof QQStrangerInteractiveMarkModel ? (QQStrangerInteractiveMarkModel) c16 : null;
            if (qQStrangerInteractiveMarkModel != null) {
                ((IQQStrangerForegroundApi) QRoute.api(IQQStrangerForegroundApi.class)).showGainMutualMarkAnimatorView(qQStrangerInteractiveMarkModel);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(final View view) {
        ViewPropertyAnimator alpha = view.animate().alpha(0.0f);
        alpha.setDuration(200L);
        alpha.withEndAction(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.background.state.i
            @Override // java.lang.Runnable
            public final void run() {
                k.l(view);
            }
        });
        alpha.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(final a.AnimatorParams viewParams, boolean immediate) {
        if (viewParams.getTextView().getVisibility() == 0) {
            if (!immediate) {
                ViewPropertyAnimator alpha = viewParams.getTextView().animate().alpha(0.0f);
                alpha.setDuration(150L);
                alpha.withEndAction(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.background.state.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.n(a.AnimatorParams.this);
                    }
                });
                alpha.start();
                return;
            }
            viewParams.getTextView().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(a.AnimatorParams viewParams) {
        Intrinsics.checkNotNullParameter(viewParams, "$viewParams");
        viewParams.getTextView().setVisibility(8);
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.state.BaseStateAnimator
    public void d(BaseMutualMarkAIOBackgroundProxy.f state, a.AnimatorParams viewParams, boolean immediate, PAGViewDelegate pv5, View pagView) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        Intrinsics.checkNotNullParameter(pv5, "pv");
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        pv5.c(pagView, new a(viewParams, immediate, pv5, state));
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.state.BaseStateAnimator
    public boolean f() {
        return false;
    }
}
