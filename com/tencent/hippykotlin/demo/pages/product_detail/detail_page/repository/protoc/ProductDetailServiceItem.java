package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailServiceItem implements ISSOModel {
    public final String desc;
    public final String icon;
    public final int serviceType;
    public final String title;

    public ProductDetailServiceItem() {
        this(0, null, null, null, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("service_type", this.serviceType);
        eVar.v("icon", this.icon);
        eVar.v("title", this.title);
        eVar.v("desc", this.desc);
        return eVar;
    }

    public final int hashCode() {
        return this.desc.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.title, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.icon, this.serviceType * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailServiceItem(serviceType=");
        m3.append(this.serviceType);
        m3.append(", icon=");
        m3.append(this.icon);
        m3.append(", title=");
        m3.append(this.title);
        m3.append(", desc=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.desc, ')');
    }

    public ProductDetailServiceItem(int i3, String str, String str2, String str3) {
        this.serviceType = i3;
        this.icon = str;
        this.title = str2;
        this.desc = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailServiceItem)) {
            return false;
        }
        ProductDetailServiceItem productDetailServiceItem = (ProductDetailServiceItem) obj;
        return this.serviceType == productDetailServiceItem.serviceType && Intrinsics.areEqual(this.icon, productDetailServiceItem.icon) && Intrinsics.areEqual(this.title, productDetailServiceItem.title) && Intrinsics.areEqual(this.desc, productDetailServiceItem.desc);
    }

    public /* synthetic */ ProductDetailServiceItem(int i3, String str, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "", "");
    }
}
