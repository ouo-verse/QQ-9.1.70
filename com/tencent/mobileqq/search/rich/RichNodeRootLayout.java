package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RichNodeRootLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f283741d;

    /* renamed from: e, reason: collision with root package name */
    private GestureDetector f283742e;

    public RichNodeRootLayout(Context context) {
        super(context);
        this.f283741d = false;
        a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f283742e;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f283741d) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (actionMasked == 1 || actionMasked == 3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public RichNodeRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f283741d = false;
        a(context);
    }

    public RichNodeRootLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f283741d = false;
        a(context);
    }

    private void a(Context context) {
    }
}
