package com.tencent.ecommerce.biz.commission.forecast;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/o;", "", "", "c", "", "b", "durationInMs", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f101491a = new o();

    o() {
    }

    public final void a(long durationInMs) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "anticipation_duration", com.tencent.ecommerce.biz.common.e.e(new com.tencent.ecommerce.biz.common.e(), null, 1, null).b("duration", String.valueOf(durationInMs)).f(), false, 4, null);
    }

    public final long b() {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "anticipation_exp", com.tencent.ecommerce.biz.common.e.e(new com.tencent.ecommerce.biz.common.e(), null, 1, null).f(), false, 4, null);
        return System.currentTimeMillis();
    }

    public final void c() {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "commission_overview_anticipation_clk", com.tencent.ecommerce.biz.common.e.e(new com.tencent.ecommerce.biz.common.e(), null, 1, null).f(), false, 4, null);
    }
}
