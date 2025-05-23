package com.qq.e.comm.plugin.base.ad.b.b.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f38410a;

    /* renamed from: b, reason: collision with root package name */
    private float f38411b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f38412c;

    /* renamed from: d, reason: collision with root package name */
    private float f38413d;

    /* renamed from: e, reason: collision with root package name */
    private Path f38414e;

    public a(Context context) {
        super(context);
        setLayerType(1, null);
        this.f38412c = new RectF();
        Paint paint = new Paint();
        this.f38410a = paint;
        paint.setAntiAlias(true);
        this.f38414e = new Path();
    }

    private int b() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    private int c() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void a(int i3) {
        this.f38410a.setColor(i3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f38414e.moveTo(getPaddingLeft(), getHeight() / 2);
        this.f38414e.lineTo((c() - this.f38411b) + getPaddingLeft(), getPaddingTop());
        this.f38414e.lineTo(c() + getPaddingLeft(), this.f38411b + getPaddingTop());
        this.f38414e.lineTo(a() + getPaddingLeft(), getHeight() / 2);
        this.f38414e.lineTo(c() + getPaddingLeft(), (b() - this.f38411b) + getPaddingTop());
        this.f38414e.lineTo((c() - this.f38411b) + getPaddingLeft(), b() + getPaddingTop());
        this.f38414e.close();
        canvas.drawPath(this.f38414e, this.f38410a);
        this.f38412c.set((c() - (this.f38411b * 2.0f)) + getPaddingLeft(), getPaddingTop(), c() + getPaddingLeft(), (this.f38411b * 2.0f) + getPaddingTop());
        canvas.drawArc(this.f38412c, 0.0f, -90.0f, true, this.f38410a);
        this.f38412c.set((c() - (this.f38411b * 2.0f)) + getPaddingLeft(), (b() - (this.f38411b * 2.0f)) + getPaddingTop(), c() + getPaddingLeft(), b() + getPaddingTop());
        canvas.drawArc(this.f38412c, 0.0f, 90.0f, true, this.f38410a);
    }

    public void a(float f16) {
        this.f38411b = (float) (f16 / Math.sqrt(2.0d));
        this.f38413d = f16;
        this.f38410a.setStrokeWidth(f16);
    }

    private float a() {
        return (float) (((this.f38413d * 2.0f) * Math.sqrt(Math.pow(b() / 2, 2.0d) + Math.pow(c() - this.f38411b, 2.0d))) / b());
    }
}
