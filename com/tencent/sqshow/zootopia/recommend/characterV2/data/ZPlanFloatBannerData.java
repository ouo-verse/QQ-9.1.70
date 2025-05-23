package com.tencent.sqshow.zootopia.recommend.characterV2.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\nB5\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/b;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "a", "I", "getModuleId", "()I", "moduleId", "b", "Ljava/lang/String;", "getTabConfig", "()Ljava/lang/String;", "tabConfig", "c", "turnInterval", "", "Lpv4/s;", "Ljava/util/List;", "()Ljava/util/List;", "bannerList", "<init>", "(ILjava/lang/String;ILjava/util/List;)V", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.recommend.characterV2.data.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanFloatBannerData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final ZPlanFloatBannerData f372482f = new ZPlanFloatBannerData(0, null, 0, null, 15, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int moduleId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String tabConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int turnInterval;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<s> bannerList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/b$a;", "", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/b;", "DEFAULT", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/b;", "a", "()Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/b;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.recommend.characterV2.data.b$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanFloatBannerData a() {
            return ZPlanFloatBannerData.f372482f;
        }

        Companion() {
        }
    }

    public ZPlanFloatBannerData() {
        this(0, null, 0, null, 15, null);
    }

    public final List<s> b() {
        return this.bannerList;
    }

    /* renamed from: c, reason: from getter */
    public final int getTurnInterval() {
        return this.turnInterval;
    }

    public final boolean d() {
        List<s> list = this.bannerList;
        return !(list == null || list.isEmpty());
    }

    public int hashCode() {
        return (((((this.moduleId * 31) + this.tabConfig.hashCode()) * 31) + this.turnInterval) * 31) + this.bannerList.hashCode();
    }

    public String toString() {
        return "ZPlanFloatBannerData(moduleId=" + this.moduleId + ", tabConfig=" + this.tabConfig + ", turnInterval=" + this.turnInterval + ", bannerList=" + this.bannerList + ")";
    }

    public ZPlanFloatBannerData(int i3, String tabConfig, int i16, List<s> bannerList) {
        Intrinsics.checkNotNullParameter(tabConfig, "tabConfig");
        Intrinsics.checkNotNullParameter(bannerList, "bannerList");
        this.moduleId = i3;
        this.tabConfig = tabConfig;
        this.turnInterval = i16;
        this.bannerList = bannerList;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanFloatBannerData)) {
            return false;
        }
        ZPlanFloatBannerData zPlanFloatBannerData = (ZPlanFloatBannerData) other;
        return this.moduleId == zPlanFloatBannerData.moduleId && Intrinsics.areEqual(this.tabConfig, zPlanFloatBannerData.tabConfig) && this.turnInterval == zPlanFloatBannerData.turnInterval && Intrinsics.areEqual(this.bannerList, zPlanFloatBannerData.bannerList);
    }

    public /* synthetic */ ZPlanFloatBannerData(int i3, String str, int i16, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
