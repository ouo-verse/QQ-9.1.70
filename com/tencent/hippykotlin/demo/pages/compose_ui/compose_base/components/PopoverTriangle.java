package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.base.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class PopoverTriangle {
    public final boolean isTriangleTop;
    public final h triangleColor;
    public final float triangleHeight;
    public final PopoverTriangleOffset triangleOffset;
    public final PopoverTriangleShadow triangleShadow;

    public PopoverTriangle() {
        this(false, 0.0f, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z16 = this.isTriangleTop;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode = (this.triangleOffset.hashCode() + ((this.triangleColor.hashCode() + PopoverTriangle$$ExternalSyntheticOutline0.m(this.triangleHeight, r06 * 31, 31)) * 31)) * 31;
        PopoverTriangleShadow popoverTriangleShadow = this.triangleShadow;
        return hashCode + (popoverTriangleShadow == null ? 0 : popoverTriangleShadow.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("PopoverTriangle(isTriangleTop=");
        m3.append(this.isTriangleTop);
        m3.append(", triangleHeight=");
        m3.append(this.triangleHeight);
        m3.append(", triangleColor=");
        m3.append(this.triangleColor);
        m3.append(", triangleOffset=");
        m3.append(this.triangleOffset);
        m3.append(", triangleShadow=");
        m3.append(this.triangleShadow);
        m3.append(')');
        return m3.toString();
    }

    public PopoverTriangle(boolean z16, float f16, h hVar, PopoverTriangleOffset popoverTriangleOffset, PopoverTriangleShadow popoverTriangleShadow) {
        this.isTriangleTop = z16;
        this.triangleHeight = f16;
        this.triangleColor = hVar;
        this.triangleOffset = popoverTriangleOffset;
        this.triangleShadow = popoverTriangleShadow;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopoverTriangle)) {
            return false;
        }
        PopoverTriangle popoverTriangle = (PopoverTriangle) obj;
        return this.isTriangleTop == popoverTriangle.isTriangleTop && Float.compare(this.triangleHeight, popoverTriangle.triangleHeight) == 0 && Intrinsics.areEqual(this.triangleColor, popoverTriangle.triangleColor) && Intrinsics.areEqual(this.triangleOffset, popoverTriangle.triangleOffset) && Intrinsics.areEqual(this.triangleShadow, popoverTriangle.triangleShadow);
    }

    public /* synthetic */ PopoverTriangle(boolean z16, float f16, h hVar, PopoverTriangleOffset popoverTriangleOffset, PopoverTriangleShadow popoverTriangleShadow, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, 8.35f, new h(4283124813L), new PopoverTriangleOffset(0, 0.0f, 3, null), null);
    }
}
