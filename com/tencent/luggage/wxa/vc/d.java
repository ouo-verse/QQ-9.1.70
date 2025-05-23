package com.tencent.luggage.wxa.vc;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.tk.g;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements a {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.ad.a f143340a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.ad.a f143341b;

    /* renamed from: c, reason: collision with root package name */
    public Stack f143342c;

    /* renamed from: d, reason: collision with root package name */
    public Stack f143343d;

    /* renamed from: f, reason: collision with root package name */
    public Paint f143345f;

    /* renamed from: g, reason: collision with root package name */
    public e f143346g;

    /* renamed from: h, reason: collision with root package name */
    public a f143347h;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f143349j;

    /* renamed from: e, reason: collision with root package name */
    public Paint f143344e = new Paint();

    /* renamed from: i, reason: collision with root package name */
    public final a.c f143348i = new a.c();

    /* renamed from: k, reason: collision with root package name */
    public boolean f143350k = true;

    public d(a aVar) {
        com.tencent.luggage.wxa.ad.a aVar2;
        com.tencent.luggage.wxa.ad.a aVar3;
        this.f143347h = aVar;
        if (g()) {
            aVar2 = com.tencent.luggage.wxa.zc.c.c().a();
        } else {
            aVar2 = new com.tencent.luggage.wxa.ad.a();
        }
        this.f143340a = aVar2;
        if (g()) {
            aVar3 = com.tencent.luggage.wxa.zc.b.c().a();
        } else {
            aVar3 = new com.tencent.luggage.wxa.ad.a();
        }
        this.f143341b = aVar3;
        this.f143340a.setStyle(Paint.Style.STROKE);
        this.f143341b.setStyle(Paint.Style.FILL);
        this.f143340a.setAntiAlias(true);
        this.f143341b.setAntiAlias(true);
        this.f143340a.setStrokeWidth(g.a(1));
        this.f143341b.setStrokeWidth(g.a(1));
        this.f143342c = new Stack();
        this.f143343d = new Stack();
        this.f143344e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public Paint a() {
        return this.f143344e;
    }

    public com.tencent.luggage.wxa.xd.d b() {
        return this.f143349j;
    }

    public Paint c() {
        return this.f143345f;
    }

    public com.tencent.luggage.wxa.ad.a d() {
        return this.f143341b;
    }

    public e e() {
        return this.f143346g;
    }

    public com.tencent.luggage.wxa.ad.a f() {
        return this.f143340a;
    }

    public boolean g() {
        return this.f143350k;
    }

    public void h() {
        this.f143342c.clear();
        this.f143343d.clear();
        this.f143340a.reset();
        this.f143341b.reset();
        this.f143340a.setStyle(Paint.Style.STROKE);
        this.f143341b.setStyle(Paint.Style.FILL);
        this.f143340a.setAntiAlias(true);
        this.f143341b.setAntiAlias(true);
        this.f143340a.setStrokeWidth(g.a(1));
        this.f143341b.setStrokeWidth(g.a(1));
    }

    public void i() {
        if (this.f143342c.isEmpty()) {
            return;
        }
        com.tencent.luggage.wxa.ad.a aVar = this.f143340a;
        com.tencent.luggage.wxa.ad.a aVar2 = this.f143341b;
        this.f143340a = (com.tencent.luggage.wxa.ad.a) this.f143342c.pop();
        this.f143341b = (com.tencent.luggage.wxa.ad.a) this.f143343d.pop();
        if (g()) {
            if (this.f143340a != aVar) {
                com.tencent.luggage.wxa.zc.c.c().a(aVar);
            }
            if (this.f143341b != aVar2) {
                com.tencent.luggage.wxa.zc.b.c().a(aVar2);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.vc.a
    public void invalidate() {
        this.f143347h.invalidate();
    }

    public void j() {
        com.tencent.luggage.wxa.ad.a aVar = this.f143340a;
        this.f143342c.push(aVar);
        if (g()) {
            com.tencent.luggage.wxa.ad.a a16 = com.tencent.luggage.wxa.zc.c.c().a();
            this.f143340a = a16;
            aVar.a(a16);
        } else {
            this.f143340a = aVar.a();
        }
        if (this.f143340a == null) {
            this.f143340a = aVar;
        }
        com.tencent.luggage.wxa.ad.a aVar2 = this.f143341b;
        this.f143343d.push(aVar2);
        if (g()) {
            this.f143341b = com.tencent.luggage.wxa.zc.b.c().a();
        } else {
            this.f143341b = aVar2.a();
        }
        aVar2.a(this.f143341b);
        if (this.f143341b == null) {
            this.f143341b = aVar2;
        }
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar) {
        this.f143349j = dVar;
    }

    public void a(e eVar) {
        this.f143346g = eVar;
    }

    public void a(boolean z16) {
        this.f143350k = z16;
    }
}
