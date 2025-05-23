package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DragSortItemView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public int f153868a;

    public DragSortItemView(Context context) {
        super(context);
        this.f153868a = 48;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    }

    public int getGravity() {
        return this.f153868a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        if (this.f153868a == 48) {
            childAt.layout(0, 0, getMeasuredWidth(), childAt.getMeasuredHeight());
        } else {
            childAt.layout(0, getMeasuredHeight() - childAt.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i16);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i16);
        View childAt = getChildAt(0);
        if (childAt == null) {
            setMeasuredDimension(0, size2);
            return;
        }
        if (childAt.isLayoutRequested()) {
            measureChild(childAt, i3, View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (mode == 0 && (size = getLayoutParams().height) <= 0) {
            size = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(size2, size);
    }

    public void setGravity(int i3) {
        this.f153868a = i3;
    }
}
