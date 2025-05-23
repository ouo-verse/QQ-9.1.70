package com.tencent.ecommerce.biz.orders.common;

import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$Coordinate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\nB\u001f\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "D", "latitude", "b", "longitude", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "cityName", "<init>", "(DDLjava/lang/String;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.common.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class Coordinate {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final double latitude;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final double longitude;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String cityName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/c$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_logistics_common/ECLogisticsCommon$Coordinate;", "coordinate", "Lcom/tencent/ecommerce/biz/orders/common/c;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.common.c$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final Coordinate a(ECLogisticsCommon$Coordinate coordinate) {
            List split$default;
            split$default = StringsKt__StringsKt.split$default((CharSequence) coordinate.lat_and_lng.get(), new String[]{","}, false, 0, 6, (Object) null);
            return new Coordinate(Double.parseDouble((String) split$default.get(0)), Double.parseDouble((String) split$default.get(1)), coordinate.location.get());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Coordinate(double d16, double d17, String str) {
        this.latitude = d16;
        this.longitude = d17;
        this.cityName = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getCityName() {
        return this.cityName;
    }

    public int hashCode() {
        int a16 = ((b.a(this.latitude) * 31) + b.a(this.longitude)) * 31;
        String str = this.cityName;
        return a16 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "Coordinate(latitude=" + this.latitude + ", longitude=" + this.longitude + ", cityName=" + this.cityName + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Coordinate)) {
            return false;
        }
        Coordinate coordinate = (Coordinate) other;
        return Double.compare(this.latitude, coordinate.latitude) == 0 && Double.compare(this.longitude, coordinate.longitude) == 0 && Intrinsics.areEqual(this.cityName, coordinate.cityName);
    }
}
