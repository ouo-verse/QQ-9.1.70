package com.tencent.timi.game.liveroom.impl.room.like.data;

import android.graphics.PointF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.timi.game.liveroom.impl.room.like.path.ILikePathProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020>R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010 \u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010#\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001a\u0010&\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001a\u0010)\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010.\u00a8\u0006@"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/data/MoveItem;", "", "startPos", "Landroid/graphics/PointF;", "endPos", "likePathProvider", "Lcom/tencent/timi/game/liveroom/impl/room/like/path/ILikePathProvider;", "duration", "", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/graphics/PointF;Landroid/graphics/PointF;Lcom/tencent/timi/game/liveroom/impl/room/like/path/ILikePathProvider;JLandroid/view/animation/Interpolator;)V", "alive", "", "getAlive", "()Z", "setAlive", "(Z)V", "beginScale", "", "getBeginScale", "()F", "setBeginScale", "(F)V", "beginTime", "getBeginTime", "()J", "setBeginTime", "(J)V", "curScale", "getCurScale", "setCurScale", "curX", "getCurX", "setCurX", "curY", "getCurY", "setCurY", "current", "getCurrent", "setCurrent", "currentAlpha", "getCurrentAlpha", "setCurrentAlpha", "getDuration", "getEndPos", "()Landroid/graphics/PointF;", "getInterpolator", "()Landroid/view/animation/Interpolator;", "getLikePathProvider", "()Lcom/tencent/timi/game/liveroom/impl/room/like/path/ILikePathProvider;", "minDuration", "", "getMinDuration", "()I", "setMinDuration", "(I)V", "showDuration", "getShowDuration", "setShowDuration", "getStartPos", "begin", "", "nextFrame", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public abstract class MoveItem {
    private boolean alive;
    private float beginScale;
    private long beginTime;
    private float curScale;
    private float curX;
    private float curY;
    private long current;
    private float currentAlpha;
    private final long duration;

    @NotNull
    private final PointF endPos;

    @NotNull
    private final Interpolator interpolator;

    @NotNull
    private final ILikePathProvider likePathProvider;
    private int minDuration;
    private float showDuration;

    @NotNull
    private final PointF startPos;

    public MoveItem(@NotNull PointF startPos, @NotNull PointF endPos, @NotNull ILikePathProvider likePathProvider, long j3, @NotNull Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(startPos, "startPos");
        Intrinsics.checkNotNullParameter(endPos, "endPos");
        Intrinsics.checkNotNullParameter(likePathProvider, "likePathProvider");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        this.startPos = startPos;
        this.endPos = endPos;
        this.likePathProvider = likePathProvider;
        this.duration = j3;
        this.interpolator = interpolator;
        this.beginScale = 0.7f;
        this.showDuration = 200.0f;
        this.minDuration = 32;
        this.curScale = 0.7f;
        this.curX = startPos.x;
        this.curY = startPos.y;
    }

    public final void begin() {
        this.beginTime = System.currentTimeMillis();
        this.alive = true;
    }

    public final boolean getAlive() {
        return this.alive;
    }

    public final float getBeginScale() {
        return this.beginScale;
    }

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final float getCurScale() {
        return this.curScale;
    }

    public final float getCurX() {
        return this.curX;
    }

    public final float getCurY() {
        return this.curY;
    }

    public final long getCurrent() {
        return this.current;
    }

    public final float getCurrentAlpha() {
        return this.currentAlpha;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final PointF getEndPos() {
        return this.endPos;
    }

    @NotNull
    public final Interpolator getInterpolator() {
        return this.interpolator;
    }

    @NotNull
    public final ILikePathProvider getLikePathProvider() {
        return this.likePathProvider;
    }

    public final int getMinDuration() {
        return this.minDuration;
    }

    public final float getShowDuration() {
        return this.showDuration;
    }

    @NotNull
    public final PointF getStartPos() {
        return this.startPos;
    }

    public final void nextFrame() {
        float f16;
        long currentTimeMillis = System.currentTimeMillis() - this.beginTime;
        this.current = currentTimeMillis;
        long j3 = this.duration;
        if (currentTimeMillis < j3) {
            f16 = this.interpolator.getInterpolation(((float) currentTimeMillis) / ((float) j3));
        } else {
            this.alive = false;
            f16 = 1.0f;
        }
        this.curX = this.likePathProvider.getX(this.startPos, this.endPos, f16);
        this.curY = this.likePathProvider.getY(this.startPos, this.endPos, f16);
        long j16 = this.current;
        float f17 = (float) j16;
        float f18 = this.showDuration;
        if (f17 < f18) {
            float f19 = ((float) j16) / f18;
            this.currentAlpha = f19;
            float f26 = this.beginScale;
            this.curScale = f26 + ((1.0f - f26) * f19);
            return;
        }
        long j17 = this.duration;
        if (((float) (j17 - j16)) < f18) {
            this.currentAlpha = ((float) (j17 - j16)) / f18;
            this.curScale = 1.0f;
        } else {
            this.currentAlpha = 1.0f;
            this.curScale = 1.0f;
        }
    }

    public final void setAlive(boolean z16) {
        this.alive = z16;
    }

    public final void setBeginScale(float f16) {
        this.beginScale = f16;
    }

    public final void setBeginTime(long j3) {
        this.beginTime = j3;
    }

    public final void setCurScale(float f16) {
        this.curScale = f16;
    }

    public final void setCurX(float f16) {
        this.curX = f16;
    }

    public final void setCurY(float f16) {
        this.curY = f16;
    }

    public final void setCurrent(long j3) {
        this.current = j3;
    }

    public final void setCurrentAlpha(float f16) {
        this.currentAlpha = f16;
    }

    public final void setMinDuration(int i3) {
        this.minDuration = i3;
    }

    public final void setShowDuration(float f16) {
        this.showDuration = f16;
    }

    public /* synthetic */ MoveItem(PointF pointF, PointF pointF2, ILikePathProvider iLikePathProvider, long j3, Interpolator interpolator, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(pointF, pointF2, iLikePathProvider, j3, (i3 & 16) != 0 ? new AccelerateDecelerateInterpolator() : interpolator);
    }
}
