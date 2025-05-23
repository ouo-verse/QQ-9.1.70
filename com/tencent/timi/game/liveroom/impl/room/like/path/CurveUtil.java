package com.tencent.timi.game.liveroom.impl.room.like.path;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nJ\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/path/CurveUtil;", "", "()V", "curveByX", "", "getCurveByX", "()Z", "setCurveByX", "(Z)V", "getPointX", "", "start", "Landroid/graphics/PointF;", "end", "percent", "getPointY", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class CurveUtil {
    private boolean curveByX = true;

    public final boolean getCurveByX() {
        return this.curveByX;
    }

    public final float getPointX(@NotNull PointF start, @NotNull PointF end, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        float f16 = start.x;
        if (this.curveByX) {
            float f17 = end.x;
            float f18 = f16 + ((f17 - f16) * percent);
            f16 = f18 + ((f17 - f18) * percent);
        }
        return f16 + ((end.x - f16) * percent);
    }

    public final float getPointY(@NotNull PointF start, @NotNull PointF end, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        float f16 = start.x;
        float f17 = start.y;
        if (this.curveByX) {
            float f18 = end.x;
        }
        return f17 + ((end.y - f17) * percent);
    }

    public final void setCurveByX(boolean z16) {
        this.curveByX = z16;
    }
}
