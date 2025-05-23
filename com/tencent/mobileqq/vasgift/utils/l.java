package com.tencent.mobileqq.vasgift.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vasgift/utils/l;", "", "", "key", "appId", "Lorg/json/JSONObject;", "toggleData", "c", "Lmqq/app/AppRuntime;", "appRuntime", "b", "a", "<init>", "()V", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f312038a = new l();

    l() {
    }

    private final String c(String key, String appId, JSONObject toggleData) {
        String str;
        if (toggleData != null) {
            str = toggleData.optString(appId);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String optString = new JSONObject(str).optString(key);
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(key)");
        return optString;
    }

    @NotNull
    public final String a(@Nullable AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.e("RechargeTipsConfig", 1, "getMarketingIconUrl, AppRuntime is null.");
            return "";
        }
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) runtimeService;
        if (!iFeatureRuntimeService.isFeatureSwitchEnable("vas_topup_panel_config", false)) {
            QLog.e("RechargeTipsConfig", 1, "getToggleConfig, toggle is disabled.");
            return "";
        }
        return c("marketCoinIcon", "0", iFeatureRuntimeService.getJSONObject("vas_topup_panel_config", ""));
    }

    @NotNull
    public final String b(@Nullable AppRuntime appRuntime, @NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (appRuntime == null) {
            QLog.e("RechargeTipsConfig", 1, "getToggleConfig, AppRuntime is null.");
            return "";
        }
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) runtimeService;
        if (!iFeatureRuntimeService.isFeatureSwitchEnable("vas_recharge_panel_config", false)) {
            QLog.e("RechargeTipsConfig", 1, "getToggleConfig, toggle is disabled.");
            return "";
        }
        String str = iFeatureRuntimeService.isEnabledWithDataSet("vas_recharge_panel_config", "").get(key);
        if (TextUtils.isEmpty(str)) {
            QLog.e("RechargeTipsConfig", 1, "getToggleConfig, toggle value is empty. key is" + key);
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
