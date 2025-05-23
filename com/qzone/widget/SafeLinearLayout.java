package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes37.dex */
public class SafeLinearLayout extends LinearLayout {
    public SafeLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchVisibilityChanged(View view, int i3) {
        super.dispatchVisibilityChanged(view, i3);
    }

    public SafeLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SafeLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
