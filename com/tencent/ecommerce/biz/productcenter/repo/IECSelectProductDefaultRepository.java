package com.tencent.ecommerce.biz.productcenter.repo;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.showwindow.repo.ECGlobalAddProductWindowRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import qi0.ECSelectProductAddWindowResponse;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/repo/IECSelectProductDefaultRepository;", "", "Lcom/tencent/ecommerce/biz/showwindow/repo/a;", "addProductWindowRequest", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lcom/tencent/ecommerce/base/network/api/d;", "Lqi0/a;", "addProductWindow", "(Lcom/tencent/ecommerce/biz/showwindow/repo/a;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECSelectProductDefaultRepository {
    Object addProductWindow(ECGlobalAddProductWindowRequest eCGlobalAddProductWindowRequest, CoroutineDispatcher coroutineDispatcher, Continuation<? super ECNetworkResponse<ECSelectProductAddWindowResponse>> continuation);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ Object a(IECSelectProductDefaultRepository iECSelectProductDefaultRepository, ECGlobalAddProductWindowRequest eCGlobalAddProductWindowRequest, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    coroutineDispatcher = Dispatchers.getIO();
                }
                return iECSelectProductDefaultRepository.addProductWindow(eCGlobalAddProductWindowRequest, coroutineDispatcher, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addProductWindow");
        }
    }
}
