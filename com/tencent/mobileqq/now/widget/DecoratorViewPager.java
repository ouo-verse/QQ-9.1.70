package com.tencent.mobileqq.now.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes9.dex */
public class DecoratorViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f254392d;

    public DecoratorViewPager(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup = this.f254392d;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup = this.f254392d;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup = this.f254392d;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setNestedpParent(ViewGroup viewGroup) {
        this.f254392d = viewGroup;
    }

    public DecoratorViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
