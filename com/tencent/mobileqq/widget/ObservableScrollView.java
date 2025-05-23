package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ObservableScrollView extends ScrollView {
    public ObservableScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setScrollViewListener(bg bgVar) {
    }
}
