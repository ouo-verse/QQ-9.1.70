package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\"\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "other", "", "b", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "a", "(Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;)Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "payType", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class i {
    public static final PayType a(IECPayApi.PayResult payResult) {
        int payChannel = payResult.getPayChannel();
        if (payChannel == 8) {
            return PayType.WECHAT;
        }
        if (payChannel != 13) {
            return PayType.UNKNOWN;
        }
        return PayType.QQ;
    }

    public static final boolean b(List<? extends PayType> list, List<? extends PayType> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) != list2.get(i3)) {
                return false;
            }
        }
        return true;
    }
}
