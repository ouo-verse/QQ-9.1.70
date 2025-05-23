package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqmini/sdk/plugins/f;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "", "errCode", "Lorg/json/JSONObject;", "c", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "getLatestUserKey", "<init>", "()V", "d", "a", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class f extends BaseJsPlugin {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "isSuccess", "", "result", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "onReceiveResult"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    static final class b implements AsyncResult {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348305b;

        b(RequestEvent requestEvent) {
            this.f348305b = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public final void onReceiveResult(boolean z16, JSONObject jSONObject) {
            f fVar = f.this;
            if (z16 && jSONObject != null) {
                QMLog.i("UserCryptoManagerJsPlug", "requestUserKey success,result:" + jSONObject);
                this.f348305b.ok(jSONObject);
                return;
            }
            QMLog.e("UserCryptoManagerJsPlug", "requestUserKey fail,errCod:10001");
            this.f348305b.fail(fVar.c(10001), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject c(int errCode) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errCode", errCode);
        return jSONObject;
    }

    @JsEvent({"getLatestUserKey"})
    public final void getLatestUserKey(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getLatestUserKey(this.mMiniAppInfo.appId, new b(req));
    }
}
