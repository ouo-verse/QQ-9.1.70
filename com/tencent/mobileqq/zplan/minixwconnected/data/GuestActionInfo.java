package com.tencent.mobileqq.zplan.minixwconnected.data;

import com.heytap.databaseengine.apiv3.data.Element;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/data/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "guestUin", "I", "()I", "guestActionId", "c", "d", "(I)V", Element.ELEMENT_NAME_TIMES, "<init>", "(JII)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minixwconnected.data.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class GuestActionInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long guestUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int guestActionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int times;

    public GuestActionInfo(long j3, int i3, int i16) {
        this.guestUin = j3;
        this.guestActionId = i3;
        this.times = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getGuestActionId() {
        return this.guestActionId;
    }

    /* renamed from: b, reason: from getter */
    public final long getGuestUin() {
        return this.guestUin;
    }

    /* renamed from: c, reason: from getter */
    public final int getTimes() {
        return this.times;
    }

    public final void d(int i3) {
        this.times = i3;
    }

    public int hashCode() {
        return (((com.tencent.mobileqq.vas.banner.c.a(this.guestUin) * 31) + this.guestActionId) * 31) + this.times;
    }

    public String toString() {
        return "GuestActionInfo(guestUin=" + this.guestUin + ", guestActionId=" + this.guestActionId + ", times=" + this.times + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuestActionInfo)) {
            return false;
        }
        GuestActionInfo guestActionInfo = (GuestActionInfo) other;
        return this.guestUin == guestActionInfo.guestUin && this.guestActionId == guestActionInfo.guestActionId && this.times == guestActionInfo.times;
    }
}
