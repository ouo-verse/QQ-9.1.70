package com.tencent.mobileqq.leba.zplan.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b72.a;

/* loaded from: classes15.dex */
public class PullToZoomHeaderFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f240838d;

    /* renamed from: e, reason: collision with root package name */
    private int f240839e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f240840f;

    /* renamed from: h, reason: collision with root package name */
    private a f240841h;

    public PullToZoomHeaderFrameLayout(@NonNull Context context) {
        this(context, null, 0, 0);
    }

    private void a() {
        this.f240838d = (int) (getResources().getDisplayMetrics().density * 200.0f);
        setFocusable(true);
        setClickable(true);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f240841h == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked() & 255;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2 && Math.abs(((int) motionEvent.getY()) - this.f240839e) > 5.0f) {
                    boolean a16 = this.f240841h.a(motionEvent);
                    this.f240840f = a16;
                    if (a16) {
                        return true;
                    }
                }
            } else if (this.f240840f) {
                this.f240840f = false;
                return true;
            }
        } else {
            this.f240840f = false;
            this.f240839e = (int) motionEvent.getY();
            this.f240841h.handleZPlanEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f240841h == null) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked() & 255;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                boolean handleZPlanEvent = this.f240841h.handleZPlanEvent(motionEvent);
                this.f240840f = handleZPlanEvent;
                if (handleZPlanEvent) {
                    return true;
                }
            }
        } else {
            this.f240841h.handleZPlanEvent(motionEvent);
            if (this.f240840f) {
                this.f240840f = false;
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, this.f240838d, z16);
    }

    public void setHandleEvent(a aVar) {
        this.f240841h = aVar;
    }

    public PullToZoomHeaderFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public PullToZoomHeaderFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public PullToZoomHeaderFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        a();
    }
}
