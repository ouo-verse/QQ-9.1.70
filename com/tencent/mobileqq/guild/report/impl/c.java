package com.tencent.mobileqq.guild.report.impl;

import com.tencent.mobileqq.guild.report.ReportOption;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/report/impl/c;", "", "", "name", "Lcom/tencent/mobileqq/guild/report/impl/PerformanceReportClient;", "default", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "clients", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a */
    public static final c f232031a = new c();

    /* renamed from: b, reason: from kotlin metadata */
    private static final ConcurrentHashMap<String, PerformanceReportClient> clients = new ConcurrentHashMap<>();

    c() {
    }

    public final PerformanceReportClient a(String name, PerformanceReportClient r132) {
        Intrinsics.checkNotNullParameter(name, "name");
        ConcurrentHashMap<String, PerformanceReportClient> concurrentHashMap = clients;
        PerformanceReportClient performanceReportClient = concurrentHashMap.get(name);
        if (performanceReportClient == null) {
            if (r132 == null) {
                r132 = new PerformanceReportClient(name, new ReportOption(name, null, null, false, 0.0f, 0.0f, 62, null), false, 4, null);
            }
            PerformanceReportClient putIfAbsent = concurrentHashMap.putIfAbsent(name, r132);
            performanceReportClient = putIfAbsent == null ? r132 : putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(performanceReportClient, "clients.getOrPut(name) {\u2026rtOption(name))\n        }");
        return performanceReportClient;
    }

    public static /* synthetic */ PerformanceReportClient b(c cVar, String str, PerformanceReportClient performanceReportClient, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            performanceReportClient = null;
        }
        return cVar.a(str, performanceReportClient);
    }
}
