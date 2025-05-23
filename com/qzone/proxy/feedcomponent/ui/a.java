package com.qzone.proxy.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.qzone.proxy.feedcomponent.ui.e;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: k, reason: collision with root package name */
    public static final int f50813k = com.qzone.proxy.feedcomponent.util.g.a(110.0f);

    /* renamed from: l, reason: collision with root package name */
    public static final int f50814l = com.qzone.proxy.feedcomponent.util.g.a(220.0f);

    /* renamed from: a, reason: collision with root package name */
    CustomPraiseView f50815a;

    /* renamed from: b, reason: collision with root package name */
    e f50816b;

    /* renamed from: c, reason: collision with root package name */
    e.a f50817c;

    /* renamed from: d, reason: collision with root package name */
    final int f50818d = 16000000;

    /* renamed from: e, reason: collision with root package name */
    Matrix f50819e;

    /* renamed from: f, reason: collision with root package name */
    Random f50820f;

    /* renamed from: g, reason: collision with root package name */
    int f50821g;

    /* renamed from: h, reason: collision with root package name */
    int f50822h;

    /* renamed from: i, reason: collision with root package name */
    int f50823i;

    /* renamed from: j, reason: collision with root package name */
    int f50824j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CustomPraiseView customPraiseView) {
        this.f50815a = customPraiseView;
        d();
    }

    public static void f(String str) {
        com.qzone.proxy.feedcomponent.b.e("LiveLikeSurfaceView", str);
    }

    public void b(Canvas canvas) {
        this.f50816b.b(canvas, this.f50819e);
    }

    void d() {
        e eVar = new e();
        this.f50816b = eVar;
        this.f50817c = eVar.d();
        this.f50820f = new Random(System.currentTimeMillis());
        this.f50819e = new Matrix();
        this.f50821g = 0;
        this.f50822h = 0;
        this.f50823i = 0;
        this.f50824j = 0;
        h();
    }

    public boolean e() {
        return this.f50816b.g();
    }

    public void g() {
        this.f50816b.f();
    }

    public void h() {
        int i3 = f50813k;
        int i16 = f50814l;
        if (i3 == 0 || i16 == 0) {
            return;
        }
        this.f50817c.i(this.f50821g);
        this.f50817c.j(this.f50822h);
        this.f50817c.k(this.f50823i);
        this.f50817c.h(this.f50824j);
        this.f50817c.a(i3, i16);
    }

    public void i() {
        this.f50816b.i();
    }

    public int c(int i3) {
        if (i3 <= 0) {
            return 0;
        }
        return this.f50820f.nextInt(i3);
    }

    public boolean j(int i3) {
        if (i3 > 100) {
            f(String.format("too much items to render, item size=%s", Integer.valueOf(i3)));
            return true;
        }
        if (i3 <= 30) {
            return false;
        }
        boolean z16 = this.f50820f.nextInt(70) + 30 < i3;
        f(String.format("drop item mode:item size=%s, current item dropped=", Integer.valueOf(i3), Boolean.valueOf(z16)));
        return z16;
    }

    public void a(Drawable drawable, long j3) {
        if (drawable == null) {
            return;
        }
        if (j3 > 0 || !j(this.f50816b.c())) {
            int e16 = this.f50817c.e();
            k d16 = k.d();
            d16.f50865n = drawable;
            d16.f50852a = SystemClock.uptimeMillis() + j3;
            long j16 = e16;
            d16.f50853b = j16;
            d16.f50855d = new Point(-1, -1);
            d16.f50856e = this.f50817c.g();
            d16.f50854c = d16.f50852a + j16;
            d16.f50862k = 0;
            this.f50816b.a(d16);
        }
    }
}
