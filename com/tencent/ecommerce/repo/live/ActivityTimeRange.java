package com.tencent.ecommerce.repo.live;

import com.tencent.ark.ark;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u0013\b\u0016\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/repo/live/d;", "", "", "d", "", "beginSec", "endSec", "a", "", "toString", "", "hashCode", "other", "equals", "J", "b", "c", "()J", "<init>", "(JJ)V", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "(Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.d, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ActivityTimeRange {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long beginSec;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long endSec;

    public ActivityTimeRange(long j3, long j16) {
        this.beginSec = j3;
        this.endSec = j16;
    }

    public final ActivityTimeRange a(long beginSec, long endSec) {
        return new ActivityTimeRange(beginSec, endSec);
    }

    /* renamed from: c, reason: from getter */
    public final long getEndSec() {
        return this.endSec;
    }

    public final boolean d() {
        long j3 = this.beginSec;
        if (j3 <= 0) {
            return false;
        }
        long j16 = this.endSec;
        return j16 > 0 && j3 <= j16;
    }

    public int hashCode() {
        return (com.tencent.ecommerce.biz.commission.forecast.b.a(this.beginSec) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.endSec);
    }

    public String toString() {
        return "ActivityTimeRange(beginSec=" + this.beginSec + ", endSec=" + this.endSec + ")";
    }

    public ActivityTimeRange(JSONObject jSONObject) {
        this(jSONObject != null ? jSONObject.optLong("begin") : 0L, jSONObject != null ? jSONObject.optLong("end") : 0L);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityTimeRange)) {
            return false;
        }
        ActivityTimeRange activityTimeRange = (ActivityTimeRange) other;
        return this.beginSec == activityTimeRange.beginSec && this.endSec == activityTimeRange.endSec;
    }

    public static /* synthetic */ ActivityTimeRange b(ActivityTimeRange activityTimeRange, long j3, long j16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = activityTimeRange.beginSec;
        }
        if ((i3 & 2) != 0) {
            j16 = activityTimeRange.endSec;
        }
        return activityTimeRange.a(j3, j16);
    }
}
