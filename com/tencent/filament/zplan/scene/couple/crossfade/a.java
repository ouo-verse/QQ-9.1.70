package com.tencent.filament.zplan.scene.couple.crossfade;

import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.sequencer.Animation;
import com.tencent.filament.zplan.animation.sequencer.AnimationType;
import com.tencent.filament.zplan.animation.sequencer.NormalAnimation;
import com.tencent.filament.zplan.animation.sequencer.Status;
import com.tencent.filament.zplan.animation.sequencer.Track;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/crossfade/a;", "", "Lcom/tencent/filament/zplan/animation/sequencer/Animation;", "fromAnimation", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "toAnimation", "", "crossFadeDuration", "lastAnimateNowInterval", "Lcom/tencent/filament/zplan/animation/sequencer/Track;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f105953a = new a();

    a() {
    }

    @NotNull
    public final Track a(@NotNull Animation fromAnimation, @NotNull FilamentAnimation toAnimation, double crossFadeDuration, double lastAnimateNowInterval) {
        Intrinsics.checkNotNullParameter(fromAnimation, "fromAnimation");
        Intrinsics.checkNotNullParameter(toAnimation, "toAnimation");
        Track track = new Track(false, null, 3, null);
        int duration = (int) (lastAnimateNowInterval / fromAnimation.getDuration());
        double duration2 = fromAnimation.getDuration() * duration;
        double d16 = lastAnimateNowInterval - duration2;
        FLog.INSTANCE.i("CrossFadeHelper", "lastAnimateNowInterval: " + lastAnimateNowInterval + ", fromDuration: " + fromAnimation.getDuration() + ", count: " + duration + ", playedTimeInterval: " + duration2 + ", beginStatusTime: " + d16);
        Status status = new Status(fromAnimation.getBeginStatus().getGltfPath(), fromAnimation.getBeginStatus().getIndex(), d16);
        Status status2 = new Status(toAnimation.getPath(), toAnimation.getIndex(), 0.0d);
        AnimationType animationType = AnimationType.CROSS_FADE;
        track.getAnimations().add(new Animation(crossFadeDuration, status, status2, 0.0d, animationType));
        double d17 = crossFadeDuration + 0.0d;
        NormalAnimation normalAnimation = new NormalAnimation(toAnimation.getDuration(), toAnimation, d17, 0.0d, toAnimation.getDuration());
        track.getAnimations().add(normalAnimation);
        track.getAnimations().add(new Animation(crossFadeDuration, new Status(toAnimation.getPath(), toAnimation.getIndex(), toAnimation.getDuration()), new Status(fromAnimation.getBeginStatus().getGltfPath(), fromAnimation.getBeginStatus().getIndex(), (((double) 2) * crossFadeDuration) + normalAnimation.getDuration() + lastAnimateNowInterval), d17 + toAnimation.getDuration(), animationType));
        return track;
    }
}
