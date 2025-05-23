package com.tencent.biz.qqstorysave.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes5.dex */
public class IgnoreParentRelativeLayout extends RelativeLayout {
    public IgnoreParentRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i3, int i16) {
        super.measureChild(view, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i16), 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildren(int i3, int i16) {
        super.measureChildren(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i16), 0));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i16), 0));
    }

    public IgnoreParentRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
