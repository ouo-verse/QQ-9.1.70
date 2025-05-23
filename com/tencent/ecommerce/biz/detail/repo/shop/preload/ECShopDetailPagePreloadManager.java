package com.tencent.ecommerce.biz.detail.repo.shop.preload;

import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import com.tencent.ecommerce.biz.detail.repo.shop.a;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailInfo;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/preload/ECShopDetailPagePreloadManager;", "", "", "spuId", "", "c", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "a", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "repository", "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "detailPageIsRequestingList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopDetailPagePreloadManager {

    /* renamed from: c, reason: collision with root package name */
    public static final ECShopDetailPagePreloadManager f102383c = new ECShopDetailPagePreloadManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final IECShopProductDetailRepository repository = a.f102322a.getShopProductDetailRepository();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<String> detailPageIsRequestingList = new CopyOnWriteArrayList<>();

    ECShopDetailPagePreloadManager() {
    }

    public final void c(String spuId) {
        JSONObject jSONObject;
        if (detailPageIsRequestingList.contains(spuId)) {
            cg0.a.b("ECShopDetailPagePreloadManager", "[preloadShopProductDetails] spuId = " + spuId + " is preloading");
            return;
        }
        ECShopProductDetailInfo a16 = IECShopProductDetailRepository.a.a(repository, spuId, null, 2, null);
        if (a16 == null || (jSONObject = a16.infoData) == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject.length() > 0) {
            cg0.a.b("ECShopDetailPagePreloadManager", "[preloadShopProductDetails] spuId = " + spuId + " is preloaded");
            return;
        }
        cg0.a.b("ECShopDetailPagePreloadManager", "[preloadShopProductDetails] spuId = " + spuId);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("spu_id", spuId);
        jSONObject2.put("is_preload", 1);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new ECShopDetailPagePreloadManager$preloadShopProductDetails$1("trpc.ecom.qq_shop_detail_svr.ProductCard", "/trpc.ecom.qq_shop_detail_svr.ProductCard/GetProductDetailByBuyer", jSONObject2, spuId, null), 3, null);
    }
}
