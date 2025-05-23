package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gj {

    /* renamed from: a, reason: collision with root package name */
    public gl f148495a;

    /* renamed from: b, reason: collision with root package name */
    public gl f148496b;

    /* renamed from: c, reason: collision with root package name */
    public gl f148497c;

    /* renamed from: d, reason: collision with root package name */
    private gm f148498d;

    public gj() {
        this.f148498d = new gm();
    }

    private void a(gl glVar, gl glVar2, gl glVar3) {
        this.f148495a = glVar;
        this.f148496b = glVar2;
        this.f148497c = glVar3;
        this.f148498d.a(glVar);
        this.f148498d.a(glVar2);
        this.f148498d.a(glVar3);
    }

    private float[] b() {
        return this.f148498d.a();
    }

    public gj(gl glVar, gl glVar2, gl glVar3) {
        this();
        a(glVar, glVar2, glVar3);
    }

    public gj(float[] fArr) {
        this();
        a(new gl(fArr[0], fArr[1], fArr[2]), new gl(fArr[3], fArr[4], fArr[5]), new gl(fArr[6], fArr[7], fArr[8]));
    }

    private boolean a(float[] fArr) {
        gl glVar = new gl(fArr[0], fArr[1], fArr[2]);
        return ((double) Math.abs(a() - ((new gj(glVar, this.f148495a, this.f148496b).a() + new gj(glVar, this.f148495a, this.f148497c).a()) + new gj(glVar, this.f148496b, this.f148497c).a()))) < 0.001d;
    }

    public final float a() {
        float[] a16 = this.f148498d.a();
        float a17 = a(a16[0], a16[1], a16[2], a16[3], a16[4], a16[5]);
        float a18 = a(a16[3], a16[4], a16[5], a16[6], a16[7], a16[8]);
        float a19 = ((a17 + a18) + a(a16[0], a16[1], a16[2], a16[6], a16[7], a16[8])) / 2.0f;
        return (float) Math.sqrt((a19 - a17) * a19 * (a19 - a18) * (a19 - r1));
    }

    private static float a(float f16, float f17, float f18, float f19, float f26, float f27) {
        float f28 = f16 - f19;
        float f29 = f17 - f26;
        float f36 = f18 - f27;
        return (float) Math.sqrt((f28 * f28) + (f29 * f29) + (f36 * f36));
    }
}
