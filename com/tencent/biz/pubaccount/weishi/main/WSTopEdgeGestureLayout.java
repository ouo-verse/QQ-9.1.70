package com.tencent.biz.pubaccount.weishi.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSTopEdgeGestureLayout extends TopGestureLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f80920d;

    /* renamed from: e, reason: collision with root package name */
    private int f80921e;

    /* renamed from: f, reason: collision with root package name */
    private int f80922f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f80923h;

    public WSTopEdgeGestureLayout(Context context) {
        this(context, null);
    }

    private void d() {
        this.f80921e = ba.o();
        this.f80922f = ViewConfiguration.getTouchSlop();
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f80923h) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f80920d = motionEvent.getX();
        } else if (motionEvent.getAction() == 2) {
            int width = getWidth();
            float f16 = this.f80920d;
            if ((f16 < this.f80921e || Math.abs(width - f16) < this.f80921e) && Math.abs(this.f80920d - motionEvent.getX()) > this.f80922f) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setIsIntercept(boolean z16) {
        this.f80923h = z16;
    }

    public WSTopEdgeGestureLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WSTopEdgeGestureLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f80923h = true;
        d();
    }
}
