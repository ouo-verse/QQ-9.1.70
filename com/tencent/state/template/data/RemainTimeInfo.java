package com.tencent.state.template.data;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00d6\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/template/data/RemainTimeInfo;", "", "sitDownStartTs", "", "heartbeatLastTs", "maxLifeSeconds", "", "(JJI)V", "getHeartbeatLastTs", "()J", "getMaxLifeSeconds", "()I", "getSitDownStartTs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class RemainTimeInfo {
    private final long heartbeatLastTs;
    private final int maxLifeSeconds;
    private final long sitDownStartTs;

    public RemainTimeInfo(long j3, long j16, int i3) {
        this.sitDownStartTs = j3;
        this.heartbeatLastTs = j16;
        this.maxLifeSeconds = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final long getSitDownStartTs() {
        return this.sitDownStartTs;
    }

    /* renamed from: component2, reason: from getter */
    public final long getHeartbeatLastTs() {
        return this.heartbeatLastTs;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxLifeSeconds() {
        return this.maxLifeSeconds;
    }

    public final RemainTimeInfo copy(long sitDownStartTs, long heartbeatLastTs, int maxLifeSeconds) {
        return new RemainTimeInfo(sitDownStartTs, heartbeatLastTs, maxLifeSeconds);
    }

    public final long getHeartbeatLastTs() {
        return this.heartbeatLastTs;
    }

    public final int getMaxLifeSeconds() {
        return this.maxLifeSeconds;
    }

    public final long getSitDownStartTs() {
        return this.sitDownStartTs;
    }

    public int hashCode() {
        return (((c.a(this.sitDownStartTs) * 31) + c.a(this.heartbeatLastTs)) * 31) + this.maxLifeSeconds;
    }

    public String toString() {
        return "{f:" + this.sitDownStartTs + ", h:" + this.heartbeatLastTs + ", m:" + this.maxLifeSeconds + ", c:" + (System.currentTimeMillis() / 1000) + '}';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemainTimeInfo)) {
            return false;
        }
        RemainTimeInfo remainTimeInfo = (RemainTimeInfo) other;
        return this.sitDownStartTs == remainTimeInfo.sitDownStartTs && this.heartbeatLastTs == remainTimeInfo.heartbeatLastTs && this.maxLifeSeconds == remainTimeInfo.maxLifeSeconds;
    }

    public static /* synthetic */ RemainTimeInfo copy$default(RemainTimeInfo remainTimeInfo, long j3, long j16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            j3 = remainTimeInfo.sitDownStartTs;
        }
        long j17 = j3;
        if ((i16 & 2) != 0) {
            j16 = remainTimeInfo.heartbeatLastTs;
        }
        long j18 = j16;
        if ((i16 & 4) != 0) {
            i3 = remainTimeInfo.maxLifeSeconds;
        }
        return remainTimeInfo.copy(j17, j18, i3);
    }
}
