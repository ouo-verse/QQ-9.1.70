package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RoundAngleFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f239182d;

    /* renamed from: e, reason: collision with root package name */
    private float f239183e;

    /* renamed from: f, reason: collision with root package name */
    private float f239184f;

    /* renamed from: h, reason: collision with root package name */
    private float f239185h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f239186i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f239187m;

    public RoundAngleFrameLayout(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        if (this.f239184f > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            float f16 = height;
            path.moveTo(0.0f, f16 - this.f239184f);
            path.lineTo(0.0f, f16);
            path.lineTo(this.f239184f, f16);
            float f17 = this.f239184f;
            path.arcTo(new RectF(0.0f, f16 - (f17 * 2.0f), f17 * 2.0f, f16), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.f239186i);
        }
    }

    private void b(Canvas canvas) {
        if (this.f239185h > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            float f16 = width;
            float f17 = height;
            path.moveTo(f16 - this.f239185h, f17);
            path.lineTo(f16, f17);
            path.lineTo(f16, f17 - this.f239185h);
            float f18 = this.f239185h;
            path.arcTo(new RectF(f16 - (f18 * 2.0f), f17 - (f18 * 2.0f), f16, f17), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.f239186i);
        }
    }

    private void c(Canvas canvas) {
        if (this.f239182d > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.f239182d);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.f239182d, 0.0f);
            float f16 = this.f239182d;
            path.arcTo(new RectF(0.0f, 0.0f, f16 * 2.0f, f16 * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.f239186i);
        }
    }

    private void d(Canvas canvas) {
        if (this.f239183e > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            float f16 = width;
            path.moveTo(f16 - this.f239183e, 0.0f);
            path.lineTo(f16, 0.0f);
            path.lineTo(f16, this.f239183e);
            float f17 = this.f239183e;
            path.arcTo(new RectF(f16 - (f17 * 2.0f), 0.0f, f16, f17 * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.f239186i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.f239187m, 31);
        super.dispatchDraw(canvas);
        c(canvas);
        d(canvas);
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    public void setRadius(int i3) {
        float f16 = i3;
        this.f239182d = f16;
        this.f239183e = f16;
        this.f239184f = f16;
        this.f239185h = f16;
    }

    public RoundAngleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint();
        this.f239186i = paint;
        paint.setColor(-1);
        this.f239186i.setAntiAlias(true);
        this.f239186i.setStyle(Paint.Style.FILL);
        this.f239186i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f239187m = paint2;
        paint2.setXfermode(null);
    }

    public void setRadius(int i3, int i16, int i17, int i18) {
        this.f239182d = i3;
        this.f239183e = i16;
        this.f239184f = i17;
        this.f239185h = i18;
    }
}
