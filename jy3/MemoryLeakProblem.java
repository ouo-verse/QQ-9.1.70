package jy3;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.pb.performance.ClientPerformance$SsoMonitorCollectorReportRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Ljy3/d;", "Ljy3/e;", "Lcom/tencent/pb/performance/ClientPerformance$SsoMonitorCollectorReportRequest;", Const.BUNDLE_KEY_REQUEST, "", "a", "", "toString", "Ljava/lang/String;", "type", "b", "leakObjectId", "c", "hprof_url", "d", "getLogUrl", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "logUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jy3.d, reason: from toString */
/* loaded from: classes25.dex */
public final class MemoryLeakProblem extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String leakObjectId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String hprof_url;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String logUrl;

    public /* synthetic */ MemoryLeakProblem(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? null : str4);
    }

    @Override // jy3.e
    public void a(@NotNull ClientPerformance$SsoMonitorCollectorReportRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        request.data.setHasFlag(true);
        request.data.memory_leak.setHasFlag(true);
        request.data.memory_leak.type.set(this.type);
        request.data.memory_leak.leak_object_id.set(this.leakObjectId);
        request.data.memory_leak.hprof_url.set(this.hprof_url);
        request.data.memory_leak.info.set(ky3.a.f413435a.a(this.logUrl));
    }

    public final void b(@Nullable String str) {
        this.logUrl = str;
    }

    @NotNull
    public String toString() {
        return "MemoryLeakProblem(type='" + this.type + "', leakObjectId='" + this.leakObjectId + "', hprof_url='" + this.hprof_url + "')";
    }

    public MemoryLeakProblem(@NotNull String type, @NotNull String leakObjectId, @NotNull String hprof_url, @Nullable String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(leakObjectId, "leakObjectId");
        Intrinsics.checkNotNullParameter(hprof_url, "hprof_url");
        this.type = type;
        this.leakObjectId = leakObjectId;
        this.hprof_url = hprof_url;
        this.logUrl = str;
    }
}
