package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes15.dex */
public class CustomViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    public float f252785d;

    /* renamed from: e, reason: collision with root package name */
    public float f252786e;

    /* renamed from: f, reason: collision with root package name */
    public float f252787f;

    /* renamed from: h, reason: collision with root package name */
    public float f252788h;

    /* renamed from: i, reason: collision with root package name */
    float f252789i;

    /* renamed from: m, reason: collision with root package name */
    float f252790m;

    public CustomViewPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        if (getAdapter() instanceof h) {
            return (super.getCurrentItem() - 50) + ((h) getAdapter()).G;
        }
        return super.getCurrentItem();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i3;
        int i16;
        if (getAdapter() instanceof h) {
            h hVar = (h) getAdapter();
            i16 = (super.getCurrentItem() - 50) + hVar.G;
            i3 = hVar.f252886h.size();
        } else {
            i3 = 0;
            i16 = 0;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float x16 = motionEvent.getX();
                float f16 = this.f252790m;
                if (f16 < x16 && i16 <= 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CustomViewPager", 2, " \u53f3\u6ed1\u5230\u5934");
                    }
                    return false;
                }
                if (f16 > x16 && i16 >= i3 - 1) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CustomViewPager", 2, " \u5de6\u6ed1\u5230\u5934");
                    }
                    return false;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
        } else {
            this.f252790m = motionEvent.getX();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                this.f252785d += Math.abs(x16 - this.f252787f);
                float abs = this.f252786e + Math.abs(y16 - this.f252788h);
                this.f252786e = abs;
                this.f252787f = x16;
                this.f252788h = y16;
                if (this.f252785d <= abs) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
                return super.onTouchEvent(motionEvent);
            }
        } else {
            this.f252786e = 0.0f;
            this.f252785d = 0.0f;
            this.f252787f = motionEvent.getX();
            this.f252788h = motionEvent.getY();
            this.f252789i = this.f252787f;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i3) {
        if (getAdapter() instanceof h) {
            super.setCurrentItem((i3 + 50) - ((h) getAdapter()).G);
        } else {
            super.setCurrentItem(i3);
        }
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i3, boolean z16) {
        if (getAdapter() instanceof h) {
            super.setCurrentItem((i3 + 50) - ((h) getAdapter()).G, z16);
        } else {
            super.setCurrentItem(i3, z16);
        }
    }
}
