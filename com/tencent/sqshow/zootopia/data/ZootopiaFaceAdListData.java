package com.tencent.sqshow.zootopia.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lnw4/h;", "a", "Ljava/util/List;", "()Ljava/util/List;", "setFaceAdList", "(Ljava/util/List;)V", "faceAdList", "<init>", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.i, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaFaceAdListData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private List<nw4.h> faceAdList;

    public ZootopiaFaceAdListData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List<nw4.h> a() {
        return this.faceAdList;
    }

    public int hashCode() {
        return this.faceAdList.hashCode();
    }

    public String toString() {
        return "ZootopiaFaceAdListData(faceAdList=" + this.faceAdList + ")";
    }

    public ZootopiaFaceAdListData(List<nw4.h> faceAdList) {
        Intrinsics.checkNotNullParameter(faceAdList, "faceAdList");
        this.faceAdList = faceAdList;
    }

    public /* synthetic */ ZootopiaFaceAdListData(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ZootopiaFaceAdListData) && Intrinsics.areEqual(this.faceAdList, ((ZootopiaFaceAdListData) other).faceAdList);
    }
}
