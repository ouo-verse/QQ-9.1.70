package or3;

import android.os.Handler;
import com.tencent.qmethod.monitor.base.a;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.network.NetworkWatcher;
import com.tencent.qmethod.monitor.report.base.reporter.batch.ReportCacheImpl;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import com.tencent.qmethod.pandoraex.core.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import or3.c;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007J\u0006\u0010\u000b\u001a\u00020\tR\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u000f\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lor3/d;", "Lor3/c;", "Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "reportData", "Lor3/c$a;", "callback", "", "a", "checkCollect", "", "c", "e", "Z", "isStarted", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "handler", "Lor3/c;", "getUploadProxy", "()Lor3/c;", "setUploadProxy", "(Lor3/c;)V", "uploadProxy", "Lor3/b;", "d", "Lor3/b;", "()Lor3/b;", "setReportCache", "(Lor3/b;)V", "reportCache", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean isStarted;

    /* renamed from: e, reason: collision with root package name */
    public static final d f423470e = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Handler handler = new Handler(ThreadManager.f343506c.b());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static c uploadProxy = new rr3.a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static or3.b reportCache = new ReportCacheImpl(handler);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"or3/d$a", "Lcom/tencent/qmethod/monitor/base/a;", "", "isAgree", "", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class a implements com.tencent.qmethod.monitor.base.a {
        a() {
        }

        @Override // com.tencent.qmethod.monitor.base.a
        public void a(boolean isAgree) {
            d.f423470e.e();
        }

        @Override // com.tencent.qmethod.monitor.base.a
        public void b() {
            a.C9329a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"or3/d$b", "Lor3/c$a;", "", "dbId", "", "onSuccess", "errorCode", "", "errorMsg", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class b implements c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.a f423471a;

        b(c.a aVar) {
            this.f423471a = aVar;
        }

        @Override // or3.c.a
        public void a(int errorCode, @NotNull String errorMsg, int dbId) {
            String str;
            Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
            c.a aVar = this.f423471a;
            if (aVar != null) {
                aVar.a(errorCode, errorMsg, dbId);
            }
            d.f423470e.b().c(dbId);
            qr3.a.f429371j.k("issue_report_succ", false);
            StringBuilder sb5 = new StringBuilder();
            if (dbId == 0) {
                str = "[RealTime]";
            } else {
                str = "[Cache]";
            }
            sb5.append(str);
            sb5.append(TokenParser.SP);
            sb5.append("reportNow-onFailure, dbId: ");
            sb5.append(dbId);
            sb5.append(", errorCode: ");
            sb5.append(errorCode);
            sb5.append(", errorMsg: ");
            sb5.append(errorMsg);
            o.c("ReporterMachine", sb5.toString());
        }

        @Override // or3.c.a
        public void onCached() {
            c.a.C10936a.a(this);
        }

        @Override // or3.c.a
        public void onSuccess(int dbId) {
            String str;
            c.a aVar = this.f423471a;
            if (aVar != null) {
                aVar.onSuccess(dbId);
            }
            d.f423470e.b().c(dbId);
            qr3.a.f429371j.k("issue_report_succ", true);
            StringBuilder sb5 = new StringBuilder();
            if (dbId == 0) {
                str = "[RealTime]";
            } else {
                str = "[Cache]";
            }
            sb5.append(str);
            sb5.append(" reportNow-onSuccess, dbId: ");
            sb5.append(dbId);
            o.e("ReporterMachine", sb5.toString());
        }
    }

    static {
        com.tencent.qmethod.monitor.a.f343451h.o(new a());
    }

    d() {
    }

    public static /* synthetic */ void d(d dVar, ReportData reportData, c.a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aVar = null;
        }
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        dVar.c(reportData, aVar, z16);
    }

    @Override // or3.c
    public boolean a(@NotNull ReportData reportData, @Nullable c.a callback) throws JSONException {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        o.a("ReporterMachine", "reportNow, dbId: " + reportData.getDbId());
        uploadProxy.a(reportData, new b(callback));
        return true;
    }

    @NotNull
    public final or3.b b() {
        return reportCache;
    }

    @JvmOverloads
    public final void c(@NotNull ReportData reportData, @Nullable c.a callback, boolean checkCollect) {
        int coerceAtMost;
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            String jSONObject = reportData.getParams().toString();
            IntRange intRange = new IntRange(1, (jSONObject.length() / 1024) + 1);
            int first = intRange.getFirst();
            int last = intRange.getLast();
            if (first <= last) {
                while (true) {
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(jSONObject.length(), first * 1024);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("post: ");
                    Intrinsics.checkExpressionValueIsNotNull(jSONObject, "this");
                    String substring = jSONObject.substring((first - 1) * 1024, coerceAtMost);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    sb5.append(substring);
                    o.a("Reporter", sb5.toString());
                    if (first == last) {
                        break;
                    } else {
                        first++;
                    }
                }
            }
        }
        if (reportData.getIsRealTime() && NetworkWatcher.f343743h.m() && com.tencent.qmethod.monitor.a.f343451h.h()) {
            try {
                a(reportData, callback);
                return;
            } catch (Exception e16) {
                o.d("ReporterMachine", "report", e16);
                return;
            }
        }
        reportCache.b(reportData);
        if (callback != null) {
            callback.onCached();
        }
        o.a("ReporterMachine", "onCached: dbID=" + reportData.getDbId());
    }

    public final void e() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("start, isStarted: ");
        sb5.append(isStarted);
        sb5.append(", PMonitor.hasAgreeUserPolicy = ");
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        sb5.append(aVar.h());
        o.e("ReporterMachine", sb5.toString());
        synchronized (this) {
            if (aVar.h() && !isStarted) {
                reportCache.a(f423470e);
                isStarted = true;
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
