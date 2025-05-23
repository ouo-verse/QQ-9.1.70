package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductReviewReviewProductID implements ISSOModel {
    public final String skuId;
    public final String spuId;

    public ProductReviewReviewProductID() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("spu_id", this.spuId);
        eVar.v("sku_id", this.skuId);
        return eVar;
    }

    public final int hashCode() {
        return this.skuId.hashCode() + (this.spuId.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductReviewReviewProductID(spuId=");
        m3.append(this.spuId);
        m3.append(", skuId=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.skuId, ')');
    }

    public ProductReviewReviewProductID(String str, String str2) {
        this.spuId = str;
        this.skuId = str2;
    }

    public /* synthetic */ ProductReviewReviewProductID(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductReviewReviewProductID)) {
            return false;
        }
        ProductReviewReviewProductID productReviewReviewProductID = (ProductReviewReviewProductID) obj;
        return Intrinsics.areEqual(this.spuId, productReviewReviewProductID.spuId) && Intrinsics.areEqual(this.skuId, productReviewReviewProductID.skuId);
    }
}
