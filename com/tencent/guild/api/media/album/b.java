package com.tencent.guild.api.media.album;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/guild/api/media/album/e;", "", CustomImageProps.QUALITY, "", "extra", "Lcom/tencent/guild/api/media/album/d;", "a", "nt-guild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {
    @NotNull
    public static final GuildPickPhotoResult a(@NotNull e eVar, boolean z16, @Nullable Object obj) {
        GuildAlbumMediaType guildAlbumMediaType;
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        int type = eVar.getType();
        if (type == c.a()) {
            guildAlbumMediaType = GuildAlbumMediaType.PHOTO;
        } else if (type == c.b()) {
            guildAlbumMediaType = GuildAlbumMediaType.VIDEO;
        } else {
            guildAlbumMediaType = GuildAlbumMediaType.OTHER;
        }
        return new GuildPickPhotoResult(z16, eVar.getPath(), guildAlbumMediaType, obj, null, 16, null);
    }

    public static /* synthetic */ GuildPickPhotoResult b(e eVar, boolean z16, Object obj, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            obj = null;
        }
        return a(eVar, z16, obj);
    }
}
