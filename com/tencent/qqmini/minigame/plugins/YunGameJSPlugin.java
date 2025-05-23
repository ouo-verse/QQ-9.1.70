package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.yungame.YunGameOptions;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@JsPlugin
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/YunGameJSPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lcom/tencent/qqmini/minigame/GameRuntime;", "c", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "initYunGame", "startYunGame", "stopYunGame", "restartYunGame", "setResolution", "sendYunGameMessage", "setKeepAlive", "<init>", "()V", "d", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class YunGameJSPlugin extends BaseJsPlugin {
    private final GameRuntime c() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (!(iMiniAppContext instanceof GameRuntime)) {
            return null;
        }
        if (iMiniAppContext != null) {
            return (GameRuntime) iMiniAppContext;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.qqmini.minigame.GameRuntime");
    }

    @JsEvent({"initYunGame"})
    public final void initYunGame(@NotNull final RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        YunGameOptions a16 = YunGameOptions.INSTANCE.a(new JSONObject(req.jsonParams));
        QMLog.i("YunGameJSPlugin", "initYunGame options:" + a16);
        if (a16.getGameInfo().getGameId() == null) {
            QMLog.e("YunGameJSPlugin", "initYunGame error,req params");
            req.fail("error gameInfo");
        } else if (c() != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.YunGameJSPlugin$initYunGame$$inlined$let$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    IMiniAppContext mMiniAppContext;
                    mMiniAppContext = ((BaseJsPlugin) YunGameJSPlugin.this).mMiniAppContext;
                    Intrinsics.checkExpressionValueIsNotNull(mMiniAppContext, "mMiniAppContext");
                    if (mMiniAppContext.getAttachActivity() == null) {
                        req.fail("error activity");
                    } else {
                        req.ok();
                    }
                }
            });
        }
    }

    @JsEvent({"restartYunGame"})
    public final void restartYunGame(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        new JSONObject(req.jsonParams);
    }

    @JsEvent({"sendYunGameMessage"})
    public final void sendYunGameMessage(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
    }

    @JsEvent({"setKeepAlive"})
    public final void setKeepAlive(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
    }

    @JsEvent({"setResolution"})
    public final void setResolution(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
    }

    @JsEvent({"startYunGame"})
    public final void startYunGame(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        QMLog.i("YunGameJSPlugin", "startYunGame");
    }

    @JsEvent({"stopYunGame"})
    public final void stopYunGame(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
    }
}
