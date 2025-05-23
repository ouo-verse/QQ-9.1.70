package my4;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lmy4/a;", "", "", "toString", "", "c", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "d", "(J)V", "beginTime", "b", "f", "endTime", "getDuration", "e", "duration", "<init>", "(JJJ)V", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: my4.a, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class EarbackTimeSlot {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long beginTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long endTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long duration;

    public EarbackTimeSlot() {
        this(0L, 0L, 0L, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getBeginTime() {
        return this.beginTime;
    }

    /* renamed from: b, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    public final void c() {
        this.beginTime = Long.MIN_VALUE;
        this.endTime = Long.MIN_VALUE;
    }

    public final void d(long j3) {
        this.beginTime = j3;
    }

    public final void e(long j3) {
        this.duration = j3;
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (this != other) {
            if (other instanceof EarbackTimeSlot) {
                EarbackTimeSlot earbackTimeSlot = (EarbackTimeSlot) other;
                if (this.beginTime == earbackTimeSlot.beginTime) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (this.endTime == earbackTimeSlot.endTime) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        if (this.duration == earbackTimeSlot.duration) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void f(long j3) {
        this.endTime = j3;
    }

    public int hashCode() {
        return (((androidx.fragment.app.a.a(this.beginTime) * 31) + androidx.fragment.app.a.a(this.endTime)) * 31) + androidx.fragment.app.a.a(this.duration);
    }

    @NotNull
    public String toString() {
        return "EarbackTimeSlot(beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", duration=" + this.duration + ')';
    }

    public EarbackTimeSlot(long j3, long j16, long j17) {
        this.beginTime = j3;
        this.endTime = j16;
        this.duration = j17;
    }

    public /* synthetic */ EarbackTimeSlot(long j3, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1L : j3, (i3 & 2) == 0 ? j16 : -1L, (i3 & 4) != 0 ? 0L : j17);
    }
}
