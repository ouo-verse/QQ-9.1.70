package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailProperty implements ISSOModel {
    public final boolean hasBrand;

    /* renamed from: id, reason: collision with root package name */
    public final String f114241id;
    public final String name;
    public final String value;

    public ProductDetailProperty() {
        this(null, null, null, false, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("id", this.f114241id);
        eVar.v("name", this.name);
        eVar.v("value", this.value);
        eVar.w("has_brand", this.hasBrand);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.value, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.f114241id.hashCode() * 31, 31), 31);
        boolean z16 = this.hasBrand;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return m3 + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailProperty(id=");
        m3.append(this.f114241id);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", value=");
        m3.append(this.value);
        m3.append(", hasBrand=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.hasBrand, ')');
    }

    public ProductDetailProperty(String str, String str2, String str3, boolean z16) {
        this.f114241id = str;
        this.name = str2;
        this.value = str3;
        this.hasBrand = z16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailProperty)) {
            return false;
        }
        ProductDetailProperty productDetailProperty = (ProductDetailProperty) obj;
        return Intrinsics.areEqual(this.f114241id, productDetailProperty.f114241id) && Intrinsics.areEqual(this.name, productDetailProperty.name) && Intrinsics.areEqual(this.value, productDetailProperty.value) && this.hasBrand == productDetailProperty.hasBrand;
    }

    public /* synthetic */ ProductDetailProperty(String str, String str2, String str3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", false);
    }
}
