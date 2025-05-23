package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailSkuInfo implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final ProductDetailActiveSku activeSku;
    public final long createTime;
    public final ProductDetailSkuDynamic dynamic;
    public final ArrayList<ProductDetailPicInfo> previewPics;
    public final ProductDetailPrice price;
    public final String skuId;
    public final int skuType;
    public final ProductDetailSpecInfo specInfo;
    public final String spuId;
    public final int status;
    public final long updateTime;

    public ProductDetailSkuInfo() {
        this(null, null, null, null, null, 0L, 0L, 0, 0, null, null, 2047, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("sku_id", this.skuId);
        eVar.v("spu_id", this.spuId);
        ProductDetailPrice productDetailPrice = this.price;
        if (productDetailPrice != null) {
            eVar.v("price", productDetailPrice.encode());
        }
        b bVar = new b();
        ArrayList<ProductDetailPicInfo> arrayList = this.previewPics;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ProductDetailPicInfo) it.next()).encode());
            }
        }
        eVar.v("preview_pics", bVar);
        ProductDetailSpecInfo productDetailSpecInfo = this.specInfo;
        if (productDetailSpecInfo != null) {
            eVar.v("spec_info", productDetailSpecInfo.encode());
        }
        eVar.u(AlbumCacheData.CREATE_TIME, this.createTime);
        eVar.u("update_time", this.updateTime);
        eVar.t("status", this.status);
        eVar.t("sku_type", this.skuType);
        ProductDetailSkuDynamic productDetailSkuDynamic = this.dynamic;
        if (productDetailSkuDynamic != null) {
            eVar.v(TabPreloadItem.TAB_NAME_DYNAMIC, productDetailSkuDynamic.encode());
        }
        ProductDetailActiveSku productDetailActiveSku = this.activeSku;
        if (productDetailActiveSku != null) {
            eVar.v("active_sku", productDetailActiveSku.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.spuId, this.skuId.hashCode() * 31, 31);
        ProductDetailPrice productDetailPrice = this.price;
        int hashCode = (m3 + (productDetailPrice == null ? 0 : productDetailPrice.hashCode())) * 31;
        ArrayList<ProductDetailPicInfo> arrayList = this.previewPics;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ProductDetailSpecInfo productDetailSpecInfo = this.specInfo;
        int m16 = QQAudioParams$$ExternalSyntheticOutline0.m(this.skuType, QQAudioParams$$ExternalSyntheticOutline0.m(this.status, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.updateTime, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.createTime, (hashCode2 + (productDetailSpecInfo == null ? 0 : productDetailSpecInfo.hashCode())) * 31, 31), 31), 31), 31);
        ProductDetailSkuDynamic productDetailSkuDynamic = this.dynamic;
        int hashCode3 = (m16 + (productDetailSkuDynamic == null ? 0 : productDetailSkuDynamic.hashCode())) * 31;
        ProductDetailActiveSku productDetailActiveSku = this.activeSku;
        return hashCode3 + (productDetailActiveSku != null ? productDetailActiveSku.hashCode() : 0);
    }

    public final String toString() {
        return "ProductDetailSkuInfo(skuId=" + this.skuId + ", spuId=" + this.spuId + ", price=" + this.price + ", previewPics=" + this.previewPics + ", specInfo=" + this.specInfo + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", status=" + this.status + ", skuType=" + this.skuType + ", dynamic=" + this.dynamic + ", activeSku=" + this.activeSku + ')';
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final ProductDetailSkuInfo decode(e eVar) {
            ArrayList arrayList;
            ProductDetailSpecInfo productDetailSpecInfo;
            int i3;
            ProductDetailSkuDynamic productDetailSkuDynamic;
            ProductDetailBuyLimit productDetailBuyLimit;
            ArrayList arrayList2;
            String q16 = eVar.q("sku_id", "");
            String q17 = eVar.q("spu_id", "");
            e m3 = eVar.m("price");
            ProductDetailPrice productDetailPrice = m3 != null ? new ProductDetailPrice(m3.q("origin_price_txt", ""), m3.q("discount_price_txt", ""), m3.q("price_txt", ""), m3.o("discount_price", 0L), m3.q("discount_price_desc", "")) : null;
            b l3 = eVar.l("preview_pics");
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                for (int i16 = 0; i16 < c16; i16++) {
                    Object d16 = l3.d(i16);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        arrayList.add(new ProductDetailPicInfo(eVar2.q("url", ""), eVar2.k("width", 0), eVar2.k("height", 0), eVar2.q("desc", ""), eVar2.q("thumbnail_url", ""), eVar2.k(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0), eVar2.k(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0)));
                    }
                }
            } else {
                arrayList = null;
            }
            e m16 = eVar.m("spec_info");
            if (m16 != null) {
                b l16 = m16.l("items");
                if (l16 != null) {
                    arrayList2 = new ArrayList();
                    int c17 = l16.c();
                    for (int i17 = 0; i17 < c17; i17++) {
                        Object d17 = l16.d(i17);
                        if (d17 != null) {
                            Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                            e eVar3 = (e) d17;
                            arrayList2.add(new ProductDetailSpecItem(eVar3.q("id", ""), eVar3.q("name", ""), eVar3.q("value", "")));
                        }
                    }
                } else {
                    arrayList2 = null;
                }
                productDetailSpecInfo = new ProductDetailSpecInfo(arrayList2);
            } else {
                productDetailSpecInfo = null;
            }
            long o16 = eVar.o(AlbumCacheData.CREATE_TIME, 0L);
            long o17 = eVar.o("update_time", 0L);
            int k3 = eVar.k("status", 0);
            int k16 = eVar.k("sku_type", 0);
            e m17 = eVar.m(TabPreloadItem.TAB_NAME_DYNAMIC);
            if (m17 != null) {
                String q18 = m17.q("stock", "");
                long o18 = m17.o("stock_nums", 0L);
                e m18 = m17.m("buy_limit");
                if (m18 != null) {
                    i3 = k3;
                    productDetailBuyLimit = new ProductDetailBuyLimit(m18.k("user_daily_limit", 0));
                } else {
                    i3 = k3;
                    productDetailBuyLimit = null;
                }
                productDetailSkuDynamic = new ProductDetailSkuDynamic(q18, o18, productDetailBuyLimit);
            } else {
                i3 = k3;
                productDetailSkuDynamic = null;
            }
            e m19 = eVar.m("active_sku");
            return new ProductDetailSkuInfo(q16, q17, productDetailPrice, arrayList, productDetailSpecInfo, o16, o17, i3, k16, productDetailSkuDynamic, m19 != null ? ProductDetailActiveSku.Companion.decode(m19) : null);
        }
    }

    public ProductDetailSkuInfo(String str, String str2, ProductDetailPrice productDetailPrice, ArrayList<ProductDetailPicInfo> arrayList, ProductDetailSpecInfo productDetailSpecInfo, long j3, long j16, int i3, int i16, ProductDetailSkuDynamic productDetailSkuDynamic, ProductDetailActiveSku productDetailActiveSku) {
        this.skuId = str;
        this.spuId = str2;
        this.price = productDetailPrice;
        this.previewPics = arrayList;
        this.specInfo = productDetailSpecInfo;
        this.createTime = j3;
        this.updateTime = j16;
        this.status = i3;
        this.skuType = i16;
        this.dynamic = productDetailSkuDynamic;
        this.activeSku = productDetailActiveSku;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailSkuInfo)) {
            return false;
        }
        ProductDetailSkuInfo productDetailSkuInfo = (ProductDetailSkuInfo) obj;
        return Intrinsics.areEqual(this.skuId, productDetailSkuInfo.skuId) && Intrinsics.areEqual(this.spuId, productDetailSkuInfo.spuId) && Intrinsics.areEqual(this.price, productDetailSkuInfo.price) && Intrinsics.areEqual(this.previewPics, productDetailSkuInfo.previewPics) && Intrinsics.areEqual(this.specInfo, productDetailSkuInfo.specInfo) && this.createTime == productDetailSkuInfo.createTime && this.updateTime == productDetailSkuInfo.updateTime && this.status == productDetailSkuInfo.status && this.skuType == productDetailSkuInfo.skuType && Intrinsics.areEqual(this.dynamic, productDetailSkuInfo.dynamic) && Intrinsics.areEqual(this.activeSku, productDetailSkuInfo.activeSku);
    }

    public /* synthetic */ ProductDetailSkuInfo(String str, String str2, ProductDetailPrice productDetailPrice, ArrayList arrayList, ProductDetailSpecInfo productDetailSpecInfo, long j3, long j16, int i3, int i16, ProductDetailSkuDynamic productDetailSkuDynamic, ProductDetailActiveSku productDetailActiveSku, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", null, null, null, 0L, 0L, 0, 0, null, null);
    }
}
