package com.tencent.qqnt.trace.perf;

import com.tencent.aio.api.perf.a;
import com.tencent.aio.monitor.PerfFrameCollector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.trace.a;
import com.tencent.qqnt.trace.perf.data.d;
import com.tencent.qqnt.trace.perf.data.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/trace/perf/b;", "Lcom/tencent/qqnt/trace/a$a;", "Lcom/tencent/aio/api/perf/a;", "", "start", "end", "", "d", "", "e", "nodeName", "nodeTime", "b", "Lcom/tencent/aio/api/perf/a$b;", "perfData", "a", "J", "appStartTime", "<init>", "()V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements a.InterfaceC9703a, com.tencent.aio.api.perf.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f362361a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final long appStartTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42938);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        b bVar = new b();
        f362361a = bVar;
        long currentTimeMillis = System.currentTimeMillis();
        appStartTime = currentTimeMillis;
        com.tencent.qqnt.trace.a.f362326a.a(bVar);
        c.INSTANCE.a().d(new d(currentTimeMillis, 0L, 0L, 0L, 0L, 30, null));
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long d(String start, String end) {
        com.tencent.qqnt.trace.a aVar = com.tencent.qqnt.trace.a.f362326a;
        return aVar.b(end) - aVar.b(start);
    }

    @Override // com.tencent.aio.api.perf.a
    public void a(@NotNull a.b perfData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) perfData);
            return;
        }
        Intrinsics.checkNotNullParameter(perfData, "perfData");
        if (QLog.isDevelopLevel()) {
            QLog.d("AIOPerfDataObserver", 4, "[onPerfDataCallback] time=" + perfData.a() + " frameCount=" + perfData.b());
        }
        c.INSTANCE.a().d(new e(perfData.a(), perfData.b(), perfData.c()));
    }

    @Override // com.tencent.qqnt.trace.a.InterfaceC9703a
    public void b(@NotNull String nodeName, long nodeTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, nodeName, Long.valueOf(nodeTime));
            return;
        }
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        if (Intrinsics.areEqual(nodeName, "SHOW_LIST")) {
            c.INSTANCE.a().d(new com.tencent.qqnt.trace.perf.data.c(d("FETCH_DATA_START", "FETCH_DATA_END"), 0L, d("FETCH_DATA_END", "TRANSFORM_DATA"), nodeTime - com.tencent.qqnt.trace.a.f362326a.b("NOTIFY_DATA"), 2, null));
        }
    }

    @Override // com.tencent.aio.api.perf.a
    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            a.C0622a.b(this, j3);
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            PerfFrameCollector.H.c(this);
        }
    }
}
