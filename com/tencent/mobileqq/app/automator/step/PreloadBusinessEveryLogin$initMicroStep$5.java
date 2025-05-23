package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import mqq.app.MobileQQ;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class PreloadBusinessEveryLogin$initMicroStep$5 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    public static final PreloadBusinessEveryLogin$initMicroStep$5 INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54026);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new PreloadBusinessEveryLogin$initMicroStep$5();
        }
    }

    PreloadBusinessEveryLogin$initMicroStep$5() {
        super(0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        QLog.e("LastExitInfo", 1, com.tencent.qqperf.monitor.crash.tools.g.b(BaseApplication.getContext()));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (MobileQQ.sProcessId == 1) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.automator.step.h
                @Override // java.lang.Runnable
                public final void run() {
                    PreloadBusinessEveryLogin$initMicroStep$5.c();
                }
            }, 64, null, true);
        }
    }
}
