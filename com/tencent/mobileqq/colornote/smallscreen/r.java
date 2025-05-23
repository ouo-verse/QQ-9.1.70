package com.tencent.mobileqq.colornote.smallscreen;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private k f201700a;

    /* renamed from: d, reason: collision with root package name */
    private float f201703d = 4.0f;

    /* renamed from: b, reason: collision with root package name */
    private final Path f201701b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f201702c = new Path();

    private void a(Drawable drawable, float f16) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            int abs = (int) ((Math.abs(intrinsicWidth - intrinsicHeight) * f16) / (Math.min(intrinsicWidth, intrinsicHeight) * 2));
            if (intrinsicWidth < intrinsicHeight) {
                int i3 = (int) f16;
                drawable.setBounds(0, -abs, i3, abs + i3);
                return;
            } else {
                int i16 = (int) f16;
                drawable.setBounds(-abs, 0, abs + i16, i16);
                return;
            }
        }
        int i17 = (int) f16;
        drawable.setBounds(0, 0, i17, i17);
    }

    private int d(int i3, float f16) {
        return (i3 | (-16777216)) & ((Math.round(f16 * 255.0f) << 24) | 16777215);
    }

    public void b(Canvas canvas, ea1.f fVar) {
        if (this.f201700a == null) {
            return;
        }
        canvas.save();
        float sin = (float) (fVar.f396026a * Math.sin(fVar.f396027b));
        float f16 = -((float) (fVar.f396026a * Math.cos(fVar.f396027b)));
        float f17 = fVar.f396028c;
        float f18 = sin - (f17 / 2.0f);
        float f19 = f16 - (f17 / 2.0f);
        canvas.translate(f18, f19);
        this.f201701b.reset();
        this.f201701b.addCircle(sin - f18, f16 - f19, (fVar.f396028c / 2.0f) - this.f201703d, Path.Direction.CW);
        if (fVar.f396032g != null) {
            this.f201702c.reset();
            ea1.f fVar2 = fVar.f396032g;
            float sin2 = (float) (fVar2.f396026a * Math.sin(fVar2.f396027b));
            ea1.f fVar3 = fVar.f396032g;
            this.f201702c.addCircle(sin2 - f18, (-((float) (fVar3.f396026a * Math.cos(fVar3.f396027b)))) - f19, fVar.f396032g.f396028c / 2.0f, Path.Direction.CW);
            this.f201701b.op(this.f201702c, Path.Op.DIFFERENCE);
        }
        canvas.clipPath(this.f201701b);
        int b16 = this.f201700a.b();
        if (fVar.f396031f) {
            canvas.drawColor(d(b16, fVar.f396029d));
        }
        Drawable c16 = this.f201700a.c();
        if (c16 != null && fVar.f396031f) {
            a(c16, fVar.f396028c);
            c16.draw(canvas);
        }
        float f26 = fVar.f396030e;
        if (f26 > 0.0f) {
            canvas.drawColor(d(b16, f26));
        }
        canvas.restore();
    }

    public void c(String str, int i3) {
        k kVar = this.f201700a;
        if (kVar != null) {
            kVar.f(str, i3);
        }
    }

    public void e(k kVar) {
        this.f201700a = kVar;
    }

    public void f(float f16) {
        this.f201703d = f16;
    }
}
