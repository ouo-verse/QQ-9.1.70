package com.tencent.ecommerce.repo.live;

import com.tencent.ark.ark;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u0013\b\u0016\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0013\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J'\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/repo/live/c;", "", "", "d", "", "total", "activityRemain", "activityInit", "a", "", "toString", "", "hashCode", "other", "equals", "J", "b", "c", "()J", "<init>", "(JJJ)V", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "(Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ActivityStock {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long total;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final long activityRemain;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long activityInit;

    public ActivityStock(long j3, long j16, long j17) {
        this.total = j3;
        this.activityRemain = j16;
        this.activityInit = j17;
    }

    public final ActivityStock a(long total, long activityRemain, long activityInit) {
        return new ActivityStock(total, activityRemain, activityInit);
    }

    /* renamed from: c, reason: from getter */
    public final long getActivityInit() {
        return this.activityInit;
    }

    public final boolean d() {
        return this.total <= 0 || this.activityRemain <= 0;
    }

    public int hashCode() {
        return (((com.tencent.ecommerce.biz.commission.forecast.b.a(this.total) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.activityRemain)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.activityInit);
    }

    public String toString() {
        return "ActivityStock(total=" + this.total + ", activityRemain=" + this.activityRemain + ", activityInit=" + this.activityInit + ")";
    }

    public ActivityStock(JSONObject jSONObject) {
        this(jSONObject != null ? jSONObject.optLong("total") : 0L, jSONObject != null ? jSONObject.optLong("remain") : 0L, jSONObject != null ? jSONObject.optLong("active") : 0L);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityStock)) {
            return false;
        }
        ActivityStock activityStock = (ActivityStock) other;
        return this.total == activityStock.total && this.activityRemain == activityStock.activityRemain && this.activityInit == activityStock.activityInit;
    }

    public static /* synthetic */ ActivityStock b(ActivityStock activityStock, long j3, long j16, long j17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = activityStock.total;
        }
        long j18 = j3;
        if ((i3 & 2) != 0) {
            j16 = activityStock.activityRemain;
        }
        long j19 = j16;
        if ((i3 & 4) != 0) {
            j17 = activityStock.activityInit;
        }
        return activityStock.a(j18, j19, j17);
    }
}
