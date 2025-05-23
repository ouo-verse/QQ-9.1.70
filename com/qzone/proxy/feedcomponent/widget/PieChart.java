package com.qzone.proxy.feedcomponent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes39.dex */
public class PieChart extends View {

    /* renamed from: d, reason: collision with root package name */
    Paint f50935d;

    /* renamed from: e, reason: collision with root package name */
    RectF f50936e;

    /* renamed from: f, reason: collision with root package name */
    float f50937f;

    /* renamed from: h, reason: collision with root package name */
    int f50938h;

    public PieChart(Context context) {
        super(context);
        this.f50938h = -13985044;
        a();
    }

    public void a() {
        Paint paint = new Paint();
        this.f50935d = paint;
        paint.setColor(this.f50938h);
        this.f50935d.setAntiAlias(true);
        this.f50936e = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f50936e;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getWidth();
        this.f50936e.bottom = getHeight();
        canvas.drawArc(this.f50936e, -90.0f, this.f50937f * 360.0f, true, this.f50935d);
        super.onDraw(canvas);
    }

    public void setColor(int i3) {
        this.f50938h = i3;
        this.f50935d.setColor(i3);
    }

    public void setPercent(float f16) {
        this.f50937f = f16;
        if (f16 > 0.98d) {
            this.f50937f = 1.0f;
        }
        invalidate();
    }

    public void b() {
        this.f50937f = 0.0f;
        invalidate();
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50938h = -13985044;
        a();
    }

    public PieChart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f50938h = -13985044;
        a();
    }
}
