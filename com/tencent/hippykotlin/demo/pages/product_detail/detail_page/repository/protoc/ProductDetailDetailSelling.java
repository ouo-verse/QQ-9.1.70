package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailDetailSelling implements ISSOModel {
    public final String hotIcon;
    public final String label;
    public final long timeLimit;

    public ProductDetailDetailSelling() {
        this(null, 0L, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("label", this.label);
        eVar.u("time_limit", this.timeLimit);
        eVar.v("hot_icon", this.hotIcon);
        return eVar;
    }

    public final int hashCode() {
        return this.hotIcon.hashCode() + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.timeLimit, this.label.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailDetailSelling(label=");
        m3.append(this.label);
        m3.append(", timeLimit=");
        m3.append(this.timeLimit);
        m3.append(", hotIcon=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.hotIcon, ')');
    }

    public ProductDetailDetailSelling(String str, long j3, String str2) {
        this.label = str;
        this.timeLimit = j3;
        this.hotIcon = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailDetailSelling)) {
            return false;
        }
        ProductDetailDetailSelling productDetailDetailSelling = (ProductDetailDetailSelling) obj;
        return Intrinsics.areEqual(this.label, productDetailDetailSelling.label) && this.timeLimit == productDetailDetailSelling.timeLimit && Intrinsics.areEqual(this.hotIcon, productDetailDetailSelling.hotIcon);
    }

    public /* synthetic */ ProductDetailDetailSelling(String str, long j3, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0L, "");
    }
}
