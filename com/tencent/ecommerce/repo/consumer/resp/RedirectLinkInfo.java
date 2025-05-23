package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/RedirectLinkInfo;", "", "()V", "redirectLinkMap", "", "", "", "getRedirectLinkMap", "()Ljava/util/Map;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class RedirectLinkInfo {

    @SerializedName("redirect_link")
    private final Map<Integer, String> redirectLinkMap;

    public RedirectLinkInfo() {
        Map<Integer, String> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.redirectLinkMap = emptyMap;
    }

    public final Map<Integer, String> getRedirectLinkMap() {
        return this.redirectLinkMap;
    }
}
