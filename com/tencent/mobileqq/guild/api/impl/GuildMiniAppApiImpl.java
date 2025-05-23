package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildMiniAppApi;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildMiniAppApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildMiniAppApi;", "()V", "registerGuildDiscoverJsPlugin", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildMiniAppApiImpl implements IGuildMiniAppApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildMiniAppApi
    public void registerGuildDiscoverJsPlugin() {
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).addExternalPlugin(com.tencent.mobileqq.guild.discover.recommend.miniapp.n.class);
    }
}
