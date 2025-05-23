package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.QQECShopProductCard;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailSimilarRecomRsp implements ISSOModel {
    public static final ISSOModelFactory<ProductDetailSimilarRecomRsp> Factory = new ISSOModelFactory<ProductDetailSimilarRecomRsp>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailSimilarRecomRsp$Companion$Factory$1
        @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
        public final ProductDetailSimilarRecomRsp decode(e eVar) {
            ArrayList arrayList;
            String q16 = eVar.q("cookie", "");
            boolean g16 = eVar.g("is_end", false);
            b l3 = eVar.l("recom_card");
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        QQECShopProductCard.Companion companion = QQECShopProductCard.Companion;
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        arrayList.add(companion.decode((e) d16));
                    }
                }
            } else {
                arrayList = null;
            }
            return new ProductDetailSimilarRecomRsp(arrayList, q16, g16);
        }
    };
    public final String cookie;
    public final boolean is_end;
    public final ArrayList<QQECShopProductCard> recom_card;

    public ProductDetailSimilarRecomRsp() {
        this(null, null, false, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("cookie", this.cookie);
        eVar.w("is_end", this.is_end);
        b bVar = new b();
        ArrayList<QQECShopProductCard> arrayList = this.recom_card;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t((QQECShopProductCard) it.next());
            }
        }
        eVar.v("recom_card", bVar);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        ArrayList<QQECShopProductCard> arrayList = this.recom_card;
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.cookie, (arrayList == null ? 0 : arrayList.hashCode()) * 31, 31);
        boolean z16 = this.is_end;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return m3 + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailSimilarRecomRsp(recom_card=");
        m3.append(this.recom_card);
        m3.append(", cookie=");
        m3.append(this.cookie);
        m3.append(", is_end=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.is_end, ')');
    }

    public ProductDetailSimilarRecomRsp(ArrayList<QQECShopProductCard> arrayList, String str, boolean z16) {
        this.recom_card = arrayList;
        this.cookie = str;
        this.is_end = z16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailSimilarRecomRsp)) {
            return false;
        }
        ProductDetailSimilarRecomRsp productDetailSimilarRecomRsp = (ProductDetailSimilarRecomRsp) obj;
        return Intrinsics.areEqual(this.recom_card, productDetailSimilarRecomRsp.recom_card) && Intrinsics.areEqual(this.cookie, productDetailSimilarRecomRsp.cookie) && this.is_end == productDetailSimilarRecomRsp.is_end;
    }

    public /* synthetic */ ProductDetailSimilarRecomRsp(ArrayList arrayList, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, "", false);
    }
}
