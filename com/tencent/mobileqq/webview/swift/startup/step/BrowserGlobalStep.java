package com.tencent.mobileqq.webview.swift.startup.step;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0005\u001a\u00020\u0003H\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/BrowserGlobalStep;", "Lcom/tencent/mobileqq/webview/swift/startup/step/BrowserStep;", "Lcom/tencent/mobileqq/webview/swift/startup/c;", "", h.F, "doStep", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class BrowserGlobalStep extends BrowserStep implements com.tencent.mobileqq.webview.swift.startup.c {
    static IPatchRedirector $redirector_;

    public BrowserGlobalStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public final int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (e()) {
            return super.doStep();
        }
        int h16 = h();
        f();
        return h16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return super.doStep();
    }
}
