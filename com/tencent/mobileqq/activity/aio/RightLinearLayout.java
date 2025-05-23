package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RightLinearLayout extends LinearLayout {
    public RightLinearLayout(Context context) {
        super(context);
    }

    private void a(int i3, int i16, int i17, int i18) {
        int i19;
        int paddingTop = getPaddingTop();
        int paddingBottom = ((i18 - i16) - paddingTop) - getPaddingBottom();
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        for (int i26 = childCount - 1; i26 >= 0; i26--) {
            View childAt = getChildAt(i26);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                int i27 = layoutParams.gravity;
                if (i27 < 0) {
                    i27 = 16;
                }
                if ((i27 & 112) != 16) {
                    i19 = paddingTop;
                } else {
                    i19 = ((((paddingBottom - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                }
                int i28 = paddingLeft + layoutParams.leftMargin;
                childAt.layout(i28, i19, i28 + measuredWidth, measuredHeight + i19);
                paddingLeft = i28 + measuredWidth + layoutParams.rightMargin + 0;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (getOrientation() == 1) {
            super.onLayout(z16, i3, i16, i17, i18);
        } else {
            a(i3, i16, i17, i18);
        }
    }

    public RightLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
