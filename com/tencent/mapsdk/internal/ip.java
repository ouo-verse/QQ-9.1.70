package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.in;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ip extends in {

    /* renamed from: i, reason: collision with root package name */
    public LatLng f148809i;

    public ip(LatLng latLng) {
        this.f148809i = latLng;
    }

    private LatLng c() {
        return this.f148809i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mapsdk.internal.in
    public final void a(float f16, Interpolator interpolator) {
        float interpolation = interpolator.getInterpolation(f16);
        in.b bVar = this.f148806h;
        if (bVar != null) {
            bVar.b(interpolation);
        }
    }
}
