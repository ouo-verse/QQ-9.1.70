package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.action.RestartAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/GameNavigationJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "onInterceptJsEvent", "requestEvent", "", "restartMiniProgram", "<init>", "()V", "d", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class GameNavigationJsPlugin extends BaseJsPlugin {
    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(@Nullable RequestEvent req) {
        if (!this.mIsMiniGame) {
            return true;
        }
        return super.onInterceptJsEvent(req);
    }

    @JsEvent({"restartMiniProgram"})
    public final void restartMiniProgram(@NotNull final RequestEvent requestEvent) {
        Intrinsics.checkParameterIsNotNull(requestEvent, "requestEvent");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.GameNavigationJsPlugin$restartMiniProgram$1
            @Override // java.lang.Runnable
            public final void run() {
                String str;
                IMiniAppContext iMiniAppContext;
                try {
                    str = new JSONObject(requestEvent.jsonParams).optString("path");
                } catch (JSONException e16) {
                    QMLog.e("GameNavigationJsPlugin", "restartMiniProgram: parse param failed.", e16);
                    str = null;
                }
                iMiniAppContext = ((BaseJsPlugin) GameNavigationJsPlugin.this).mMiniAppContext;
                if (RestartAction.restart(iMiniAppContext, str)) {
                    requestEvent.ok();
                } else {
                    requestEvent.fail();
                }
            }
        });
    }
}
