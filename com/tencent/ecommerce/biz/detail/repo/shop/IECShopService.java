package com.tencent.ecommerce.biz.detail.repo.shop;

import com.tencent.ecommerce.repo.db.ECommerceDatabase;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopService;", "", "database", "Lcom/tencent/ecommerce/repo/db/ECommerceDatabase;", "getDatabase", "()Lcom/tencent/ecommerce/repo/db/ECommerceDatabase;", "shopProductDetailRepository", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "getShopProductDetailRepository", "()Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECShopService {
    ECommerceDatabase getDatabase();

    IECShopProductDetailRepository getShopProductDetailRepository();
}
