package com.tencent.ecommerce.base.network.service;

import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "I", "O", "", "reqModel", "respModel", "", "onSuccess", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "(Ljava/lang/Object;Lcom/tencent/ecommerce/base/network/api/e;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface IECNetworkCallback<I, O> {
    void onError(I reqModel, ECRemoteResponse errorResponse);

    void onSuccess(I reqModel, O respModel);
}
