package com.tencent.sqshow.zootopia.samestyle;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanVideoClipInfo;", "Ljava/io/Serializable;", "coverUrl", "", "startTime", "", "duration", "(Ljava/lang/String;JJ)V", "getCoverUrl", "()Ljava/lang/String;", "getDuration", "()J", "getStartTime", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final /* data */ class ZPlanVideoClipInfo implements Serializable {
    private final String coverUrl;
    private final long duration;
    private final long startTime;

    public ZPlanVideoClipInfo(String coverUrl, long j3, long j16) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        this.coverUrl = coverUrl;
        this.startTime = j3;
        this.duration = j16;
    }

    /* renamed from: component1, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    public final ZPlanVideoClipInfo copy(String coverUrl, long startTime, long duration) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        return new ZPlanVideoClipInfo(coverUrl, startTime, duration);
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return (((this.coverUrl.hashCode() * 31) + com.tencent.mobileqq.vas.banner.c.a(this.startTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.duration);
    }

    public String toString() {
        return "ZPlanVideoClipInfo(coverUrl=" + this.coverUrl + ", startTime=" + this.startTime + ", duration=" + this.duration + ")";
    }

    public static /* synthetic */ ZPlanVideoClipInfo copy$default(ZPlanVideoClipInfo zPlanVideoClipInfo, String str, long j3, long j16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = zPlanVideoClipInfo.coverUrl;
        }
        if ((i3 & 2) != 0) {
            j3 = zPlanVideoClipInfo.startTime;
        }
        long j17 = j3;
        if ((i3 & 4) != 0) {
            j16 = zPlanVideoClipInfo.duration;
        }
        return zPlanVideoClipInfo.copy(str, j17, j16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanVideoClipInfo)) {
            return false;
        }
        ZPlanVideoClipInfo zPlanVideoClipInfo = (ZPlanVideoClipInfo) other;
        return Intrinsics.areEqual(this.coverUrl, zPlanVideoClipInfo.coverUrl) && this.startTime == zPlanVideoClipInfo.startTime && this.duration == zPlanVideoClipInfo.duration;
    }
}
