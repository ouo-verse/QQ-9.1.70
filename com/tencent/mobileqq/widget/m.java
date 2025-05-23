package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m extends s {

    /* renamed from: p, reason: collision with root package name */
    private float f317092p;

    /* renamed from: q, reason: collision with root package name */
    private int f317093q;

    /* renamed from: m, reason: collision with root package name */
    private int f317089m = -872415232;

    /* renamed from: n, reason: collision with root package name */
    private int f317090n = 0;

    /* renamed from: l, reason: collision with root package name */
    private Paint f317088l = new Paint();

    /* renamed from: o, reason: collision with root package name */
    private PorterDuffXfermode f317091o = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        int centerX = bounds.centerX();
        int i3 = this.f317093q;
        canvas.clipRect(bounds);
        canvas.drawColor(this.f317089m);
        this.f317088l.setStyle(Paint.Style.FILL);
        this.f317088l.setColor(this.f317090n);
        this.f317088l.setXfermode(this.f317091o);
        canvas.drawCircle(centerX, this.f317092p, i3, this.f317088l);
        canvas.restore();
    }

    public void e(float f16) {
        this.f317092p = f16;
    }

    public void f(int i3) {
        this.f317093q = i3;
    }
}
