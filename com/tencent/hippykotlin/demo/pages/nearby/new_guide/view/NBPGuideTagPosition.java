package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;

/* loaded from: classes31.dex */
public final class NBPGuideTagPosition {
    public final int horizontal;

    /* renamed from: x, reason: collision with root package name */
    public final float f114236x;

    /* renamed from: y, reason: collision with root package name */
    public final float f114237y;

    public NBPGuideTagPosition(float f16, float f17, int i3) {
        this.f114236x = f16;
        this.f114237y = f17;
        this.horizontal = i3;
    }

    public final int hashCode() {
        return BoxType$EnumUnboxingSharedUtility.ordinal(this.horizontal) + PopoverTriangle$$ExternalSyntheticOutline0.m(this.f114237y, Float.floatToIntBits(this.f114236x) * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPGuideTagPosition(x=");
        m3.append(this.f114236x);
        m3.append(", y=");
        m3.append(this.f114237y);
        m3.append(", horizontal=");
        m3.append(NBPGuideTagPositionHorizontal$EnumUnboxingLocalUtility.stringValueOf(this.horizontal));
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPGuideTagPosition)) {
            return false;
        }
        NBPGuideTagPosition nBPGuideTagPosition = (NBPGuideTagPosition) obj;
        return Float.compare(this.f114236x, nBPGuideTagPosition.f114236x) == 0 && Float.compare(this.f114237y, nBPGuideTagPosition.f114237y) == 0 && this.horizontal == nBPGuideTagPosition.horizontal;
    }
}
