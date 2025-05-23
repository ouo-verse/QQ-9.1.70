package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.in;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class iq extends in {

    /* renamed from: i, reason: collision with root package name */
    private float f148810i;

    /* renamed from: j, reason: collision with root package name */
    private float f148811j;

    /* renamed from: k, reason: collision with root package name */
    private float f148812k;

    /* renamed from: l, reason: collision with root package name */
    private float f148813l;

    /* renamed from: m, reason: collision with root package name */
    private float f148814m;

    public iq(float f16, float f17, float f18, float f19, float f26) {
        this.f148810i = f16;
        this.f148811j = f17;
        this.f148812k = f18;
        this.f148813l = f19;
        this.f148814m = f26;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mapsdk.internal.in
    public final void a(float f16, Interpolator interpolator) {
        float interpolation = this.f148810i + ((this.f148811j - this.f148810i) * interpolator.getInterpolation(f16));
        in.b bVar = this.f148806h;
        if (bVar != null) {
            bVar.a(interpolation, this.f148812k, this.f148813l, this.f148814m);
        }
    }
}
