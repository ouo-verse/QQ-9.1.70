package com.tencent.mobileqq.triton.statistic;

import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\nH\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\u0007H\u00c6\u0003J\t\u0010$\u001a\u00020\nH\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\t\u0010&\u001a\u00020\nH\u00c6\u0003J\t\u0010'\u001a\u00020\nH\u00c6\u0003J\t\u0010(\u001a\u00020\u0007H\u00c6\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\nH\u00c6\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020.H\u00d6\u0001J\t\u0010/\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "", WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadResult;", "scriptContextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "scriptName", "", "scriptPath", "readTimeMs", "", "readCodeCacheTimeMs", "compileTimeMs", "executeTimeMs", "exception", "startTime", "(Lcom/tencent/mobileqq/triton/statistic/ScriptLoadResult;Lcom/tencent/mobileqq/triton/script/ScriptContextType;Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/String;J)V", "getCompileTimeMs", "()J", "getException", "()Ljava/lang/String;", "getExecuteTimeMs", "getLoadResult", "()Lcom/tencent/mobileqq/triton/statistic/ScriptLoadResult;", "getReadCodeCacheTimeMs", "getReadTimeMs", "getScriptContextType", "()Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "getScriptName", "getScriptPath", "getStartTime", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final /* data */ class ScriptLoadStatistic {
    private final long compileTimeMs;

    @NotNull
    private final String exception;
    private final long executeTimeMs;

    @NotNull
    private final ScriptLoadResult loadResult;
    private final long readCodeCacheTimeMs;
    private final long readTimeMs;

    @NotNull
    private final ScriptContextType scriptContextType;

    @NotNull
    private final String scriptName;

    @NotNull
    private final String scriptPath;
    private final long startTime;

    public ScriptLoadStatistic(@NotNull ScriptLoadResult loadResult, @NotNull ScriptContextType scriptContextType, @NotNull String scriptName, @NotNull String scriptPath, long j3, long j16, long j17, long j18, @NotNull String exception, long j19) {
        Intrinsics.checkParameterIsNotNull(loadResult, "loadResult");
        Intrinsics.checkParameterIsNotNull(scriptContextType, "scriptContextType");
        Intrinsics.checkParameterIsNotNull(scriptName, "scriptName");
        Intrinsics.checkParameterIsNotNull(scriptPath, "scriptPath");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        this.loadResult = loadResult;
        this.scriptContextType = scriptContextType;
        this.scriptName = scriptName;
        this.scriptPath = scriptPath;
        this.readTimeMs = j3;
        this.readCodeCacheTimeMs = j16;
        this.compileTimeMs = j17;
        this.executeTimeMs = j18;
        this.exception = exception;
        this.startTime = j19;
    }

    public static /* synthetic */ ScriptLoadStatistic copy$default(ScriptLoadStatistic scriptLoadStatistic, ScriptLoadResult scriptLoadResult, ScriptContextType scriptContextType, String str, String str2, long j3, long j16, long j17, long j18, String str3, long j19, int i3, Object obj) {
        ScriptLoadResult scriptLoadResult2;
        ScriptContextType scriptContextType2;
        String str4;
        String str5;
        long j26;
        long j27;
        long j28;
        long j29;
        String str6;
        long j36;
        if ((i3 & 1) != 0) {
            scriptLoadResult2 = scriptLoadStatistic.loadResult;
        } else {
            scriptLoadResult2 = scriptLoadResult;
        }
        if ((i3 & 2) != 0) {
            scriptContextType2 = scriptLoadStatistic.scriptContextType;
        } else {
            scriptContextType2 = scriptContextType;
        }
        if ((i3 & 4) != 0) {
            str4 = scriptLoadStatistic.scriptName;
        } else {
            str4 = str;
        }
        if ((i3 & 8) != 0) {
            str5 = scriptLoadStatistic.scriptPath;
        } else {
            str5 = str2;
        }
        if ((i3 & 16) != 0) {
            j26 = scriptLoadStatistic.readTimeMs;
        } else {
            j26 = j3;
        }
        if ((i3 & 32) != 0) {
            j27 = scriptLoadStatistic.readCodeCacheTimeMs;
        } else {
            j27 = j16;
        }
        if ((i3 & 64) != 0) {
            j28 = scriptLoadStatistic.compileTimeMs;
        } else {
            j28 = j17;
        }
        if ((i3 & 128) != 0) {
            j29 = scriptLoadStatistic.executeTimeMs;
        } else {
            j29 = j18;
        }
        if ((i3 & 256) != 0) {
            str6 = scriptLoadStatistic.exception;
        } else {
            str6 = str3;
        }
        String str7 = str6;
        if ((i3 & 512) != 0) {
            j36 = scriptLoadStatistic.startTime;
        } else {
            j36 = j19;
        }
        return scriptLoadStatistic.copy(scriptLoadResult2, scriptContextType2, str4, str5, j26, j27, j28, j29, str7, j36);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final ScriptLoadResult getLoadResult() {
        return this.loadResult;
    }

    /* renamed from: component10, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ScriptContextType getScriptContextType() {
        return this.scriptContextType;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getScriptName() {
        return this.scriptName;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getScriptPath() {
        return this.scriptPath;
    }

    /* renamed from: component5, reason: from getter */
    public final long getReadTimeMs() {
        return this.readTimeMs;
    }

    /* renamed from: component6, reason: from getter */
    public final long getReadCodeCacheTimeMs() {
        return this.readCodeCacheTimeMs;
    }

    /* renamed from: component7, reason: from getter */
    public final long getCompileTimeMs() {
        return this.compileTimeMs;
    }

    /* renamed from: component8, reason: from getter */
    public final long getExecuteTimeMs() {
        return this.executeTimeMs;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getException() {
        return this.exception;
    }

    @NotNull
    public final ScriptLoadStatistic copy(@NotNull ScriptLoadResult loadResult, @NotNull ScriptContextType scriptContextType, @NotNull String scriptName, @NotNull String scriptPath, long readTimeMs, long readCodeCacheTimeMs, long compileTimeMs, long executeTimeMs, @NotNull String exception, long startTime) {
        Intrinsics.checkParameterIsNotNull(loadResult, "loadResult");
        Intrinsics.checkParameterIsNotNull(scriptContextType, "scriptContextType");
        Intrinsics.checkParameterIsNotNull(scriptName, "scriptName");
        Intrinsics.checkParameterIsNotNull(scriptPath, "scriptPath");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        return new ScriptLoadStatistic(loadResult, scriptContextType, scriptName, scriptPath, readTimeMs, readCodeCacheTimeMs, compileTimeMs, executeTimeMs, exception, startTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ScriptLoadStatistic) {
                ScriptLoadStatistic scriptLoadStatistic = (ScriptLoadStatistic) other;
                if (!Intrinsics.areEqual(this.loadResult, scriptLoadStatistic.loadResult) || !Intrinsics.areEqual(this.scriptContextType, scriptLoadStatistic.scriptContextType) || !Intrinsics.areEqual(this.scriptName, scriptLoadStatistic.scriptName) || !Intrinsics.areEqual(this.scriptPath, scriptLoadStatistic.scriptPath) || this.readTimeMs != scriptLoadStatistic.readTimeMs || this.readCodeCacheTimeMs != scriptLoadStatistic.readCodeCacheTimeMs || this.compileTimeMs != scriptLoadStatistic.compileTimeMs || this.executeTimeMs != scriptLoadStatistic.executeTimeMs || !Intrinsics.areEqual(this.exception, scriptLoadStatistic.exception) || this.startTime != scriptLoadStatistic.startTime) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getCompileTimeMs() {
        return this.compileTimeMs;
    }

    @NotNull
    public final String getException() {
        return this.exception;
    }

    public final long getExecuteTimeMs() {
        return this.executeTimeMs;
    }

    @NotNull
    public final ScriptLoadResult getLoadResult() {
        return this.loadResult;
    }

    public final long getReadCodeCacheTimeMs() {
        return this.readCodeCacheTimeMs;
    }

    public final long getReadTimeMs() {
        return this.readTimeMs;
    }

    @NotNull
    public final ScriptContextType getScriptContextType() {
        return this.scriptContextType;
    }

    @NotNull
    public final String getScriptName() {
        return this.scriptName;
    }

    @NotNull
    public final String getScriptPath() {
        return this.scriptPath;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        ScriptLoadResult scriptLoadResult = this.loadResult;
        int i19 = 0;
        if (scriptLoadResult != null) {
            i3 = scriptLoadResult.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = i3 * 31;
        ScriptContextType scriptContextType = this.scriptContextType;
        if (scriptContextType != null) {
            i16 = scriptContextType.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        String str = this.scriptName;
        if (str != null) {
            i17 = str.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        String str2 = this.scriptPath;
        if (str2 != null) {
            i18 = str2.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        long j3 = this.readTimeMs;
        int i36 = (i29 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j16 = this.readCodeCacheTimeMs;
        int i37 = (i36 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.compileTimeMs;
        int i38 = (i37 + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        long j18 = this.executeTimeMs;
        int i39 = (i38 + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        String str3 = this.exception;
        if (str3 != null) {
            i19 = str3.hashCode();
        }
        int i46 = (i39 + i19) * 31;
        long j19 = this.startTime;
        return i46 + ((int) (j19 ^ (j19 >>> 32)));
    }

    @NotNull
    public String toString() {
        return "ScriptLoadStatistic(loadResult=" + this.loadResult + ", scriptContextType=" + this.scriptContextType + ", scriptName=" + this.scriptName + ", scriptPath=" + this.scriptPath + ", readTimeMs=" + this.readTimeMs + ", readCodeCacheTimeMs=" + this.readCodeCacheTimeMs + ", compileTimeMs=" + this.compileTimeMs + ", executeTimeMs=" + this.executeTimeMs + ", exception=" + this.exception + ", startTime=" + this.startTime + ")";
    }

    public /* synthetic */ ScriptLoadStatistic(ScriptLoadResult scriptLoadResult, ScriptContextType scriptContextType, String str, String str2, long j3, long j16, long j17, long j18, String str3, long j19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(scriptLoadResult, scriptContextType, str, str2, j3, j16, j17, j18, str3, (i3 & 512) != 0 ? 0L : j19);
    }
}
