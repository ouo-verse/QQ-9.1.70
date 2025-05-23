package com.tencent.ditto.widget;

import android.view.View;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ditto.shell.LayoutAttrSet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FlexLinearAreaLayout extends LinearAreaLayout {
    private int shrinkColumns;
    private int stretchColumns;

    public FlexLinearAreaLayout(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.shrinkColumns = -1;
        this.stretchColumns = -1;
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.SHRINK_COLUMNS)) {
            this.shrinkColumns = layoutAttrSet.getAttr(LayoutAttrDefine.SHRINK_COLUMNS, -1);
        }
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.STRETCH_COLUMNS)) {
            this.stretchColumns = layoutAttrSet.getAttr(LayoutAttrDefine.STRETCH_COLUMNS, -1);
        }
    }

    @Override // com.tencent.ditto.widget.LinearAreaLayout
    public void measureHorizontal(int i3, int i16) {
        int i17 = this.shrinkColumns;
        if (i17 < 0 || i17 >= getChildCount()) {
            super.measureHorizontal(i3, i16);
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            super.measureHorizontal(i3, i16);
        }
        measureChildrenHorizontal(i3, i16);
        int childCount = getChildCount();
        int i18 = size;
        int i19 = 0;
        for (int i26 = 0; i26 < childCount; i26++) {
            DittoArea childAt = getChildAt(i26);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                i19 = Math.max(i19, childAt.getMeasuredHeight());
                if (this.shrinkColumns != i26) {
                    LayoutAttrSet layoutAttr = childAt.getLayoutAttr();
                    i18 -= (measuredWidth + layoutAttr.leftMargin) + layoutAttr.rightMargin;
                }
            }
        }
        DittoArea childAt2 = getChildAt(this.shrinkColumns);
        if (childAt2 == null) {
            return;
        }
        if (childAt2.getVisibility() != 8) {
            LayoutAttrSet layoutAttr2 = childAt2.getLayoutAttr();
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int i27 = layoutAttr2.leftMargin;
            int i28 = layoutAttr2.rightMargin;
            if (measuredWidth2 + i27 + i28 > i18) {
                int childMeasureSpec = DittoAreaGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec((i18 - i27) - i28, mode), getPaddingLeft() + getPaddingRight(), layoutAttr2.width);
                childAt2.setMeasureDirty(true);
                measureChildWithMargins(childAt2, childMeasureSpec, 0, i16, 0);
                childAt2.setMeasureDirty(false);
            }
        }
        setMeasuredDimension(size, resolveSize(i19, i16));
    }
}
