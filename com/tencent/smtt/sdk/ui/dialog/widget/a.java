package com.tencent.smtt.sdk.ui.dialog.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f369584a;

    /* renamed from: b, reason: collision with root package name */
    private int f369585b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f369586c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f369587d;

    /* renamed from: e, reason: collision with root package name */
    private Path f369588e;

    /* renamed from: f, reason: collision with root package name */
    private Path f369589f;

    /* renamed from: g, reason: collision with root package name */
    private RectF f369590g;

    /* renamed from: h, reason: collision with root package name */
    private float[] f369591h;

    /* renamed from: i, reason: collision with root package name */
    private float f369592i;

    /* renamed from: j, reason: collision with root package name */
    private float f369593j;

    public a(Context context, float f16, float f17, float f18) {
        super(context, null, 0);
        a(context, f16, f17, f18);
    }

    private void a(Context context, float f16, float f17, float f18) {
        this.f369592i = f17;
        this.f369593j = f18;
        int parseColor = Color.parseColor("#989DB4");
        float a16 = a(context, 6.0f);
        this.f369586c = new Paint();
        Paint paint = new Paint();
        this.f369587d = paint;
        paint.setColor(-1);
        this.f369587d.setStyle(Paint.Style.FILL);
        this.f369587d.setAntiAlias(true);
        this.f369586c.setColor(parseColor);
        this.f369586c.setStyle(Paint.Style.STROKE);
        this.f369586c.setAntiAlias(true);
        this.f369586c.setStrokeWidth(a16);
        this.f369586c.setStrokeJoin(Paint.Join.ROUND);
        this.f369590g = new RectF();
        this.f369591h = new float[]{f16, f16, f16, f16, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0.0f, 0.0f);
        canvas.rotate(0.0f);
        if (this.f369589f == null) {
            this.f369589f = new Path();
        }
        this.f369589f.reset();
        this.f369589f.addRoundRect(this.f369590g, this.f369591h, Path.Direction.CCW);
        this.f369589f.close();
        canvas.drawPath(this.f369589f, this.f369587d);
        canvas.translate(this.f369584a / 2.0f, (this.f369585b / 2.0f) + (this.f369593j / 2.0f));
        if (this.f369588e == null) {
            this.f369588e = new Path();
        }
        this.f369588e.reset();
        this.f369588e.moveTo(0.0f, 0.0f);
        this.f369588e.lineTo((-this.f369592i) / 2.0f, (-this.f369593j) / 2.0f);
        this.f369588e.close();
        canvas.drawPath(this.f369588e, this.f369586c);
        this.f369588e.reset();
        this.f369588e.moveTo(0.0f, 0.0f);
        this.f369588e.lineTo(this.f369592i / 2.0f, (-this.f369593j) / 2.0f);
        this.f369588e.close();
        canvas.drawPath(this.f369588e, this.f369586c);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(a(i3), a(i16));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f369584a = i3;
        this.f369585b = i16;
        RectF rectF = this.f369590g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = i3;
        rectF.bottom = i16;
    }

    private int a(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(100, size);
        }
        return 100;
    }

    public static int a(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
