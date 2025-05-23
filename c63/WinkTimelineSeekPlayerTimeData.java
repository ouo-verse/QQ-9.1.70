package c63;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lc63/b;", "", "", "a", "", "b", "", "toString", "", "hashCode", "other", "equals", "J", "c", "()J", "time", "Z", "getNeedScroll", "()Z", "needScroll", "<init>", "(JZ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: c63.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkTimelineSeekPlayerTimeData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long time;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needScroll;

    public WinkTimelineSeekPlayerTimeData(long j3, boolean z16) {
        this.time = j3;
        this.needScroll = z16;
    }

    /* renamed from: a, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedScroll() {
        return this.needScroll;
    }

    public final long c() {
        return this.time;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkTimelineSeekPlayerTimeData)) {
            return false;
        }
        WinkTimelineSeekPlayerTimeData winkTimelineSeekPlayerTimeData = (WinkTimelineSeekPlayerTimeData) other;
        if (this.time == winkTimelineSeekPlayerTimeData.time && this.needScroll == winkTimelineSeekPlayerTimeData.needScroll) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = androidx.fragment.app.a.a(this.time) * 31;
        boolean z16 = this.needScroll;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return a16 + i3;
    }

    @NotNull
    public String toString() {
        return "WinkTimelineSeekPlayerTimeData(time=" + this.time + ", needScroll=" + this.needScroll + ")";
    }
}
