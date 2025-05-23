package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.doodle.m;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private m f178569a = new m();

    /* renamed from: b, reason: collision with root package name */
    private o f178570b;

    /* renamed from: c, reason: collision with root package name */
    private g f178571c;

    public n(g gVar, int i3, List<m.a> list, int i16) {
        g gVar2 = new g();
        this.f178571c = gVar2;
        if (gVar == null) {
            return;
        }
        gVar2.i(gVar);
        this.f178569a.k(i3);
        this.f178569a.l(i16);
        this.f178569a.b(list);
    }

    public void a(float f16, float f17, long j3) {
        float f18 = this.f178571c.f();
        m.a f19 = this.f178569a.f();
        if (f19 != null) {
            long b16 = j3 - f19.b();
            if (b16 <= 0) {
                f18 = f19.c();
            } else {
                f18 = this.f178571c.c(b16, f19.d(), f19.e(), f16, f17);
            }
        } else {
            this.f178570b = null;
        }
        o oVar = this.f178570b;
        if (oVar != null) {
            oVar.b(f16, f17, f18, j3);
        }
        this.f178569a.a(f16, f17, f18, j3);
    }

    public void b(Canvas canvas, boolean z16) {
        if (this.f178570b != null && canvas != null) {
            if (z16) {
                this.f178570b.t(0, 0, canvas.getWidth(), canvas.getHeight());
            }
            this.f178570b.e(canvas);
        }
    }

    public boolean c(Canvas canvas, int i3, int i16) {
        o oVar = this.f178570b;
        if (oVar != null) {
            return oVar.h(canvas, i3, i16);
        }
        return false;
    }

    public void d(boolean z16) {
        o oVar = this.f178570b;
        if (oVar != null) {
            oVar.k(z16);
        }
    }

    public int e() {
        m mVar = this.f178569a;
        if (mVar == null) {
            return 0;
        }
        return mVar.g();
    }

    public int f() {
        o oVar = this.f178570b;
        if (oVar == null) {
            return 0;
        }
        return oVar.m();
    }

    public boolean g() {
        if (this.f178569a == null) {
            return false;
        }
        h();
        return true;
    }

    public o h() {
        o oVar = this.f178570b;
        if (oVar != null) {
            oVar.r();
            this.f178570b.u(this.f178569a.d());
            this.f178570b.v(this.f178569a.i());
        } else {
            Rect d16 = this.f178571c.d();
            this.f178570b = new o(this.f178569a, d16.width(), d16.height(), -1, -1, 10, 15, 1.0f);
        }
        return this.f178570b;
    }

    public void i(float f16, float f17) {
        o oVar = this.f178570b;
        if (oVar != null) {
            oVar.p(f16, f17, this.f178571c.f(), 0L);
        }
        this.f178569a.c();
        this.f178569a.a(f16, f17, this.f178571c.f(), 0L);
    }
}
