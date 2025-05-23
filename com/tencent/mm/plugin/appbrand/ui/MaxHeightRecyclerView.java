package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MaxHeightRecyclerView extends RecyclerView {

    /* renamed from: a, reason: collision with root package name */
    public int f152294a;

    public MaxHeightRecyclerView(Context context) {
        super(context);
    }

    public int getMaxHeight() {
        return this.f152294a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17 = this.f152294a;
        if (i17 > 0) {
            i16 = View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i16);
    }

    public void setMaxHeight(int i3) {
        this.f152294a = i3;
        invalidate();
        requestLayout();
    }

    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
