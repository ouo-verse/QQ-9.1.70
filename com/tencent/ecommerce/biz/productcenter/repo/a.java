package com.tencent.ecommerce.biz.productcenter.repo;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.showwindow.repo.ECGlobalAddProductWindowRequest;
import com.tencent.ecommerce.biz.showwindow.repo.ECGlobalShowWindowRepo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/repo/a;", "Lcom/tencent/ecommerce/biz/productcenter/repo/IECSelectProductDefaultRepository;", "Lcom/tencent/ecommerce/biz/showwindow/repo/a;", "addProductWindowRequest", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lcom/tencent/ecommerce/base/network/api/d;", "Lqi0/a;", "addProductWindow", "(Lcom/tencent/ecommerce/biz/showwindow/repo/a;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a implements IECSelectProductDefaultRepository {

    /* renamed from: a, reason: collision with root package name */
    public static final a f103921a = new a();

    a() {
    }

    @Override // com.tencent.ecommerce.biz.productcenter.repo.IECSelectProductDefaultRepository
    public Object addProductWindow(ECGlobalAddProductWindowRequest eCGlobalAddProductWindowRequest, CoroutineDispatcher coroutineDispatcher, Continuation<? super ECNetworkResponse<qi0.a>> continuation) {
        return ECGlobalShowWindowRepo.f104642b.a(eCGlobalAddProductWindowRequest, continuation);
    }
}
