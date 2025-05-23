package com.tencent.state.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0014J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/view/SquareTabLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareTabLayout extends ViewGroup {
    private static final String TAG = "MayKnowTabLayout";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareTabLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        super.measureChildren(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        int i3 = 0;
        int i16 = 0;
        while (i3 < childCount) {
            View childView = getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childView, "childView");
            int measuredWidth = childView.getMeasuredWidth() + childView.getPaddingLeft() + childView.getPaddingRight() + i16;
            if (measuredWidth > size) {
                break;
            }
            i3++;
            i16 = measuredWidth;
        }
        int min = Math.min(i16, size);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                size2 = getPaddingBottom() + getPaddingTop() + 0;
                if (childAt != null) {
                    size2 += childAt.getMeasuredHeight();
                }
            } else {
                size2 = 0;
            }
        }
        super.setMeasuredDimension(min, size2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        int paddingLeft = ((r16 - l3) - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childView = getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childView, "childView");
            if (childView.getVisibility() != 8) {
                int measuredWidth = childView.getMeasuredWidth();
                int measuredHeight = childView.getMeasuredHeight();
                int i16 = paddingLeft2 + measuredWidth;
                if (i16 > paddingLeft) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = childView.getLayoutParams();
                if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
                    layoutParams = null;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                int i17 = layoutParams2 != null ? layoutParams2.rightMargin : 0;
                childView.layout(paddingLeft2, paddingTop, i16, measuredHeight + paddingTop);
                paddingLeft2 = measuredWidth + i17 + paddingLeft2;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareTabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
