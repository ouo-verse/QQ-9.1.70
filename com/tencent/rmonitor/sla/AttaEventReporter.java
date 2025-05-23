package com.tencent.rmonitor.sla;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001e\u0010\u000b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0003R$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0012j\b\u0012\u0004\u0012\u00020\u0003`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/rmonitor/sla/AttaEventReporter;", "", "", "Lcom/tencent/rmonitor/sla/c;", "eventList", "", "cacheToDb", tl.h.F, "f", "Ljava/net/URL;", "g", "e", "", "d", "event", "i", "attaEvent", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "cache", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class AttaEventReporter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<AttaEvent> cache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f365812b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<AttaEventReporter>() { // from class: com.tencent.rmonitor.sla.AttaEventReporter$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final AttaEventReporter invoke() {
            return new AttaEventReporter(null);
        }
    });

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/rmonitor/sla/AttaEventReporter$a;", "", "Lcom/tencent/rmonitor/sla/AttaEventReporter;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/rmonitor/sla/AttaEventReporter;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "MAX_MERGE_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.sla.AttaEventReporter$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty[] f365817a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "getInstance()Lcom/tencent/rmonitor/sla/AttaEventReporter;"))};

        Companion() {
        }

        @NotNull
        public final AttaEventReporter a() {
            Lazy lazy = AttaEventReporter.f365812b;
            KProperty kProperty = f365817a[0];
            return (AttaEventReporter) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    AttaEventReporter() {
        this.cache = new ArrayList<>(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(List<AttaEvent> eventList, boolean cacheToDb) {
        URL g16 = g();
        if (g16 != null) {
            boolean g17 = new AttaEventReportTask(g16, eventList).g();
            if (g17 && cacheToDb) {
                b.f365843b.a(eventList);
            }
            return g17;
        }
        Logger.f365497g.w("RMonitor_sla_AttaEventReporter", "can not get atta url");
        return false;
    }

    private final URL g() {
        try {
            return new URL(BaseInfo.urlMeta.getAttaUrl());
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_sla_AttaEventReporter", th5);
            return null;
        }
    }

    private final boolean h(List<AttaEvent> eventList, boolean cacheToDb) {
        if (eventList.isEmpty()) {
            return false;
        }
        AttaEventHelper.f365808a.b(eventList);
        if (cacheToDb) {
            b.f365843b.b(eventList);
            return true;
        }
        return true;
    }

    public final void c(@NotNull final AttaEvent attaEvent) {
        Intrinsics.checkParameterIsNotNull(attaEvent, "attaEvent");
        Logger logger = Logger.f365497g;
        logger.d("RMonitor_sla_AttaEventReporter", "addEvent, eventCode:" + attaEvent.getEventCode());
        AttaEventHelper.f365808a.a(attaEvent);
        b.f365843b.d(attaEvent);
        synchronized (this.cache) {
            logger.d("RMonitor_sla_AttaEventReporter", "current cache size:" + this.cache.size() + " , do add event");
            this.cache.add(attaEvent);
            if (this.cache.size() >= 10) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.cache);
                ReporterMachine.f365411g.k(new Runnable() { // from class: com.tencent.rmonitor.sla.AttaEventReporter$addEvent$$inlined$synchronized$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f(arrayList, true);
                    }
                });
                this.cache.clear();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void d(@NotNull final List<AttaEvent> eventList, final boolean cacheToDb) {
        Intrinsics.checkParameterIsNotNull(eventList, "eventList");
        Logger.f365497g.d("RMonitor_sla_AttaEventReporter", "reportAsync size:" + eventList.size());
        if (h(eventList, cacheToDb)) {
            ReporterMachine.f365411g.k(new Runnable() { // from class: com.tencent.rmonitor.sla.AttaEventReporter$batchReportAsync$1
                @Override // java.lang.Runnable
                public final void run() {
                    AttaEventReporter.this.f(eventList, cacheToDb);
                }
            });
        }
    }

    public final boolean e(@NotNull List<AttaEvent> eventList, boolean cacheToDb) {
        Intrinsics.checkParameterIsNotNull(eventList, "eventList");
        Logger.f365497g.d("RMonitor_sla_AttaEventReporter", "reportSync size:" + eventList.size());
        if (!h(eventList, cacheToDb)) {
            return false;
        }
        return f(eventList, cacheToDb);
    }

    public final void i(@NotNull AttaEvent event, boolean cacheToDb) {
        ArrayList arrayListOf;
        Intrinsics.checkParameterIsNotNull(event, "event");
        Logger.f365497g.d("RMonitor_sla_AttaEventReporter", "reportAsync , eventCode:" + event.getEventCode());
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(event);
        d(arrayListOf, cacheToDb);
    }

    public /* synthetic */ AttaEventReporter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
