package com.qzone.album.ui.widget;

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
/* loaded from: classes39.dex */
public class AdvRoundFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f44116d;

    /* renamed from: e, reason: collision with root package name */
    private float f44117e;

    /* renamed from: f, reason: collision with root package name */
    private float f44118f;

    /* renamed from: h, reason: collision with root package name */
    private float f44119h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f44120i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f44121m;

    public AdvRoundFrameLayout(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        if (this.f44118f > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            float f16 = height;
            path.moveTo(0.0f, f16 - this.f44118f);
            path.lineTo(0.0f, f16);
            path.lineTo(this.f44118f, f16);
            float f17 = this.f44118f;
            path.arcTo(new RectF(0.0f, f16 - (f17 * 2.0f), f17 * 2.0f, f16), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.f44120i);
        }
    }

    private void b(Canvas canvas) {
        if (this.f44119h > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            float f16 = width;
            float f17 = height;
            path.moveTo(f16 - this.f44119h, f17);
            path.lineTo(f16, f17);
            path.lineTo(f16, f17 - this.f44119h);
            float f18 = this.f44119h;
            path.arcTo(new RectF(f16 - (f18 * 2.0f), f17 - (f18 * 2.0f), f16, f17), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.f44120i);
        }
    }

    private void c(Canvas canvas) {
        if (this.f44116d > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.f44116d);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.f44116d, 0.0f);
            float f16 = this.f44116d;
            path.arcTo(new RectF(0.0f, 0.0f, f16 * 2.0f, f16 * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.f44120i);
        }
    }

    private void d(Canvas canvas) {
        if (this.f44117e > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            float f16 = width;
            path.moveTo(f16 - this.f44117e, 0.0f);
            path.lineTo(f16, 0.0f);
            path.lineTo(f16, this.f44117e);
            float f17 = this.f44117e;
            path.arcTo(new RectF(f16 - (f17 * 2.0f), 0.0f, f16, f17 * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.f44120i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.f44121m, 31);
        super.dispatchDraw(canvas);
        c(canvas);
        d(canvas);
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    public void setRaduis(int i3) {
        float f16 = i3;
        this.f44116d = f16;
        this.f44117e = f16;
        this.f44118f = f16;
        this.f44119h = f16;
    }

    public AdvRoundFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdvRoundFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint();
        this.f44120i = paint;
        paint.setColor(-1);
        this.f44120i.setAntiAlias(true);
        this.f44120i.setStyle(Paint.Style.FILL);
        this.f44120i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f44121m = paint2;
        paint2.setXfermode(null);
    }

    public void setRaduis(int i3, int i16, int i17, int i18) {
        this.f44116d = i3;
        this.f44117e = i16;
        this.f44118f = i17;
        this.f44119h = i18;
    }
}
