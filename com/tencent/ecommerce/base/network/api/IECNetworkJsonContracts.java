package com.tencent.ecommerce.base.network.api;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "P", BdhLogUtil.LogTag.Tag_Req, "", "decodeResponse", "rsp", "", "([B)Ljava/lang/Object;", "encodeRequestParams", "Lorg/json/JSONObject;", "params", "(Ljava/lang/Object;)Lorg/json/JSONObject;", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECNetworkJsonContracts<P, R> {
    R decodeResponse(@NotNull byte[] rsp);

    @NotNull
    JSONObject encodeRequestParams(P params);
}
