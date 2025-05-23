package com.tencent.sqshow.zootopia.card.view.floatbanner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.sqshow.zootopia.card.view.floatbanner.ImageIndicator;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.BaseImageIndicator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u001b\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u0016\u0010\u001aB#\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001b\u001a\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014J0\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0014J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/floatbanner/ImageIndicator;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/BaseImageIndicator;", "Landroid/widget/ImageView;", "iv", "", "isSelected", "", "j", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "l", "t", "r", "b", "onLayout", "f", "g", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ImageIndicator extends BaseImageIndicator {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageIndicator(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ImageIndicator this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int indicatorSize = this$0.e().getIndicatorSize();
        int i3 = 0;
        while (i3 < indicatorSize) {
            View childAt = this$0.getChildAt(i3);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            this$0.j((ImageView) childAt, this$0.e().getCurrentPosition() == i3);
            i3++;
        }
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.indicator.BaseImageIndicator
    public void f() {
        removeAllViews();
        int indicatorSize = e().getIndicatorSize();
        int i3 = 0;
        while (i3 < indicatorSize) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new LinearLayout.LayoutParams(e().getNormalWidth(), e().getHeight()));
            j(imageView, e().getCurrentPosition() == i3);
            addView(imageView);
            i3++;
        }
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.indicator.BaseImageIndicator
    public void g() {
        post(new Runnable() { // from class: n84.c
            @Override // java.lang.Runnable
            public final void run() {
                ImageIndicator.i(ImageIndicator.this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        super.onLayout(changed, l3, t16, r16, b16);
        int childCount = getChildCount();
        int measuredWidth = childCount > 1 ? (getMeasuredWidth() - (getChildCount() * getChildAt(0).getMeasuredWidth())) / (childCount - 1) : 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            int height = ((getHeight() - childAt.getMeasuredHeight()) / 2) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int measuredHeight = childAt.getMeasuredHeight() + height;
            int measuredWidth2 = (childAt.getMeasuredWidth() + measuredWidth) * i3;
            childAt.layout(measuredWidth2, height, childAt.getMeasuredWidth() + measuredWidth2, measuredHeight);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int indicatorSize = e().getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        int i3 = indicatorSize - 1;
        setMeasuredDimension((e().getIndicatorSpace() * i3) + e().getNormalWidth() + (e().getNormalWidth() * i3), e().getHeight());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void j(ImageView iv5, boolean isSelected) {
        if (isSelected) {
            iv5.setBackgroundResource(getHelper().getSelectedDrawableRes());
        } else {
            iv5.setBackgroundResource(getHelper().getUnSelectedDrawableRes());
        }
    }
}
