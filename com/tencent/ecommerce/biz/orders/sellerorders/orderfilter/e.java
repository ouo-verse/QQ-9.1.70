package com.tencent.ecommerce.biz.orders.sellerorders.orderfilter;

import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.g;
import com.tencent.ecommerce.biz.util.ECDateUtil;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\"\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "Lkotlin/Pair;", "", "b", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/c;", "a", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/c;", "()Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/c;", "SaasPlatformItemAll", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final c f103868a = new c(0, "\u5168\u90e8", "");

    public static final c a() {
        return f103868a;
    }

    public static final Pair<Long, Long> b(g gVar) {
        if (gVar instanceof g.a) {
            return TuplesKt.to(0L, Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
        }
        if (gVar instanceof g.e) {
            return TuplesKt.to(Long.valueOf(ECDateUtil.b(0)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
        }
        if (gVar instanceof g.d) {
            return TuplesKt.to(Long.valueOf(ECDateUtil.b(6)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
        }
        if (gVar instanceof g.c) {
            return TuplesKt.to(Long.valueOf(ECDateUtil.b(29)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
        }
        if (gVar instanceof g.b) {
            g.b bVar = (g.b) gVar;
            return TuplesKt.to(Long.valueOf(bVar.beginTimeSeconds), Long.valueOf(bVar.endTimeSeconds));
        }
        throw new NoWhenBranchMatchedException();
    }
}
