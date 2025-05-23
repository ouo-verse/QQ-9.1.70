package com.tencent.ecommerce.biz.detail.repo.shop;

import com.tencent.ecommerce.biz.detail.ProductCommentSortType;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailInfo;
import com.tencent.ecommerce.biz.detail.repo.shop.data.b;
import com.tencent.ecommerce.biz.detail.repo.shop.data.f;
import com.tencent.ecommerce.biz.detail.repo.shop.data.g;
import com.tencent.ecommerce.biz.detail.repo.shop.data.j;
import com.tencent.ecommerce.biz.shophome.repo.ECShareInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineDispatcher;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&J-\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0010J)\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ=\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#J1\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u001b\u001a\u00020\u00022\b\b\u0001\u0010$\u001a\u00020\u001c2\b\b\u0002\u0010%\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J%\u0010+\u001a\u0004\u0018\u00010\n2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010\u0015J#\u0010-\u001a\u00020,2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "", "", "getShopDetailCacheCommentCookie", "productId", "extKeyString", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "getShopDetailCacheData", "service", "method", "Lorg/json/JSONObject;", "params", "getShopProductDetailData", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/g;", "getShopProductDetailRelatedData", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/j;", "getSkuStockInfoData", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/b;", "updateSkuInfoDataToCache", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "getShopLiveStatus", "(Lorg/json/JSONObject;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "spuId", "", "shareAction", "appId", "arkViewName", "version", "Lcom/tencent/ecommerce/biz/shophome/repo/b;", "getShopProductShareInfo", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sortType", "cookie", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/a;", "getShopProductCommentData", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shopId", "brandId", "getBrandQuaLinks", "Lxh0/a;", "checkApplySampleQualified", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECShopProductDetailRepository {
    Object checkApplySampleQualified(String str, String str2, Continuation<? super xh0.a> continuation);

    Object getBrandQuaLinks(String str, String str2, Continuation<? super JSONObject> continuation);

    String getShopDetailCacheCommentCookie();

    ECShopProductDetailInfo getShopDetailCacheData(String productId, String extKeyString);

    Object getShopLiveStatus(JSONObject jSONObject, CoroutineDispatcher coroutineDispatcher, Continuation<? super f> continuation);

    Object getShopProductCommentData(String str, @ProductCommentSortType int i3, String str2, Continuation<? super com.tencent.ecommerce.biz.detail.repo.shop.data.a> continuation);

    Object getShopProductDetailData(String str, String str2, JSONObject jSONObject, Continuation<? super ECShopProductDetailInfo> continuation);

    Object getShopProductDetailRelatedData(JSONObject jSONObject, Continuation<? super g> continuation);

    Object getShopProductShareInfo(String str, int i3, String str2, String str3, String str4, Continuation<? super ECShareInfo> continuation);

    Object getSkuStockInfoData(JSONObject jSONObject, Continuation<? super j> continuation);

    Object updateSkuInfoDataToCache(String str, String str2, Continuation<? super b> continuation);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ ECShopProductDetailInfo a(IECShopProductDetailRepository iECShopProductDetailRepository, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str2 = "";
                }
                return iECShopProductDetailRepository.getShopDetailCacheData(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShopDetailCacheData");
        }
    }
}
