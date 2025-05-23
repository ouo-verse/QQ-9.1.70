package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.cache;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewReviewDetail;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.raft.measure.utils.MeasureConst;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionCache {
    public final Set<String> loadSpuIds = new LinkedHashSet();
    public final Map<String, SellerProductCardRsp> detailCaches = new LinkedHashMap();
    public final Map<String, ProductReviewGetsRsp> commentCaches = new LinkedHashMap();

    public final String cacheKey(String str) {
        return AgreementConsentViewKt$$ExternalSyntheticOutline0.m(MeasureConst.SLI_TYPE_DISTRIBUTION, str);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp>] */
    public final void updateCommentCache(String str, ProductReviewGetsRsp productReviewGetsRsp) {
        this.commentCaches.put(cacheKey(str), productReviewGetsRsp);
        SellerProductCardRsp sellerProductCardRsp = (SellerProductCardRsp) this.detailCaches.get(cacheKey(str));
        if (sellerProductCardRsp != null) {
            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
            String cacheKey = cacheKey(str);
            e eVar = new e();
            eVar.v("detail", sellerProductCardRsp.encode());
            if (productReviewGetsRsp != null) {
                eVar.v("comment", productReviewGetsRsp.encode());
            }
            currentBridgeModule.setCachedToNative(cacheKey, eVar.toString(), ProductDetailDistributionCache$saveCacheToNative$1.INSTANCE);
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("distribution save native cache, spuId:[", str, "] hasComment:[");
            m3.append(productReviewGetsRsp != null);
            m3.append(']');
            kLog.i("ProductDetail", m3.toString());
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp>] */
    public final void updateDetailCache(String str, SellerProductCardRsp sellerProductCardRsp) {
        this.detailCaches.put(cacheKey(str), sellerProductCardRsp);
        ProductReviewGetsRsp productReviewGetsRsp = (ProductReviewGetsRsp) this.commentCaches.get(cacheKey(str));
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        String cacheKey = cacheKey(str);
        e eVar = new e();
        eVar.v("detail", sellerProductCardRsp.encode());
        if (productReviewGetsRsp != null) {
            eVar.v("comment", productReviewGetsRsp.encode());
        }
        currentBridgeModule.setCachedToNative(cacheKey, eVar.toString(), ProductDetailDistributionCache$saveCacheToNative$1.INSTANCE);
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("distribution save native cache, spuId:[", str, "] hasComment:[");
        m3.append(productReviewGetsRsp != null);
        m3.append(']');
        kLog.i("ProductDetail", m3.toString());
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp>] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp>] */
    public final ProductDetailDistributionInfo getDetailInfo(String str) {
        ProductReviewGetsRsp productReviewGetsRsp;
        ArrayList arrayList;
        SellerProductCardRsp sellerProductCardRsp = (SellerProductCardRsp) this.detailCaches.get(cacheKey(str));
        if (sellerProductCardRsp != null || this.loadSpuIds.contains(cacheKey(str))) {
            if (sellerProductCardRsp != null) {
                return new ProductDetailDistributionInfo(sellerProductCardRsp, (ProductReviewGetsRsp) this.commentCaches.get(cacheKey(str)));
            }
            return null;
        }
        this.loadSpuIds.add(cacheKey(str));
        String cachedFromNative = Utils.INSTANCE.currentBridgeModule().getCachedFromNative(cacheKey(str));
        if (cachedFromNative.length() > 0) {
            e eVar = new e(cachedFromNative);
            ISSOModelFactory<SellerProductCardRsp> iSSOModelFactory = SellerProductCardRsp.Factory;
            e m3 = eVar.m("detail");
            SellerProductCardRsp sellerProductCardRsp2 = m3 != null ? (SellerProductCardRsp) iSSOModelFactory.decode(m3) : null;
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
            if (sellerProductCardRsp2 == null) {
                sellerProductCardRsp2 = new SellerProductCardRsp(null, 0, 0, null, null, null, null, null, null, null, null, false, false, null, null, 32767, null);
            }
            ProductDetailDistributionInfo productDetailDistributionInfo = new ProductDetailDistributionInfo(sellerProductCardRsp2, productReviewGetsRsp);
            if (sellerProductCardRsp2.spuId.length() > 0) {
                this.detailCaches.put(cacheKey(str), sellerProductCardRsp2);
                if (productReviewGetsRsp != null) {
                    this.commentCaches.put(cacheKey(str), productReviewGetsRsp);
                }
                KLog kLog = KLog.INSTANCE;
                StringBuilder m17 = CacheDiskLru$$ExternalSyntheticOutline0.m("distribution has native cache, spuId:[", str, "] hasComment:[");
                m17.append(productReviewGetsRsp != null);
                m17.append(']');
                kLog.i("ProductDetail", m17.toString());
                return productDetailDistributionInfo;
            }
        }
        KLog.INSTANCE.i("ProductDetail", "distribution no native cache, spuId:[" + str + ']');
        return null;
    }
}
