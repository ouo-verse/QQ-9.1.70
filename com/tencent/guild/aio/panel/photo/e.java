package com.tencent.guild.aio.panel.photo;

import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/e;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "Lcom/tencent/guild/aio/panel/photo/e$a;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class e implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/e$a;", "Lcom/tencent/guild/aio/panel/photo/e;", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "a", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "()Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "repo", "<init>", "(Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildAIOMediasRepository repo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull GuildAIOMediasRepository repo) {
            super(null);
            Intrinsics.checkNotNullParameter(repo, "repo");
            this.repo = repo;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildAIOMediasRepository getRepo() {
            return this.repo;
        }
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    e() {
    }
}
