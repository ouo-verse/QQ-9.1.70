package com.tencent.luggage.wxa.vc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends Canvas {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f143351a;

    public f(Bitmap bitmap) {
        super(bitmap);
        b();
        this.f143351a = bitmap;
    }

    public void a(float f16, float f17, float f18, float f19) {
        Bitmap a16 = com.tencent.luggage.wxa.tk.e.a(this.f143351a, new RectF(0.0f, 0.0f, this.f143351a.getWidth(), this.f143351a.getHeight()), new RectF(f16, f17, f18, f19), Region.Op.DIFFERENCE);
        if (a16 == null || a16.isRecycled()) {
            return;
        }
        this.f143351a.eraseColor(0);
        drawBitmap(a16, 0.0f, 0.0f, (Paint) null);
        a16.recycle();
    }

    @Override // android.graphics.Canvas
    public void setBitmap(Bitmap bitmap) {
        super.setBitmap(bitmap);
        this.f143351a = bitmap;
    }

    public Bitmap a() {
        return this.f143351a;
    }

    public final void b() {
    }
}
