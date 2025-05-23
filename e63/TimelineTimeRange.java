package e63;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Le63/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "startTime", "duration", "<init>", "(JJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e63.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class TimelineTimeRange {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long startTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long duration;

    public TimelineTimeRange(long j3, long j16) {
        this.startTime = j3;
        this.duration = j16;
    }

    /* renamed from: a, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: b, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimelineTimeRange)) {
            return false;
        }
        TimelineTimeRange timelineTimeRange = (TimelineTimeRange) other;
        if (this.startTime == timelineTimeRange.startTime && this.duration == timelineTimeRange.duration) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.startTime) * 31) + androidx.fragment.app.a.a(this.duration);
    }

    @NotNull
    public String toString() {
        return "TimelineTimeRange(startTime=" + this.startTime + ", duration=" + this.duration + ")";
    }
}
