package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\u0006R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u001b\u0010\u001a\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerProgressBar;", "Landroid/widget/RelativeLayout;", "", "width", "current", "total", "", "i", "", "needAnimator", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "g", "f", "l", "d", "I", "barMinWidth", "e", "currentProgress", "curBarWidth", h.F, "contentViewWidth", "Landroid/view/View;", "Lkotlin/Lazy;", "()Landroid/view/View;", "contentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeFlowerProgressBar extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int barMinWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int currentProgress;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int curBarWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int contentViewWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy contentView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniHomeFlowerProgressBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final View e() {
        Object value = this.contentView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-contentView>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MiniHomeFlowerProgressBar this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.contentViewWidth != 0) {
            return;
        }
        int width = this$0.e().getWidth();
        this$0.contentViewWidth = width;
        this$0.i(width, i3, i16);
        this$0.l(i3, i16, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ImageView imageView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "imageView.layoutParams");
        layoutParams.width = intValue;
        imageView.setLayoutParams(layoutParams);
    }

    private final void m(int current, final int total, boolean needAnimator) {
        final TextView textView = (TextView) e().findViewById(R.id.qe_);
        if (needAnimator) {
            final ValueAnimator ofInt = ValueAnimator.ofInt(this.currentProgress, current);
            ofInt.setDuration(current - this.currentProgress < 10 ? 200L : 1000L);
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MiniHomeFlowerProgressBar.n(ofInt, total, textView, valueAnimator);
                }
            });
            ofInt.start();
            return;
        }
        if (textView == null) {
            return;
        }
        textView.setText(current + " / " + total);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ValueAnimator valueAnimator, int i3, TextView textView, ValueAnimator valueAnimator2) {
        String str = valueAnimator.getAnimatedValue() + " / " + i3;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    /* renamed from: f, reason: from getter */
    public final int getCurrentProgress() {
        return this.currentProgress;
    }

    public final void l(int current, int total, boolean needAnimator) {
        QLog.i("MiniHomeFlowerProgressBar", 1, "updateProgress  " + current + ", " + total + ", " + needAnimator);
        if (current <= 0) {
            ImageView imageView = (ImageView) e().findViewById(R.id.qe5);
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = (ImageView) e().findViewById(R.id.qe5);
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        m(current, total, needAnimator);
        j(current, total, needAnimator);
        this.currentProgress = current;
        QLog.i("MiniHomeFlowerProgressBar", 1, "currentProgress  " + current);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniHomeFlowerProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MiniHomeFlowerProgressBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void j(int current, int total, boolean needAnimator) {
        final ImageView imageView;
        if (total <= 0 || e().getWidth() == 0 || (imageView = (ImageView) e().findViewById(R.id.qe5)) == null) {
            return;
        }
        float f16 = current / total;
        int i3 = this.curBarWidth;
        float max = Math.max(e().getWidth() * f16, this.barMinWidth);
        QLog.i("MiniHomeFlowerProgressBar", 1, "updateBarWithAnimation  " + current + ", " + total + ", " + needAnimator);
        QLog.i("MiniHomeFlowerProgressBar", 1, "updateBarWithAnimation  percentage: " + f16 + ", initialWidth: " + i3 + ", targetWidth: " + max);
        if (needAnimator) {
            ValueAnimator ofInt = ValueAnimator.ofInt(i3, (int) max);
            ofInt.setDuration(1000L);
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MiniHomeFlowerProgressBar.k(imageView, valueAnimator);
                }
            });
            ofInt.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "imageView.layoutParams");
        layoutParams.width = (int) max;
        imageView.setLayoutParams(layoutParams);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeFlowerProgressBar(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        int dpToPx = ViewUtils.dpToPx(20.0f);
        this.barMinWidth = dpToPx;
        this.curBarWidth = dpToPx;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.MiniHomeFlowerProgressBar$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return LayoutInflater.from(context).inflate(R.layout.ddb, this);
            }
        });
        this.contentView = lazy;
    }

    public final void g(final int current, final int total) {
        if (total <= 0) {
            return;
        }
        TextView textView = (TextView) e().findViewById(R.id.qe_);
        if (textView != null) {
            textView.setText(current + " / " + total);
        }
        try {
            int i3 = this.contentViewWidth;
            if (i3 != 0) {
                i(i3, current, total);
            }
            e().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.e
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    MiniHomeFlowerProgressBar.h(MiniHomeFlowerProgressBar.this, current, total);
                }
            });
        } catch (Exception e16) {
            QLog.e("MiniHomeFlowerProgressBar", 1, "initProgress error", e16);
        }
    }

    private final void i(int width, int current, int total) {
        int max = Math.max((int) (width * (current / total)), this.barMinWidth);
        View findViewById = e().findViewById(R.id.qe5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.progress_bar_image)");
        ImageView imageView = (ImageView) findViewById;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "imageView.layoutParams");
        layoutParams.width = max;
        imageView.setLayoutParams(layoutParams);
        this.curBarWidth = max;
    }

    public final void d() {
    }
}
