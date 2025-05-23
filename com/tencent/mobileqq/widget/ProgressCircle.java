package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;

/* loaded from: classes20.dex */
public class ProgressCircle extends View {
    public boolean C;
    public int D;
    public int E;
    public int F;
    public Paint.Style G;

    /* renamed from: d, reason: collision with root package name */
    private Paint f316007d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f316008e;

    /* renamed from: f, reason: collision with root package name */
    private int f316009f;

    /* renamed from: h, reason: collision with root package name */
    private int f316010h;

    /* renamed from: i, reason: collision with root package name */
    private int f316011i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f316012m;

    public ProgressCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316012m = true;
        this.C = false;
        this.F = 2;
        this.G = Paint.Style.STROKE;
        a();
    }

    protected void a() {
        this.f316007d = new Paint();
        this.f316008e = new RectF();
        this.f316010h = 2;
        this.f316011i = 18;
        this.D = getResources().getColor(R.color.skin_color_button_white);
        this.E = getResources().getColor(R.color.skin_color_button_white);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (width != height) {
            if (width >= height) {
                width = height;
            }
            height = width;
        }
        this.f316007d.setAntiAlias(true);
        this.f316007d.setColor(-1);
        canvas.drawColor(0);
        RectF rectF = this.f316008e;
        int i3 = this.f316010h;
        rectF.left = i3 / 2;
        rectF.top = i3 / 2;
        rectF.right = width - (i3 / 2);
        rectF.bottom = height - (i3 / 2);
        this.f316007d.setStrokeWidth(i3);
        this.f316007d.setColor(this.D);
        this.f316007d.setStyle(this.G);
        canvas.drawArc(this.f316008e, -90.0f, 360.0f, false, this.f316007d);
        this.f316007d.setColor(this.E);
        this.f316007d.setStrokeWidth(this.f316010h * this.F);
        RectF rectF2 = this.f316008e;
        int i16 = this.f316010h;
        rectF2.left = i16;
        rectF2.top = i16;
        rectF2.right = width - i16;
        rectF2.bottom = height - i16;
        canvas.drawArc(rectF2, -90.0f, (this.f316009f / 100.0f) * 360.0f, false, this.f316007d);
        if (this.f316012m) {
            int i17 = width / 2;
            int i18 = height / 2;
            this.f316007d.setStyle(Paint.Style.FILL);
            this.f316007d.setStrokeWidth(this.f316010h);
            int i19 = this.f316011i;
            canvas.drawRect(new RectF(i17 - (i19 / 2), i18 - (i19 / 2), i17 + (i19 / 2), i18 + (i19 / 2)), this.f316007d);
        }
        if (this.C) {
            String str = this.f316009f + "%";
            this.f316007d.setTextSize(40.0f);
            this.f316007d.setStrokeWidth(1.0f);
            this.f316007d.setColor(-1);
            this.f316007d.setStyle(Paint.Style.FILL);
            float measureText = this.f316007d.measureText(str);
            Paint.FontMetricsInt fontMetricsInt = this.f316007d.getFontMetricsInt();
            int height2 = getHeight();
            int i26 = fontMetricsInt.descent;
            int i27 = fontMetricsInt.ascent;
            canvas.drawText(str, (int) ((getWidth() - measureText) / 2.0f), ((height2 - (i26 - i27)) / 2) + (-i27), this.f316007d);
        }
    }

    public void setProgress(int i3) {
        this.f316009f = i3;
        postInvalidate();
    }
}
