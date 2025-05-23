package com.tencent.qqmini.minigame.webrtc;

import com.tencent.luggage.wxa.q2.e;
import com.tencent.qqmini.minigame.dynamic.client.b;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015JI\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016JI\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqmini/minigame/webrtc/a;", "Lcom/tencent/qqmini/minigame/dynamic/client/b;", "", "method", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/qqmini/minigame/dynamic/client/ClientCallback;", "callback", "call", "Lcom/tencent/qqmini/minigame/webrtc/YunGameWebRtcPage;", "a", "Lcom/tencent/qqmini/minigame/webrtc/YunGameWebRtcPage;", "getPage", "()Lcom/tencent/qqmini/minigame/webrtc/YunGameWebRtcPage;", "page", "<init>", "(Lcom/tencent/qqmini/minigame/webrtc/YunGameWebRtcPage;)V", "b", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a implements com.tencent.qqmini.minigame.dynamic.client.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final YunGameWebRtcPage page;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "isSuccess", "", "result", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "onReceiveResult", "com/tencent/qqmini/minigame/webrtc/WebRtcPluginClient$call$1$1"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    static final class b implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f346861a;

        b(Function1 function1) {
            this.f346861a = function1;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public final void onReceiveResult(boolean z16, JSONObject jSONObject) {
            if (z16 && jSONObject != null) {
                Function1 function1 = this.f346861a;
                if (function1 != null) {
                    return;
                }
                return;
            }
            Function1 function12 = this.f346861a;
            if (function12 != null) {
            }
        }
    }

    public a(@NotNull YunGameWebRtcPage page) {
        Intrinsics.checkParameterIsNotNull(page, "page");
        this.page = page;
    }

    @Override // com.tencent.qqmini.minigame.dynamic.client.b
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -75310397) {
            if (hashCode == 1071520468 && method.equals("showVAFloatDownloadTips")) {
                this.page.B();
                return Unit.INSTANCE;
            }
        } else if (method.equals(e.NAME)) {
            QMLog.i("YunGame_WebRtcPluginClient", "call client, method:" + method + " params:" + params);
            QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
            if (qQCustomizedProxy != null) {
                qQCustomizedProxy.getOAID(true, new b(callback));
                return Unit.INSTANCE;
            }
            if (callback != null) {
                return callback.invoke(new JSONObject().put("errCode", -1));
            }
            return null;
        }
        return b.a.a(this, method, params, callback);
    }

    @Override // com.tencent.qqmini.minigame.dynamic.client.b
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        if (params == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(params);
        int hashCode = method.hashCode();
        if (hashCode != -562582687) {
            if (hashCode != -406984094) {
                if (hashCode == -310140146 && method.equals("onRTCNativeMessage")) {
                    if (!Intrinsics.areEqual(jSONObject.optString("method"), "createDataChannel-onmessage")) {
                        QMLog.i("YunGame_WebRtcPluginClient", "call client, method:" + method + " params:" + params);
                    }
                    this.page.z("onRTCNativeMessage", jSONObject);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("onRTCOtherNativeMessage")) {
                QMLog.i("YunGame_WebRtcPluginClient", "call client, method:" + method + " params:" + params);
                this.page.z("onRTCOtherNativeMessage", jSONObject);
                return Unit.INSTANCE;
            }
        } else if (method.equals("onInitWebrtcCallback")) {
            QMLog.i("YunGame_WebRtcPluginClient", "call client, method:" + method + " params:" + params);
            YunGameWebRtcPage yunGameWebRtcPage = this.page;
            int optInt = jSONObject.optInt("callbackId");
            int optInt2 = jSONObject.optInt("errCode");
            String optString = jSONObject.optString("errMsg");
            Intrinsics.checkExpressionValueIsNotNull(optString, "data.optString(ERROR_MSG)");
            yunGameWebRtcPage.A(optInt, optInt2, optString);
            return Unit.INSTANCE;
        }
        return b.a.b(this, method, params, callback);
    }
}
