package com.tencent.ecommerce.biz.orders.address;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/d;", "", "", "from", "", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f103051a = new d();

    d() {
    }

    public final void a(String from) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_order_submit_address_edit", new com.tencent.ecommerce.biz.common.e().a(String.valueOf(ug0.b.f438933d.e())).b("triger", from).f(), false, 4, null);
    }
}
