package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes37.dex */
public class DisAllowInterceptRelativeLayout extends RelativeLayout {
    public DisAllowInterceptRelativeLayout(Context context) {
        super(context);
    }

    public DisAllowInterceptRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public DisAllowInterceptRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
