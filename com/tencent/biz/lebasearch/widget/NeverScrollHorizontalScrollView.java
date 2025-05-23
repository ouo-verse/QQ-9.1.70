package com.tencent.biz.lebasearch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NeverScrollHorizontalScrollView extends HorizontalScrollView {
    public NeverScrollHorizontalScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(2);
    }

    public NeverScrollHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NeverScrollHorizontalScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
