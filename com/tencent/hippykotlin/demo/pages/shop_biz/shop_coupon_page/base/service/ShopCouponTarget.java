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
public final class ShopCouponTarget implements ISSOModel {

    /* renamed from: id, reason: collision with root package name */
    public final String f114305id;
    public final String idName;
    public final int idType;

    public ShopCouponTarget() {
        this(0, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("id_type", this.idType);
        eVar.v("id", this.f114305id);
        eVar.v("id_name", this.idName);
        return eVar;
    }

    public final int hashCode() {
        return this.idName.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.f114305id, this.idType * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponTarget(idType=");
        m3.append(this.idType);
        m3.append(", id=");
        m3.append(this.f114305id);
        m3.append(", idName=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.idName, ')');
    }

    public ShopCouponTarget(int i3, String str, String str2) {
        this.idType = i3;
        this.f114305id = str;
        this.idName = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponTarget)) {
            return false;
        }
        ShopCouponTarget shopCouponTarget = (ShopCouponTarget) obj;
        return this.idType == shopCouponTarget.idType && Intrinsics.areEqual(this.f114305id, shopCouponTarget.f114305id) && Intrinsics.areEqual(this.idName, shopCouponTarget.idName);
    }

    public /* synthetic */ ShopCouponTarget(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "");
    }
}
