package com.tencent.mobileqq.matchfriend.reborn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DisableRightDragExitRecycleView extends RecyclerView {
    public DisableRightDragExitRecycleView(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if ((motionEvent.getAction() & 255) == 0 && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public DisableRightDragExitRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DisableRightDragExitRecycleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
