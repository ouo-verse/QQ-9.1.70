package com.tencent.timi.game.liveroom.impl.room.like.path;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/path/LovePathProvider;", "Lcom/tencent/timi/game/liveroom/impl/room/like/path/ILikePathProvider;", "()V", "curveType", "", "getCurveType", "()I", "setCurveType", "(I)V", "curveUtil", "Lcom/tencent/timi/game/liveroom/impl/room/like/path/CurveUtil;", "getCurveUtil", "()Lcom/tencent/timi/game/liveroom/impl/room/like/path/CurveUtil;", "getX", "", "start", "Landroid/graphics/PointF;", "end", "percent", "getY", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class LovePathProvider implements ILikePathProvider {
    private int curveType;

    @NotNull
    private final CurveUtil curveUtil;

    public LovePathProvider() {
        CurveUtil curveUtil = new CurveUtil();
        this.curveUtil = curveUtil;
        curveUtil.setCurveByX(true);
    }

    public final int getCurveType() {
        return this.curveType;
    }

    @NotNull
    public final CurveUtil getCurveUtil() {
        return this.curveUtil;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.like.path.ILikePathProvider
    public float getX(@NotNull PointF start, @NotNull PointF end, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return this.curveUtil.getPointX(start, end, percent);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.like.path.ILikePathProvider
    public float getY(@NotNull PointF start, @NotNull PointF end, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return this.curveUtil.getPointY(start, end, percent);
    }

    public final void setCurveType(int i3) {
        this.curveType = i3;
    }
}
