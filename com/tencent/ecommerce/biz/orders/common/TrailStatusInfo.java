package com.tencent.ecommerce.biz.orders.common;

import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$TraceStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\nB\u001f\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\n\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/common/TrailStatus;", "a", "Lcom/tencent/ecommerce/biz/orders/common/TrailStatus;", "status", "Lcom/tencent/ecommerce/biz/orders/common/TrailSubStatus;", "b", "Lcom/tencent/ecommerce/biz/orders/common/TrailSubStatus;", "subStatus", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "desc", "<init>", "(Lcom/tencent/ecommerce/biz/orders/common/TrailStatus;Lcom/tencent/ecommerce/biz/orders/common/TrailSubStatus;Ljava/lang/String;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.common.m, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class TrailStatusInfo {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final TrailStatus status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final TrailSubStatus subStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String desc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/m$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_logistics_common/ECLogisticsCommon$TraceStatus;", "traceStatus", "Lcom/tencent/ecommerce/biz/orders/common/m;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.common.m$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final TrailStatusInfo a(ECLogisticsCommon$TraceStatus traceStatus) {
            return new TrailStatusInfo(TrailStatus.INSTANCE.a(traceStatus.status.get()), TrailSubStatus.INSTANCE.a(traceStatus.sub_status.get()), traceStatus.status_desc.get());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TrailStatusInfo(TrailStatus trailStatus, TrailSubStatus trailSubStatus, String str) {
        this.status = trailStatus;
        this.subStatus = trailSubStatus;
        this.desc = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    public int hashCode() {
        TrailStatus trailStatus = this.status;
        int hashCode = (trailStatus != null ? trailStatus.hashCode() : 0) * 31;
        TrailSubStatus trailSubStatus = this.subStatus;
        int hashCode2 = (hashCode + (trailSubStatus != null ? trailSubStatus.hashCode() : 0)) * 31;
        String str = this.desc;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "TrailStatusInfo(status=" + this.status + ", subStatus=" + this.subStatus + ", desc=" + this.desc + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrailStatusInfo)) {
            return false;
        }
        TrailStatusInfo trailStatusInfo = (TrailStatusInfo) other;
        return Intrinsics.areEqual(this.status, trailStatusInfo.status) && Intrinsics.areEqual(this.subStatus, trailStatusInfo.subStatus) && Intrinsics.areEqual(this.desc, trailStatusInfo.desc);
    }
}
