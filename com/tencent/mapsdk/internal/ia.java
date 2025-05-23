package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.tencentmap.mapsdk.maps.model.IScaleAnimation;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ia extends hw implements IScaleAnimation {
    public ia(float f16, float f17, float f18, float f19) {
        if (this.f148757a == null) {
            this.f148757a = new ir(f16, f17, f18, f19);
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
