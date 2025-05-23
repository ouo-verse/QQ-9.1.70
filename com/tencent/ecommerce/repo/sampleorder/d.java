package com.tencent.ecommerce.repo.sampleorder;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.repo.aftersale.apply.OptionValue;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJE\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0014J#\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0014J5\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/ecommerce/repo/sampleorder/d;", "", "", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/repo/sampleorder/a;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "token", "Lcom/tencent/ecommerce/repo/aftersale/apply/j;", "reason", "desc", "", "imageUrls", "e", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/aftersale/apply/j;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "g", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "needLatestOrderInfo", "Lcom/tencent/ecommerce/repo/sampleorder/e;", "d", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface d {
    Object a(String str, Continuation<? super ECNetworkResponse<com.tencent.ecommerce.repo.sampleorder.a>> continuation);

    Object b(String str, String str2, Continuation<? super Boolean> continuation);

    Object c(String str, String str2, Continuation<? super Boolean> continuation);

    Object d(String str, String str2, ECAddress eCAddress, boolean z16, Continuation<? super e> continuation);

    Object e(String str, String str2, OptionValue optionValue, String str3, List<String> list, Continuation<? super Boolean> continuation);

    Object f(Continuation<? super Boolean> continuation);

    Object g(String str, String str2, Continuation<? super Boolean> continuation);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ Object a(d dVar, String str, String str2, ECAddress eCAddress, boolean z16, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return dVar.d(str, str2, eCAddress, z16, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateOrderAddress");
        }
    }
}
