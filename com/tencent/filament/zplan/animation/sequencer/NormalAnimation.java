package com.tencent.filament.zplan.animation.sequencer;

import androidx.annotation.Keep;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/filament/zplan/animation/sequencer/NormalAnimation;", "Lcom/tencent/filament/zplan/animation/sequencer/Animation;", "", "duration", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "filamentAnimation", "beginTime", "beginStatusTime", "endStatusTime", "<init>", "(DLcom/tencent/filament/zplan/animation/FilamentAnimation;DDD)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class NormalAnimation extends Animation {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/animation/sequencer/NormalAnimation$a;", "", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "filamentAnimation", "Lcom/tencent/filament/zplan/animation/sequencer/NormalAnimation;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.animation.sequencer.NormalAnimation$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final NormalAnimation a(@NotNull FilamentAnimation filamentAnimation) {
            Intrinsics.checkNotNullParameter(filamentAnimation, "filamentAnimation");
            return new NormalAnimation(filamentAnimation.getDuration(), filamentAnimation, 0.0d, 0.0d, filamentAnimation.getDuration());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalAnimation(double d16, @NotNull FilamentAnimation filamentAnimation, double d17, double d18, double d19) {
        super(d16, new Status(filamentAnimation.getPath(), filamentAnimation.getIndex(), d18), new Status(filamentAnimation.getPath(), filamentAnimation.getIndex(), d19), d17, AnimationType.NORMAL);
        Intrinsics.checkNotNullParameter(filamentAnimation, "filamentAnimation");
    }
}
