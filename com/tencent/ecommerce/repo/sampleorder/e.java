package com.tencent.ecommerce.repo.sampleorder;

import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$OrderDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0007B\u001b\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u0082\u0001\u0002\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/repo/sampleorder/e;", "", "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;", "a", "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;", "requestInfo", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderDetail;", "b", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderDetail;", "latestOrderInfo", "<init>", "(Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderDetail;)V", "Lcom/tencent/ecommerce/repo/sampleorder/e$b;", "Lcom/tencent/ecommerce/repo/sampleorder/e$a;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ECOrderSpan.OrderRequestInfo requestInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ECQshopSampleSvr$OrderDetail latestOrderInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/repo/sampleorder/e$a;", "Lcom/tencent/ecommerce/repo/sampleorder/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "I", "errorCode", "d", "Ljava/lang/String;", "errorMsg", "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;", "e", "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;", "reqInfo", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderDetail;", "f", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderDetail;", "orderInfo", "<init>", "(ILjava/lang/String;Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderDetail;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.sampleorder.e$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class Failed extends e {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int errorCode;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String errorMsg;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECOrderSpan.OrderRequestInfo reqInfo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECQshopSampleSvr$OrderDetail orderInfo;

        public /* synthetic */ Failed(int i3, String str, ECOrderSpan.OrderRequestInfo orderRequestInfo, ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, orderRequestInfo, (i16 & 8) != 0 ? null : eCQshopSampleSvr$OrderDetail);
        }

        public int hashCode() {
            int i3 = this.errorCode * 31;
            String str = this.errorMsg;
            int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
            ECOrderSpan.OrderRequestInfo orderRequestInfo = this.reqInfo;
            int hashCode2 = (hashCode + (orderRequestInfo != null ? orderRequestInfo.hashCode() : 0)) * 31;
            ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail = this.orderInfo;
            return hashCode2 + (eCQshopSampleSvr$OrderDetail != null ? eCQshopSampleSvr$OrderDetail.hashCode() : 0);
        }

        public String toString() {
            return "Failed(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", reqInfo=" + this.reqInfo + ", orderInfo=" + this.orderInfo + ")";
        }

        public Failed(int i3, String str, ECOrderSpan.OrderRequestInfo orderRequestInfo, ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail) {
            super(orderRequestInfo, eCQshopSampleSvr$OrderDetail, null);
            this.errorCode = i3;
            this.errorMsg = str;
            this.reqInfo = orderRequestInfo;
            this.orderInfo = eCQshopSampleSvr$OrderDetail;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failed)) {
                return false;
            }
            Failed failed = (Failed) other;
            return this.errorCode == failed.errorCode && Intrinsics.areEqual(this.errorMsg, failed.errorMsg) && Intrinsics.areEqual(this.reqInfo, failed.reqInfo) && Intrinsics.areEqual(this.orderInfo, failed.orderInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/repo/sampleorder/e$b;", "Lcom/tencent/ecommerce/repo/sampleorder/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;", "c", "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;", "reqInfo", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderDetail;", "d", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderDetail;", "orderInfo", "<init>", "(Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderDetail;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.sampleorder.e$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class Succeed extends e {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECOrderSpan.OrderRequestInfo reqInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECQshopSampleSvr$OrderDetail orderInfo;

        public int hashCode() {
            ECOrderSpan.OrderRequestInfo orderRequestInfo = this.reqInfo;
            int hashCode = (orderRequestInfo != null ? orderRequestInfo.hashCode() : 0) * 31;
            ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail = this.orderInfo;
            return hashCode + (eCQshopSampleSvr$OrderDetail != null ? eCQshopSampleSvr$OrderDetail.hashCode() : 0);
        }

        public String toString() {
            return "Succeed(reqInfo=" + this.reqInfo + ", orderInfo=" + this.orderInfo + ")";
        }

        public Succeed(ECOrderSpan.OrderRequestInfo orderRequestInfo, ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail) {
            super(orderRequestInfo, eCQshopSampleSvr$OrderDetail, null);
            this.reqInfo = orderRequestInfo;
            this.orderInfo = eCQshopSampleSvr$OrderDetail;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Succeed)) {
                return false;
            }
            Succeed succeed = (Succeed) other;
            return Intrinsics.areEqual(this.reqInfo, succeed.reqInfo) && Intrinsics.areEqual(this.orderInfo, succeed.orderInfo);
        }
    }

    e(ECOrderSpan.OrderRequestInfo orderRequestInfo, ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail) {
        this.requestInfo = orderRequestInfo;
        this.latestOrderInfo = eCQshopSampleSvr$OrderDetail;
    }

    public /* synthetic */ e(ECOrderSpan.OrderRequestInfo orderRequestInfo, ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail, DefaultConstructorMarker defaultConstructorMarker) {
        this(orderRequestInfo, eCQshopSampleSvr$OrderDetail);
    }
}
