package com.tencent.mobileqq.guild.webview.methods;

import android.app.Activity;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.GuildHotLiveFragment;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/r;", "Lcom/tencent/mobileqq/guild/webview/methods/a;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "k", "<init>", "()V", tl.h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class r extends a {
    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        WebViewPlugin.b bVar;
        Activity a16;
        WebViewPlugin.b bVar2;
        Activity a17;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.d("OpenDiscoverThirdAppPanelMethod", 2, "onJsBridge invoke, method: ", method);
        com.tencent.mobileqq.guild.webview.g gVar = this.f235756e;
        if (gVar != null && (bVar2 = gVar.mRuntime) != null && (a17 = bVar2.a()) != null) {
            GuildHotLiveFragment.Companion.f(GuildHotLiveFragment.INSTANCE, a17, "", "\u70ed\u95e8\u6d3b\u52a8", "", true, 2, 0, 0, DiscoverTabType.HOT, false, "", new GuildAppReportSourceInfo("channel_media_gift_task", ""), null, 4096, null);
        }
        com.tencent.mobileqq.guild.webview.g gVar2 = this.f235756e;
        if (gVar2 != null && (bVar = gVar2.mRuntime) != null && (a16 = bVar.a()) != null) {
            a16.finish();
        }
        return true;
    }
}
