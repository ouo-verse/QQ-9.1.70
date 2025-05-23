package com.tencent.mobileqq.ptt.temp.api.impl;

import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ptt.temp.api.IMediaPlayerManagerTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class MediaPlayerManagerTempApiImpl implements IMediaPlayerManagerTempApi {
    static IPatchRedirector $redirector_;

    public MediaPlayerManagerTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IMediaPlayerManagerTempApi
    public void mediaPlayer_doStop(boolean z16, AppRuntime appRuntime) {
        MediaPlayerManager mediaPlayerManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), appRuntime);
        } else if (appRuntime != null && (appRuntime instanceof QQAppInterface) && (mediaPlayerManager = (MediaPlayerManager) ((QQAppInterface) appRuntime).getManager(QQManagerFactory.MGR_MEDIA_PLAYER)) != null) {
            mediaPlayerManager.D(z16);
        }
    }
}
