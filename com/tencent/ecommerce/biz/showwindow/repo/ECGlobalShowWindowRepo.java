package com.tencent.ecommerce.biz.showwindow.repo;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import qi0.ECSelectProductAddWindowResponse;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/ECGlobalShowWindowRepo;", "", "Lcom/tencent/ecommerce/biz/showwindow/repo/a;", "addProductWindowRequest", "Lcom/tencent/ecommerce/base/network/api/d;", "Lqi0/a;", "a", "(Lcom/tencent/ecommerce/biz/showwindow/repo/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECGlobalShowWindowRepo {

    /* renamed from: b, reason: collision with root package name */
    public static final ECGlobalShowWindowRepo f104642b = new ECGlobalShowWindowRepo();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineDispatcher dispatcher = Dispatchers.getIO();

    ECGlobalShowWindowRepo() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ECGlobalAddProductWindowRequest eCGlobalAddProductWindowRequest, Continuation<? super ECNetworkResponse<ECSelectProductAddWindowResponse>> continuation) {
        ECGlobalShowWindowRepo$addProductWindow$1 eCGlobalShowWindowRepo$addProductWindow$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECGlobalShowWindowRepo$addProductWindow$1) {
            eCGlobalShowWindowRepo$addProductWindow$1 = (ECGlobalShowWindowRepo$addProductWindow$1) continuation;
            int i16 = eCGlobalShowWindowRepo$addProductWindow$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCGlobalShowWindowRepo$addProductWindow$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCGlobalShowWindowRepo$addProductWindow$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCGlobalShowWindowRepo$addProductWindow$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = dispatcher;
                    ECGlobalShowWindowRepo$addProductWindow$response$1 eCGlobalShowWindowRepo$addProductWindow$response$1 = new ECGlobalShowWindowRepo$addProductWindow$response$1(eCGlobalAddProductWindowRequest, null);
                    eCGlobalShowWindowRepo$addProductWindow$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCGlobalShowWindowRepo$addProductWindow$response$1, eCGlobalShowWindowRepo$addProductWindow$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    cg0.a.a("ECGlobalShowWindowRepo", "addProductWindow", "addProductWindow error, errCode: " + eCNetworkResponse.getCode() + ", errMsg: " + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse;
            }
        }
        eCGlobalShowWindowRepo$addProductWindow$1 = new ECGlobalShowWindowRepo$addProductWindow$1(this, continuation);
        Object obj2 = eCGlobalShowWindowRepo$addProductWindow$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCGlobalShowWindowRepo$addProductWindow$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
        return eCNetworkResponse;
    }
}
