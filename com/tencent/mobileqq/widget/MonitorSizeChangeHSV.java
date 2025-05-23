package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MonitorSizeChangeHSV extends HorizontalScrollView {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public MonitorSizeChangeHSV(Context context) {
        super(context);
    }

    public boolean a() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getWidth() >= childAt.getWidth() + getPaddingLeft() + getPaddingLeft()) {
            return false;
        }
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup;
        if (a()) {
            if (motionEvent.getAction() == 0) {
                ViewGroup viewGroup2 = (ViewGroup) getParent();
                if (viewGroup2 != null) {
                    viewGroup2.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && (viewGroup = (ViewGroup) getParent()) != null) {
                viewGroup.requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(2);
    }

    public MonitorSizeChangeHSV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSizeChangeCallback(a aVar) {
    }
}
