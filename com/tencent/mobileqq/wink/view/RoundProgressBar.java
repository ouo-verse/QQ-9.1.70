package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes21.dex */
public class RoundProgressBar extends View {
    private int C;
    private float D;
    private String E;
    private Rect F;
    private Paint G;
    private RectF H;

    /* renamed from: d, reason: collision with root package name */
    private int f326841d;

    /* renamed from: e, reason: collision with root package name */
    private int f326842e;

    /* renamed from: f, reason: collision with root package name */
    private int f326843f;

    /* renamed from: h, reason: collision with root package name */
    private int f326844h;

    /* renamed from: i, reason: collision with root package name */
    private int f326845i;

    /* renamed from: m, reason: collision with root package name */
    private int f326846m;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    private void a() {
        this.F = new Rect();
        Paint paint = new Paint(1);
        this.G = paint;
        paint.setAntiAlias(true);
        this.H = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.G.setColor(this.f326844h);
        this.G.setStyle(Paint.Style.STROKE);
        this.G.setStrokeWidth(this.f326843f);
        this.G.setStrokeCap(Paint.Cap.ROUND);
        int width = getWidth() / 2;
        int i3 = width - this.f326843f;
        float f16 = width;
        canvas.drawCircle(f16, f16, i3, this.G);
        this.G.setColor(this.f326845i);
        float f17 = width - i3;
        float f18 = i3 + width;
        this.H.set(f17, f17, f18, f18);
        canvas.drawArc(this.H, -90.0f, this.D, false, this.G);
        this.G.reset();
        this.G.setAntiAlias(true);
        this.G.setColor(this.f326842e);
        this.G.setTextSize(this.f326841d);
        Paint paint = this.G;
        String str = this.E;
        paint.getTextBounds(str, 0, str.length(), this.F);
        canvas.drawText(this.E, f16 - (this.F.width() / 2.0f), f16 + (this.F.height() / 2.0f), this.G);
    }

    public void setProgress(int i3) {
        this.C = i3;
        this.D = i3 * 3.6f;
        this.E = Math.round((this.D / 360.0f) * 100.0f) + "%";
        postInvalidate();
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = "0%";
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.tencent.mobileqq.wink.j.A6, i3, 0);
        this.f326841d = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.G6, (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
        this.f326842e = obtainStyledAttributes.getColor(com.tencent.mobileqq.wink.j.F6, -16777216);
        this.f326844h = obtainStyledAttributes.getColor(com.tencent.mobileqq.wink.j.B6, -16777216);
        this.f326843f = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.C6, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.f326845i = obtainStyledAttributes.getColor(com.tencent.mobileqq.wink.j.D6, -16777216);
        this.f326846m = obtainStyledAttributes.getInt(com.tencent.mobileqq.wink.j.E6, 10);
        obtainStyledAttributes.recycle();
        a();
    }
}
