package com.tencent.av.doodle;

import android.graphics.Canvas;
import android.graphics.PointF;
import androidx.core.internal.view.SupportMenu;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    final String f73608a;

    /* renamed from: b, reason: collision with root package name */
    public int f73609b = 1;

    /* renamed from: c, reason: collision with root package name */
    public String f73610c = "unused";

    /* renamed from: d, reason: collision with root package name */
    public int f73611d = 12;

    /* renamed from: e, reason: collision with root package name */
    public int f73612e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f73613f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f73614g = SupportMenu.CATEGORY_MASK;

    /* renamed from: h, reason: collision with root package name */
    public PointF f73615h = new PointF();

    /* renamed from: i, reason: collision with root package name */
    public long f73616i = -1;

    public b() {
        String str = "DoodleItem_" + getClass().getSimpleName() + "_" + com.tencent.av.utils.e.d();
        this.f73608a = str;
        if (com.tencent.av.utils.e.k()) {
            QLog.w(str, 1, getClass().getSimpleName());
        }
    }

    public abstract void a(Canvas canvas, MySurfaceView mySurfaceView, boolean z16);

    public void b(Canvas canvas, MySurfaceView mySurfaceView, boolean z16) {
        float f16;
        float f17;
        int width = mySurfaceView.getWidth();
        int height = mySurfaceView.getHeight();
        int i3 = this.f73613f;
        int i16 = this.f73612e;
        float f18 = 0.0f;
        if (width * i3 < height * i16) {
            f16 = width / i16;
            f17 = (height - (i3 * f16)) / 2.0f;
        } else {
            float f19 = height / i3;
            f18 = (width - (i16 * f19)) / 2.0f;
            f16 = f19;
            f17 = 0.0f;
        }
        if (canvas != null) {
            canvas.save();
            canvas.translate(f18, f17);
            canvas.scale(f16, f16);
            a(canvas, mySurfaceView, z16);
            try {
                canvas.restore();
            } catch (Exception e16) {
                AVCoreLog.printErrorLog(this.f73608a, e16.getMessage());
            }
        }
    }

    public abstract void c(float f16, float f17);

    public abstract void d(long j3);

    public boolean e(float f16, float f17) {
        boolean z16;
        float abs = Math.abs(f16 - this.f73615h.x);
        float abs2 = Math.abs(f17 - this.f73615h.y);
        if (abs < 8.0f && abs2 < 8.0f) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            c(f16, f17);
            PointF pointF = this.f73615h;
            pointF.x = f16;
            pointF.y = f17;
        }
        return z16;
    }

    public void f(float f16, float f17) {
        PointF pointF = this.f73615h;
        pointF.x = f16;
        pointF.y = f17;
    }

    public abstract void g(float f16, float f17);

    public String toString() {
        return this.f73608a + ", mPenType[" + this.f73609b + "], mPoint[" + this.f73615h.x + "," + this.f73615h.y + "]";
    }
}
