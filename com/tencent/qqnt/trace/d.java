package com.tencent.qqnt.trace;

import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.tracer.RFWTraceStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\u0017\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/trace/d;", "", "", "c", "a", "", "time", "d", tl.h.F, "e", "g", "f", "b", "J", "sessionId", "", "Z", "firstMsgDidShow", "pushMsgDidReceive", "pushMsgDidShow", "nextSessionId", "Lcom/tencent/richframework/tracer/RFWTraceStream;", "()Lcom/tencent/richframework/tracer/RFWTraceStream;", "stream", "<init>", "()V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f362331a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long sessionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean firstMsgDidShow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean pushMsgDidReceive;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean pushMsgDidShow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long nextSessionId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42799);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f362331a = new d();
            nextSessionId = 1L;
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a() {
        boolean z16;
        if (sessionId > 0 && firstMsgDidShow && pushMsgDidShow) {
            RFWTraceStream b16 = b();
            GuardManager guardManager = GuardManager.sInstance;
            if (guardManager != null) {
                z16 = guardManager.isApplicationForeground();
            } else {
                z16 = true;
            }
            b16.addParam("isAppForeground", Boolean.valueOf(z16));
            b().addParam("isPublicVersion", Boolean.valueOf(com.tencent.qqnt.util.b.f362976b.isPublicVersion()));
            b().tagNode("clickPushEndStream", System.currentTimeMillis());
            b().end();
            sessionId = 0L;
        }
    }

    private final RFWTraceStream b() {
        return r.f362387a.findStream("CLICK_PUSH_MSG");
    }

    private final void c() {
        long j3 = nextSessionId;
        nextSessionId = 1 + j3;
        sessionId = j3;
        firstMsgDidShow = false;
        pushMsgDidShow = false;
    }

    public final void d(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, time);
            return;
        }
        c();
        if (QLog.isDevelopLevel()) {
            QLog.d("ClickPushMsgTracer", 4, "tracePushStart: id=" + sessionId + " time=" + time);
        }
        b().reset();
        b().tagNode("PushClickStartTime", time);
    }

    public final void e(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, time);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ClickPushMsgTracer", 4, "traceFirstMsgDidShow: id=" + sessionId + " time=" + time);
        }
        if (sessionId > 0) {
            firstMsgDidShow = true;
            b().tagNode("clickPushToInsertMsgTime", time);
            a();
        }
    }

    public final void f(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, time);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ClickPushMsgTracer", 4, "tracePushMsgDidShow: id=" + sessionId + " time=" + time);
        }
        if (sessionId > 0) {
            if (!pushMsgDidReceive) {
                g(time);
            }
            pushMsgDidShow = true;
            b().tagNode("matchClickedPushMsgTime", time);
            a();
        }
    }

    public final void g(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, time);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ClickPushMsgTracer", 4, "tracePushMsgReceived: id=" + sessionId + " time=" + time);
        }
        if (sessionId > 0 && !pushMsgDidReceive) {
            pushMsgDidReceive = true;
            b().tagNode("PushMsgReceivedTime", time);
        }
    }

    public final void h(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, time);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ClickPushMsgTracer", 4, "traceWillEnterAIO: id=" + sessionId + " time=" + time);
        }
        if (sessionId > 0) {
            b().tagNode("PushWillEnterAIOTime", time);
        }
    }
}
