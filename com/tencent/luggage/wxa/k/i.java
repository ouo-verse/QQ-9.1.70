package com.tencent.luggage.wxa.k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.util.Size;
import android.view.View;
import com.tencent.luggage.wxa.l.a;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public final a f131333a;

    /* renamed from: b, reason: collision with root package name */
    public final o f131334b;

    /* renamed from: c, reason: collision with root package name */
    public Size f131335c = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void a(String str);

        void a(byte[] bArr);

        void a(byte[] bArr, int i3, int i16, int i17);

        void b();

        void c();
    }

    public i(a aVar, o oVar) {
        this.f131333a = aVar;
        this.f131334b = oVar;
    }

    public abstract boolean A();

    public abstract void B();

    public abstract boolean C();

    public abstract void D();

    public abstract void E();

    public abstract void F();

    public a.c a(Context context, List list) {
        Point point;
        float f16 = f();
        int p16 = p();
        Point a16 = a(context);
        int b16 = com.tencent.luggage.wxa.l.b.b(context);
        if (b16 != 90 && b16 != 270) {
            point = new Point(a16.x, a16.y);
        } else {
            point = new Point(a16.y, a16.x);
        }
        if (f16 == 0.0f) {
            f.d("CameraViewImpl", "DisplayRatio is 0, skip getReasonableSize");
            return null;
        }
        if (list != null && !list.isEmpty()) {
            float f17 = 1.0f / f16;
            if (f16 >= 1.0f) {
                p16 = Math.round(p16 / f17);
            }
            int e16 = e();
            boolean z16 = e16 == 90 || e16 == 270;
            a.c a17 = com.tencent.luggage.wxa.l.a.a(context, list, point, p16, z16);
            if (a17 == null || a17.f132753a == null) {
                f.b("CameraViewImpl", "fuck, preview size still null!!");
                a17 = com.tencent.luggage.wxa.l.a.b(context, list, point, p16, z16);
            }
            if (a17 == null || a17.f132753a == null) {
                return null;
            }
            return a17;
        }
        f.d("CameraViewImpl", "supportSizes is empty, skip getReasonableSize");
        return null;
    }

    public abstract void a(float f16);

    public abstract void a(float f16, float f17);

    public abstract void a(int i3);

    public abstract void a(SurfaceTexture surfaceTexture);

    public abstract void a(q qVar);

    public abstract void a(Float f16);

    public abstract void a(boolean z16);

    public abstract boolean a(com.tencent.luggage.wxa.k.a aVar);

    public abstract boolean a(String str, int i3, int i16, boolean z16, CamcorderProfile camcorderProfile, boolean z17);

    public abstract com.tencent.luggage.wxa.k.a b();

    public abstract void b(float f16);

    public abstract void b(int i3);

    public abstract void b(boolean z16);

    public abstract void c(float f16);

    public abstract void c(int i3);

    public abstract void c(boolean z16);

    public abstract boolean c();

    public abstract int d();

    public abstract void d(int i3);

    public abstract int e();

    public abstract void e(int i3);

    public abstract float f();

    public abstract int g();

    public abstract int h();

    public int i() {
        return 300;
    }

    public abstract float j();

    public int k() {
        return 1000;
    }

    public abstract float l();

    public abstract q m();

    public abstract r n();

    public abstract q o();

    public abstract int p();

    public abstract r q();

    public abstract boolean r();

    public abstract float[] s();

    public abstract Set t();

    public abstract Point u();

    public View v() {
        return this.f131334b.g();
    }

    public abstract int w();

    public abstract float x();

    public abstract boolean y();

    public abstract boolean z();

    public com.tencent.luggage.wxa.k.a a() {
        r q16 = q();
        r n3 = n();
        Set c16 = q16.c();
        com.tencent.luggage.wxa.k.a aVar = j.f131336a;
        if (!c16.contains(aVar) || !n3.c().contains(aVar)) {
            Set c17 = q16.c();
            aVar = j.f131337b;
            if (!c17.contains(aVar) || !n3.c().contains(aVar)) {
                aVar = (com.tencent.luggage.wxa.k.a) q16.c().iterator().next();
            }
        }
        f.c("CameraViewImpl", "chooseAspectRatio, aspect ratio changed to " + aVar.toString());
        return aVar;
    }

    public final Point a(Context context) {
        if (this.f131335c == null) {
            return com.tencent.luggage.wxa.l.b.a(context);
        }
        return new Point(this.f131335c.getWidth(), this.f131335c.getHeight());
    }

    public void a(Size size) {
        this.f131335c = size;
    }
}
