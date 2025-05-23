package jy3;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.pb.performance.ClientPerformance$SsoMonitorCollectorReportRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Ljy3/g;", "Ljy3/e;", "Lcom/tencent/pb/performance/ClientPerformance$SsoMonitorCollectorReportRequest;", Const.BUNDLE_KEY_REQUEST, "", "a", "", "toString", "Ljava/lang/String;", "type", "b", "msg", "c", CrashHianalyticsData.STACK_TRACE, "d", "cause_stack_trace", "", "e", "I", "count", "f", "branchName", "g", "getLogUrl", "()Ljava/lang/String;", "setLogUrl", "(Ljava/lang/String;)V", "logUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jy3.g, reason: from toString */
/* loaded from: classes25.dex */
public final class StrictModeProblem extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String msg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String stack_trace;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String cause_stack_trace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int count;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String branchName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String logUrl;

    public /* synthetic */ StrictModeProblem(String str, String str2, String str3, String str4, int i3, String str5, String str6, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i3, (i16 & 32) != 0 ? null : str5, (i16 & 64) != 0 ? null : str6);
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
        request.data.strict_mode_monitor.setHasFlag(true);
        request.data.strict_mode_monitor.type.set(this.type);
        request.data.strict_mode_monitor.f342166msg.set(this.msg);
        request.data.strict_mode_monitor.stack_trace.set(this.stack_trace);
        request.data.strict_mode_monitor.cause_stack_trace.set(this.cause_stack_trace);
        request.data.strict_mode_monitor.info.set(ky3.a.f413435a.a(this.logUrl));
    }

    @NotNull
    public String toString() {
        return "StrictModeProblem(type='" + this.type + "', msg='" + this.msg + "', stack_trace='" + this.stack_trace + "', cause_stack_trace='" + this.cause_stack_trace + "', count=" + this.count + ", branchName=" + this.branchName + ')';
    }

    public StrictModeProblem(@NotNull String type, @NotNull String msg2, @NotNull String stack_trace, @NotNull String cause_stack_trace, int i3, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(stack_trace, "stack_trace");
        Intrinsics.checkNotNullParameter(cause_stack_trace, "cause_stack_trace");
        this.type = type;
        this.msg = msg2;
        this.stack_trace = stack_trace;
        this.cause_stack_trace = cause_stack_trace;
        this.count = i3;
        this.branchName = str;
        this.logUrl = str2;
    }
}
