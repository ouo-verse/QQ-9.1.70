package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes5.dex */
public class UnHandleTouchEventViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    protected boolean f94504d;

    public UnHandleTouchEventViewPager(Context context) {
        super(context);
    }

    public boolean a(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f94504d && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f94504d && super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setDisableScroll(boolean z16) {
        this.f94504d = z16;
    }

    public UnHandleTouchEventViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
