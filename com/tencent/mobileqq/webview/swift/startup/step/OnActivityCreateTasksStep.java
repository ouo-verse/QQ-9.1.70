package com.tencent.mobileqq.webview.swift.startup.step;

import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.util.v;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/OnActivityCreateTasksStep;", "Lcom/tencent/mobileqq/webview/swift/startup/step/BrowserStep;", "()V", "doStep", "", "webview_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public class OnActivityCreateTasksStep extends BrowserStep {
    static IPatchRedirector $redirector_;

    public OnActivityCreateTasksStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (!WebAccelerateHelper.isWebViewEntered) {
            v.b(true);
        }
        AuthorizeConfig.y().F("https://www.qq.com/", "foo.bar");
        return super.doStep();
    }
}
