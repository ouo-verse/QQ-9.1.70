package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterShopInfo implements ISSOModel {
    public final String shopId;
    public final String shopName;
    public final String url;

    public GoodsCenterShopInfo() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("shop_id", this.shopId);
        eVar.v("shop_name", this.shopName);
        eVar.v("url", this.url);
        return eVar;
    }

    public final int hashCode() {
        return this.url.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.shopName, this.shopId.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterShopInfo(shopId=");
        m3.append(this.shopId);
        m3.append(", shopName=");
        m3.append(this.shopName);
        m3.append(", url=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.url, ')');
    }

    public GoodsCenterShopInfo(String str, String str2, String str3) {
        this.shopId = str;
        this.shopName = str2;
        this.url = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterShopInfo)) {
            return false;
        }
        GoodsCenterShopInfo goodsCenterShopInfo = (GoodsCenterShopInfo) obj;
        return Intrinsics.areEqual(this.shopId, goodsCenterShopInfo.shopId) && Intrinsics.areEqual(this.shopName, goodsCenterShopInfo.shopName) && Intrinsics.areEqual(this.url, goodsCenterShopInfo.url);
    }

    public /* synthetic */ GoodsCenterShopInfo(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "");
    }
}
