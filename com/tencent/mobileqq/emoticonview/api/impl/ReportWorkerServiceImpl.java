package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.ReportWorker;
import com.tencent.mobileqq.emoticonview.api.IReportWorkerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ReportWorkerServiceImpl implements IReportWorkerService {
    static IPatchRedirector $redirector_;

    public ReportWorkerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IReportWorkerService
    public Runnable createReportWorker(String str, boolean z16, IEmoticonMainPanel iEmoticonMainPanel, BaseQQAppInterface baseQQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Runnable) iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), iEmoticonMainPanel, baseQQAppInterface, Integer.valueOf(i3));
        }
        return new ReportWorker(str, z16, iEmoticonMainPanel, baseQQAppInterface, i3);
    }
}
