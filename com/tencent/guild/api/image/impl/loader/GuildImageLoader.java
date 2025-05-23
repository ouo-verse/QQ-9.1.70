package com.tencent.guild.api.image.impl.loader;

import com.tencent.guild.api.image.IGuildImageApi;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.picload.e;
import jr0.GuildImageOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003*\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/api/image/impl/loader/GuildImageLoader;", "Lcom/tencent/guild/api/image/IGuildImageApi;", "Ljr0/a;", "Lcom/tencent/libra/request/Option;", "kotlin.jvm.PlatformType", "toGuildPicLoaderOption", "option", "", "load", "getLocalPath", "deleteCache", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildImageLoader implements IGuildImageApi {
    private final Option toGuildPicLoaderOption(GuildImageOptions guildImageOptions) {
        return new Option().setUrl(guildImageOptions.getUrl()).setTargetView(guildImageOptions.getTargetView()).setPredecode(true).setRequestHeight(guildImageOptions.getHeight()).setRequestWidth(guildImageOptions.getWidth());
    }

    @Override // com.tencent.guild.api.image.IGuildImageApi
    public void getLocalPath(@NotNull GuildImageOptions option) {
        Intrinsics.checkNotNullParameter(option, "option");
    }

    @Override // com.tencent.guild.api.image.IGuildImageApi
    public void load(@NotNull GuildImageOptions option) {
        Intrinsics.checkNotNullParameter(option, "option");
        e.a().e(option.e());
    }

    @Override // com.tencent.guild.api.image.IGuildImageApi
    public void deleteCache() {
    }
}
