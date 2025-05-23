package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@JsPlugin
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/a;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "openFeedbackPage", "<init>", "()V", "d", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a extends BaseJsPlugin {
    @JsEvent({"openFeedbackPage"})
    public final void openFeedbackPage(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        QMLog.d("FeedbackJsPlugin", "openFeedbackPage");
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy == null) {
            req.fail("unsupport in current platform");
        } else {
            req.ok();
            qQCustomizedProxy.openFeedbackPage(this.mMiniAppContext);
        }
    }
}
