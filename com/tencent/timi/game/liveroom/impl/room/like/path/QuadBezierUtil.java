package com.tencent.timi.game.liveroom.impl.room.like.path;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J(\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J&\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010J&\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0010H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/path/QuadBezierUtil;", "", "()V", "controlPoint", "Landroid/graphics/PointF;", "getControlPoint", "()Landroid/graphics/PointF;", "setControlPoint", "(Landroid/graphics/PointF;)V", "curveByLEFT", "", "getCurveByLEFT", "()Z", "setCurveByLEFT", "(Z)V", "calculateBezierPointXForQuadratic", "", "t", "p0", "p1", "p2", "calculateBezierPointYForQuadratic", "getPointX", "start", "end", "width", "percent", "getPointY", "resetContrulPoint", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class QuadBezierUtil {
    private boolean curveByLEFT = true;

    @NotNull
    private PointF controlPoint = new PointF();

    private final float calculateBezierPointXForQuadratic(float t16, PointF p06, PointF p16, PointF p26) {
        float f16 = 1 - t16;
        return (f16 * f16 * p06.x) + (2 * t16 * f16 * p16.x) + (t16 * t16 * p26.x);
    }

    private final float calculateBezierPointYForQuadratic(float t16, PointF p06, PointF p16, PointF p26) {
        float f16 = 1 - t16;
        return (f16 * f16 * p06.y) + (2 * t16 * f16 * p16.y) + (t16 * t16 * p26.y);
    }

    private final void resetContrulPoint(PointF end, PointF start, float width) {
        if (this.curveByLEFT) {
            PointF pointF = this.controlPoint;
            pointF.x = end.x - width;
            float f16 = end.y;
            float f17 = start.y;
            pointF.y = ((f16 - f17) * 0.5f) + f17;
            return;
        }
        PointF pointF2 = this.controlPoint;
        pointF2.x = start.x + width;
        float f18 = end.y;
        float f19 = start.y;
        pointF2.y = ((f18 - f19) * 0.5f) + f19;
    }

    @NotNull
    public final PointF getControlPoint() {
        return this.controlPoint;
    }

    public final boolean getCurveByLEFT() {
        return this.curveByLEFT;
    }

    public final float getPointX(@NotNull PointF start, @NotNull PointF end, float width, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        resetContrulPoint(end, start, width);
        return calculateBezierPointXForQuadratic(percent, start, this.controlPoint, end);
    }

    public final float getPointY(@NotNull PointF start, @NotNull PointF end, float width, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        resetContrulPoint(end, start, width);
        return calculateBezierPointYForQuadratic(percent, start, this.controlPoint, end);
    }

    public final void setControlPoint(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.controlPoint = pointF;
    }

    public final void setCurveByLEFT(boolean z16) {
        this.curveByLEFT = z16;
    }
}
