package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponEntry implements ISSOModel {
    public final String key;
    public final String value;

    public ShopCouponEntry() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("key", this.key);
        eVar.v("value", this.value);
        return eVar;
    }

    public final int hashCode() {
        return this.value.hashCode() + (this.key.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponEntry(key=");
        m3.append(this.key);
        m3.append(", value=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.value, ')');
    }

    public ShopCouponEntry(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public /* synthetic */ ShopCouponEntry(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponEntry)) {
            return false;
        }
        ShopCouponEntry shopCouponEntry = (ShopCouponEntry) obj;
        return Intrinsics.areEqual(this.key, shopCouponEntry.key) && Intrinsics.areEqual(this.value, shopCouponEntry.value);
    }
}
