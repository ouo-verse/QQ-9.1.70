package com.tencent.mobileqq.zplan.report.api.impl;

import com.tencent.mobileqq.tianjige.i;
import com.tencent.mobileqq.tianjige.metric.d;
import com.tencent.mobileqq.tianjige.metric.h;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR3\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R3\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0016`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/api/impl/ZPlanReportMetricImpl;", "Lqj3/a;", "Lcom/tencent/mobileqq/tianjige/metric/h;", "b", "Lkotlin/Lazy;", "getMetricRecorder", "()Lcom/tencent/mobileqq/tianjige/metric/h;", "metricRecorder", "Lcom/tencent/mobileqq/tianjige/i;", "c", "getTracer", "()Lcom/tencent/mobileqq/tianjige/i;", "tracer", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/tianjige/metric/a;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "getCounterMap", "()Ljava/util/HashMap;", "counterMap", "Lcom/tencent/mobileqq/tianjige/metric/d;", "e", "getRecorderMap", "recorderMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanReportMetricImpl implements qj3.a {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanReportMetricImpl f335053a = new ZPlanReportMetricImpl();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy metricRecorder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy tracer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, com.tencent.mobileqq.tianjige.metric.a> counterMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, d> recorderMap;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<h>() { // from class: com.tencent.mobileqq.zplan.report.api.impl.ZPlanReportMetricImpl$metricRecorder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return ZPlanReportHelperImpl.Companion.a();
            }
        });
        metricRecorder = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<i>() { // from class: com.tencent.mobileqq.zplan.report.api.impl.ZPlanReportMetricImpl$tracer$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i invoke() {
                return ZPlanReportHelperImpl.Companion.b();
            }
        });
        tracer = lazy2;
        counterMap = new HashMap<>();
        recorderMap = new HashMap<>();
    }

    ZPlanReportMetricImpl() {
    }
}
