package com.tencent.biz.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/* loaded from: classes5.dex */
public class PhotoHorizontalScrollView extends HorizontalScrollView {
    public PhotoHorizontalScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public PhotoHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PhotoHorizontalScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
