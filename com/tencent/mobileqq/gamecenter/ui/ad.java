package com.tencent.mobileqq.gamecenter.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ad extends ColorDrawable {

    /* renamed from: a, reason: collision with root package name */
    private final RectF f213291a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f213292b;

    /* renamed from: c, reason: collision with root package name */
    private final int f213293c;

    /* renamed from: d, reason: collision with root package name */
    private final int f213294d;

    /* renamed from: e, reason: collision with root package name */
    private float f213295e;

    public ad(int i3, float f16, int i16, int i17) {
        super(i3);
        RectF rectF = new RectF();
        this.f213291a = rectF;
        this.f213295e = f16;
        Paint paint = new Paint();
        this.f213292b = paint;
        paint.setAntiAlias(true);
        paint.setColor(i3);
        rectF.set(0.0f, 0.0f, i16, i17);
        this.f213293c = i16;
        this.f213294d = i17;
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.f213291a;
        float f16 = this.f213295e;
        canvas.drawRoundRect(rectF, f16, f16, this.f213292b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f213294d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f213293c;
    }
}
