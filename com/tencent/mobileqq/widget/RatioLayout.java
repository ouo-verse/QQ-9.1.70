package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RatioLayout extends ViewGroup {

    /* renamed from: d, reason: collision with root package name */
    boolean f316149d;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public float f316150a;

        /* renamed from: b, reason: collision with root package name */
        public float f316151b;

        /* renamed from: c, reason: collision with root package name */
        public float f316152c;

        /* renamed from: d, reason: collision with root package name */
        public float f316153d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i3, int i16, float f16, float f17) {
            this(i3, i16, 0.0f, 0.0f, f16, f17);
        }

        public LayoutParams(int i3, int i16, float f16, float f17, float f18, float f19) {
            super(i3, i16);
            this.f316152c = f16;
            this.f316153d = f17;
            this.f316150a = f18;
            this.f316151b = f19;
        }
    }

    public RatioLayout(Context context) {
        super(context);
        this.f316149d = false;
    }

    public void a(View view, int i3, int i16) {
        float f16;
        float f17;
        if (view != null && view.getParent() == this) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams != null) {
                f16 = layoutParams.f316152c;
                f17 = layoutParams.f316153d;
            } else {
                f16 = 0.0f;
                f17 = 0.0f;
            }
            view.offsetLeftAndRight((i3 - ((int) (f16 * view.getWidth()))) - view.getLeft());
            view.offsetTopAndBottom((i16 - ((int) (f17 * view.getHeight()))) - view.getTop());
        }
    }

    public void b(View view, float f16, float f17) {
        a(view, (int) (f16 * getWidth()), (int) (f17 * getHeight()));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 0.0f, 0.0f);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int paddingLeft = (getPaddingLeft() + ((int) (layoutParams.f316150a * getMeasuredWidth()))) - ((int) (layoutParams.f316152c * measuredWidth));
                int paddingTop = (getPaddingTop() + ((int) (layoutParams.f316151b * getMeasuredHeight()))) - ((int) (layoutParams.f316153d * measuredHeight));
                childAt.layout(paddingLeft, paddingTop, measuredWidth + paddingLeft, measuredHeight + paddingTop);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int childCount = getChildCount();
        if (this.f316149d) {
            super.onMeasure(i3, i16);
            return;
        }
        measureChildren(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i26 = (((int) (layoutParams.f316150a * size)) - ((int) (layoutParams.f316152c * measuredWidth))) + measuredWidth;
                int i27 = (((int) (layoutParams.f316151b * size2)) - ((int) (layoutParams.f316153d * measuredHeight))) + measuredHeight;
                i17 = Math.max(i17, i26);
                i18 = Math.max(i18, i27);
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(i17 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3), View.resolveSize(Math.max(i18 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i16));
    }

    public void setSkipMeasure(boolean z16) {
        this.f316149d = z16;
    }

    public RatioLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316149d = false;
    }

    public RatioLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316149d = false;
    }
}
