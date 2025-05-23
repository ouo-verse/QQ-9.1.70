package com.tencent.mobileqq.emoticon.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.au;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.util.List;

/* loaded from: classes12.dex */
public class FunnyPicHelperServiceImpl implements IFunnyPicHelperService {
    static IPatchRedirector $redirector_;

    public FunnyPicHelperServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService
    public void checkLoadEmotionPic(Context context, List<CustomEmotionData> list, BaseQQAppInterface baseQQAppInterface, IPicDownloadListener iPicDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            au.c(context, list, baseQQAppInterface, iPicDownloadListener);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, list, baseQQAppInterface, iPicDownloadListener);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService
    public AbsDownloader createFunnyPicDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbsDownloader) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new au.c();
    }

    @Override // com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService
    public void resolveFunnyPicJson(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInterface);
        } else {
            au.g(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService
    public void checkLoadEmotionPic(boolean z16, Context context, List<CustomEmotionData> list, AppInterface appInterface, IPicDownloadListener iPicDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            au.d(z16, context, list, appInterface, iPicDownloadListener);
        } else {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), context, list, appInterface, iPicDownloadListener);
        }
    }
}
