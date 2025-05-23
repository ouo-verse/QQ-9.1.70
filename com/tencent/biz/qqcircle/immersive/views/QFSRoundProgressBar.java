package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes4.dex */
public class QFSRoundProgressBar extends View {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private Rect f90451d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f90452e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f90453f;

    /* renamed from: h, reason: collision with root package name */
    private float f90454h;

    /* renamed from: i, reason: collision with root package name */
    private String f90455i;

    /* renamed from: m, reason: collision with root package name */
    private int f90456m;

    public QFSRoundProgressBar(Context context) {
        this(context, null);
    }

    private void a() {
        this.f90451d = new Rect();
        this.f90452e = new Paint(1);
        this.f90453f = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f90452e.setAntiAlias(true);
        this.f90452e.setColor(this.E);
        this.f90452e.setStyle(Paint.Style.STROKE);
        this.f90452e.setStrokeWidth(this.D);
        this.f90452e.setStrokeCap(Paint.Cap.ROUND);
        int width = getWidth() / 2;
        int i3 = width - this.D;
        float f16 = width;
        canvas.drawCircle(f16, f16, i3, this.f90452e);
        this.f90452e.setColor(this.F);
        float f17 = width - i3;
        float f18 = i3 + width;
        this.f90453f.set(f17, f17, f18, f18);
        canvas.drawArc(this.f90453f, -90.0f, this.f90454h, false, this.f90452e);
        this.f90452e.reset();
        this.f90452e.setAntiAlias(true);
        this.f90452e.setStrokeWidth(0.0f);
        this.f90452e.setColor(this.C);
        this.f90452e.setTextSize(this.f90456m);
        Paint paint = this.f90452e;
        String str = this.f90455i;
        paint.getTextBounds(str, 0, str.length(), this.f90451d);
        canvas.drawText(this.f90455i, f16 - (this.f90451d.width() / 2.0f), f16 + (this.f90451d.height() / 2.0f), this.f90452e);
    }

    public void setProgress(int i3) {
        this.f90454h = i3 * 3.6f;
        this.f90455i = Math.round((this.f90454h / 360.0f) * 100.0f) + "%";
        postInvalidate();
    }

    public QFSRoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSRoundProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90455i = "0%";
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, y91.a.f449853v8, i3, 0);
        this.f90456m = obtainStyledAttributes.getDimensionPixelSize(y91.a.B8, (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
        this.C = obtainStyledAttributes.getColor(y91.a.A8, -16777216);
        this.E = obtainStyledAttributes.getColor(y91.a.f449865w8, -16777216);
        this.D = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449878x8, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.F = obtainStyledAttributes.getColor(y91.a.f449891y8, -16777216);
        this.G = obtainStyledAttributes.getInt(y91.a.f449904z8, 10);
        obtainStyledAttributes.recycle();
        a();
    }
}
