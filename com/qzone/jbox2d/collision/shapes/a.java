package com.qzone.jbox2d.collision.shapes;

import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends f {

    /* renamed from: c, reason: collision with root package name */
    public Vec2[] f48076c;

    /* renamed from: d, reason: collision with root package name */
    public int f48077d;

    /* renamed from: e, reason: collision with root package name */
    public final Vec2 f48078e;

    /* renamed from: f, reason: collision with root package name */
    public final Vec2 f48079f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f48080g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f48081h;

    /* renamed from: i, reason: collision with root package name */
    private final c f48082i;

    public a() {
        super(ShapeType.CHAIN);
        this.f48078e = new Vec2();
        this.f48079f = new Vec2();
        this.f48080g = false;
        this.f48081h = false;
        this.f48082i = new c();
        this.f48076c = null;
        this.f48104b = com.qzone.jbox2d.common.d.f48147o;
        this.f48077d = 0;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public f clone() {
        a aVar = new a();
        aVar.h(this.f48076c, this.f48077d);
        aVar.f48078e.set(this.f48078e);
        aVar.f48079f.set(this.f48079f);
        aVar.f48080g = this.f48080g;
        aVar.f48081h = this.f48081h;
        return aVar;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public void b(com.qzone.jbox2d.collision.a aVar, Transform transform, int i3) {
        Vec2 vec2 = aVar.f47986a;
        Vec2 vec22 = aVar.f47987b;
        int i16 = i3 + 1;
        if (i16 == this.f48077d) {
            i16 = 0;
        }
        Vec2[] vec2Arr = this.f48076c;
        Vec2 vec23 = vec2Arr[i3];
        Vec2 vec24 = vec2Arr[i16];
        Rot rot = transform.f48118q;
        Vec2 vec25 = transform.f48117p;
        float f16 = rot.f48110c;
        float f17 = vec23.f48119x;
        float f18 = rot.f48111s;
        float f19 = vec23.f48120y;
        float f26 = vec25.f48119x;
        float f27 = ((f16 * f17) - (f18 * f19)) + f26;
        float f28 = vec25.f48120y;
        float f29 = (f17 * f18) + (f19 * f16) + f28;
        float f36 = vec24.f48119x;
        float f37 = vec24.f48120y;
        float f38 = ((f16 * f36) - (f18 * f37)) + f26;
        float f39 = (f18 * f36) + (f16 * f37) + f28;
        vec2.f48119x = f27 < f38 ? f27 : f38;
        vec2.f48120y = f29 < f39 ? f29 : f39;
        if (f27 <= f38) {
            f27 = f38;
        }
        vec22.f48119x = f27;
        if (f29 <= f39) {
            f29 = f39;
        }
        vec22.f48120y = f29;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public int d() {
        return this.f48077d - 1;
    }

    public void h(Vec2[] vec2Arr, int i3) {
        this.f48077d = i3;
        this.f48076c = new Vec2[i3];
        for (int i16 = 1; i16 < this.f48077d; i16++) {
            float f16 = com.qzone.jbox2d.common.b.f(vec2Arr[i16 - 1], vec2Arr[i16]);
            float f17 = com.qzone.jbox2d.common.d.f48145m;
            if (f16 < f17 * f17) {
                throw new RuntimeException("Vertices of chain shape are too close together");
            }
        }
        for (int i17 = 0; i17 < this.f48077d; i17++) {
            this.f48076c[i17] = new Vec2(vec2Arr[i17]);
        }
        this.f48080g = false;
        this.f48081h = false;
        this.f48078e.setZero();
        this.f48079f.setZero();
    }

    public void i(c cVar, int i3) {
        cVar.f48104b = this.f48104b;
        Vec2[] vec2Arr = this.f48076c;
        Vec2 vec2 = vec2Arr[i3 + 0];
        Vec2 vec22 = vec2Arr[i3 + 1];
        Vec2 vec23 = cVar.f48084c;
        vec23.f48119x = vec2.f48119x;
        vec23.f48120y = vec2.f48120y;
        Vec2 vec24 = cVar.f48085d;
        vec24.f48119x = vec22.f48119x;
        vec24.f48120y = vec22.f48120y;
        if (i3 > 0) {
            Vec2 vec25 = vec2Arr[i3 - 1];
            Vec2 vec26 = cVar.f48086e;
            vec26.f48119x = vec25.f48119x;
            vec26.f48120y = vec25.f48120y;
            cVar.f48088g = true;
        } else {
            Vec2 vec27 = cVar.f48086e;
            Vec2 vec28 = this.f48078e;
            vec27.f48119x = vec28.f48119x;
            vec27.f48120y = vec28.f48120y;
            cVar.f48088g = this.f48080g;
        }
        if (i3 < this.f48077d - 2) {
            Vec2 vec29 = vec2Arr[i3 + 2];
            Vec2 vec210 = cVar.f48087f;
            vec210.f48119x = vec29.f48119x;
            vec210.f48120y = vec29.f48120y;
            cVar.f48089h = true;
            return;
        }
        Vec2 vec211 = cVar.f48087f;
        Vec2 vec212 = this.f48079f;
        vec211.f48119x = vec212.f48119x;
        vec211.f48120y = vec212.f48120y;
        cVar.f48089h = this.f48081h;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public void c(d dVar, float f16) {
        dVar.f48091a = 0.0f;
        dVar.f48092b.setZero();
        dVar.f48093c = 0.0f;
    }
}
