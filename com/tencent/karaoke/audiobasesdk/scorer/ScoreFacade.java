package com.tencent.karaoke.audiobasesdk.scorer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreFacade;", "", "()V", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class ScoreFacade {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ.\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreFacade$Companion;", "", "()V", "createMultiScore", "Lcom/tencent/karaoke/audiobasesdk/scorer/IMultiScore;", "createScore", "Lcom/tencent/karaoke/audiobasesdk/scorer/IScore;", "scoreConfig", "Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig;", "process", "", "ss", "", "length", "", "processForTotal", "scores", "scoreLength", "total", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final IMultiScore createMultiScore() {
            return new MultiScoreImpl();
        }

        @NotNull
        public final IScore createScore(@NotNull ScoreConfig scoreConfig) {
            Intrinsics.checkParameterIsNotNull(scoreConfig, "scoreConfig");
            if (!scoreConfig.getEnableBottomUpPlan()) {
                return new DefaultScoreImpl(scoreConfig);
            }
            return new KaraScoreImpl(scoreConfig);
        }

        @Nullable
        public final int[] process(@NotNull byte[] ss5, int length) {
            Intrinsics.checkParameterIsNotNull(ss5, "ss");
            return ScorerNativeBridge.INSTANCE.native_process(ss5, length);
        }

        public final int processForTotal(@NotNull byte[] ss5, int length, @NotNull int[] scores, int scoreLength, int total) {
            Intrinsics.checkParameterIsNotNull(ss5, "ss");
            Intrinsics.checkParameterIsNotNull(scores, "scores");
            return ScorerNativeBridge.INSTANCE.native_processForTotal(ss5, length, scores, scoreLength, total);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
