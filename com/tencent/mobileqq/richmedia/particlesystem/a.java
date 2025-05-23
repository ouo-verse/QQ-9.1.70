package com.tencent.mobileqq.richmedia.particlesystem;

import androidx.annotation.NonNull;
import java.util.Comparator;
import om2.g;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f281679a;

    /* renamed from: b, reason: collision with root package name */
    public int f281680b;

    /* renamed from: c, reason: collision with root package name */
    public int f281681c;

    /* renamed from: d, reason: collision with root package name */
    public float f281682d;

    /* renamed from: e, reason: collision with root package name */
    public float f281683e;

    /* renamed from: f, reason: collision with root package name */
    public float f281684f;

    /* renamed from: g, reason: collision with root package name */
    public float f281685g;

    /* renamed from: h, reason: collision with root package name */
    public float f281686h;

    /* renamed from: i, reason: collision with root package name */
    public float f281687i;

    /* renamed from: j, reason: collision with root package name */
    public float f281688j;

    /* renamed from: k, reason: collision with root package name */
    public float f281689k;

    /* renamed from: l, reason: collision with root package name */
    public float f281690l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f281691m = 1.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f281692n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    public float f281693o = 0.0f;

    /* renamed from: p, reason: collision with root package name */
    public float f281694p = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    public float f281695q = 0.0f;

    /* renamed from: r, reason: collision with root package name */
    public float f281696r = 0.0f;

    /* renamed from: s, reason: collision with root package name */
    public float f281697s = 0.0f;

    /* renamed from: t, reason: collision with root package name */
    public float f281698t = 0.0f;

    /* renamed from: u, reason: collision with root package name */
    public final jm2.b f281699u;

    /* renamed from: v, reason: collision with root package name */
    public g f281700v;

    /* renamed from: w, reason: collision with root package name */
    public int f281701w;

    /* renamed from: x, reason: collision with root package name */
    public Object f281702x;

    /* renamed from: y, reason: collision with root package name */
    public km2.g f281703y;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.richmedia.particlesystem.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C8516a implements Comparator<a> {

        /* renamed from: d, reason: collision with root package name */
        public static final C8516a f281704d = new C8516a();

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            return Float.compare(aVar.f281684f, aVar2.f281684f);
        }
    }

    public a(int i3, int i16, int i17, float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, g gVar, Object obj, jm2.b bVar, km2.g gVar2) {
        this.f281679a = i3;
        this.f281680b = i16;
        this.f281681c = i17;
        this.f281682d = f16;
        this.f281683e = f17;
        this.f281684f = f18;
        this.f281685g = f19;
        this.f281686h = f26;
        this.f281687i = f27;
        this.f281688j = f28;
        this.f281689k = f29;
        this.f281699u = bVar;
        this.f281700v = gVar;
        this.f281703y = gVar2;
        this.f281702x = obj;
    }

    public boolean a() {
        return this.f281699u.b();
    }

    @NonNull
    public String toString() {
        return "Particle{width=" + this.f281680b + ", height=" + this.f281681c + ", locationX=" + this.f281682d + ", locationY=" + this.f281683e + ", locationZ=" + this.f281684f + ", speedX=" + this.f281685g + ", speedY=" + this.f281686h + ", accelerationX=" + this.f281687i + ", accelerationY=" + this.f281688j + ", alpha=" + this.f281689k + ", lifecycle=" + this.f281699u + ", bitmap='" + this.f281700v + "', lastUpdateTime=" + this.f281701w + '}';
    }
}
