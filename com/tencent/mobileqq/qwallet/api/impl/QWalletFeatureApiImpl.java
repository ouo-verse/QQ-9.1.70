package com.tencent.mobileqq.qwallet.api.impl;

import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/impl/QWalletFeatureApiImpl;", "Lcom/tencent/mobileqq/qwallet/api/IQWalletFeatureApi;", "", "init", "", "name", "", "isFeatureSwitch", "default", "Lorg/json/JSONObject;", "getJSONObject", "Lmqq/app/MobileQQ;", "getMobileQQ", "()Lmqq/app/MobileQQ;", "mobileQQ", "Lmqq/app/AppRuntime;", "getApp", "()Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/qqfeatureswitch/IFeatureRuntimeService;", "getFeatureService", "()Lcom/tencent/mobileqq/qqfeatureswitch/IFeatureRuntimeService;", "featureService", "<init>", "()V", "Companion", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletFeatureApiImpl implements IQWalletFeatureApi {

    @NotNull
    private static final String TAG = "QWalletFeatureApi";

    private final AppRuntime getApp() {
        AppRuntime waitAppRuntime = getMobileQQ().waitAppRuntime(null);
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "mobileQQ.waitAppRuntime(null)");
        return waitAppRuntime;
    }

    private final IFeatureRuntimeService getFeatureService() {
        IRuntimeService runtimeService = getApp().getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026ava, ProcessConstant.ALL)");
        return (IFeatureRuntimeService) runtimeService;
    }

    private final MobileQQ getMobileQQ() {
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        return sMobileQQ;
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi
    @Nullable
    public JSONObject getJSONObject(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!isFeatureSwitch(name)) {
            return null;
        }
        return getFeatureService().getJSONObject(name, null);
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi
    public void init() {
        getFeatureService().initSdk();
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi
    public boolean isFeatureSwitch(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return isFeatureSwitch(name, false);
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi
    public boolean isFeatureSwitch(@NotNull String name, boolean r36) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getFeatureService().isFeatureSwitchEnable(name, r36);
    }
}
