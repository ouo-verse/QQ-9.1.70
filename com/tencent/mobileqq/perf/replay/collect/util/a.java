package com.tencent.mobileqq.perf.replay.collect.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\r\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/perf/replay/collect/util/a;", "Lcom/tencent/mobileqq/util/FPSCalculator$a;", "", "fpsTime", "", "f", "", "onInfo", "", "a", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Lcom/tencent/mobileqq/perf/replay/collect/data/a;", "b", "Lcom/tencent/mobileqq/perf/replay/collect/data/a;", "()Lcom/tencent/mobileqq/perf/replay/collect/data/a;", "(Lcom/tencent/mobileqq/perf/replay/collect/data/a;)V", "perfData", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements FPSCalculator.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.perf.replay.collect.data.a perfData;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.tag = "FpsCollector";
        }
    }

    @Nullable
    public final com.tencent.mobileqq.perf.replay.collect.data.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.perf.replay.collect.data.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.perfData;
    }

    public final void b(@Nullable com.tencent.mobileqq.perf.replay.collect.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.perfData = aVar;
        }
    }

    @Override // com.tencent.mobileqq.util.FPSCalculator.a
    public void onInfo(long fpsTime, double f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(fpsTime), Double.valueOf(f16));
            return;
        }
        QLog.i(this.tag, 1, " fps Callback : " + f16);
        com.tencent.mobileqq.perf.replay.collect.data.a aVar = this.perfData;
        if (aVar != null) {
            aVar.t(aVar.l() + f16);
            aVar.i().put(Long.valueOf(System.currentTimeMillis()), Double.valueOf(f16));
        }
    }
}
