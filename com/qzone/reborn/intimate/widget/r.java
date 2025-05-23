package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.jbox2d.common.Vec2;
import com.qzone.jbox2d.dynamics.BodyType;
import com.tencent.mobileqq.R;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes37.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private final Context f57730a;

    /* renamed from: b, reason: collision with root package name */
    private com.qzone.jbox2d.dynamics.l f57731b;

    /* renamed from: c, reason: collision with root package name */
    private int f57732c;

    /* renamed from: d, reason: collision with root package name */
    private int f57733d;

    /* renamed from: e, reason: collision with root package name */
    private final ViewGroup f57734e;

    /* renamed from: o, reason: collision with root package name */
    private Paint f57744o;

    /* renamed from: q, reason: collision with root package name */
    private com.qzone.jbox2d.dynamics.a f57746q;

    /* renamed from: r, reason: collision with root package name */
    private com.qzone.jbox2d.dynamics.a f57747r;

    /* renamed from: s, reason: collision with root package name */
    private com.qzone.jbox2d.dynamics.a f57748s;

    /* renamed from: t, reason: collision with root package name */
    private com.qzone.jbox2d.dynamics.a f57749t;

    /* renamed from: f, reason: collision with root package name */
    private float f57735f = 0.5f;

    /* renamed from: g, reason: collision with root package name */
    private float f57736g = 0.2f;

    /* renamed from: h, reason: collision with root package name */
    private float f57737h = 0.6f;

    /* renamed from: j, reason: collision with root package name */
    private boolean f57739j = true;

    /* renamed from: k, reason: collision with root package name */
    private int f57740k = 3;

    /* renamed from: l, reason: collision with root package name */
    private int f57741l = 10;

    /* renamed from: m, reason: collision with root package name */
    private float f57742m = 0.016666668f;

    /* renamed from: n, reason: collision with root package name */
    private int f57743n = 50;

    /* renamed from: p, reason: collision with root package name */
    private boolean f57745p = false;

    /* renamed from: i, reason: collision with root package name */
    private final Random f57738i = new Random();

    public r(Context context, ViewGroup viewGroup) {
        this.f57730a = context;
        this.f57734e = viewGroup;
        Paint paint = new Paint();
        this.f57744o = paint;
        paint.setColor(0);
        this.f57744o.setStrokeWidth(4.0f);
        this.f57744o.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    private com.qzone.jbox2d.collision.shapes.f b(View view) {
        com.qzone.jbox2d.collision.shapes.b bVar = new com.qzone.jbox2d.collision.shapes.b();
        bVar.g(n(view.getWidth() / 2));
        return bVar;
    }

    private void c(boolean z16, Context context) {
        if (this.f57731b == null) {
            this.f57731b = new com.qzone.jbox2d.dynamics.l(new Vec2(0.0f, 1.0f));
        }
        int childCount = this.f57734e.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f57734e.getChildAt(i3);
            int intValue = childAt.getTag() != null ? ((Integer) childAt.getTag()).intValue() : 0;
            com.qzone.jbox2d.dynamics.a aVar = (com.qzone.jbox2d.dynamics.a) childAt.getTag(R.id.n4e);
            if (intValue != -1 && (aVar == null || z16)) {
                if (aVar != null) {
                    this.f57731b.d(aVar);
                }
                a(this.f57731b, childAt);
            }
        }
    }

    private float f(View view) {
        if (this.f57732c <= 0) {
            return n(view.getX());
        }
        if (((Boolean) view.getTag(R.id.n4r)).booleanValue()) {
            return n(this.f57732c / 2);
        }
        return n(this.f57738i.nextInt(this.f57732c));
    }

    private void g(Canvas canvas) {
        canvas.drawRect(new Rect(0, 0, this.f57732c, this.f57733d), this.f57744o);
        if (this.f57745p) {
            return;
        }
        e();
        com.qzone.jbox2d.dynamics.b bVar = new com.qzone.jbox2d.dynamics.b();
        bVar.f48186a = BodyType.STATIC;
        float n3 = n(this.f57732c);
        float n16 = n(this.f57733d);
        float n17 = n(this.f57743n);
        com.qzone.jbox2d.collision.shapes.e eVar = new com.qzone.jbox2d.collision.shapes.e();
        eVar.h(n3, n17);
        com.qzone.jbox2d.dynamics.f fVar = new com.qzone.jbox2d.dynamics.f();
        fVar.f48222a = eVar;
        fVar.f48226e = 1.0f;
        fVar.f48224c = 0.4f;
        fVar.f48225d = 0.3f;
        float f16 = -n17;
        bVar.f48188c.set(0.0f, f16);
        com.qzone.jbox2d.dynamics.a c16 = this.f57731b.c(bVar);
        this.f57746q = c16;
        c16.c(fVar);
        bVar.f48188c.set(0.0f, n16 + n17);
        com.qzone.jbox2d.dynamics.a c17 = this.f57731b.c(bVar);
        this.f57747r = c17;
        c17.c(fVar);
        com.qzone.jbox2d.collision.shapes.e eVar2 = new com.qzone.jbox2d.collision.shapes.e();
        eVar2.h(n17, n16);
        com.qzone.jbox2d.dynamics.f fVar2 = new com.qzone.jbox2d.dynamics.f();
        fVar2.f48222a = eVar2;
        fVar2.f48226e = 0.5f;
        fVar2.f48224c = 0.3f;
        fVar2.f48225d = 0.5f;
        bVar.f48188c.set(f16, n16);
        com.qzone.jbox2d.dynamics.a c18 = this.f57731b.c(bVar);
        this.f57748s = c18;
        c18.c(fVar2);
        bVar.f48188c.set(n3 + n17, 0.0f);
        com.qzone.jbox2d.dynamics.a c19 = this.f57731b.c(bVar);
        this.f57749t = c19;
        c19.c(fVar2);
        this.f57745p = true;
    }

    private float o(float f16) {
        return (f16 / 3.14f) * 180.0f;
    }

    private void r(boolean z16) {
        this.f57739j = z16;
    }

    public void d(View view) {
        if (this.f57731b == null) {
            return;
        }
        com.qzone.jbox2d.dynamics.a aVar = view == null ? null : (com.qzone.jbox2d.dynamics.a) view.getTag(R.id.n4e);
        if (aVar == null) {
            return;
        }
        this.f57731b.d(aVar);
    }

    public void e() {
        com.qzone.jbox2d.dynamics.a aVar = this.f57746q;
        if (aVar != null) {
            this.f57731b.d(aVar);
        }
        com.qzone.jbox2d.dynamics.a aVar2 = this.f57747r;
        if (aVar2 != null) {
            this.f57731b.d(aVar2);
        }
        com.qzone.jbox2d.dynamics.a aVar3 = this.f57748s;
        if (aVar3 != null) {
            this.f57731b.d(aVar3);
        }
        com.qzone.jbox2d.dynamics.a aVar4 = this.f57749t;
        if (aVar4 != null) {
            this.f57731b.d(aVar4);
        }
    }

    public float h(float f16) {
        return f16 * this.f57743n;
    }

    public void i(Canvas canvas) {
        if (this.f57731b == null || !this.f57739j) {
            return;
        }
        g(canvas);
        this.f57731b.p(this.f57742m, this.f57740k, this.f57741l);
        int childCount = this.f57734e.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f57734e.getChildAt(i3);
            com.qzone.jbox2d.dynamics.a aVar = (com.qzone.jbox2d.dynamics.a) childAt.getTag(R.id.n4e);
            if (aVar != null) {
                childAt.setX(h(aVar.j().f48119x) - (childAt.getWidth() / 2));
                childAt.setY(h(aVar.j().f48120y) - (childAt.getHeight() / 2));
                childAt.setRotation(o(aVar.d() % 360.0f));
            }
        }
        this.f57734e.invalidate();
    }

    public void j(boolean z16) {
        c(z16, this.f57730a);
    }

    public void k(int i3, int i16) {
        this.f57732c = i3;
        this.f57733d = i16;
    }

    public float n(float f16) {
        return f16 / this.f57743n;
    }

    public void q(float f16, float f17) {
        com.qzone.jbox2d.dynamics.l lVar = this.f57731b;
        if (lVar != null) {
            lVar.m(new Vec2(f16, f17));
        }
    }

    public void l() {
        r(true);
    }

    public void m() {
        r(false);
    }

    public void p() {
        this.f57745p = false;
    }

    private void a(com.qzone.jbox2d.dynamics.l lVar, View view) {
        if (lVar == null || view == null) {
            return;
        }
        com.qzone.jbox2d.dynamics.b bVar = new com.qzone.jbox2d.dynamics.b();
        bVar.f48186a = BodyType.DYNAMIC;
        bVar.f48188c.set(f(view), n(view.getY() + (view.getHeight() / 2)));
        bVar.f48194i = false;
        com.qzone.jbox2d.collision.shapes.f b16 = b(view);
        com.qzone.jbox2d.dynamics.f fVar = new com.qzone.jbox2d.dynamics.f();
        fVar.a(b16);
        fVar.f48224c = this.f57736g;
        fVar.f48225d = this.f57737h;
        fVar.f48226e = this.f57735f;
        com.qzone.jbox2d.dynamics.a c16 = lVar.c(bVar);
        c16.c(fVar);
        view.setTag(R.id.n4e, c16);
        c16.s(new Vec2(this.f57738i.nextFloat(), this.f57738i.nextFloat()));
    }
}
