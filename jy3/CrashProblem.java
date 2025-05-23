package jy3;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.pb.performance.ClientPerformance$SsoCrashReportRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\bR\u0014\u0010\u001d\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\fR\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\b\u00a8\u0006 "}, d2 = {"Ljy3/a;", "Ljy3/f;", "Lcom/tencent/pb/performance/ClientPerformance$SsoCrashReportRequest;", Const.BUNDLE_KEY_REQUEST, "", "a", "", "toString", "Ljava/lang/String;", "crashType", "", "b", "Z", "isNativeCrashed", "c", "crashAddress", "d", "crashStack", "", "e", "I", "nativeSicode", "", "f", "J", "crashTime", "g", "processName", h.F, "isRelease", "i", "branchName", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jy3.a, reason: from toString */
/* loaded from: classes25.dex */
public final class CrashProblem extends f<ClientPerformance$SsoCrashReportRequest> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String crashType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isNativeCrashed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String crashAddress;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String crashStack;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int nativeSicode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long crashTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String processName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isRelease;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String branchName;

    public void a(@NotNull ClientPerformance$SsoCrashReportRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        request.setHasFlag(true);
        request.branch_name.set(this.branchName);
        request.crash_type.set(this.crashType);
        request.is_native_crashed.set(this.isNativeCrashed);
        request.crash_address.set(this.crashAddress);
        request.crash_stack.set(this.crashStack);
        request.native_si_code.set(this.nativeSicode);
        request.crash_time.set(this.crashTime);
        request.process_name.set(this.processName);
        request.is_release.set(this.isRelease);
        request.info.set(ky3.a.b(ky3.a.f413435a, null, 1, null));
    }

    @NotNull
    public String toString() {
        return "CrashProblem(crashType='" + this.crashType + "', isNativeCrashed='" + this.isNativeCrashed + "', crashAddress='" + this.crashAddress + "', nativeSicode='" + this.nativeSicode + "', crashTime='" + this.crashTime + "', processName='" + this.processName + "', isRelease='" + this.isRelease + "')";
    }
}
