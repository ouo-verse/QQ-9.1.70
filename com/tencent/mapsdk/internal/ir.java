package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.in;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ir extends in {

    /* renamed from: i, reason: collision with root package name */
    private float f148815i;

    /* renamed from: j, reason: collision with root package name */
    private float f148816j;

    /* renamed from: k, reason: collision with root package name */
    private float f148817k;

    /* renamed from: l, reason: collision with root package name */
    private float f148818l;

    public ir(float f16, float f17, float f18, float f19) {
        this.f148815i = f16;
        this.f148816j = f17;
        this.f148817k = f18;
        this.f148818l = f19;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mapsdk.internal.in
    public final void a(float f16, Interpolator interpolator) {
        if (f16 < 0.0f) {
            return;
        }
        float f17 = this.f148816j - this.f148815i;
        float f18 = this.f148818l - this.f148817k;
        float interpolation = interpolator.getInterpolation(f16);
        float f19 = this.f148815i + (f17 * interpolation);
        float f26 = this.f148817k + (f18 * interpolation);
        in.b bVar = this.f148806h;
        if (bVar != null) {
            bVar.a(f19, f26);
        }
    }
}
