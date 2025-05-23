package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.cache;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewReviewDetail;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailShopCache {
    public final Set<String> loadSpuIds = new LinkedHashSet();
    public final Map<String, ProductDetailProductCardRsp> detailCaches = new LinkedHashMap();
    public final Map<String, ProductReviewGetsRsp> commentCaches = new LinkedHashMap();

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp>] */
    public final void updateCommentCache(String str, ProductReviewGetsRsp productReviewGetsRsp) {
        this.commentCaches.put(str, productReviewGetsRsp);
        ProductDetailProductCardRsp productDetailProductCardRsp = (ProductDetailProductCardRsp) this.detailCaches.get(str);
        if (productDetailProductCardRsp != null) {
            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
            e eVar = new e();
            eVar.v("detail", productDetailProductCardRsp.encode());
            if (productReviewGetsRsp != null) {
                eVar.v("comment", productReviewGetsRsp.encode());
            }
            currentBridgeModule.setCachedToNative(str, eVar.toString(), ProductDetailShopCache$saveCacheToNative$1.INSTANCE);
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("save native cache, spuId:[", str, "] hasComment:[");
            m3.append(productReviewGetsRsp != null);
            m3.append(']');
            kLog.i("ProductDetail", m3.toString());
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp>] */
    public final void updateDetailCache(String str, ProductDetailProductCardRsp productDetailProductCardRsp) {
        this.detailCaches.put(str, productDetailProductCardRsp);
        ProductReviewGetsRsp productReviewGetsRsp = (ProductReviewGetsRsp) this.commentCaches.get(str);
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e eVar = new e();
        eVar.v("detail", productDetailProductCardRsp.encode());
        if (productReviewGetsRsp != null) {
            eVar.v("comment", productReviewGetsRsp.encode());
        }
        currentBridgeModule.setCachedToNative(str, eVar.toString(), ProductDetailShopCache$saveCacheToNative$1.INSTANCE);
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("save native cache, spuId:[", str, "] hasComment:[");
        m3.append(productReviewGetsRsp != null);
        m3.append(']');
        kLog.i("ProductDetail", m3.toString());
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp>] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp>] */
    public final ProductDetailInfo getDetailInfo(String str) {
        ProductReviewGetsRsp productReviewGetsRsp;
        ArrayList arrayList;
        ProductDetailProductCardRsp productDetailProductCardRsp = (ProductDetailProductCardRsp) this.detailCaches.get(str);
        if (productDetailProductCardRsp != null || this.loadSpuIds.contains(str)) {
            if (productDetailProductCardRsp != null) {
                return new ProductDetailInfo(productDetailProductCardRsp, (ProductReviewGetsRsp) this.commentCaches.get(str));
            }
            return null;
        }
        this.loadSpuIds.add(str);
        String cachedFromNative = Utils.INSTANCE.currentBridgeModule().getCachedFromNative(str);
        if (cachedFromNative.length() > 0) {
            e eVar = new e(cachedFromNative);
            ISSOModelFactory<ProductDetailProductCardRsp> iSSOModelFactory = ProductDetailProductCardRsp.Factory;
            e m3 = eVar.m("detail");
            ProductDetailProductCardRsp productDetailProductCardRsp2 = m3 != null ? (ProductDetailProductCardRsp) iSSOModelFactory.decode(m3) : null;
            e m16 = eVar.m("comment");
            if (m16 != null) {
                b l3 = m16.l("review_detail");
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
                productReviewGetsRsp = new ProductReviewGetsRsp(arrayList, m16.k("review_count", 0), m16.q("cookie", ""), m16.g("is_end", false));
            } else {
                productReviewGetsRsp = null;
            }
            if (productDetailProductCardRsp2 == null) {
                productDetailProductCardRsp2 = new ProductDetailProductCardRsp(null, 0, 0, false, null, null, null, null, null, null, null, null, 4095, null);
            }
            ProductDetailInfo productDetailInfo = new ProductDetailInfo(productDetailProductCardRsp2, productReviewGetsRsp);
            if (productDetailProductCardRsp2.spuId.length() > 0) {
                this.detailCaches.put(str, productDetailProductCardRsp2);
                ProductReviewGetsRsp productReviewGetsRsp2 = productDetailInfo.comment;
                if (productReviewGetsRsp2 != null) {
                    this.commentCaches.put(str, productReviewGetsRsp2);
                }
                KLog kLog = KLog.INSTANCE;
                StringBuilder m17 = CacheDiskLru$$ExternalSyntheticOutline0.m("has native cache, spuId:[", str, "] hasComment:[");
                m17.append(productDetailInfo.comment != null);
                m17.append(']');
                kLog.i("ProductDetail", m17.toString());
                return productDetailInfo;
            }
        }
        KLog.INSTANCE.i("ProductDetail", "no native cache, spuId:[" + str + ']');
        return null;
    }
}
