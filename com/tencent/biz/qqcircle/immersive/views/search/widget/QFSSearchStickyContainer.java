package com.tencent.biz.qqcircle.immersive.views.search.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchStickyContainer extends FrameLayout {
    private int C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private View f91295d;

    /* renamed from: e, reason: collision with root package name */
    private View f91296e;

    /* renamed from: f, reason: collision with root package name */
    private int f91297f;

    /* renamed from: h, reason: collision with root package name */
    private float f91298h;

    /* renamed from: i, reason: collision with root package name */
    private float f91299i;

    /* renamed from: m, reason: collision with root package name */
    private VelocityTracker f91300m;

    public QFSSearchStickyContainer(@NonNull Context context) {
        super(context);
    }

    private boolean a() {
        if (this.f91295d == null) {
            if (getChildCount() != 2) {
                return false;
            }
            this.f91295d = getChildAt(1);
            this.f91296e = getChildAt(0);
        }
        if (this.f91297f == 0) {
            this.f91297f = this.f91295d.getHeight();
        }
        View view = this.f91296e;
        if (!(view instanceof RecyclerView) || !view.canScrollVertically(this.f91297f)) {
            return false;
        }
        if (this.f91300m == null) {
            this.f91300m = VelocityTracker.obtain();
        }
        if (this.C == 0) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.C = viewConfiguration.getScaledMinimumFlingVelocity() * 10;
            this.D = viewConfiguration.getScaledMaximumFlingVelocity();
        }
        if (this.f91296e.getVisibility() == 0 && this.f91297f != 0) {
            return true;
        }
        return false;
    }

    private void b() {
        VelocityTracker velocityTracker = this.f91300m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f91300m = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!a()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        this.f91300m.addMovement(motionEvent);
        float y16 = motionEvent.getY();
        float x16 = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            float f16 = 0.0f;
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        b();
                    }
                } else {
                    float f17 = y16 - this.f91298h;
                    float f18 = x16 - this.f91299i;
                    this.f91298h = y16;
                    this.f91299i = x16;
                    if (Math.abs(f18) <= Math.abs(f17) && f17 >= 0.0f) {
                        float translationY = this.f91295d.getTranslationY() + f17;
                        if (translationY <= 0.0f) {
                            int i3 = this.f91297f;
                            if (translationY < (-i3)) {
                                f16 = -i3;
                            } else {
                                f16 = translationY;
                            }
                        }
                        this.f91295d.setTranslationY(f16);
                    }
                }
            } else if (this.f91298h >= this.f91297f) {
                this.f91300m.computeCurrentVelocity(1000, this.D);
                float yVelocity = this.f91300m.getYVelocity();
                if (yVelocity < 0.0f && Math.abs(yVelocity) > this.C) {
                    this.f91295d.setTranslationY(-this.f91297f);
                }
            }
        } else {
            this.f91298h = y16;
            this.f91299i = x16;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    public QFSSearchStickyContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSSearchStickyContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
