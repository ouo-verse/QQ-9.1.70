package com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot;

/* loaded from: classes31.dex */
public final class NBPShootTrackAnimationKt {
    public static final float distance(NBPShootPoint nBPShootPoint, NBPShootPoint nBPShootPoint2) {
        float f16 = nBPShootPoint2.f114234x - nBPShootPoint.f114234x;
        float f17 = nBPShootPoint2.f114235y - nBPShootPoint.f114235y;
        return (float) Math.sqrt((f17 * f17) + (f16 * f16));
    }
}
