package com.tencent.timi.game.liveroom.impl.room.like.path;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J \u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0003H\u0016J \u0010!\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0003H\u0016J \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/path/CurvePathProvider;", "Lcom/tencent/timi/game/liveroom/impl/room/like/path/ILikePathProvider;", "stageHeight", "", "stageWidth", "startLeft", "", "(FFZ)V", "CURVE_TYPE_START_LEFT", "", "CURVE_TYPE_START_RIGHT", "curveType", "getCurveType", "()I", "setCurveType", "(I)V", "curveUtil", "Lcom/tencent/timi/game/liveroom/impl/room/like/path/QuadBezierUtil;", "getCurveUtil", "()Lcom/tencent/timi/game/liveroom/impl/room/like/path/QuadBezierUtil;", "stageEnd", "Landroid/graphics/PointF;", "getStageEnd", "()Landroid/graphics/PointF;", "getStageHeight", "()F", "stageStart", "getStageStart", "getStageWidth", "getX", "start", "end", "percent", "getY", "setStageStartEnd", "", "originStart", "originEnd", "curStage", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class CurvePathProvider implements ILikePathProvider {
    private int CURVE_TYPE_START_LEFT;
    private int CURVE_TYPE_START_RIGHT;
    private int curveType;

    @NotNull
    private final QuadBezierUtil curveUtil;

    @NotNull
    private final PointF stageEnd;
    private final float stageHeight;

    @NotNull
    private final PointF stageStart;
    private final float stageWidth;

    public CurvePathProvider(float f16, float f17, boolean z16) {
        this.stageHeight = f16;
        this.stageWidth = f17;
        this.CURVE_TYPE_START_RIGHT = 1;
        this.stageStart = new PointF();
        this.stageEnd = new PointF();
        this.curveUtil = new QuadBezierUtil();
        if (z16) {
            this.CURVE_TYPE_START_LEFT = 1;
            this.CURVE_TYPE_START_RIGHT = 0;
        } else {
            this.CURVE_TYPE_START_LEFT = 0;
            this.CURVE_TYPE_START_RIGHT = 1;
        }
    }

    private final void setStageStartEnd(PointF originStart, PointF originEnd, int curStage) {
        int i3 = curStage % 2;
        if (i3 == this.CURVE_TYPE_START_LEFT) {
            PointF pointF = this.stageStart;
            pointF.x = originStart.x;
            float f16 = originStart.y;
            float f17 = this.stageHeight;
            pointF.y = f16 - (curStage * f17);
            PointF pointF2 = this.stageEnd;
            pointF2.x = originStart.x;
            pointF2.y = originStart.y - ((curStage + 1) * f17);
            this.curveUtil.setCurveByLEFT(true);
            return;
        }
        if (i3 == this.CURVE_TYPE_START_RIGHT) {
            PointF pointF3 = this.stageStart;
            pointF3.x = originStart.x;
            float f18 = originStart.y;
            float f19 = this.stageHeight;
            pointF3.y = f18 - (curStage * f19);
            PointF pointF4 = this.stageEnd;
            pointF4.x = originStart.x;
            pointF4.y = originStart.y - ((curStage + 1) * f19);
            this.curveUtil.setCurveByLEFT(false);
        }
    }

    public final int getCurveType() {
        return this.curveType;
    }

    @NotNull
    public final QuadBezierUtil getCurveUtil() {
        return this.curveUtil;
    }

    @NotNull
    public final PointF getStageEnd() {
        return this.stageEnd;
    }

    public final float getStageHeight() {
        return this.stageHeight;
    }

    @NotNull
    public final PointF getStageStart() {
        return this.stageStart;
    }

    public final float getStageWidth() {
        return this.stageWidth;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.like.path.ILikePathProvider
    public float getX(@NotNull PointF start, @NotNull PointF end, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        float abs = Math.abs(end.y - start.y) * percent;
        float f16 = this.stageHeight;
        float f17 = (abs % f16) / f16;
        setStageStartEnd(start, end, (int) (abs / f16));
        return this.curveUtil.getPointX(this.stageStart, this.stageEnd, this.stageWidth, f17);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.like.path.ILikePathProvider
    public float getY(@NotNull PointF start, @NotNull PointF end, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        float abs = Math.abs(end.y - start.y) * percent;
        float f16 = this.stageHeight;
        float f17 = (abs % f16) / f16;
        setStageStartEnd(start, end, (int) (abs / f16));
        return this.curveUtil.getPointY(this.stageStart, this.stageEnd, this.stageWidth, f17);
    }

    public final void setCurveType(int i3) {
        this.curveType = i3;
    }

    public /* synthetic */ CurvePathProvider(float f16, float f17, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, f17, (i3 & 4) != 0 ? false : z16);
    }
}
