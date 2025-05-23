package com.tencent.qqnt.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.richframework.tracer.RFWTracer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/trace/r;", "Lcom/tencent/richframework/tracer/RFWTracer;", "<init>", "()V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class r extends RFWTracer {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f362387a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42861);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        r rVar = new r();
        f362387a = rVar;
        rVar.addStream(new k());
        rVar.addStream(new b());
        rVar.addStream(new f());
        rVar.addStream(new s());
        rVar.addStream(new e());
        rVar.addStream(new c());
        rVar.addStream(new i());
    }

    r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
