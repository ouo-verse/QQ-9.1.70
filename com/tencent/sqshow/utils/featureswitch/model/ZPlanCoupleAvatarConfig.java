package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/r;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "map", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "", "duration", "J", "getDuration", "()J", "<init>", "(Ljava/util/Map;J)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.r, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanCoupleAvatarConfig {

    @SerializedName("sceneConfigCacheDuration")
    private final long duration;

    @SerializedName("defaultRelationTypeToSceneMappingTable")
    private final Map<String, Integer> map;

    public ZPlanCoupleAvatarConfig() {
        this(null, 0L, 3, null);
    }

    public final Map<String, Integer> a() {
        return this.map;
    }

    public int hashCode() {
        return (this.map.hashCode() * 31) + com.tencent.mobileqq.vas.banner.c.a(this.duration);
    }

    public String toString() {
        return "ZPlanCoupleAvatarConfig(map=" + this.map + ", duration=" + this.duration + ')';
    }

    public ZPlanCoupleAvatarConfig(Map<String, Integer> map, long j3) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
        this.duration = j3;
    }

    public /* synthetic */ ZPlanCoupleAvatarConfig(Map map, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i3 & 2) != 0 ? 0L : j3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanCoupleAvatarConfig)) {
            return false;
        }
        ZPlanCoupleAvatarConfig zPlanCoupleAvatarConfig = (ZPlanCoupleAvatarConfig) other;
        return Intrinsics.areEqual(this.map, zPlanCoupleAvatarConfig.map) && this.duration == zPlanCoupleAvatarConfig.duration;
    }
}
