package com.tencent.ecommerce.base.config.service;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.config.api.IECRemoteConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0004\b\n\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/base/config/service/b;", "", "T", "", "configId", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "(ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "b", "Lcom/tencent/ecommerce/base/config/api/IECRemoteConfig;", "Lcom/tencent/ecommerce/base/config/api/IECRemoteConfig;", "remoteConfig", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f100655b = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final IECRemoteConfig remoteConfig = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRemoteConfig();

    b() {
    }

    @Deprecated(message = "\u795e\u706f\u914d\u7f6e\u5373\u5c06\u4e0b\u67b6,\u540e\u7eed\u65b0\u7684\u914d\u7f6e\u5efa\u8bae\u4f7f\u7528getUnitedConfig")
    public final <T> T a(int configId, String key, T defaultValue) {
        return (T) remoteConfig.getConfig(configId, key, defaultValue);
    }

    public final <T> T b(int configId, String key, T defaultValue) {
        return (T) remoteConfig.getUnitedConfig(configId, key, defaultValue);
    }
}
