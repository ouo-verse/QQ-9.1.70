package com.tencent.ecommerce.biz.live;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/live/TransactionData;", "Ljava/util/HashMap;", "", "", "a", "ecommerce_api_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class c {
    @NotNull
    public static final HashMap<String, Object> a(@NotNull TransactionData transactionData) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("PARAMS_ORDER_MONEY", String.valueOf(transactionData.getOrderMoney()));
        hashMap.put("PARAMS_ORDER_NUM", String.valueOf(transactionData.getOrderNum()));
        hashMap.put("PARAMS_PERSON_NUM", String.valueOf(transactionData.getPersonNum()));
        hashMap.put("PARAM_FORMAT_MONETY", b.f102672a.b(transactionData.getOrderMoney()));
        return hashMap;
    }
}
