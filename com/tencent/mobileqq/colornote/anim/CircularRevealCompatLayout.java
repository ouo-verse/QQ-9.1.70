package com.tencent.mobileqq.colornote.anim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CircularRevealCompatLayout extends FrameLayout {
    private float C;
    private final Path D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private float f201328d;

    /* renamed from: e, reason: collision with root package name */
    private float f201329e;

    /* renamed from: f, reason: collision with root package name */
    private float f201330f;

    /* renamed from: h, reason: collision with root package name */
    private final Path f201331h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f201332i;

    /* renamed from: m, reason: collision with root package name */
    private RectF f201333m;

    public CircularRevealCompatLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f201332i) {
            if (!this.f201331h.isEmpty()) {
                canvas.save();
                canvas.clipPath(this.f201331h);
                super.dispatchDraw(canvas);
                canvas.restore();
                return;
            }
            super.dispatchDraw(canvas);
            return;
        }
        if (this.E) {
            if (!this.D.isEmpty()) {
                canvas.save();
                canvas.clipPath(this.D);
                super.dispatchDraw(canvas);
                canvas.restore();
                return;
            }
            super.dispatchDraw(canvas);
            return;
        }
        super.dispatchDraw(canvas);
    }

    public void setClipRect(RectF rectF, float f16) {
        if (rectF.width() >= getWidth() && rectF.height() >= getHeight()) {
            this.E = false;
            invalidate();
            return;
        }
        this.E = true;
        this.f201333m.set(rectF);
        this.C = f16;
        this.D.reset();
        Path path = this.D;
        RectF rectF2 = this.f201333m;
        float f17 = this.C;
        path.addRoundRect(rectF2, f17, f17, Path.Direction.CW);
        this.D.close();
    }

    public void setEnableClip(boolean z16) {
        this.f201332i = z16;
    }

    public void setRevealClip(float f16, float f17, float f18) {
        boolean z16;
        this.f201328d = f16;
        this.f201329e = f17;
        this.f201330f = f18;
        float width = getWidth() - f16;
        float width2 = getWidth() - f17;
        if (Math.max(f16 * f16, width * width) + Math.max(f17 * f17, width2 * width2) > f18 * f18) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f201332i = z16;
        this.f201331h.reset();
        this.f201331h.addCircle(this.f201328d, this.f201329e, this.f201330f, Path.Direction.CW);
        this.f201331h.close();
        invalidate();
    }

    public CircularRevealCompatLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularRevealCompatLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f201331h = new Path();
        this.f201333m = new RectF();
        this.D = new Path();
    }
}
