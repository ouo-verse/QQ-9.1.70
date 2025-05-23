package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECircleBottomWrapLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f62536d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f62537e;

    /* renamed from: f, reason: collision with root package name */
    private View f62538f;

    /* renamed from: h, reason: collision with root package name */
    private AEBottomListScrollView f62539h;

    /* renamed from: i, reason: collision with root package name */
    private VelocityTracker f62540i;

    public AECircleBottomWrapLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f62540i.addMovement(motionEvent);
        this.f62540i.computeCurrentVelocity(1000);
        if (motionEvent.getAction() == 0) {
            this.f62536d = false;
            this.f62537e = false;
            this.f62540i.clear();
        }
        if (Math.abs(this.f62540i.getXVelocity()) > 100.0f && motionEvent.getEventTime() - motionEvent.getDownTime() < 100 && com.tencent.aelight.camera.ae.util.c.g(this.f62538f, motionEvent) && !this.f62536d) {
            this.f62536d = true;
            this.f62537e = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f62540i = VelocityTracker.obtain();
        this.f62538f = findViewById(R.id.rtz);
        this.f62539h = (AEBottomListScrollView) findViewById(R.id.s08);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f62540i.recycle();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f62537e) {
            ms.a.a("AECircleBottomLayout", "in onInterceptTouchEvent true.");
            motionEvent.setAction(0);
            this.f62539h.dispatchTouchEvent(motionEvent);
            this.f62537e = false;
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f62536d) {
            return super.onTouchEvent(motionEvent);
        }
        return this.f62539h.onTouchEvent(motionEvent);
    }

    public AECircleBottomWrapLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AECircleBottomWrapLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f62536d = false;
        this.f62537e = false;
    }
}
