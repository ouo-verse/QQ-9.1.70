package com.tencent.mobileqq.ocr.view.gesture.detector;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends ScaleGestureDetector {

    /* renamed from: a, reason: collision with root package name */
    private float f255046a;

    /* renamed from: b, reason: collision with root package name */
    private float f255047b;

    public a(Context context, ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
        super(context, onScaleGestureListener);
        b();
    }

    @TargetApi(19)
    private boolean a() {
        if (isQuickScaleEnabled() && getCurrentSpan() == getCurrentSpanY()) {
            return true;
        }
        return false;
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        MotionEvent obtain = MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 3, 0.0f, 0.0f, 0);
        onTouchEvent(obtain);
        obtain.recycle();
    }

    @Override // android.view.ScaleGestureDetector
    public float getScaleFactor() {
        float scaleFactor = super.getScaleFactor();
        if (a()) {
            float f16 = this.f255046a;
            float f17 = this.f255047b;
            if ((f16 <= f17 || scaleFactor <= 1.0f) && (f16 >= f17 || scaleFactor >= 1.0f)) {
                return 1.0f;
            }
            return Math.max(0.8f, Math.min(scaleFactor, 1.25f));
        }
        return scaleFactor;
    }

    @Override // android.view.ScaleGestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.f255047b = this.f255046a;
        this.f255046a = motionEvent.getY();
        if (motionEvent.getActionMasked() == 0) {
            this.f255047b = motionEvent.getY();
        }
        return onTouchEvent;
    }
}
