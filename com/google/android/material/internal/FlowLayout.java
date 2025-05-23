package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: d, reason: collision with root package name */
    private int f33754d;

    /* renamed from: e, reason: collision with root package name */
    private int f33755e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33756f;

    /* renamed from: h, reason: collision with root package name */
    private int f33757h;

    public FlowLayout(@NonNull Context context) {
        this(context, null);
    }

    private static int a(int i3, int i16, int i17) {
        if (i16 != Integer.MIN_VALUE) {
            if (i16 != 1073741824) {
                return i17;
            }
            return i3;
        }
        return Math.min(i17, i3);
    }

    private void e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, w0.a.j3, 0, 0);
        this.f33754d = obtainStyledAttributes.getDimensionPixelSize(w0.a.l3, 0);
        this.f33755e = obtainStyledAttributes.getDimensionPixelSize(w0.a.k3, 0);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return this.f33757h;
    }

    public int c(@NonNull View view) {
        Object tag = view.getTag(R.id.f785347b);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    public boolean d() {
        return this.f33756f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i3) {
        this.f33755e = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i3) {
        this.f33754d = i3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        boolean z17;
        int paddingLeft;
        int paddingRight;
        int i19;
        int i26;
        if (getChildCount() == 0) {
            this.f33757h = 0;
            return;
        }
        this.f33757h = 1;
        if (ViewCompat.getLayoutDirection(this) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (z17) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int i27 = (i17 - i3) - paddingRight;
        int i28 = paddingLeft;
        int i29 = paddingTop;
        for (int i36 = 0; i36 < getChildCount(); i36++) {
            View childAt = getChildAt(i36);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.f785347b, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i26 = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    i19 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    i19 = 0;
                    i26 = 0;
                }
                int measuredWidth = i28 + i26 + childAt.getMeasuredWidth();
                if (!this.f33756f && measuredWidth > i27) {
                    i29 = this.f33754d + paddingTop;
                    this.f33757h++;
                    i28 = paddingLeft;
                }
                childAt.setTag(R.id.f785347b, Integer.valueOf(this.f33757h - 1));
                int i37 = i28 + i26;
                int measuredWidth2 = childAt.getMeasuredWidth() + i37;
                int measuredHeight = childAt.getMeasuredHeight() + i29;
                if (z17) {
                    childAt.layout(i27 - measuredWidth2, i29, (i27 - i28) - i26, measuredHeight);
                } else {
                    childAt.layout(i37, i29, measuredWidth2, measuredHeight);
                }
                i28 += i26 + i19 + childAt.getMeasuredWidth() + this.f33755e;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode2 = View.MeasureSpec.getMode(i16);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            i17 = Integer.MAX_VALUE;
        } else {
            i17 = size;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i17 - getPaddingRight();
        int i27 = paddingTop;
        int i28 = 0;
        for (int i29 = 0; i29 < getChildCount(); i29++) {
            View childAt = getChildAt(i29);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i16);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i18 = marginLayoutParams.leftMargin + 0;
                    i19 = marginLayoutParams.rightMargin + 0;
                } else {
                    i18 = 0;
                    i19 = 0;
                }
                int i36 = paddingLeft;
                if (paddingLeft + i18 + childAt.getMeasuredWidth() > paddingRight && !d()) {
                    i26 = getPaddingLeft();
                    i27 = this.f33754d + paddingTop;
                } else {
                    i26 = i36;
                }
                int measuredWidth = i26 + i18 + childAt.getMeasuredWidth();
                int measuredHeight = i27 + childAt.getMeasuredHeight();
                if (measuredWidth > i28) {
                    i28 = measuredWidth;
                }
                paddingLeft = i26 + i18 + i19 + childAt.getMeasuredWidth() + this.f33755e;
                if (i29 == getChildCount() - 1) {
                    i28 += i19;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i28 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    public void setSingleLine(boolean z16) {
        this.f33756f = z16;
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f33756f = false;
        e(context, attributeSet);
    }
}
