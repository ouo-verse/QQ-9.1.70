package com.tencent.rmonitor.sla;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.base.reporter.DiscardReason;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001\u001dB\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\u0015\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J.\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u001e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fR0\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u001bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/rmonitor/sla/StatisticsReporter;", "", "", "baseType", QCircleLpReportDc010001.KEY_SUBTYPE, "", "success", "", "contentLength", QCircleWeakNetReporter.KEY_COST, "", "k", "Lcom/tencent/rmonitor/base/reporter/DiscardReason;", "discardReason", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/rmonitor/sla/h;", "g", "", "Lcom/tencent/rmonitor/sla/c;", "list", "e", "statisticsEvent", "l", "f", "j", tl.h.F, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "eventMap", "Ljava/lang/Runnable;", "b", "Ljava/lang/Runnable;", "uploadRunnable", "<init>", "()V", "d", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class StatisticsReporter {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy f365828c;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, StatisticsEvent> eventMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Runnable uploadRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/rmonitor/sla/StatisticsReporter$a;", "", "Lcom/tencent/rmonitor/sla/StatisticsReporter;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/rmonitor/sla/StatisticsReporter;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "", "UPLOAD_INTERVAL", "J", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.sla.StatisticsReporter$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty[] f365832a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "getInstance()Lcom/tencent/rmonitor/sla/StatisticsReporter;"))};

        Companion() {
        }

        @NotNull
        public final StatisticsReporter a() {
            Lazy lazy = StatisticsReporter.f365828c;
            KProperty kProperty = f365832a[0];
            return (StatisticsReporter) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<StatisticsReporter>() { // from class: com.tencent.rmonitor.sla.StatisticsReporter$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final StatisticsReporter invoke() {
                return new StatisticsReporter(null);
            }
        });
        f365828c = lazy;
    }

    StatisticsReporter() {
        this.eventMap = new HashMap<>();
        Runnable runnable = new Runnable() { // from class: com.tencent.rmonitor.sla.StatisticsReporter$uploadRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                StatisticsReporter.this.m();
            }
        };
        this.uploadRunnable = runnable;
        ReporterMachine.f365411g.l(runnable, 600000L);
    }

    private final void e(List<AttaEvent> list) {
        b.f365843b.a(list);
    }

    private final void f(StatisticsEvent statisticsEvent) {
        AttaEvent attaEvent = statisticsEvent.getAttaEvent();
        AttaEventHelper.f365808a.a(attaEvent);
        attaEvent.a0(statisticsEvent.getBaseType());
        attaEvent.b0(statisticsEvent.getSubType());
        attaEvent.g0(String.valueOf(statisticsEvent.getDiscardCount()));
        attaEvent.h0(String.valueOf(statisticsEvent.getFailCount()));
        attaEvent.i0(String.valueOf(statisticsEvent.getSuccCount()));
        attaEvent.j0(String.valueOf(statisticsEvent.getExpiredCount()));
        attaEvent.c0(String.valueOf(statisticsEvent.getSuccContentLengthSum()));
        attaEvent.d0(String.valueOf(statisticsEvent.getFailContentLengthSum()));
        attaEvent.e0(String.valueOf(statisticsEvent.getSuccCostSum()));
        attaEvent.f0(String.valueOf(statisticsEvent.getFailCostSum()));
    }

    private final StatisticsEvent g(String baseType, String subType) {
        String str = baseType + '-' + subType;
        StatisticsEvent statisticsEvent = this.eventMap.get(str);
        if (statisticsEvent == null) {
            statisticsEvent = new StatisticsEvent(baseType, subType);
        }
        this.eventMap.put(str, statisticsEvent);
        return statisticsEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String baseType, String subType, DiscardReason discardReason) {
        StatisticsEvent g16 = g(baseType, subType);
        if (discardReason == DiscardReason.CACHE_EXPIRE) {
            g16.m(g16.getExpiredCount() + 1);
        } else if (discardReason == DiscardReason.RETRY_EXCEEDED) {
            g16.l(g16.getDiscardCount() + 1);
        }
        l(g16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String baseType, String subType, boolean success, int contentLength, int cost) {
        StatisticsEvent g16 = g(baseType, subType);
        if (success) {
            g16.s(g16.getSuccCount() + 1);
            g16.q(g16.getSuccContentLengthSum() + contentLength);
            g16.r(g16.getSuccCostSum() + cost);
        } else {
            g16.p(g16.getFailCount() + 1);
            g16.n(g16.getFailContentLengthSum() + contentLength);
            g16.o(g16.getFailCostSum() + cost);
        }
        l(g16);
    }

    private final void l(StatisticsEvent statisticsEvent) {
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_sla_StatisticsReporter", "saveDataToDB baseType:" + statisticsEvent.getBaseType() + " subType:" + statisticsEvent.getSubType());
        }
        f(statisticsEvent);
        b.f365843b.d(statisticsEvent.getAttaEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_sla_StatisticsReporter", "upload statistics data");
        }
        if (this.eventMap.isEmpty()) {
            Logger.f365497g.d("RMonitor_sla_StatisticsReporter", "statistics data is empty , wait next upload");
        } else {
            ArrayList arrayList = new ArrayList();
            Collection<StatisticsEvent> values = this.eventMap.values();
            Intrinsics.checkExpressionValueIsNotNull(values, "eventMap.values");
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                arrayList.add(((StatisticsEvent) it.next()).getAttaEvent());
            }
            if (AttaEventReporter.INSTANCE.a().e(arrayList, false)) {
                this.eventMap.clear();
                e(arrayList);
            }
        }
        ReporterMachine.f365411g.l(this.uploadRunnable, 600000L);
    }

    public final void h(@NotNull final String baseType, @NotNull final String subType, @NotNull final DiscardReason discardReason) {
        Intrinsics.checkParameterIsNotNull(baseType, "baseType");
        Intrinsics.checkParameterIsNotNull(subType, "subType");
        Intrinsics.checkParameterIsNotNull(discardReason, "discardReason");
        if (!e.b().c("RMRecordReport")) {
            if (Logger.verbos) {
                Logger.f365497g.v("RMonitor_sla_StatisticsReporter", "recordDiscard, [" + baseType + ", " + subType + "] miss hit");
                return;
            }
            return;
        }
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_sla_StatisticsReporter", "recordDiscard baseType:" + baseType + ", subType:" + subType);
        }
        ReporterMachine.f365411g.k(new Runnable() { // from class: com.tencent.rmonitor.sla.StatisticsReporter$recordDiscard$1
            @Override // java.lang.Runnable
            public final void run() {
                StatisticsReporter.this.i(baseType, subType, discardReason);
            }
        });
    }

    public final void j(@NotNull final String baseType, @NotNull final String subType, final boolean success, final int contentLength, final int cost) {
        Intrinsics.checkParameterIsNotNull(baseType, "baseType");
        Intrinsics.checkParameterIsNotNull(subType, "subType");
        if (!e.b().c("RMRecordReport")) {
            if (Logger.verbos) {
                Logger.f365497g.v("RMonitor_sla_StatisticsReporter", "recordUpload, [" + baseType + ", " + subType + "] miss hit");
                return;
            }
            return;
        }
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_sla_StatisticsReporter", "recordUpload [" + baseType + ", " + subType + "], success:" + success + ", length:" + contentLength + ", cost:" + cost);
        }
        ReporterMachine.f365411g.k(new Runnable() { // from class: com.tencent.rmonitor.sla.StatisticsReporter$recordUpload$1
            @Override // java.lang.Runnable
            public final void run() {
                StatisticsReporter.this.k(baseType, subType, success, contentLength, cost);
            }
        });
    }

    public /* synthetic */ StatisticsReporter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
