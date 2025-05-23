package af4;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Laf4/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "recentTaskWatchTime", "numOfAvailableTask", "c", "taskUnionStatusOfToday", "<init>", "(III)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: af4.b, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class BatteryOperationData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int recentTaskWatchTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int numOfAvailableTask;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int taskUnionStatusOfToday;

    public BatteryOperationData(int i3, int i16, int i17) {
        this.recentTaskWatchTime = i3;
        this.numOfAvailableTask = i16;
        this.taskUnionStatusOfToday = i17;
    }

    /* renamed from: a, reason: from getter */
    public final int getNumOfAvailableTask() {
        return this.numOfAvailableTask;
    }

    /* renamed from: b, reason: from getter */
    public final int getRecentTaskWatchTime() {
        return this.recentTaskWatchTime;
    }

    /* renamed from: c, reason: from getter */
    public final int getTaskUnionStatusOfToday() {
        return this.taskUnionStatusOfToday;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatteryOperationData)) {
            return false;
        }
        BatteryOperationData batteryOperationData = (BatteryOperationData) other;
        if (this.recentTaskWatchTime == batteryOperationData.recentTaskWatchTime && this.numOfAvailableTask == batteryOperationData.numOfAvailableTask && this.taskUnionStatusOfToday == batteryOperationData.taskUnionStatusOfToday) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.recentTaskWatchTime * 31) + this.numOfAvailableTask) * 31) + this.taskUnionStatusOfToday;
    }

    @NotNull
    public String toString() {
        return "BatteryOperationData(recentTaskWatchTime=" + this.recentTaskWatchTime + ", numOfAvailableTask=" + this.numOfAvailableTask + ", taskUnionStatusOfToday=" + this.taskUnionStatusOfToday + ")";
    }
}
