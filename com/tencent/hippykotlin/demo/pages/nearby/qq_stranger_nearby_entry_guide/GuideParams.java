package com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;

/* loaded from: classes31.dex */
public final class GuideParams {
    public final float targetHeight;
    public final float targetRadius;
    public final float targetWidth;
    public final float targetX;
    public final float targetY;

    public GuideParams(float f16, float f17, float f18, float f19, float f26) {
        this.targetX = f16;
        this.targetY = f17;
        this.targetWidth = f18;
        this.targetHeight = f19;
        this.targetRadius = f26;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.targetRadius) + PopoverTriangle$$ExternalSyntheticOutline0.m(this.targetHeight, PopoverTriangle$$ExternalSyntheticOutline0.m(this.targetWidth, PopoverTriangle$$ExternalSyntheticOutline0.m(this.targetY, Float.floatToIntBits(this.targetX) * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GuideParams(targetX=");
        m3.append(this.targetX);
        m3.append(", targetY=");
        m3.append(this.targetY);
        m3.append(", targetWidth=");
        m3.append(this.targetWidth);
        m3.append(", targetHeight=");
        m3.append(this.targetHeight);
        m3.append(", targetRadius=");
        m3.append(this.targetRadius);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuideParams)) {
            return false;
        }
        GuideParams guideParams = (GuideParams) obj;
        return Float.compare(this.targetX, guideParams.targetX) == 0 && Float.compare(this.targetY, guideParams.targetY) == 0 && Float.compare(this.targetWidth, guideParams.targetWidth) == 0 && Float.compare(this.targetHeight, guideParams.targetHeight) == 0 && Float.compare(this.targetRadius, guideParams.targetRadius) == 0;
    }
}
