package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CustomGuideView extends View {
    public int C;
    public int D;
    public int E;
    public float F;
    public int G;
    public int H;
    public int I;

    /* renamed from: d, reason: collision with root package name */
    private TextPaint f96956d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f96957e;

    /* renamed from: f, reason: collision with root package name */
    private Path f96958f;

    /* renamed from: h, reason: collision with root package name */
    public String f96959h;

    /* renamed from: i, reason: collision with root package name */
    public int f96960i;

    /* renamed from: m, reason: collision with root package name */
    public int f96961m;

    public CustomGuideView(Context context) {
        super(context);
        this.f96959h = HardCodeUtil.qqStr(R.string.l7d);
        b();
    }

    private int a(float f16) {
        return (int) ((f16 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int d(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i3, size);
        }
        return i3;
    }

    public void b() {
        Paint paint = new Paint();
        this.f96957e = paint;
        paint.setAntiAlias(true);
        this.f96957e.setFilterBitmap(true);
        this.f96956d = new TextPaint();
        this.f96958f = new Path();
        this.E = a(12.5f);
        this.f96960i = a(30.0f);
        this.f96961m = a(7.0f);
        this.C = a(5.0f);
        this.D = 0;
        this.F = a(12.0f);
    }

    public int c() {
        return this.f96960i + this.f96961m;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        float width = (getWidth() * 0.9f) - this.I;
        float f16 = this.f96961m;
        this.f96958f.reset();
        this.f96958f.moveTo(width, f16);
        this.f96958f.lineTo((this.I / 2) + width, 0.0f);
        this.f96958f.lineTo(width + this.I, f16);
        this.f96957e.setColor(this.H);
        this.f96957e.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.f96958f, this.f96957e);
        RectF rectF = new RectF(0.0f, this.f96961m, getWidth(), getHeight());
        int i3 = this.E;
        canvas.drawRoundRect(rectF, i3, i3, this.f96957e);
        this.f96956d.setColor(this.G);
        this.f96956d.setTextSize(this.F);
        Paint.FontMetrics fontMetrics = this.f96956d.getFontMetrics();
        canvas.drawText(this.f96959h, (getWidth() - this.f96956d.measureText(this.f96959h)) / 2.0f, this.f96961m + ((rectF.height() - (fontMetrics.ascent + fontMetrics.bottom)) / 2.0f), this.f96956d);
    }

    public int e() {
        this.f96956d.setTextSize(this.F);
        return (int) (this.f96956d.measureText(this.f96959h) + (this.C * 2) + (this.D * 2) + (this.E * 2) + 0.5f);
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        setMeasuredDimension(d(e(), i3), d(c(), i16));
    }

    public CustomGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f96959h = HardCodeUtil.qqStr(R.string.l7d);
        b();
    }

    public CustomGuideView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f96959h = HardCodeUtil.qqStr(R.string.l7d);
        b();
    }
}
