package com.tencent.biz.pubaccount.weishi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

/* compiled from: P */
/* loaded from: classes32.dex */
public class RotationSeekBar extends SeekBar {

    /* renamed from: h, reason: collision with root package name */
    private static float f82389h = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float[] f82390d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f82391e;

    /* renamed from: f, reason: collision with root package name */
    private int f82392f;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
    }

    public RotationSeekBar(Context context) {
        super(context);
        this.f82390d = null;
        this.f82391e = null;
        d();
    }

    private float c() {
        if (f82389h == -1.0f) {
            f82389h = getContext().getResources().getDisplayMetrics().density;
        }
        return f82389h;
    }

    protected int a(float f16) {
        c();
        return Math.round(f16 * f82389h);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.dispatchTouchEvent(b(motionEvent));
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f82390d != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (this.f82391e == null) {
                Paint paint = new Paint();
                this.f82391e = paint;
                paint.setStyle(Paint.Style.FILL);
                this.f82391e.setColor(-3355444);
            }
            int a16 = a(2.0f);
            int i3 = measuredHeight / 2;
            for (float f16 : this.f82390d) {
                if (f16 > 0.0f && f16 < 1.0f) {
                    canvas.save();
                    canvas.translate(f16 * measuredWidth, i3);
                    canvas.drawCircle(0.0f, 0.0f, a16, this.f82391e);
                    canvas.restore();
                }
            }
        }
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    private MotionEvent b(MotionEvent motionEvent) {
        int i3;
        int i16;
        if (motionEvent != null && motionEvent.getAction() == 2) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i17 = iArr[0];
            int i18 = iArr[1];
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int i19 = this.f82392f;
            if (i19 == 90) {
                i3 = rawY - i18;
                i16 = i17 - rawX;
            } else if (i19 == 180) {
                int i26 = i17 - rawX;
                i16 = i18 - rawY;
                i3 = i26;
            } else if (i19 != 270) {
                i3 = (int) motionEvent.getX();
                i16 = (int) motionEvent.getY();
            } else {
                i3 = i18 - rawY;
                i16 = rawX - i17;
            }
            motionEvent.setLocation(i3, i16);
        }
        return motionEvent;
    }

    public RotationSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82390d = null;
        this.f82391e = null;
        d();
    }

    public RotationSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82390d = null;
        this.f82391e = null;
        d();
    }

    void d() {
    }

    public void setOnRotationChangeListener(a aVar) {
    }
}
