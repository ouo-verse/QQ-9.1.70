package com.tencent.ecommerce.repo.buyerorder.orderlist;

import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ-\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\tJ5\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/orderlist/d;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "token", "", "needLatestOrder", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/f;", "c", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "newAddress", "e", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/e;", "a", "()Lkotlinx/coroutines/flow/SharedFlow;", "orderListOperateEvent", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface d {
    SharedFlow<e> a();

    Object b(Continuation<? super Unit> continuation);

    Object c(String str, String str2, boolean z16, Continuation<? super f> continuation);

    Object d(String str, String str2, boolean z16, Continuation<? super f> continuation);

    Object e(String str, String str2, ECAddress eCAddress, boolean z16, Continuation<? super f> continuation);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ Object a(d dVar, String str, String str2, boolean z16, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                return dVar.c(str, str2, z16, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelOrder");
        }

        public static /* synthetic */ Object b(d dVar, String str, String str2, boolean z16, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                return dVar.d(str, str2, z16, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: confirmReceive");
        }

        public static /* synthetic */ Object c(d dVar, String str, String str2, ECAddress eCAddress, boolean z16, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return dVar.e(str, str2, eCAddress, z16, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAddress");
        }
    }
}
