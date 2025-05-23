package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductReviewTextData implements ISSOModel {
    public final String content;

    public ProductReviewTextData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("content", this.content);
        return eVar;
    }

    public final int hashCode() {
        return this.content.hashCode();
    }

    public final String toString() {
        return LoadFailParams$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductReviewTextData(content="), this.content, ')');
    }

    public ProductReviewTextData(String str) {
        this.content = str;
    }

    public /* synthetic */ ProductReviewTextData(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProductReviewTextData) && Intrinsics.areEqual(this.content, ((ProductReviewTextData) obj).content);
    }
}
