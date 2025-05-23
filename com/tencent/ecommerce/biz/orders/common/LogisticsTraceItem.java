package com.tencent.ecommerce.biz.orders.common;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$TraceItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\tB/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "acceptTime", "b", "acceptStation", "Lcom/tencent/ecommerce/biz/orders/common/TrailStatus;", "c", "Lcom/tencent/ecommerce/biz/orders/common/TrailStatus;", "status", "d", "statusDesc", "e", "location", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/common/TrailStatus;Ljava/lang/String;Ljava/lang/String;)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.common.g, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class LogisticsTraceItem {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String acceptTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String acceptStation;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final TrailStatus status;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String statusDesc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String location;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/g$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_logistics_common/ECLogisticsCommon$TraceItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/ecommerce/biz/orders/common/g;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.common.g$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final LogisticsTraceItem a(ECLogisticsCommon$TraceItem item) {
            String str = item.accept_time.get();
            String str2 = item.accept_station.get();
            TrailStatus a16 = TrailStatus.INSTANCE.a(item.status.status.get());
            if (a16 == null) {
                a16 = TrailStatus.NO_MSG;
            }
            return new LogisticsTraceItem(str, str2, a16, item.status.status_desc.get(), item.location.get());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LogisticsTraceItem(String str, String str2, TrailStatus trailStatus, String str3, String str4) {
        this.acceptTime = str;
        this.acceptStation = str2;
        this.status = trailStatus;
        this.statusDesc = str3;
        this.location = str4;
    }

    public int hashCode() {
        String str = this.acceptTime;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.acceptStation;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        TrailStatus trailStatus = this.status;
        int hashCode3 = (hashCode2 + (trailStatus != null ? trailStatus.hashCode() : 0)) * 31;
        String str3 = this.statusDesc;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.location;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "LogisticsTraceItem(acceptTime=" + this.acceptTime + ", acceptStation=" + this.acceptStation + ", status=" + this.status + ", statusDesc=" + this.statusDesc + ", location=" + this.location + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogisticsTraceItem)) {
            return false;
        }
        LogisticsTraceItem logisticsTraceItem = (LogisticsTraceItem) other;
        return Intrinsics.areEqual(this.acceptTime, logisticsTraceItem.acceptTime) && Intrinsics.areEqual(this.acceptStation, logisticsTraceItem.acceptStation) && Intrinsics.areEqual(this.status, logisticsTraceItem.status) && Intrinsics.areEqual(this.statusDesc, logisticsTraceItem.statusDesc) && Intrinsics.areEqual(this.location, logisticsTraceItem.location);
    }
}
