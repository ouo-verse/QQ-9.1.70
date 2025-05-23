package com.tencent.guild.aio.panel.photo;

import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "SelectMediaChanged", "SelectMediaRepositoryGet", "SelectMediaRepositoryPost", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent$SelectMediaChanged;", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent$SelectMediaRepositoryGet;", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent$SelectMediaRepositoryPost;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildPhotoPanelMsgIntent implements MsgIntent {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent$SelectMediaChanged;", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent;", "", "Lcom/tencent/guild/api/media/album/e;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "list", "<init>", "(Ljava/util/List;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class SelectMediaChanged extends GuildPhotoPanelMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.guild.api.media.album.e> list;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public SelectMediaChanged(@NotNull List<? extends com.tencent.guild.api.media.album.e> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        @NotNull
        public final List<com.tencent.guild.api.media.album.e> a() {
            return this.list;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent$SelectMediaRepositoryGet;", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SelectMediaRepositoryGet extends GuildPhotoPanelMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final SelectMediaRepositoryGet f112040d = new SelectMediaRepositoryGet();

        SelectMediaRepositoryGet() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent$SelectMediaRepositoryPost;", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent;", "", "isSticky", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "d", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "a", "()Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "repo", "<init>", "(Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class SelectMediaRepositoryPost extends GuildPhotoPanelMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildAIOMediasRepository repo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectMediaRepositoryPost(@NotNull GuildAIOMediasRepository repo) {
            super(null);
            Intrinsics.checkNotNullParameter(repo, "repo");
            this.repo = repo;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildAIOMediasRepository getRepo() {
            return this.repo;
        }

        @Override // com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgIntent, com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            return true;
        }
    }

    public /* synthetic */ GuildPhotoPanelMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    GuildPhotoPanelMsgIntent() {
    }
}
