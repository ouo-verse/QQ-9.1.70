package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductReviewHrefData implements ISSOModel {
    public final String content;
    public final String topicId;
    public final String url;

    public ProductReviewHrefData() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("content", this.content);
        eVar.v("url", this.url);
        eVar.v("topic_id", this.topicId);
        return eVar;
    }

    public final int hashCode() {
        return this.topicId.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.url, this.content.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductReviewHrefData(content=");
        m3.append(this.content);
        m3.append(", url=");
        m3.append(this.url);
        m3.append(", topicId=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.topicId, ')');
    }

    public ProductReviewHrefData(String str, String str2, String str3) {
        this.content = str;
        this.url = str2;
        this.topicId = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductReviewHrefData)) {
            return false;
        }
        ProductReviewHrefData productReviewHrefData = (ProductReviewHrefData) obj;
        return Intrinsics.areEqual(this.content, productReviewHrefData.content) && Intrinsics.areEqual(this.url, productReviewHrefData.url) && Intrinsics.areEqual(this.topicId, productReviewHrefData.topicId);
    }

    public /* synthetic */ ProductReviewHrefData(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "");
    }
}
