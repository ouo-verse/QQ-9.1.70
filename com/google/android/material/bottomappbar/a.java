package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.b;
import com.google.android.material.shape.i;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends b implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private float f33328d;

    /* renamed from: e, reason: collision with root package name */
    private float f33329e;

    /* renamed from: f, reason: collision with root package name */
    private float f33330f;

    /* renamed from: h, reason: collision with root package name */
    private float f33331h;

    /* renamed from: i, reason: collision with root package name */
    private float f33332i;

    /* renamed from: m, reason: collision with root package name */
    private float f33333m = -1.0f;

    public a(float f16, float f17, float f18) {
        this.f33329e = f16;
        this.f33328d = f17;
        j(f18);
        this.f33332i = 0.0f;
    }

    @Override // com.google.android.material.shape.b
    public void b(float f16, float f17, float f18, @NonNull i iVar) {
        boolean z16;
        float f19;
        float f26;
        float f27 = this.f33330f;
        if (f27 == 0.0f) {
            iVar.m(f16, 0.0f);
            return;
        }
        float f28 = ((this.f33329e * 2.0f) + f27) / 2.0f;
        float f29 = f18 * this.f33328d;
        float f36 = f17 + this.f33332i;
        float f37 = (this.f33331h * f18) + ((1.0f - f18) * f28);
        if (f37 / f28 >= 1.0f) {
            iVar.m(f16, 0.0f);
            return;
        }
        float f38 = this.f33333m;
        float f39 = f38 * f18;
        if (f38 != -1.0f && Math.abs((f38 * 2.0f) - f27) >= 0.1f) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean z17 = z16;
        if (!z17) {
            f26 = 1.75f;
            f19 = 0.0f;
        } else {
            f19 = f37;
            f26 = 0.0f;
        }
        float f46 = f28 + f29;
        float f47 = f19 + f29;
        float sqrt = (float) Math.sqrt((f46 * f46) - (f47 * f47));
        float f48 = f36 - sqrt;
        float f49 = f36 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f47));
        float f56 = (90.0f - degrees) + f26;
        iVar.m(f48, 0.0f);
        float f57 = f29 * 2.0f;
        iVar.a(f48 - f29, 0.0f, f48 + f29, f57, 270.0f, degrees);
        if (z17) {
            iVar.a(f36 - f28, (-f28) - f19, f36 + f28, f28 - f19, 180.0f - f56, (f56 * 2.0f) - 180.0f);
        } else {
            float f58 = this.f33329e;
            float f59 = f39 * 2.0f;
            float f65 = f36 - f28;
            iVar.a(f65, -(f39 + f58), f65 + f58 + f59, f58 + f39, 180.0f - f56, ((f56 * 2.0f) - 180.0f) / 2.0f);
            float f66 = f36 + f28;
            float f67 = this.f33329e;
            iVar.m(f66 - ((f67 / 2.0f) + f39), f67 + f39);
            float f68 = this.f33329e;
            iVar.a(f66 - (f59 + f68), -(f39 + f68), f66, f68 + f39, 90.0f, f56 - 90.0f);
        }
        iVar.a(f49 - f29, 0.0f, f49 + f29, f57, 270.0f - degrees, degrees);
        iVar.m(f16, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f33331h;
    }

    public float d() {
        return this.f33333m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f33329e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.f33328d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float h() {
        return this.f33330f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float i() {
        return this.f33332i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(@FloatRange(from = 0.0d) float f16) {
        if (f16 >= 0.0f) {
            this.f33331h = f16;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void k(float f16) {
        this.f33333m = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(float f16) {
        this.f33329e = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f16) {
        this.f33328d = f16;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void n(float f16) {
        this.f33330f = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(float f16) {
        this.f33332i = f16;
    }
}
