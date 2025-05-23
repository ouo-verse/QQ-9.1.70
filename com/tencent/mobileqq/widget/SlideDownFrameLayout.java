package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SlideDownFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f316291d;

    /* renamed from: e, reason: collision with root package name */
    private float f316292e;

    /* renamed from: f, reason: collision with root package name */
    private int f316293f;

    /* renamed from: h, reason: collision with root package name */
    private VelocityTracker f316294h;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public SlideDownFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316291d = 0.0f;
        this.f316292e = 0.0f;
        this.f316293f = 0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y16 = motionEvent.getY();
        this.f316292e = y16;
        if (action == 0) {
            this.f316291d = y16;
        } else if (action == 2) {
            if (this.f316293f == 1) {
                if (this.f316294h == null) {
                    this.f316294h = VelocityTracker.obtain();
                }
                this.f316294h.addMovement(motionEvent);
                return true;
            }
        } else if (action == 1 || action == 3) {
            int i3 = this.f316293f;
            this.f316293f = 0;
            VelocityTracker velocityTracker = this.f316294h;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f316294h = null;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnSlideListener(a aVar) {
    }
}
