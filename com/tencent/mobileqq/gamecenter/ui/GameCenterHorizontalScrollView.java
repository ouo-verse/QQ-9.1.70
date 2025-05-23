package com.tencent.mobileqq.gamecenter.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: f, reason: collision with root package name */
    private static final double f213248f = Math.tan(Math.toRadians(30.0d));

    /* renamed from: d, reason: collision with root package name */
    private float f213249d;

    /* renamed from: e, reason: collision with root package name */
    private float f213250e;

    public GameCenterHorizontalScrollView(Context context) {
        super(context);
    }

    private boolean a(float f16, float f17) {
        if (Math.abs(f16 - this.f213249d) > Math.abs(f17 - this.f213250e) * f213248f) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 2 || action == 3) {
                getParent().requestDisallowInterceptTouchEvent(a(x16, y16));
            }
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f213249d = x16;
            this.f213250e = y16;
        }
        return dispatchTouchEvent;
    }

    public GameCenterHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
