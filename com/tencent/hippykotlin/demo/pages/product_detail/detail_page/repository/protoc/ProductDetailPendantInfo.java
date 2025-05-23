package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailPendantInfo implements ISSOModel {
    public final String coverUrl;

    public ProductDetailPendantInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("cover_url", this.coverUrl);
        return eVar;
    }

    public final int hashCode() {
        return this.coverUrl.hashCode();
    }

    public final String toString() {
        return LoadFailParams$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailPendantInfo(coverUrl="), this.coverUrl, ')');
    }

    public ProductDetailPendantInfo(String str) {
        this.coverUrl = str;
    }

    public /* synthetic */ ProductDetailPendantInfo(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProductDetailPendantInfo) && Intrinsics.areEqual(this.coverUrl, ((ProductDetailPendantInfo) obj).coverUrl);
    }
}
