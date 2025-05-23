package com.tencent.ecommerce.biz.submitsucceed;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/submitsucceed/a;", "", "", "g", "", "isChecked", "b", "c", "a", "f", "e", "d", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f104808a = new a();

    a() {
    }

    public final void a(boolean isChecked) {
        Map mapOf;
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("check_status", Integer.valueOf(isChecked ? 1 : 0)));
        IECDataReport.a.a(bVar, "qstore_order_submit_follow_ck_cancel", mapOf, false, 4, null);
    }

    public final void b(boolean isChecked) {
        Map mapOf;
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("check_status", Integer.valueOf(isChecked ? 1 : 0)));
        IECDataReport.a.a(bVar, "qstore_order_submit_follow_ck_check", mapOf, false, 4, null);
    }

    public final void c(boolean isChecked) {
        Map mapOf;
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("check_status", Integer.valueOf(isChecked ? 1 : 0)));
        IECDataReport.a.a(bVar, "qstore_order_submit_follow_ck_confirm", mapOf, false, 4, null);
    }

    public final void d() {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_order_submit_follow_second_ck_cancel", null, false, 4, null);
    }

    public final void e() {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_order_submit_follow_second_ck_confirm", null, false, 4, null);
    }

    public final void f() {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_order_submit_follow_second_exp", null, false, 4, null);
    }

    public final void g() {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_order_submit_follow_exp", null, false, 4, null);
    }
}
