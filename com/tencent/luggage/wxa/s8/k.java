package com.tencent.luggage.wxa.s8;

import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k {

    /* renamed from: k, reason: collision with root package name */
    public static final k f140176k;

    /* renamed from: a, reason: collision with root package name */
    public float f140177a;

    /* renamed from: b, reason: collision with root package name */
    public float f140178b;

    /* renamed from: c, reason: collision with root package name */
    public float f140179c;

    /* renamed from: d, reason: collision with root package name */
    public float f140180d;

    /* renamed from: e, reason: collision with root package name */
    public float f140181e;

    /* renamed from: f, reason: collision with root package name */
    public float f140182f;

    /* renamed from: g, reason: collision with root package name */
    public float f140183g;

    /* renamed from: h, reason: collision with root package name */
    public float f140184h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f140185i;

    /* renamed from: j, reason: collision with root package name */
    public int f140186j = 1;

    static {
        k kVar = new k();
        f140176k = kVar;
        kVar.a();
    }

    public void a() {
        this.f140180d = 0.0f;
        this.f140179c = 0.0f;
        this.f140178b = 0.0f;
        this.f140177a = 0.0f;
        this.f140184h = 0.0f;
        this.f140183g = 0.0f;
        this.f140182f = 0.0f;
        this.f140181e = 0.0f;
        this.f140186j = 1;
        this.f140185i = false;
    }

    public void b(float f16, float f17) {
        this.f140179c = f16;
        this.f140180d = f17;
    }

    public String toString() {
        return "glyph(" + this.f140177a + ", " + this.f140178b + ", [" + this.f140179c + ", " + this.f140180d + "], [" + this.f140181e + ", " + this.f140182f + ", " + this.f140183g + ", " + this.f140184h + ", " + this.f140185i + "])";
    }

    public void b(FloatBuffer floatBuffer) {
        floatBuffer.put(this.f140177a).put(this.f140178b).put(this.f140179c).put(this.f140180d).put(this.f140181e).put(this.f140182f).put(this.f140183g).put(this.f140184h).put(this.f140185i ? 1.0f : 0.0f).put(this.f140186j);
    }

    public void a(float f16, float f17) {
        b(f16, f17);
    }

    public k a(boolean z16) {
        this.f140185i = z16;
        return this;
    }

    public void a(float f16, float f17, float f18, float f19) {
        this.f140181e = f16;
        this.f140182f = f17;
        this.f140183g = f18;
        this.f140184h = f19;
    }

    public void a(FloatBuffer floatBuffer) {
        b(floatBuffer);
    }

    public static void a(FloatBuffer floatBuffer, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (kVar != null) {
                kVar.a(floatBuffer);
            }
        }
    }
}
