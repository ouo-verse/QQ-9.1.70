package com.tencent.open.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes22.dex */
public class HalfScreenRelativelayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f341791d;

    @TargetApi(11)
    public HalfScreenRelativelayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f341791d = Integer.MAX_VALUE;
        b();
    }

    private int a(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    private void b() {
        this.f341791d = ((int) (a(getContext()) / 2.0f)) + x.c(getContext(), 56.0f);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        int i17 = this.f341791d;
        if (size > i17 && mode != 0) {
            i16 = View.MeasureSpec.makeMeasureSpec(i17, mode);
        }
        super.onMeasure(i3, i16);
    }

    public void setMaxHeight(int i3) {
        this.f341791d = i3;
        if (i3 < getMeasuredHeight()) {
            requestLayout();
        }
    }

    public HalfScreenRelativelayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HalfScreenRelativelayout(Context context) {
        this(context, null);
    }
}
