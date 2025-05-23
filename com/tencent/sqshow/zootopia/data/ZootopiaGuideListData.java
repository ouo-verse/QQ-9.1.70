package com.tencent.sqshow.zootopia.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lpv4/f;", "a", "Ljava/util/List;", "getGuideList", "()Ljava/util/List;", "setGuideList", "(Ljava/util/List;)V", "guideList", "b", "Z", "getCheckGuideStatus", "()Z", "setCheckGuideStatus", "(Z)V", "checkGuideStatus", "<init>", "(Ljava/util/List;Z)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.j, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaGuideListData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private List<pv4.f> guideList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean checkGuideStatus;

    public ZootopiaGuideListData() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.guideList.hashCode() * 31;
        boolean z16 = this.checkGuideStatus;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "ZootopiaGuideListData(guideList=" + this.guideList + ", checkGuideStatus=" + this.checkGuideStatus + ")";
    }

    public ZootopiaGuideListData(List<pv4.f> guideList, boolean z16) {
        Intrinsics.checkNotNullParameter(guideList, "guideList");
        this.guideList = guideList;
        this.checkGuideStatus = z16;
    }

    public /* synthetic */ ZootopiaGuideListData(List list, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? false : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaGuideListData)) {
            return false;
        }
        ZootopiaGuideListData zootopiaGuideListData = (ZootopiaGuideListData) other;
        return Intrinsics.areEqual(this.guideList, zootopiaGuideListData.guideList) && this.checkGuideStatus == zootopiaGuideListData.checkGuideStatus;
    }
}
