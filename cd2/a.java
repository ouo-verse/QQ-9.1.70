package cd2;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.c;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcd2/a;", "Lcom/tencent/rmonitor/fd/c;", "", "dumperType", "", "g", "Lcom/tencent/rmonitor/fd/dump/FdLeakDumpResult;", "result", "c", "e", "Lcom/tencent/rmonitor/fd/analysis/data/FdLeakIssueResult;", h.F, "status", "b", "p0", "p1", "Ljava/util/ArrayList;", "", "f", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements c {
    @Override // com.tencent.rmonitor.fd.c
    public void b(int status) {
        com.tencent.mobileqq.perf.log.a.a("FD", "QQRMonitorFdListener.onFdMonitorStart, status : " + status);
    }

    @Override // w04.b
    public void c(int dumperType, @Nullable FdLeakDumpResult result) {
        com.tencent.mobileqq.perf.log.a.a("FD", "QQRMonitorFdListener.onDumpFinished, dumperType : " + dumperType + " , result : " + result);
    }

    @Override // t04.c
    public void e() {
        com.tencent.mobileqq.perf.log.a.a("FD", "QQRMonitorFdListener.onAnalyzeStart");
    }

    @Override // com.tencent.rmonitor.fd.c
    @NotNull
    public ArrayList<String> f(int p06, int p16) {
        com.tencent.mobileqq.perf.log.a.d("FD", "QQRMonitorFdListener.onFdLeakDetected");
        return new ArrayList<>();
    }

    @Override // w04.b
    public void g(int dumperType) {
        com.tencent.mobileqq.perf.log.a.a("FD", "QQRMonitorFdListener.onDumpStart, dumperType : " + dumperType);
    }

    @Override // t04.c
    public void h(@Nullable FdLeakIssueResult result) {
        com.tencent.mobileqq.perf.log.a.a("FD", "QQRMonitorFdListener. onAnalyzeFinished success.");
    }
}
