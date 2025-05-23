package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailProductID implements ISSOModel {

    /* renamed from: id, reason: collision with root package name */
    public final String f114240id;
    public final String subType;
    public final int type;

    public ProductDetailProductID() {
        this(0, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("type", this.type);
        eVar.v("id", this.f114240id);
        eVar.v("sub_type", this.subType);
        return eVar;
    }

    public final int hashCode() {
        return this.subType.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.f114240id, this.type * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailProductID(type=");
        m3.append(this.type);
        m3.append(", id=");
        m3.append(this.f114240id);
        m3.append(", subType=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.subType, ')');
    }

    public ProductDetailProductID(int i3, String str, String str2) {
        this.type = i3;
        this.f114240id = str;
        this.subType = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailProductID)) {
            return false;
        }
        ProductDetailProductID productDetailProductID = (ProductDetailProductID) obj;
        return this.type == productDetailProductID.type && Intrinsics.areEqual(this.f114240id, productDetailProductID.f114240id) && Intrinsics.areEqual(this.subType, productDetailProductID.subType);
    }

    public /* synthetic */ ProductDetailProductID(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "");
    }
}
