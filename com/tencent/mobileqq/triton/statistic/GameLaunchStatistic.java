package com.tencent.mobileqq.triton.statistic;

import com.tencent.mobileqq.triton.exception.TritonException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\fH\u00c6\u0003JC\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/GameLaunchStatistic;", "", "success", "", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "launchTimesMs", "", "gameScriptLoadStatics", "", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "engineInitStatistic", "Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "(ZLcom/tencent/mobileqq/triton/exception/TritonException;JLjava/util/List;Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;)V", "getEngineInitStatistic", "()Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "getException", "()Lcom/tencent/mobileqq/triton/exception/TritonException;", "getGameScriptLoadStatics", "()Ljava/util/List;", "getLaunchTimesMs", "()J", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final /* data */ class GameLaunchStatistic {

    @NotNull
    private final EngineInitStatistic engineInitStatistic;

    @Nullable
    private final TritonException exception;

    @NotNull
    private final List<ScriptLoadStatistic> gameScriptLoadStatics;
    private final long launchTimesMs;
    private final boolean success;

    public GameLaunchStatistic(boolean z16, @Nullable TritonException tritonException, long j3, @NotNull List<ScriptLoadStatistic> gameScriptLoadStatics, @NotNull EngineInitStatistic engineInitStatistic) {
        Intrinsics.checkParameterIsNotNull(gameScriptLoadStatics, "gameScriptLoadStatics");
        Intrinsics.checkParameterIsNotNull(engineInitStatistic, "engineInitStatistic");
        this.success = z16;
        this.exception = tritonException;
        this.launchTimesMs = j3;
        this.gameScriptLoadStatics = gameScriptLoadStatics;
        this.engineInitStatistic = engineInitStatistic;
    }

    public static /* synthetic */ GameLaunchStatistic copy$default(GameLaunchStatistic gameLaunchStatistic, boolean z16, TritonException tritonException, long j3, List list, EngineInitStatistic engineInitStatistic, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = gameLaunchStatistic.success;
        }
        if ((i3 & 2) != 0) {
            tritonException = gameLaunchStatistic.exception;
        }
        TritonException tritonException2 = tritonException;
        if ((i3 & 4) != 0) {
            j3 = gameLaunchStatistic.launchTimesMs;
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            list = gameLaunchStatistic.gameScriptLoadStatics;
        }
        List list2 = list;
        if ((i3 & 16) != 0) {
            engineInitStatistic = gameLaunchStatistic.engineInitStatistic;
        }
        return gameLaunchStatistic.copy(z16, tritonException2, j16, list2, engineInitStatistic);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final TritonException getException() {
        return this.exception;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLaunchTimesMs() {
        return this.launchTimesMs;
    }

    @NotNull
    public final List<ScriptLoadStatistic> component4() {
        return this.gameScriptLoadStatics;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final EngineInitStatistic getEngineInitStatistic() {
        return this.engineInitStatistic;
    }

    @NotNull
    public final GameLaunchStatistic copy(boolean success, @Nullable TritonException exception, long launchTimesMs, @NotNull List<ScriptLoadStatistic> gameScriptLoadStatics, @NotNull EngineInitStatistic engineInitStatistic) {
        Intrinsics.checkParameterIsNotNull(gameScriptLoadStatics, "gameScriptLoadStatics");
        Intrinsics.checkParameterIsNotNull(engineInitStatistic, "engineInitStatistic");
        return new GameLaunchStatistic(success, exception, launchTimesMs, gameScriptLoadStatics, engineInitStatistic);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof GameLaunchStatistic) {
                GameLaunchStatistic gameLaunchStatistic = (GameLaunchStatistic) other;
                if (this.success != gameLaunchStatistic.success || !Intrinsics.areEqual(this.exception, gameLaunchStatistic.exception) || this.launchTimesMs != gameLaunchStatistic.launchTimesMs || !Intrinsics.areEqual(this.gameScriptLoadStatics, gameLaunchStatistic.gameScriptLoadStatics) || !Intrinsics.areEqual(this.engineInitStatistic, gameLaunchStatistic.engineInitStatistic)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final EngineInitStatistic getEngineInitStatistic() {
        return this.engineInitStatistic;
    }

    @Nullable
    public final TritonException getException() {
        return this.exception;
    }

    @NotNull
    public final List<ScriptLoadStatistic> getGameScriptLoadStatics() {
        return this.gameScriptLoadStatics;
    }

    public final long getLaunchTimesMs() {
        return this.launchTimesMs;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        int i3;
        int i16;
        boolean z16 = this.success;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i17 = r06 * 31;
        TritonException tritonException = this.exception;
        int i18 = 0;
        if (tritonException != null) {
            i3 = tritonException.hashCode();
        } else {
            i3 = 0;
        }
        long j3 = this.launchTimesMs;
        int i19 = (((i17 + i3) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        List<ScriptLoadStatistic> list = this.gameScriptLoadStatics;
        if (list != null) {
            i16 = list.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        EngineInitStatistic engineInitStatistic = this.engineInitStatistic;
        if (engineInitStatistic != null) {
            i18 = engineInitStatistic.hashCode();
        }
        return i26 + i18;
    }

    @NotNull
    public String toString() {
        return "GameLaunchStatistic(success=" + this.success + ", exception=" + this.exception + ", launchTimesMs=" + this.launchTimesMs + ", gameScriptLoadStatics=" + this.gameScriptLoadStatics + ", engineInitStatistic=" + this.engineInitStatistic + ")";
    }
}
