package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QQECShopProductCard implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final ProductDetailCommissionInfo commission;
    public final ArrayList<QQECShopCoupon> coupons;
    public final String cover;
    public final boolean is_price_exceed;
    public final String price_str;
    public final ArrayList<ProductDetailLabelInfo> prodTags;
    public final QQECShopProductIDInfo product_id_info;
    public final String sales_str;
    public final String spu_id;
    public final ArrayList<String> tags;
    public final String title;
    public final String url;

    public QQECShopProductCard() {
        this(null, null, null, null, null, null, null, null, null, false, null, null, 4095, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("spu_id", this.spu_id);
        eVar.v("title", this.title);
        eVar.v("cover", this.cover);
        eVar.v("price_str", this.price_str);
        eVar.v("sales_str", this.sales_str);
        eVar.v("url", this.url);
        ProductDetailCommissionInfo productDetailCommissionInfo = this.commission;
        if (productDetailCommissionInfo != null) {
            eVar.v("commission", productDetailCommissionInfo.encode());
        }
        eVar.w("is_price_exceed", this.is_price_exceed);
        QQECShopProductIDInfo qQECShopProductIDInfo = this.product_id_info;
        if (qQECShopProductIDInfo != null) {
            eVar.v("product_id_info", qQECShopProductIDInfo.encode());
        }
        b bVar = new b();
        ArrayList<String> arrayList = this.tags;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t((String) it.next());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, ComicCancelRedPointPopItemData.JSON_KEY_TAGS, bVar);
        ArrayList<QQECShopCoupon> arrayList2 = this.coupons;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.t((QQECShopCoupon) it5.next());
            }
        }
        b m16 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "coupons", m3);
        ArrayList<ProductDetailLabelInfo> arrayList3 = this.prodTags;
        if (arrayList3 != null) {
            Iterator<T> it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                m16.t(((ProductDetailLabelInfo) it6.next()).encode());
            }
        }
        eVar.v("prod_tags", m16);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.sales_str, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.price_str, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.cover, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.title, this.spu_id.hashCode() * 31, 31), 31), 31), 31);
        ArrayList<String> arrayList = this.tags;
        int hashCode = (m3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<QQECShopCoupon> arrayList2 = this.coupons;
        int m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.url, (hashCode + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31, 31);
        ProductDetailCommissionInfo productDetailCommissionInfo = this.commission;
        int hashCode2 = (m16 + (productDetailCommissionInfo == null ? 0 : productDetailCommissionInfo.hashCode())) * 31;
        boolean z16 = this.is_price_exceed;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        QQECShopProductIDInfo qQECShopProductIDInfo = this.product_id_info;
        int hashCode3 = (i16 + (qQECShopProductIDInfo == null ? 0 : qQECShopProductIDInfo.hashCode())) * 31;
        ArrayList<ProductDetailLabelInfo> arrayList3 = this.prodTags;
        return hashCode3 + (arrayList3 != null ? arrayList3.hashCode() : 0);
    }

    public final String toString() {
        return "QQECShopProductCard(spu_id=" + this.spu_id + ", title=" + this.title + ", cover=" + this.cover + ", price_str=" + this.price_str + ", sales_str=" + this.sales_str + ", tags=" + this.tags + ", coupons=" + this.coupons + ", url=" + this.url + ", commission=" + this.commission + ", is_price_exceed=" + this.is_price_exceed + ", product_id_info=" + this.product_id_info + ", prodTags=" + this.prodTags + ')';
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final QQECShopProductCard decode(e eVar) {
            ArrayList arrayList;
            ProductDetailCommissionInfo productDetailCommissionInfo;
            boolean z16;
            QQECShopProductIDInfo qQECShopProductIDInfo;
            ArrayList arrayList2;
            ArrayList arrayList3;
            b bVar;
            b bVar2;
            ProductDetailCommissionInfo productDetailCommissionInfo2;
            boolean z17;
            String q16 = eVar.q("spu_id", "");
            String q17 = eVar.q("title", "");
            String q18 = eVar.q("cover", "");
            String q19 = eVar.q("price_str", "");
            String q26 = eVar.q("sales_str", "");
            String q27 = eVar.q("url", "");
            e m3 = eVar.m("commission");
            ProductDetailCommissionInfo productDetailCommissionInfo3 = m3 != null ? new ProductDetailCommissionInfo(m3.q("commission", ""), m3.q("commission_rate", ""), m3.q("commission_rate_txt", ""), m3.k("plan_type", 0)) : null;
            boolean f16 = eVar.f("is_price_exceed");
            e m16 = eVar.m("product_id_info");
            QQECShopProductIDInfo qQECShopProductIDInfo2 = m16 != null ? new QQECShopProductIDInfo(m16.j("type"), m16.q("productID", ""), m16.q("sub_type", "")) : null;
            b l3 = eVar.l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
            if (l3 != null) {
                ArrayList arrayList4 = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    String o16 = l3.o(i3);
                    if (o16 != null) {
                        arrayList4.add(o16);
                    }
                }
                arrayList = arrayList4;
            } else {
                arrayList = null;
            }
            b l16 = eVar.l("coupons");
            if (l16 != null) {
                arrayList2 = new ArrayList();
                int c17 = l16.c();
                qQECShopProductIDInfo = qQECShopProductIDInfo2;
                int i16 = 0;
                while (i16 < c17) {
                    int i17 = c17;
                    Object d16 = l16.d(i16);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        bVar2 = l16;
                        z17 = f16;
                        productDetailCommissionInfo2 = productDetailCommissionInfo3;
                        arrayList2.add(new QQECShopCoupon(eVar2.q("id", ""), eVar2.q("name", ""), eVar2.q("desc", "")));
                    } else {
                        bVar2 = l16;
                        productDetailCommissionInfo2 = productDetailCommissionInfo3;
                        z17 = f16;
                    }
                    i16++;
                    c17 = i17;
                    l16 = bVar2;
                    f16 = z17;
                    productDetailCommissionInfo3 = productDetailCommissionInfo2;
                }
                productDetailCommissionInfo = productDetailCommissionInfo3;
                z16 = f16;
            } else {
                productDetailCommissionInfo = productDetailCommissionInfo3;
                z16 = f16;
                qQECShopProductIDInfo = qQECShopProductIDInfo2;
                arrayList2 = null;
            }
            b l17 = eVar.l("prod_tags");
            if (l17 != null) {
                ArrayList arrayList5 = new ArrayList();
                int c18 = l17.c();
                int i18 = 0;
                while (i18 < c18) {
                    Object d17 = l17.d(i18);
                    if (d17 != null) {
                        Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar3 = (e) d17;
                        bVar = l17;
                        arrayList5.add(new ProductDetailLabelInfo(eVar3.q("background_color", ""), eVar3.q("text_color", ""), eVar3.q("text", ""), eVar3.q("text_prefix", ""), eVar3.k("text_style_type", 0), eVar3.q(LayoutAttrDefine.BorderColor, ""), eVar3.q("pic_url", ""), eVar3.k("width", 0), eVar3.k("height", 0), eVar3.q("pic_token", "")));
                    } else {
                        bVar = l17;
                    }
                    i18++;
                    l17 = bVar;
                }
                arrayList3 = arrayList5;
            } else {
                arrayList3 = null;
            }
            return new QQECShopProductCard(q16, q17, q18, q19, q26, arrayList, arrayList2, q27, productDetailCommissionInfo, z16, qQECShopProductIDInfo, arrayList3);
        }
    }

    public QQECShopProductCard(String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, ArrayList<QQECShopCoupon> arrayList2, String str6, ProductDetailCommissionInfo productDetailCommissionInfo, boolean z16, QQECShopProductIDInfo qQECShopProductIDInfo, ArrayList<ProductDetailLabelInfo> arrayList3) {
        this.spu_id = str;
        this.title = str2;
        this.cover = str3;
        this.price_str = str4;
        this.sales_str = str5;
        this.tags = arrayList;
        this.coupons = arrayList2;
        this.url = str6;
        this.commission = productDetailCommissionInfo;
        this.is_price_exceed = z16;
        this.product_id_info = qQECShopProductIDInfo;
        this.prodTags = arrayList3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QQECShopProductCard)) {
            return false;
        }
        QQECShopProductCard qQECShopProductCard = (QQECShopProductCard) obj;
        return Intrinsics.areEqual(this.spu_id, qQECShopProductCard.spu_id) && Intrinsics.areEqual(this.title, qQECShopProductCard.title) && Intrinsics.areEqual(this.cover, qQECShopProductCard.cover) && Intrinsics.areEqual(this.price_str, qQECShopProductCard.price_str) && Intrinsics.areEqual(this.sales_str, qQECShopProductCard.sales_str) && Intrinsics.areEqual(this.tags, qQECShopProductCard.tags) && Intrinsics.areEqual(this.coupons, qQECShopProductCard.coupons) && Intrinsics.areEqual(this.url, qQECShopProductCard.url) && Intrinsics.areEqual(this.commission, qQECShopProductCard.commission) && this.is_price_exceed == qQECShopProductCard.is_price_exceed && Intrinsics.areEqual(this.product_id_info, qQECShopProductCard.product_id_info) && Intrinsics.areEqual(this.prodTags, qQECShopProductCard.prodTags);
    }

    public /* synthetic */ QQECShopProductCard(String str, String str2, String str3, String str4, String str5, ArrayList arrayList, ArrayList arrayList2, String str6, ProductDetailCommissionInfo productDetailCommissionInfo, boolean z16, QQECShopProductIDInfo qQECShopProductIDInfo, ArrayList arrayList3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "", null, null, "", null, false, null, null);
    }
}
