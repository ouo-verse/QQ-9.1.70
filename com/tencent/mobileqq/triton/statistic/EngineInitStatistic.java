package com.tencent.mobileqq.triton.statistic;

import com.tencent.mobileqq.triton.exception.TritonException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\u0007H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003J\t\u0010'\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u00c6\u0003J\t\u0010*\u001a\u00020\u0007H\u00c6\u0003J{\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020/H\u00d6\u0001J\t\u00100\u001a\u000201H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "", "success", "", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "loadNativeLibraryTimeMs", "", "loadEngineScriptTimeMs", "createEGLContextTimeMs", "totalInitTimesMs", "engineScriptLoadStatics", "", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "nativeLibraryLoadStatistics", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "initEngineStartTimeMs", "loadEngineScriptStartTimeMs", "(ZLcom/tencent/mobileqq/triton/exception/TritonException;JJJJLjava/util/List;Ljava/util/List;JJ)V", "getCreateEGLContextTimeMs", "()J", "getEngineScriptLoadStatics", "()Ljava/util/List;", "getException", "()Lcom/tencent/mobileqq/triton/exception/TritonException;", "getInitEngineStartTimeMs", "getLoadEngineScriptStartTimeMs", "getLoadEngineScriptTimeMs", "getLoadNativeLibraryTimeMs", "getNativeLibraryLoadStatistics", "getSuccess", "()Z", "getTotalInitTimesMs", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final /* data */ class EngineInitStatistic {
    private final long createEGLContextTimeMs;

    @NotNull
    private final List<ScriptLoadStatistic> engineScriptLoadStatics;

    @Nullable
    private final TritonException exception;
    private final long initEngineStartTimeMs;
    private final long loadEngineScriptStartTimeMs;
    private final long loadEngineScriptTimeMs;
    private final long loadNativeLibraryTimeMs;

    @NotNull
    private final List<NativeLibraryLoadStatistic> nativeLibraryLoadStatistics;
    private final boolean success;
    private final long totalInitTimesMs;

    public EngineInitStatistic(boolean z16, @Nullable TritonException tritonException, long j3, long j16, long j17, long j18, @NotNull List<ScriptLoadStatistic> engineScriptLoadStatics, @NotNull List<NativeLibraryLoadStatistic> nativeLibraryLoadStatistics, long j19, long j26) {
        Intrinsics.checkParameterIsNotNull(engineScriptLoadStatics, "engineScriptLoadStatics");
        Intrinsics.checkParameterIsNotNull(nativeLibraryLoadStatistics, "nativeLibraryLoadStatistics");
        this.success = z16;
        this.exception = tritonException;
        this.loadNativeLibraryTimeMs = j3;
        this.loadEngineScriptTimeMs = j16;
        this.createEGLContextTimeMs = j17;
        this.totalInitTimesMs = j18;
        this.engineScriptLoadStatics = engineScriptLoadStatics;
        this.nativeLibraryLoadStatistics = nativeLibraryLoadStatistics;
        this.initEngineStartTimeMs = j19;
        this.loadEngineScriptStartTimeMs = j26;
    }

    public static /* synthetic */ EngineInitStatistic copy$default(EngineInitStatistic engineInitStatistic, boolean z16, TritonException tritonException, long j3, long j16, long j17, long j18, List list, List list2, long j19, long j26, int i3, Object obj) {
        boolean z17;
        TritonException tritonException2;
        long j27;
        long j28;
        long j29;
        long j36;
        List list3;
        List list4;
        long j37;
        long j38;
        if ((i3 & 1) != 0) {
            z17 = engineInitStatistic.success;
        } else {
            z17 = z16;
        }
        if ((i3 & 2) != 0) {
            tritonException2 = engineInitStatistic.exception;
        } else {
            tritonException2 = tritonException;
        }
        if ((i3 & 4) != 0) {
            j27 = engineInitStatistic.loadNativeLibraryTimeMs;
        } else {
            j27 = j3;
        }
        if ((i3 & 8) != 0) {
            j28 = engineInitStatistic.loadEngineScriptTimeMs;
        } else {
            j28 = j16;
        }
        if ((i3 & 16) != 0) {
            j29 = engineInitStatistic.createEGLContextTimeMs;
        } else {
            j29 = j17;
        }
        if ((i3 & 32) != 0) {
            j36 = engineInitStatistic.totalInitTimesMs;
        } else {
            j36 = j18;
        }
        if ((i3 & 64) != 0) {
            list3 = engineInitStatistic.engineScriptLoadStatics;
        } else {
            list3 = list;
        }
        if ((i3 & 128) != 0) {
            list4 = engineInitStatistic.nativeLibraryLoadStatistics;
        } else {
            list4 = list2;
        }
        if ((i3 & 256) != 0) {
            j37 = engineInitStatistic.initEngineStartTimeMs;
        } else {
            j37 = j19;
        }
        long j39 = j37;
        if ((i3 & 512) != 0) {
            j38 = engineInitStatistic.loadEngineScriptStartTimeMs;
        } else {
            j38 = j26;
        }
        return engineInitStatistic.copy(z17, tritonException2, j27, j28, j29, j36, list3, list4, j39, j38);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component10, reason: from getter */
    public final long getLoadEngineScriptStartTimeMs() {
        return this.loadEngineScriptStartTimeMs;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final TritonException getException() {
        return this.exception;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLoadNativeLibraryTimeMs() {
        return this.loadNativeLibraryTimeMs;
    }

    /* renamed from: component4, reason: from getter */
    public final long getLoadEngineScriptTimeMs() {
        return this.loadEngineScriptTimeMs;
    }

    /* renamed from: component5, reason: from getter */
    public final long getCreateEGLContextTimeMs() {
        return this.createEGLContextTimeMs;
    }

    /* renamed from: component6, reason: from getter */
    public final long getTotalInitTimesMs() {
        return this.totalInitTimesMs;
    }

    @NotNull
    public final List<ScriptLoadStatistic> component7() {
        return this.engineScriptLoadStatics;
    }

    @NotNull
    public final List<NativeLibraryLoadStatistic> component8() {
        return this.nativeLibraryLoadStatistics;
    }

    /* renamed from: component9, reason: from getter */
    public final long getInitEngineStartTimeMs() {
        return this.initEngineStartTimeMs;
    }

    @NotNull
    public final EngineInitStatistic copy(boolean success, @Nullable TritonException exception, long loadNativeLibraryTimeMs, long loadEngineScriptTimeMs, long createEGLContextTimeMs, long totalInitTimesMs, @NotNull List<ScriptLoadStatistic> engineScriptLoadStatics, @NotNull List<NativeLibraryLoadStatistic> nativeLibraryLoadStatistics, long initEngineStartTimeMs, long loadEngineScriptStartTimeMs) {
        Intrinsics.checkParameterIsNotNull(engineScriptLoadStatics, "engineScriptLoadStatics");
        Intrinsics.checkParameterIsNotNull(nativeLibraryLoadStatistics, "nativeLibraryLoadStatistics");
        return new EngineInitStatistic(success, exception, loadNativeLibraryTimeMs, loadEngineScriptTimeMs, createEGLContextTimeMs, totalInitTimesMs, engineScriptLoadStatics, nativeLibraryLoadStatistics, initEngineStartTimeMs, loadEngineScriptStartTimeMs);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof EngineInitStatistic) {
                EngineInitStatistic engineInitStatistic = (EngineInitStatistic) other;
                if (this.success != engineInitStatistic.success || !Intrinsics.areEqual(this.exception, engineInitStatistic.exception) || this.loadNativeLibraryTimeMs != engineInitStatistic.loadNativeLibraryTimeMs || this.loadEngineScriptTimeMs != engineInitStatistic.loadEngineScriptTimeMs || this.createEGLContextTimeMs != engineInitStatistic.createEGLContextTimeMs || this.totalInitTimesMs != engineInitStatistic.totalInitTimesMs || !Intrinsics.areEqual(this.engineScriptLoadStatics, engineInitStatistic.engineScriptLoadStatics) || !Intrinsics.areEqual(this.nativeLibraryLoadStatistics, engineInitStatistic.nativeLibraryLoadStatistics) || this.initEngineStartTimeMs != engineInitStatistic.initEngineStartTimeMs || this.loadEngineScriptStartTimeMs != engineInitStatistic.loadEngineScriptStartTimeMs) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getCreateEGLContextTimeMs() {
        return this.createEGLContextTimeMs;
    }

    @NotNull
    public final List<ScriptLoadStatistic> getEngineScriptLoadStatics() {
        return this.engineScriptLoadStatics;
    }

    @Nullable
    public final TritonException getException() {
        return this.exception;
    }

    public final long getInitEngineStartTimeMs() {
        return this.initEngineStartTimeMs;
    }

    public final long getLoadEngineScriptStartTimeMs() {
        return this.loadEngineScriptStartTimeMs;
    }

    public final long getLoadEngineScriptTimeMs() {
        return this.loadEngineScriptTimeMs;
    }

    public final long getLoadNativeLibraryTimeMs() {
        return this.loadNativeLibraryTimeMs;
    }

    @NotNull
    public final List<NativeLibraryLoadStatistic> getNativeLibraryLoadStatistics() {
        return this.nativeLibraryLoadStatistics;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final long getTotalInitTimesMs() {
        return this.totalInitTimesMs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
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
        long j3 = this.loadNativeLibraryTimeMs;
        int i19 = (((i17 + i3) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j16 = this.loadEngineScriptTimeMs;
        int i26 = (i19 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.createEGLContextTimeMs;
        int i27 = (i26 + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        long j18 = this.totalInitTimesMs;
        int i28 = (i27 + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        List<ScriptLoadStatistic> list = this.engineScriptLoadStatics;
        if (list != null) {
            i16 = list.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        List<NativeLibraryLoadStatistic> list2 = this.nativeLibraryLoadStatistics;
        if (list2 != null) {
            i18 = list2.hashCode();
        }
        int i36 = (i29 + i18) * 31;
        long j19 = this.initEngineStartTimeMs;
        int i37 = (i36 + ((int) (j19 ^ (j19 >>> 32)))) * 31;
        long j26 = this.loadEngineScriptStartTimeMs;
        return i37 + ((int) (j26 ^ (j26 >>> 32)));
    }

    @NotNull
    public String toString() {
        return "EngineInitStatistic(success=" + this.success + ", exception=" + this.exception + ", loadNativeLibraryTimeMs=" + this.loadNativeLibraryTimeMs + ", loadEngineScriptTimeMs=" + this.loadEngineScriptTimeMs + ", createEGLContextTimeMs=" + this.createEGLContextTimeMs + ", totalInitTimesMs=" + this.totalInitTimesMs + ", engineScriptLoadStatics=" + this.engineScriptLoadStatics + ", nativeLibraryLoadStatistics=" + this.nativeLibraryLoadStatistics + ", initEngineStartTimeMs=" + this.initEngineStartTimeMs + ", loadEngineScriptStartTimeMs=" + this.loadEngineScriptStartTimeMs + ")";
    }

    public /* synthetic */ EngineInitStatistic(boolean z16, TritonException tritonException, long j3, long j16, long j17, long j18, List list, List list2, long j19, long j26, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, tritonException, j3, j16, j17, j18, list, list2, (i3 & 256) != 0 ? 0L : j19, (i3 & 512) != 0 ? 0L : j26);
    }
}
