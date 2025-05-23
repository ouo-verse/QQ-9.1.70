package com.tencent.qmethod.monitor.report.base.reporter.batch;

import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qmethod.monitor.a;
import com.tencent.qmethod.monitor.base.util.AppInfo;
import com.tencent.qmethod.monitor.network.NetworkWatcher;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mr3.b;
import nr3.UserMeta;
import or3.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0019\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016R*\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/reporter/batch/CollectRecordDataRunnable;", "Ljava/lang/Runnable;", "", "f", "", "Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "objects", h.F, "e", TencentLocation.RUN_MODE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "reportDataList", "Lcom/tencent/qmethod/monitor/report/base/reporter/batch/BatchReportHelper;", "Lkotlin/Lazy;", "g", "()Lcom/tencent/qmethod/monitor/report/base/reporter/batch/BatchReportHelper;", "batchReportHelper", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Lor3/c;", "Lor3/c;", "reporter", "<init>", "(Landroid/os/Handler;Lor3/c;)V", "i", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class CollectRecordDataRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ReportData> reportDataList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy batchReportHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final c reporter;

    public CollectRecordDataRunnable(@Nullable Handler handler, @NotNull c reporter) {
        Lazy lazy;
        Intrinsics.checkParameterIsNotNull(reporter, "reporter");
        this.handler = handler;
        this.reporter = reporter;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<BatchReportHelper>() { // from class: com.tencent.qmethod.monitor.report.base.reporter.batch.CollectRecordDataRunnable$batchReportHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BatchReportHelper invoke() {
                c cVar;
                cVar = CollectRecordDataRunnable.this.reporter;
                return new BatchReportHelper(cVar);
            }
        });
        this.batchReportHelper = lazy;
    }

    private final void e() {
        a aVar = a.f343451h;
        if (com.tencent.qmethod.pandoraex.core.collector.utils.a.j(aVar.g().getContext())) {
            com.tencent.qmethod.monitor.report.base.db.c.INSTANCE.a(aVar.g().getContext()).getDbHandler().e(new b(), new Function0<Unit>() { // from class: com.tencent.qmethod.monitor.report.base.reporter.batch.CollectRecordDataRunnable$cleanReportQuestionData$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    private final void f() {
        Object obj;
        Handler handler;
        ArrayList<ReportData> arrayList;
        com.tencent.qmethod.monitor.report.base.db.b dbHandler;
        UserMeta userMeta = nr3.a.f421180b;
        String str = userMeta.appId;
        AppInfo.Companion companion = AppInfo.INSTANCE;
        mr3.a aVar = new mr3.a(str, companion.c(companion.a()), userMeta.appVersion);
        this.reportDataList = new ArrayList<>();
        com.tencent.qmethod.monitor.report.base.db.c cVar = nr3.a.f421181c;
        Boolean bool = null;
        if (cVar != null && (dbHandler = cVar.getDbHandler()) != null) {
            obj = dbHandler.i(aVar, new Function0<Boolean>() { // from class: com.tencent.qmethod.monitor.report.base.reporter.batch.CollectRecordDataRunnable$collectDbDataAndDeleteFile$reportDataFromCache$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2() {
                    return true;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Boolean invoke() {
                    return Boolean.valueOf(invoke2());
                }
            });
        } else {
            obj = null;
        }
        if (!(obj instanceof ArrayList)) {
            obj = null;
        }
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList2 != null && (arrayList = this.reportDataList) != null) {
            arrayList.addAll(arrayList2);
        }
        ArrayList<ReportData> arrayList3 = this.reportDataList;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.postDelayed(this, 500L);
            }
            bool = Boolean.TRUE;
        }
        if (bool == null && (handler = this.handler) != null) {
            handler.postDelayed(this, 7200000L);
        }
    }

    private final BatchReportHelper g() {
        return (BatchReportHelper) this.batchReportHelper.getValue();
    }

    private final void h(final List<ReportData> objects) {
        g().d(objects, new Function0<Unit>() { // from class: com.tencent.qmethod.monitor.report.base.reporter.batch.CollectRecordDataRunnable$reportDbData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Handler handler;
                com.tencent.qmethod.monitor.report.base.db.b dbHandler;
                com.tencent.qmethod.monitor.report.base.db.c cVar = nr3.a.f421181c;
                if (cVar != null && (dbHandler = cVar.getDbHandler()) != null) {
                    dbHandler.f(mr3.a.INSTANCE.a(), true);
                }
                objects.clear();
                handler = CollectRecordDataRunnable.this.handler;
                if (handler != null) {
                    handler.postDelayed(CollectRecordDataRunnable.this, 7200000L);
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        if (r0 != null) goto L16;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Unit unit;
        o.a("CollectRecordDataRunnable", TencentLocation.RUN_MODE);
        if (!NetworkWatcher.f343743h.m()) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.postDelayed(this, 7200000L);
            }
        } else {
            ArrayList<ReportData> arrayList = this.reportDataList;
            if (arrayList != null) {
                if (!arrayList.isEmpty()) {
                    h(arrayList);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
            }
            f();
            Unit unit2 = Unit.INSTANCE;
        }
        e();
    }
}
