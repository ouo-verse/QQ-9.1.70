package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.api.IUniteVasRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/UniteVasResImpl;", "Lcom/tencent/mobileqq/vas/api/IUniteVasRes;", "()V", "getResourcePath", "", "key", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class UniteVasResImpl implements IUniteVasRes {
    @Override // com.tencent.mobileqq.vas.api.IUniteVasRes
    @NotNull
    public String getResourcePath(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String resourcePath = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getResourcePath(key);
        if (resourcePath == null) {
            return "";
        }
        return resourcePath;
    }
}
