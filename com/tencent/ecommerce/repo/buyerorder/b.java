package com.tencent.ecommerce.repo.buyerorder;

import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailBottomUIData;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayStatus;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0005\tJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/b;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/repo/buyerorder/b$a;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payParams", "Lcom/tencent/ecommerce/repo/buyerorder/b$b;", "b", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayStatus;", "status", "", "c", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface b {
    Object a(String str, Continuation<? super OrderDetailResult> continuation);

    Object b(String str, String str2, Continuation<? super OrderPayStatusResult> continuation);

    void c(String orderId, PayStatus status);

    PayStatus d(String orderId);

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "state", "b", "Ljava/lang/String;", "token", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "orderDetailState", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/d;", "d", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/d;", "bottomBarData", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/d;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.buyerorder.b$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class OrderDetailResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECOrderSubmitViewModel.g state;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String token;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECOrderDetailState orderDetailState;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECOrderDetailBottomUIData bottomBarData;

        public OrderDetailResult(ECOrderSubmitViewModel.g gVar, String str, ECOrderDetailState eCOrderDetailState, ECOrderDetailBottomUIData eCOrderDetailBottomUIData) {
            this.state = gVar;
            this.token = str;
            this.orderDetailState = eCOrderDetailState;
            this.bottomBarData = eCOrderDetailBottomUIData;
        }

        public int hashCode() {
            ECOrderSubmitViewModel.g gVar = this.state;
            int hashCode = (gVar != null ? gVar.hashCode() : 0) * 31;
            String str = this.token;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            ECOrderDetailState eCOrderDetailState = this.orderDetailState;
            int hashCode3 = (hashCode2 + (eCOrderDetailState != null ? eCOrderDetailState.hashCode() : 0)) * 31;
            ECOrderDetailBottomUIData eCOrderDetailBottomUIData = this.bottomBarData;
            return hashCode3 + (eCOrderDetailBottomUIData != null ? eCOrderDetailBottomUIData.hashCode() : 0);
        }

        public String toString() {
            return "OrderDetailResult(state=" + this.state + ", token=" + this.token + ", orderDetailState=" + this.orderDetailState + ", bottomBarData=" + this.bottomBarData + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OrderDetailResult)) {
                return false;
            }
            OrderDetailResult orderDetailResult = (OrderDetailResult) other;
            return Intrinsics.areEqual(this.state, orderDetailResult.state) && Intrinsics.areEqual(this.token, orderDetailResult.token) && Intrinsics.areEqual(this.orderDetailState, orderDetailResult.orderDetailState) && Intrinsics.areEqual(this.bottomBarData, orderDetailResult.bottomBarData);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayStatus;", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayStatus;", "status", "b", "Ljava/lang/String;", "alertMsg", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayStatus;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.buyerorder.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class OrderPayStatusResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final PayStatus status;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String alertMsg;

        public OrderPayStatusResult(PayStatus payStatus, String str) {
            this.status = payStatus;
            this.alertMsg = str;
        }

        public int hashCode() {
            PayStatus payStatus = this.status;
            int hashCode = (payStatus != null ? payStatus.hashCode() : 0) * 31;
            String str = this.alertMsg;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "OrderPayStatusResult(status=" + this.status + ", alertMsg=" + this.alertMsg + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OrderPayStatusResult)) {
                return false;
            }
            OrderPayStatusResult orderPayStatusResult = (OrderPayStatusResult) other;
            return Intrinsics.areEqual(this.status, orderPayStatusResult.status) && Intrinsics.areEqual(this.alertMsg, orderPayStatusResult.alertMsg);
        }
    }
}
