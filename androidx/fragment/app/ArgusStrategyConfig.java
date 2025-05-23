package androidx.fragment.app;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Landroidx/fragment/app/ArgusStrategyConfig;", "", "predictPastMinutes", "", "recordClearPastMinutes", "minChangeGroupMill", "(JJJ)V", "getMinChangeGroupMill", "()J", "getPredictPastMinutes", "getRecordClearPastMinutes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final /* data */ class ArgusStrategyConfig {
    private final long minChangeGroupMill;
    private final long predictPastMinutes;
    private final long recordClearPastMinutes;

    public ArgusStrategyConfig() {
        this(0L, 0L, 0L, 7, null);
    }

    public static /* synthetic */ ArgusStrategyConfig copy$default(ArgusStrategyConfig argusStrategyConfig, long j3, long j16, long j17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = argusStrategyConfig.predictPastMinutes;
        }
        long j18 = j3;
        if ((i3 & 2) != 0) {
            j16 = argusStrategyConfig.recordClearPastMinutes;
        }
        long j19 = j16;
        if ((i3 & 4) != 0) {
            j17 = argusStrategyConfig.minChangeGroupMill;
        }
        return argusStrategyConfig.copy(j18, j19, j17);
    }

    /* renamed from: component1, reason: from getter */
    public final long getPredictPastMinutes() {
        return this.predictPastMinutes;
    }

    /* renamed from: component2, reason: from getter */
    public final long getRecordClearPastMinutes() {
        return this.recordClearPastMinutes;
    }

    /* renamed from: component3, reason: from getter */
    public final long getMinChangeGroupMill() {
        return this.minChangeGroupMill;
    }

    @NotNull
    public final ArgusStrategyConfig copy(long predictPastMinutes, long recordClearPastMinutes, long minChangeGroupMill) {
        return new ArgusStrategyConfig(predictPastMinutes, recordClearPastMinutes, minChangeGroupMill);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ArgusStrategyConfig) {
                ArgusStrategyConfig argusStrategyConfig = (ArgusStrategyConfig) other;
                if (this.predictPastMinutes != argusStrategyConfig.predictPastMinutes || this.recordClearPastMinutes != argusStrategyConfig.recordClearPastMinutes || this.minChangeGroupMill != argusStrategyConfig.minChangeGroupMill) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getMinChangeGroupMill() {
        return this.minChangeGroupMill;
    }

    public final long getPredictPastMinutes() {
        return this.predictPastMinutes;
    }

    public final long getRecordClearPastMinutes() {
        return this.recordClearPastMinutes;
    }

    public int hashCode() {
        return (((a.a(this.predictPastMinutes) * 31) + a.a(this.recordClearPastMinutes)) * 31) + a.a(this.minChangeGroupMill);
    }

    @NotNull
    public String toString() {
        return "ArgusStrategyConfig(predictPastMinutes=" + this.predictPastMinutes + ", recordClearPastMinutes=" + this.recordClearPastMinutes + ", minChangeGroupMill=" + this.minChangeGroupMill + ")";
    }

    public ArgusStrategyConfig(long j3, long j16, long j17) {
        this.predictPastMinutes = j3;
        this.recordClearPastMinutes = j16;
        this.minChangeGroupMill = j17;
    }

    public /* synthetic */ ArgusStrategyConfig(long j3, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 4320L : j3, (i3 & 2) == 0 ? j16 : 4320L, (i3 & 4) != 0 ? 1500L : j17);
    }
}
