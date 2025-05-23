package com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ButtonInfo {
    public static final Companion Companion = new Companion();
    public final boolean isActive;
    public final boolean isDiscountPrice;
    public final String price;
    public final String text;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final Pair<ButtonInfo, String> fromJson(e eVar) {
            boolean g16 = eVar.g("isActive", false);
            String q16 = eVar.q("text", "");
            return new Pair<>(new ButtonInfo(g16, q16, eVar.q("price", ""), eVar.g("isDiscountPrice", false)), eVar.q(WadlProxyConsts.KEY_JUMP_URL, ""));
        }
    }

    public ButtonInfo(boolean z16, String str, String str2, boolean z17) {
        this.isActive = z16;
        this.text = str;
        this.price = str2;
        this.isDiscountPrice = z17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z16 = this.isActive;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.price, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.text, r06 * 31, 31), 31);
        boolean z17 = this.isDiscountPrice;
        return m3 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ButtonInfo(isActive=");
        m3.append(this.isActive);
        m3.append(", text=");
        m3.append(this.text);
        m3.append(", price=");
        m3.append(this.price);
        m3.append(", isDiscountPrice=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isDiscountPrice, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonInfo)) {
            return false;
        }
        ButtonInfo buttonInfo = (ButtonInfo) obj;
        return this.isActive == buttonInfo.isActive && Intrinsics.areEqual(this.text, buttonInfo.text) && Intrinsics.areEqual(this.price, buttonInfo.price) && this.isDiscountPrice == buttonInfo.isDiscountPrice;
    }
}
