package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/aa;", "", "", "toString", "", "hashCode", "other", "", "equals", "enableIntermittentFetch", "Z", "getEnableIntermittentFetch", "()Z", "", "duration", "J", "getDuration", "()J", "<init>", "(ZJ)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.aa, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanIntermittentFetchCoupleProfileConfig {

    @SerializedName("fetch_duration_millisecond")
    private final long duration;

    @SerializedName("enable_intermittent_fetch")
    private final boolean enableIntermittentFetch;

    public ZPlanIntermittentFetchCoupleProfileConfig() {
        this(false, 0L, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.enableIntermittentFetch;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + com.tencent.mobileqq.vas.banner.c.a(this.duration);
    }

    public String toString() {
        return "ZPlanIntermittentFetchCoupleProfileConfig(enableIntermittentFetch=" + this.enableIntermittentFetch + ", duration=" + this.duration + ')';
    }

    public ZPlanIntermittentFetchCoupleProfileConfig(boolean z16, long j3) {
        this.enableIntermittentFetch = z16;
        this.duration = j3;
    }

    public /* synthetic */ ZPlanIntermittentFetchCoupleProfileConfig(boolean z16, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? 2100000L : j3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanIntermittentFetchCoupleProfileConfig)) {
            return false;
        }
        ZPlanIntermittentFetchCoupleProfileConfig zPlanIntermittentFetchCoupleProfileConfig = (ZPlanIntermittentFetchCoupleProfileConfig) other;
        return this.enableIntermittentFetch == zPlanIntermittentFetchCoupleProfileConfig.enableIntermittentFetch && this.duration == zPlanIntermittentFetchCoupleProfileConfig.duration;
    }
}
