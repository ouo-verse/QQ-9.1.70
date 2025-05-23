package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.filament.zplan.scene.xwconnect.data.ScreenCoord;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import t74.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/image/URLImageView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class MiniHomeConnectFriendFocusComponent$plantingBubble$2 extends Lambda implements Function0<URLImageView> {
    final /* synthetic */ MiniHomeConnectFriendFocusComponent this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent$plantingBubble$2$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MiniHomeConnectFriendFocusComponent f334566d;

        a(MiniHomeConnectFriendFocusComponent miniHomeConnectFriendFocusComponent) {
            this.f334566d = miniHomeConnectFriendFocusComponent;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            AnimatorSet animatorSet;
            AnimatorSet animatorSet2;
            URLImageView s16;
            QLog.i("MiniHomeConnectFriendFocusComponent", 1, "hideBubbleAnimate onAnimationCancel");
            animatorSet = this.f334566d.hideBubbleAnimatorSet;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            animatorSet2 = this.f334566d.hideBubbleAnimatorSet;
            if (animatorSet2 != null) {
                animatorSet2.end();
            }
            this.f334566d.hideBubbleAnimatorSet = null;
            s16 = this.f334566d.s();
            s16.setAlpha(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            AnimatorSet animatorSet;
            AnimatorSet animatorSet2;
            URLImageView s16;
            QLog.i("MiniHomeConnectFriendFocusComponent", 1, "hideBubbleAnimate onAnimationEnd");
            animatorSet = this.f334566d.hideBubbleAnimatorSet;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            animatorSet2 = this.f334566d.hideBubbleAnimatorSet;
            if (animatorSet2 != null) {
                animatorSet2.end();
            }
            this.f334566d.hideBubbleAnimatorSet = null;
            s16 = this.f334566d.s();
            s16.setAlpha(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent$plantingBubble$2$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MiniHomeConnectFriendFocusComponent f334567d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLImageView f334568e;

        b(MiniHomeConnectFriendFocusComponent miniHomeConnectFriendFocusComponent, URLImageView uRLImageView) {
            this.f334567d = miniHomeConnectFriendFocusComponent;
            this.f334568e = uRLImageView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            URLImageView s16;
            URLImageView s17;
            URLImageView s18;
            QLog.i("MiniHomeConnectFriendFocusComponent", 1, "onGlobalLayout " + this.f334567d.v().getHeight());
            ScreenCoord screenCoord = this.f334567d.curScreenCoord;
            if (screenCoord != null) {
                MiniHomeConnectFriendFocusComponent miniHomeConnectFriendFocusComponent = this.f334567d;
                URLImageView uRLImageView = this.f334568e;
                s17 = miniHomeConnectFriendFocusComponent.s();
                s18 = miniHomeConnectFriendFocusComponent.s();
                ViewGroup.LayoutParams layoutParams = s18.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = (miniHomeConnectFriendFocusComponent.v().getHeight() - screenCoord.getY()) + DisplayUtil.dip2px(uRLImageView.getContext(), 20.0f);
                layoutParams2.leftMargin = screenCoord.getX() - (ViewUtils.dpToPx(155.0f) / 2);
                s17.setLayoutParams(layoutParams2);
            }
            s16 = this.f334567d.s();
            s16.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectFriendFocusComponent$plantingBubble$2(MiniHomeConnectFriendFocusComponent miniHomeConnectFriendFocusComponent) {
        super(0);
        this.this$0 = miniHomeConnectFriendFocusComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MiniHomeConnectFriendFocusComponent this$0, View it) {
        ObjectAnimator objectAnimator;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("MiniHomeConnectFriendFocusComponent", 1, "bubble click");
        if (NetworkUtil.isNetworkAvailable()) {
            this$0.A();
            objectAnimator = this$0.plantingBubbleAnimation;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            qi3.b bVar = qi3.b.f428962a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            AnimatorSet d16 = bVar.d(it, new a(this$0));
            d16.start();
            this$0.hideBubbleAnimatorSet = d16;
            return;
        }
        QQToastUtil.showQQToastInUiThread(1, ZPlanQQMC.INSTANCE.getXWConnectFlowerConfig().getNetworkExceptionPromptText());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final URLImageView invoke() {
        URLImageView uRLImageView = new URLImageView(this.this$0.getContext());
        final MiniHomeConnectFriendFocusComponent miniHomeConnectFriendFocusComponent = this.this$0;
        uRLImageView.setTag("plant_bubble");
        n.e(uRLImageView, ZPlanQQMC.INSTANCE.getXWConnectFlowerConfig().getFriendPlantBubble(), R.drawable.igt, null, 4, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(155.0f), ViewUtils.dpToPx(46.0f));
        layoutParams.addRule(14);
        uRLImageView.setLayoutParams(layoutParams);
        uRLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniHomeConnectFriendFocusComponent$plantingBubble$2.b(MiniHomeConnectFriendFocusComponent.this, view);
            }
        });
        uRLImageView.getViewTreeObserver().addOnGlobalLayoutListener(new b(miniHomeConnectFriendFocusComponent, uRLImageView));
        return uRLImageView;
    }
}
