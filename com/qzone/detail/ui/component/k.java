package com.qzone.detail.ui.component;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.detail.ui.component.g;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/detail/ui/component/k;", "Lcom/qzone/detail/ui/component/g;", "", "x0", "C0", "B0", "Landroid/view/View;", "preview", "y0", "J0", "Landroid/view/View;", "previewView", "", "K0", "Z", "isDismissing", "", "L0", UserInfo.SEX_FEMALE, "cornerRadius", "Lcom/qzone/detail/ui/component/g$a;", "param", "<init>", "(Lcom/qzone/detail/ui/component/g$a;)V", "M0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class k extends g {

    /* renamed from: J0, reason: from kotlin metadata */
    private View previewView;

    /* renamed from: K0, reason: from kotlin metadata */
    private boolean isDismissing;

    /* renamed from: L0, reason: from kotlin metadata */
    private float cornerRadius;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/detail/ui/component/k$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            k.this.isDismissing = false;
            View view = k.this.previewView;
            if (view == null) {
                return;
            }
            view.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    public k(g.a aVar) {
        super(aVar);
        this.cornerRadius = ViewUtils.dpToPx(16.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(k this$0) {
        View view;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isDismissing || (view = this$0.previewView) == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        if (view.getVisibility() == 0) {
            this$0.isDismissing = true;
            this$0.B0();
        }
    }

    private final void B0() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        he0.b.l(alphaAnimation, R.anim.f154975ui);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.6f, 1.0f, 0.6f, 1, 0.5f, 1, 0.5f);
        he0.b.l(scaleAnimation, R.anim.f154975ui);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(new b());
        View view = this.previewView;
        if (view != null) {
            view.startAnimation(animationSet);
        }
    }

    private final void C0() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        he0.b.l(alphaAnimation, R.anim.f154978ul);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.6f, 1.0f, 0.6f, 1.0f, 1, 0.5f, 1, 0.5f);
        he0.b.l(scaleAnimation, R.anim.f154978ul);
        animationSet.addAnimation(scaleAnimation);
        View view = this.previewView;
        if (view != null) {
            view.startAnimation(animationSet);
        }
    }

    private final void x0() {
        RelativeLayout actionContentView;
        ActionSheet actionSheet = this.F;
        if (((actionSheet == null || (actionContentView = actionSheet.getActionContentView()) == null) ? null : actionContentView.getParent()) == null || this.G == null || this.previewView == null) {
            return;
        }
        ViewParent parent = this.F.getActionContentView().getParent();
        RelativeLayout relativeLayout = parent instanceof RelativeLayout ? (RelativeLayout) parent : null;
        if (relativeLayout == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(13);
        layoutParams.addRule(2, R.id.action_sheet_actionView);
        layoutParams.setMargins(ViewUtils.dpToPx(32.0f), ViewUtils.dpToPx(32.0f) + ImmersiveUtils.getStatusBarHeight(relativeLayout.getContext()), ViewUtils.dpToPx(32.0f), ViewUtils.dpToPx(32.0f));
        View view = this.previewView;
        Intrinsics.checkNotNull(view);
        view.setVisibility(0);
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = new RoundCorneredRelativeLayout(relativeLayout.getContext());
        float f16 = this.cornerRadius;
        roundCorneredRelativeLayout.setRadius(f16, f16, f16, f16);
        roundCorneredRelativeLayout.setGravity(17);
        View view2 = this.previewView;
        if ((view2 != null ? view2.getParent() : null) != null) {
            View view3 = this.previewView;
            Intrinsics.checkNotNull(view3);
            ViewParent parent2 = view3.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent2).removeView(this.previewView);
        }
        roundCorneredRelativeLayout.addView(this.previewView);
        relativeLayout.addView(roundCorneredRelativeLayout, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(k this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x0();
        this$0.C0();
    }

    public final void y0(View preview) {
        this.previewView = preview;
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.qzone.detail.ui.component.i
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                k.z0(k.this, dialogInterface);
            }
        });
        setWatchDismissListener(new ActionSheet.WatchDismissActions() { // from class: com.qzone.detail.ui.component.j
            @Override // com.tencent.widget.ActionSheet.WatchDismissActions
            public final void onDismissOperations() {
                k.A0(k.this);
            }
        });
    }
}
