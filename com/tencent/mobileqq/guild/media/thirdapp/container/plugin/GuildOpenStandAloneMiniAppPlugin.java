package com.tencent.mobileqq.guild.media.thirdapp.container.plugin;

import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.aa;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@KeepClassConstructor
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/GuildOpenStandAloneMiniAppPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "d", "onInvoke", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOpenStandAloneMiniAppPlugin extends BaseJsPlugin {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GuildOpenStandAloneMiniAppPlugin this$0, RequestEvent req) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "$req");
        this$0.d(req);
    }

    private final void d(RequestEvent req) {
        j.d().i(new aa(new MiniAppIntent.MiniAppRequestEvent(req)));
    }

    @JsEvent({"closeStandAloneMiniAppPanel", "notifyUserAuthResult", "getAuthCode", "lifeNodeNotice"})
    public final void onInvoke(@NotNull final RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildOpenStandAloneMiniAppPlugin", 1, "[notifyUserAuthResult] event " + req.event + " ");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildOpenStandAloneMiniAppPlugin.c(GuildOpenStandAloneMiniAppPlugin.this, req);
            }
        });
    }
}
