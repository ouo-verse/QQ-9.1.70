package com.tencent.ecommerce.base.config.service;

import com.tencent.ecommerce.base.config.api.IECLocalConfigKeyRegistry;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/base/config/service/a;", "Lcom/tencent/ecommerce/base/config/api/IECLocalConfigKeyRegistry;", "", "key", "", "isAccountScopedConfigKey", "isGlobalScopedConfigKey", "", "a", "Ljava/util/List;", "accountScopedConfigKeys", "b", "globalScopedConfigKeys", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class a implements IECLocalConfigKeyRegistry {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final List<String> accountScopedConfigKeys;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<String> globalScopedConfigKeys;

    /* renamed from: c, reason: collision with root package name */
    public static final a f100653c = new a();

    static {
        List<String> emptyList;
        List<String> emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        accountScopedConfigKeys = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        globalScopedConfigKeys = emptyList2;
    }

    a() {
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfigKeyRegistry
    public boolean isAccountScopedConfigKey(String key) {
        return accountScopedConfigKeys.contains(key);
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfigKeyRegistry
    public boolean isGlobalScopedConfigKey(String key) {
        return globalScopedConfigKeys.contains(key);
    }
}
