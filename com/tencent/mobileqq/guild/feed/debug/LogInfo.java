package com.tencent.mobileqq.guild.feed.debug;

import com.heytap.databaseengine.apiv3.data.Element;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/debug/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "c", "(J)V", Element.ELEMENT_NAME_TIMES, "b", "d", "totalLength", "<init>", "(JJ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.debug.k, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class LogInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long times;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long totalLength;

    public LogInfo() {
        this(0L, 0L, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getTimes() {
        return this.times;
    }

    /* renamed from: b, reason: from getter */
    public final long getTotalLength() {
        return this.totalLength;
    }

    public final void c(long j3) {
        this.times = j3;
    }

    public final void d(long j3) {
        this.totalLength = j3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogInfo)) {
            return false;
        }
        LogInfo logInfo = (LogInfo) other;
        if (this.times == logInfo.times && this.totalLength == logInfo.totalLength) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.times) * 31) + androidx.fragment.app.a.a(this.totalLength);
    }

    @NotNull
    public String toString() {
        return "LogInfo(times=" + this.times + ", totalLength=" + this.totalLength + ")";
    }

    public LogInfo(long j3, long j16) {
        this.times = j3;
        this.totalLength = j16;
    }

    public /* synthetic */ LogInfo(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16);
    }
}
