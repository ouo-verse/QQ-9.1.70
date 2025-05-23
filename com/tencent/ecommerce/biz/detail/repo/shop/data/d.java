package com.tencent.ecommerce.biz.detail.repo.shop.data;

import com.tencent.hippy.qq.api.TabPreloadItem;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\"\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/d;", "", "", "productId", "activeId", "d", "", "c", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "productDetailInfo", "a", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/b;", "productDetailBuyFloatPageInfo", "g", "e", "shopId", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "info", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "detailDataCache", "liveStatusCache", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f102363c = new d();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, ECShopProductDetailInfo> detailDataCache = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, f> liveStatusCache = new ConcurrentHashMap<>();

    d() {
    }

    public final void a(String productId, ECShopProductDetailInfo productDetailInfo) {
        JSONObject optJSONObject = productDetailInfo.infoData.optJSONObject("active_info");
        detailDataCache.put(d(productId, optJSONObject != null ? optJSONObject.optString("active_id", "") : null), productDetailInfo);
    }

    public final void c() {
        detailDataCache.clear();
        liveStatusCache.clear();
    }

    public final ECShopProductDetailInfo e(String productId, String activeId) {
        return detailDataCache.get(d(productId, activeId));
    }

    public final void g(String productId, ECShopProductDetailBuyFloatPageInfo productDetailBuyFloatPageInfo, String activeId) {
        JSONObject optJSONObject;
        if (detailDataCache.containsKey(d(productId, activeId))) {
            JSONObject infoData = productDetailBuyFloatPageInfo.getInfoData();
            ECShopProductDetailInfo e16 = e(productId, activeId);
            if (e16 != null) {
                JSONObject optJSONObject2 = e16.infoData.optJSONObject("product");
                if (optJSONObject2 != null) {
                    if (infoData.has("buy_limit") && (optJSONObject = optJSONObject2.optJSONObject(TabPreloadItem.TAB_NAME_DYNAMIC)) != null) {
                        optJSONObject.put("buy_limit", infoData.get("buy_limit"));
                    }
                    if (infoData.has("sku_infos")) {
                        optJSONObject2.put("sku_infos", infoData.get("sku_infos"));
                    }
                }
                f102363c.a(productId, e16);
            }
        }
    }

    private final String d(String productId, String activeId) {
        if (activeId == null || activeId.length() == 0) {
            return productId;
        }
        return productId + "_" + activeId;
    }

    public final void b(String shopId, f info) {
        if (info == null || !info.b()) {
            return;
        }
        liveStatusCache.put(shopId, info);
    }

    public static /* synthetic */ ECShopProductDetailInfo f(d dVar, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        return dVar.e(str, str2);
    }
}
