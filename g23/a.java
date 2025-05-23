package g23;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lg23/a;", "", "", "key", "appId", "Lorg/json/JSONObject;", "toggleData", "b", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f401118a = new a();

    a() {
    }

    private final String b(String key, String appId, JSONObject toggleData) {
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
    public final String a(@NotNull String key, @NotNull String appId) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(appId, "appId");
        AppInterface a16 = com.tencent.mobileqq.vas.pay.api.impl.helper.a.a();
        if (a16 == null) {
            QLog.e("RechargeTipsConfig", 1, "getToggleConfig, AppInterface is null.");
            return "";
        }
        IRuntimeService runtimeService = a16.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026ava, ProcessConstant.ALL)");
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) runtimeService;
        if (!iFeatureRuntimeService.isFeatureSwitchEnable("vas_topup_panel_config", false)) {
            QLog.e("RechargeTipsConfig", 1, "getToggleConfig, toggle is disabled.");
            return "";
        }
        JSONObject jSONObject = iFeatureRuntimeService.getJSONObject("vas_topup_panel_config", "");
        String b16 = b(key, appId, jSONObject);
        if (TextUtils.isEmpty(b16)) {
            b16 = b(key, "0", jSONObject);
        }
        if (TextUtils.isEmpty(b16)) {
            QLog.e("RechargeTipsConfig", 1, "getToggleConfig, toggle value is empty. key is" + key);
        }
        return b16;
    }
}
