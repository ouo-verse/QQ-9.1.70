package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/d;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "subscribePublicAccount", "<init>", "()V", "d", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class d extends BaseJsPlugin {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "isSuccess", "", "result", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "onReceiveResult"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    static final class b implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f346649a;

        b(RequestEvent requestEvent) {
            this.f346649a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public final void onReceiveResult(boolean z16, JSONObject jSONObject) {
            QMLog.i("GameSubscribeJsPlugin", "subscribePublicAccount: request done, isSuccess=" + z16 + ", result=" + jSONObject);
            if (z16) {
                this.f346649a.ok();
            } else {
                this.f346649a.fail("request failed.");
            }
        }
    }

    @JsEvent({"subscribePublicAccount"})
    public final void subscribePublicAccount(@NotNull RequestEvent req) {
        String str;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(req, "req");
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy == null) {
            req.fail("request proxy not exists.");
            return;
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null) {
            str = miniAppInfo.appId;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            req.fail("get appId null");
        } else {
            channelProxy.subscribePublicAccount(str, new b(req));
        }
    }
}
