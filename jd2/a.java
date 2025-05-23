package jd2;

import com.tencent.mobileqq.perf.process.foregroud.ProcessExitManager;
import com.tencent.mobileqq.perf.report.PerfFeature;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Ljd2/a;", "Lcom/tencent/rmonitor/natmem/a;", "", "onSuccess", "", "errCode", "onFail", "", ReportConstant.COSTREPORT_PREFIX, "i", "d", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements com.tencent.rmonitor.natmem.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f409854b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Ljd2/a$a;", "", "", "nativeMemOpen", "Z", "a", "()Z", "setNativeMemOpen", "(Z)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: jd2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return a.f409854b;
        }

        Companion() {
        }
    }

    @Override // com.tencent.rmonitor.natmem.a
    public void d(@NotNull String s16, int i3) {
        Intrinsics.checkNotNullParameter(s16, "s");
        com.tencent.mobileqq.perf.log.a.d("QQRMonitorNatMemListener", "onNativeMemoryCeil, path : " + s16 + " ,type " + i3);
        ProcessExitManager.f257912d.d(ProcessExitManager.FromTag.RMonitor);
    }

    @Override // com.tencent.rmonitor.natmem.a
    public void onFail(int errCode) {
        com.tencent.mobileqq.perf.log.a.c("QQRMonitorNatMemListener", "onFail , errCode = " + errCode);
    }

    @Override // com.tencent.rmonitor.natmem.a
    public void onSuccess() {
        com.tencent.mobileqq.perf.log.a.c("QQRMonitorNatMemListener", "onSuccess.");
        f409854b = true;
        PerfFeature.a(PerfFeature.CustomFlag.NatMemMonitor);
    }
}
