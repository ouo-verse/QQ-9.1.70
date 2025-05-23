package fh1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lfh1/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "priority", "b", "getState", "state", "<init>", "(II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: fh1.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class FeedChannelStateInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int priority;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int state;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FeedChannelStateInfo() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    /* renamed from: a, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedChannelStateInfo)) {
            return false;
        }
        FeedChannelStateInfo feedChannelStateInfo = (FeedChannelStateInfo) other;
        if (this.priority == feedChannelStateInfo.priority && this.state == feedChannelStateInfo.state) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.priority * 31) + this.state;
    }

    @NotNull
    public String toString() {
        return "FeedChannelStateInfo(priority=" + this.priority + ", state=" + this.state + ")";
    }

    public FeedChannelStateInfo(int i3, int i16) {
        this.priority = i3;
        this.state = i16;
    }

    public /* synthetic */ FeedChannelStateInfo(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? -1 : i16);
    }
}
