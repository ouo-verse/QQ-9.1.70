package com.tencent.mobileqq.webview.swift.startup.step;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.startup.BrowserAutomator;
import com.tencent.mobileqq.webview.swift.startup.e;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/PreCreateEngineStep;", "Lcom/tencent/mobileqq/webview/swift/startup/step/BrowserStep;", "()V", "doStep", "", "webview_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class PreCreateEngineStep extends BrowserStep {
    static IPatchRedirector $redirector_;

    public PreCreateEngineStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        boolean b16 = e.b(e.EVENT_KERNEL_INIT_ENGINE);
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(((BrowserAutomator) this.mAutomator).getTag(), 1, "initEngineStarted:" + b16 + " appRuntimeReady:" + z16);
        if (!b16 && z16) {
            SwiftWebAccelerator.h().j();
        }
        return super.doStep();
    }
}
