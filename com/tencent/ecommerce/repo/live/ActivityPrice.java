package com.tencent.ecommerce.repo.live;

import com.tencent.ark.ark;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u0013\b\u0016\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/repo/live/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "originalPrice", "b", "livePrice", "c", "()J", "liveSpecialPrice", "<init>", "(JJJ)V", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "(Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ActivityPrice {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long originalPrice;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final long livePrice;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long liveSpecialPrice;

    public ActivityPrice(long j3, long j16, long j17) {
        this.originalPrice = j3;
        this.livePrice = j16;
        this.liveSpecialPrice = j17;
    }

    /* renamed from: a, reason: from getter */
    public final long getLiveSpecialPrice() {
        return this.liveSpecialPrice;
    }

    public int hashCode() {
        return (((com.tencent.ecommerce.biz.commission.forecast.b.a(this.originalPrice) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.livePrice)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.liveSpecialPrice);
    }

    public String toString() {
        return "ActivityPrice(originalPrice=" + this.originalPrice + ", livePrice=" + this.livePrice + ", liveSpecialPrice=" + this.liveSpecialPrice + ")";
    }

    public ActivityPrice(JSONObject jSONObject) {
        this(jSONObject != null ? jSONObject.optLong("original") : 0L, jSONObject != null ? jSONObject.optLong("live") : 0L, jSONObject != null ? jSONObject.optLong("live_special") : 0L);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityPrice)) {
            return false;
        }
        ActivityPrice activityPrice = (ActivityPrice) other;
        return this.originalPrice == activityPrice.originalPrice && this.livePrice == activityPrice.livePrice && this.liveSpecialPrice == activityPrice.liveSpecialPrice;
    }
}
