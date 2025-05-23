package com.tencent.mobileqq.mini.entry.expDesktop.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniIconFlingAnimView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "iconView", "Landroid/view/View;", "imageView", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "miniRootView", "getMiniRootView", "()Landroid/view/View;", "setMiniRootView", "(Landroid/view/View;)V", "movingView", "setUrl", "", "url", "", "ParabolaEvaluator", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniIconFlingAnimView extends FrameLayout {
    private View iconView;
    private RoundRectImageView imageView;
    public View miniRootView;
    private View movingView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniIconFlingAnimView$ParabolaEvaluator;", "Landroid/animation/TypeEvaluator;", "", "height", "", "(Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniIconFlingAnimView;F)V", "evaluate", "t", "start", "end", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public final class ParabolaEvaluator implements TypeEvaluator<int[]> {
        private final float height;

        public ParabolaEvaluator(float f16) {
            this.height = f16;
        }

        @Override // android.animation.TypeEvaluator
        public int[] evaluate(float t16, int[] start, int[] end) {
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(end, "end");
            int[] iArr = {0, 0};
            iArr[0] = (int) (start[0] + ((end[0] - r2) * t16));
            iArr[1] = (int) (start[1] + ((end[1] - r7) * t16) + (this.height * t16 * (1 - t16)));
            return iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniIconFlingAnimView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(final MiniIconFlingAnimView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View findViewById = this$0.getMiniRootView().findViewById(R.id.rh7);
        if (findViewById instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) findViewById;
            if (recyclerView.getChildCount() > 0) {
                View childAt = recyclerView.getChildAt(0);
                Intrinsics.checkNotNullExpressionValue(childAt, "parentRv.getChildAt(0)");
                this$0.movingView = childAt;
                int[] iArr = {0, 0};
                if (childAt == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("movingView");
                    childAt = null;
                }
                childAt.getLocationOnScreen(iArr);
                int[] iArr2 = {0, 0};
                this$0.iconView.getLocationOnScreen(iArr2);
                ValueAnimator ofObject = ValueAnimator.ofObject(new ParabolaEvaluator(1000.0f), new int[]{0, 0}, new int[]{iArr2[0] - iArr[0], iArr2[1] - iArr[1]});
                Intrinsics.checkNotNullExpressionValue(ofObject, "ofObject(ParabolaEvaluat\u2026, intArrayOf(0, 0), diff)");
                ofObject.setDuration(480L);
                ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.ui.f
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        MiniIconFlingAnimView.lambda$4$lambda$3(MiniIconFlingAnimView.this, valueAnimator);
                    }
                });
                ofObject.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.ui.MiniIconFlingAnimView$3$2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        super.onAnimationCancel(animation);
                        ab.c(MiniIconFlingAnimView.this);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ab.c(MiniIconFlingAnimView.this);
                    }
                });
                ofObject.start();
                return;
            }
        }
        QLog.i(com.tencent.mobileqq.tianshu.ui.a.c(), 1, "parent " + findViewById);
        ab.c(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$4$lambda$3(MiniIconFlingAnimView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.IntArray");
        int[] iArr = (int[]) animatedValue;
        this$0.iconView.setTranslationX(-iArr[0]);
        this$0.iconView.setTranslationY(-iArr[1]);
    }

    public final View getMiniRootView() {
        View view = this.miniRootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("miniRootView");
        return null;
    }

    public final void setMiniRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.miniRootView = view;
    }

    public final void setUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        RoundRectImageView roundRectImageView = this.imageView;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            roundRectImageView = null;
        }
        roundRectImageView.setImageDrawable(MiniAppUtils.getIcon(getRootView().getContext(), url, true));
    }

    public /* synthetic */ MiniIconFlingAnimView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniIconFlingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View _init_$lambda$2 = LayoutInflater.from(context).inflate(R.layout.f167477dj1, (ViewGroup) this, false);
        _init_$lambda$2.setLayoutParams(new FrameLayout.LayoutParams(ViewUtils.dip2px(80.0f), ViewUtils.dip2px(80.0f)));
        RoundRectImageView roundRectImageView = (RoundRectImageView) _init_$lambda$2.findViewById(R.id.rjn);
        roundRectImageView.setCornerRadiusAndMode(ViewUtils.dip2px(24.0f), 1);
        Intrinsics.checkNotNullExpressionValue(roundRectImageView, "this");
        this.imageView = roundRectImageView;
        _init_$lambda$2.findViewById(R.id.rjr).setVisibility(8);
        _init_$lambda$2.findViewById(R.id.rjq).setVisibility(8);
        _init_$lambda$2.findViewById(R.id.rg_).setVisibility(8);
        _init_$lambda$2.findViewById(R.id.f163693ri0).setVisibility(0);
        ViewGroup.LayoutParams layoutParams = _init_$lambda$2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).gravity = 53;
        Intrinsics.checkNotNullExpressionValue(_init_$lambda$2, "_init_$lambda$2");
        int statusBarHeight = AppBrandUtil.getStatusBarHeight(context);
        ViewGroup.LayoutParams layoutParams2 = _init_$lambda$2.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams3 = _init_$lambda$2.getLayoutParams();
            int i3 = layoutParams3 != null ? layoutParams3.width : -2;
            ViewGroup.LayoutParams layoutParams4 = _init_$lambda$2.getLayoutParams();
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, layoutParams4 != null ? layoutParams4.height : -2);
        }
        if (statusBarHeight != marginLayoutParams.topMargin) {
            marginLayoutParams.topMargin = statusBarHeight;
            _init_$lambda$2.setLayoutParams(marginLayoutParams);
        }
        int dip2px = ViewUtils.dip2px(24.0f);
        ViewGroup.LayoutParams layoutParams5 = _init_$lambda$2.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams5 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams5 : null;
        if (marginLayoutParams2 == null) {
            ViewGroup.LayoutParams layoutParams6 = _init_$lambda$2.getLayoutParams();
            int i16 = layoutParams6 != null ? layoutParams6.width : -2;
            ViewGroup.LayoutParams layoutParams7 = _init_$lambda$2.getLayoutParams();
            marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i16, layoutParams7 != null ? layoutParams7.height : -2);
        }
        if (dip2px != marginLayoutParams2.rightMargin) {
            marginLayoutParams2.rightMargin = dip2px;
            _init_$lambda$2.setLayoutParams(marginLayoutParams2);
        }
        this.iconView = _init_$lambda$2;
        addView(_init_$lambda$2);
        post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.ui.e
            @Override // java.lang.Runnable
            public final void run() {
                MiniIconFlingAnimView._init_$lambda$4(MiniIconFlingAnimView.this);
            }
        });
    }
}
