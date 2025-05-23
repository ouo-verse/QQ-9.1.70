package com.tencent.core.experiment.trace;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.takedown.MethodHandler;
import rf0.a;

/* compiled from: P */
@Keep
/* loaded from: classes5.dex */
public class CoreExperimentalMethodTrace {
    static IPatchRedirector $redirector_;
    private static a traceAdapter;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7800);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sf0.a.a();
            traceAdapter = new MethodHandler();
        }
    }

    public CoreExperimentalMethodTrace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean checkExecutionMethod(String str, String str2, String str3, String str4) {
        return traceAdapter.checkExecutionMethod(str, str2, str3, str4);
    }

    public static void checkExecutionMethodThrow(String str, String str2, String str3, String str4) {
        traceAdapter.checkExecutionMethodThrow(str, str2, str3, str4);
    }

    public static void successVisitorMethod(String str, String str2, String str3, String str4) {
        traceAdapter.successVisitorMethod(str, str2, str3, str4);
    }
}
