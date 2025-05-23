package com.tencent.mobileqq.zplan.maintenance;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/maintenance/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/zplan/model/i;", "mMaintenanceInfo", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.maintenance.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanManageMaintConfig {

    @SerializedName("MaintenanceInfo")
    private final Map<String, ZPlanMaintInfo> mMaintenanceInfo;

    public ZPlanManageMaintConfig(Map<String, ZPlanMaintInfo> mMaintenanceInfo) {
        Intrinsics.checkNotNullParameter(mMaintenanceInfo, "mMaintenanceInfo");
        this.mMaintenanceInfo = mMaintenanceInfo;
    }

    public final Map<String, ZPlanMaintInfo> a() {
        return this.mMaintenanceInfo;
    }

    public int hashCode() {
        return this.mMaintenanceInfo.hashCode();
    }

    public String toString() {
        return "ZPlanManageMaintConfig(mMaintenanceInfo=" + this.mMaintenanceInfo + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ZPlanManageMaintConfig() {
        this(r0);
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ZPlanManageMaintConfig) && Intrinsics.areEqual(this.mMaintenanceInfo, ((ZPlanManageMaintConfig) other).mMaintenanceInfo);
    }
}
