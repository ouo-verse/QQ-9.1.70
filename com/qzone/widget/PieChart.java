package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes37.dex */
public class PieChart extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f60444d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f60445e;

    /* renamed from: f, reason: collision with root package name */
    private float f60446f;

    public PieChart(Context context) {
        super(context);
        this.f60446f = 0.0f;
        a();
    }

    public void a() {
        Paint paint = new Paint();
        this.f60444d = paint;
        paint.setColor(-13002006);
        this.f60444d.setAntiAlias(true);
        this.f60445e = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f60445e;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getWidth();
        this.f60445e.bottom = getHeight();
        canvas.drawArc(this.f60445e, -90.0f, this.f60446f * 360.0f, true, this.f60444d);
        super.onDraw(canvas);
    }

    public void setPercent(float f16) {
        this.f60446f = f16;
        if (f16 > 0.98d) {
            this.f60446f = 1.0f;
        }
        invalidate();
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60446f = 0.0f;
        a();
    }

    public PieChart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60446f = 0.0f;
        a();
    }
}
