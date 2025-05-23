package com.tencent.mobileqq.qqecommerce.biz.config.api.impl;

import com.tencent.mobileqq.qqecommerce.biz.config.api.IECUnitedConfigApi;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import re2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/config/api/impl/ECUnitedConfigApiImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/config/api/IECUnitedConfigApi;", "()V", "getString", "", "configId", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ECUnitedConfigApiImpl implements IECUnitedConfigApi {
    @Override // com.tencent.mobileqq.qqecommerce.biz.config.api.IECUnitedConfigApi
    public String getString(String configId, String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return b.f431163a.e(configId, key, defaultValue);
    }
}
