package com.tencent.guild.api.input.impl;

import com.tencent.guild.api.input.IGuildInputBarApi;
import com.tencent.mobileqq.guild.temp.api.IGuildBackgroundApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/api/input/impl/GuildInputBarApiImpl;", "Lcom/tencent/guild/api/input/IGuildInputBarApi;", "()V", "getSkinAioInputBg", "", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildInputBarApiImpl implements IGuildInputBarApi {
    @Override // com.tencent.guild.api.input.IGuildInputBarApi
    public int getSkinAioInputBg() {
        return ((IGuildBackgroundApi) QRoute.api(IGuildBackgroundApi.class)).getSkinAioInputBg();
    }
}
