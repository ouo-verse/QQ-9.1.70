package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BaselineLayout extends ViewGroup {

    /* renamed from: d, reason: collision with root package name */
    private int f33749d;

    public BaselineLayout(Context context) {
        super(context, null, 0);
        this.f33749d = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f33749d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i17 - i3) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt = getChildAt(i26);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i27 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                if (this.f33749d != -1 && childAt.getBaseline() != -1) {
                    i19 = (this.f33749d + paddingTop) - childAt.getBaseline();
                } else {
                    i19 = paddingTop;
                }
                childAt.layout(i27, i19, measuredWidth + i27, measuredHeight + i19);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int childCount = getChildCount();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = -1;
        int i27 = -1;
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt = getChildAt(i28);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i16);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i26 = Math.max(i26, baseline);
                    i27 = Math.max(i27, childAt.getMeasuredHeight() - baseline);
                }
                i18 = Math.max(i18, childAt.getMeasuredWidth());
                i17 = Math.max(i17, childAt.getMeasuredHeight());
                i19 = View.combineMeasuredStates(i19, childAt.getMeasuredState());
            }
        }
        if (i26 != -1) {
            i17 = Math.max(i17, Math.max(i27, getPaddingBottom()) + i26);
            this.f33749d = i26;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i18, getSuggestedMinimumWidth()), i3, i19), View.resolveSizeAndState(Math.max(i17, getSuggestedMinimumHeight()), i16, i19 << 16));
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f33749d = -1;
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f33749d = -1;
    }
}
