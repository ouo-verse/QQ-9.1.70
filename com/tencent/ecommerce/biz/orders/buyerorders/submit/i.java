package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/i;", "", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "payResult", "", "costTimeMs", "", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f103574a = new i();

    i() {
    }

    public final void a(IECPayApi.PayResult payResult, long costTimeMs) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ec_quality_shop_pay", new com.tencent.ecommerce.biz.common.e().b("result_code", String.valueOf(payResult.getCode())).b("type", String.valueOf(payResult.getPayChannel())).b("cost_time", String.valueOf(costTimeMs)).b("state", String.valueOf(payResult.getPayState())).b("error_msg", payResult.getMsg()).f(), false, 4, null);
    }
}
