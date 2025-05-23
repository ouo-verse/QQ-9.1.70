package com.tencent.richframework.argus;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/richframework/argus/MonitorData;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "startTime", "J", "getStartTime", "()J", "startFpsIndex", "I", "getStartFpsIndex", "()I", "<init>", "(JI)V", "argus-monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class MonitorData {
    private final int startFpsIndex;
    private final long startTime;

    public MonitorData(long j3, int i3) {
        this.startTime = j3;
        this.startFpsIndex = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MonitorData) {
                MonitorData monitorData = (MonitorData) other;
                if (this.startTime != monitorData.startTime || this.startFpsIndex != monitorData.startFpsIndex) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getStartFpsIndex() {
        return this.startFpsIndex;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        long j3 = this.startTime;
        return (((int) (j3 ^ (j3 >>> 32))) * 31) + this.startFpsIndex;
    }

    @NotNull
    public String toString() {
        return "MonitorData(startTime=" + this.startTime + ", startFpsIndex=" + this.startFpsIndex + ")";
    }
}
