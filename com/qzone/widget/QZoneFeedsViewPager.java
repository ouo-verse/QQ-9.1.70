package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes37.dex */
public class QZoneFeedsViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    private float f60473d;

    public QZoneFeedsViewPager(Context context) {
        super(context);
        this.f60473d = 0.0f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 2 && getCurrentItem() == 0 && motionEvent.getX() - this.f60473d > 0.0f) {
                this.f60473d = motionEvent.getX();
                return false;
            }
        } else {
            this.f60473d = motionEvent.getX();
        }
        return onInterceptTouchEvent;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public QZoneFeedsViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60473d = 0.0f;
    }
}
