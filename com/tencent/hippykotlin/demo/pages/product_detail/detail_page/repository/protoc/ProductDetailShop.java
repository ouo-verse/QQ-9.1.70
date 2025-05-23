package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailShop implements ISSOModel {
    public final ProductDetailButtonItem button;
    public final ProductDetailShopDynamic dynamic;
    public final String icon;

    /* renamed from: id, reason: collision with root package name */
    public final String f114242id;
    public final String name;

    public ProductDetailShop() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("id", this.f114242id);
        eVar.v("name", this.name);
        eVar.v("icon", this.icon);
        ProductDetailButtonItem productDetailButtonItem = this.button;
        if (productDetailButtonItem != null) {
            eVar.v("button", productDetailButtonItem.encode());
        }
        ProductDetailShopDynamic productDetailShopDynamic = this.dynamic;
        if (productDetailShopDynamic != null) {
            eVar.v(TabPreloadItem.TAB_NAME_DYNAMIC, productDetailShopDynamic.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.icon, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.f114242id.hashCode() * 31, 31), 31);
        ProductDetailButtonItem productDetailButtonItem = this.button;
        int hashCode = (m3 + (productDetailButtonItem == null ? 0 : productDetailButtonItem.hashCode())) * 31;
        ProductDetailShopDynamic productDetailShopDynamic = this.dynamic;
        return hashCode + (productDetailShopDynamic != null ? productDetailShopDynamic.sales.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailShop(id=");
        m3.append(this.f114242id);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", icon=");
        m3.append(this.icon);
        m3.append(", button=");
        m3.append(this.button);
        m3.append(", dynamic=");
        m3.append(this.dynamic);
        m3.append(')');
        return m3.toString();
    }

    public ProductDetailShop(String str, String str2, String str3, ProductDetailButtonItem productDetailButtonItem, ProductDetailShopDynamic productDetailShopDynamic) {
        this.f114242id = str;
        this.name = str2;
        this.icon = str3;
        this.button = productDetailButtonItem;
        this.dynamic = productDetailShopDynamic;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailShop)) {
            return false;
        }
        ProductDetailShop productDetailShop = (ProductDetailShop) obj;
        return Intrinsics.areEqual(this.f114242id, productDetailShop.f114242id) && Intrinsics.areEqual(this.name, productDetailShop.name) && Intrinsics.areEqual(this.icon, productDetailShop.icon) && Intrinsics.areEqual(this.button, productDetailShop.button) && Intrinsics.areEqual(this.dynamic, productDetailShop.dynamic);
    }

    public /* synthetic */ ProductDetailShop(String str, String str2, String str3, ProductDetailButtonItem productDetailButtonItem, ProductDetailShopDynamic productDetailShopDynamic, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", null, null);
    }
}
