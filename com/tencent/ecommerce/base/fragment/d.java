package com.tencent.ecommerce.base.fragment;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.opentelemtry.api.IECSpan;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fJ*\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fJ \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002R$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/base/fragment/d;", "", "", "spanName", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "g", "serviceName", "Lhg0/c;", "parentSpanNode", "f", "", "attributes", "e", "event", "a", "c", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "b", "Lhg0/c;", "d", "()Lhg0/c;", "setPageSpanNode", "(Lhg0/c;)V", "pageSpanNode", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "spanProxy", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static hg0.c pageSpanNode;

    /* renamed from: c, reason: collision with root package name */
    public static final d f100713c = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final IECSpan spanProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getOpenTelemetry().getSpanManager();

    d() {
    }

    public final void a(String spanName, String event, Map<String, String> attributes) {
        spanProxy.addEvent(spanName, event, attributes);
    }

    public final void b(String event, String traceInfo) {
        String str;
        Map<String, String> mapOf;
        hg0.c cVar = pageSpanNode;
        if (TextUtils.isEmpty(cVar != null ? cVar.getSpanName() : null)) {
            return;
        }
        IECSpan iECSpan = spanProxy;
        hg0.c cVar2 = pageSpanNode;
        if (cVar2 == null || (str = cVar2.getSpanName()) == null) {
            str = "";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("request.span.info", traceInfo));
        iECSpan.addEvent(str, event, mapOf);
    }

    public final void c(String spanName, hg0.c parentSpanNode, int statusCode) {
        boolean startsWith$default;
        String str;
        hg0.c parentSpan;
        String str2;
        IECSpan iECSpan = spanProxy;
        iECSpan.endSpan(spanName, statusCode);
        pageSpanNode = parentSpanNode;
        if (parentSpanNode != null && parentSpanNode.d()) {
            hg0.c cVar = pageSpanNode;
            if (cVar == null || (str2 = cVar.getSpanName()) == null) {
                str2 = "";
            }
            hg0.c cVar2 = pageSpanNode;
            iECSpan.endSpan(str2, cVar2 != null ? cVar2.getSpanStatus() : 0);
            pageSpanNode = null;
        }
        do {
            hg0.c cVar3 = pageSpanNode;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(String.valueOf(cVar3 != null ? cVar3.getSpanName() : null), "ECHandleScheme", false, 2, null);
            if (!startsWith$default) {
                return;
            }
            IECSpan iECSpan2 = spanProxy;
            hg0.c cVar4 = pageSpanNode;
            if (cVar4 == null || (str = cVar4.getSpanName()) == null) {
                str = "";
            }
            hg0.c cVar5 = pageSpanNode;
            iECSpan2.endSpan(str, cVar5 != null ? cVar5.getSpanStatus() : 0);
            hg0.c cVar6 = pageSpanNode;
            parentSpan = cVar6 != null ? cVar6.getParentSpan() : null;
            pageSpanNode = parentSpan;
        } while ((parentSpan != null ? parentSpan.getParentSpan() : null) != null);
    }

    public final hg0.c d() {
        return pageSpanNode;
    }

    public final void e(String spanName, Map<String, String> attributes) {
        spanProxy.setAttribute(spanName, attributes);
    }

    public final void f(String spanName, String serviceName, hg0.c parentSpanNode) {
        String str;
        hg0.c cVar;
        IECSpan iECSpan = spanProxy;
        if (parentSpanNode == null || (str = parentSpanNode.getSpanName()) == null) {
            str = "";
        }
        iECSpan.startSpanWithParent(spanName, serviceName, str);
        if (parentSpanNode == null) {
            cVar = new hg0.c(null, spanName, 0, 5, null);
        } else {
            cVar = new hg0.c(parentSpanNode, spanName, 0, 4, null);
        }
        pageSpanNode = cVar;
    }

    public final void g(String spanName, int statusCode) {
        hg0.c cVar = pageSpanNode;
        hg0.c e16 = cVar != null ? cVar.e(spanName) : null;
        if (e16 != null) {
            e16.f(statusCode);
        }
    }
}
