package com.tencent.mobileqq.guild.live.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/live/helper/d;", "", "", "b", "", "toString", "", "hashCode", "other", "", "equals", "a", "J", "getStart", "()J", "start", "c", "(J)V", "end", "<init>", "(JJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.live.helper.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildTimeRecord {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long start;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long end;

    public GuildTimeRecord(long j3, long j16) {
        this.start = j3;
        this.end = j16;
    }

    /* renamed from: a, reason: from getter */
    public final long getEnd() {
        return this.end;
    }

    public final long b() {
        long j3 = this.start;
        if (j3 >= 0) {
            long j16 = this.end;
            if (j16 >= 0 && j3 <= j16) {
                return j16 - j3;
            }
        }
        return -1L;
    }

    public final void c(long j3) {
        this.end = j3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildTimeRecord)) {
            return false;
        }
        GuildTimeRecord guildTimeRecord = (GuildTimeRecord) other;
        if (this.start == guildTimeRecord.start && this.end == guildTimeRecord.end) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.start) * 31) + androidx.fragment.app.a.a(this.end);
    }

    @NotNull
    public String toString() {
        return "GuildTimeRecord(start=" + this.start + ", end=" + this.end + ")";
    }

    public /* synthetic */ GuildTimeRecord(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? 0L : j16);
    }
}
