package com.tencent.qmethod.monitor.report;

import android.os.Handler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.e;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.bean.ConstitutionConfig;
import com.tencent.qmethod.monitor.config.bean.ConstitutionSceneConfig;
import com.tencent.qmethod.monitor.debug.question.QuestionCollect;
import com.tencent.qmethod.monitor.ext.overcall.OverCallMonitor;
import com.tencent.qmethod.monitor.report.api.ApiInvokeAnalyse;
import com.tencent.qmethod.monitor.report.base.db.c;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import com.tencent.qmethod.monitor.report.sample.APILevelSampleHelper;
import com.tencent.qmethod.pandoraex.api.n;
import com.tencent.qmethod.pandoraex.api.t;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.s;
import com.tencent.qmethod.pandoraex.core.x;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mr3.b;
import or3.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qmethod/monitor/report/PMonitorReporter;", "Lcom/tencent/qmethod/pandoraex/api/n;", "Lcom/tencent/qmethod/pandoraex/api/u;", "reportStrategy", "", "d", "", "l", "i", "f", DomainData.DOMAIN_NAME, "k", h.F, "g", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "e", "(Lcom/tencent/qmethod/pandoraex/api/u;)V", "Lcom/tencent/qmethod/pandoraex/api/n;", "appReporter", "<init>", "(Lcom/tencent/qmethod/pandoraex/api/n;)V", "c", "Companion", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class PMonitorReporter implements n {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f343762b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final n appReporter;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qmethod/monitor/report/PMonitorReporter$Companion;", "", "", "hash", "", "a", "Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "b", "()Landroid/os/Handler;", "handler", "", "FOREGROUND_NEXT_CHECK_TIME", "I", "HIGH_FREQ_IGNORE_REPORT_STACK_THRESHOLD", "HIGH_FREQ_MIN_REPORT_STACK_THRESHOLD", "SHIPLY_TAG_WAIT_TIME", "TAG", "Ljava/lang/String;", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean a(@NotNull final String hash) {
            boolean z16;
            Intrinsics.checkParameterIsNotNull(hash, "hash");
            c.Companion companion = c.INSTANCE;
            com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
            Object i3 = companion.a(aVar.g().getContext()).getDbHandler().i(new b(), new Function0<String>() { // from class: com.tencent.qmethod.monitor.report.PMonitorReporter$Companion$filterAndRecordSameHash$searchResult$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return hash;
                }
            });
            if (!(i3 instanceof Boolean)) {
                i3 = null;
            }
            Boolean bool = (Boolean) i3;
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            if (!z16) {
                int g16 = companion.a(aVar.g().getContext()).getDbHandler().g(new b(), new Function0<String>() { // from class: com.tencent.qmethod.monitor.report.PMonitorReporter$Companion$filterAndRecordSameHash$code$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        return hash;
                    }
                });
                if (aVar.g().getDebug()) {
                    o.a("Reporter", "insert code=" + g16);
                }
            }
            if (aVar.g().getDebug()) {
                o.a("Reporter", "shouldFilterSameQuestionReport=" + z16);
            }
            return z16;
        }

        @NotNull
        public final Handler b() {
            return (Handler) PMonitorReporter.f343762b.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Handler>() { // from class: com.tencent.qmethod.monitor.report.PMonitorReporter$Companion$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(ThreadManager.f343506c.b());
            }
        });
        f343762b = lazy;
    }

    public PMonitorReporter(@Nullable n nVar) {
        this.appReporter = nVar;
    }

    private final void d(u reportStrategy) {
        if (Intrinsics.areEqual("normal", reportStrategy.f343967d)) {
            return;
        }
        QuestionCollect a16 = gr3.a.f403087a.a();
        if (a16 != null) {
            a16.d(reportStrategy);
        }
        com.tencent.qmethod.monitor.b.f343452a.a(reportStrategy);
    }

    private final void f(final u reportStrategy) {
        if (Intrinsics.areEqual(reportStrategy.f343967d, "back")) {
            INSTANCE.b().postDelayed(new Runnable() { // from class: com.tencent.qmethod.monitor.report.PMonitorReporter$execReport$1
                @Override // java.lang.Runnable
                public final void run() {
                    int i3;
                    u uVar = reportStrategy;
                    uVar.f343989z = 700;
                    if (com.tencent.qmethod.monitor.a.f343451h.g().getAppStateManager().d()) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    uVar.f343988y = i3;
                    PMonitorReporter.this.e(reportStrategy);
                }
            }, 700);
        } else {
            INSTANCE.b().post(new Runnable() { // from class: com.tencent.qmethod.monitor.report.PMonitorReporter$execReport$2
                @Override // java.lang.Runnable
                public final void run() {
                    PMonitorReporter.this.e(reportStrategy);
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
    
        if (r6 != null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean g(u reportStrategy) {
        boolean z16;
        String str;
        List<t> list = reportStrategy.f343980q;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        List<t> list2 = reportStrategy.f343980q;
        Intrinsics.checkExpressionValueIsNotNull(list2, "reportStrategy.reportStackItems");
        t tVar = null;
        for (t tVar2 : list2) {
            if (tVar == null || tVar.f343963c < tVar2.f343963c) {
                tVar = tVar2;
            }
        }
        if (tVar != null) {
            e eVar = e.f343535a;
            String str2 = reportStrategy.f343967d + '.' + reportStrategy.f343964a + '.' + reportStrategy.f343965b + '.' + reportStrategy.f343968e + '.' + reportStrategy.f343969f + '.' + x.N(tVar.f343961a, 4, 25);
            Charset defaultCharset = Charset.defaultCharset();
            Intrinsics.checkExpressionValueIsNotNull(defaultCharset, "Charset.defaultCharset()");
            if (str2 != null) {
                byte[] bytes = str2.getBytes(defaultCharset);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                str = eVar.b(bytes);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        str = "";
        return INSTANCE.a(str);
    }

    private final boolean h(u reportStrategy) {
        int i3;
        if (!Intrinsics.areEqual("high_freq", reportStrategy.f343967d)) {
            return false;
        }
        com.tencent.qmethod.pandoraex.api.c cVar = reportStrategy.f343976m;
        if (cVar != null) {
            i3 = cVar.f343897b;
        } else {
            i3 = 0;
        }
        if (i3 < 10) {
            return false;
        }
        List<t> list = reportStrategy.f343980q;
        Intrinsics.checkExpressionValueIsNotNull(list, "reportStrategy.reportStackItems");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((t) it.next()).f343963c >= 4) {
                return false;
            }
        }
        return true;
    }

    private final boolean i(u reportStrategy) {
        if (SampleHelper.f343779l.p() && !APILevelSampleHelper.f343864j.m(reportStrategy)) {
            return true;
        }
        return false;
    }

    private final boolean j(u reportStrategy) {
        boolean z16 = true;
        if (!Intrinsics.areEqual(reportStrategy.f343967d, "back")) {
            return false;
        }
        long j3 = 500;
        long j16 = reportStrategy.f343975l;
        if (1 > j16 || j3 < j16) {
            z16 = false;
        }
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            o.a("Reporter", "filterShortTimeBackQuestion=" + z16);
        }
        return z16;
    }

    private final boolean k(u reportStrategy) {
        ConstitutionConfig q16 = ConfigManager.f343549h.q();
        String str = reportStrategy.f343964a;
        Intrinsics.checkExpressionValueIsNotNull(str, "reportStrategy.moduleName");
        ConstitutionSceneConfig a16 = q16.a(str, reportStrategy.f343965b, "normal");
        if (a16 == null) {
            if (Intrinsics.areEqual("normal", reportStrategy.f343967d)) {
                APILevelSampleHelper aPILevelSampleHelper = APILevelSampleHelper.f343864j;
                String str2 = reportStrategy.f343965b;
                Intrinsics.checkExpressionValueIsNotNull(str2, "reportStrategy.apiName");
                if (aPILevelSampleHelper.k(str2)) {
                    if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                        o.a("Reporter", "api:" + reportStrategy.f343965b + " \u975e\u914d\u7f6e\u7684normal\u573a\u666f\u4e0d\u505a\u4e0a\u62a5");
                    }
                    return true;
                }
                if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                    o.a("Reporter", "api:" + reportStrategy.f343965b + " API\u5206\u573a\u666f\u7ba1\u63a7\u9700\u8981\uff0c\u5141\u8bb8\u4e0a\u62a5 reportType=" + reportStrategy.f343984u);
                    return false;
                }
                return false;
            }
            return false;
        }
        reportStrategy.f343984u = a16.getCom.tencent.ad.tangram.statistics.metric.AdMetricTag.Report.TYPE java.lang.String().name();
        reportStrategy.f343985v = true;
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            o.a("Reporter", "api:" + reportStrategy.f343965b + " \u547d\u4e2d\u4e2d\u53f0\u914d\u7f6e\u4e0a\u62a5 reportType=" + reportStrategy.f343984u);
            return false;
        }
        return false;
    }

    private final boolean l(u reportStrategy) {
        if (!com.tencent.qmethod.monitor.report.sample.b.f343868c.c(2, reportStrategy)) {
            return false;
        }
        if (!h(reportStrategy) && !j(reportStrategy) && !k(reportStrategy)) {
            n(reportStrategy);
            if (i(reportStrategy)) {
                if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                    o.a("Reporter", "filterNoSerious " + reportStrategy);
                }
                return false;
            }
            SampleHelper sampleHelper = SampleHelper.f343779l;
            if (sampleHelper.o() && g(reportStrategy)) {
                if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                    o.a("Reporter", "filterSame " + reportStrategy);
                }
                sampleHelper.w(reportStrategy);
                return false;
            }
            return true;
        }
        SampleHelper.f343779l.w(reportStrategy);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(u reportStrategy) {
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        if (!aVar.h() && s.b()) {
            com.tencent.qmethod.monitor.a.p(true);
        }
        aVar.k();
        QuestionCollect a16 = gr3.a.f403087a.a();
        if (a16 != null) {
            a16.g(reportStrategy);
        }
        JSONObject e16 = pr3.b.f427061b.e("compliance", DTConstants.TAG.API, reportStrategy.f343977n / 1000);
        try {
            a.m(e16, reportStrategy);
            if (aVar.g().getDebug()) {
                o.a("Reporter", "prepare report: " + reportStrategy);
            }
            d.d(d.f423470e, new ReportData(e16, true), null, false, 6, null);
            qr3.a aVar2 = qr3.a.f429371j;
            String str = reportStrategy.f343967d;
            Intrinsics.checkExpressionValueIsNotNull(str, "reportStrategy.scene");
            aVar2.j("issue_type", aVar2.e(str));
        } catch (Exception e17) {
            o.d("Reporter", "report error:", e17);
        }
    }

    private final void n(u reportStrategy) {
        String str;
        if (Intrinsics.areEqual("high_freq", reportStrategy.f343967d) && (str = reportStrategy.f343968e) != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1884274053) {
                if (hashCode != -1077756671 || !str.equals("memory")) {
                    return;
                }
            } else if (!str.equals(QQPermissionConstants.Permission.STORAGE_GROUP)) {
                return;
            }
            reportStrategy.f343969f = false;
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.n
    public synchronized void a(@Nullable u reportStrategy) {
        if (reportStrategy == null) {
            o.c("Reporter", "\u95ee\u9898\u4e0a\u62a5\u6570\u636e\u4e3a\u7a7a");
            return;
        }
        ApiInvokeAnalyse.f343783d.c(reportStrategy);
        dr3.a.f394686a.b(reportStrategy);
        d(reportStrategy);
        boolean l3 = l(reportStrategy);
        try {
            reportStrategy.B = l3;
            n nVar = this.appReporter;
            if (nVar != null) {
                nVar.a(reportStrategy);
            }
        } catch (Throwable th5) {
            o.b("Reporter", "\u4e1a\u52a1\u4e0a\u62a5\u903b\u8f91\u9519\u8bef,\u8fdb\u884c\u515c\u5e95", th5);
        }
        if (l3) {
            f(reportStrategy);
        }
        OverCallMonitor.f343654b.c(reportStrategy);
    }

    public final void e(@NotNull final u reportStrategy) {
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        INSTANCE.b().post(new Runnable() { // from class: com.tencent.qmethod.monitor.report.PMonitorReporter$doReport$1
            @Override // java.lang.Runnable
            public final void run() {
                PMonitorReporter.this.m(reportStrategy);
            }
        });
    }
}
