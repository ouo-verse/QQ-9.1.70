package com.tencent.sqshow.zootopia.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0019\u0010\f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/o;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "moduleId", "b", "currentPageIndex", "", "Lpv4/h;", "Ljava/util/List;", "d", "()Ljava/util/List;", "partyRoomList", "Z", "()Z", "hasMore", "e", "refreshInterval", "<init>", "(IILjava/util/List;ZI)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.o, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaPartyRoomData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int moduleId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int currentPageIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<pv4.h> partyRoomList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasMore;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int refreshInterval;

    public ZootopiaPartyRoomData(int i3, int i16, List<pv4.h> partyRoomList, boolean z16, int i17) {
        Intrinsics.checkNotNullParameter(partyRoomList, "partyRoomList");
        this.moduleId = i3;
        this.currentPageIndex = i16;
        this.partyRoomList = partyRoomList;
        this.hasMore = z16;
        this.refreshInterval = i17;
    }

    /* renamed from: a, reason: from getter */
    public final int getCurrentPageIndex() {
        return this.currentPageIndex;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: c, reason: from getter */
    public final int getModuleId() {
        return this.moduleId;
    }

    public final List<pv4.h> d() {
        return this.partyRoomList;
    }

    /* renamed from: e, reason: from getter */
    public final int getRefreshInterval() {
        return this.refreshInterval;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.moduleId * 31) + this.currentPageIndex) * 31) + this.partyRoomList.hashCode()) * 31;
        boolean z16 = this.hasMore;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.refreshInterval;
    }

    public String toString() {
        return "ZootopiaPartyRoomData(moduleId=" + this.moduleId + ", currentPageIndex=" + this.currentPageIndex + ", partyRoomList=" + this.partyRoomList + ", hasMore=" + this.hasMore + ", refreshInterval=" + this.refreshInterval + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaPartyRoomData)) {
            return false;
        }
        ZootopiaPartyRoomData zootopiaPartyRoomData = (ZootopiaPartyRoomData) other;
        return this.moduleId == zootopiaPartyRoomData.moduleId && this.currentPageIndex == zootopiaPartyRoomData.currentPageIndex && Intrinsics.areEqual(this.partyRoomList, zootopiaPartyRoomData.partyRoomList) && this.hasMore == zootopiaPartyRoomData.hasMore && this.refreshInterval == zootopiaPartyRoomData.refreshInterval;
    }
}
