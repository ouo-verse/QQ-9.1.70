package com.tencent.open.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MaxHeightScrollView extends ScrollView {

    /* renamed from: d, reason: collision with root package name */
    private int f341794d;

    public MaxHeightScrollView(Context context) {
        this(context, null);
    }

    private int b(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    private void c() {
        this.f341794d = b(getContext()) - x.c(getContext(), 56.0f);
    }

    public int a() {
        return this.f341794d;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        int i17 = this.f341794d;
        if (size > i17 && mode != 0) {
            i16 = View.MeasureSpec.makeMeasureSpec(i17, mode);
        }
        super.onMeasure(i3, i16);
    }

    public void setMaxHeight(int i3) {
        this.f341794d = i3;
        requestLayout();
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f341794d = Integer.MAX_VALUE;
        c();
    }
}
