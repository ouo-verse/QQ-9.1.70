package com.tencent.ecommerce.biz.orders.sellerorders;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.SellerOrderFilterOption;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.b;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.c;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.e;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.g;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\b\u001a\u00020\u0006*\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderRepository;", "", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/d;", "filterOptions", "", "cookie", "Lorg/json/JSONObject;", "a", "e", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "callback", "", "d", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lorg/json/JSONArray;", "b", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSellerOrderRepository {

    /* renamed from: a, reason: collision with root package name */
    public static final ECSellerOrderRepository f103821a = new ECSellerOrderRepository();

    ECSellerOrderRepository() {
    }

    private final JSONObject a(SellerOrderFilterOption filterOptions, String cookie) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("request_id", UUID.randomUUID().toString());
        jSONObject.put("query_option", f103821a.e(filterOptions));
        jSONObject.put("cookie", cookie);
        return jSONObject;
    }

    private final JSONObject e(SellerOrderFilterOption sellerOrderFilterOption) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("keyword", sellerOrderFilterOption.searchKey);
        if (!Intrinsics.areEqual(sellerOrderFilterOption.timeOption, g.a.f103876c)) {
            jSONObject.put("enable_time_filter", true);
        }
        jSONObject.put(QCircleLpReportDc05502.KEY_BEGIN_TIME, e.b(sellerOrderFilterOption.timeOption).getFirst().longValue());
        jSONObject.put("end_time", e.b(sellerOrderFilterOption.timeOption).getSecond().longValue());
        jSONObject.put("settlement_state", sellerOrderFilterOption.category.id);
        JSONArray jSONArray = new JSONArray();
        if (!sellerOrderFilterOption.c().contains(b.a.f103855c)) {
            Iterator<T> it = sellerOrderFilterOption.c().iterator();
            while (it.hasNext()) {
                jSONArray.put(((b) it.next()).id);
            }
        }
        jSONObject.put("state", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        if (!sellerOrderFilterOption.d().contains(e.a())) {
            Iterator<T> it5 = sellerOrderFilterOption.d().iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(((c) it5.next()).a());
            }
        }
        jSONObject.put("saas_infos", jSONArray2);
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(CoroutineDispatcher coroutineDispatcher, Continuation<? super JSONArray> continuation) {
        ECSellerOrderRepository$getSaasInfos$1 eCSellerOrderRepository$getSaasInfos$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ECSellerOrderRepository$getSaasInfos$1) {
            eCSellerOrderRepository$getSaasInfos$1 = (ECSellerOrderRepository$getSaasInfos$1) continuation;
            int i16 = eCSellerOrderRepository$getSaasInfos$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCSellerOrderRepository$getSaasInfos$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCSellerOrderRepository$getSaasInfos$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCSellerOrderRepository$getSaasInfos$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECSellerOrderRepository$getSaasInfos$result$1 eCSellerOrderRepository$getSaasInfos$result$1 = new ECSellerOrderRepository$getSaasInfos$result$1(null);
                    eCSellerOrderRepository$getSaasInfos$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCSellerOrderRepository$getSaasInfos$result$1, eCSellerOrderRepository$getSaasInfos$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((ECNetworkResponse) obj).b();
            }
        }
        eCSellerOrderRepository$getSaasInfos$1 = new ECSellerOrderRepository$getSaasInfos$1(this, continuation);
        Object obj2 = eCSellerOrderRepository$getSaasInfos$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCSellerOrderRepository$getSaasInfos$1.label;
        if (i3 != 0) {
        }
        return ((ECNetworkResponse) obj2).b();
    }

    public final void d(SellerOrderFilterOption filterOptions, String cookie, IECJsonNetworkCallback callback) {
        com.tencent.ecommerce.base.network.service.a.c("trpc.ecom.qshop_seller_data_svr.SellerOrderService", "/trpc.ecom.qshop_seller_data_svr.SellerOrderService/QuerySellerOrderList", a(filterOptions, cookie), callback);
    }

    public static /* synthetic */ Object c(ECSellerOrderRepository eCSellerOrderRepository, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        return eCSellerOrderRepository.b(coroutineDispatcher, continuation);
    }
}
