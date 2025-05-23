package ea1;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public float f396026a;

    /* renamed from: b, reason: collision with root package name */
    public float f396027b;

    /* renamed from: c, reason: collision with root package name */
    public float f396028c;

    /* renamed from: d, reason: collision with root package name */
    public float f396029d;

    /* renamed from: e, reason: collision with root package name */
    public float f396030e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f396031f;

    /* renamed from: g, reason: collision with root package name */
    public f f396032g;

    public void a(f fVar) {
        this.f396026a = fVar.f396026a;
        this.f396027b = fVar.f396027b;
        this.f396028c = fVar.f396028c;
        this.f396029d = fVar.f396029d;
        this.f396030e = fVar.f396030e;
        this.f396031f = fVar.f396031f;
    }

    public void b(f fVar, f fVar2, float f16) {
        boolean z16;
        float f17 = 1.0f - f16;
        this.f396026a = (fVar.f396026a * f17) + (fVar2.f396026a * f16);
        this.f396027b = (fVar.f396027b * f17) + (fVar2.f396027b * f16);
        this.f396028c = (fVar.f396028c * f17) + (fVar2.f396028c * f16);
        this.f396029d = (fVar.f396029d * f17) + (fVar2.f396029d * f16);
        this.f396030e = (f17 * fVar.f396030e) + (fVar2.f396030e * f16);
        if (f16 > 0.9f) {
            z16 = fVar2.f396031f;
        } else {
            z16 = fVar.f396031f;
        }
        this.f396031f = z16;
    }

    @NonNull
    public String toString() {
        return "PetalData {\n\tradius: " + this.f396026a + "\n\ttheta: " + this.f396027b + "\n\tsize: " + this.f396028c + "\n\talpha: " + this.f396029d + "\n\tcolorAlpha: " + this.f396030e + "\n}";
    }
}
