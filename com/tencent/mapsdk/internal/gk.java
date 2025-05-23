package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gk {

    /* renamed from: a, reason: collision with root package name */
    private float f148499a;

    /* renamed from: b, reason: collision with root package name */
    private float f148500b;

    /* renamed from: c, reason: collision with root package name */
    private float f148501c;

    public gk(float f16, float f17, float f18) {
        this.f148499a = f16;
        this.f148500b = f17;
        this.f148501c = f18;
        double e16 = e();
        if (e16 != 0.0d) {
            this.f148499a = (float) (this.f148499a / e16);
            this.f148500b = (float) (this.f148500b / e16);
            this.f148501c = (float) (this.f148501c / e16);
        }
    }

    private static gk b(gk gkVar) {
        return new gk(-gkVar.f148499a, -gkVar.f148500b, -gkVar.f148501c);
    }

    private float c() {
        return this.f148500b;
    }

    private float d() {
        return this.f148501c;
    }

    private double e() {
        float f16 = this.f148499a;
        float f17 = this.f148500b;
        float f18 = (f16 * f16) + (f17 * f17);
        float f19 = this.f148501c;
        return Math.sqrt(f18 + (f19 * f19));
    }

    private void f() {
        double e16 = e();
        if (e16 == 0.0d) {
            return;
        }
        this.f148499a = (float) (this.f148499a / e16);
        this.f148500b = (float) (this.f148500b / e16);
        this.f148501c = (float) (this.f148501c / e16);
    }

    public final float[] a() {
        return new float[]{this.f148499a, this.f148500b, this.f148501c};
    }

    public final String toString() {
        return this.f148499a + "," + this.f148500b + "," + this.f148501c;
    }

    private static gk a(gk gkVar, gk gkVar2) {
        return new gk(gkVar.f148499a + gkVar2.f148499a, gkVar.f148500b + gkVar2.f148500b, gkVar.f148501c + gkVar2.f148501c);
    }

    private float b() {
        return this.f148499a;
    }

    private double c(gk gkVar) {
        return (Math.acos((((this.f148499a * gkVar.f148499a) + (this.f148500b * gkVar.f148500b)) + (this.f148501c * gkVar.f148501c)) / (e() * gkVar.e())) * 180.0d) / 3.141592653589793d;
    }

    private static gk a(gk gkVar) {
        float f16 = gkVar.f148499a;
        float f17 = gkVar.f148500b;
        float e16 = (float) (f16 / gkVar.e());
        float e17 = (float) ((-f17) / gkVar.e());
        gk gkVar2 = new gk(e16, e17, 0.0f);
        return (Math.acos(((double) (((gkVar2.f148499a * gkVar.f148499a) + (gkVar2.f148500b * gkVar.f148500b)) + (gkVar2.f148501c * gkVar.f148501c))) / (gkVar2.e() * gkVar.e())) * 180.0d) / 3.141592653589793d != 90.0d ? new gk(-e16, -e17, 0.0f) : gkVar2;
    }
}
