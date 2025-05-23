package com.qzone.module.personalitycomponent.entity;

import android.animation.TypeEvaluator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a implements TypeEvaluator {

    /* renamed from: d, reason: collision with root package name */
    public static int f49022d = 3;

    /* renamed from: a, reason: collision with root package name */
    private int f49023a = 1;

    /* renamed from: b, reason: collision with root package name */
    private float f49024b = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    private C0415a f49025c;

    /* compiled from: P */
    /* renamed from: com.qzone.module.personalitycomponent.entity.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static class C0415a {

        /* renamed from: a, reason: collision with root package name */
        public float f49026a;

        /* renamed from: b, reason: collision with root package name */
        public float f49027b;

        /* renamed from: c, reason: collision with root package name */
        public float f49028c;

        /* renamed from: d, reason: collision with root package name */
        public float f49029d;

        /* renamed from: e, reason: collision with root package name */
        public float f49030e;

        /* renamed from: f, reason: collision with root package name */
        public int f49031f;

        /* renamed from: g, reason: collision with root package name */
        public int f49032g;

        /* renamed from: h, reason: collision with root package name */
        public int f49033h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f49034i = false;

        public C0415a(float f16, float f17, float f18, float f19, float f26) {
            this.f49026a = f16;
            this.f49027b = f17;
            this.f49028c = f18;
            this.f49029d = f19;
            this.f49030e = f26;
        }
    }

    public a(C0415a c0415a) {
        this.f49025c = c0415a;
        f49022d = 3;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f16, Object obj, Object obj2) {
        C0415a c0415a = (C0415a) obj;
        C0415a c0415a2 = (C0415a) obj2;
        if (c0415a != null && c0415a2 != null) {
            float f17 = this.f49024b;
            if (f17 != -1.0f && f17 > f16) {
                this.f49023a++;
            }
            float f18 = c0415a.f49026a;
            float f19 = f18 + ((c0415a2.f49026a - f18) * f16);
            float f26 = c0415a.f49027b;
            float f27 = f26 + ((c0415a2.f49027b - f26) * f16);
            float f28 = c0415a.f49028c;
            float f29 = f28 + ((c0415a2.f49028c - f28) * f16);
            float f36 = c0415a.f49029d;
            float f37 = f36 + ((c0415a2.f49029d - f36) * f16);
            float f38 = c0415a.f49030e;
            float f39 = f38 + ((c0415a2.f49030e - f38) * f16);
            C0415a c0415a3 = this.f49025c;
            if (c0415a3 == null) {
                this.f49025c = new C0415a(f19, f27, f29, f37, f39);
            } else {
                c0415a3.f49026a = f19;
                c0415a3.f49027b = f27;
                c0415a3.f49028c = f29;
                c0415a3.f49029d = f37;
                c0415a3.f49030e = f39;
            }
            C0415a c0415a4 = this.f49025c;
            int i3 = (this.f49023a + c0415a4.f49031f) % 5;
            c0415a4.f49032g = i3;
            this.f49024b = f16;
            if (i3 == 3) {
                c0415a4.f49034i = true;
            }
            if (i3 > 3 && c0415a4.f49034i) {
                int i16 = f49022d;
                c0415a4.f49033h = i16;
                c0415a4.f49034i = false;
                f49022d = i16 + 1;
            }
            return c0415a4;
        }
        return this.f49025c;
    }
}
