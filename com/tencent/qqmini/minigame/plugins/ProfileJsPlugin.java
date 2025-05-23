package com.tencent.qqmini.minigame.plugins;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import com.tencent.qqmini.minigame.action.DebugSocketAction;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(lazyLoad = false)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/ProfileJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "()V", "jsService", "Lcom/tencent/qqmini/sdk/launcher/core/IJsService;", "observer", "Lcom/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter$RuntimeStateObserver;", "covertProfileToIdeData", "", "v8Message", "notifyProfileCmd", "", "cmd", "id", "", "onCreate", "miniAppContext", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, ProfileJsPlugin.API_REGISTER_PROFILE, "req", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", ProfileJsPlugin.API_TIME_PERFORMANCE_RESULT, "Companion", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class ProfileJsPlugin extends BaseJsPlugin {
    private static final String API_REGISTER_PROFILE = "registerProfile";
    private static final String API_TIME_PERFORMANCE_RESULT = "timePerformanceResult";
    private static final String EVENT_PROFILE_CMD = "onProfileCmd";
    private static final String TAG = "ProfileJsPlugin";
    private IJsService jsService;
    private AppRuntimeEventCenter.RuntimeStateObserver observer;

    private final String covertProfileToIdeData(String v8Message) {
        return "{\"debug_message\":[{\"seq\":1,\"category\":\"performance\",\"data\":" + v8Message + "}]}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyProfileCmd(String cmd, int id5) {
        if (this.jsService != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", cmd);
            jSONObject.put("id", id5);
            GameLog.getInstance().w(TAG, "notifyProfileCmd cmd:" + cmd + ", id:" + id5);
            IJsService iJsService = this.jsService;
            if (iJsService == null) {
                Intrinsics.throwNpe();
            }
            iJsService.evaluateSubscribeJS(EVENT_PROFILE_CMD, jSONObject.toString(), -1);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(@Nullable IMiniAppContext miniAppContext) {
        super.onCreate(miniAppContext);
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
        if (queryAppRunTimeLoader != null) {
            Intrinsics.checkExpressionValueIsNotNull(queryAppRunTimeLoader, "AppRuntimeLoaderManager.\u2026r(mMiniAppInfo) ?: return");
            AppRuntimeEventCenter.RuntimeStateObserver runtimeStateObserver = new AppRuntimeEventCenter.RuntimeStateObserver() { // from class: com.tencent.qqmini.minigame.plugins.ProfileJsPlugin$onCreate$1
                @Override // com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver
                public void onStateChange(@Nullable AppRuntimeEventCenter.MiniAppStateMessage msg2) {
                    Integer num;
                    if (msg2 != null) {
                        num = Integer.valueOf(msg2.what);
                    } else {
                        num = null;
                    }
                    if (num != null && num.intValue() == 2056) {
                        ProfileJsPlugin profileJsPlugin = ProfileJsPlugin.this;
                        Object obj = msg2.obj;
                        if (obj != null) {
                            profileJsPlugin.notifyProfileCmd("start", ((Integer) obj).intValue());
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                    }
                    if (num != null && num.intValue() == 2057) {
                        ProfileJsPlugin profileJsPlugin2 = ProfileJsPlugin.this;
                        Object obj2 = msg2.obj;
                        if (obj2 != null) {
                            profileJsPlugin2.notifyProfileCmd("end", ((Integer) obj2).intValue());
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
            };
            this.observer = runtimeStateObserver;
            queryAppRunTimeLoader.addRuntimeStateObserver(runtimeStateObserver);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
        AppRuntimeEventCenter.RuntimeStateObserver runtimeStateObserver = this.observer;
        if (runtimeStateObserver != null && queryAppRunTimeLoader != null) {
            queryAppRunTimeLoader.removeRuntimeStateObserver(runtimeStateObserver);
        }
    }

    @JsEvent({API_REGISTER_PROFILE})
    public final void registerProfile(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        this.jsService = req.jsService;
    }

    @JsEvent({API_TIME_PERFORMANCE_RESULT})
    public final void timePerformanceResult(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        try {
            JSONObject jSONObject = new JSONObject(req.jsonParams);
            String optString = jSONObject.optString("result", "");
            int optInt = jSONObject.optInt("id", -1);
            if (!TextUtils.isEmpty(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", optInt);
                jSONObject2.put("result", jSONArray);
                String jSONObject3 = jSONObject2.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "ret.toString()");
                DebugSocketAction.obtain(this.mMiniAppContext).sendQQDebugMethodMsg(DebugUtils.Body.DEBUG_MESSAGE_CLIENT, covertProfileToIdeData(jSONObject3));
            }
        } catch (JSONException e16) {
            QMLog.e(TAG, "qq API_TIME_PERFORMANCE_REAULT:", e16);
        }
    }
}
