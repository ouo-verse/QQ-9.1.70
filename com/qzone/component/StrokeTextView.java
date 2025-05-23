package com.qzone.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class StrokeTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private float f46285d;

    /* renamed from: e, reason: collision with root package name */
    private int f46286e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f46287f;

    public StrokeTextView(Context context) {
        super(context);
        this.f46286e = -16777216;
        this.f46287f = new TextView(context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        TextPaint paint2 = this.f46287f.getPaint();
        paint2.setTextSize(paint.getTextSize());
        paint2.setTypeface(paint.getTypeface());
        paint2.setFlags(paint.getFlags());
        paint2.setAlpha(paint.getAlpha());
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(this.f46286e);
        paint2.setStrokeWidth(this.f46285d);
        String charSequence = getText().toString();
        canvas.drawText(charSequence, (getWidth() - paint2.measureText(charSequence)) / 2.0f, getBaseline(), paint2);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public void setStrokeColor(int i3) {
        this.f46286e = i3;
        invalidate();
    }

    public void setStrokeWidth(int i3) {
        this.f46285d = i3;
        invalidate();
    }

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46286e = -16777216;
        this.f46287f = new TextView(context, attributeSet);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f46286e = -16777216;
        this.f46287f = new TextView(context, attributeSet, i3);
    }
}
