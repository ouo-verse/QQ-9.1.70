package com.tencent.mobileqq.app.automator.example;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/automator/example/Step1;", "Lcom/tencent/mobileqq/app/automator/AsyncStep;", "Lcom/tencent/mobileqq/app/automator/b;", "", "doStep", "<init>", "()V", "QAutomator_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class Step1 extends AsyncStep<b> {
    static IPatchRedirector $redirector_;

    public Step1() {
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
        QLog.d("IAutomator", 1, "doStep(Step1)");
        return 7;
    }
}
