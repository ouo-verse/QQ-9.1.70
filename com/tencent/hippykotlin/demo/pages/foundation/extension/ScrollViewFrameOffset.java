package com.tencent.hippykotlin.demo.pages.foundation.extension;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ScrollViewFrameOffset {

    /* renamed from: h, reason: collision with root package name */
    public final float f114184h;
    public final float offsetX;
    public final float offsetY;

    /* renamed from: w, reason: collision with root package name */
    public final float f114185w;

    public ScrollViewFrameOffset(float f16, float f17, float f18, float f19) {
        this.f114185w = f16;
        this.f114184h = f17;
        this.offsetX = f18;
        this.offsetY = f19;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.offsetY) + PopoverTriangle$$ExternalSyntheticOutline0.m(this.offsetX, PopoverTriangle$$ExternalSyntheticOutline0.m(this.f114184h, Float.floatToIntBits(this.f114185w) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ScrollViewFrameOffset(w=");
        m3.append(this.f114185w);
        m3.append(", h=");
        m3.append(this.f114184h);
        m3.append(", offsetX=");
        m3.append(this.offsetX);
        m3.append(", offsetY=");
        m3.append(this.offsetY);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollViewFrameOffset)) {
            return false;
        }
        ScrollViewFrameOffset scrollViewFrameOffset = (ScrollViewFrameOffset) obj;
        return Float.compare(this.f114185w, scrollViewFrameOffset.f114185w) == 0 && Float.compare(this.f114184h, scrollViewFrameOffset.f114184h) == 0 && Float.compare(this.offsetX, scrollViewFrameOffset.offsetX) == 0 && Float.compare(this.offsetY, scrollViewFrameOffset.offsetY) == 0;
    }
}
