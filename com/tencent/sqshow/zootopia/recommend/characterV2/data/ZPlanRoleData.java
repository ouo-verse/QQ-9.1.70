package com.tencent.sqshow.zootopia.recommend.characterV2.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0011\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lpv4/s;", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "rightBtnData", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/b;", "b", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/b;", "()Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/b;", "floatBannerData", "Ljava/lang/String;", "()Ljava/lang/String;", "from", "<init>", "(Ljava/util/List;Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/b;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.recommend.characterV2.data.d, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanRoleData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<s> rightBtnData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanFloatBannerData floatBannerData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String from;

    public ZPlanRoleData() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final ZPlanFloatBannerData getFloatBannerData() {
        return this.floatBannerData;
    }

    /* renamed from: b, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    public final List<s> c() {
        return this.rightBtnData;
    }

    public int hashCode() {
        return (((this.rightBtnData.hashCode() * 31) + this.floatBannerData.hashCode()) * 31) + this.from.hashCode();
    }

    public String toString() {
        return "ZPlanRoleData(rightBtnData=" + this.rightBtnData + ", floatBannerData=" + this.floatBannerData + ", from=" + this.from + ")";
    }

    public ZPlanRoleData(List<s> rightBtnData, ZPlanFloatBannerData floatBannerData, String from) {
        Intrinsics.checkNotNullParameter(rightBtnData, "rightBtnData");
        Intrinsics.checkNotNullParameter(floatBannerData, "floatBannerData");
        Intrinsics.checkNotNullParameter(from, "from");
        this.rightBtnData = rightBtnData;
        this.floatBannerData = floatBannerData;
        this.from = from;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanRoleData)) {
            return false;
        }
        ZPlanRoleData zPlanRoleData = (ZPlanRoleData) other;
        return Intrinsics.areEqual(this.rightBtnData, zPlanRoleData.rightBtnData) && Intrinsics.areEqual(this.floatBannerData, zPlanRoleData.floatBannerData) && Intrinsics.areEqual(this.from, zPlanRoleData.from);
    }

    public /* synthetic */ ZPlanRoleData(List list, ZPlanFloatBannerData zPlanFloatBannerData, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? ZPlanFloatBannerData.INSTANCE.a() : zPlanFloatBannerData, (i3 & 4) != 0 ? "init" : str);
    }
}
