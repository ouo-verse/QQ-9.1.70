package com.tencent.guild.aio.component.publisher;

import com.tencent.guild.api.media.album.e;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/guild/aio/component/publisher/GuildPostMediaUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "HidePostMedia", "RefreshPostMedia", "Lcom/tencent/guild/aio/component/publisher/GuildPostMediaUIState$HidePostMedia;", "Lcom/tencent/guild/aio/component/publisher/GuildPostMediaUIState$RefreshPostMedia;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildPostMediaUIState implements MviUIState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/component/publisher/GuildPostMediaUIState$HidePostMedia;", "Lcom/tencent/guild/aio/component/publisher/GuildPostMediaUIState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class HidePostMedia extends GuildPostMediaUIState {
        public HidePostMedia() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/component/publisher/GuildPostMediaUIState$RefreshPostMedia;", "Lcom/tencent/guild/aio/component/publisher/GuildPostMediaUIState;", "", "Lcom/tencent/guild/api/media/album/e;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "list", "<init>", "(Ljava/util/List;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class RefreshPostMedia extends GuildPostMediaUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<e> list;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public RefreshPostMedia(@NotNull List<? extends e> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        @NotNull
        public final List<e> a() {
            return this.list;
        }
    }

    public /* synthetic */ GuildPostMediaUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildPostMediaUIState() {
    }
}
