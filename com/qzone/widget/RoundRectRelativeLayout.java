package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes37.dex */
public class RoundRectRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f60669d;

    /* renamed from: e, reason: collision with root package name */
    private int f60670e;

    /* renamed from: f, reason: collision with root package name */
    private int f60671f;

    /* renamed from: h, reason: collision with root package name */
    private Path f60672h;

    public RoundRectRelativeLayout(Context context) {
        super(context);
        a(null, 0, 0);
    }

    private void a(AttributeSet attributeSet, int i3, int i16) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, jj2.b.f410085i7, i3, i16);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f60669d = dimensionPixelSize;
        if (dimensionPixelSize < 0) {
            this.f60669d = 0;
        }
        Log.i("RoundRectRelativeLayout", "init: " + this.f60669d);
        obtainStyledAttributes.recycle();
    }

    private void b() {
        Path path = new Path();
        this.f60672h = path;
        int i3 = this.f60669d;
        if (i3 == 0) {
            path.addRect(0.0f, 0.0f, this.f60670e, this.f60671f, Path.Direction.CCW);
            return;
        }
        float min = Math.min(i3 * 2, Math.min(this.f60670e, this.f60671f)) / 2;
        this.f60672h.addRoundRect(new RectF(0.0f, 0.0f, this.f60670e, this.f60671f), min, min, Path.Direction.CCW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Integer num;
        if (this.f60672h != null) {
            num = Integer.valueOf(canvas.save());
            canvas.clipPath(this.f60672h);
        } else {
            num = null;
        }
        super.dispatchDraw(canvas);
        if (num != null) {
            canvas.restoreToCount(num.intValue());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        Log.i("RoundRectRelativeLayout", "dispatchTouchEvent: " + dispatchTouchEvent);
        return dispatchTouchEvent;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth();
        int height = getHeight();
        if (width == this.f60670e && height == this.f60671f) {
            return;
        }
        this.f60670e = width;
        this.f60671f = height;
        b();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Log.i("RoundRectRelativeLayout", "onTouchEvent: ");
        return onTouchEvent;
    }

    public RoundRectRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0, 0);
    }

    public void setAllRadius(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (this.f60669d == i3) {
            return;
        }
        this.f60669d = i3;
        Log.i("RoundRectRelativeLayout", "setAllRadius: " + this.f60669d);
        b();
        invalidate();
    }

    public RoundRectRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(attributeSet, i3, 0);
    }
}
