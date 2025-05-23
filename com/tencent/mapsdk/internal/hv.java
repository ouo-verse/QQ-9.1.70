package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hv extends hw implements IAlphaAnimation {
    public hv(float f16, float f17) {
        if (this.f148757a == null) {
            this.f148757a = new im(f16, f17);
        }
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
        if (inVar == null || interpolator == null) {
            return;
        }
        inVar.f148804f = interpolator;
    }
}
