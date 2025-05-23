package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailSpecItem implements ISSOModel {

    /* renamed from: id, reason: collision with root package name */
    public final String f114243id;
    public final String name;
    public final String value;

    public ProductDetailSpecItem() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("id", this.f114243id);
        eVar.v("name", this.name);
        eVar.v("value", this.value);
        return eVar;
    }

    public final int hashCode() {
        return this.value.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.f114243id.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailSpecItem(id=");
        m3.append(this.f114243id);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", value=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.value, ')');
    }

    public ProductDetailSpecItem(String str, String str2, String str3) {
        this.f114243id = str;
        this.name = str2;
        this.value = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailSpecItem)) {
            return false;
        }
        ProductDetailSpecItem productDetailSpecItem = (ProductDetailSpecItem) obj;
        return Intrinsics.areEqual(this.f114243id, productDetailSpecItem.f114243id) && Intrinsics.areEqual(this.name, productDetailSpecItem.name) && Intrinsics.areEqual(this.value, productDetailSpecItem.value);
    }

    public /* synthetic */ ProductDetailSpecItem(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "");
    }
}
