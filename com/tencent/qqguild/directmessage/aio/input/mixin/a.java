package com.tencent.qqguild.directmessage.aio.input.mixin;

import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u00020\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/mixin/a;", "", "Lcom/tencent/aio/api/runtime/a;", "a", "()Lcom/tencent/aio/api/runtime/a;", "setAioContext", "(Lcom/tencent/aio/api/runtime/a;)V", "aioContext", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "i", "()Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "setMediaRepo", "(Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;)V", "mediaRepo", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface a {
    @NotNull
    com.tencent.aio.api.runtime.a a();

    @Nullable
    GuildAIOMediasRepository i();
}
