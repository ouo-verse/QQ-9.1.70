package com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BlindBoxOperationBottomBarButton {
    public boolean enable;
    public boolean isDiscountPrice;
    public String price;
    public String text;
    public int type;

    public BlindBoxOperationBottomBarButton() {
        this(0, 31);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(this.type) * 31;
        boolean z16 = this.enable;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.price, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.text, (ordinal + i3) * 31, 31), 31);
        boolean z17 = this.isDiscountPrice;
        return m3 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BlindBoxOperationBottomBarButton(type=");
        m3.append(BlindBoxOperationBottomBarButtonType$EnumUnboxingLocalUtility.stringValueOf(this.type));
        m3.append(", enable=");
        m3.append(this.enable);
        m3.append(", text=");
        m3.append(this.text);
        m3.append(", price=");
        m3.append(this.price);
        m3.append(", isDiscountPrice=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isDiscountPrice, ')');
    }

    public BlindBoxOperationBottomBarButton(int i3, boolean z16, String str, String str2, boolean z17) {
        this.type = i3;
        this.enable = z16;
        this.text = str;
        this.price = str2;
        this.isDiscountPrice = z17;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlindBoxOperationBottomBarButton)) {
            return false;
        }
        BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton = (BlindBoxOperationBottomBarButton) obj;
        return this.type == blindBoxOperationBottomBarButton.type && this.enable == blindBoxOperationBottomBarButton.enable && Intrinsics.areEqual(this.text, blindBoxOperationBottomBarButton.text) && Intrinsics.areEqual(this.price, blindBoxOperationBottomBarButton.price) && this.isDiscountPrice == blindBoxOperationBottomBarButton.isDiscountPrice;
    }

    public /* synthetic */ BlindBoxOperationBottomBarButton(int i3, int i16) {
        this((i16 & 1) != 0 ? 1 : i3, (i16 & 2) != 0, (i16 & 4) != 0 ? "" : null, (i16 & 8) != 0 ? "" : null, false);
    }
}
