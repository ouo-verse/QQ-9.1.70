package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.mobileqq.emoticon.api.IVasExtensionDownloaderService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.VasExtensionDownloader;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class VasExtensionDownloaderServiceImpl implements IVasExtensionDownloaderService {
    static IPatchRedirector $redirector_;

    public VasExtensionDownloaderServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IVasExtensionDownloaderService
    public AbsDownloader createVasExtensionDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbsDownloader) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new VasExtensionDownloader(MobileQQ.sMobileQQ);
    }
}
