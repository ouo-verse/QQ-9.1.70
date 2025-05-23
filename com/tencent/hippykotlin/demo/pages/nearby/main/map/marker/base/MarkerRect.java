package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MarkerRect {
    public static final Companion Companion = new Companion();
    public final float bottom;
    public final float height;
    public final float left;
    public final float right;
    public final float top;
    public final float width;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final MarkerRect createRectWithSize(float f16, float f17, float f18, float f19) {
            return new MarkerRect(f16, f17, f18 + f16, f19 + f17);
        }
    }

    public MarkerRect(float f16, float f17, float f18, float f19) {
        this.left = f16;
        this.top = f17;
        this.right = f18;
        this.bottom = f19;
        this.width = f18 - f16;
        this.height = f19 - f17;
    }

    public final boolean contains(float f16, float f17) {
        return f16 >= this.left && f16 <= this.right && f17 >= this.top && f17 <= this.bottom;
    }

    public final float getCenterX() {
        return (this.right + this.left) / 2.0f;
    }

    public final float getCenterY() {
        return (this.bottom + this.top) / 2.0f;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.bottom) + PopoverTriangle$$ExternalSyntheticOutline0.m(this.right, PopoverTriangle$$ExternalSyntheticOutline0.m(this.top, Float.floatToIntBits(this.left) * 31, 31), 31);
    }

    public final MarkerRect scale(float f16, float f17, float f18, float f19) {
        float f26 = this.right;
        float f27 = this.left;
        float f28 = f26 - f27;
        float f29 = this.bottom;
        float f36 = this.top;
        float f37 = f29 - f36;
        float f38 = f16 * f28;
        float f39 = f17 * f37;
        float f46 = ((f28 * f18) + f27) - (f18 * f38);
        float f47 = ((f37 * f19) + f36) - (f19 * f39);
        return new MarkerRect(f46, f47, f38 + f46, f39 + f47);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("MarkerRect(left=");
        m3.append(this.left);
        m3.append(", top=");
        m3.append(this.top);
        m3.append(", right=");
        m3.append(this.right);
        m3.append(", bottom=");
        m3.append(this.bottom);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarkerRect)) {
            return false;
        }
        MarkerRect markerRect = (MarkerRect) obj;
        return Float.compare(this.left, markerRect.left) == 0 && Float.compare(this.top, markerRect.top) == 0 && Float.compare(this.right, markerRect.right) == 0 && Float.compare(this.bottom, markerRect.bottom) == 0;
    }
}
