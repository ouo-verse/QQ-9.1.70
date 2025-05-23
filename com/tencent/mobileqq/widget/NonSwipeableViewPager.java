package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes20.dex */
public class NonSwipeableViewPager extends QQViewPager {

    /* renamed from: d, reason: collision with root package name */
    private boolean f315882d;

    public NonSwipeableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315882d = true;
    }

    @Override // com.tencent.mobileqq.widget.QQViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f315882d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.widget.QQViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f315882d) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setPagingEnabled(boolean z16) {
        this.f315882d = z16;
    }
}
