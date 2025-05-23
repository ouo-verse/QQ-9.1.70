package com.tencent.ecommerce.repo.live;

import com.tencent.ark.ark;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/repo/live/n;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getCouponBatchId", "()Ljava/lang/String;", "setCouponBatchId", "(Ljava/lang/String;)V", "couponBatchId", "b", "setMsg", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.n, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class LiveCouponDetail {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String couponBatchId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String msg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/live/n$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/ecommerce/repo/live/n;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.n$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final LiveCouponDetail a(JSONObject json) {
            String str;
            String optString;
            String str2 = "";
            if (json == null || (str = json.optString("coupon_batch_id")) == null) {
                str = "";
            }
            if (json != null && (optString = json.optString("msg")) != null) {
                str2 = optString;
            }
            return new LiveCouponDetail(str, str2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LiveCouponDetail(String str, String str2) {
        this.couponBatchId = str;
        this.msg = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        String str = this.couponBatchId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.msg;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "LiveCouponDetail(couponBatchId=" + this.couponBatchId + ", msg=" + this.msg + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveCouponDetail)) {
            return false;
        }
        LiveCouponDetail liveCouponDetail = (LiveCouponDetail) other;
        return Intrinsics.areEqual(this.couponBatchId, liveCouponDetail.couponBatchId) && Intrinsics.areEqual(this.msg, liveCouponDetail.msg);
    }
}
