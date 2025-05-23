package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.webrtc.YunGameWebRtcPage;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/WebRtcJSPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lcom/tencent/qqmini/minigame/GameRuntime;", "c", "Lcom/tencent/qqmini/minigame/webrtc/YunGameWebRtcPage;", "d", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "initWebRTCEnv", "updateWebRtcRendererView", "", "operateWebRtc", "onReceiveGameMessage", "Lcom/tencent/qqmini/minigame/webrtc/YunGameWebRtcPage;", "mWebRtcPage", "<init>", "()V", "e", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class WebRtcJSPlugin extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private YunGameWebRtcPage mWebRtcPage;

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

    /* JADX INFO: Access modifiers changed from: private */
    public final YunGameWebRtcPage d() {
        IMiniAppContext mMiniAppContext = this.mMiniAppContext;
        Intrinsics.checkExpressionValueIsNotNull(mMiniAppContext, "mMiniAppContext");
        if (mMiniAppContext.getAttachActivity() != null && c() != null) {
            if (this.mWebRtcPage == null) {
                IMiniAppContext mMiniAppContext2 = this.mMiniAppContext;
                Intrinsics.checkExpressionValueIsNotNull(mMiniAppContext2, "mMiniAppContext");
                Activity attachActivity = mMiniAppContext2.getAttachActivity();
                Intrinsics.checkExpressionValueIsNotNull(attachActivity, "mMiniAppContext.attachedActivity");
                MiniAppInfo mMiniAppInfo = this.mMiniAppInfo;
                Intrinsics.checkExpressionValueIsNotNull(mMiniAppInfo, "mMiniAppInfo");
                GameRuntime c16 = c();
                if (c16 == null) {
                    Intrinsics.throwNpe();
                }
                this.mWebRtcPage = new YunGameWebRtcPage(attachActivity, mMiniAppInfo, c16);
            }
            YunGameWebRtcPage yunGameWebRtcPage = this.mWebRtcPage;
            if (yunGameWebRtcPage == null) {
                Intrinsics.throwNpe();
            }
            return yunGameWebRtcPage;
        }
        return null;
    }

    @JsEvent({"initWebRTCEnv"})
    public final void initWebRTCEnv(@NotNull final RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        GameRuntime c16 = c();
        YunGameWebRtcPage d16 = d();
        if (c16 != null && d16 != null) {
            QMLog.i("YunGame_WebRtcJSPlugin", "initWebRTCEnv");
            GameRuntime c17 = c();
            if (c17 != null) {
                c17.attachYunGamePage(d16);
            }
            d16.t(new Function3<Boolean, JSONObject, String, Unit>() { // from class: com.tencent.qqmini.minigame.plugins.WebRtcJSPlugin$initWebRTCEnv$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, JSONObject jSONObject, String str) {
                    invoke(bool.booleanValue(), jSONObject, str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull JSONObject data, @NotNull String msg2) {
                    Intrinsics.checkParameterIsNotNull(data, "data");
                    Intrinsics.checkParameterIsNotNull(msg2, "msg");
                    QMLog.i("YunGame_WebRtcJSPlugin", "initWebRtcEnv isSuccess:" + z16 + " data:" + data + " msg:" + msg2);
                    if (z16) {
                        RequestEvent.this.ok(data);
                    } else {
                        RequestEvent.this.fail(msg2);
                    }
                }
            });
            return;
        }
        req.fail("runtime is null");
    }

    @JsEvent({"receiveRTCGameMessage"})
    public final void onReceiveGameMessage(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        YunGameWebRtcPage d16 = d();
        if (d16 != null) {
            d16.x(req);
        }
    }

    @JsEvent({"operateWebRTC"})
    @Nullable
    public final String operateWebRtc(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        YunGameWebRtcPage d16 = d();
        if (d16 != null) {
            return d16.y(req);
        }
        return null;
    }

    @JsEvent({com.tencent.luggage.wxa.jh.d.NAME})
    public final void updateWebRtcRendererView(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        try {
            QMLog.i("YunGame_WebRtcJSPlugin", com.tencent.luggage.wxa.jh.d.NAME);
            final JSONObject jSONObject = new JSONObject(req.jsonParams);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.WebRtcJSPlugin$updateWebRtcRendererView$1
                @Override // java.lang.Runnable
                public final void run() {
                    YunGameWebRtcPage d16;
                    d16 = WebRtcJSPlugin.this.d();
                    if (d16 != null) {
                        d16.C(jSONObject);
                    }
                }
            });
        } catch (JSONException e16) {
            QMLog.e("YunGame_WebRtcJSPlugin", String.valueOf(e16));
        }
    }
}
