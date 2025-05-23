package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.mobileqq.emoticon.api.IPicEmotionDownloaderService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.PicEmotionDownloader;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class PicEmotionDownloaderServiceImpl implements IPicEmotionDownloaderService {
    static IPatchRedirector $redirector_;

    public PicEmotionDownloaderServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IPicEmotionDownloaderService
    public AbsDownloader createPicEmotionDownloader(MobileQQ mobileQQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbsDownloader) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mobileQQ);
        }
        return new PicEmotionDownloader(mobileQQ);
    }
}
