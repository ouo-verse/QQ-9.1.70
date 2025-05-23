package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DispatchActionMoveScrollView extends ScrollView {
    public boolean dispatchActionMove;

    public DispatchActionMoveScrollView(Context context) {
        super(context);
        this.dispatchActionMove = false;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dispatchActionMove) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @TargetApi(9)
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(2);
    }

    public DispatchActionMoveScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dispatchActionMove = false;
    }

    public DispatchActionMoveScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.dispatchActionMove = false;
    }
}
