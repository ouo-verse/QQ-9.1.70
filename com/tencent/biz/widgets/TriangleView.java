package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TriangleView extends View {

    /* renamed from: d, reason: collision with root package name */
    Paint f97743d;

    /* renamed from: e, reason: collision with root package name */
    Path f97744e;

    /* renamed from: f, reason: collision with root package name */
    Paint f97745f;

    public TriangleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f97743d = paint;
        paint.setColor(-1);
        this.f97744e = new Path();
        Paint paint2 = new Paint();
        this.f97745f = paint2;
        paint2.setColor(-2170912);
        this.f97745f.setStrokeWidth(2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        int i3 = (measuredHeight * 2) + 150;
        float f16 = measuredHeight + 150;
        this.f97744e.moveTo(f16, 0.0f);
        float f17 = 150;
        float f18 = measuredHeight;
        this.f97744e.lineTo(f17, f18);
        float f19 = i3;
        this.f97744e.lineTo(f19, f18);
        this.f97744e.close();
        canvas.drawPath(this.f97744e, this.f97743d);
        this.f97745f.setStrokeWidth(1.0f);
        canvas.drawLine(f16, 0.0f, f17, f18, this.f97745f);
        canvas.drawLine(f16, 0.0f, f19, f18, this.f97745f);
        this.f97745f.setStrokeWidth(2.0f);
        canvas.drawLine(0.0f, f18, f17, f18, this.f97745f);
        canvas.drawLine(f19, f18, getMeasuredWidth(), f18, this.f97745f);
    }

    public void setColor(int i3) {
        this.f97743d.setColor(i3);
    }
}
