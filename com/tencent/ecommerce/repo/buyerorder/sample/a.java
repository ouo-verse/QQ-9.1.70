package com.tencent.ecommerce.repo.buyerorder.sample;

import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/sample/a;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/repo/buyerorder/sample/a$a;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface a {
    Object a(String str, Continuation<? super OrderDetailResult> continuation);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/sample/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "state", "b", "Ljava/lang/String;", "token", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "orderDetailState", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.buyerorder.sample.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class OrderDetailResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECOrderSubmitViewModel.g state;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String token;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECOrderDetailState orderDetailState;

        public OrderDetailResult(ECOrderSubmitViewModel.g gVar, String str, ECOrderDetailState eCOrderDetailState) {
            this.state = gVar;
            this.token = str;
            this.orderDetailState = eCOrderDetailState;
        }

        public int hashCode() {
            ECOrderSubmitViewModel.g gVar = this.state;
            int hashCode = (gVar != null ? gVar.hashCode() : 0) * 31;
            String str = this.token;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            ECOrderDetailState eCOrderDetailState = this.orderDetailState;
            return hashCode2 + (eCOrderDetailState != null ? eCOrderDetailState.hashCode() : 0);
        }

        public String toString() {
            return "OrderDetailResult(state=" + this.state + ", token=" + this.token + ", orderDetailState=" + this.orderDetailState + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OrderDetailResult)) {
                return false;
            }
            OrderDetailResult orderDetailResult = (OrderDetailResult) other;
            return Intrinsics.areEqual(this.state, orderDetailResult.state) && Intrinsics.areEqual(this.token, orderDetailResult.token) && Intrinsics.areEqual(this.orderDetailState, orderDetailResult.orderDetailState);
        }
    }
}
