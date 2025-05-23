package com.tencent.guild.aio.panel.photo;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "RefreshUI", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelUIState$RefreshUI;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildPhotoPanelUIState implements MviUIState {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelUIState$RefreshUI;", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelUIState;", "", "Lcom/tencent/guild/api/media/album/e;", "d", "Ljava/util/List;", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "list", "", "e", "Z", "a", "()Z", CustomImageProps.QUALITY, "<init>", "(Ljava/util/List;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class RefreshUI extends GuildPhotoPanelUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<com.tencent.guild.api.media.album.e> list;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean quality;

        /* JADX WARN: Multi-variable type inference failed */
        public RefreshUI(@Nullable List<? extends com.tencent.guild.api.media.album.e> list, boolean z16) {
            super(null);
            this.list = list;
            this.quality = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getQuality() {
            return this.quality;
        }

        public /* synthetic */ RefreshUI(List list, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : list, z16);
        }
    }

    public /* synthetic */ GuildPhotoPanelUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    GuildPhotoPanelUIState() {
    }
}
