package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hx extends hw implements IAnimationSet {
    public hx(boolean z16) {
        if (this.f148757a == null) {
            this.f148757a = new io(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet
    public final boolean addAnimation(Animation animation) {
        in inVar;
        in inVar2;
        if (animation == null || !(animation instanceof hw) || (inVar = ((hw) animation).f148757a) == null || (inVar2 = this.f148757a) == null) {
            return false;
        }
        ((io) inVar2).a(inVar);
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet
    public final void cleanAnimation() {
        in inVar = this.f148757a;
        if (inVar == null) {
            return;
        }
        ((io) inVar).c();
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
