package com.tencent.ecommerce.repo.live;

import com.tencent.ark.ark;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u000bB\u001d\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/repo/live/o;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/ecommerce/repo/live/n;", "a", "Ljava/util/List;", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "list", "Lcom/tencent/ecommerce/repo/live/q$b;", "b", "Lcom/tencent/ecommerce/repo/live/q$b;", "()Lcom/tencent/ecommerce/repo/live/q$b;", "setPriceWithCoupon", "(Lcom/tencent/ecommerce/repo/live/q$b;)V", "priceWithCoupon", "<init>", "(Ljava/util/List;Lcom/tencent/ecommerce/repo/live/q$b;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.o, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class LiveCouponInfo {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private List<LiveCouponDetail> list;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private LiveProduct.Price priceWithCoupon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/live/o$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/ecommerce/repo/live/o;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.o$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveCouponInfo a(JSONObject json) {
            if (json == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = json.optJSONArray("coupons");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = optJSONArray.get(i3);
                    if (obj != null) {
                        arrayList.add(LiveCouponDetail.INSTANCE.a((JSONObject) obj));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                }
            }
            return new LiveCouponInfo(arrayList, new LiveProduct.Price(json.optJSONObject("after_coupon")));
        }
    }

    public LiveCouponInfo(List<LiveCouponDetail> list, LiveProduct.Price price) {
        this.list = list;
        this.priceWithCoupon = price;
    }

    /* renamed from: a, reason: from getter */
    public final LiveProduct.Price getPriceWithCoupon() {
        return this.priceWithCoupon;
    }

    public int hashCode() {
        List<LiveCouponDetail> list = this.list;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        LiveProduct.Price price = this.priceWithCoupon;
        return hashCode + (price != null ? price.hashCode() : 0);
    }

    public String toString() {
        return "LiveCouponInfo(list=" + this.list + ", priceWithCoupon=" + this.priceWithCoupon + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveCouponInfo)) {
            return false;
        }
        LiveCouponInfo liveCouponInfo = (LiveCouponInfo) other;
        return Intrinsics.areEqual(this.list, liveCouponInfo.list) && Intrinsics.areEqual(this.priceWithCoupon, liveCouponInfo.priceWithCoupon);
    }
}
