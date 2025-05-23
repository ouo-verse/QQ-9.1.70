package com.qzone.module.feedcomponent.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.adapter.feedcomponent.j;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CustomGridLayout extends ViewGroup {
    public static final int AUTO_FIT = -1;
    public static final int HIDE_DIVIDER_HORIZON = 1;
    public static final int HIDE_DIVIDER_NONE = 0;
    public static final int HIDE_DIVIDER_VIRTICAL = 2;
    public static final int NO_STRETCH = 0;
    public static final int NO_STRETCH_NO_EXCEED = 4;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int STRETCH_COLUMN_WIDTH = 2;
    public static final int STRETCH_SPACING = 1;
    public static final int STRETCH_SPACING_UNIFORM = 3;
    int mColumnWidth;
    Drawable mDivider;
    int mDividerColor;
    int mDividerHeight;
    int mDividerHide;
    Paint mDividerPaint;
    int mDividerWidth;
    boolean mFixLastRowDivider;
    int mHorizontalSpacing;
    int mNumColumns;
    int mRequestedColumnWidth;
    int mRequestedHorizontalSpacing;
    int mRequestedNumColumns;
    int mShowDividers;
    int mStretchMode;
    int mVerticalSpacing;

    /* compiled from: P */
    /* loaded from: classes39.dex */
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

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public CustomGridLayout(Context context) {
        this(context, null);
    }

    static int ceil(float f16) {
        int i3 = (int) f16;
        if (f16 != i3) {
            return i3 + 1;
        }
        return i3;
    }

    public void attachRecycleableView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null && (layoutParams = generateDefaultLayoutParams()) == null) {
            throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
        }
        attachRecycleableView(view, -1, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    boolean determineColumns(int i3) {
        int i16 = this.mRequestedHorizontalSpacing;
        int i17 = this.mStretchMode;
        int i18 = this.mRequestedColumnWidth;
        int i19 = this.mRequestedNumColumns;
        if (i19 != -1) {
            this.mNumColumns = i19;
        } else if (i18 > 0) {
            this.mNumColumns = (i3 + i16) / (i18 + i16);
        } else {
            this.mNumColumns = 2;
        }
        if (this.mNumColumns <= 0) {
            this.mNumColumns = 1;
        }
        if (i17 == 0) {
            this.mColumnWidth = i18;
            this.mHorizontalSpacing = i16;
        } else if (i17 != 4) {
            int i26 = this.mNumColumns;
            int i27 = (i3 - (i26 * i18)) - ((i26 - 1) * i16);
            r3 = i27 < 0;
            if (i17 == 1) {
                this.mColumnWidth = i18;
                if (i26 > 1) {
                    this.mHorizontalSpacing = i16 + (i27 / (i26 - 1));
                } else {
                    this.mHorizontalSpacing = i16 + i27;
                }
            } else if (i17 == 2) {
                this.mColumnWidth = i18 + (i27 / i26);
                this.mHorizontalSpacing = i16;
            } else if (i17 == 3) {
                this.mColumnWidth = i18;
                if (i26 > 1) {
                    this.mHorizontalSpacing = i16 + (i27 / (i26 + 1));
                } else {
                    this.mHorizontalSpacing = i16 + i27;
                }
            }
        } else {
            int i28 = this.mNumColumns;
            int i29 = (i3 - ((i28 - 1) * i16)) / i28;
            if (i18 > i29) {
                i18 = i29;
            }
            this.mColumnWidth = i18;
            this.mHorizontalSpacing = i16;
        }
        return r3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        drawDividerInner(canvas);
    }

    void drawHorizontalDividerInner(Canvas canvas, int i3, int i16, int i17) {
        Drawable drawable = this.mDivider;
        if (drawable != null) {
            drawable.setBounds(i16, i3, i17 + i16, this.mDividerHeight + i3);
            this.mDivider.draw(canvas);
        } else {
            canvas.drawRect(i16, i3, i16 + i17, i3 + this.mDividerHeight, this.mDividerPaint);
        }
    }

    void drawVerticalDividerInner(Canvas canvas, int i3, int i16, int i17) {
        this.mDivider.setBounds(i16, i3, this.mDividerWidth + i16, i17 + i3);
        this.mDivider.draw(canvas);
    }

    void fixLastRowDivider(Canvas canvas, int i3) {
        int i16;
        int childCount;
        int childCount2;
        if (!this.mFixLastRowDivider || i3 <= 1 || (childCount2 = (childCount = getChildCount()) % (i16 = this.mNumColumns)) == 0) {
            return;
        }
        View childAt = getChildAt(childCount - 1);
        int paddingLeft = getPaddingLeft();
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i17 = paddingLeft + ((this.mHorizontalSpacing + measuredWidth) * childCount2);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        int i18 = (i17 - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerWidth;
        int top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (this.mDividerHide != 2) {
            drawVerticalDividerInner(canvas, top, i18, measuredHeight);
        }
        if (this.mDividerHide != 1) {
            while (childCount2 < i16) {
                drawHorizontalDividerInner(canvas, (childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mDividerHeight, i17 - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, measuredWidth);
                i17 += this.mHorizontalSpacing + measuredWidth;
                childCount2++;
            }
        }
    }

    public int getColumnWidth() {
        return this.mColumnWidth;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getHorizontalSpacing() {
        return this.mHorizontalSpacing;
    }

    public int getNumColumns() {
        return this.mNumColumns;
    }

    public int getRequestedHorizontalSpacing() {
        return this.mRequestedHorizontalSpacing;
    }

    public int getRequestedNumColumns() {
        return this.mRequestedNumColumns;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public int getStretchMode() {
        return this.mStretchMode;
    }

    public int getVerticalSpacing() {
        return this.mVerticalSpacing;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (childCount > 0) {
            int i19 = this.mNumColumns;
            int i26 = paddingLeft;
            int i27 = 0;
            int i28 = 0;
            for (int i29 = 0; i29 < childCount; i29++) {
                View childAt = getChildAt(i29);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(i26, paddingTop, i26 + measuredWidth, paddingTop + measuredHeight);
                    if (i27 < measuredHeight) {
                        i27 = measuredHeight;
                    }
                    i26 += measuredWidth + this.mHorizontalSpacing;
                    i28++;
                    if (i28 >= i19) {
                        paddingTop += this.mVerticalSpacing + i27;
                        i26 = paddingLeft;
                        i28 = 0;
                    }
                }
            }
        }
    }

    final void requestLayoutIfNecessary() {
        if (getChildCount() > 0) {
            requestLayout();
            invalidate();
        }
    }

    public void setColumnWidth(int i3) {
        if (i3 != this.mRequestedColumnWidth) {
            this.mRequestedColumnWidth = i3;
            requestLayoutIfNecessary();
        }
    }

    public void setDividerColor(int i3) {
        float f16 = getResources().getDisplayMetrics().density * 1.0f;
        setDividerColor(i3, ceil(f16), ceil(f16));
    }

    public void setFixLastRowDivider(boolean z16) {
        this.mFixLastRowDivider = z16;
    }

    public void setHideDividers(int i3) {
        if (this.mDividerHide != i3) {
            requestLayout();
        }
        this.mDividerHide = i3;
    }

    public void setHorizontalSpacing(int i3) {
        if (i3 != this.mRequestedHorizontalSpacing) {
            this.mRequestedHorizontalSpacing = i3;
            requestLayoutIfNecessary();
        }
    }

    public void setNumColumns(int i3) {
        if (i3 != this.mRequestedNumColumns) {
            this.mRequestedNumColumns = i3;
            requestLayoutIfNecessary();
        }
    }

    public void setShowDividers(int i3) {
        if (i3 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i3;
    }

    public void setStretchMode(int i3) {
        if (i3 != this.mStretchMode) {
            this.mStretchMode = i3;
            requestLayoutIfNecessary();
        }
    }

    public void setVerticalSpacing(int i3) {
        if (i3 != this.mVerticalSpacing) {
            this.mVerticalSpacing = i3;
            requestLayoutIfNecessary();
        }
    }

    public CustomGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public CustomGridLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mNumColumns = -1;
        this.mStretchMode = 2;
        this.mShowDividers = 0;
        this.mFixLastRowDivider = true;
        this.mDividerHide = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, (int[]) j.L(1639), i3, 0);
        setHorizontalSpacing(obtainStyledAttributes.getDimensionPixelOffset(((Integer) j.L(1640)).intValue(), 0));
        setVerticalSpacing(obtainStyledAttributes.getDimensionPixelOffset(((Integer) j.L(1641)).intValue(), 0));
        int i16 = obtainStyledAttributes.getInt(((Integer) j.L(1642)).intValue(), 2);
        if (i16 >= 0) {
            setStretchMode(i16);
        }
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(((Integer) j.L(1643)).intValue(), -1);
        if (dimensionPixelOffset > 0) {
            setColumnWidth(dimensionPixelOffset);
        }
        setNumColumns(obtainStyledAttributes.getInt(((Integer) j.L(1644)).intValue(), 1));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        boolean z16;
        int i19;
        int i26;
        int i27;
        int paddingTop;
        boolean z17;
        int i28;
        int i29;
        int i36;
        int i37;
        int paddingLeft;
        int paddingRight;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode == 0) {
            int i38 = this.mColumnWidth;
            if (i38 > 0) {
                paddingLeft = i38 + getPaddingLeft();
                paddingRight = getPaddingRight();
            } else {
                paddingLeft = getPaddingLeft();
                paddingRight = getPaddingRight();
            }
            size = paddingLeft + paddingRight + getVerticalScrollbarWidth();
        }
        int paddingLeft2 = (size - getPaddingLeft()) - getPaddingRight();
        boolean determineColumns = determineColumns(paddingLeft2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int i39 = this.mNumColumns;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i56 = 0;
            while (i47 < childCount) {
                View childAt = getChildAt(i47);
                int i57 = size2;
                if (childAt.getVisibility() == 8) {
                    i28 = size;
                    i36 = paddingLeft2;
                    z17 = determineColumns;
                } else {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = generateDefaultLayoutParams();
                        childAt.setLayoutParams(layoutParams);
                    }
                    int i58 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    int i59 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    z17 = determineColumns;
                    i28 = size;
                    if (this.mStretchMode != 4 || (((i58 <= (i37 = this.mColumnWidth) || childCount <= 1) && i58 <= paddingLeft2) || i58 <= 0)) {
                        i29 = 0;
                    } else {
                        if (i59 > 0) {
                            i59 = (int) ((i37 / i58) * i59);
                        }
                        i29 = 0;
                        i58 = -1;
                    }
                    i36 = paddingLeft2;
                    childAt.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.mColumnWidth, 1073741824), i29, i58), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(i29, i29), i29, i59));
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (i46 < measuredHeight) {
                        i46 = measuredHeight;
                    }
                    i49++;
                    if (i49 >= i39 || i47 == childCount - 1) {
                        i48 += i46;
                        if (i56 > 0) {
                            i48 += this.mVerticalSpacing;
                        }
                        i56++;
                        i46 = i29;
                        i49 = i46;
                    }
                }
                i47++;
                paddingLeft2 = i36;
                size2 = i57;
                determineColumns = z17;
                size = i28;
            }
            i17 = size;
            i18 = size2;
            z16 = determineColumns;
            i19 = i48;
        } else {
            i17 = size;
            i18 = size2;
            z16 = determineColumns;
            i19 = 0;
        }
        int verticalFadingEdgeLength = mode2 == 0 ? (getVerticalFadingEdgeLength() * 2) + getPaddingTop() + getPaddingBottom() + i19 : i18;
        if (mode2 == Integer.MIN_VALUE && verticalFadingEdgeLength > (paddingTop = getPaddingTop() + getPaddingBottom() + i19 + (getVerticalFadingEdgeLength() * 2))) {
            verticalFadingEdgeLength = paddingTop;
        }
        if (mode != Integer.MIN_VALUE || (i27 = this.mRequestedNumColumns) == -1) {
            i26 = i17;
        } else {
            i26 = i17;
            if ((this.mColumnWidth * i27) + ((i27 - 1) * this.mHorizontalSpacing) + getPaddingLeft() + getPaddingRight() > i26 || z16) {
                i26 |= 16777216;
            }
        }
        setMeasuredDimension(i26, verticalFadingEdgeLength);
    }

    public void setDividerColor(int i3, int i16, int i17) {
        if (this.mDividerColor == i3) {
            return;
        }
        this.mDividerColor = i3;
        this.mDivider = new ColorDrawable(this.mDividerColor);
        float f16 = getResources().getDisplayMetrics().density * 1.0f;
        this.mDividerWidth = Math.max(i16, ceil(f16));
        this.mDividerHeight = Math.max(i17, ceil(f16));
        setWillNotDraw(false);
        requestLayout();
    }

    public void detachRecycleableView(View view) {
        if (view == null) {
            return;
        }
        view.onStartTemporaryDetach();
        detachViewFromParent(view);
    }

    public void attachRecycleableView(View view, ViewGroup.LayoutParams layoutParams) {
        attachRecycleableView(view, -1, layoutParams);
    }

    void drawDividerInner(Canvas canvas) {
        int i3;
        if (this.mShowDividers != 0) {
            if (this.mDivider == null && this.mDividerPaint == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            if (childCount > 0) {
                int i16 = this.mNumColumns;
                int ceil = ceil(childCount / i16);
                int i17 = 0;
                while (i17 < ceil) {
                    int i18 = paddingLeft;
                    int i19 = 0;
                    int i26 = 0;
                    while (i19 < i16) {
                        int i27 = (i17 * i16) + i19;
                        if (i27 >= childCount) {
                            break;
                        }
                        View childAt = getChildAt(i27);
                        if (childAt.getVisibility() == 8) {
                            i3 = paddingLeft;
                        } else {
                            int measuredWidth = childAt.getMeasuredWidth();
                            int measuredHeight = childAt.getMeasuredHeight();
                            if (i26 < measuredHeight) {
                                i26 = measuredHeight;
                            }
                            if (this.mDividerHide == 1 || !hasRowDividerBeforeChildAt(i17, i19, ceil)) {
                                i3 = paddingLeft;
                            } else {
                                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                                i3 = paddingLeft;
                                drawHorizontalDividerInner(canvas, (childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mDividerHeight, i18 - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, measuredWidth);
                            }
                            if (this.mDividerHide != 2 && hasColumnDividerBeforeChildAt(i17, i19)) {
                                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                                drawVerticalDividerInner(canvas, paddingTop - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin, (childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) - this.mDividerWidth, measuredHeight);
                            }
                            i18 += measuredWidth + this.mHorizontalSpacing;
                        }
                        i19++;
                        paddingLeft = i3;
                    }
                    paddingTop += i26 + this.mVerticalSpacing;
                    i17++;
                    paddingLeft = paddingLeft;
                }
                fixLastRowDivider(canvas, ceil);
            }
        }
    }

    boolean hasColumnDividerBeforeChildAt(int i3, int i16) {
        return i16 == 0 ? (this.mShowDividers & 1) != 0 : i16 == this.mNumColumns ? (this.mShowDividers & 4) != 0 : (this.mShowDividers & 2) != 0;
    }

    boolean hasRowDividerBeforeChildAt(int i3, int i16, int i17) {
        return i3 == 0 ? (this.mShowDividers & 1) != 0 : i3 == i17 ? (this.mShowDividers & 4) != 0 : (this.mShowDividers & 2) != 0;
    }

    public void attachRecycleableView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        view.onFinishTemporaryDetach();
        attachViewToParent(view, i3, layoutParams);
        requestLayout();
    }
}
