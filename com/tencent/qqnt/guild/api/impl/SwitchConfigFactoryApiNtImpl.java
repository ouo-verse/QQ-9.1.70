package com.tencent.qqnt.guild.api.impl;

import com.tencent.qqnt.guild.api.ISwitchConfigFactoryApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/guild/api/impl/SwitchConfigFactoryApiNtImpl;", "Lcom/tencent/qqnt/guild/api/ISwitchConfigFactoryApi;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class SwitchConfigFactoryApiNtImpl implements ISwitchConfigFactoryApi {
    @Override // com.tencent.qqnt.guild.api.ISwitchConfigFactoryApi
    @NotNull
    public ax3.a create(@NotNull String str, @NotNull String str2) {
        return ISwitchConfigFactoryApi.a.a(this, str, str2);
    }

    @Override // com.tencent.qqnt.guild.api.ISwitchConfigFactoryApi
    @NotNull
    public ax3.a create(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return ISwitchConfigFactoryApi.a.b(this, str, str2, str3, str4);
    }
}
