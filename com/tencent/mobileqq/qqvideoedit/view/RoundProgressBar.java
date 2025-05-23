package com.tencent.mobileqq.qqvideoedit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes17.dex */
public class RoundProgressBar extends View {
    private int C;
    private int D;
    private float E;
    private String F;
    private Rect G;
    private Paint H;
    private RectF I;
    private SweepGradient J;

    /* renamed from: d, reason: collision with root package name */
    private int f276261d;

    /* renamed from: e, reason: collision with root package name */
    private int f276262e;

    /* renamed from: f, reason: collision with root package name */
    private int f276263f;

    /* renamed from: h, reason: collision with root package name */
    private int f276264h;

    /* renamed from: i, reason: collision with root package name */
    private int f276265i;

    /* renamed from: m, reason: collision with root package name */
    private int f276266m;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    private void a() {
        this.G = new Rect();
        Paint paint = new Paint(1);
        this.H = paint;
        paint.setAntiAlias(true);
        this.I = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.H.setColor(this.f276264h);
        this.H.setStyle(Paint.Style.STROKE);
        this.H.setStrokeWidth(this.f276263f);
        this.H.setStrokeCap(Paint.Cap.ROUND);
        int width = getWidth() / 2;
        int i3 = width - this.f276263f;
        float f16 = width;
        canvas.drawCircle(f16, f16, i3, this.H);
        SweepGradient sweepGradient = this.J;
        if (sweepGradient != null) {
            this.H.setShader(sweepGradient);
        } else {
            this.H.setColor(this.f276265i);
        }
        float f17 = width - i3;
        float f18 = i3 + width;
        this.I.set(f17, f17, f18, f18);
        canvas.drawArc(this.I, -90.0f, this.E, false, this.H);
        this.H.reset();
        this.H.setAntiAlias(true);
        this.H.setColor(this.f276262e);
        this.H.setTextSize(this.f276261d);
        Paint paint = this.H;
        String str = this.F;
        paint.getTextBounds(str, 0, str.length(), this.G);
        canvas.drawText(this.F, f16 - (this.G.width() / 2.0f), f16 + (this.G.height() / 2.0f), this.H);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        if (this.f276266m != -1 || this.C != -1) {
            float width = getWidth() / 2.0f;
            this.J = new SweepGradient(width, width, this.f276266m, this.C);
            Matrix matrix = new Matrix();
            matrix.setRotate(-90.0f, width, width);
            this.J.setLocalMatrix(matrix);
        }
    }

    public void setProgress(int i3) {
        this.E = i3 * 3.6f;
        this.F = Math.round((this.E / 360.0f) * 100.0f) + "%";
        postInvalidate();
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F = "0%";
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.tencent.mobileqq.qqvideoedit.d.G4, i3, 0);
        this.f276261d = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.qqvideoedit.d.O4, (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
        this.f276262e = obtainStyledAttributes.getColor(com.tencent.mobileqq.qqvideoedit.d.N4, -16777216);
        this.f276264h = obtainStyledAttributes.getColor(com.tencent.mobileqq.qqvideoedit.d.H4, -16777216);
        this.f276263f = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.qqvideoedit.d.I4, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.f276265i = obtainStyledAttributes.getColor(com.tencent.mobileqq.qqvideoedit.d.J4, -16777216);
        this.f276266m = obtainStyledAttributes.getColor(com.tencent.mobileqq.qqvideoedit.d.M4, -1);
        this.C = obtainStyledAttributes.getColor(com.tencent.mobileqq.qqvideoedit.d.K4, -1);
        this.D = obtainStyledAttributes.getInt(com.tencent.mobileqq.qqvideoedit.d.L4, 10);
        obtainStyledAttributes.recycle();
        a();
    }
}
