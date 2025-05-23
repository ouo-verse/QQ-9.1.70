package com.tencent.ecommerce.base.network.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/base/network/api/b;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "Lorg/json/JSONObject;", "params", "b", "", "rsp", "a", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b implements IECNetworkJsonContracts<JSONObject, JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f100803a = new b();

    b() {
    }

    @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject decodeResponse(@NotNull byte[] rsp) {
        return c.c(rsp);
    }

    @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject encodeRequestParams(@NotNull JSONObject params) {
        return params;
    }
}
