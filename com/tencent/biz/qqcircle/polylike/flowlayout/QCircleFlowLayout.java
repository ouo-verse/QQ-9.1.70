package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFlowLayout extends ViewGroup {

    /* renamed from: d, reason: collision with root package name */
    protected List<List<View>> f91592d;

    /* renamed from: e, reason: collision with root package name */
    protected List<Integer> f91593e;

    /* renamed from: f, reason: collision with root package name */
    protected List<Integer> f91594f;

    /* renamed from: h, reason: collision with root package name */
    private int f91595h;

    /* renamed from: i, reason: collision with root package name */
    private List<View> f91596i;

    public QCircleFlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f91592d = new ArrayList();
        this.f91593e = new ArrayList();
        this.f91594f = new ArrayList();
        this.f91596i = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.U5);
        obtainStyledAttributes.getInt(y91.a.W5, -1);
        this.f91595h = -1;
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        this.f91592d.clear();
        this.f91593e.clear();
        this.f91594f.clear();
        this.f91596i.clear();
        int width = getWidth();
        int childCount = getChildCount();
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt = getChildAt(i27);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i26 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.f91593e.add(Integer.valueOf(i19));
                    this.f91592d.add(this.f91596i);
                    this.f91594f.add(Integer.valueOf(i26));
                    i19 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.f91596i = new ArrayList();
                    i26 = 0;
                }
                i26 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i19 = Math.max(i19, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                this.f91596i.add(childAt);
            }
        }
        this.f91593e.add(Integer.valueOf(i19));
        this.f91594f.add(Integer.valueOf(i26));
        this.f91592d.add(this.f91596i);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f91592d.size();
        for (int i28 = 0; i28 < size; i28++) {
            this.f91596i = this.f91592d.get(i28);
            int intValue = this.f91593e.get(i28).intValue();
            int intValue2 = this.f91594f.get(i28).intValue();
            int i29 = this.f91595h;
            if (i29 == -1) {
                paddingLeft = getPaddingLeft();
            } else if (i29 == 0) {
                paddingLeft = ((width - intValue2) / 2) + getPaddingLeft();
            } else if (i29 == 1) {
                paddingLeft = (width - (intValue2 + getPaddingLeft())) - getPaddingRight();
                Collections.reverse(this.f91596i);
            }
            for (int i36 = 0; i36 < this.f91596i.size(); i36++) {
                View view = this.f91596i.get(i36);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i37 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i38 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i37, i38, view.getMeasuredWidth() + i37, view.getMeasuredHeight() + i38);
                    paddingLeft += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingTop += intValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        int paddingTop;
        int i17;
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode2 = View.MeasureSpec.getMode(i16);
        int childCount = getChildCount();
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        while (i18 < childCount) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() == 8) {
                if (i18 == childCount - 1) {
                    i19 = Math.max(i26, i19);
                    i28 += i27;
                }
                i17 = size2;
            } else {
                measureChild(childAt, i3, i16);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i17 = size2;
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i29 = i26 + measuredWidth;
                if (i29 > (size - getPaddingLeft()) - getPaddingRight()) {
                    i19 = Math.max(i19, i26);
                    i28 += i27;
                } else {
                    measuredHeight = Math.max(i27, measuredHeight);
                    measuredWidth = i29;
                }
                if (i18 == childCount - 1) {
                    i19 = Math.max(measuredWidth, i19);
                    i28 += measuredHeight;
                }
                i27 = measuredHeight;
                i26 = measuredWidth;
            }
            i18++;
            size2 = i17;
        }
        int i36 = size2;
        if (mode != 1073741824) {
            size = getPaddingRight() + i19 + getPaddingLeft();
        }
        if (mode2 == 1073741824) {
            paddingTop = i36;
        } else {
            paddingTop = i28 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, paddingTop);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public QCircleFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleFlowLayout(Context context) {
        this(context, null);
    }
}
