package ij1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lij1/o;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "d", "(I)V", "redPointType", "c", "count", "<init>", "(II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ij1.o, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildNoticeBlockRedPoint {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int redPointType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int count;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuildNoticeBlockRedPoint() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    /* renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: b, reason: from getter */
    public final int getRedPointType() {
        return this.redPointType;
    }

    public final void c(int i3) {
        this.count = i3;
    }

    public final void d(int i3) {
        this.redPointType = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildNoticeBlockRedPoint)) {
            return false;
        }
        GuildNoticeBlockRedPoint guildNoticeBlockRedPoint = (GuildNoticeBlockRedPoint) other;
        if (this.redPointType == guildNoticeBlockRedPoint.redPointType && this.count == guildNoticeBlockRedPoint.count) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.redPointType * 31) + this.count;
    }

    @NotNull
    public String toString() {
        return "GuildNoticeBlockRedPoint(redPointType=" + this.redPointType + ", count=" + this.count + ")";
    }

    public GuildNoticeBlockRedPoint(int i3, int i16) {
        this.redPointType = i3;
        this.count = i16;
    }

    public /* synthetic */ GuildNoticeBlockRedPoint(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16);
    }
}
