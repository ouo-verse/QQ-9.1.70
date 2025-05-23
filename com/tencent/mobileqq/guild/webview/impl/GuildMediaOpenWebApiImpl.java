package com.tencent.mobileqq.guild.webview.impl;

import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer;
import com.tencent.mobileqq.guild.webview.IGuildMediaOpenWebApi;
import com.tencent.mobileqq.qipc.QIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/impl/GuildMediaOpenWebApiImpl;", "Lcom/tencent/mobileqq/guild/webview/IGuildMediaOpenWebApi;", "()V", "getServerIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "registerClient", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildMediaOpenWebApiImpl implements IGuildMediaOpenWebApi {
    @Override // com.tencent.mobileqq.guild.webview.IGuildMediaOpenWebApi
    @NotNull
    public QIPCModule getServerIPCModule() {
        return GuildMediaWebIPCServer.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.guild.webview.IGuildMediaOpenWebApi
    public void registerClient() {
    }
}
