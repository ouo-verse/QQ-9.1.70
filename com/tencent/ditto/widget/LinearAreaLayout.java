package com.tencent.ditto.widget;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LinearAreaLayout extends DittoAreaGroup {
    private int mGravity;
    private int mOrientation;
    private int mTotalLength;

    public LinearAreaLayout(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mOrientation = 1;
        this.mGravity = 3;
        setOrientation(layoutAttrSet.orientation);
        setGravity(layoutAttrSet.gravity);
    }

    private void layoutChildHorizontal(int i3, int i16, int i17, int i18, int i19, int i26) {
        int i27;
        int i28;
        int i29;
        int weight;
        int i36;
        for (int i37 = 0; i37 < i3; i37++) {
            DittoArea childAt = getChildAt(i37);
            if (childAt.getVisibility() != 8) {
                LayoutAttrSet layoutAttr = childAt.getLayoutAttr();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i38 = layoutAttr.layout_gravity;
                if (i38 != 16) {
                    if (i38 != 48) {
                        if (i38 != 80) {
                            i29 = layoutAttr.topMargin;
                        } else {
                            i27 = i17 - measuredHeight;
                            i28 = layoutAttr.bottomMargin;
                        }
                    } else {
                        i29 = layoutAttr.topMargin;
                    }
                    weight = childAt.getWeight();
                    if (weight <= 0 && i18 > 0 && i19 > 0) {
                        i36 = (weight * i19) / i18;
                        i18 -= weight;
                        i19 -= i36;
                    } else {
                        i36 = 0;
                    }
                    int i39 = i26 + layoutAttr.leftMargin;
                    childAt.layout(i39, i29, i39 + measuredWidth + i36, measuredHeight + i29);
                    i26 = i39 + measuredWidth + i36 + layoutAttr.rightMargin;
                } else {
                    i27 = ((i16 - measuredHeight) / 2) + layoutAttr.topMargin;
                    i28 = layoutAttr.bottomMargin;
                }
                i29 = i27 - i28;
                weight = childAt.getWeight();
                if (weight <= 0) {
                }
                i36 = 0;
                int i392 = i26 + layoutAttr.leftMargin;
                childAt.layout(i392, i29, i392 + measuredWidth + i36, measuredHeight + i29);
                i26 = i392 + measuredWidth + i36 + layoutAttr.rightMargin;
            }
        }
    }

    private void layoutChildVertical(int i3, int i16, int i17, int i18, int i19, int i26) {
        int i27;
        int i28;
        int i29;
        int weight;
        int i36;
        for (int i37 = 0; i37 < i3; i37++) {
            DittoArea childAt = getChildAt(i37);
            if (childAt.getVisibility() != 8) {
                LayoutAttrSet layoutAttr = childAt.getLayoutAttr();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i38 = layoutAttr.layout_gravity;
                if (i38 != 1) {
                    if (i38 != 5) {
                        i29 = layoutAttr.leftMargin;
                        weight = childAt.getWeight();
                        if (weight <= 0 && i18 > 0 && i19 > 0) {
                            i36 = (weight * i19) / i18;
                            i18 -= weight;
                            i19 -= i36;
                        } else {
                            i36 = 0;
                        }
                        int i39 = i26 + layoutAttr.topMargin;
                        childAt.layout(i29, i39, measuredWidth + i29, i39 + measuredHeight + i36);
                        i26 = i39 + measuredHeight + i36 + layoutAttr.bottomMargin;
                    } else {
                        i27 = i17 - measuredWidth;
                        i28 = layoutAttr.rightMargin;
                    }
                } else {
                    i27 = ((i16 - measuredWidth) / 2) + layoutAttr.leftMargin;
                    i28 = layoutAttr.rightMargin;
                }
                i29 = i27 - i28;
                weight = childAt.getWeight();
                if (weight <= 0) {
                }
                i36 = 0;
                int i392 = i26 + layoutAttr.topMargin;
                childAt.layout(i29, i392, measuredWidth + i29, i392 + measuredHeight + i36);
                i26 = i392 + measuredHeight + i36 + layoutAttr.bottomMargin;
            }
        }
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public int getGravity() {
        return this.mGravity;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        if (r2 != 17) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutHorizontal() {
        int i3;
        int paddingTop = getPaddingTop();
        getPaddingLeft();
        int paddingRight = getPaddingRight();
        int height = getHeight();
        int i16 = height - paddingRight;
        int i17 = (height - paddingTop) - paddingRight;
        int i18 = this.mTotalLength;
        int width = getWidth() - i18;
        int childCount = getChildCount();
        int i19 = 0;
        if (width > 0) {
            int i26 = 0;
            for (int i27 = 0; i27 < childCount; i27++) {
                int weight = getChildAt(i27).getWeight();
                if (weight > 0) {
                    i26 += weight;
                }
            }
            if (i26 > 0) {
                i18 = getWidth();
            }
            i3 = i26;
        } else {
            i3 = 0;
        }
        int i28 = this.mGravity;
        if (i28 != 1) {
            if (i28 == 5) {
                i19 = getWidth() - i18;
            }
            layoutChildHorizontal(childCount, i17, i16, i3, width, i19);
        }
        i19 = (getWidth() - i18) / 2;
        layoutChildHorizontal(childCount, i17, i16, i3, width, i19);
    }

    public void layoutVertical() {
        int i3;
        getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        int i16 = width - paddingRight;
        int i17 = (width - paddingLeft) - paddingRight;
        int i18 = this.mTotalLength;
        int height = getHeight() - i18;
        int childCount = getChildCount();
        int i19 = 0;
        if (height > 0) {
            int i26 = 0;
            for (int i27 = 0; i27 < childCount; i27++) {
                int weight = getChildAt(i27).getWeight();
                if (weight > 0) {
                    i26 += weight;
                }
            }
            if (i26 > 0) {
                i18 = getHeight();
            }
            i3 = i26;
        } else {
            i3 = 0;
        }
        int i28 = this.mGravity;
        if (i28 != 16 && i28 != 17) {
            if (i28 == 80) {
                i19 = getHeight() - i18;
            }
        } else {
            i19 = (getHeight() - i18) / 2;
        }
        layoutChildVertical(childCount, i17, i16, i3, height, i19);
    }

    public void measureChildrenHorizontal(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i16, 0, getLayoutAttr().height);
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            DittoArea childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                LayoutAttrSet layoutAttr = childAt.getLayoutAttr();
                measureChildWithMargins(childAt, DittoAreaGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(size, mode), 0, layoutAttr.width, childAt), 0, childMeasureSpec, 0);
                int measuredWidth = childAt.getMeasuredWidth();
                if (size > 0 && measuredWidth > 0) {
                    size = ((size - measuredWidth) - layoutAttr.leftMargin) - layoutAttr.rightMargin;
                }
            }
        }
    }

    public void measureHorizontal(int i3, int i16) {
        this.mTotalLength = 0;
        int childCount = getChildCount();
        measureChildrenHorizontal(i3, i16);
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            DittoArea childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                LayoutAttrSet layoutAttr = childAt.getLayoutAttr();
                this.mTotalLength += measuredWidth + layoutAttr.leftMargin + layoutAttr.rightMargin;
                i17 = Math.max(i17, measuredHeight);
            }
        }
        setMeasuredDimension(resolveSize(this.mTotalLength, i3), resolveSize(i17, i16));
    }

    public void measureVertical(int i3, int i16) {
        this.mTotalLength = 0;
        int childCount = getChildCount();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, 0, getLayoutAttr().width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i16, 0, getLayoutAttr().height);
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            DittoArea childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, childMeasureSpec, 0, childMeasureSpec2, 0);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                LayoutAttrSet layoutAttr = childAt.getLayoutAttr();
                this.mTotalLength += measuredHeight + layoutAttr.topMargin + layoutAttr.bottomMargin;
                i17 = Math.max(i17, measuredWidth);
            }
        }
        setMeasuredDimension(resolveSize(i17, i3), resolveSize(this.mTotalLength, i16));
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onLayout(int i3, int i16, int i17, int i18) {
        if (this.mOrientation == 1) {
            layoutVertical();
        } else {
            layoutHorizontal();
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        if (this.mOrientation == 1) {
            measureVertical(i3, i16);
        } else {
            measureHorizontal(i3, i16);
        }
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public void setGravity(int i3) {
        super.setGravity(i3);
        if (this.mGravity != i3) {
            this.mGravity = i3;
            requestLayout();
        }
    }

    public void setOrientation(int i3) {
        if (this.mOrientation != i3) {
            this.mOrientation = i3;
            requestLayout();
        }
    }
}
