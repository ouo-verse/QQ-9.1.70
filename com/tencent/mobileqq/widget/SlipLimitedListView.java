package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SlipLimitedListView extends SlideDetectListView {
    private Rect Q;

    public SlipLimitedListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Q = new Rect();
    }

    protected boolean k0(View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof WorkSpaceView) {
                    WorkSpaceView workSpaceView = (WorkSpaceView) childAt;
                    workSpaceView.getGlobalVisibleRect(this.Q);
                    if (!workSpaceView.isShown() || !this.Q.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        return false;
                    }
                    return true;
                }
                if ((childAt instanceof ViewGroup) && k0((ViewGroup) childAt, motionEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.widget.SlideDetectListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 2) && k0(this, motionEvent)) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
