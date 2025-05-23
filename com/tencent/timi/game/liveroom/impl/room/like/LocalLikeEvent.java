package com.tencent.timi.game.liveroom.impl.room.like;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LocalLikeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "likeResId", "(Ljava/lang/String;Ljava/lang/String;)V", "getLikeResId", "()Ljava/lang/String;", "getMaterialId", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class LocalLikeEvent extends SimpleBaseEvent {

    @NotNull
    private final String likeResId;

    @NotNull
    private final String materialId;

    public LocalLikeEvent(@NotNull String materialId, @NotNull String likeResId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(likeResId, "likeResId");
        this.materialId = materialId;
        this.likeResId = likeResId;
    }

    @NotNull
    public final String getLikeResId() {
        return this.likeResId;
    }

    @NotNull
    public final String getMaterialId() {
        return this.materialId;
    }

    public /* synthetic */ LocalLikeEvent(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2);
    }
}
