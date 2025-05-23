package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hy extends hw implements IEmergeAnimation {

    /* renamed from: c, reason: collision with root package name */
    private LatLng f148762c;

    public hy(LatLng latLng) {
        this.f148762c = null;
        if (this.f148757a == null) {
            this.f148757a = new ip(latLng);
        }
        this.f148762c = latLng;
    }

    private LatLng a() {
        return this.f148762c;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public final void setDuration(long j3) {
        in inVar = this.f148757a;
        if (inVar == null) {
            return;
        }
        inVar.a(j3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public final void setInterpolator(Interpolator interpolator) {
        in inVar = this.f148757a;
        if (inVar != null && interpolator != null) {
            inVar.f148804f = interpolator;
        }
    }
}
