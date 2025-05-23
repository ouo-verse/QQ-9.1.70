package com.tencent.timi.game.liveroom.impl.room.like.path;

import android.graphics.PointF;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/path/ILikePathProvider;", "", "getX", "", "start", "Landroid/graphics/PointF;", "end", "percent", "getY", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public interface ILikePathProvider {
    float getX(@NotNull PointF start, @NotNull PointF end, float percent);

    float getY(@NotNull PointF start, @NotNull PointF end, float percent);
}
