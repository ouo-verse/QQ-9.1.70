package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponIssuer implements ISSOModel {

    /* renamed from: id, reason: collision with root package name */
    public final String f114304id;
    public final String name;
    public final int type;

    public ShopCouponIssuer() {
        this(0, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("type", this.type);
        eVar.v("id", this.f114304id);
        eVar.v("name", this.name);
        return eVar;
    }

    public final int hashCode() {
        return this.name.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.f114304id, this.type * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponIssuer(type=");
        m3.append(this.type);
        m3.append(", id=");
        m3.append(this.f114304id);
        m3.append(", name=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.name, ')');
    }

    public ShopCouponIssuer(int i3, String str, String str2) {
        this.type = i3;
        this.f114304id = str;
        this.name = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponIssuer)) {
            return false;
        }
        ShopCouponIssuer shopCouponIssuer = (ShopCouponIssuer) obj;
        return this.type == shopCouponIssuer.type && Intrinsics.areEqual(this.f114304id, shopCouponIssuer.f114304id) && Intrinsics.areEqual(this.name, shopCouponIssuer.name);
    }

    public /* synthetic */ ShopCouponIssuer(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "");
    }
}
