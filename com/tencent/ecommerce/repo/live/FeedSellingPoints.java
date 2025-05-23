package com.tencent.ecommerce.repo.live;

import com.tencent.ark.ark;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\nB\u001f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0016\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/repo/live/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/repo/live/b;", "a", "Lcom/tencent/ecommerce/repo/live/b;", "getTitleLeftSellingPoint", "()Lcom/tencent/ecommerce/repo/live/b;", "setTitleLeftSellingPoint", "(Lcom/tencent/ecommerce/repo/live/b;)V", "titleLeftSellingPoint", "b", "getMiddleSellingPoint", "setMiddleSellingPoint", "middleSellingPoint", "c", "setDiscountSellingPoint", "discountSellingPoint", "<init>", "(Lcom/tencent/ecommerce/repo/live/b;Lcom/tencent/ecommerce/repo/live/b;Lcom/tencent/ecommerce/repo/live/b;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.j, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class FeedSellingPoints {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private ActivitySellingPoint titleLeftSellingPoint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private ActivitySellingPoint middleSellingPoint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private ActivitySellingPoint discountSellingPoint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/live/j$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/ecommerce/repo/live/j;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.j$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedSellingPoints a(JSONObject json) {
            if (json == null) {
                return null;
            }
            return new FeedSellingPoints(new ActivitySellingPoint(json.optJSONObject("title_left")), new ActivitySellingPoint(json.optJSONObject("middle_selling")), new ActivitySellingPoint(json.optJSONObject("discount_price")));
        }
    }

    public FeedSellingPoints(ActivitySellingPoint activitySellingPoint, ActivitySellingPoint activitySellingPoint2, ActivitySellingPoint activitySellingPoint3) {
        this.titleLeftSellingPoint = activitySellingPoint;
        this.middleSellingPoint = activitySellingPoint2;
        this.discountSellingPoint = activitySellingPoint3;
    }

    /* renamed from: a, reason: from getter */
    public final ActivitySellingPoint getDiscountSellingPoint() {
        return this.discountSellingPoint;
    }

    public int hashCode() {
        ActivitySellingPoint activitySellingPoint = this.titleLeftSellingPoint;
        int hashCode = (activitySellingPoint != null ? activitySellingPoint.hashCode() : 0) * 31;
        ActivitySellingPoint activitySellingPoint2 = this.middleSellingPoint;
        int hashCode2 = (hashCode + (activitySellingPoint2 != null ? activitySellingPoint2.hashCode() : 0)) * 31;
        ActivitySellingPoint activitySellingPoint3 = this.discountSellingPoint;
        return hashCode2 + (activitySellingPoint3 != null ? activitySellingPoint3.hashCode() : 0);
    }

    public String toString() {
        return "FeedSellingPoints(titleLeftSellingPoint=" + this.titleLeftSellingPoint + ", middleSellingPoint=" + this.middleSellingPoint + ", discountSellingPoint=" + this.discountSellingPoint + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedSellingPoints)) {
            return false;
        }
        FeedSellingPoints feedSellingPoints = (FeedSellingPoints) other;
        return Intrinsics.areEqual(this.titleLeftSellingPoint, feedSellingPoints.titleLeftSellingPoint) && Intrinsics.areEqual(this.middleSellingPoint, feedSellingPoints.middleSellingPoint) && Intrinsics.areEqual(this.discountSellingPoint, feedSellingPoints.discountSellingPoint);
    }
}
