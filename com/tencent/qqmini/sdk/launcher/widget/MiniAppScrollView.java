package com.tencent.qqmini.sdk.launcher.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppScrollView extends ScrollView {
    public MiniAppScrollView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels / 2, Integer.MIN_VALUE));
    }

    public MiniAppScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
    }

    public MiniAppScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
    }
}
