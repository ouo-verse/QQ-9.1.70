package com.tencent.gamecenter.wadl.api.impl;

import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/gamecenter/wadl/api/impl/QQGameSwitchApiImpl;", "Lcom/tencent/gamecenter/wadl/api/IQQGameSwitchApi;", "()V", "getFeatureService", "Lcom/tencent/mobileqq/qqfeatureswitch/IFeatureRuntimeService;", "getJSONObject", "Lorg/json/JSONObject;", "name", "", "init", "", "isFeatureSwitch", "", "default", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class QQGameSwitchApiImpl implements IQQGameSwitchApi {
    private final IFeatureRuntimeService getFeatureService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        }
        return null;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameSwitchApi
    @Nullable
    public JSONObject getJSONObject(@NotNull String name) {
        IFeatureRuntimeService featureService;
        Intrinsics.checkNotNullParameter(name, "name");
        if (!isFeatureSwitch(name) || (featureService = getFeatureService()) == null) {
            return null;
        }
        return featureService.getJSONObject(name, null);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameSwitchApi
    public void init() {
        IFeatureRuntimeService featureService = getFeatureService();
        if (featureService != null) {
            featureService.initSdk();
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameSwitchApi
    public boolean isFeatureSwitch(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return isFeatureSwitch(name, false);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameSwitchApi
    public boolean isFeatureSwitch(@NotNull String name, boolean r36) {
        Intrinsics.checkNotNullParameter(name, "name");
        init();
        IFeatureRuntimeService featureService = getFeatureService();
        if (featureService != null) {
            return featureService.isFeatureSwitchEnable(name, r36);
        }
        return false;
    }
}
