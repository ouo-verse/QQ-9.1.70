package com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPShootTrackTransform {
    public final NBPShootPoint point;
    public final float rotate;
    public final float translateX;
    public final float translateY;

    public NBPShootTrackTransform(NBPShootPoint nBPShootPoint, float f16, float f17, float f18) {
        this.point = nBPShootPoint;
        this.translateX = f16;
        this.translateY = f17;
        this.rotate = f18;
    }

    public final float getRotate() {
        return this.rotate;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.rotate) + PopoverTriangle$$ExternalSyntheticOutline0.m(this.translateY, PopoverTriangle$$ExternalSyntheticOutline0.m(this.translateX, this.point.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPShootTrackTransform(point=");
        m3.append(this.point);
        m3.append(", translateX=");
        m3.append(this.translateX);
        m3.append(", translateY=");
        m3.append(this.translateY);
        m3.append(", rotate=");
        m3.append(this.rotate);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPShootTrackTransform)) {
            return false;
        }
        NBPShootTrackTransform nBPShootTrackTransform = (NBPShootTrackTransform) obj;
        return Intrinsics.areEqual(this.point, nBPShootTrackTransform.point) && Float.compare(this.translateX, nBPShootTrackTransform.translateX) == 0 && Float.compare(this.translateY, nBPShootTrackTransform.translateY) == 0 && Float.compare(this.rotate, nBPShootTrackTransform.rotate) == 0;
    }
}
