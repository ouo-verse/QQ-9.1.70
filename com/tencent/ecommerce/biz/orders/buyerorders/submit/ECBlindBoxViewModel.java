package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import androidx.lifecycle.ViewModel;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J;\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJO\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECBlindBoxViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "payResult", "", "", "orderIds", "spuId", "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpanScene;", "scene", "L1", "(Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;Ljava/util/List;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpanScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "groupId", "Lkotlin/Pair;", "", "M1", "(Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpanScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "i", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECBlindBoxViewModel extends ViewModel {
    public final Object L1(IECPayApi.PayResult payResult, List<String> list, String str, ECOrderSpanScene eCOrderSpanScene, Continuation<? super String> continuation) {
        if ((payResult.getCode() == 0 || payResult.getCode() == 100) && !list.isEmpty()) {
            return TimeoutKt.withTimeoutOrNull(15000L, new ECBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2(list, eCOrderSpanScene, str, null), continuation);
        }
        return null;
    }

    public final Object M1(IECPayApi.PayResult payResult, List<String> list, String str, String str2, ECOrderSpanScene eCOrderSpanScene, Continuation<? super Pair<Boolean, String>> continuation) {
        if ((payResult.getCode() == 0 || payResult.getCode() == 100) && !list.isEmpty()) {
            return TimeoutKt.withTimeoutOrNull(15000L, new ECBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2(list, eCOrderSpanScene, str2, str, null), continuation);
        }
        return null;
    }
}
