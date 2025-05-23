package com.tencent.sqshow.zootopia.operation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "e", "(J)V", "todayFirstShowMilliSeconds", "b", "I", "()I", "f", "(I)V", "todayShowTimes", "c", "g", "totalFirstShowSeconds", "d", h.F, "totalShowTimes", "<init>", "(JIJI)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.operation.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ConditionsCache {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long todayFirstShowMilliSeconds;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int todayShowTimes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long totalFirstShowSeconds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int totalShowTimes;

    public ConditionsCache() {
        this(0L, 0, 0L, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getTodayFirstShowMilliSeconds() {
        return this.todayFirstShowMilliSeconds;
    }

    /* renamed from: b, reason: from getter */
    public final int getTodayShowTimes() {
        return this.todayShowTimes;
    }

    /* renamed from: c, reason: from getter */
    public final long getTotalFirstShowSeconds() {
        return this.totalFirstShowSeconds;
    }

    /* renamed from: d, reason: from getter */
    public final int getTotalShowTimes() {
        return this.totalShowTimes;
    }

    public final void e(long j3) {
        this.todayFirstShowMilliSeconds = j3;
    }

    public final void f(int i3) {
        this.todayShowTimes = i3;
    }

    public final void g(long j3) {
        this.totalFirstShowSeconds = j3;
    }

    public final void h(int i3) {
        this.totalShowTimes = i3;
    }

    public int hashCode() {
        return (((((com.tencent.mobileqq.vas.banner.c.a(this.todayFirstShowMilliSeconds) * 31) + this.todayShowTimes) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.totalFirstShowSeconds)) * 31) + this.totalShowTimes;
    }

    public String toString() {
        return "ConditionsCache(todayFirstShowMilliSeconds=" + this.todayFirstShowMilliSeconds + ", todayShowTimes=" + this.todayShowTimes + ", totalFirstShowSeconds=" + this.totalFirstShowSeconds + ", totalShowTimes=" + this.totalShowTimes + ")";
    }

    public ConditionsCache(long j3, int i3, long j16, int i16) {
        this.todayFirstShowMilliSeconds = j3;
        this.todayShowTimes = i3;
        this.totalFirstShowSeconds = j16;
        this.totalShowTimes = i16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConditionsCache)) {
            return false;
        }
        ConditionsCache conditionsCache = (ConditionsCache) other;
        return this.todayFirstShowMilliSeconds == conditionsCache.todayFirstShowMilliSeconds && this.todayShowTimes == conditionsCache.todayShowTimes && this.totalFirstShowSeconds == conditionsCache.totalFirstShowSeconds && this.totalShowTimes == conditionsCache.totalShowTimes;
    }

    public /* synthetic */ ConditionsCache(long j3, int i3, long j16, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0L : j3, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) == 0 ? j16 : 0L, (i17 & 8) != 0 ? 0 : i16);
    }
}
