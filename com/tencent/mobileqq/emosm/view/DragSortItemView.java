package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

/* compiled from: P */
/* loaded from: classes6.dex */
public class DragSortItemView extends ViewGroup {
    private int mGravity;

    public DragSortItemView(Context context) {
        super(context);
        this.mGravity = 48;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    }

    public int getGravity() {
        return this.mGravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        View childAt = super.getChildAt(0);
        if (childAt == null) {
            return;
        }
        if (this.mGravity == 48) {
            childAt.layout(0, 0, super.getMeasuredWidth(), childAt.getMeasuredHeight());
        } else {
            childAt.layout(0, super.getMeasuredHeight() - childAt.getMeasuredHeight(), super.getMeasuredWidth(), super.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i16);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i16);
        View childAt = super.getChildAt(0);
        if (childAt == null) {
            super.setMeasuredDimension(0, size2);
            return;
        }
        if (childAt.isLayoutRequested()) {
            super.measureChild(childAt, i3, View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (mode == 0 && (size = super.getLayoutParams().height) <= 0) {
            size = childAt.getMeasuredHeight();
        }
        super.setMeasuredDimension(size2, size);
    }

    public void setGravity(int i3) {
        this.mGravity = i3;
    }
}
