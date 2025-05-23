package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class CustomGridLayout extends ViewGroup {
    private int C;
    private int D;
    private Paint E;
    private Drawable F;
    private int G;
    private int H;
    private int I;
    private int J;
    private boolean K;

    /* renamed from: d, reason: collision with root package name */
    private int f60198d;

    /* renamed from: e, reason: collision with root package name */
    private int f60199e;

    /* renamed from: f, reason: collision with root package name */
    private int f60200f;

    /* renamed from: h, reason: collision with root package name */
    private int f60201h;

    /* renamed from: i, reason: collision with root package name */
    private int f60202i;

    /* renamed from: m, reason: collision with root package name */
    private int f60203m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public CustomGridLayout(Context context) {
        this(context, null);
    }

    private static int a(float f16) {
        int i3 = (int) f16;
        if (f16 != i3) {
            return i3 + 1;
        }
        return i3;
    }

    private boolean b(int i3) {
        int i16 = this.C;
        int i17 = this.f60202i;
        int i18 = this.f60200f;
        int i19 = this.f60201h;
        if (i19 != -1) {
            this.f60198d = i19;
        } else if (i18 > 0) {
            this.f60198d = (i3 + i16) / (i18 + i16);
        } else {
            this.f60198d = 2;
        }
        if (this.f60198d <= 0) {
            this.f60198d = 1;
        }
        if (i17 == 0) {
            this.f60199e = i18;
            this.f60203m = i16;
        } else if (i17 != 4) {
            int i26 = this.f60198d;
            int i27 = (i3 - (i26 * i18)) - ((i26 - 1) * i16);
            r3 = i27 < 0;
            if (i17 == 1) {
                this.f60199e = i18;
                if (i26 > 1) {
                    this.f60203m = i16 + (i27 / (i26 - 1));
                } else {
                    this.f60203m = i16 + i27;
                }
            } else if (i17 == 2) {
                this.f60199e = i18 + (i27 / i26);
                this.f60203m = i16;
            } else if (i17 == 3) {
                this.f60199e = i18;
                if (i26 > 1) {
                    this.f60203m = i16 + (i27 / (i26 + 1));
                } else {
                    this.f60203m = i16 + i27;
                }
            }
        } else {
            int i28 = this.f60198d;
            int i29 = (i3 - ((i28 - 1) * i16)) / i28;
            if (i18 > i29) {
                i18 = i29;
            }
            this.f60199e = i18;
            this.f60203m = i16;
        }
        return r3;
    }

    private void d(Canvas canvas, int i3, int i16, int i17) {
        Drawable drawable = this.F;
        if (drawable != null) {
            drawable.setBounds(i16, i3, i17 + i16, this.I + i3);
            this.F.draw(canvas);
        }
    }

    private void e(Canvas canvas, int i3, int i16, int i17) {
        Drawable drawable = this.F;
        if (drawable != null) {
            drawable.setBounds(i16, i3, this.H + i16, i17 + i3);
            this.F.draw(canvas);
        }
    }

    private void f(Canvas canvas, int i3) {
        int i16;
        int childCount;
        int childCount2;
        if (!this.K || i3 <= 1 || (childCount2 = (childCount = getChildCount()) % (i16 = this.f60198d)) == 0) {
            return;
        }
        View childAt = getChildAt(childCount - 1);
        int paddingLeft = getPaddingLeft();
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i17 = paddingLeft + ((this.f60203m + measuredWidth) * childCount2);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        e(canvas, childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i17 - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.H, measuredHeight);
        while (childCount2 < i16) {
            d(canvas, (childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.I, i17 - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, measuredWidth);
            i17 += this.f60203m + measuredWidth;
            childCount2++;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        c(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    final void k() {
        if (getChildCount() > 0) {
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (childCount > 0) {
            int i19 = this.f60198d;
            int a16 = a(childCount / i19);
            for (int i26 = 0; i26 < a16; i26++) {
                int i27 = paddingLeft;
                int i28 = 0;
                for (int i29 = 0; i29 < i19; i29++) {
                    int i36 = (i26 * i19) + i29;
                    if (i36 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i36);
                    if (childAt.getVisibility() != 8) {
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        childAt.layout(i27, paddingTop, i27 + measuredWidth, paddingTop + measuredHeight);
                        if (i28 < measuredHeight) {
                            i28 = measuredHeight;
                        }
                        i27 += measuredWidth + this.f60203m;
                    }
                }
                paddingTop += i28 + this.D;
            }
        }
    }

    public void setColumnWidth(int i3) {
        if (i3 != this.f60200f) {
            this.f60200f = i3;
            k();
        }
    }

    public void setDividerColor(int i3) {
        float f16 = getResources().getDisplayMetrics().density * 1.0f;
        setDividerColor(i3, a(f16), a(f16));
    }

    public void setFixLastRowDivider(boolean z16) {
        this.K = z16;
    }

    public void setHorizontalSpacing(int i3) {
        if (i3 != this.C) {
            this.C = i3;
            k();
        }
    }

    public void setNumColumns(int i3) {
        if (i3 != this.f60201h) {
            this.f60201h = i3;
            k();
        }
    }

    public void setShowDividers(int i3) {
        if (i3 != this.J) {
            requestLayout();
        }
        this.J = i3;
    }

    public void setStretchMode(int i3) {
        if (i3 != this.f60202i) {
            this.f60202i = i3;
            k();
        }
    }

    public void setVerticalSpacing(int i3) {
        if (i3 != this.D) {
            this.D = i3;
            k();
        }
    }

    public CustomGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public CustomGridLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60198d = -1;
        this.f60202i = 2;
        this.f60203m = 0;
        this.D = 0;
        this.J = 0;
        this.K = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomGridLayout, i3, 0);
        setHorizontalSpacing(obtainStyledAttributes.getDimensionPixelOffset(1, 0));
        setVerticalSpacing(obtainStyledAttributes.getDimensionPixelOffset(4, 0));
        int i16 = obtainStyledAttributes.getInt(3, 2);
        if (i16 >= 0) {
            setStretchMode(i16);
        }
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
        if (dimensionPixelOffset > 0) {
            setColumnWidth(dimensionPixelOffset);
        }
        setNumColumns(obtainStyledAttributes.getInt(2, 1));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int paddingTop;
        int i26;
        int i27;
        int i28;
        int i29;
        int paddingLeft;
        int paddingRight;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode == 0) {
            int i36 = this.f60199e;
            if (i36 > 0) {
                paddingLeft = i36 + getPaddingLeft();
                paddingRight = getPaddingRight();
            } else {
                paddingLeft = getPaddingLeft();
                paddingRight = getPaddingRight();
            }
            size = paddingLeft + paddingRight + getVerticalScrollbarWidth();
        }
        int paddingLeft2 = (size - getPaddingLeft()) - getPaddingRight();
        boolean b16 = b(paddingLeft2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int i37 = this.f60198d;
            int a16 = a(childCount / i37);
            int i38 = 0;
            int i39 = 0;
            while (i38 < a16) {
                int i46 = 0;
                int i47 = 0;
                while (i47 < i37) {
                    int i48 = (i38 * i37) + i47;
                    if (i48 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i48);
                    int i49 = size2;
                    if (childAt.getVisibility() == 8) {
                        i28 = paddingLeft2;
                        i26 = i37;
                        i27 = a16;
                    } else {
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = generateDefaultLayoutParams();
                            childAt.setLayoutParams(layoutParams);
                        }
                        int i56 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                        int i57 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                        i26 = i37;
                        i27 = a16;
                        if (this.f60202i == 4 && (((i56 > (i29 = this.f60199e) && childCount > 1) || i56 > paddingLeft2) && i56 > 0)) {
                            if (i57 > 0) {
                                i57 = (int) ((i29 / i56) * i57);
                            }
                            i56 = -1;
                        }
                        i28 = paddingLeft2;
                        childAt.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.f60199e, 1073741824), 0, i56), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, i57));
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (i46 < measuredHeight) {
                            i46 = measuredHeight;
                        }
                    }
                    i47++;
                    paddingLeft2 = i28;
                    size2 = i49;
                    i37 = i26;
                    a16 = i27;
                }
                int i58 = size2;
                int i59 = paddingLeft2;
                int i65 = i37;
                int i66 = a16;
                if (i38 > 0) {
                    i46 += this.D;
                }
                i39 += i46;
                i38++;
                paddingLeft2 = i59;
                size2 = i58;
                i37 = i65;
                a16 = i66;
            }
            i17 = size2;
            i18 = i39;
        } else {
            i17 = size2;
            i18 = 0;
        }
        int paddingTop2 = mode2 == 0 ? getPaddingTop() + getPaddingBottom() + i18 + (getVerticalFadingEdgeLength() * 2) : i17;
        if (mode2 == Integer.MIN_VALUE && paddingTop2 > (paddingTop = getPaddingTop() + getPaddingBottom() + i18 + (getVerticalFadingEdgeLength() * 2))) {
            paddingTop2 = paddingTop;
        }
        if (mode == Integer.MIN_VALUE && (i19 = this.f60201h) != -1 && ((this.f60199e * i19) + ((i19 - 1) * this.f60203m) + getPaddingLeft() + getPaddingRight() > size || b16)) {
            size |= 16777216;
        }
        setMeasuredDimension(size, paddingTop2);
    }

    public void setDividerColor(int i3, int i16, int i17) {
        if (this.G == i3) {
            return;
        }
        this.G = i3;
        this.F = new ColorDrawable(this.G);
        float f16 = getResources().getDisplayMetrics().density * 1.0f;
        this.H = Math.max(i16, a(f16));
        this.I = Math.max(i17, a(f16));
        setWillNotDraw(false);
        requestLayout();
    }

    private void c(Canvas canvas) {
        if (this.J != 0) {
            if (this.F == null && this.E == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            if (childCount > 0) {
                int i3 = this.f60198d;
                int a16 = a(childCount / i3);
                for (int i16 = 0; i16 < a16; i16++) {
                    int i17 = paddingLeft;
                    int i18 = 0;
                    for (int i19 = 0; i19 < i3; i19++) {
                        int i26 = (i16 * i3) + i19;
                        if (i26 >= childCount) {
                            break;
                        }
                        View childAt = getChildAt(i26);
                        if (childAt.getVisibility() != 8) {
                            int measuredWidth = childAt.getMeasuredWidth();
                            int measuredHeight = childAt.getMeasuredHeight();
                            if (i18 < measuredHeight) {
                                i18 = measuredHeight;
                            }
                            if (j(i16, i19, a16)) {
                                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                                d(canvas, (childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.I, i17 - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, measuredWidth);
                            }
                            if (i(i16, i19)) {
                                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                                e(canvas, paddingTop - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin, (childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) - this.H, measuredHeight);
                            }
                            i17 += measuredWidth + this.f60203m;
                        }
                    }
                    paddingTop += i18 + this.D;
                }
                f(canvas, a16);
            }
        }
    }

    private boolean i(int i3, int i16) {
        return i16 == 0 ? (this.J & 1) != 0 : i16 == this.f60198d ? (this.J & 4) != 0 : (this.J & 2) != 0;
    }

    private boolean j(int i3, int i16, int i17) {
        return i3 == 0 ? (this.J & 1) != 0 : i3 == i17 ? (this.J & 4) != 0 : (this.J & 2) != 0;
    }
}
