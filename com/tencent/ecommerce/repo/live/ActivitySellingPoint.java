package com.tencent.ecommerce.repo.live;

import com.tencent.ark.ark;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015B\u0013\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/repo/live/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "label", "", "b", "J", "timeLimit", "c", "getHotIcon", "()Ljava/lang/String;", "hotIcon", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "(Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ActivitySellingPoint {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String label;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final long timeLimit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String hotIcon;

    public ActivitySellingPoint(String str, long j3, String str2) {
        this.label = str;
        this.timeLimit = j3;
        this.hotIcon = str2;
    }

    public int hashCode() {
        String str = this.label;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.timeLimit)) * 31;
        String str2 = this.hotIcon;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ActivitySellingPoint(label=" + this.label + ", timeLimit=" + this.timeLimit + ", hotIcon=" + this.hotIcon + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ActivitySellingPoint(JSONObject jSONObject) {
        this(r1, r2, r0);
        String optString;
        String str = "";
        String str2 = (jSONObject == null || (str2 = jSONObject.optString("label")) == null) ? "" : str2;
        long optLong = jSONObject != null ? jSONObject.optLong("time_limit") : 0L;
        if (jSONObject != null && (optString = jSONObject.optString("hot_icon")) != null) {
            str = optString;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivitySellingPoint)) {
            return false;
        }
        ActivitySellingPoint activitySellingPoint = (ActivitySellingPoint) other;
        return Intrinsics.areEqual(this.label, activitySellingPoint.label) && this.timeLimit == activitySellingPoint.timeLimit && Intrinsics.areEqual(this.hotIcon, activitySellingPoint.hotIcon);
    }
}
