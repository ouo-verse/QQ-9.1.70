package com.tencent.mobileqq.qqlive.filter.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
class QQLiveAEResDownloader$2 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            System.currentTimeMillis();
            QLog.d("QQLiveAEResDownloader", 4, "[preDownloadAllRes] start");
            throw null;
        }
    }
}
