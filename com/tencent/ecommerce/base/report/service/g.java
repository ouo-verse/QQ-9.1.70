package com.tencent.ecommerce.base.report.service;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007J$\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\rH\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/g;", "", "", "mediaId", "", "c", "productId", "saasType", "", "price", "commission", "b", "eventCode", "", "params", "d", "Lcom/tencent/ecommerce/base/report/service/h;", "reqModel", "a", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "ioScope", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final g f100929b = new g();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineScope ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());

    g() {
    }

    private final void a(h reqModel) {
        com.tencent.ecommerce.base.network.service.a.d("trpc.ecom.realtime_reportsvr.RealtimeReportsvr", "/trpc.ecom.realtime_reportsvr.RealtimeReportsvr/Report", reqModel, new j(), null, 16, null);
    }

    @JvmStatic
    public static final void b(String productId, String saasType, long price, long commission) {
        f100929b.a(new h(ECRealtimeReportOperation.EC_REALTIME_REPORT_OPERATION_VIEW_PRODUCT, null, new ECRealtimeReportProductModel(productId, saasType, (int) price, (int) commission), null, 10, null));
    }

    @JvmStatic
    public static final void c(String mediaId) {
        f100929b.a(new h(ECRealtimeReportOperation.EC_REALTIME_REPORT_OPERATION_VIEW_SHOW_WINDOWS, mediaId, null, null, 8, null));
    }

    @JvmStatic
    public static final void d(String eventCode, Map<Object, ? extends Object> params) {
        f100929b.a(new h(ECRealtimeReportOperation.EC_REALTIME_REPORT_OPERATION_TERMINAL_REAL_REPORT, null, null, new n(eventCode, params), 6, null));
    }
}
