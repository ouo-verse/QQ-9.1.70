package com.tencent.ecommerce.repo.consumer.resp;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/ExtendInfo;", "", "()V", "ext", "", "", "getExt", "()Ljava/util/Map;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ExtendInfo {
    private final Map<String, String> ext;

    public ExtendInfo() {
        Map<String, String> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.ext = emptyMap;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }
}
