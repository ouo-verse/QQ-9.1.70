package com.tencent.gamecenter.wadl.biz.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import jl0.d;

/* loaded from: classes6.dex */
public class WadlRoundProgressBar extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f106878d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f106879e;

    /* renamed from: f, reason: collision with root package name */
    private float f106880f;

    /* renamed from: h, reason: collision with root package name */
    private int f106881h;

    /* renamed from: i, reason: collision with root package name */
    private int f106882i;

    /* renamed from: m, reason: collision with root package name */
    private int f106883m;

    public WadlRoundProgressBar(Context context) {
        this(context, null);
    }

    private void a() {
        this.f106878d = new Paint(1);
        this.f106879e = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f106878d.setAntiAlias(true);
        this.f106878d.setColor(this.f106882i);
        this.f106878d.setStyle(Paint.Style.FILL);
        this.f106878d.setStrokeWidth(this.f106881h);
        this.f106878d.setStrokeCap(Paint.Cap.ROUND);
        int width = getWidth() / 2;
        int i3 = width - this.f106881h;
        float f16 = width;
        canvas.drawCircle(f16, f16, i3, this.f106878d);
        this.f106878d.setStyle(Paint.Style.STROKE);
        this.f106878d.setColor(this.f106883m);
        float f17 = width - i3;
        float f18 = i3 + width;
        this.f106879e.set(f17, f17, f18, f18);
        canvas.drawArc(this.f106879e, -90.0f, this.f106880f, false, this.f106878d);
    }

    public void setProgress(int i3) {
        this.f106880f = i3 * 3.6f;
        postInvalidate();
    }

    public WadlRoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WadlRoundProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, d.f410542x4, i3, 0);
        this.f106882i = obtainStyledAttributes.getColor(d.f410550y4, -16777216);
        this.f106881h = obtainStyledAttributes.getDimensionPixelSize(d.f410558z4, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.f106883m = obtainStyledAttributes.getColor(d.A4, -16777216);
        obtainStyledAttributes.recycle();
        a();
    }
}
