package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewReviewDetail;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductReviewGetsRsp implements ISSOModel {
    public static final ISSOModelFactory<ProductReviewGetsRsp> Factory = new ISSOModelFactory<ProductReviewGetsRsp>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp$Companion$Factory$1
        @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
        public final ProductReviewGetsRsp decode(e eVar) {
            ArrayList arrayList;
            b l3 = eVar.l("review_detail");
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        ProductReviewReviewDetail.Companion companion = ProductReviewReviewDetail.Companion;
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        arrayList.add(companion.decode((e) d16));
                    }
                }
            } else {
                arrayList = null;
            }
            return new ProductReviewGetsRsp(arrayList, eVar.k("review_count", 0), eVar.q("cookie", ""), eVar.g("is_end", false));
        }
    };
    public final String cookie;
    public final boolean isEnd;
    public final int reviewCount;
    public final ArrayList<ProductReviewReviewDetail> reviewDetail;

    public ProductReviewGetsRsp() {
        this(false, 15);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<ProductReviewReviewDetail> arrayList = this.reviewDetail;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ProductReviewReviewDetail) it.next()).encode());
            }
        }
        eVar.v("review_detail", bVar);
        eVar.t("review_count", this.reviewCount);
        eVar.v("cookie", this.cookie);
        eVar.w("is_end", this.isEnd);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        ArrayList<ProductReviewReviewDetail> arrayList = this.reviewDetail;
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.cookie, QQAudioParams$$ExternalSyntheticOutline0.m(this.reviewCount, (arrayList == null ? 0 : arrayList.hashCode()) * 31, 31), 31);
        boolean z16 = this.isEnd;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return m3 + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductReviewGetsRsp(reviewDetail=");
        m3.append(this.reviewDetail);
        m3.append(", reviewCount=");
        m3.append(this.reviewCount);
        m3.append(", cookie=");
        m3.append(this.cookie);
        m3.append(", isEnd=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isEnd, ')');
    }

    public ProductReviewGetsRsp(ArrayList<ProductReviewReviewDetail> arrayList, int i3, String str, boolean z16) {
        this.reviewDetail = arrayList;
        this.reviewCount = i3;
        this.cookie = str;
        this.isEnd = z16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductReviewGetsRsp)) {
            return false;
        }
        ProductReviewGetsRsp productReviewGetsRsp = (ProductReviewGetsRsp) obj;
        return Intrinsics.areEqual(this.reviewDetail, productReviewGetsRsp.reviewDetail) && this.reviewCount == productReviewGetsRsp.reviewCount && Intrinsics.areEqual(this.cookie, productReviewGetsRsp.cookie) && this.isEnd == productReviewGetsRsp.isEnd;
    }

    public /* synthetic */ ProductReviewGetsRsp(boolean z16, int i3) {
        this(null, 0, (i3 & 4) != 0 ? "" : null, (i3 & 8) != 0 ? false : z16);
    }
}
