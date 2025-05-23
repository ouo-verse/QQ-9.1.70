package com.tencent.mobileqq.zplan.avatar.impl.cache;

import com.tencent.mobileqq.zplan.api.UECacheData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ue3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/cache/UECacheIpcApiImpl;", "Lue3/c;", "", "cacheKey", "queryCache", "deleteCache", "", "Lcom/tencent/mobileqq/zplan/api/UECacheData;", "getAllCacheData", "", "sync", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class UECacheIpcApiImpl implements c {
    @Override // ue3.a
    public String deleteCache(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        return UECacheInfoManager.f331873b.deleteCache(cacheKey);
    }

    @Override // ue3.a
    public List<UECacheData> getAllCacheData() {
        return UECacheInfoManager.f331873b.getAllCacheData();
    }

    @Override // ue3.a
    public String queryCache(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        return UECacheInfoManager.f331873b.queryCache(cacheKey);
    }

    @Override // ue3.a
    public void sync() {
        UECacheInfoManager.f331873b.sync();
    }
}
