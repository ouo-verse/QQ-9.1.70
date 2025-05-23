package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailService implements ISSOModel {
    public final ArrayList<ProductDetailServiceItem> services;
    public final String shipTemplateId;
    public final String shippingTips;

    public ProductDetailService() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<ProductDetailServiceItem> arrayList = this.services;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ProductDetailServiceItem) it.next()).encode());
            }
        }
        eVar.v("services", bVar);
        eVar.v("ship_template_id", this.shipTemplateId);
        eVar.v("shipping_tips", this.shippingTips);
        return eVar;
    }

    public final int hashCode() {
        ArrayList<ProductDetailServiceItem> arrayList = this.services;
        return this.shippingTips.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.shipTemplateId, (arrayList == null ? 0 : arrayList.hashCode()) * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailService(services=");
        m3.append(this.services);
        m3.append(", shipTemplateId=");
        m3.append(this.shipTemplateId);
        m3.append(", shippingTips=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.shippingTips, ')');
    }

    public ProductDetailService(ArrayList<ProductDetailServiceItem> arrayList, String str, String str2) {
        this.services = arrayList;
        this.shipTemplateId = str;
        this.shippingTips = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailService)) {
            return false;
        }
        ProductDetailService productDetailService = (ProductDetailService) obj;
        return Intrinsics.areEqual(this.services, productDetailService.services) && Intrinsics.areEqual(this.shipTemplateId, productDetailService.shipTemplateId) && Intrinsics.areEqual(this.shippingTips, productDetailService.shippingTips);
    }

    public /* synthetic */ ProductDetailService(ArrayList arrayList, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, "", "");
    }
}
