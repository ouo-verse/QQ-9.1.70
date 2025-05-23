package com.tencent.mobileqq.vas.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u00a2\u0006\u0004\b\u0018\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0011\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/data/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getUin", "()J", "setUin", "(J)V", "uin", "b", "Z", "isOnSelfRoom", "()Z", "c", "(Z)V", "isFull", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.data.f, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class SmallHomeStatus {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isOnSelfRoom;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isFull;

    public SmallHomeStatus() {
        this(0L, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsFull() {
        return this.isFull;
    }

    public final void b(boolean z16) {
        this.isFull = z16;
    }

    public final void c(boolean z16) {
        this.isOnSelfRoom = z16;
    }

    public int hashCode() {
        return com.tencent.mobileqq.vas.banner.c.a(this.uin);
    }

    public String toString() {
        return "SmallHomeStatus(uin=" + this.uin + ")";
    }

    public SmallHomeStatus(long j3) {
        this.uin = j3;
    }

    public /* synthetic */ SmallHomeStatus(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SmallHomeStatus) && this.uin == ((SmallHomeStatus) other).uin;
    }
}
