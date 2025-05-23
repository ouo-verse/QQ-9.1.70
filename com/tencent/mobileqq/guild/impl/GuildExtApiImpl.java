package com.tencent.mobileqq.guild.impl;

import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.GuildContactFragment;
import com.tencent.mobileqq.guild.IGuildExtApi;
import com.tencent.mobileqq.guild.k;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/impl/GuildExtApiImpl;", "Lcom/tencent/mobileqq/guild/IGuildExtApi;", "()V", "getGuildContactFragment", "Lcom/tencent/mobileqq/app/QBaseFragment;", "getParserClass", "Ljava/lang/Class;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class GuildExtApiImpl implements IGuildExtApi {
    @Override // com.tencent.mobileqq.guild.IGuildExtApi
    public QBaseFragment getGuildContactFragment() {
        return new GuildContactFragment();
    }

    @Override // com.tencent.mobileqq.guild.IGuildExtApi
    public Class<?> getParserClass() {
        return k.class;
    }
}
