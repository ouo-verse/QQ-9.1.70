package com.tencent.biz.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MultiLineLayout extends ViewGroup {

    /* renamed from: d, reason: collision with root package name */
    private int f96986d;

    /* renamed from: e, reason: collision with root package name */
    private int f96987e;

    /* renamed from: f, reason: collision with root package name */
    private int f96988f;

    /* renamed from: h, reason: collision with root package name */
    private int f96989h;

    /* renamed from: i, reason: collision with root package name */
    private float f96990i;

    /* renamed from: m, reason: collision with root package name */
    int f96991m;

    public MultiLineLayout(Context context) {
        super(context);
        this.f96988f = 0;
        this.f96989h = -1;
    }

    private void a(Context context) {
        float f16 = context.getResources().getDisplayMetrics().density;
        this.f96990i = f16;
        this.f96991m = (int) (f16 * 5.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int childCount = getChildCount();
        if (childCount > 0) {
            i19 = 1;
        } else {
            i19 = 0;
        }
        this.f96988f = i19;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        for (int i29 = 0; i29 < childCount; i29++) {
            View childAt = getChildAt(i29);
            int i36 = this.f96989h;
            if ((i36 == -1 || this.f96988f <= i36) && childAt.getVisibility() != 8) {
                childAt.setVisibility(0);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i37 = i28 + measuredWidth;
                int i38 = this.f96991m + i37;
                if (i38 <= this.f96986d) {
                    childAt.layout(i28, i26, i37, i26 + measuredHeight);
                    i27 = (int) Math.max(i27, measuredHeight + (this.f96990i * 5.0f));
                    i28 = i38;
                } else {
                    int i39 = this.f96988f + 1;
                    this.f96988f = i39;
                    int i46 = this.f96989h;
                    if (i46 != -1 && i39 > i46) {
                        childAt.setVisibility(8);
                    } else {
                        i26 += i27;
                        childAt.layout(0, i26, measuredWidth, i26 + measuredHeight);
                    }
                    i28 = this.f96991m + measuredWidth;
                    i27 = (int) (measuredHeight + (this.f96990i * 5.0f));
                }
            } else {
                childAt.setVisibility(8);
            }
        }
        this.f96987e = i26 + i27;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        this.f96986d = View.MeasureSpec.getSize(i3);
        measureChildren(i3, i16);
        int childCount = getChildCount();
        if (childCount > 0) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        this.f96988f = i17;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        for (int i37 = 0; i37 < childCount; i37++) {
            View childAt = getChildAt(i37);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight();
                int i38 = this.f96989h;
                if (i38 != -1 && this.f96988f > i38) {
                    break;
                }
                int measuredWidth = childAt.getMeasuredWidth();
                int i39 = this.f96991m;
                int i46 = i29 + measuredWidth + i39;
                if (i46 <= this.f96986d) {
                    int max = (int) Math.max(i36, measuredHeight + (this.f96990i * 5.0f));
                    i19 = i46;
                    i26 = max;
                    i18 = i27;
                } else {
                    int i47 = this.f96988f + 1;
                    this.f96988f = i47;
                    int i48 = this.f96989h;
                    if (i48 == -1 || i47 <= i48) {
                        i27 += i36;
                    }
                    int i49 = i39 + measuredWidth;
                    i18 = i27;
                    i19 = i49;
                    i26 = measuredHeight;
                }
                int i56 = i18;
                i28 = i27 + measuredHeight;
                i27 = i56;
                int i57 = i19;
                i36 = i26;
                i29 = i57;
            }
        }
        setMeasuredDimension(this.f96986d, i28);
    }

    public void setShowLine(int i3) {
        this.f96989h = i3;
    }

    public MultiLineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f96988f = 0;
        this.f96989h = -1;
        a(context);
    }

    public MultiLineLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f96988f = 0;
        this.f96989h = -1;
        a(context);
    }
}
