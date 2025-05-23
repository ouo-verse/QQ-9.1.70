package com.tencent.mobileqq.matchfriend.aio.background.state;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy;
import com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate;
import com.tencent.mobileqq.matchfriend.aio.background.state.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J0\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/state/f;", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/BaseStateAnimator;", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/a$a;", "viewParams", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate;", "pagView", "", "k", "Landroid/view/View;", "view", "o", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "", "immediate", "pv", "d", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f extends BaseStateAnimator {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(a.AnimatorParams this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.getTextView().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(f this$0, TextView this_run) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        this$0.o(this_run);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(a.AnimatorParams this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.getPolarLightView().setVisibility(0);
    }

    private final void o(final View view) {
        ViewPropertyAnimator alpha = view.animate().alpha(0.0f);
        alpha.setStartDelay(2000L);
        alpha.setDuration(150L);
        alpha.withEndAction(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.background.state.e
            @Override // java.lang.Runnable
            public final void run() {
                f.p(view);
            }
        });
        alpha.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(View view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        view.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.state.BaseStateAnimator
    public void d(BaseMutualMarkAIOBackgroundProxy.f state, a.AnimatorParams viewParams, boolean immediate, PAGViewDelegate pv5, View pagView) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        Intrinsics.checkNotNullParameter(pv5, "pv");
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        if (!immediate) {
            k(viewParams, pv5);
            return;
        }
        viewParams.getTextView().setVisibility(0);
        viewParams.getTextView().setAlpha(1.0f);
        o(viewParams.getTextView());
    }

    private final void k(final a.AnimatorParams viewParams, PAGViewDelegate pagView) {
        pagView.setAlpha(0.0f);
        ViewPropertyAnimator alpha = pagView.animate().alpha(1.0f);
        alpha.setDuration(200L);
        alpha.start();
        final TextView textView = viewParams.getTextView();
        textView.setAlpha(0.0f);
        ViewPropertyAnimator alpha2 = textView.animate().alpha(1.0f);
        alpha2.setDuration(150L);
        alpha2.withStartAction(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.background.state.b
            @Override // java.lang.Runnable
            public final void run() {
                f.l(a.AnimatorParams.this);
            }
        });
        alpha2.withEndAction(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.background.state.c
            @Override // java.lang.Runnable
            public final void run() {
                f.m(f.this, textView);
            }
        });
        alpha2.start();
        viewParams.getPolarLightView().setAlpha(0.0f);
        ViewPropertyAnimator alpha3 = viewParams.getPolarLightView().animate().alpha(1.0f);
        alpha3.setDuration(240L);
        alpha3.withStartAction(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.background.state.d
            @Override // java.lang.Runnable
            public final void run() {
                f.n(a.AnimatorParams.this);
            }
        });
        alpha3.start();
    }
}
