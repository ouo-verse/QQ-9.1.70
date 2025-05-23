package jy3;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.pb.performance.ClientPerformance$SsoMonitorCollectorReportRequest;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\n\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Ljy3/c;", "Ljy3/e;", "Lcom/tencent/pb/performance/ClientPerformance$SsoMonitorCollectorReportRequest;", Const.BUNDLE_KEY_REQUEST, "", "a", "", "toString", "Ljava/lang/String;", "type", "b", CrashHianalyticsData.STACK_TRACE, "", "c", "J", QCircleWeakNetReporter.KEY_COST, "", "d", "I", "count", "e", "branchName", "f", "getLogUrl", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "logUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jy3.c, reason: from toString */
/* loaded from: classes25.dex */
public final class MainBlockMethodProblem extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String stack_trace;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long cost;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int count;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String branchName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String logUrl;

    public /* synthetic */ MainBlockMethodProblem(String str, String str2, long j3, int i3, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j3, i3, (i16 & 16) != 0 ? null : str3, (i16 & 32) != 0 ? null : str4);
    }

    @Override // jy3.e
    public void a(@NotNull ClientPerformance$SsoMonitorCollectorReportRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        request.data.setHasFlag(true);
        String str = this.branchName;
        if (str != null) {
            request.branch_name.set(str);
        }
        request.data.count.set(this.count);
        request.data.main_thread_monitor.setHasFlag(true);
        request.data.main_thread_monitor.type.set(this.type);
        request.data.main_thread_monitor.stack_trace.set(this.stack_trace);
        request.data.main_thread_monitor.cost_time.set(this.count);
        request.data.main_thread_monitor.info.set(ky3.a.f413435a.a(this.logUrl));
    }

    public final void b(@Nullable String str) {
        this.logUrl = str;
    }

    @NotNull
    public String toString() {
        return "MainBlockMethodProblem(type='" + this.type + "', stack_trace='" + this.stack_trace + "', cost=" + this.cost + ", count=" + this.count + ", branchName=" + this.branchName + ')';
    }

    public MainBlockMethodProblem(@NotNull String type, @NotNull String stack_trace, long j3, int i3, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(stack_trace, "stack_trace");
        this.type = type;
        this.stack_trace = stack_trace;
        this.cost = j3;
        this.count = i3;
        this.branchName = str;
        this.logUrl = str2;
    }
}
