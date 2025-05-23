package com.tencent.filament.zplan.animation.sequencer;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/animation/sequencer/Animation;", "", "duration", "", "beginStatus", "Lcom/tencent/filament/zplan/animation/sequencer/Status;", "endStatus", "beginTime", "animationType", "Lcom/tencent/filament/zplan/animation/sequencer/AnimationType;", "(DLcom/tencent/filament/zplan/animation/sequencer/Status;Lcom/tencent/filament/zplan/animation/sequencer/Status;DLcom/tencent/filament/zplan/animation/sequencer/AnimationType;)V", "getAnimationType", "()Lcom/tencent/filament/zplan/animation/sequencer/AnimationType;", "getBeginStatus", "()Lcom/tencent/filament/zplan/animation/sequencer/Status;", "getBeginTime", "()D", "setBeginTime", "(D)V", "getDuration", "getEndStatus", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public class Animation {

    @NotNull
    private final AnimationType animationType;

    @NotNull
    private final Status beginStatus;
    private double beginTime;
    private final double duration;

    @NotNull
    private final Status endStatus;

    public Animation(double d16, @NotNull Status beginStatus, @NotNull Status endStatus, double d17, @NotNull AnimationType animationType) {
        Intrinsics.checkNotNullParameter(beginStatus, "beginStatus");
        Intrinsics.checkNotNullParameter(endStatus, "endStatus");
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        this.duration = d16;
        this.beginStatus = beginStatus;
        this.endStatus = endStatus;
        this.beginTime = d17;
        this.animationType = animationType;
    }

    @NotNull
    public final AnimationType getAnimationType() {
        return this.animationType;
    }

    @NotNull
    public final Status getBeginStatus() {
        return this.beginStatus;
    }

    public final double getBeginTime() {
        return this.beginTime;
    }

    public final double getDuration() {
        return this.duration;
    }

    @NotNull
    public final Status getEndStatus() {
        return this.endStatus;
    }

    public final void setBeginTime(double d16) {
        this.beginTime = d16;
    }

    public /* synthetic */ Animation(double d16, Status status, Status status2, double d17, AnimationType animationType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0d : d16, status, status2, (i3 & 8) != 0 ? 0.0d : d17, (i3 & 16) != 0 ? AnimationType.NORMAL : animationType);
    }
}
