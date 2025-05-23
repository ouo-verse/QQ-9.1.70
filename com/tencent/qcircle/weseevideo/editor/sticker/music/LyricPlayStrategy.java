package com.tencent.qcircle.weseevideo.editor.sticker.music;

import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricPlayStrategy;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy;", "", "()V", "STRATEGY_LOOP", "", "STRATEGY_SPEED", "mLoopStrategy", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LoopStrategy;", "getMLoopStrategy", "()Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LoopStrategy;", "mLoopStrategy$delegate", "Lkotlin/Lazy;", "mSpeedStrategy", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$SpeedStrategy;", "getMSpeedStrategy", "()Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$SpeedStrategy;", "mSpeedStrategy$delegate", "calculateProgress", "", "currentPosition", "", "lyricDuration", "animation", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "IStrategy", "LoopStrategy", "LyricAnimation", "SpeedStrategy", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class LyricPlayStrategy {
    public static final LyricPlayStrategy INSTANCE = new LyricPlayStrategy();
    public static final int STRATEGY_LOOP = 1;
    public static final int STRATEGY_SPEED = 0;

    /* renamed from: mLoopStrategy$delegate, reason: from kotlin metadata */
    private static final Lazy mLoopStrategy;

    /* renamed from: mSpeedStrategy$delegate, reason: from kotlin metadata */
    private static final Lazy mSpeedStrategy;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$IStrategy;", "", "calculateProgress", "", "currentPosition", "", "lyricDuration", "animation", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public interface IStrategy {
        float calculateProgress(long currentPosition, long lyricDuration, @NotNull LyricAnimation animation);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LoopStrategy;", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$IStrategy;", "()V", "calculateProgress", "", "currentPosition", "", "lyricDuration", "animation", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class LoopStrategy implements IStrategy {
        @Override // com.tencent.qcircle.weseevideo.editor.sticker.music.LyricPlayStrategy.IStrategy
        public float calculateProgress(long currentPosition, long lyricDuration, @NotNull LyricAnimation animation) {
            float prefixDuration;
            long duration;
            float loopRangeDuration;
            long duration2;
            Intrinsics.checkParameterIsNotNull(animation, "animation");
            if (lyricDuration < animation.getPrefixDuration() + animation.getSuffixDuration()) {
                if (currentPosition <= animation.getPrefixDuration()) {
                    loopRangeDuration = (float) currentPosition;
                    duration2 = animation.getDuration();
                } else {
                    loopRangeDuration = (float) (currentPosition + animation.getLoopRangeDuration());
                    duration2 = animation.getDuration();
                }
                return loopRangeDuration / ((float) duration2);
            }
            if (currentPosition <= animation.getPrefixDuration()) {
                prefixDuration = (float) currentPosition;
                duration = animation.getDuration();
            } else if (currentPosition < lyricDuration - animation.getSuffixDuration()) {
                prefixDuration = (float) (((currentPosition - animation.getPrefixDuration()) % animation.getLoopRangeDuration()) + animation.getPrefixDuration());
                duration = animation.getDuration();
            } else {
                return 1 - (((float) (lyricDuration - currentPosition)) / ((float) animation.getDuration()));
            }
            return prefixDuration / ((float) duration);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010!\u001a\u00020\u0000J\t\u0010\"\u001a\u00020\u0007H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006%"}, d2 = {"Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "", "loopStart", "", "loopEnd", "duration", "type", "", "(JJJI)V", "getDuration", "()J", "setDuration", "(J)V", "getLoopEnd", "setLoopEnd", "loopRangeDuration", "getLoopRangeDuration", "getLoopStart", "setLoopStart", "prefixDuration", "getPrefixDuration", "suffixDuration", "getSuffixDuration", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "format", "hashCode", "toString", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final /* data */ class LyricAnimation {
        private long duration;
        private long loopEnd;
        private long loopStart;
        private final int type;

        public LyricAnimation(long j3, long j16, long j17, int i3) {
            this.loopStart = j3;
            this.loopEnd = j16;
            this.duration = j17;
            this.type = i3;
        }

        public static /* synthetic */ LyricAnimation copy$default(LyricAnimation lyricAnimation, long j3, long j16, long j17, int i3, int i16, Object obj) {
            long j18;
            long j19;
            long j26;
            int i17;
            if ((i16 & 1) != 0) {
                j18 = lyricAnimation.loopStart;
            } else {
                j18 = j3;
            }
            if ((i16 & 2) != 0) {
                j19 = lyricAnimation.loopEnd;
            } else {
                j19 = j16;
            }
            if ((i16 & 4) != 0) {
                j26 = lyricAnimation.duration;
            } else {
                j26 = j17;
            }
            if ((i16 & 8) != 0) {
                i17 = lyricAnimation.type;
            } else {
                i17 = i3;
            }
            return lyricAnimation.copy(j18, j19, j26, i17);
        }

        /* renamed from: component1, reason: from getter */
        public final long getLoopStart() {
            return this.loopStart;
        }

        /* renamed from: component2, reason: from getter */
        public final long getLoopEnd() {
            return this.loopEnd;
        }

        /* renamed from: component3, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* renamed from: component4, reason: from getter */
        public final int getType() {
            return this.type;
        }

        @NotNull
        public final LyricAnimation copy(long loopStart, long loopEnd, long duration, int type) {
            return new LyricAnimation(loopStart, loopEnd, duration, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof LyricAnimation) {
                    LyricAnimation lyricAnimation = (LyricAnimation) other;
                    if (this.loopStart != lyricAnimation.loopStart || this.loopEnd != lyricAnimation.loopEnd || this.duration != lyricAnimation.duration || this.type != lyricAnimation.type) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @NotNull
        public final LyricAnimation format() {
            if (this.duration < 0) {
                this.duration = 0L;
            }
            if (this.loopStart <= 0) {
                this.loopStart = 0L;
            }
            long j3 = this.loopEnd;
            if (j3 == 0 || j3 > this.duration) {
                this.loopEnd = this.duration;
            }
            return this;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final long getLoopEnd() {
            return this.loopEnd;
        }

        public final long getLoopRangeDuration() {
            return this.loopEnd - this.loopStart;
        }

        public final long getLoopStart() {
            return this.loopStart;
        }

        public final long getPrefixDuration() {
            return this.loopStart;
        }

        public final long getSuffixDuration() {
            return this.duration - this.loopEnd;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            long j3 = this.loopStart;
            long j16 = this.loopEnd;
            int i3 = ((((int) (j3 ^ (j3 >>> 32))) * 31) + ((int) (j16 ^ (j16 >>> 32)))) * 31;
            long j17 = this.duration;
            return ((i3 + ((int) ((j17 >>> 32) ^ j17))) * 31) + this.type;
        }

        public final void setDuration(long j3) {
            this.duration = j3;
        }

        public final void setLoopEnd(long j3) {
            this.loopEnd = j3;
        }

        public final void setLoopStart(long j3) {
            this.loopStart = j3;
        }

        @NotNull
        public String toString() {
            return "LyricAnimation(loopStart=" + this.loopStart + ", loopEnd=" + this.loopEnd + ", duration=" + this.duration + ", type=" + this.type + ")";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$SpeedStrategy;", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$IStrategy;", "()V", "calculateProgress", "", "currentPosition", "", "lyricDuration", "animation", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class SpeedStrategy implements IStrategy {
        @Override // com.tencent.qcircle.weseevideo.editor.sticker.music.LyricPlayStrategy.IStrategy
        public float calculateProgress(long currentPosition, long lyricDuration, @NotNull LyricAnimation animation) {
            float prefixDuration;
            long duration;
            float loopRangeDuration;
            long duration2;
            Intrinsics.checkParameterIsNotNull(animation, "animation");
            if (lyricDuration < animation.getPrefixDuration() + animation.getSuffixDuration()) {
                if (currentPosition <= animation.getPrefixDuration()) {
                    loopRangeDuration = (float) currentPosition;
                    duration2 = animation.getDuration();
                } else {
                    loopRangeDuration = (float) (currentPosition + animation.getLoopRangeDuration());
                    duration2 = animation.getDuration();
                }
                return loopRangeDuration / ((float) duration2);
            }
            if (currentPosition <= animation.getPrefixDuration()) {
                prefixDuration = (float) currentPosition;
                duration = animation.getDuration();
            } else if (currentPosition < lyricDuration - animation.getSuffixDuration()) {
                prefixDuration = ((((float) (currentPosition - animation.getPrefixDuration())) / ((float) ((lyricDuration - animation.getPrefixDuration()) - animation.getSuffixDuration()))) * ((float) animation.getLoopRangeDuration())) + ((float) animation.getPrefixDuration());
                duration = animation.getDuration();
            } else {
                return 1 - (((float) (lyricDuration - currentPosition)) / ((float) animation.getDuration()));
            }
            return prefixDuration / ((float) duration);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LoopStrategy>() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.music.LyricPlayStrategy$mLoopStrategy$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LyricPlayStrategy.LoopStrategy invoke() {
                return new LyricPlayStrategy.LoopStrategy();
            }
        });
        mLoopStrategy = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SpeedStrategy>() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.music.LyricPlayStrategy$mSpeedStrategy$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LyricPlayStrategy.SpeedStrategy invoke() {
                return new LyricPlayStrategy.SpeedStrategy();
            }
        });
        mSpeedStrategy = lazy2;
    }

    LyricPlayStrategy() {
    }

    private final LoopStrategy getMLoopStrategy() {
        return (LoopStrategy) mLoopStrategy.getValue();
    }

    private final SpeedStrategy getMSpeedStrategy() {
        return (SpeedStrategy) mSpeedStrategy.getValue();
    }

    public final float calculateProgress(long currentPosition, long lyricDuration, @NotNull LyricAnimation animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        if (animation.getType() != 0) {
            return getMLoopStrategy().calculateProgress(currentPosition, lyricDuration, animation);
        }
        return getMSpeedStrategy().calculateProgress(currentPosition, lyricDuration, animation);
    }
}
