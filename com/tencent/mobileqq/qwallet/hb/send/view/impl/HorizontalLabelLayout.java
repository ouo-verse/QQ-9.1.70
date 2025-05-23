package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HorizontalLabelLayout extends ViewGroup {

    /* renamed from: d, reason: collision with root package name */
    private int f277789d;

    /* renamed from: e, reason: collision with root package name */
    private int f277790e;

    public HorizontalLabelLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        boolean z17;
        int i26 = i17 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int childCount = getChildCount();
        int i27 = 0;
        int i28 = 0;
        boolean z18 = true;
        for (int i29 = 0; i29 < childCount; i29++) {
            View childAt = getChildAt(i29);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                i27 = Math.max(measuredHeight, i27);
                if (z18) {
                    if (i29 > 0) {
                        paddingTop = paddingTop + this.f277789d + i27;
                        i19 = paddingLeft;
                        i27 = measuredHeight;
                    } else {
                        i19 = paddingLeft;
                    }
                } else {
                    i19 = i28 + this.f277790e;
                }
                int i36 = i19 + measuredWidth;
                if (measuredWidth + i36 + paddingRight > i26) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                childAt.layout(i19, paddingTop, i36, measuredHeight + paddingTop);
                i28 = i36;
                z18 = z17;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int resolveSize = View.resolveSize(0, i3);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int childCount = getChildCount();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = paddingTop;
        boolean z16 = true;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i27 = childCount;
            int i28 = resolveSize;
            childAt.measure(ViewGroup.getChildMeasureSpec(i3, paddingLeft + paddingRight, layoutParams.width), ViewGroup.getChildMeasureSpec(i16, paddingTop + paddingBottom, layoutParams.height));
            int measuredWidth = childAt.getMeasuredWidth();
            i18 = Math.max(childAt.getMeasuredHeight(), i18);
            if (z16) {
                int i29 = paddingLeft + measuredWidth + paddingRight;
                if (i17 == 0) {
                    i26 += i18;
                } else {
                    i26 = i26 + i18 + this.f277789d;
                }
                i19 = i29;
            } else {
                i19 = i19 + measuredWidth + this.f277790e;
            }
            if (measuredWidth + i19 > i28) {
                z16 = true;
            } else {
                z16 = false;
            }
            i17++;
            resolveSize = i28;
            childCount = i27;
        }
        setMeasuredDimension(resolveSize, View.resolveSize(i26 + paddingBottom, i16));
    }

    public void setHorizontalSpacing(int i3) {
        this.f277790e = i3;
    }

    public void setVerticalSpacing(int i3) {
        this.f277789d = i3;
    }

    public HorizontalLabelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HorizontalLabelLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
