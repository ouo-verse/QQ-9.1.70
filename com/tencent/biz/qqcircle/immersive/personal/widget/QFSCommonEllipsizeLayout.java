package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommonEllipsizeLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private final int f89187d;

    /* renamed from: e, reason: collision with root package name */
    private int f89188e;

    /* renamed from: f, reason: collision with root package name */
    private View f89189f;

    public QFSCommonEllipsizeLayout(Context context) {
        this(context, null);
    }

    private void a() {
        View view;
        ViewGroup.LayoutParams layoutParams;
        if (this.f89188e == Integer.MIN_VALUE && (view = this.f89189f) != null && (layoutParams = view.getLayoutParams()) != null) {
            this.f89188e = layoutParams.width;
        }
    }

    private void b() {
        View view;
        ViewGroup.LayoutParams layoutParams;
        if (this.f89188e != Integer.MIN_VALUE && (view = this.f89189f) != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.width = this.f89188e;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        boolean z16;
        if (getOrientation() == 0 && View.MeasureSpec.getMode(i3) == 1073741824 && this.f89187d < getChildCount()) {
            this.f89189f = getChildAt(this.f89187d);
            a();
            int childCount = getChildCount();
            int size = (View.MeasureSpec.getSize(i3) - getPaddingStart()) - getPaddingEnd();
            int i17 = 0;
            int makeMeasureSpec = (View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0) - getPaddingStart()) - getPaddingEnd();
            int i18 = 0;
            boolean z17 = false;
            int i19 = 0;
            while (true) {
                z16 = true;
                if (i18 >= childCount || z17) {
                    break;
                }
                View childAt = getChildAt(i18);
                if (childAt != null && childAt.getVisibility() != 8) {
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i16, 0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    if (layoutParams != null) {
                        i19 += childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        z17 = true;
                    }
                }
                i18++;
            }
            View view = this.f89189f;
            if (view != null && i19 != 0) {
                z16 = false;
            }
            if (!(z17 | z16) && i19 > size) {
                int measuredWidth = view.getMeasuredWidth() - (i19 - size);
                if (measuredWidth >= 0) {
                    i17 = measuredWidth;
                }
                ViewGroup.LayoutParams layoutParams2 = this.f89189f.getLayoutParams();
                layoutParams2.width = i17;
                this.f89189f.setLayoutParams(layoutParams2);
            }
        }
        super.onMeasure(i3, i16);
    }

    public QFSCommonEllipsizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f89188e = Integer.MIN_VALUE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.f449761o6);
        this.f89187d = obtainStyledAttributes.getInteger(y91.a.f449774p6, 0);
        obtainStyledAttributes.recycle();
    }
}
