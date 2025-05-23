package c.t.m.g;

/* compiled from: P */
/* loaded from: classes.dex */
public class s2 {

    /* renamed from: a, reason: collision with root package name */
    public final float f29980a;

    /* renamed from: b, reason: collision with root package name */
    public final float f29981b;

    /* renamed from: c, reason: collision with root package name */
    public final float f29982c;

    public s2(long j3, long j16, float f16, float f17, float f18) {
        this.f29980a = f16;
        this.f29981b = f17;
        this.f29982c = f18;
    }

    public float a() {
        return (float) Math.sqrt(Math.pow(this.f29980a, 2.0d) + Math.pow(this.f29981b, 2.0d) + Math.pow(this.f29982c, 2.0d));
    }

    public float b() {
        return this.f29980a;
    }

    public float c() {
        return this.f29981b;
    }

    public float d() {
        return this.f29982c;
    }
}
