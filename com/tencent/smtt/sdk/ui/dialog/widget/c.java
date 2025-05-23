package com.tencent.smtt.sdk.ui.dialog.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private float f369603a;

    /* renamed from: b, reason: collision with root package name */
    private float f369604b;

    /* renamed from: c, reason: collision with root package name */
    private float f369605c;

    /* renamed from: d, reason: collision with root package name */
    private float f369606d;

    /* renamed from: e, reason: collision with root package name */
    private Path f369607e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f369608f;

    /* renamed from: g, reason: collision with root package name */
    private RectF f369609g;

    public c(int i3, float f16, float f17, float f18, float f19) {
        this.f369603a = f16;
        this.f369604b = f17;
        this.f369606d = f18;
        this.f369605c = f19;
        Paint paint = new Paint();
        this.f369608f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f369608f.setAntiAlias(true);
        this.f369608f.setColor(i3);
        this.f369609g = new RectF();
    }

    public void a(int i3, int i16) {
        RectF rectF = this.f369609g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = i3;
        rectF.bottom = i16;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f369607e == null) {
            this.f369607e = new Path();
        }
        this.f369607e.reset();
        Path path = this.f369607e;
        RectF rectF = this.f369609g;
        float f16 = this.f369603a;
        float f17 = this.f369604b;
        float f18 = this.f369606d;
        float f19 = this.f369605c;
        path.addRoundRect(rectF, new float[]{f16, f16, f17, f17, f18, f18, f19, f19}, Path.Direction.CCW);
        this.f369607e.close();
        canvas.drawPath(this.f369607e, this.f369608f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f369608f.setAlpha(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f369608f.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
