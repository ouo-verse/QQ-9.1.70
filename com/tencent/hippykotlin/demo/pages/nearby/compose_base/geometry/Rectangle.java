package com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Rectangle {
    public final float bottom;
    public final float left;
    public final float right;
    public final float top;

    public Rectangle(float f16, float f17, float f18, float f19) {
        this.left = f16;
        this.right = f17;
        this.top = f18;
        this.bottom = f19;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.bottom) + PopoverTriangle$$ExternalSyntheticOutline0.m(this.top, PopoverTriangle$$ExternalSyntheticOutline0.m(this.right, Float.floatToIntBits(this.left) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Rectangle(left=");
        m3.append(this.left);
        m3.append(", right=");
        m3.append(this.right);
        m3.append(", top=");
        m3.append(this.top);
        m3.append(", bottom=");
        m3.append(this.bottom);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return Float.compare(this.left, rectangle.left) == 0 && Float.compare(this.right, rectangle.right) == 0 && Float.compare(this.top, rectangle.top) == 0 && Float.compare(this.bottom, rectangle.bottom) == 0;
    }
}
