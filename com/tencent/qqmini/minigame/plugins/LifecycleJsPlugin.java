package com.tencent.qqmini.minigame.plugins;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@JsPlugin(lazyLoad = false)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/LifecycleJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "()V", "lifeCycleMap", "Ljava/util/HashMap;", "", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "Lkotlin/collections/HashMap;", "observer", "Lcom/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter$RuntimeStateObserver;", "bindBackgroundListener", "req", "bindForegroundListener", "bindFun", "bindStopListener", "onCreate", "", "miniAppContext", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Companion", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class LifecycleJsPlugin extends BaseJsPlugin {
    private static final String TAG = "LifecycleJsPlugin";
    private final HashMap<String, RequestEvent> lifeCycleMap = new HashMap<>();
    private AppRuntimeEventCenter.RuntimeStateObserver observer;

    private final String bindFun(RequestEvent req) {
        if (!this.lifeCycleMap.containsKey(req.event)) {
            HashMap<String, RequestEvent> hashMap = this.lifeCycleMap;
            String str = req.event;
            Intrinsics.checkExpressionValueIsNotNull(str, "req.event");
            hashMap.put(str, req);
            return null;
        }
        return null;
    }

    @JsEvent({"onAppEnterBackground"})
    @Nullable
    public final String bindBackgroundListener(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        return bindFun(req);
    }

    @JsEvent({"onAppEnterForeground"})
    @Nullable
    public final String bindForegroundListener(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        return bindFun(req);
    }

    @JsEvent({GameInfoManager.GAME_STOP})
    @Nullable
    public final String bindStopListener(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        return bindFun(req);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(@Nullable final IMiniAppContext miniAppContext) {
        super.onCreate(miniAppContext);
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
        if (queryAppRunTimeLoader != null) {
            Intrinsics.checkExpressionValueIsNotNull(queryAppRunTimeLoader, "AppRuntimeLoaderManager.\u2026r(mMiniAppInfo) ?: return");
            AppRuntimeEventCenter.RuntimeStateObserver runtimeStateObserver = new AppRuntimeEventCenter.RuntimeStateObserver() { // from class: com.tencent.qqmini.minigame.plugins.LifecycleJsPlugin$onCreate$1
                @Override // com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver
                public void onStateChange(@Nullable AppRuntimeEventCenter.MiniAppStateMessage msg2) {
                    Integer num;
                    HashMap hashMap;
                    IJsService iJsService;
                    HashMap hashMap2;
                    IJsService iJsService2;
                    HashMap hashMap3;
                    IJsService iJsService3;
                    JSONObject onShowParam;
                    String str = null;
                    if (msg2 != null) {
                        num = Integer.valueOf(msg2.what);
                    } else {
                        num = null;
                    }
                    if (num != null && num.intValue() == 2051) {
                        hashMap3 = LifecycleJsPlugin.this.lifeCycleMap;
                        RequestEvent requestEvent = (RequestEvent) hashMap3.get("onAppEnterForeground");
                        IMiniAppContext iMiniAppContext = miniAppContext;
                        if (iMiniAppContext instanceof GameRuntime) {
                            GameInfoManager gameInfoManager = ((GameRuntime) iMiniAppContext).getGameInfoManager();
                            if (gameInfoManager != null && (onShowParam = gameInfoManager.getOnShowParam()) != null) {
                                str = onShowParam.toString();
                            }
                            if (requestEvent != null && (iJsService3 = requestEvent.jsService) != null) {
                                iJsService3.evaluateSubscribeJS("onAppEnterForeground", str, 0);
                            }
                            GameLog.getInstance().w("LifecycleJsPlugin", "--onShow--onAppEnterForeground, params:" + str);
                            return;
                        }
                        return;
                    }
                    if (num != null && num.intValue() == 2052) {
                        hashMap2 = LifecycleJsPlugin.this.lifeCycleMap;
                        RequestEvent requestEvent2 = (RequestEvent) hashMap2.get("onAppEnterBackground");
                        if (requestEvent2 != null && (iJsService2 = requestEvent2.jsService) != null) {
                            iJsService2.evaluateSubscribeJS("onAppEnterBackground", "", 0);
                        }
                        GameLog.getInstance().w("LifecycleJsPlugin", "--onHide--onAppEnterBackground");
                        return;
                    }
                    if (num != null && num.intValue() == 2053) {
                        GameLog.getInstance().i("LifecycleJsPlugin", GameInfoManager.GAME_STOP);
                        hashMap = LifecycleJsPlugin.this.lifeCycleMap;
                        RequestEvent requestEvent3 = (RequestEvent) hashMap.get(GameInfoManager.GAME_STOP);
                        if (requestEvent3 != null && (iJsService = requestEvent3.jsService) != null) {
                            iJsService.evaluateSubscribeJS(GameInfoManager.GAME_STOP, "", 0);
                        }
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
}
