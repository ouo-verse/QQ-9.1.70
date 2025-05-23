package com.tencent.guild.aio.halfpop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes6.dex */
public class RoundAngleLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f110661d;

    /* renamed from: e, reason: collision with root package name */
    private float f110662e;

    /* renamed from: f, reason: collision with root package name */
    private float f110663f;

    /* renamed from: h, reason: collision with root package name */
    private float f110664h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f110665i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f110666m;

    public RoundAngleLinearLayout(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        if (this.f110663f > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            float f16 = height;
            path.moveTo(0.0f, f16 - this.f110663f);
            path.lineTo(0.0f, f16);
            path.lineTo(this.f110663f, f16);
            float f17 = this.f110663f;
            path.arcTo(new RectF(0.0f, f16 - (f17 * 2.0f), f17 * 2.0f, f16), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.f110665i);
        }
    }

    private void b(Canvas canvas) {
        if (this.f110664h > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            float f16 = width;
            float f17 = height;
            path.moveTo(f16 - this.f110664h, f17);
            path.lineTo(f16, f17);
            path.lineTo(f16, f17 - this.f110664h);
            float f18 = this.f110664h;
            path.arcTo(new RectF(f16 - (f18 * 2.0f), f17 - (f18 * 2.0f), f16, f17), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.f110665i);
        }
    }

    private void c(Canvas canvas) {
        if (this.f110661d > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.f110661d);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.f110661d, 0.0f);
            float f16 = this.f110661d;
            path.arcTo(new RectF(0.0f, 0.0f, f16 * 2.0f, f16 * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.f110665i);
        }
    }

    private void d(Canvas canvas) {
        if (this.f110662e > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            float f16 = width;
            path.moveTo(f16 - this.f110662e, 0.0f);
            path.lineTo(f16, 0.0f);
            path.lineTo(f16, this.f110662e);
            float f17 = this.f110662e;
            path.arcTo(new RectF(f16 - (f17 * 2.0f), 0.0f, f16, f17 * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.f110665i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.f110666m, 31);
        super.dispatchDraw(canvas);
        c(canvas);
        d(canvas);
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    public void setRadius(int i3) {
        float f16 = i3;
        this.f110661d = f16;
        this.f110662e = f16;
        this.f110663f = f16;
        this.f110664h = f16;
    }

    public RoundAngleLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        wn0.a aVar = wn0.a.f445842a;
        this.f110661d = aVar.b(8);
        this.f110662e = aVar.b(8);
        this.f110663f = 0.0f;
        this.f110664h = 0.0f;
        Paint paint = new Paint();
        this.f110665i = paint;
        paint.setColor(-16776961);
        this.f110665i.setAntiAlias(true);
        this.f110665i.setStyle(Paint.Style.FILL);
        this.f110665i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f110666m = paint2;
        paint2.setXfermode(null);
    }

    public void setRadius(int i3, int i16, int i17, int i18) {
        this.f110661d = i3;
        this.f110662e = i16;
        this.f110663f = i17;
        this.f110664h = i18;
    }
}
