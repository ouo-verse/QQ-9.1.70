package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.api.IUnitedData;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/UnitedDataImpl;", "Lcom/tencent/mobileqq/vas/api/IUnitedData;", "()V", "isSwitchOn", "", "name", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "loadRawConfig", "", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class UnitedDataImpl implements IUnitedData {
    @Override // com.tencent.mobileqq.vas.api.IUnitedData
    public boolean isSwitchOn(@NotNull String name, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(name, defaultValue);
    }

    @Override // com.tencent.mobileqq.vas.api.IUnitedData
    @NotNull
    public byte[] loadRawConfig(@NotNull String name, @NotNull byte[] defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(name, defaultValue);
    }
}
