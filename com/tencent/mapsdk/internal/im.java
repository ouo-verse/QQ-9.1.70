package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.in;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class im extends in {

    /* renamed from: i, reason: collision with root package name */
    private float f148797i;

    /* renamed from: j, reason: collision with root package name */
    private float f148798j;

    public im(float f16, float f17) {
        this.f148797i = f16;
        this.f148798j = f17;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mapsdk.internal.in
    public final void a(float f16, Interpolator interpolator) {
        float interpolation = this.f148797i + ((this.f148798j - this.f148797i) * interpolator.getInterpolation(f16));
        in.b bVar = this.f148806h;
        if (bVar != null) {
            bVar.a(interpolation);
        }
    }
}
