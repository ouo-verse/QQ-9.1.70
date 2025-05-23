package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShopDynamic implements ISSOModel {
    public final String sales;

    public ShopDynamic() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("sales", this.sales);
        return eVar;
    }

    public final int hashCode() {
        return this.sales.hashCode();
    }

    public final String toString() {
        return LoadFailParams$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopDynamic(sales="), this.sales, ')');
    }

    public ShopDynamic(String str) {
        this.sales = str;
    }

    public /* synthetic */ ShopDynamic(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShopDynamic) && Intrinsics.areEqual(this.sales, ((ShopDynamic) obj).sales);
    }
}
