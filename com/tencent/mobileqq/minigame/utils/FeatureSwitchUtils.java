package com.tencent.mobileqq.minigame.utils;

import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004J\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/minigame/utils/FeatureSwitchUtils;", "", "()V", "TAG", "", "getToggleJson", "Lorg/json/JSONObject;", "toggleName", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getToggleParams", "", "isFeatureSwitchEnable", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class FeatureSwitchUtils {
    public static final FeatureSwitchUtils INSTANCE = new FeatureSwitchUtils();
    private static final String TAG = "FeatureSwitchUtils";

    FeatureSwitchUtils() {
    }

    public final JSONObject getToggleJson(String toggleName, String defaultValue) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ\n            .p\u2026ava, ProcessConstant.ALL)");
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) runtimeService;
        if (iFeatureRuntimeService.isFeatureSwitchEnable(toggleName, false)) {
            return iFeatureRuntimeService.getJSONObject(toggleName, defaultValue);
        }
        return null;
    }

    public final Map<String, String> getToggleParams(String toggleName) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ava, ProcessConstant.ALL)");
        return ((IFeatureRuntimeService) runtimeService).isEnabledWithDataSet(toggleName, "");
    }

    public final boolean isFeatureSwitchEnable(String toggleName, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean isFeatureSwitchEnable = peekAppRuntime != null ? ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(toggleName, defaultValue) : false;
        QLog.d(TAG, 2, "[" + toggleName + "] " + isFeatureSwitchEnable);
        return isFeatureSwitchEnable;
    }

    public static /* synthetic */ JSONObject getToggleJson$default(FeatureSwitchUtils featureSwitchUtils, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        return featureSwitchUtils.getToggleJson(str, str2);
    }
}
