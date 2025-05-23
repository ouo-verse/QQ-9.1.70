package com.tencent.mobileqq.guild.client.impl;

import com.tencent.mobileqq.guild.client.IGuildClientCommonApi;
import com.tencent.mobileqq.guild.util.bs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/client/impl/GuildClientCommonApiImpl;", "Lcom/tencent/mobileqq/guild/client/IGuildClientCommonApi;", "()V", "getClientIdentityIconPrefix", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildClientCommonApiImpl implements IGuildClientCommonApi {
    @Override // com.tencent.mobileqq.guild.client.IGuildClientCommonApi
    @NotNull
    public String getClientIdentityIconPrefix() {
        return bs.b();
    }
}
