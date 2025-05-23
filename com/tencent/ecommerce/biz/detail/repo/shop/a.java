package com.tencent.ecommerce.biz.detail.repo.shop;

import com.tencent.ecommerce.repo.db.ECommerceDatabase;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/a;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopService;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "getShopProductDetailRepository", "()Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "shopProductDetailRepository", "Lcom/tencent/ecommerce/repo/db/ECommerceDatabase;", "getDatabase", "()Lcom/tencent/ecommerce/repo/db/ECommerceDatabase;", "database", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a implements IECShopService {

    /* renamed from: a, reason: collision with root package name */
    public static final a f102322a = new a();

    a() {
    }

    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopService
    public ECommerceDatabase getDatabase() {
        return ECommerceDatabase.INSTANCE.a(wg0.a.a());
    }

    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopService
    public IECShopProductDetailRepository getShopProductDetailRepository() {
        return ECShopProductDetailRepository.f102321d;
    }
}
