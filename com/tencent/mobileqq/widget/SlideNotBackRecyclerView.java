package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SlideNotBackRecyclerView extends RecyclerView {
    public SlideNotBackRecyclerView(Context context) {
        super(context);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            ViewParent parent = getParent();
            while (!(parent instanceof ListView)) {
                parent = parent.getParent();
            }
            ViewParent parent2 = parent.getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
            }
        }
        return onInterceptTouchEvent;
    }

    public SlideNotBackRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
