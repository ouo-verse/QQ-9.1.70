package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IToggleData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J7\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u0001H\tH\u0016\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J$\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0018H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/ToggleDataImpl;", "Lcom/tencent/mobileqq/vas/api/IToggleData;", "()V", "i", "", "tag", "", "isEnable", "onGetBean", "T", "name", "clazz", "Ljava/lang/Class;", "defVal", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "onGetInt", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "onGetJsonString", "Lorg/json/JSONObject;", "onGetStringData", "onGetStringDataSet", "key", "onIsEnable", "", "isLogResult", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class ToggleDataImpl implements IToggleData {
    @Override // com.tencent.mobileqq.vas.api.IToggleData
    public void i(@NotNull String tag, @NotNull String isEnable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(isEnable, "isEnable");
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("VasToggle", "isEnable: " + tag + " result:" + isEnable);
    }

    @Override // com.tencent.mobileqq.vas.api.IToggleData
    @Nullable
    public <T> T onGetBean(@NotNull String name, @Nullable Class<T> clazz, @Nullable T defVal) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (T) VasToggle.getBean(name, clazz, defVal);
    }

    @Override // com.tencent.mobileqq.vas.api.IToggleData
    public int onGetInt(@NotNull String name, int defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return defaultValue;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026essConstant.ALL\n        )");
        int i3 = ((IFeatureRuntimeService) runtimeService).getInt(name, defaultValue);
        if (i3 != 0) {
            return i3;
        }
        return defaultValue;
    }

    @Override // com.tencent.mobileqq.vas.api.IToggleData
    @Nullable
    public JSONObject onGetJsonString(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("VasToggle", 1, "getJsonString: runtime is null");
            return null;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026essConstant.ALL\n        )");
        return ((IFeatureRuntimeService) runtimeService).getJSONObject(name, "");
    }

    @Override // com.tencent.mobileqq.vas.api.IToggleData
    @NotNull
    public String onGetStringData(@NotNull String name, @NotNull String defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String stringData = VasToggle.getStringData(name, defaultValue);
        Intrinsics.checkNotNullExpressionValue(stringData, "getStringData(name, defaultValue)");
        return stringData;
    }

    @Override // com.tencent.mobileqq.vas.api.IToggleData
    @Nullable
    public String onGetStringDataSet(@NotNull String name, @NotNull String key, @Nullable String defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(key, "key");
        return VasToggle.getStringDataSet(name, key, defaultValue);
    }

    @Override // com.tencent.mobileqq.vas.api.IToggleData
    public boolean onIsEnable(boolean isLogResult, @NotNull String name, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        return VasToggle.isEnable(name, defaultValue);
    }
}
