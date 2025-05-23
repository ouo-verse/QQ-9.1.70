package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailActiveSales implements ISSOModel {
    public final long saleNums;
    public final String salesNumsTxt;

    public ProductDetailActiveSales() {
        this(0L, null, 3, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.u("sale_nums", this.saleNums);
        eVar.v("sales_nums_txt", this.salesNumsTxt);
        return eVar;
    }

    public final int hashCode() {
        return this.salesNumsTxt.hashCode() + (d.a(this.saleNums) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailActiveSales(saleNums=");
        m3.append(this.saleNums);
        m3.append(", salesNumsTxt=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.salesNumsTxt, ')');
    }

    public ProductDetailActiveSales(long j3, String str) {
        this.saleNums = j3;
        this.salesNumsTxt = str;
    }

    public /* synthetic */ ProductDetailActiveSales(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailActiveSales)) {
            return false;
        }
        ProductDetailActiveSales productDetailActiveSales = (ProductDetailActiveSales) obj;
        return this.saleNums == productDetailActiveSales.saleNums && Intrinsics.areEqual(this.salesNumsTxt, productDetailActiveSales.salesNumsTxt);
    }
}
