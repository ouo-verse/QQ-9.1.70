package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CustomHorizontalScrollView extends HorizontalScrollView {
    int C;
    Runnable D;
    float E;
    float F;
    int G;

    /* renamed from: d, reason: collision with root package name */
    Handler f315603d;

    /* renamed from: e, reason: collision with root package name */
    float f315604e;

    /* renamed from: f, reason: collision with root package name */
    int f315605f;

    /* renamed from: h, reason: collision with root package name */
    int f315606h;

    /* renamed from: i, reason: collision with root package name */
    int f315607i;

    /* renamed from: m, reason: collision with root package name */
    int f315608m;

    public CustomHorizontalScrollView(Context context) {
        super(context);
        this.f315605f = -1;
        this.D = new Runnable() { // from class: com.tencent.mobileqq.widget.CustomHorizontalScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int scrollX = CustomHorizontalScrollView.this.getScrollX();
                CustomHorizontalScrollView customHorizontalScrollView = CustomHorizontalScrollView.this;
                if (scrollX == customHorizontalScrollView.f315605f) {
                    int i3 = customHorizontalScrollView.f315606h;
                    int i16 = customHorizontalScrollView.f315607i;
                    int i17 = scrollX % (i3 + i16);
                    if (customHorizontalScrollView.C + scrollX >= customHorizontalScrollView.f315608m) {
                        return;
                    }
                    if (i17 < i3 / 2) {
                        customHorizontalScrollView.smoothScrollBy(-i17, 0);
                    } else if (i17 >= i3 / 2) {
                        customHorizontalScrollView.smoothScrollBy((i3 + i16) - i17, 0);
                    }
                    CustomHorizontalScrollView.this.f315605f = scrollX;
                    return;
                }
                customHorizontalScrollView.f315605f = scrollX;
                customHorizontalScrollView.f315603d.postDelayed(customHorizontalScrollView.D, 5L);
            }
        };
        this.G = 3;
        this.f315603d = new Handler();
        this.f315604e = getResources().getDisplayMetrics().density;
        this.C = getResources().getDisplayMetrics().widthPixels;
        float f16 = this.f315604e;
        this.f315606h = (int) ((70.0f * f16) + 0.5d);
        this.f315607i = (int) (f16 + 0.5d);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 2 || action == 3) {
                if ((this.G * Math.abs(x16 - this.E) > Math.abs(y16 - this.F) || (x16 == this.E && y16 == this.F)) && getScrollX() != 0) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.E = x16;
            this.F = y16;
        }
        return dispatchTouchEvent;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                this.f315608m = childAt.getMeasuredWidth();
            }
            this.f315603d.postDelayed(this.D, 5L);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(2);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315605f = -1;
        this.D = new Runnable() { // from class: com.tencent.mobileqq.widget.CustomHorizontalScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int scrollX = CustomHorizontalScrollView.this.getScrollX();
                CustomHorizontalScrollView customHorizontalScrollView = CustomHorizontalScrollView.this;
                if (scrollX == customHorizontalScrollView.f315605f) {
                    int i3 = customHorizontalScrollView.f315606h;
                    int i16 = customHorizontalScrollView.f315607i;
                    int i17 = scrollX % (i3 + i16);
                    if (customHorizontalScrollView.C + scrollX >= customHorizontalScrollView.f315608m) {
                        return;
                    }
                    if (i17 < i3 / 2) {
                        customHorizontalScrollView.smoothScrollBy(-i17, 0);
                    } else if (i17 >= i3 / 2) {
                        customHorizontalScrollView.smoothScrollBy((i3 + i16) - i17, 0);
                    }
                    CustomHorizontalScrollView.this.f315605f = scrollX;
                    return;
                }
                customHorizontalScrollView.f315605f = scrollX;
                customHorizontalScrollView.f315603d.postDelayed(customHorizontalScrollView.D, 5L);
            }
        };
        this.G = 3;
        this.f315603d = new Handler(Looper.getMainLooper());
        this.f315604e = getResources().getDisplayMetrics().density;
        this.C = getResources().getDisplayMetrics().widthPixels;
        float f16 = this.f315604e;
        this.f315606h = (int) ((70.0f * f16) + 0.5d);
        this.f315607i = (int) (f16 + 0.5d);
    }
}
