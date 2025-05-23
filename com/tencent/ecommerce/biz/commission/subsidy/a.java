package com.tencent.ecommerce.biz.commission.subsidy;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.b;
import com.tencent.ecommerce.biz.common.e;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/subsidy/a;", "", "", "eventCode", "", "a", "d", "b", "c", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f101535a = new a();

    a() {
    }

    private final void a(String eventCode) {
        IECDataReport.a.a(b.f100913b, eventCode, new e().a(String.valueOf(ug0.b.f438933d.e())).f(), false, 4, null);
    }

    public final void b() {
        a("comission_pddbenefit_page_exp");
    }

    public final void c() {
        a("comission_pddbenefit_yugu_page_exp");
    }

    public final void d() {
        a("comission_pddbenefit_clk");
    }
}
