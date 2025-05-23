package com.tencent.guild.api.image.impl;

import com.tencent.guild.api.image.IGuildImageApi;
import com.tencent.guild.api.image.impl.loader.GuildImageLoader;
import jr0.GuildImageOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/api/image/impl/GuildImageApiImpl;", "Lcom/tencent/guild/api/image/IGuildImageApi;", "Ljr0/a;", "option", "", "load", "getLocalPath", "deleteCache", "Lcom/tencent/guild/api/image/impl/loader/GuildImageLoader;", "guildImageLoader", "Lcom/tencent/guild/api/image/impl/loader/GuildImageLoader;", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildImageApiImpl implements IGuildImageApi {

    @NotNull
    private final GuildImageLoader guildImageLoader = new GuildImageLoader();

    @Override // com.tencent.guild.api.image.IGuildImageApi
    public void deleteCache() {
        this.guildImageLoader.deleteCache();
    }

    @Override // com.tencent.guild.api.image.IGuildImageApi
    public void getLocalPath(@NotNull GuildImageOptions option) {
        Intrinsics.checkNotNullParameter(option, "option");
        this.guildImageLoader.getLocalPath(option);
    }

    @Override // com.tencent.guild.api.image.IGuildImageApi
    public void load(@NotNull GuildImageOptions option) {
        Intrinsics.checkNotNullParameter(option, "option");
        this.guildImageLoader.load(option);
    }
}
