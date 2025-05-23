package com.tencent.mobileqq.zplan.aigc.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.falco.utils.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.aigc.view.SuitCreateLoadingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.pag.ZPlanPAGLoader;
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import fi3.bx;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0002!\"B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/SuitCreateLoadingView;", "Landroid/widget/FrameLayout;", "", h.F, "Lcom/tencent/mobileqq/zplan/aigc/view/SuitCreateLoadingView$b;", "callback", "setOnRetryListener", "g", "Landroid/graphics/drawable/Drawable;", "drawable", "setShadowDrawable", "d", "i", "j", "", "Landroid/animation/ObjectAnimator;", "f", "e", "Lfi3/bx;", "Lfi3/bx;", "mBinding", "Lcom/tencent/mobileqq/zplan/aigc/view/SuitCreateLoadingView$b;", "mRetryCallback", "Landroid/graphics/drawable/Drawable;", "mShadowDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitCreateLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final bx mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private b mRetryCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Drawable mShadowDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/SuitCreateLoadingView$b;", "", "", "onRetry", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void onRetry();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuitCreateLoadingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SuitCreateLoadingView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetworkAvailable()) {
            this$0.d();
            return;
        }
        b bVar = this$0.mRetryCallback;
        if (bVar != null) {
            bVar.onRetry();
        }
        this$0.h();
    }

    private final void h() {
        this.mBinding.f399182c.setVisibility(8);
        i();
    }

    public final List<ObjectAnimator> e() {
        List<ObjectAnimator> listOf;
        SuitPagView suitPagView = this.mBinding.f399181b;
        Intrinsics.checkNotNullExpressionValue(suitPagView, "mBinding.suitBgPagView");
        suitPagView.setPivotX(suitPagView.getWidth() / 2);
        suitPagView.setPivotY(suitPagView.getHeight() / 2);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ObjectAnimator[]{ObjectAnimator.ofFloat(suitPagView, "translationY", 0.0f), ObjectAnimator.ofFloat(suitPagView, BasicAnimation.KeyPath.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(suitPagView, BasicAnimation.KeyPath.SCALE_X, 1.0f)});
        return listOf;
    }

    public final List<ObjectAnimator> f() {
        List<ObjectAnimator> listOf;
        SuitPagView suitPagView = this.mBinding.f399181b;
        Intrinsics.checkNotNullExpressionValue(suitPagView, "mBinding.suitBgPagView");
        suitPagView.setPivotX(suitPagView.getWidth() / 2);
        suitPagView.setPivotY(suitPagView.getHeight() / 2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(suitPagView, "translationY", ViewUtils.dpToPx(146.0f) - (getHeight() / 2.0f)).setDuration(960L);
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(\n               \u2026MODEL_CLOTH_FLY_DURATION)");
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(suitPagView, BasicAnimation.KeyPath.SCALE_Y, 0.42f).setDuration(960L);
        Intrinsics.checkNotNullExpressionValue(duration2, "ofFloat(view, \"scaleY\", \u2026MODEL_CLOTH_FLY_DURATION)");
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(suitPagView, BasicAnimation.KeyPath.SCALE_X, 0.42f).setDuration(960L);
        Intrinsics.checkNotNullExpressionValue(duration3, "ofFloat(view, \"scaleX\", \u2026MODEL_CLOTH_FLY_DURATION)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ObjectAnimator[]{duration, duration2, duration3});
        return listOf;
    }

    public final void g() {
        QLog.i("SuitCreateLoadingView", 1, "pauseLoading");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(260L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new c());
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.mBinding.f399184e, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f), ObjectAnimator.ofFloat(this.mBinding.f399185f, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f));
        animatorSet.start();
        this.mBinding.f399182c.setVisibility(8);
        this.mBinding.f399184e.w();
    }

    public final void j() {
        this.mBinding.f399184e.setVisibility(0);
        this.mBinding.f399184e.setAlpha(1.0f);
        this.mBinding.f399185f.setVisibility(0);
        this.mBinding.f399185f.setAlpha(1.0f);
        bx bxVar = this.mBinding;
        bxVar.f399184e.setOuterPlaceHolderView(bxVar.f399183d);
        SuitPagView suitPagView = this.mBinding.f399184e;
        Intrinsics.checkNotNullExpressionValue(suitPagView, "mBinding.suitLoadingPagView");
        SuitPagView.v(suitPagView, "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_loading.pag", false, 2, null);
    }

    public final void setOnRetryListener(b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mRetryCallback = callback;
    }

    public final void setShadowDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mShadowDrawable = drawable;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuitCreateLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void i() {
        QLog.i("SuitCreateLoadingView", 1, "showBackgroundLoading");
        SuitPagView suitPagView = this.mBinding.f399181b;
        Intrinsics.checkNotNullExpressionValue(suitPagView, "mBinding.suitBgPagView");
        SuitPagView.v(suitPagView, "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_loading_bg_slow.pag", false, 2, null);
    }

    public /* synthetic */ SuitCreateLoadingView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCreateLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        bx g16 = bx.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.mBinding = g16;
        g16.f399182c.setOnClickListener(new View.OnClickListener() { // from class: ae3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitCreateLoadingView.b(SuitCreateLoadingView.this, view);
            }
        });
        g16.f399181b.getLayoutParams().width = ViewUtils.getScreenHeight();
        if (new File(ZPlanPAGLoader.f369875a.g("https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_loading_bg_slow.pag", false)).exists()) {
            return;
        }
        g16.f399183d.addView(LoadingUtil.getLoadingView(context, UIUtil.dp2px(context, 16.0f), UIUtil.dp2px(context, 16.0f), 2));
    }

    public final void d() {
        QQToastUtil.showQQToast(1, R.string.xjj);
        this.mBinding.f399184e.setVisibility(0);
        this.mBinding.f399184e.setAlpha(1.0f);
        this.mBinding.f399185f.setVisibility(0);
        this.mBinding.f399185f.setAlpha(1.0f);
        this.mBinding.f399184e.s("https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_loading.pag", false);
        this.mBinding.f399181b.w();
        Drawable drawable = this.mShadowDrawable;
        if (drawable != null) {
            this.mBinding.f399182c.setBackground(drawable);
        }
        this.mBinding.f399182c.setVisibility(0);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/view/SuitCreateLoadingView$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            SuitCreateLoadingView.this.mBinding.f399184e.setVisibility(8);
            SuitCreateLoadingView.this.mBinding.f399185f.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
