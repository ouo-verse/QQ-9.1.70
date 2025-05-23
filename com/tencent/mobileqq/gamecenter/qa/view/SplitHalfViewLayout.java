package com.tencent.mobileqq.gamecenter.qa.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SplitHalfViewLayout extends FrameLayout {
    public SplitHalfViewLayout(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19 = i17 - i3;
        int i26 = i18 - i16;
        if (getChildCount() == 2) {
            int i27 = i19 / 2;
            getChildAt(0).layout(0, 0, i27, i26);
            getChildAt(1).layout(i27, 0, i19, i26);
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int childMeasureSpec;
        int childMeasureSpec2;
        super.onMeasure(i3, i16);
        int childCount = getChildCount();
        if (childCount == 2) {
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = getChildAt(i17);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int i18 = marginLayoutParams.width;
                if (i18 == -1) {
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredWidth() - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin) / 2, 1073741824);
                } else {
                    childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, i18);
                }
                int i19 = marginLayoutParams.height;
                if (i19 == -1) {
                    childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredHeight() - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824);
                } else {
                    childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i16, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, i19);
                }
                childAt.measure(childMeasureSpec, childMeasureSpec2);
            }
        }
    }

    public SplitHalfViewLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplitHalfViewLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
