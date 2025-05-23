package com.tencent.mobileqq.highway.kernel;

import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
class KernelCallBack extends AbstractKernelCallBack {
    static IPatchRedirector $redirector_;
    Transaction trans;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KernelCallBack(Transaction transaction, IKernelFinishCallBack iKernelFinishCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) transaction, (Object) iKernelFinishCallBack);
            return;
        }
        this.trans = transaction;
        this.f236830cb = transaction.f236840cb;
        this.finishCallBack = iKernelFinishCallBack;
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelCallBack
    HashMap<String, String> generateReportInfo() {
        return this.trans.updateAndGetReporter();
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelCallBack
    long getTransId() {
        return this.trans.kernelTransID;
    }
}
